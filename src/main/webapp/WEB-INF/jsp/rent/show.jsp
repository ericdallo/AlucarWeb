<div class='form-group col-md-10 col-md-offset-1 box-home'>

	<div class="card-title text-center">
		<h1>
			<fmt:message key="rent.title" />
		</h1>
	</div>

	<div class="form-group col-sm-2">
		<label class='control-label'><fmt:message key="rent.car.id" /></label>
		<div class=" input-group col-sm-12">
			<input type="text" class="form-control" value="${rent.car.id}"
				disabled />
		</div>
	</div>

	<div class="form-group col-sm-3">
		<label class='control-label'><fmt:message key="rent.status" /></label>
		<div class="input-group col-sm-12">
			<input type='text' class='form-control'
				value="${rent.status.attribute}" disabled />
		</div>
	</div>


	<div class="form-group col-sm-3">
		<label class='control-label'><fmt:message
				key="rent.killometerType" /></label>
		<div class="input-group col-sm-12">
			<input type='text' class='form-control'
				value='${rent.killometerType.attribute}' disabled />
		</div>
	</div>


	<div class="form-group col-sm-4">
		<label for="rent.client" class='control-label'><fmt:message
				key="rent.client" /></label>
		<div class="input-group col-sm-12">
			<input type='text' class='form-control' value='${rent.client.name}'
				disabled />
		</div>
	</div>

	<div class='form-group col-sm-2'>
		<label class='control-label'><fmt:message key="rent.createdAt" />*</label>
		<div class="input-group col-sm-12">
			<input type="text" class="form-control"
				value=<fmt:formatDate value="${rent.createdAt.time}" type="Date"/>
				disabled>
		</div>
	</div>


	<div class='form-group col-sm-2'>
		<label class='control-label'><fmt:message
				key="rent.expectedDate" />*</label>
		<div class="input-group col-sm-12">
			<input type="text" class="form-control"
				value=<fmt:formatDate value="${rent.expectedDate.time}" type="Date"/>
				disabled />
		</div>
	</div>

	<div class='form-group col-sm-3'>
		<label class='control-label'><fmt:message key="rent.agency" /></label>
		<div class="input-group col-sm-12">
			<input type="text" class="form-control" value='${rent.agency.name}'
				disabled />
		</div>
	</div>

	<div class='form-group col-sm-3'>
		<label class='control-label'><fmt:message
				key="rent.expectedAgency" /></label>
		<div class="input-group col-sm-12">
			<input type="text" class="form-control"
				value='${rent.expectedAgency.name}' disabled />
		</div>
	</div>



	<form class="form-group col-sm-12 btn-group float-right"
		action='<c:url value="/locacao/" />'>
		<button type="submit" class='btn btn-primary'>Devolver</button>
	</form>
</div>