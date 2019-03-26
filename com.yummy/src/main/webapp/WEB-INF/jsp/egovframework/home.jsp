<%@ page    language="java"  contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ page    session="true"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%--
   /**
  * @Class Name : home.jsp
  * @Description : home 화면
  * @Modification Information
  *
  *   수정일     수정자           수정내용
  *  -------  --------  ---------------------------
  *  2019.03.03      최초 생성
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
    <title><spring:message code="title.index"/></title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/home.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/common.css'/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  </head>
  <body>
    <!-- ==== HEADER ==== -->
      <jsp:include page="/WEB-INF/jsp/egovframework/include/HEADER.jsp" flush="true"/>
    <!-- ==== HEADER ==== -->
    <div class="main">
      <div class="login">
        <h1><spring:message code="title.index"/></h1>
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
  <script src="<c:url value='/js/memb.js'/>"></script>
</html>