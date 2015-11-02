<div class='form-group col-md-10 col-md-offset-1 box-home'>
	<div class="card-title text-center">
		<h1>
			<fmt:message key="payment.title" />
		</h1>
	</div>
	
	<form class='' style='background-color:#fff;' action='<c:url value="/pagamentos"/>' method="POST">
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.holdersName" class='control-label'><fmt:message key="payment.holdersName " /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" name='payment.holdersName' value='' >
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="" class='control-label'><fmt:message key="" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" name='' value='' >
				</div>
			</div>
		</div>
		
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.name" class='control-label'><fmt:message key="payment.name" /></label>
				<div class="input-group col-sm-12">
					<select class='input-group' name='payment.type'>
					
					</select>
				</div>
			</div>
		</div>
				
		
		<div class='form-group col-sm-12 btn-group float-right'>
			<input type='hidden' name='payment.rent.id' value='${rent.id}'/>
			<button type="submit" class='btn btn-primary float-right'>Pagar</button>
		</div>
	</form>
</div>