<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<h1>List</h1>
		<colgroup>
			<col width="50">
			<col width="500">
			<col width="100">
			<col width="200">
		</colgroup>

		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>

		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4">--------작성된 글이 없습니다---------</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.seq }</td>
						<td><a href="detail.do?seq=${dto.seq}">${dto.title }</a></td>
						<td>${dto.writer }</td>
						<td>${dto.regdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

		<tr>
			<td colspan="4" align="right">
			<input type="button" value="글작성" onclick="location.href=''">
			</td>
		</tr>











	</table>

</body>
</html>