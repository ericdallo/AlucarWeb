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
	<div class="list-title">
		<h1>Automóveis</h1>
	</div>
	
	<div class="container">
		<c:forEach items="${cars}" var="car">
			<div class="row car-row">
				<div class="col-xs-8 col-xs-offset-2 card">
					<div class="image-car">
						<a href="<c:url value='/automovel/${car.id}'/>"> <img
							src="${car.image}" alt="Image">
						</a>
					</div>

					<div class="content">
						<span class="float-right">${car.state}</span>

						<h4>${car.model}</h4>
						<p>${car.manufacturer}</p>
						<p>${car.obs}</p>

					</div>
					<div class="footer">
						<span class="pull-right buttons"> <a
							href="<c:url value='/automovel/${car.id}'/>"
							class="btn btn-sm btn-default" role="button"> <span
								class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
								Visualizar
						</a>
							<button class="btn btn-sm btn-primary">
								<i class="fa fa-fw fa-credit-card"></i> Alugar
							</button>
						</span>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>