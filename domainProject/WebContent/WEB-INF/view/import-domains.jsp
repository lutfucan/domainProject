<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Domain Filtreleme</title>
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
	<div class="row">

		<div class="col-md-3" title="FİLTRELENECEK DOMAİNLER"
			style="border-width: 3px; border-style: groove;">
			<div class="header" align="center">
				<h4>
					<span class="badge badge-secondary">FİLTRELENECEK DOMAİNLER</span>
				</h4>
			</div>
			<select multiple="multiple" size="${domainsToFilter.size() + 1}">
				<c:forEach items="${domainsToFilter}" var="domainstofilter">
					<option label="${domainstofilter}" value="${domainstofilter}" />
				</c:forEach>
				<option label="Devamı var...">
			</select>
		</div>
		<div class="col-md-3" title="KELİMELER"
			style="border-width: 3px; border-style: groove;">
			<div class="header" align="center">
				<h4>
					<span class="badge badge-secondary">KELİMELER</span>
				</h4>
			</div>
			<select multiple="multiple" size="${words.size() + 1}">
				<c:forEach items="${words}" var="wordslist">
					<option label="${wordslist}" value="${wordslist}" />
				</c:forEach>
				<option label="Devamı var...">
			</select>
		</div>
		<div class="col-md-3" title="İSTENMEYEN KELİMELER"
			style="border-width: 3px; border-style: groove;">
			<div class="header" align="center">
				<h4>
					<span class="badge badge-secondary">İSTENMEYEN KELİMELER</span>
				</h4>
			</div>
			<select multiple="multiple" size="${blackWords.size() + 1}">
				<c:forEach items="${blackWords}" var="blackwords">
					<option label="${blackwords}" value="${blackwords}" />
				</c:forEach>
				<option label="Devamı var...">
			</select>
		</div>
		<div class="col-md-3" title="TARAMA SONUCU"
			style="border-width: 3px; border-style: groove;">

			<div class="header" align="center">
				<h4>
					<span class="badge badge-secondary">TARAMA SONUCU</span>
				</h4>
			</div>
			<form action="${pageContext.request.contextPath}/filter/filter" method="POST" >
				<input type="submit" value="Filtre"/>
			</form>
			<select multiple="multiple" size="${filtered.size() + 1}">
				<c:forEach items="${filtered}" var="filtered">
					<option label="${filtered}" value="${filtered}" />
				</c:forEach>
			</select>
		</div>
	</div>
</body>
</html>