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
<link href='<c:url value="/css/client-list.css"/>' rel="stylesheet">
<title><fmt:message key="client.title" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/navbar.jsp"%>

	<div>
		<c:forEach items="${errors}" var="e">
			<div class="alert alert-danger text-center msg-error">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> ${e.message}
			</div>
		</c:forEach>
	</div>
	<table class="flatTable col-md-offset-2 col-md-4">

		<thead>
			<tr class="titleTr">
				<td class="titleTd">Pesquisa de Clientes</td>
				<td colspan="5"></td>
			</tr>
			<tr class="headingTr">
				<td>#</td>
				<td>Gênero</td>
				<td>Nome</td>
				<td>CPF</td>
				<td>Email</td>
			</tr>
		<tbody class="table-hover">
			<c:forEach items="${clients}" var="c">
				<tr onclick="window.location.href = '<c:url value="/cliente/${c.id}"/>'">
					<td>${c.id}</td>
					<td>${c.gender}</td>
					<td>${c.name}</td>
					<td>${c.cpf}</td>
					<td>${c.email}</td>
					<!-- <td>
						<form action="<c:url value='/cliente/${c.id}'/>" method='POST'
							class="">
							<a href="<c:url value='/cliente/${c.id}'/>"
								class="btn btn-primary" role="button"> <span
								class="glyphicon glyphicon-edit" aria-hidden="true"></span>

							</a>

							<button type="submit" name="_method" class='btn btn-danger'
								value="DELETE">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>

							</button>
						</form>
					</td> -->
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>