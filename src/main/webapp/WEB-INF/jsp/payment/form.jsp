<div class='form-group col-md-10 col-md-offset-1 box-home'>
	<div class="card-title text-center">
		<h1>
			<fmt:message key="payment.title" />
		</h1>
	</div>
	
	<form class='' style='background-color:#fff;' action='<c:url value="/pagamentos"/>' method="POST">
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.holdersName" class='control-label'><fmt:message key="payment.holdersName"/></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" name='payment.holdersName'/>
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.cpf" class='control-label'><fmt:message key="payment.cpf" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.cpf" type="text" class="form-control" name='payment.cpf' />
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.value" class='control-label'><fmt:message key="payment.value" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.value" type="text" class="form-control" name='payment.value' readonly />
				</div>
			</div>
		</div>

		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.type" class='control-label'><fmt:message key="payment.type" /></label>
				<div class="input-group col-sm-12">
					<select class='form-control' id='payment.type' name='payment.type'>
						<c:forEach var="type" items="${paymentTypes.list}">
							<option value="${type}">${type.attribute}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<!-- CREDITO -->
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.cardNumber" class='control-label'><fmt:message key="payment.cardNumber" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.cardNumber" type="text" class="form-control" name='payment.cardNumber' />
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.cardDate" class='control-label'><fmt:message key="payment.cardDate" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" />
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.safeCode" class='control-label'><fmt:message key="payment.safeCode" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.safeCode" type="text" class="form-control" name='payment.safeCode' />
				</div>
			</div>
		</div>
		<!-- DEBITO -->
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.bank" class='control-label'><fmt:message key="payment.bank" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.bank" type="text" class="form-control" name='payment.bank' />
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.bankAgency" class='control-label'><fmt:message key="payment.bankAgency" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.bankAgency" type="text" class="form-control" name='payment.bankAgency' />
				</div>
			</div>
		</div>
		
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.account" class='control-label'><fmt:message key="payment.account" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.account" type="text" class="form-control" name='payment.account' />
				</div>
			</div>
		</div>

		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.phone" class='control-label'><fmt:message key="payment.phone" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.phone" type="text" class="form-control" name='payment.phone' />
				</div>
			</div>
		</div>
		
		<div class='form-group col-sm-12 btn-group float-right'>
			<input type='hidden' name='payment.rent.id' value='${rent.id}'/>
			<button type="submit" class='btn btn-primary float-right'>Pagar</button>
		</div>
	</form>
</div>