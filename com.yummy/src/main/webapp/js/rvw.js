//min (포함) 과 max (포함) 사이의 임의 정수를 반환
//Math.round() 를 사용하면 고르지 않은 분포를 얻게된다!
function getRandomIntInclusive(min, max) {
	return Math.round(Math.random() * (max - min + 1)) + min;
}

//setTimeout()은 지연시간을 발생시킨 후 특정 함수를 호출
/*
var showAlert = setTimeout(function() {
    clearInterval(getRandomNo);
    alert('Wow!!!');
}, 10000);
 */

//setInterval(){} 일정 시간마다 반복 실행하는 함수.
//setInterval(function() { ... }, 지연시간);
/*
getRandomNo = setInterval(function() {
    let r = getRandomIntInclusive(1, 10);
    console.log(r);   
}, 500);
 */

//타이머 중지.
//clearInterval(getRandomNo);



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

function signUp( id, pwd, nick ) {
	let url = '/yummy/memb/signUp';
	let param = {
			id : id,
			pwd: pwd,
			nick: nick
	}

	try{
		$.post( url, param ).done( function( data ) {
			console.log( data );
		});
	} catch( err ) {
	}
}


var cnt = 0;
function callbackInsert( cycle ) {
	if( cnt < cycle ){
		setTimeout(function(){
			cnt++;
			let id = 'TestUser9-' + cnt;
			let nick = 'TestUser9-' + cnt; 
			let pwd = 1111;

			signUp( id, pwd, nick );

			for (let j = 0; j <= 100; j++) {
				setTimeout( function() {
					let cont = cnt + '\n' + id + '의 Review Test - ' + j + '임';
					saveRvw( id, cont );
				}, 500);
			}
			callbackInsert( cycle );

		}, 1000);
	}
}