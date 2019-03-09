
 // 로그인 기능
  $('#submit').click( function ( event ) {
    event.preventDefault();
    
    let idVal = $('#id').val();
    let pwdVal = $('#pwd').val();
    
    if (idVal.length <= 0 || idVal == "") {
      alert("아이디를 입력하세요.");
      $('#id').focus();
    } else if (pwdVal.length <= 0 || pwdVal == "") {
      alert("비밀번호를 입력하세요.");
      $('#pwd').focus();
    } else {
      const url = 'memb/adminLogin';
      let form = $('#userForm').serializeArray();
      
      console.log( form );
      
      $.post( url, form ).done(function( data ) {
        if( data === 'loginError') {
          alert('ID와 비밀 번호를 확인 해 주세요.')
        }  else {
          window.location.href = document.location.href + data;
        }
      });
    }
  });

  /**
   * id 확인을 위한 Function
   * @Param target  - id 확인 할 대상 id
   * @return  - 사용 가능 여부 반환
   * 
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
   */
  function signOut( param ) {
    let url = 'memb/signOut';
    let id = { id : param };
    
    console.log( param );
    
    $.post( url, id ).done();
  }