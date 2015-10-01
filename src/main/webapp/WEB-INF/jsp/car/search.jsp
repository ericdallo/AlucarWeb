<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link href='<c:url value="/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/css/util.css"/>' rel="stylesheet">
</head>
<title><fmt:message key="car.title"/></title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
	<div class='page-header text-center'>
		<h1>Pesquisa de carros</h1>
	</div>	
	
	<div class='col-sm-2'></div>
	
	<form class='form-group col-sm-9' method='POST'>
	
		<c:forEach items="${cars}" var="e">
			<div class="row">
		  		<div class="col-sm-6 col-md-4">
		    		<div class="thumbnail">
		      		<img src="${e.image}" alt="...">
		      		<div class="caption">
		        		<h3>${e.model}</h3>
		        		<p></p>
		        		<p>
		        			<a href="#" class="btn btn-primary" role="button">Editar</a> 
		        			<a href="#" class="btn btn-default" role="button">Excluir</a>
		        		</p>
		      		</div>
		    	</div>
			</div>
		</c:forEach>
	</form>
</div>
</body>
</html>