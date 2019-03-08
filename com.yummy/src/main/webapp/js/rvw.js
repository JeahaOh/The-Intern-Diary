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
//	let rvw_no;
//	let rst_no = $('#rst_no').val();
	let rst_no = getRandomIntInclusive(1, 187);
//	let id = $('#userId').val();
//	let id = 'asdf1020'
//	let cont;
//	let cont = 'Review Test임'
//	let score;
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
	console.log('rst_no : ' + rst_no);
	
	$.ajax("/yummy/rvw/getRvwList" , {
	    method: "POST",
	    data:{
	      "rst_no": $('#rst_no').val()
	    },
	    dataType: "json",
	    success: function ( data ) {
	      console.log( data );
	    },
	    error: function(xhr, status, msg) {
	      console.log('xhr:\n ' + xhr);
	      console.log('status:\n ' + status);
	      console.log('msg:\n ' + msg);
	    }
	  });
}

$(document).ready(function() {
	getRvwList();
});