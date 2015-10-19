<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src='<c:url value="/js/jquery.js"/>'></script>
<script src='<c:url value="/bootstrap/js/bootstrap.min.js"/>'></script>

<link href='<c:url value="/bootstrap/css/bootstrap.min.css"/>'
	rel="stylesheet">
<link href='<c:url value="/css/util.css"/>' rel="stylesheet">
<link href='<c:url value="/css/car-list.css"/>' rel="stylesheet">

</head>
<title><fmt:message key="car.title" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<!-- TODO - FILTROS PARA A PESQUISA -->

	<div>
		<c:forEach items="${errors}" var="e">
			<div class="alert alert-info text-center msg-error">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> ${e.message}
			</div>
		</c:forEach>
	</div>

	<div class="container">
		<div class="row car-panel">
			<div class='title'>
				<h1 class='list-title'>Pesquisa de carros</h1>
			</div>
			

			<c:forEach items="${cars}" var="car">
				<div class="col-sm-6 col-md-4 shadow">
					<div class='inside'>
						<form action="<c:url value='/automovel/${car.id}'/>" method='POST'>
							<a href="<c:url value='/automovel/${car.id}'/>"> <img
								src="${car.image}" alt="Image car" class="img-thumbnail pointer">
							</a>
							<h2>${car.model}</h2>
							<p>${car.manufacturer}</p>
							<a href="<c:url value='/automovel/${car.id}'/>"
								class="btn btn-primary" role="button"> <span
								class="glyphicon glyphicon-edit" aria-hidden="true"></span>
								Visualizar
							</a>

							<button type="submit" name="_method" class='btn btn-danger'
								value="DELETE">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								Excluir
							</button>
						</form>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>
</body>
</html>