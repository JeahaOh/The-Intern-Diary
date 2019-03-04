<%@ page
  language="java"
  contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@ taglib
  uri="http://java.sun.com/jsp/jstl/core"
  prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="kor">

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
    
    var idVal = $('#id').val();
    var pwdVal = $('#pwd').val();
    
    if (idVal.length <= 0 || idVal == "") {
      alert("아이디를 입력하세요.");
      $('#id').focus();
    } else if (pwdVal.length <= 0 || pwdVal == "") {
      alert("비밀번호를 입력하세요.");
      $('#pwd').focus();
    } else {
      var url = 'memb/adminLogin';
      var data = $('#userForm').serialize();
      
      $.post( url, data ).done(function( data ) {
        
        /* console.log(document.location.href + data); */
        window.location.href = document.location.href + data;
      });
    }
    
  });
</script>
</html>