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
<link href='<c:url value="/css/car-form.css"/>' rel="stylesheet">

<title><fmt:message key="car.title" /></title>

</head>

<body>
	<c:if test="${not empty car.id}">
		<script>window.history.pushState('','','/AlucarWeb/automovel/${car.id}');</script>
	</c:if>

	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>

	<div class='col-sm-2'></div>

	<form class='form-group col-sm-8 box-home' action='<c:url value="/automovel/${car.id}"/>' method="POST" enctype="multipart/form-data">
		<div class="card-title text-center">
			<h1>
				<fmt:message key="car.title.update" />
			</h1>
		</div>
		<%@ include file="/WEB-INF/jsp/car/form.jsp"%>

		<div class="form-group col-sm-12">
			<button type="submit" name="_method"
				class='btn btn-primary float-right' value="POST">Atualizar</button>
		</div>

	</form>

</body>
</html>