
<c:if test="${not empty errors}">
	<div class="alert alert-danger" style="text-align: center">
		<c:forEach var="error" items="${errors}">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			${error.message}
		</c:forEach>
	</div>
</c:if>

<!-- <input type='hidden' name='rent.id' value='${rent.id}' /> -->

<div class="form-group col-sm-4">
	<label for="rent.car.id" class='control-label'><fmt:message key="rent.car.id" /></label>
	<div class=" input-group col-sm-12">
		<input type="text" class="form-control" id="rent.car.id" name='rent.car.id' value="${carId}" disabled>
	</div>
</div>

<jsp:useBean id="status"
	class='com.alucarweb.rent.status.RentStatusBean' />

<div class="form-group col-sm-2">
	<label for="rent.status" class='control-label'><fmt:message key="rent.status" /></label>
	<div class="input-group col-sm-12">
		<select class='form-control' id='rent.status' name='rent.status'>
			<c:forEach var="st" items="${status.list}">
				<c:if test="${not empty rent.status and rent.status eq st}">
					<option value="${rent.status}" selected>${rent.status}</option>
				</c:if>
				<c:if test="${empty rent.status or rent.status != st}">
					<option value="${st}">${st}</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
</div>

<jsp:useBean id="kms" class='com.alucarweb.rent.KillometerTypeBean' />

<div class="form-group col-sm-3">
	<label for="rent.killometerType" class='control-label'><fmt:message
			key="rent.killometerType" /></label>
	<div class="input-group col-sm-12">
		<select class='form-control' id='rent.killometerType'
			name='rent.killometerType'>
			<c:forEach var="km" items="${kms.list}">
				<c:if
					test="${not empty rent.killometerType and rent.killometerType eq km}">
					<option value="${rent.killometerType}" selected>${rent.killometerType}</option>
				</c:if>
				<c:if
					test="${empty rent.killometerType or rent.killometerType != km}">
					<option value="${km}">${km}</option>
				</c:if>
			</c:forEach>
		</select>
	</div>
</div>
<c:if test="${not empty rent.id}">
	<div class="form-group col-sm-3">
		<label for="rent.createdAt" class='control-label'><fmt:message
				key="rent.createdAt" /></label>
		<div class="input-group col-sm-12">
			<input type="text" class="form-control" id="rent.createdAt"
				name='rent.createdAt' value="${rent.createdAt}">
		</div>
	</div>
</c:if>
