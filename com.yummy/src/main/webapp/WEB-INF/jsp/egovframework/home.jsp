<%@ page    contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page    session="false"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%--
   /**
    * @Class Name : home.jsp
    * @Description : home 화면
    * @Modification Information
    *
    *   수정일         수정자                   수정내용
    *  -------    --------    ---------------------------
    *  2019.03.03            최초 생성
    *
    * author JeahaOh
    * since 2019.03.03
    *
    * Copyright (C) 2019 by JeahaOh  All right reserved.
    */
--%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>LogIn</title>
  <style>
    .main {
      text-align: center;
    }
    .login {
      display: inline-block;
    }
    form {
      margin: 0 auto;
      padding: 1em;
      border: 1px solid #CCC;
      border-radius: 1em;
    }
    form div+div {
      margin-top: 1em;
    }
    label {
      display: inline-block;
      width: 90px;
      text-align: center;
    }
    input {
      font: 1em sans-serif;
      width: 150px;
    }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body>
    <div class="main">
        <div class="login">
            <h1>관리자 페이지</h1>
            <form action="#" method="post" id="userForm" class="login">
                <div>
                    <label for="id">ID</label>
                    <input type="text" id="id" name="id" value="ID" alt="ID">
                </div>
                <div>
                    <label for="pwd">PWD</label>
                    <input type="password" id="pwd" name="pwd" alt="password">
                </div>
                <div>
                    <button type="reset" id="reset">취소</button>
                    <button type="button" id="submit">로그인</button>
                </div>
            </form>

            <p>The time on the server is ${serverTime}.</p>
        </div>
    </div>
</body>
<script>
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
  
</script>
</html>