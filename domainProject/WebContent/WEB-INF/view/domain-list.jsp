<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Domain Listesi</title>
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
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>

					<th>Domain Adı</th>
					<th>Firması</th>
					<th>Uzantısı</th>
					<th>Kayıt Tarihi</th>
					<th>Bitiş Tarihi</th>
					<th>Durumu</th>
					<th>Sahibi</th>
					<th>Kategoriler</th>

				</tr>
			</thead>

			<c:forEach items="${theDomainsList}" var="domains">
				<tr>
					<td><c:out value="${domains.fullDomainName}"></c:out></td>
					<td><c:out value="${domains.registrar.registrarName}"></c:out></td>
					<td><c:out value="${domains.extension}"></c:out></td>
					<td><c:out value="${domains.registerDate}"></c:out></td>
					<td><c:out value="${domains.expirationDate}"></c:out></td>
					<td><c:out value="${domains.status.status}"></c:out></td>
					<td><c:out value="${domains.user}"></c:out></td>
					<td><c:forEach items="${domains.categories}" var="categories">
							<c:out value="${categories.categoryName} - "></c:out>
						</c:forEach></td>


				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>