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
    "rst_no": rst_no,
    "id": id,
    "cont": cont,
    "score": score
  })
  
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


function getRvwList(){
  let rst_no = JSON.stringify($('#rst_no').val());

  $.ajax("/yummy/rvw/getRvwList" , {
    method: "POST",
    data:{
      "rst_no": $('#rst_no').val()
    },
    dataType: "json",
    success: function ( data ) {
      /*console.log( data );*/
      if ( data === null || data.length < 0 ) {
        return;
      }
      let html;
      for ( i = 0; i < data.length; i++ ) {
        html += '<tr onclick="rvw_manage(' + data[i].rvw_no + ')">';
        html += '<td class="tbtd_caption rvw_no">' + data[i].rvw_no +'</td>';
        html += '<td class="tbtd_caption rvw_id">' + data[i].id +'</td>';
        html += '<td class="tbtd_caption rvw_score">' + data[i].score+'</td>';
        html += '<td class="tbtd_caption vrw_cdt">'+ data[i].cdt +'</td>';
        html += '</tr>';
      }
      $('#rvw').append(html);
    },
    error: function(xhr, status, msg) {
      console.log('xhr:\n ' + xhr);
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
    }
  });
}

function getRvwInfo(){
  console.log('getRvwInfo');
  let rst_no = JSON.stringify($('#rst_no').val());

  $.ajax("/yummy/rvw/getRvwInfo" , {
    method: "POST",
    data:{
      "rst_no": $('#rst_no').val()
    },
    dataType: "json",
    success: function ( data ) {
      console.log( data );
      console.log( Object.keys( data ).length );
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
      $('#rvw').append(html);
    },
    error: function(xhr, status, msg) {
      console.log('xhr:\n ' + xhr);
      console.log('status:\n ' + status);
      console.log('msg:\n ' + msg);
    }
  });
}

function getRvwDtl( rvw_no ) {
  $.ajax("/yummy/rvw/getRvwDtl" , {
    method: "POST",
    data:{
      "rvw_no": rvw_no
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
      }	else {
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



function rvw_manage(rvw_no) {
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
          }	else {
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


$(document).ready(function() {
  getRvwInfo();
});