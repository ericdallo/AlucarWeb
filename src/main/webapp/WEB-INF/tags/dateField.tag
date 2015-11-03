<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="name" required="true"%>

<div class="form-group col-sm-2">
	<label for="${name}" class='control-label'><fmt:message key="${name}" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control datepicker" id="${name}" name='${name}'>
	</div>
</div>

<script>
	$(".datepicker").datepicker();
</script>
