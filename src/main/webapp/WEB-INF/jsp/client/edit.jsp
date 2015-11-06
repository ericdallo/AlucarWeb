<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="alucar" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<alucar:import 
	jquery="true" 
	bootstrap="true"
/>
<link href='<c:url value="/css/client-form.css"/>' rel="stylesheet">
<title><fmt:message key="client.title" /></title>

</head>

<body>
	<c:if test="${not empty client.id}">
		<script>window.location.url = '/AlucarWeb/cliente/${client.id}'</script>
		
	</c:if>

	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>

	<div class='col-sm-2'></div>
	
	
	<form class='form-group col-sm-8 box-home' action='<c:url value="/cliente/${client.id}"/>' method="POST">
		<input type='hidden' name='client.id' value='${client.id}' />
		
		
		<div class="card-title text-center">
			<h1>
				<fmt:message key="client.title.update" />
			</h1>
		</div>
		<%@ include file="/WEB-INF/jsp/client/form.jsp"%>

		<div class="form-group col-sm-12 btn-group">
			<button type="submit" name="_method" class='btn btn-primary' value="POST">Atualizar</button>
			<c:if test="${loggedUser.supervisor == true}">
				<button type="submit" name="_method" class='btn btn-danger' value="DELETE">Excluir</button>
			</c:if>
		</div>
		
	</form>

</body>
</html>