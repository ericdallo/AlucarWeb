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
			
	<c:if test="${not empty errors}">
		<div class="alert alert-danger" style="text-align: center">
			<c:forEach var="error" items="${errors}">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				${error.message}
			</c:forEach>
		</div>
	</c:if>
	
	<div class="container">
		<div class='row '>
			<c:if test="${devolutionIsEnabled eq true }">
				<%@ include file="/WEB-INF/jsp/devolution/form.jsp" %>
			</c:if>
			
			<c:if test="${paymentIsEnabled eq true }">
				
			</c:if>
		</div>
		<div class='row row-margin'>			
			<c:if test="${not empty devolution}">
				<%@ include file="/WEB-INF/jsp/devolution/devolution.jsp" %>
			</c:if>
			
			<%@ include file="/WEB-INF/jsp/rent/show.jsp" %>
			
		</div><!-- row -->
	</div><!-- container -->
</body>
</html>