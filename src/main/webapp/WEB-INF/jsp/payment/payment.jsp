<div class='form-group col-md-10 col-md-offset-1 box-home'>
	<div class="card-title text-center">
		<h1>
			<fmt:message key="payment.finished.title" />
		</h1>
	</div>
	<div class='col-sm-3'>
		<div class="form-group">
			<label for="payment.holdersName" class='control-label'><fmt:message key="payment.holdersName" /></label>
			<div class="input-group col-sm-12">
				<input type="text" class="form-control" value='${payment.holdersName}' disabled />
			</div>
		</div>
	</div>

	<div class='col-sm-3'>
		<div class="form-group">
			<label for="payment.cpf" class='control-label'><fmt:message key="payment.cpf" /></label>
			<div class="input-group col-sm-12">
				<input id="payment.cpf" type="text" class="form-control" value='${payment.cpf}' disabled />
			</div>
		</div>
	</div>

	<div class='col-sm-3'>
		<div class="form-group">
			<label for="payment.value" class='control-label'><fmt:message key="payment.value" /></label>
			<div class="input-group col-sm-12">
				<input id="payment.value" type="text" class="form-control" value='${payment.value}' disabled />
			</div>
		</div>
	</div>
	<c:if test='${payment.credit eq true}'>
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.cardNumber" class='control-label'><fmt:message key="payment.cardNumber" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.cardNumber" type="text" class="form-control" value='${payment.cardNumber}' disabled />
				</div>
			</div>
		</div>

		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.cardDate" class='control-label'><fmt:message key="payment.cardDate" /></label>
				<div class="input-group col-sm-12">
					<input type="text" class="form-control" value="<fmt:formatDate type='Date' value='${payment.cardDate.time}'/>" disabled/>
				</div>
			</div>
		</div>

		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.safeCode" class='control-label'><fmt:message key="payment.safeCode" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.safeCode" type="text" class="form-control" value='${payment.safeCode}'disabled />
				</div>
			</div>
		</div>
	</c:if>
	<c:if test='${payment.credit eq false}'>
		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.bank" class='control-label'><fmt:message key="payment.bank" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.bank" type="text" class="form-control" value='${payment.bank }' disabled/>
				</div>
			</div>
		</div>

		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.bankAgency" class='control-label'><fmt:message key="payment.bankAgency" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.bankAgency" type="text" class="form-control" value='${payment.bankAgency }' disabled/>
				</div>
			</div>
		</div>

		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.account" class='control-label'><fmt:message key="payment.account" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.account" type="text" class="form-control" value='${payment.account }' disabled/>
				</div>
			</div>
		</div>

		<div class='col-sm-3'>
			<div class="form-group">
				<label for="payment.phone" class='control-label'><fmt:message key="payment.phone" /></label>
				<div class="input-group col-sm-12">
					<input id="payment.phone" type="text" class="form-control" value='${payment.phone}' disabled/>
				</div>
			</div>
		</div>
	</c:if>
</div>