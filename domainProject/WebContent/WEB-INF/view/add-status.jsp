<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Durum Bilgisi Ekle / Değiştir</title>
<!-- <link type="text/css" rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/resources/css/style.css"> --%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.slim.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


</head>
<body>
	<jsp:include page="nav.jsp" />

	<div class="header" align="center">
		<h1>
			<span class="badge badge-primary">DURUM BİLGİSİ EKLE</span>
		</h1>
	</div>
	<div class="container">
		<form:form modelAttribute="status" action="addStatus"
			method="POST">
			<form:hidden path="stId" />
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="status">Durum Adı</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="status" class="form-control" />
				</div>
				<div class="col-md-1">
					<input type="submit" value="Gönder" class="btn btn-primary"></input>
				</div>
				<div class="col-md-1">
					<input type="reset" value="Sıfırla" class="btn btn-secondary"></input>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>