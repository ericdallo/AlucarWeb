<c:if test="${not empty errors}">
	<div class="alert alert-danger" style="text-align:center">
		<c:forEach var="error" items="${errors}">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			${error.message}
		</c:forEach>
	</div>
</c:if>

<jsp:useBean id="states" class='com.alucarweb.state.StatesBean' />

<div class='form-group col-sm-6'>
	<label for="client.name" class='control-label'><fmt:message key="client.name" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.name' value="${client.name}">
	</div>
</div>

<div class='form-group col-sm-3'>
	<label for="client.name" class='control-label'><fmt:message key="client.cpf" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.cpf' value="${client.cpf}">
	</div>
</div>

<div class='form-group col-sm-3'>
	<label for="client.name" class='control-label'><fmt:message key="client.born" />*</label>
	<div class="input-group col-sm-12">
	</div>
		<input type="text" class="form-control" name='client.born' value="<fmt:formatDate type='Date' value='${client.born.time}'/>">
</div>


<div class='form-group col-sm-4'>
	<label for="client.name" class='control-label'><fmt:message key="client.email" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.email' value="${client.email}">
	</div>
</div>

<div class='form-group col-sm-3'>
	<label for="client.name" class='control-label'><fmt:message key="client.gender" />*</label>
	<div class="input-group col-sm-12">		
		<select class='form-control' name='client.gender'>
			<option value="F" <c:if test="${client.gender == 'F'}">selected</c:if>>
				<fmt:message key="client.gender.female" />
			</option>
			<option value="M" <c:if test="${client.gender == 'M'}">selected</c:if>>
				<fmt:message key="client.gender.male" />
			</option>
		</select>
	</div>
</div>

<div class="form-group col-sm-2">
	<label for="client.state" class='control-label'><fmt:message key="client.state" />*</label>
	<div class="input-group col-sm-12">
		<select class='form-control' id='client.state' name='client.state'>
			<c:forEach var="st" items="${states.list}">
				<c:if test="${not empty client.state and client.state eq st}">
					<option value="${client.state}" selected>${client.state}</option>
				</c:if>
				<c:if test="${empty client.state or client.state != st}">
					<option value="${st}">${st}</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
</div>


<div class='form-group col-sm-3'>
	<label for="client.name" class='control-label'><fmt:message key="client.city" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.city' value="${client.city}">
	</div>
</div>


<div class='form-group col-sm-5'>
	<label for="client.name" class='control-label'><fmt:message key="client.address" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.address' value="${client.address}">
	</div>
</div>

<div class='form-group col-sm-2'>
	<label for="client.name" class='control-label'><fmt:message key="client.addressNumber" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.addressNumber' value="${client.addressNumber}">
	</div>
</div>

<div class='form-group col-sm-3'>
	<label for="client.name" class='control-label'><fmt:message key="client.neighborhood" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.neighborhood' value="${client.neighborhood}">
	</div>
</div>

<div class='form-group col-sm-2'>
	<label for="client.name" class='control-label'><fmt:message key="client.postalCode" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.postalCode' value="${client.postalCode}">
	</div>
</div>




<div class='form-group col-sm-4'>
	<label for="client.licenseCode" class='control-label'><fmt:message key="client.licenseCode" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.licenseCode' value="${client.licenseCode}">
	</div>
</div>
<div class='form-group col-sm-2'>
	<label for="client.licenseValidity" class='control-label'><fmt:message key="client.licenseValidity" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.licenseValidity' value="<fmt:formatDate type='Date' value='${client.licenseValidity.time}'/>">
		
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="client.state" class='control-label'><fmt:message key="client.licenseState" />*</label>
	<div class="input-group col-sm-12">
		<select class='form-control' name='client.licenseState'>
			<c:forEach var="st" items="${states.list}">
				<c:if test="${not empty client.licenseState and client.licenseState eq st}">
					<option value="${client.licenseState}" selected>${client.licenseState}</option>
				</c:if>
				<c:if test="${empty client.licenseState or client.licenseState != st}">
					<option value="${st}">${st}</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
</div>


<div class='form-group col-sm-3'>
	<label for="client.licenseCity" class='control-label'><fmt:message key="client.licenseCity" />*</label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" name='client.licenseCity' value="${client.licenseCity}">
	</div>
</div>