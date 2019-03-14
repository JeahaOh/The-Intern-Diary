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
/*

//  min (포함) 과 max (포함) 사이의 임의 정수를 반환하는 함수.
function getRandomIntInclusive(min, max) {
  return Math.round(Math.random() * (max - min + 1)) + min;
  //  Math.round() 고르지 않은 분포의 난수를 생성한다.
}

//  setTimeout()은 지연시간을 발생시킨 후 특정 함수를 호출함.

var showAlert = setTimeout(function() {
    clearInterval(getRandomNo);
    alert('Wow!!!');
}, 10000);

 */
function getRandomIntInclusive(min, max) {
  return Math.round(Math.random() * (max - min + 1)) + min;
}

function saveRvw( id, cont/*rst_no, id, cont, score*/ ){
//  let rvw_no;
//  let rst_no = $('#rst_no').val();
  let rst_no = getRandomIntInclusive(1, 187);
//  let id = $('#userId').val();
//  let id = 'asdf1020'
//  let cont;
//  let cont = 'Review Test임'
//  let score;
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

//  rst에 대한 rvw list를 가져옴
function getRvwInfo(){
  console.log('getRvwInfo');

  $.ajax("/yummy/rvw/getRvwInfo" , {
    method: "POST",
    data:{
      rst_no: $('#rst_no').val()
    },
    dataType: "json",
    success: function ( data ) {
      console.log( data );
      console.log( Object.keys( data ).length );
      if ( data.rate === null || Object.keys( data.rate ).length <= 2 ) {
        console.log('data.rate == null or <= 1');
        $('#rate').hide();
        return;
      }  else {
        $('#score_best').html(data.rate.best);
        $('#score_good').html(data.rate.good);
        $('#score_soso').html(data.rate.soso);
        $('#score_bad').html(data.rate.bad);
        $('#score_worst').html(data.rate.worst);
        $('#score_cnt').text(data.rate.cnt);
        $('#score_grade').text(data.rate.grade);
        console.log('score');
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
        console.log('rvwList append');
        $('#rvw').append(html);
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
  console.log('{ rvw_no: ' + rvw_no + ' }');
  $.ajax("/yummy/rvw/getRvwDtl" , {
    method: "POST",
    data:{
      rvw_no: rvw_no
    },
    dataType: "json",
    success: function ( data ) {
      console.log( data );
      $('#rvw_no').val(data.rvw_no);
      $('#id').val(data.id);
      $('#score').val(data.score);
      $('#cont').val(data.cont);
      $('#cdt').val(data.cdt);
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
    console.log('수정 불가능한 상태입니다.');
    return
  }

  $.ajax("/yummy/rvw/delete" , {
    method: "POST",
    data:{
      "rvw_no": $('#rvw_no').val()
    },
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

function getRate(){
  $.ajax("/yummy/rater/getRate" , {
    method: "POST",
    data: {
      rst_no : $('#rst_no').val()
    },
    dataType: "json",
    success: function ( data ) {
      console.log( data );
      /*console.log( Object.keys( data ).length );
      if ( data === null || Object.keys( data.rvwList ).length <= 2 ) {
        console.log('data == null or <= 1');
        $('#rvwTable').hide();
        return;
      }
      let html;
      for ( i = 0; i < data.rvwList.length; i++ ) {
        html += '<tr class="rvw" onclick="rvw_manage(' + data.rvwList[i].rvw_no + ')">';
        html += '<td class="tbtd_content  rvw_no">' + data.rvwList[i].rvw_no +'</td>';
        html += '<td class="tbtd_content  rvw_id">' + data.rvwList[i].id +'</td>';
        html += '<td class="tbtd_content  rvw_score">' + data.rvwList[i].score+'</td>';
        html += '<td class="tbtd_content  vrw_cdt">'+ data.rvwList[i].cdt +'</td>';
        html += '</tr>';
      }
      console.log('append');
      $('#rvw').append(html);*/
    },
    error: function(xhr, status, msg) {
      console.log('xhr:\n ' + xhr);
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
    }
  });
}

//  화면이 로드되고, mode가 modify일 경우 rvw info를 가져오도록 함.
$(document).ready(function() {
  if( $('#mode').hasClass('modify') ) {
    getRvwInfo();
  }
});