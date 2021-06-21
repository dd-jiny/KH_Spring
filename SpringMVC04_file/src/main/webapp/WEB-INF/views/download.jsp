<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	file:${fileObj.name }<br>
	desc:@${fileObj.desc }<br>
	
	<form action="download" method="post">
		<input type="hidden" name="name" value="${fileObj.name }">
		<input type="submit" value="download">
	
	
	</form>

</body>
</html>

<!-- 

	tomcat web.xml 확인해보기 (자주 봐라!) 
	mime-type (Multipurpose Internet Mail Extension) 
	데이터가 어떤 종류의 stream인지를 나타내주는 프로토콜 (request header에 지정) 
	
	<mime-mapping>
        <extension>hwp</extension>
        <mime-type>application/unknown</mime-type>
    </mime-mapping>
    
    
	

 -->