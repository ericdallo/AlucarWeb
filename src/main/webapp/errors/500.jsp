<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="alucar" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<alucar:import jquery="true" bootstrap="true" />
<link href='<c:url value="/css/car-form.css"/>' rel="stylesheet">
<title><fmt:message key="500.title" /></title>
</head>
<body>
	<div class='container'>

		<div class="row row-margin">
			<div class="col-md-6 col-md-offset-3 text-center">
				<img style='width:300px !important;' src='<c:url value="/images/500.png"/>' />
			</div>
		</div>

		<div class='row row-margin'>
			<h3 class='text-center'>
				<fmt:message key="500.desc" />
			</h3>

			<div class="col-md-6 col-md-offset-3 text-center" role="group" aria-label="...">
				<a href='<c:url value="/home" />'  class="btn btn-primary"><fmt:message key="500.button" /></a>
			</div>
		</div>
	</div>

</body>
</html>