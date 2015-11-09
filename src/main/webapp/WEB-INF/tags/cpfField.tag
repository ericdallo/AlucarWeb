<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="false" %>

<script src='<c:url value="/js/jquery-ui.js"/>'></script>
<link href='<c:url value="/css/jquery-ui.css"/>' rel="stylesheet">

<div class="form-group col-sm-3">
	<label for="${name}" class='control-label'><fmt:message key="${name}" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control mask-cpf" id="${name}" name='${name}'>
	</div>
</div>
<script>
	$(".mask-cpf").mask('999.999.999-99');	
</script>