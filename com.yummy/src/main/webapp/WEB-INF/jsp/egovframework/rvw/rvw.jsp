<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>

<div>
  <table id="rvwTable">
    <thead>
      <tr>
        <td class="tbtd_caption"><spring:message code="rvw.id"/></td>
        <td class="tbtd_caption"><spring:message code="rvw.cont"/></td>
        <td class="tbtd_caption"><spring:message code="rvw.score"/></td>
        <td class="tbtd_caption"><spring:message code="rvw.cdt"/></td>
      </tr>
    </thead>
    <tbody id="rvw">
      <tr>
        <td id="rvw_id" class="tbtd_caption"></td>
        <td id="rvw_cont" class="tbtd_caption"></td>
        <td id="rvw_score" class="tbtd_caption"></td>
        <td id="vrw_cdt" class="tbtd_caption"></td>
      </tr>
    </tbody>
  </table>
</div>