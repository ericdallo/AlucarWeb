<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="alucar" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<alucar:import jquery="true" bootstrap="true" />
<link href='<c:url value="/css/home.css"/>' rel="stylesheet">
<title>Alucar - Home</title>

</head>
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
	
	<div class="container">
		<div class="home-menu col-md-10 col-md-offset-1">
			<h3>Bem-vindo ao Sistema de Locação de automoveis, Alucar.</h3>
		</div>	
	</div>
	
</body>
</html>