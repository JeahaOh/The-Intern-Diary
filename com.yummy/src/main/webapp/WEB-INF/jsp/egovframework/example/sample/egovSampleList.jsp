<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<%
  /**
			* @Class Name : egovSampleList.jsp
			* @Description : Sample List 화면
			* @Modification Information
			*
			*   수정일         수정자                   수정내용
			*  -------    --------    ---------------------------
			*  2009.02.01            최초 생성
			*
			* author 실행환경 개발팀
			* since 2009.02.01
			*
			* Copyright (C) 2009 by MOPAS  All right reserved.
			*/
%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<title><spring:message code="title.sample" /></title>
<%--
CSS 경로 잡기는 나중에 하기로... c:url을 걸든 그냥 href를 쓰던 경로에 대한 공부를 좀 해야 할 듯.
<link type="text/css" rel="stylesheet" href="<c:url value='css/egovframework/sample.css'/>" />
??
<%=request.getContextPath() %>
??
--%>
<style>
* {margin:0;padding:0;}
* html {height:1px;}
body {margin:0; padding:0; font-family:"굴림"; font-size:12px; color:#666; scroll:auto;}
table, tr, td, th {font-family:"돋움"; font-size:11px; color:#333333;}
.listtd {padding:10px 5px 8px 5px; border-bottom:1px solid #e5e5e5;}
th {background-color:#F3F5E0; background:url(../../images/egovframework/example/th_bg.gif) 0 0 repeat; height:26px; text-align:center; vertical-align:middle; color:#003366;}
img {border:0; vertical-align:middle;}
p { height:20px; margin:0; padding:5 0 0 0;}
.check ul {margin:0; padding:0; float:left;}
.check li {list-style-type:none; float:left; margin:0 0 0 0; padding:0 0 0 3px;}
.top {vertical-align:top;}

a:link { font-size:11px; font-family:"돋움"; color:#3A5870; text-decoration:none; line-height:100%;}
a:visited { font-size:11px; font-family:"돋움"; color:#3A5870; text-decoration:none}
a:active { font-size:11px; font-family:"돋움"; color:#339999; text-decoration:none;}
a:hover { font-size:11px; font-family:"돋움"; color:#339999; text-decoration:none;}

.login {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:52px 0px 0px 270px; /*overflow:hidden;*/ width:330px; height:260px;background:url(../../images/egovframework/example/login_bg.jpg) 0 0 no-repeat; }
.login_en {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:52px 0px 0px 270px; /*overflow:hidden;*/ width:330px; height:260px;background:url(../../images/egovframework/example/login_bg_en.jpg) 0 0 no-repeat; }
.error {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:120px 0px 0px 80px; /*overflow:hidden;*/ width:520px; height:260px;background:url(../../images/egovframework/example/error_bg.jpg) 0 0 no-repeat; }
.error_en {position:relative; margin:0; padding:0 0 0 0px; text-align:left; vertical-align:top; padding:120px 0px 0px 80px; /*overflow:hidden;*/ width:520px; height:260px;background:url(../../images/egovframework/example/error_bg_en.jpg) 0 0 no-repeat; }
#logo {margin:0; padding:0; text-align:left; /*overflow:hidden;*/ width:910px;}
#header {height:74px; background:url(../../images/egovframework/example/civilappeal_topmn_bg.jpg) repeat-x;}
#top {width:910px;}
.menu { text-align:center; height:38px; margin:0; padding:13px 0 0 0;}
.menu ul {display:inline; width:910px;}
.menu li {display:inline; list-style-type:none; margin:0; padding:14px 28px 0 28px; background:url(../../images/egovframework/example/civilappeal_topmn_bar.jpg) 0 15px no-repeat;}
.menu li.last {width:1px; padding:15px 0 0 0; background:url(../../images/egovframework/example/civilappeal_topmn_bar.jpg) 0 0 no-repeat;}
.menu a.top:link {font-family:"굴림"; font-weight:bold; color:#FFFFFF; text-decoration:none; font-size:12px;}
.menu a.top:visited {font-family:"굴림"; font-weight:bold; color:#FFFFFF; text-decoration:none; font-size:12px;}
.menu a.top:hover {font-family:"굴림"; font-weight:bold; color: #00CCFF; text-decoration:none; font-size:12px;} 
.menu a.top:active {font-family:"굴림"; font-weight:bold; color:#FFFFFF; text-decoration:none; font-size:12px;} 

.menu .on a.top:link {font-family:"굴림"; font-weight:bold; color:#00CCFF; text-decoration:none; font-size:12px;}
.menu .on a.top:visited {font-family:"굴림"; font-weight:bold; color:#00CCFF; text-decoration:none; font-size:12px;}
.menu .on a.top:hover {font-family:"굴림"; font-weight:bold; color: #00CCFF; text-decoration:none; font-size:12px;} 
.menu .on a.top:active {font-family:"굴림"; font-weight:bold; color:#00CCFF; text-decoration:none; font-size:12px;} 
    
.right_area {float:right; height:38px; margin:0; padding:0 8px 0 0; background:url(../../images/egovframework/example/civilappeal_topmn_bg11.jpg) right no-repeat;}
#sub {float:left; padding:10px 10px 10px 10px; /*overflow:hidden;*/width:180px; margin-right:30px;}
#sub .login {width:180px; height:70px; text-align:left; vertical-align:top; padding:5px 0 0 0; background:url(../../images/egovframework/example/civilappeal_login_bg.jpg) right no-repeat; margin-bottom:10px;}
#sub .login_en {width:180px; height:70px; text-align:left; vertical-align:top; padding:5px 0 0 0; background:url(../../images/egovframework/example/civilappeal_login_bg_en.jpg) right no-repeat; margin-bottom:10px;}
#sub .sub_menu {width:150px; height:300px; text-align:left; vertical-align:top; background:url(../../images/egovframework/example/civilappeal_leftmenu_bg.jpg) 0 0 no-repeat; padding-top:40px; padding-left:15px; padding-right:15px; padding-bottom:0px;}
#sub .sub_menu dl {width:150px;}
#sub .sub_menu dd {font-weight:bold; padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:10px; margin:0;}
#sub .sub_menu dt {list-style:none;  padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:8px; margin:0px;}
#sub .sub_menu_en {width:150px; height:300px; text-align:left; vertical-align:top; background:url(../../images/egovframework/example/civilappeal_leftmenu_bg_en.jpg) 0 0 no-repeat; padding-top:40px; padding-left:15px; padding-right:15px; padding-bottom:0px;}
#sub .sub_menu_en dl {width:150px;}
#sub .sub_menu_en dd {font-weight:bold; padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:10px; margin:0;}
#sub .sub_menu_en dt {list-style:none;  padding-left:0px; padding-right:0px; padding-bottom:0px; padding-top:8px; margin:0px;}
#content {float:left; text-align:left; /*overflow:hidden;*/width:680px; background-color:#FFFFFF; padding:10px 0px 10px 0px;}
#content_pop {float:left; text-align:left; /*overflow:hidden;*/width:680px; background-color:#FFFFFF; padding:10px 10px 10px 10px;}
#title {float:left; text-align:left; margin:0 0 10 0; padding:0; height:30px; border-bottom:1px solid #e5e5e5; width:680px;}
#title ul {float:left; margin:0; padding:0;}
#title li {list-style-type:none; width:200px; padding:3px 0px 2px 0px; float:left; font-family:"돋움"; font-size:16px; font-weight:bold; color:#000000;}
#title .location {float:right; height:20px; margin:0; padding:5 0 0 0; font-family:"돋움"; font-size:11px;}
#foot {margin:0; padding:0 0 0 0; text-align:left; /*overflow:hidden;*/ height:40px; clear:both; background-color:#F7F7F7; border-top:1px solid #e5e5e5; font-family:Tahoma; font-size:11px; color:#999999;}
#search {float:right; margin:0; padding:10px 0 10px 0; width:680px;}
#search ul {margin:0; float:right;}
#search li {list-style-type:none; float:left; margin:0 0 0 0; padding:0 0 0 3px;}
#table {float:left; margin:0 0 10px 0; padding:0 0 0 0; width:680px;}
#paging {padding:0 0 0 0; text-align:center; width:680px;}
#paging ul {display:inline;}
#paging li {display:inline; list-style-type:none; padding:0 10px 0 10px; font-family: Tahoma; font-size:11px; color: #333333;}
#paging li.pre10 {padding:0 2px 0 2px;}
#paging li.pre1 {padding:0 2px 0 2px;}
#paging li.next10 {padding:0 2px 0 2px;}
#paging li.next1 {padding:0 2px 0 2px;}
#paging li.line {background:url(../../images/egovframework/example/paging_line.gif) 0 2px no-repeat;}
#paging li.first {padding:0 5px 0 0;}
#paging li.last {background:url(../../images/egovframework/example/paging_line.gif) 0 2px no-repeat; padding:0 5px 0 0;}
#sysbtn {float:right; text-align:right; padding:0; margin:0; display:inline;}
#sysbtn ul {margin:0; padding:0; float:left; display:inline;}
#sysbtn li {list-style-type:none; margin:0 auto; padding:0 0 0 3px; float:left; display:inline;}

#sysbtn1 {text-align:left; padding-top:10px; padding-bottom:0px; margin-bottom:0px; width:680px;}
#sysbtn1 ul {margin:0; padding:0; float:left; display:inline;}
#sysbtn1 li {list-style-type:none; margin:0 0 0 0; padding:0 0 0 3px; float:left; display:inline;}
#idwrap {float:left; padding-top:0px; padding-bottom:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; margin-top:0px; padding-left:0px; padding-right:0px; }
#idwrap ul {float:left; padding:0; margin:0;}
#idwrap li {list-style-type:none; float:left; margin:0; padding-right:3px;}
button {cursor:hand; border:0px solid #FFFFFF; padding:0px 0px 0px 0px; background-color:#FFFFFF; white-space:nowrap;}
.btn_blue_l {float:left; background:url(../../images/egovframework/example/btn_bg_l.gif) 0 0 no-repeat; height:20px; padding:0px 0px 0px 10px; margin:0px 0px 0px 0px;}
.btn_blue_r {float:left; background:url(../../images/egovframework/example/btn_bg_r.gif) 0 0 no-repeat; background-position:right; height:20px; font-family:"돋움"; font-size:11px; color:#000000; margin:0px 0px 0px 0px; padding-top:0px; _padding-top:0px; padding-left:10px; padding-right:10px; padding-bottom:0px; text-align:center;}
input { height:20px; font-family:"돋움"; font-size:12px; color:#000000; padding:2px 2px 0px 2px; margin-top:0px; _margin-top:-1px;}
select {font-family:'돋움'; font-size:12px; margin-top:0px; height:20px; padding-top:0px;}
.tbtd_caption {font-weight:bold; color:#003366; background-color:#E5EDF3; text-align:right; padding:10px 10px 9px 5px; margin:0;}
.tbtd_content {background-color:#F5F8FA; padding:7px 10px 5px 10px; margin:0;}
.tbtd_caption_re {font-weight:bold; color:#666633; background-color:#F6F5E5; text-align:right; padding:10px 10px 9px 5px; margin:0;}
.tbtd_content_re {background-color:#F9F9F2; padding:7px 10px 5px 10px; margin:0;}
input.txt               {height:18px; background-color:#FFF; border:1px solid #BCC8D8; padding-top:2px; color:#5e5e5e; cursor:text;}
input.essentiality  {height:18px; background-color:#ebebeb; border:1px solid #BCC8D8; padding-top:2px; color:#000; cursor:text;}
</style>
<script defer type="text/javaScript">
	/* 글 수정 화면 function */
	function fn_egov_select(id) {
		document.listForm.selectedId.value = id;
		document.listForm.action = "<c:url value='/updateSampleView.do'/>";
		document.listForm.submit();
	}

	/* 글 등록 화면 function */
	function fn_egov_addView() {
		document.listForm.action = "<c:url value='/addSample.do'/>";
		document.listForm.submit();
	}

	/* 글 목록 화면 function */
	function fn_egov_selectList() {
		document.listForm.action = "<c:url value='/egovSampleList.do'/>";
		document.listForm.submit();
	}

	/* pagination 페이지 링크 function */
	function fn_egov_link_page(pageNo) {
		document.listForm.pageIndex.value = pageNo;
		document.listForm.action = "<c:url value='/egovSampleList.do'/>";
		document.listForm.submit();
	}
</script>
</head>

<body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
  <form:form
    commandName="searchVO"
    id="listForm"
    name="listForm"
    method="post">
    <input
      type="hidden"
      name="selectedId" />
    <div id="content_pop">
      <!-- 타이틀 -->
      <div id="title">
        <ul>
          <li><img
            src="<c:url value='/images/egovframework/example/title_dot.gif'/>"
            alt="" />
          <spring:message code="list.sample" /></li>
        </ul>
      </div>
      <!-- // 타이틀 -->
      <div id="search">
        <ul>
          <li><label
            for="searchCondition"
            style="visibility: hidden;"><spring:message code="search.choose" /></label> <form:select
              path="searchCondition"
              cssClass="use">
              <form:option
                value="1"
                label="Name" />
              <form:option
                value="0"
                label="ID" />
            </form:select></li>
          <li><label
            for="searchKeyword"
            style="visibility: hidden; display: none;"><spring:message code="search.keyword" /></label>
            <form:input
              path="searchKeyword"
              cssClass="txt" /></li>
          <li><span class="btn_blue_l"> <a href="javascript:fn_egov_selectList();"><spring:message
                  code="button.search" /></a> <img
              src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
              style="margin-left: 6px;"
              alt="" />
          </span></li>
        </ul>
      </div>
      <!-- List -->
      <div id="table">
        <table
          width="100%"
          border="0"
          cellpadding="0"
          cellspacing="0"
          summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
          <caption style="visibility: hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는
            테이블</caption>
          <colgroup>
            <col width="40" />
            <col width="100" />
            <col width="150" />
            <col width="80" />
            <col width="?" />
            <col width="60" />
          </colgroup>
          <tr>
            <th align="center">No</th>
            <th align="center"><spring:message code="title.sample.id" /></th>
            <th align="center"><spring:message code="title.sample.name" /></th>
            <th align="center"><spring:message code="title.sample.useYn" /></th>
            <th align="center"><spring:message code="title.sample.description" /></th>
            <th align="center"><spring:message code="title.sample.regUser" /></th>
          </tr>
          <c:forEach
            var="result"
            items="${resultList}"
            varStatus="status">
            <tr>
              <td
                align="center"
                class="listtd"><c:out
                  value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}" /></td>
              <td
                align="center"
                class="listtd"><a
                href="javascript:fn_egov_select('<c:out value="${result.id}"/>')"><c:out
                    value="${result.id}" /></a></td>
              <td
                align="left"
                class="listtd"><c:out value="${result.name}" />&nbsp;</td>
              <td
                align="center"
                class="listtd"><c:out value="${result.useYn}" />&nbsp;</td>
              <td
                align="center"
                class="listtd"><c:out value="${result.description}" />&nbsp;</td>
              <td
                align="center"
                class="listtd"><c:out value="${result.regUser}" />&nbsp;</td>
            </tr>
          </c:forEach>
        </table>
      </div>
      <!-- /List -->
      <div id="paging">
        <ui:pagination
          paginationInfo="${paginationInfo}"
          type="image"
          jsFunction="fn_egov_link_page" />
        <form:hidden path="pageIndex" />
      </div>
      <div id="sysbtn">
        <ul>
          <li><span class="btn_blue_l"> <a href="javascript:fn_egov_addView();"><spring:message
                  code="button.create" /></a> <img
              src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
              style="margin-left: 6px;"
              alt="" />
          </span></li>
        </ul>
      </div>
    </div>
  </form:form>
</body>
</html>
