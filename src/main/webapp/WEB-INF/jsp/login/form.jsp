<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src='<c:url value="/js/jquery.js"/>'></script>
<script src='<c:url value="/bootstrap/js/bootstrap.min.js"/>'></script>
<script src='<c:url value="/js/login.js"/>'></script>
<link href='<c:url value="/bootstrap/css/bootstrap.min.css"/>'
	rel="stylesheet">
<link href='<c:url value="/css/util.css"/>' rel="stylesheet">
<link href='<c:url value="/css/login.css"/>' rel="stylesheet">
</head>
<body>
	<div>
		<c:forEach items="${errors}" var="e">
			<div class="alert alert-danger text-center msg-error">
				${e.message}
			</div>
		</c:forEach>
	</div>
	<div class="jumbotron">
		<div class="container">
			<span class="glyphicon "></span>
			<img alt="Logo" src='<c:url value="/images/logo.png"/>'>
			<h2>Login</h2>
			<form action='<c:url value="login"/>' method="POST">
				<div class="box">
					<input type="text" name="user.name" autofocus placeholder='<fmt:message key="login.user"/>' class="${inputError}"> 
					<input type="password" name="user.password" placeholder='<fmt:message key="login.password"/>' class="${inputError}">
					<button class="btn btn-info full-width" type="submit">
						<span class="glyphicon glyphicon-ok"></span>
					</button>
					<select placeholder="Agency" name='agency' class="float-right">
						<c:forEach var="ag" items="${agencies}">
							<option value="${ag.id}">${ag.name}</option>
						</c:forEach>
					</select>
				</div>
			</form>
		</div>
	</div>
</body>
</html>