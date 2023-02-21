<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
!!관리자에게 문의하세요<br>
${msg }<br>
<hr>
<c:out value="${msg2.getMessage() }"/>
<pre>
적은 그대로 보여주는 부분
StackTraceElement[] list = ex.getStackTrace();
		for(StackTraceElement stack:list) {
			log.error(stack);
		}
</pre>
</h1>
<hr>
<ul>
<c:forEach items="${msg2.getStackTrace() }" var="stack">
	<li>${stack }
</c:forEach>
</ul>
<hr>
${msg2 }
</body>
</html>