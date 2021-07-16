<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>detail</h1>
	
	<table>
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="50">${dto.content }</textarea></td>
		</tr>
		
		<tr>
			<td>
				<input type="button" value="수정" onclick="">
				<input type="button" value="삭제" onclick="">
				<input type="button" value="목록" onclick="">
			</td>
		</tr>
		
	</table>
	

</body>
</html>