<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		결과는 (경고창 문구, 새로 고치면 없어짐)  ${aaa } <br> 뭐야 1번(안나옴) ${param.aaa }<br>뭐야 2번 ${bbb }<br>
		<script>
			var aaa = "${aaa}";
			if (aaa != "")
				alert("${aaa}");
		</script>
	</h2>
</body>
</html>