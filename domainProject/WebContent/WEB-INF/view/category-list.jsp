<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kategori Listesi</title>
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
			style="width: 30%; margin: 0px auto;">
			<thead class="thead-dark">
				<tr>
					<th style="width: 30%">Kategori ID</th>
					<th style="width: 70%">Kategori Adı</th>
				</tr>
			</thead>
			<c:forEach items="${theCategoryList}" var="categories">
				<tr>
					<td><c:out value="${categories.catId}"></c:out></td>
					<td><c:out value="${categories.categoryName}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>