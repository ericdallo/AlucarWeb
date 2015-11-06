<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="alucar" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<alucar:import jquery="true" bootstrap="true" />
<link href='<c:url value="/css/table-list.css"/>' rel="stylesheet">
<title><fmt:message key="rent.title" /></title>

</head>



<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>
	<div>
		<c:forEach items="${errors}" var="e">
			<div class="alert alert-info text-center msg-error">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> 
				${e.message}
			</div>
		</c:forEach>
	</div>
	<table class="flatTable col-md-offset-2 col-md-4">

		<thead>
			<tr class="titleTr">
				<td class="titleTd">Lista de Locações</td>
				<td colspan="6"></td>
			</tr>
			<tr class="headingTr">
				<td>#</td>
				<td>Data de Locação</td>
				<td>Tipo de Km</td>
				<td>Status</td>
				<td>Automóvel</td>
				<td>Cliente</td>
				<td></td>
			</tr>
		<tbody class="table-hover">
			<c:forEach items="${rents}" var="r">
				<tr onclick="window.location.href = '<c:url value='/locacao/${r.id}'/>'">
					<td>${r.id}</td>
					<td><fmt:formatDate value="${r.createdAt.time}" type="Date"></fmt:formatDate></td>
					<td>${r.killometerType.attribute}</td>
					<td>${r.status.attribute}</td>
					<td>${r.car.model}</td>
					<td>${r.client.name}</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>