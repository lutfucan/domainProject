<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ana Sayfa</title>

</head>
<body>
	<nav class="navbar sticky-top navbar-dark bg-dark navbar-expand-lg">
		<a class="navbar-brand" href="${pageContext.request.contextPath}">Domain Menü</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="${pageContext.request.contextPath}">
						Ana Sayfa 
					</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" 
						href="#" id="navbarDropdown"
						role="button" 
						data-toggle="dropdown" 
						aria-haspopup="true"
						aria-expanded="false"> 
							Ana Menü 
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/domain/add">
							Domain Ekle
						</a> 
						<a class="dropdown-item" href="${pageContext.request.contextPath}/domain/list">
							Domain Listesi
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="${pageContext.request.contextPath}/category/add">
							Kategori Ekle
						</a> 
						<a class="dropdown-item" href="${pageContext.request.contextPath}/category/list">
							Kategori Listesi
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="${pageContext.request.contextPath}/status/add">
							Durum Bilgisi Ekle
						</a> 
						<a class="dropdown-item" href="${pageContext.request.contextPath}/status/list">
							Durum Listesi
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="${pageContext.request.contextPath}/registrar/add">
							Kayıt Firması Ekle
						</a> 
						<a class="dropdown-item" href="${pageContext.request.contextPath}/registrar/list">
							Kayıt Firma Listesi
						</a>
						<div class="dropdown-divider"></div>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" 
					href="#" 
					id="navbarDropdown"
					role="button" 
					data-toggle="dropdown" 
					aria-haspopup="true"
					aria-expanded="false"> 
						Filtreleme İşlemleri 
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/filter/main">
							Domain Filtreleme
						</a> 
						<div class="dropdown-divider"></div>
					</div>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="Ara" aria-label="Ara">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Ara</button>
			</form>
		</div>
	</nav>
</body>
</html>