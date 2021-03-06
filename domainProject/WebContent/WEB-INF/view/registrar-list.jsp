<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kayıt Firma Listesi</title>
<!-- <link type="text/css" rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/resources/css/style.css"> --%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.slim.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="table-responsive">
		<table class="table table-bordered table-hover table-sm"
			style="width: 60%; margin: 0px auto;">
			<thead class="thead-dark">
				<tr>
					<th style="width: 10%">Firma ID</th>
					<th style="width: 45%">Firma Adı</th>
					<th style="width: 45%">Firma Adresi</th>

				</tr>
			</thead>
			<c:forEach items="${theRegistrarList}" var="registrars">
				<tr>
					<td><c:out value="${registrars.regId}"></c:out></td>
					<td><c:out value="${registrars.registrarName}"></c:out></td>
					<td><c:out value="${registrars.registrarUrl}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>