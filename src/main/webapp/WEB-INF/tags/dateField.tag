<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="false" type="java.util.Date"%>

<script src='<c:url value="/js/jquery-ui.js"/>'></script>
<link href='<c:url value="/css/jquery-ui.css"/>' rel="stylesheet">

<div class="form-group col-sm-2">
	<label for="${name}" class='control-label'><fmt:message key="${name}" />*</label>
	<div class="input-group col-sm-12">
		<c:if test="${not empty value}">
			<input type="text" class="form-control datepicker" id="${name}" name='${name}' value="<fmt:formatDate type='Date' value='${value}'/>">
		</c:if>
		<c:if test="${empty value }">
			<input type="text" class="form-control datepicker" id="${name}" name='${name}'>
		</c:if>
	</div>
</div>
<script>
	$(".datepicker").datepicker();
</script>
