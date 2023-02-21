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
객체왔니? ${sampleDTO} SampleController에서 SampleDTO이름을 aaa로 지정하지 않으면 나온다.<br>
객체왔니? ${sampleDTO.name}<br>
객체왔니? ${sampleDTO.age}<br>
객체왔니? ${aaa}<br>
int 왔니? ${page2 } 
</h2>
<!-- 자바빈즈로 만들어진 객체는 model로 보내지 않아도 읽을 수 있다. 
(첫번째 문자는 소문자로 써야 함, 여기서는 sampleDTO 
	여기서 page는 읽히지 않으나 controller에 @ModelAttribute("page")로 읽어오면 jsp에서도 일을 수 있다.-->
</body>
</html>