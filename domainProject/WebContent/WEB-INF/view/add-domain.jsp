<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Domain Ekle / Değiştir</title>
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
			<span class="badge badge-primary">DOMAIN EKLE</span>
		</h1>
	</div>
	<div class="container">
		<form:form modelAttribute="domain" action="addDomain" method="POST">
			<form:hidden path="domId" />
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="fullDomainName">Domain</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="fullDomainName" class="form-control" />
				</div>
				<div class="col-md-2">
					<form:label path="extension">Uzantısı</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="extension" class="form-control" />
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="registrar">Kayıt Firması</form:label>
				</div>
				<div class="col-md-4">
					<form:select path="registrar" class="form-control">
						<c:forEach items="${registrarList}" var="registrars">
							<form:option value="${registrars.regId}">${registrars.registrarName}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-md-2">
					<form:label path="categories">Kategoriler</form:label>
				</div>
				<div class="col-md-4">
					<form:select path="categories" multiple="true" class="form-control">
						<c:forEach items="${categoryList}" var="categories">
							<form:option value="${categories.catId}">${categories.categoryName}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="registerDate">Kayıt Tarihi</form:label>
				</div>
				<div class="col-md-4">
					<form:input type="date" path="registerDate" class="form-control" />
				</div>
				<div class="col-md-2">
					<form:label path="expirationDate">Kayıt Bitiş Tarihi</form:label>
				</div>
				<div class="col-md-4">
					<form:input type="date" path="expirationDate" class="form-control" />
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="cost">Maliyet</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="cost" class="form-control" />
				</div>
				<div class="col-md-2">
					<form:label path="minimumPrice">Minimum Fiyat</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="minimumPrice" class="form-control" />
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="askingPrice">Talep Edilen Ücret</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="askingPrice" class="form-control" />
				</div>
				<div class="col-md-2">
					<form:label path="maxPrice">Maksimum Fiyat</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="maxPrice" class="form-control" />
				</div>
			</div>
			<div class="row form-group">
				<div class="col-md-2">
					<form:label path="status">Durum</form:label>
				</div>
				<div class="col-md-4">
					<form:select path="status" class="form-control">
						<c:forEach items="${statusList}" var="stasuses">
							<form:option value="${stasuses.stId}">${stasuses.status}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-md-2">
					<form:label path="user">Kullanıcı</form:label>
				</div>
				<div class="col-md-4">
					<form:input path="user" class="form-control" />
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