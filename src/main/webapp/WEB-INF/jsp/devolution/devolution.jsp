<div class='form-group col-md-10 col-md-offset-1 box-home'>
	<div class="card-title text-center">
		<h1>
			<fmt:message key="devolution.title" />
		</h1>
	</div>
	
	<div class='col-sm-2'>
		<div class="form-group">
			<label for="devolution.date" class='control-label'><fmt:message key="devolution.date" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" value='<fmt:formatDate value="${devolution.date.time}" type="Date"/>' disabled >
			</div>
		</div>
	</div>
	
	<div class='col-sm-3'>
		<div class="form-group">
			<label for="devolution.agency" class='control-label'><fmt:message key="devolution.agency" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" value='${devolution.agency.name}' disabled >
			</div>
		</div>
	</div>
	
	<div class='col-sm-3'>
		<div class="form-group">
			<label for="devolution.totalValue" class='control-label'><fmt:message key="devolution.totalValue" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" value='${devolution.totalValue}' disabled >
			</div>
		</div>
	</div>


	<form class='form-group col-sm-12 btn-group float-right' action='<c:url value="/devolucao/${devolution.id}"/>' method='POST'>
		
		<button type="submit" class='btn btn-primary float-right'>Pagar</button>
	</form>	
</div><!-- form-group -->

