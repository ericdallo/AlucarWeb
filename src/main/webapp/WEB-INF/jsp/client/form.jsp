
<c:if test="${not empty errors}">
	<div class="alert alert-danger" style="text-align:center">
		<c:forEach var="error" items="${errors}">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			${error.message}
		</c:forEach>
	</div>
</c:if>

<input type='hidden' name='client.id' value='${car.id}' />




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
		<input type="text" class="form-control" name='client.born' value="${client.born}">
	</div>
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
		<select class='form-control' id='client.state' name='car.state'>
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
	<label for="car.state" class='control-label'><fmt:message key="client.state" />*</label>
	<div class="input-group col-sm-12">
		<select class='form-control' id='client.state' name='car.state'>
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
		<input type="text" class="form-control" name='client.licenseValidity' value="${client.licenseValidity}">
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="car.state" class='control-label'><fmt:message key="client.licenseState" />*</label>
	<div class="input-group col-sm-12">
		<select class='form-control' name='car.licenseState'>
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
		<input type="text" class="form-control" name='client.postalCode' value="${client.postalCode}">
	</div>
</div>










<!--

<div class='col-sm-4'>
	<div class="form-group">
		<label for="car.model" class='control-label'><fmt:message key="car.model" /></label>
		<div class="input-group col-sm-12">
			<input type="text" class="form-control" name='client.name' value="${car.model}">
		</div>
	</div>
</div>

<div class="form-group col-sm-4">
	<label for="car.manufacturer" class='control-label'><fmt:message key="car.manufacturer" /></label>
	<div class=" input-group col-sm-12">
		<input type="text" class="form-control" id="car.manufacturer" name='car.manufacturer' value="${car.manufacturer}">
	</div>
</div>


<jsp:useBean id="states" class='com.alucarweb.car.state.StatesBean' />

<div class="form-group col-sm-2">
	<label for="car.state" class='control-label'><fmt:message key="client.state" /></label>
	<div class="input-group col-sm-12">
		<select class='form-control' id='client.state' name='car.state'>
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

<div class="form-group col-sm-3">
	<label for="car.city" class='control-label'><fmt:message key="car.city" /></label>
	<div class=" input-group col-sm-12">
		<input type="text" class="form-control" id="car.city" name='car.city' value="${car.city}">
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="car.licensePlate" class='control-label'><fmt:message key="car.licensePlate" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.licensePlate" name='car.licensePlate' value="${car.licensePlate}">
	</div>
</div>

<div class="form-group col-sm-4">
	<label for="car.chassi" class='  control-label'><fmt:message key="car.chassi" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.chassi" name='car.chassi' value="${car.chassi}">
	</div>
</div>

<div class="form-group col-sm-4">
	<label for="car.category" class='control-label'><fmt:message key="car.category" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.category" name='car.category' value="${car.category}">
	</div>
</div>

<div class='form-group col-sm-3'>
	<label for="car.km" class='control-label'><fmt:message key="car.km" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.km" name='car.km' value="${car.km}">
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="car.freeKm" class='control-label'><fmt:message key="car.freeKm" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.freeKm" name='car.freeKm' value="${car.freeKm}">
	</div>
</div>

<div class="form-group col-sm-3">
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
</div>-->