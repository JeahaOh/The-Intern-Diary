<%@ page   language="java"    contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ui"        uri="http://egovframework.gov/ctl/ui" %>
<%--
   /**
    * @Class Name : rstList.jsp
    * @Description : rst List 화면
    * @Modification Information
    *
    *   수정일         수정자                   수정내용
    *  -------    --------    ---------------------------
    *  2019.03.05            최초 생성
    *
    * author JeahaOh
    * since 2019.03.05
    *
    * Copyright (C) 2019 by JeahaOh  All right reserved.
    */
--%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <title>레스토랑 목록</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/common.css'/>"/>
    <script src="<c:url value='/js/jquery-3.3.1.min.js'/>"></script>
  </head>
  <body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <div class="outter_container">
    <%-- ==== HEADER ==== --%>
      <jsp:include page="/WEB-INF/jsp/egovframework/include/HEADER.jsp" flush="true"/>
    <%-- ==== NAVBAR ==== --%>
      <jsp:include page="/WEB-INF/jsp/egovframework/include/NAVBAR.jsp" flush="true"/>
    <%-- 여기서부터  rst List를 출력할 TABLE --%>
      <table width="80%" border="0" cellpadding="0" style="margin-bottom:10em;"
          cellspacing="0" summary="rstID(래스토랑 번호), rstName(레스토랑 이름), star(미슐랭 별점), loc(위치하는 구), catag(메뉴 대분류)를 표시하는 테이블">
        <caption style="visibility: hidden">
          rstID(래스토랑 번호), rstName(레스토랑 이름), star(미슐랭 별점), loc(위치하는 구), catag(메뉴 대분류)를 표시하는 테이블
        </caption>
        <colgroup>
          <col width="40" />
          <col width="?" />
          <col width="80" />
          <col width="80" />
          <col width="120" />
        </colgroup>
        <tr>
          <td colspan="4"></td>
          <td>
            <button type="button" id="create" onclick="createRst();">
              <spring:message code="title.rst.create"/>
            </button>
          </td>
        </tr>
        <tr>
          <th align="center"><spring:message code="title.rst.id" /></th>
          <th align="center"><spring:message code="title.rst.name" /></th>
          <th align="center"><spring:message code="title.rst.star" /></th>
          <th align="center"><spring:message code="title.rst.loc" /></th>
          <th align="center"><spring:message code="title.rst.catag" /></th>
        </tr>
        <c:forEach var="result" items="${rstList}" varStatus="status">
          <tr onClick="toRstDetail('${result.rst_no}');">
            <%--
            <td align="center" class="listtd">
              <c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}" />
            </td>
            --%>
            <td align="center" class="listtd">
              <a href="javascript:fn_egov_select('<c:out value="${result.rst_no}"/>')">
                <c:out value="${result.rst_no}" />
              </a>
            </td>
            <td align="left" class="listtd"><c:out value="${result.rst_name}" />&nbsp;</td>
            <td align="center" class="listtd"><c:out value="${result.star}" />&nbsp;</td>
            <td align="center" class="listtd"><c:out value="${result.loc}" />&nbsp;</td>
            <td align="center" class="listtd"><c:out value="${result.catag_nm}" />&nbsp;</td>
          </tr>
        </c:forEach>
      </table>
    <%-- 여기까지  rst List를 출력하는 TABLE --%>
    <%-- PAGING --%>
    <%-- 
    <div id="paging">
      <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
      <form:hidden path="pageIndex" />
    </div>
  
    <div id="sysbtn">
      <ul>
        <li>
          <span class="btn_blue_l">
            <a href="javascript:fn_egov_addView();">
              <spring:message code="button.create" />
            </a>
            <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
                style="margin-left: 6px;"
                alt="" />
          </span>
        </li>
      </ul>
    </div>
     --%>
    <%-- PAGING --%>
    <%-- ==== FOOTER ==== --%>
      <jsp:include page="/WEB-INF/jsp/egovframework/include/FOOTER.jsp" flush="true"/>
    </div>
    <script>
      /**
       * Rst 상세 페이지로 이동하기 위한 function
       */
      function toRstDetail( data ) {
        console.log( data );
        location.href = "/yummy/rst/detail?id=" + data
      }
    
      function createRst() {
        location.href = "/yummy/rst/save"
      }
    </script>
    <script src="<c:url value='/js/common.js'/>" charset="utf-8"></script>
  </body>
</html>