<div class='form-group col-md-10 col-md-offset-1 box-home'>
	<div class="card-title text-center">
		<h1>
			<fmt:message key="devolution.title" />
		</h1>
	</div>
	
	<form class='' style='background-color:#fff;' action='<c:url value="/devolucoes"/>' method="POST">
		<div class='col-sm-2'>
			<div class="form-group">
				<label for="devolution.date" class='control-label'><fmt:message key="devolution.date" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" name='devolution.date' value='' >
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="devolution.agency" class='control-label'><fmt:message key="devolution.agency" /></label>
				<div class="input-group col-sm-12">
					<select class='form-control' id="devolution.agency" name='devolution.agency.id'>
						<c:forEach var="ag" items="${agencies}">
							<option value="${ag.id}">${ag.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="devolution.totalValue" class='control-label'><fmt:message key="devolution.totalValue" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" name='devolution.totalValue' value='${devolution.totalValue}' >
				</div>
			</div>
		</div>
			
		<div class='form-group col-sm-12 btn-group float-right'>
			<input type='hidden' name='devolution.rent.id' value='${rent.id}'/>
			<button type="submit" class='btn btn-primary float-right'>Gravar</button>
		</div>
	</form>
</div>