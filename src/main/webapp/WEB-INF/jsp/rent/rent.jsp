<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="alucar" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<alucar:import jquery="true" bootstrap="true" />
<script src='<c:url value="/js/payment.js"/>' type="text/javascript" ></script>
<title><fmt:message key="rent.title" /></title>
</head>
</head><link href='<c:url value="/css/util.css"/>' rel="stylesheet">
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<jsp:useBean id="status" class='com.alucarweb.status.RentStatusBean' />
	<jsp:useBean id="kms" class='com.alucarweb.killometer.KillometerTypeBean' />
	<jsp:useBean id="paymentTypes" class='com.alucarweb.payment.type.PaymentTypeBean' />

	<c:if test="${not empty errors}">
		<div class="alert alert-danger" style="text-align: center">
			<c:forEach var="error" items="${errors}">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span>
				${error.message}
			</c:forEach>
		</div>
	</c:if>

	<div class="container">
		<div class='row'>
			<c:if test="${paymentIsEnabled eq true }">
				<%@ include file="/WEB-INF/jsp/payment/form.jsp"%>
			</c:if>
		</div>

		<c:if test="${devolutionIsEnabled eq true }">
			<div class='row row-margin'>
				<%@ include file="/WEB-INF/jsp/devolution/form.jsp"%>
			</div>
		</c:if>

		<div class='row row-margin'>
			<c:if test="${not empty payment}">
				<%@ include file="/WEB-INF/jsp/payment/payment.jsp"%>
			</c:if>
		
			<c:if test="${not empty devolution}">
				<%@ include file="/WEB-INF/jsp/devolution/devolution.jsp"%>
			</c:if>

			<%@ include file="/WEB-INF/jsp/rent/show.jsp"%>

		</div>
	</div>
	<!-- container -->
</body>
</html>