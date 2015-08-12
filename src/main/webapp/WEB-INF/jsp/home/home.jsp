<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src='<c:url value="/js/jquery.js"/>'></script>
<script src='<c:url value="/bootstrap/js/bootstrap.min.js"/>'></script>
<script src='<c:url value="/js/home.js"/>'></script>

<link href='<c:url value="/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/css/util.css"/>' rel="stylesheet">
<link href='<c:url value="/css/home.css"/>' rel="stylesheet">

<title>Alucar - Home</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="btn-group btn-group-justified">
				<div class="btn-group">
					<button type="button" class="btn btn-nav">
						<span class="glyphicon glyphicon-user"></span>
						<p><fmt:message key="home.client"/></p>
					</button>
				</div>
				<div class="btn-group">
					<button type="button" class="btn btn-nav">
						<span class="glyphicon glyphicon-dashboard"></span>
						<p><fmt:message key="home.car"/></p>
					</button>
				</div>
				<div class="btn-group">
					<button type="button" class="btn btn-nav">
						<span class="glyphicon glyphicon-usd"></span>
						<p><fmt:message key="home.location"/></p>
					</button>
				</div>
				<div class="btn-group">
					<button type="button" class="btn btn-nav">
						<span class="glyphicon glyphicon-ok"></span>
						<p><fmt:message key="home.devolution"/></p>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>