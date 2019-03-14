//  min (포함) 과 max (포함) 사이의 임의 정수를 반환하는 함수.
function getRandomIntInclusive(min, max) {
  return Math.round(Math.random() * (max - min + 1)) + min;
  //  Math.round() 고르지 않은 분포의 난수를 생성한다.
}

//  setTimeout()은 지연시간을 발생시킨 후 특정 함수를 호출함.
/*
var showAlert = setTimeout(function() {
    clearInterval(getRandomNo);
    alert('Wow!!!');
}, 10000);
*/

//  rvw 테이블에 AJAX로 id, cont 값을 입력 시키는 함수.
function saveRvw( id, cont ){
  //  1 ~ 187사이의 난수를 발생 시켜서 rst_no값으로 준다.
  let rst_no = getRandomIntInclusive(1, 188);
  //  1 ~ 3 사이의 난수를 발생 시켜서 score값으로 준다.
  let score = getRandomIntInclusive(4, 5);
  param = JSON.stringify({
    "rst_no": rst_no,
    "id": id,
    "cont": cont,
    "score": score
  })
  
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
      let id = 'TestUser20-' + cnt;
      let nick = 'TestUser20-' + cnt; 
      let pwd = 1111;

      signUp( id, pwd, nick );

      for (let j = 0; j <= 30; j++) {
        setTimeout( function() {
          let cont = '\n' + id + '의 Review Test - ' + j + '임';
          saveRvw( id, cont );
        }, 250);
      }
      callbackInsert( cycle );
    }, 250);
  }
}