<style>
@media (max-width: 768px){
	.input-group{width:100% !important;}
}

@media (min-width:270px){
	.car-image{
		width:260px !important; 
		height:195px !important;
	}
}
.car-image:hover{
	opacity: 0.8;
}
</style>

<div class="form-group col-sm-4">
	<img src="${car.image}" alt="" class="img-thumbnail center-block car-image pointer">
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


<div class="form-group col-sm-2">
	<label for="car.state" class='  control-label'><fmt:message key="car.state" /></label>
	<div class="input-group col-sm-12">
		<select class='form-control' id='car.state' name='car.state'>
			<option value='${car.state}'>${car.state}</option>
		</select>
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="car.city" class='control-label'><fmt:message
			key="car.city" /></label>
	<div class=" input-group col-sm-12">
		<input type="text" class="form-control" id="car.city" name='car.city'
			value="${car.city}">
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="car.licensePlate" class='control-label'><fmt:message
			key="car.licensePlate" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.licensePlate"
			name='car.licensePlate' value="${car.licensePlate}">
	</div>
</div>
<!-- BREAK LINE -->




<div class="form-group col-sm-4">
	<label for="car.chassi" class='  control-label'><fmt:message
			key="car.chassi" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.chassi"
			name='car.chassi' value="${car.chassi}">
	</div>
</div>

<div class="form-group col-sm-4">
	<label for="car.group" class='control-label'><fmt:message
			key="car.group" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.group"
			name='car.group' value="${car.carGroup}">
	</div>
</div>

<div class='form-group col-sm-3'>
	<label for="car.km" class='control-label'><fmt:message
			key="car.km" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.km" name='car.km'
			value="${car.km}">
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="car.freeKm" class='control-label'><fmt:message
			key="car.freeKm" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.freeKm"
			name='car.freeKm' value="${car.freeKm}">
	</div>
</div>

<div class="form-group col-sm-3">
	<label for="car.controlKm" class='  control-label'><fmt:message
			key="car.controlKm" /></label>
	<div class="input-group col-sm-12">
		<input type="text" class="form-control" id="car.controlKm"
			name='car.controlKm' value="${car.controlKm}">
	</div>
</div>
<!-- BREAK LINE -->


<div class="form-group col-sm-12">
	<label for="car.obs" class='  control-label'><fmt:message
			key="car.obs" /></label>
	<div class="input-group col-sm-12">
		<textarea class="form-control" id="car.obs" name='car.obs' rows='4'>${car.obs}</textarea>
	</div>
</div>