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
<title><fmt:message key="client.title" /></title>
<style>
	.box-table{
		padding:10px;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<div class='page-header text-center'>
		<h1><fmt:message key="client.title" /></h1>
	</div>
	
	<div class='col-sm-2'></div>
	
		
	<div class="panel panel-default col-sm-8 box-table">
		<!-- Default panel contents -->
		<div class="panel-heading">Clientes cadastrados</div>

		<table class="table">
			<tr><td>${client.name }</td></tr>			
		</table>
	</div>


</body>
</html>