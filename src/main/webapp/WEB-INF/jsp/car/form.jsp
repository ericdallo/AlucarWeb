
<c:if test="${not empty errors}">
	<div class="alert alert-danger" style="text-align:center">
		<c:forEach var="error" items="${errors}">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			${error.message}
		</c:forEach>
	</div>
</c:if>

<div class="form-group col-sm-4 image-upload">
	 <label for="imageFile">
        <img src="${car.image}" class="img-thumbnail center-block car-image pointer"/>
    </label>
    <input id="imageFile" name="imageFile" type="file"/>
</div>

<input type='hidden' name='car.id' value='${car.id}' />
<input type='hidden' name='car.available' value='true' />

<div class='col-sm-4'>
	<div class="form-group">
		<label for="car.model" class='control-label'><fmt:message key="car.model" /></label>
		<div class="input-group col-sm-12">
			<input type="text" class="form-control" id="car.model" name='car.model' value="${car.model}">
		</div>
	</div>
</div>

<div class="form-group col-sm-4">
	<label for="car.manufacturer" class='control-label'><fmt:message key="car.manufacturer" /></label>
	<div class=" input-group col-sm-12">
		<input type="text" class="form-control" id="car.manufacturer" name='car.manufacturer' value="${car.manufacturer}">
	</div>
</div>
<!-- BREAK LINE -->

<jsp:useBean id="states" class='com.alucarweb.car.state.StatesBean' />

<div class="form-group col-sm-2">
	<label for="car.state" class='control-label'><fmt:message key="car.state" /></label>
	<div class="input-group col-sm-12">
		<select class='form-control' id='car.state' name='car.state'>
			<c:forEach var="st" items="${states.list}">
				<c:if test="${not empty car.state and car.state eq st}">
					<option value="${car.state}" selected>${car.state}</option>
				</c:if>
				<c:if test="${empty car.state or car.state != st}">
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
<!-- BREAK LINE -->

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
<!-- BREAK LINE -->


<div class="form-group col-sm-12">
	<label for="car.obs" class='  control-label'><fmt:message key="car.obs" /></label>
	<div class="input-group col-sm-12">
		<textarea class="form-control" id="car.obs" name='car.obs' rows='4'>${car.obs}</textarea>
	</div>
</div>