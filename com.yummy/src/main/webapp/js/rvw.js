/**
 * rstDetail.jsp에서 rvw를 관리 하기 위한 js function 모음.
 */

/**
 * form의 input 값을 JSON형태로 바꾸는 function.
 */
$.fn.serializeObject = function() {
  var result = {}
  var extend = function(i, element) {
    var node = result[element.name]
    if ("undefined" !== typeof node && node !== null) {
      if ($.isArray(node)) {
        node.push(element.value)
      } else {
        result[element.name] = [node, element.value]
      }
    } else {
      result[element.name] = element.value
    }
  }
  $.each(this.serializeArray(), extend)
  return result
}

function getRandomIntInclusive(min, max) {
  return Math.round(Math.random() * (max - min + 1)) + min;
}

function saveRvw( id, cont/*rst_no, id, cont, score*/ ){
  let rst_no = getRandomIntInclusive(1, 187);
  let score = getRandomIntInclusive(1, 2);
  param = JSON.stringify({
    rst_no: rst_no,
    id: id,
    cont: cont,
    score: score
  });
  console.log( param );

  setTimeout(function(){
    $.ajax("/yummy/rvw/save" , {
      method: "POST",
      data: param,
      contentType : "application/json; charset=UTF-8",
      dataType: "json",
      success: function ( data ) {
        console.log( data );
      },
      error: function(xhr, status, msg) {
        console.debug('xhr:\n ' + xhr);
        console.debug('status:\n ' + status);
        console.debug('msg:\n ' + msg);
      }
    });
  }, 500);
}

//  rst에 대한 rvw rating 정보와 rvw List를 가져와서 출력
function getRvwInfo(){
  console.log('getRvwInfo');

  $.ajax("/yummy/rvw/getRvwInfo" , {
    method: "POST",
    data:{
      rst_no: $('#rst_no').val()
    },
    dataType: "json",
    success: function ( data ) {
      console.log( "recieve : " + data );
      if ( data.rate === null || Object.keys( data.rate ).length <= 2 ) {
        console.log('data.rate == null or <= 1');
        $('#rate').hide();
        return;
      }  else {
        console.log( data.rate );
        $('#score_best').html(data.rate.best);
        $('#score_good').html(data.rate.good);
        $('#score_soso').html(data.rate.soso);
        $('#score_bad').html(data.rate.bad);
        $('#score_worst').html(data.rate.worst);
        $('#score_cnt').text(data.rate.cnt);
        $('#score_avg').text(data.rate.avg);
        $('#score_grade').text(data.rate.grade);
        console.log('score appended');
      }
      
      if ( data.rvwList === null || Object.keys( data.rvwList ).length < 1 ) {
        console.log('data.rvwList == null or <= 1');
        $('#rvwTable').hide();
        return;
      }  else {
        let html;
        for ( i = 0; i < data.rvwList.length; i++ ) {
          html += '<tr class="rvw" onclick="rvw_manage(' + data.rvwList[i].rvw_no + ')">';
          html += '<td class="tbtd_content  rvw_no">' + data.rvwList[i].rvw_no +'</td>';
          html += '<td class="tbtd_content  rvw_id">' + data.rvwList[i].id +'</td>';
          html += '<td class="tbtd_content  rvw_score">' + data.rvwList[i].score+'</td>';
          html += '<td class="tbtd_content  vrw_cdt">'+ data.rvwList[i].cdt +'</td>';
          html += '</tr>';
        }
        $('#rvw').append(html);
        console.log('rvwList appended');
      }
    },
    error: function(xhr, status, msg) {
      console.log('xhr:\n ' + xhr);
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
    }
  });
}

//  rvw의 detail 정보 가져오기
function getRvwDtl( rvw_no ) {
  param = {"rvw_no": rvw_no };
  console.log(param);
  
  $.ajax("/yummy/rvw/getRvwDtl" , {
    method: "POST",
    data: param,
    dataType: "json",
    success: function ( data ) {
      console.log( data );
      $('#rvw_no').val(data.rvw_no);
      $('#id').val(data.id);
      $('#score').val(data.score);
      $('#cont').val(data.cont);
      $('#cdt').val(data.cdt);
      if( data.rvw_phot != null ) {
        $('#rvw_phot').attr( 'src', "/yummy/resources/images/rvw/" + data.rvw_phot );
      } else {
        $('#rvw_phot').attr( 'src', "/yummy/resources/images/rvw/DEFAULT" );
      }
      $('#rvw_phot').hide();
      $('#rvw_phot').fadeIn(650);
      
      
      
    },
    error: function(xhr, status, msg) {
      console.log('xhr:\n ' + xhr);
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
    }
  });
}

//  rvw를 삭제하는 function
function deleteRvw(  ) {
  if( $('#cont').attr('readOnly') ){
    alert('수정 불가능한 상태입니다.');
    return;
  }
  
  param = {"rvw_no": $('#rvw_no').val() };
  
  $.ajax("/yummy/rvw/delete" , {
    method: "POST",
    data: param,
    dataType: "json",
    success: function ( data ) {
      console.log(data);
      if( data === "success" ) {
        alert( '게시번호' + $('#rvw_no').val() + '를 삭제하였습니다.' );
        window.location.href = document.location.href;
      }  else {
        alert( '게시번호' + $('#rvw_no').val() + '의 삭제를 실패 하였습니다.\n새로고침 후 다시 시도 해주세요' );
      }
    },
    error: function(xhr, status, msg) {
      alert( '게시번호' + $('#rvw_no').val() + '의 삭제를 실패 하였습니다.\n새로고침 후 다시 시도 해주세요' );
      console.log('xhr:\n ' + xhr);
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
    }
  });
}

//  table의 rvw 클릭시 rvw의 detail을 가져옴.
function rvw_manage( rvw_no ) {
  getRvwDtl( rvw_no );
  openModal();
}


//rvw 수정 클릭 시
function rvw_edit(){
  if( $('#cont').attr('readOnly') ){
    $('#cont').removeAttr('readOnly');
  }  else {
    $('#cont').attr('readOnly', 'readonly');
  }
}

//  rvw 수정을 위한 function
function rvw_update(){
  if( $('#cont').attr('readOnly') ){
    console.log('수정 불가능한 상태입니다.');
    return
  }
  param = JSON.stringify({
    "rvw_no": $('#rvw_no').val(),
    "rst_no": $('#rst_no').val(),
    "cont": $('#cont').val(),
    "score": $('#score').val()
  });

  console.log(param);

  $.ajax("/yummy/rvw/update" , {
    method: "POST",
    data: param,
    contentType : "application/json; charset=UTF-8",
    dataType: "json",
    success: function ( data ) {
      console.log( data );
      if( data === "success" ) {
        alert( '게시번호' + $('#rvw_no').val() + '를 수정하였습니다.' );
        window.location.href = document.location.href;
      }  else {
        alert( '게시번호' + $('#rvw_no').val() + '의 수정을 실패 하였습니다.\n새로고침 후 다시 시도 해주세요' );
      }
    },
    error: function(xhr, status, msg) {
      console.debug('xhr:\n ' + xhr);
      console.debug('status:\n ' + status);
      console.debug('msg:\n ' + msg);
    }
  });
}

//  화면이 로드되고, mode가 modify일 경우 rvw info를 가져오도록 함.
$(document).ready(function() {
  if( $('#mode').hasClass('modify') ) {
    getRvwInfo();
  }
});