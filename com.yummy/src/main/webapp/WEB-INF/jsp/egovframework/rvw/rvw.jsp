<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%-- 
/WEB-INF/jsp/egovframework/rvw/rvw.jsp
 --%>
<div class="inner_container">
<hr>
  <table id="rate">
    <colgroup>
      <col width="100"/>
      <col width="100"/>
      <col width="100"/>
      <col width="100"/>
      <col width="100"/>
      <col width="100"/>
    </colgroup>
    <thead>
      <tr>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.best"/></td>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.good"/></td>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.soso"/></td>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.bad"/></td>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.worst"/></td>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.cnt"/></td>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.avg"/></td>
        <td class="rvw_dtl tbtd_caption"><spring:message code="rvw.grade"/></td>
      </tr>
    </thead>
    <tbody>
      <tr>
        <!-- 1, 2, 3, 4, 5, 후기 갯수, 평점 -->
        <td id="score_best" class="rvw_dtl tbtd_content"></td>
        <td id="score_good" class="rvw_dtl tbtd_content"></td>
        <td id="score_soso" class="rvw_dtl tbtd_content"></td>
        <td id="score_bad" class="rvw_dtl tbtd_content"></td>
        <td id="score_worst" class="rvw_dtl tbtd_content"></td>
        <td id="score_cnt" class="rvw_dtl tbtd_content"></td>
        <td id="score_avg" class="rvw_dtl tbtd_content"></td>
        <td id="score_grade" class="rvw_dtl tbtd_content"></td>
      </tr>
    </tbody>
  </table>
</div>
<hr>
<div class="inner_container">
  <table id="rvwTable">
    <colgroup>
      <col width="100"/>
      <col width="500"/>
      <col width="50"/>
      <col width="200"/>
    </colgroup>
    <thead>
      <tr>
        <td class="tbtd_caption"><spring:message code="rvw.no"/></td>
        <td class="tbtd_caption"><spring:message code="rvw.id"/></td>
        <td class="tbtd_caption"><spring:message code="rvw.score"/></td>
        <td class="tbtd_caption"><spring:message code="rvw.cdt"/></td>
      </tr>
    </thead>
    <tbody id="rvw">
    </tbody>
  </table>
</div>