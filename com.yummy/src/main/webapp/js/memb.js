/**
 * 회원 정보에 관한 처리를 하는 function들임.
 * 주로 membController와 통신함.
 * 관리자 로그인 기능을 제외하면 Test용 function임.
 */

/**
 * 관리자 로그인 기능
 * @param event
 * @returns
 */
$('#submit').click( function ( event ) {
  event.preventDefault();

  let idVal = $('#id').val();
  let pwdVal = $('#pwd').val();

  //  유효성 검사
  if (idVal.length <= 0 || idVal == "") {
    alert("아이디를 입력하세요.");
    $('#id').focus();
  } else if (pwdVal.length <= 0 || pwdVal == "") {
    alert("비밀번호를 입력하세요.");
    $('#pwd').focus();
  } else {
    //  로그인 POST URL
    const url = 'memb/adminLogin';
    let form = $('#userForm').serializeArray();

    console.log( form );

    $.post( url, form ).done(( data ) => {
      if( data === 'loginError') {
        alert('ID와 비밀 번호를 확인 해 주세요.');
      }  else {
        //  로그인 성공시 data로 넘어온 URL로 이동함.
        window.location.href = document.location.href + data;
      }
    });
  }
});

/**
 * 회원 로그인 기능
 * !! TEST용 function !!
 */
function membLogin(id, pwd){
  let param = {
      "id": id,
      "pwd": pwd
  }
  console.log( param );
  $.ajax("/yummy/memb/membLogin" , {
    method: "POST",
    data: param,
    entType : "application/json; charset=UTF-8",
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

/**
 * id 확인을 위한 Function
 * @Param target  - id 확인 할 대상 id
 * @return  - 사용 가능 여부 반환
 * !! TEST용 function !!
 */
function idCheck( target ) {
  let url = 'memb/idCheck';
  let param = { id: target };

  $.post( url, param ).done( function( data ) {
    if( !data ) {
      console.log( '사용 가능' );
    } else {
      console.log( '사용 불가능' );
    }
  });
}

/**
 * 회원 가입을 위한 Function
 * 
 * 예외 처리를 다시 해야함.
 * !! TEST용 function !!
 */
function signUp( id, pwd, nick ) {
  let url = 'memb/signUp';
  let param = {
      id : id,
      pwd: pwd,
      nick: nick
  }

  console.log( param );
  try{
    $.post( url, param ).done( function( data ) {
      console.log( data );
      if (data === 'success' ) {
        alert('회원 가입 성공');
      }
    });
  } catch( err ) {
    console.log( err );
    alert('회원 가입 실패\n관리자에게 문의하세요');
  }
}

/**
 * 회원 탈퇴를 위한 Function
 * 
 * 예외 처리, detail한 처리 다시 해야함.
 * !! TEST용 function !!
 */
function signOut( param ) {
  let url = 'memb/signOut';
  let id = { id : param };

  console.log( param );

  $.post( url, id ).done();
}