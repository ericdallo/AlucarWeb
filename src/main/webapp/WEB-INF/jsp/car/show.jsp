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
<link href='<c:url value="/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/css/util.css"/>' rel="stylesheet">
<title><fmt:message key="car.title" /></title>
<style>
@media screen and (max-width: 768px){
	.input-group{width:100% !important;}
}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
	
	<div class='col-sm-2'></div>
	
	<form class='form-group col-sm-9 box-home' style='background-color:#efefef;padding-top:20px;'>
		<div class="form-group col-sm-4">
			<img src="http://shopfacil.vteximg.com.br/arquivos/ids/726014-210-210/Carro-CKS-BMW-X6-com-Controle-Remoto-e-Sete-Funcoes-%E2%80%93-Vermelho_0.jpg" alt="..." class="img-thumbnail center-block" style='height:200px;width:200px;'>
		</div>
		
		<div class='col-sm-4'>
			<div class="form-group">
				<label class='control-label'><fmt:message key="car.id" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" id="car.id" name='car.id' value="${car.id}" disabled>
				</div>
			</div>
		</div>
		
		<div class='col-sm-4'>
			<div class="form-group">
				<label for="car.model" class='control-label'><fmt:message key="car.model" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" id="car.model" name='car.model' value="${car.model}">
				</div>
			</div>
		</div>
		<div class="form-group col-sm-4">
			<label for="car.state" class='  control-label'><fmt:message key="car.state" /></label>
			<div class="input-group col-sm-12">
				<select class='form-control' id='car.state' name='car.state'>
					<option value='car.state'>${car.state}</option>
				</select>
			</div>
		</div>
			
		<div class="form-group col-sm-4">
			<label for="car.city" class='control-label'><fmt:message key="car.city" /></label>
			<div class=" input-group col-sm-12">
				<input type="text" class="form-control" id="car.city" name='car.city' value="${car.city}">
			</div>
		</div>
		
		<div class="form-group col-sm-4">
			<label for="car.manufacturer" class='control-label'><fmt:message key="car.manufacturer" /></label>
			<div class=" input-group col-sm-12">
				<input type="text" class="form-control" id="car.manufacturer" name='car.manufacturer' value="${car.manufacturer}">
			</div>
		</div>

		<div class="form-group col-sm-4">
			<label for="car.chassi" class='  control-label'><fmt:message key="car.chassi" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" id="car.chassi" name='car.chassi' value="${car.chassi}">
			</div>
		</div>

		
		
		<div class="form-group col-sm-4">
			<label for="car.licensePlate" class='control-label'><fmt:message key="car.licensePlate" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" id="car.licensePlate" name='car.licensePlate' value="${car.licensePlate}">
			</div>
		</div>
		
		<div class="form-group col-sm-4">
			<label for="car.group" class='control-label'><fmt:message key="car.group" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" id="car.group" name='car.group' value="${car.group}">
			</div>
		</div>
		
		<div class='form-group col-sm-4'>
			<label for="car.km" class='control-label'><fmt:message key="car.km" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" id="car.km" name='car.km' value="${car.km}">
			</div>
		</div>
		
		<div class="form-group col-sm-4">
			<label for="car.freeKm" class='control-label'><fmt:message key="car.freeKm" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" id="car.freeKm" name='car.freeKm' value="${car.freeKm}">
			</div>
		</div>

		<div class="form-group col-sm-4">
			<label for="car.controlKm" class='  control-label'><fmt:message key="car.controlKm" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" id="car.controlKm" name='car.controlKm' value="${car.controlKm}">
			</div>
		</div>

		<div class="form-group col-sm-12">
			<label for="car.obs" class='  control-label'><fmt:message key="car.obs" /></label>
			<div class="input-group col-sm-12">
				<textarea class="form-control" id="car.obs" name='car.obs' rows='4'>${car.obs}</textarea>
			</div>
		</div>
		
		<!--<button type="submit" class="btn btn-default">Submit</button>-->
	</form>
</body>
</html>