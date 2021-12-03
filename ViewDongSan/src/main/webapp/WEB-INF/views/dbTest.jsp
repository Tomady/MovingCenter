<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
		
	}
</style>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<th>호스트 아이디</th>
				<th>호스트 비밀번호</th>
				<th>호스트 이 름</th>
				<th>호스트 연락처</th>
				<th>호스트 경고 수</th>
			</tr>
			<c:forEach items="${Hosts }" var="host">
				<tr>
					<td>${host.hostId }</td>
					<td>${host.hpassword }</td>
					<td>${host.hname }</td>
					<c:if test="${empty host.htel }">
						<td>없음</td>					
					</c:if>
					<c:if test="${not empty host.htel }">
						<td>host.htel</td>					
					</c:if>
					<td>${host.hyellowCard }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>