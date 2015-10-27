<div class='form-group col-md-10 col-md-offset-1'>
	<div class="card-title">
		<h1>
			<fmt:message key="devolution.title" />
		</h1>
	</div>
	
	<form class='' style='background-color:#fff;' action='<c:url value="/devolucao"/>' method="POST">
		<div class='col-sm-2'>
			<div class="form-group">
				<label for="devolution.date" class='control-label'><fmt:message key="devolution.date" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" name='devolution.date' value='<fmt:formatDate value="${devolution.date.time}" type="Date"/>' >
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="devolution.agency" class='control-label'><fmt:message key="devolution.agency" /></label>
				<div class="input-group col-sm-12">
					<select class='form-control' name='devolution.agency'>
						<c:forEach var="agency" items="${agencies}">
							<c:if test="${devolution.agency.id eq agency.id}" >
								<option value="${agency.id}" selected>${agency.name}</option>
							</c:if>
							<c:if test="${not (devolution.agency.id eq agency.id)}" >
								<option value="${agency.id}">${agency.name}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="devolution.totalValue" class='control-label'><fmt:message key="devolution.totalValue" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" name='devolution.agency' value='${devolution.totalValue}' >
				</div>
			</div>
		</div>
			
		<div class='form-group col-sm-12 btn-group float-right'>
			<button type="submit" class='btn btn-primary float-right'>Gravar</button>
		</div>
	</form>
</div>