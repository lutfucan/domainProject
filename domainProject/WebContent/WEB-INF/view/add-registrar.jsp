<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kayıt Firması Ekle / Değiştir</title>
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
			<span class="badge badge-primary">KAYIT FİRMASI EKLE</span>
		</h1>
	</div>
	<div class="container">
		<form:form modelAttribute="registrar" action="addRegistrar"
			method="POST">
			<form:hidden path="regId" />
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="registrarName">Firma Adı</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="registrarName" class="form-control" />
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="registrarUrl">Firma URL</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="registrarUrl" class="form-control" />
				</div>
			</div>
			<div class="row form-group">
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