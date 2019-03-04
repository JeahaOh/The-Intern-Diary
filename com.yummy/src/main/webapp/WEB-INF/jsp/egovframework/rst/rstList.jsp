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
<title>Restaurant List</title>
<style></style>
</head>
<body>
  <c:forEach
    var="rst"
    items="${rstList}"
    varStatus="status">
      <div>
        ${rst.rst_name}
      </div>
  </c:forEach>
</body>
</html>