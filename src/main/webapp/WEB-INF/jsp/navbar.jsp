<link href='<c:url value="/css/navbar.css"/>' rel="stylesheet">
<nav class="navbar navbar-main">
	<div class="container">
		<div class="navbar-header">
			<a href="<c:url value="/home"/>">
				<img alt="Alucar-logo" src="<c:url value='/images/logo-navbar.png' />" class="pull-left logo"/>
			</a>
			<a class="navbar-brand" href="<c:url value='/home'/>">Alucar</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown" role="button" aria-expanded="false">
						<fmt:message key="navbar.client" />
						<span class='caret'></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<c:if test="${loggedUser.supervisor == true}">
							<li><a href="<c:url value='/cliente'/>"><fmt:message key="navbar.client.add" /></a></li>	
						</c:if>
						<li><a href="<c:url value='/clientes'/>"><fmt:message key="navbar.client.search" /></a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown" role="button" aria-expanded="false">
						<fmt:message key="navbar.car" />
						<span class='caret'></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<c:if test="${loggedUser.supervisor == true}">
							<li><a href="<c:url value='/automovel'/>"><fmt:message key="navbar.car.add" /></a></li>
						</c:if>
						<li><a href="<c:url value='/automoveis'/>"><fmt:message key="navbar.car.search" /></a></li>
					</ul>
				</li>
				<li class="active">
					<a href="<c:url value="/locacoes"/>" class="nav-link">
						<fmt:message key="navbar.location" />
					</a>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown" role="button" aria-expanded="false">
						<fmt:message key="navbar.account" />
						<span class='caret'></span>
					</a>
					<ul class="dropdown-menu" role="menu">						
						<li><form action="<c:url value="/logout"/>" method="POST">
							<input type='submit' value="<fmt:message key="navbar.logout"/>" class="logout"/>
						</form>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>