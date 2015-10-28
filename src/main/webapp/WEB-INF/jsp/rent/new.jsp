<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src='<c:url value="/js/jquery.js"/>'></script>
<script src='<c:url value="/bootstrap/js/bootstrap.min.js"/>'></script>
<link href='<c:url value="/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/css/util.css"/>' rel="stylesheet">
<title><fmt:message key="rent.title" /></title>
</head>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	
	<jsp:useBean id="status" class='com.alucarweb.status.RentStatusBean' />
	<jsp:useBean id="kms" class='com.alucarweb.killometer.KillometerTypeBean' />
	
	
	<div class="container">
		<div class='row'>
			<form class='form-group col-md-10 col-md-offset-1' style='background-color:#fff' action=''>
				<c:if test="${not empty errors}">
					<div class="alert alert-danger" style="text-align: center">
						<c:forEach var="error" items="${errors}">
							<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
							${error.message}
						</c:forEach>
					</div>
				</c:if>
					
				<div class="card-title text-center">
					<h1>
						<fmt:message key="rent.title" />
					</h1>
				</div>
						
				<div class="form-group col-sm-2">
					<label class='control-label'><fmt:message key="rent.car.id" /></label>
					<div class=" input-group col-sm-12">
						<input type="text" class="form-control" name='rent.car.id' value="${car.id}" readonly />
					</div>
				</div>
				
				
				<div class="form-group col-sm-3">
					<label class='control-label'><fmt:message key="rent.car.model" /></label>
					<div class=" input-group col-sm-12">
						<input type="text" class="form-control" value="${car.model}" disabled />
					</div>
				</div>
				
				<div class='form-group col-sm-3'>
					<label class='control-label'><fmt:message key="rent.client" /></label>
					<select class='form-control'name='rent.client.id'> 
						<c:forEach var="client" items="${clients}">
							<option value="${client.id}">${client.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group col-sm-2">
					<label class='control-label'><fmt:message key="rent.killometerType" /></label>
					<div class="input-group col-sm-12">
						<select class='form-control'name='rent.KillometerType'> 
							<c:forEach var="km" items="${kms.list}">
								<option value="${km}">${km.attribute}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class='form-group col-sm-2'>
					<label class='control-label'><fmt:message key="rent.expectedDate" /></label>
					<div class="input-group col-sm-12">
						<input type="text" class="form-control" value='<fmt:formatDate value="${rent.expectedDate.time}" type="Date"/>' disabled />
					</div>
				</div>
				
				<div class="form-group col-sm-2">
					<label class='control-label'><fmt:message key="rent.agency" /></label>
					<div class="input-group col-sm-12">
						<select class='form-control'name='rent.agency'> 
							<c:forEach var="ag" items="${agencies}">
								<option value="${ag.id}">${ag.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
			</form>
		</div><!-- row -->
	</div><!-- container -->
	
	
</body>
</html>