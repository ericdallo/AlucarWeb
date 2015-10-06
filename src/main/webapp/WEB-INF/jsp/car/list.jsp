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
<style>
@media (min-width:270px){
	.car-image{
		width:260px !important; 
		height:170px !important;
	}
}

.car-image:hover{
	opacity: 0.8;
}

.thumbnail{
	padding-top: 5px;
	padding-bottom:0px;
}
</style>
</head>
<title><fmt:message key="car.title"/></title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
	<div class='page-header text-center'>
		<h1>Pesquisa de carros</h1>
	</div>	
	<!-- TODO - FILTROS PARA A PESQUISA -->
	
	<div class='col-sm-2'></div>
	
	<div class='form-group col-sm-9 pointer'>
	
		<c:forEach items="${cars}" var="car">
	  		<div class="col-sm-6 col-md-4">
	    		<div class="thumbnail">
	      			<img src="${car.image}" alt="..." class='car-image' >
		      		<div class="caption">
		        		<h3>${car.model}</h3>
		        		<p></p>
		        		<p>
		        			<form action="<c:url value='/automoveis'/>" method='POST'>
		        				<a href="<c:url value='/automovel/${car.id}'/>" class="btn btn-primary" role="button">Visualizar</a>
		        				<input type='submit' class='btn btn-default' value='Excluir' />
		        				<input type='hidden' name='car.id' value='${car.id}'/>
		        			</form>
	    	    		</p>
	      			</div><!-- caption -->
		    	</div><!-- thumbnail -->
			</div>
		</c:forEach>
	</div>
</body>
</html>