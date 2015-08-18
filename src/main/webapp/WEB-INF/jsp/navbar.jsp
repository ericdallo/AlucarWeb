<link href='<c:url value="/css/navbar.css"/>' rel="stylesheet">
<nav class="navbar navbar-main navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
				<span class="sr-only">Navegação</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="<c:url value="home"/>"><img alt="Alucar-logo" src="<c:url value="/images/logo-navbar.png" />" class="pull-left logo"/></a>
			<a class="navbar-brand" href="<c:url value="home"/>"> Alucar</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active">
					<a href="<c:url value="clientes"/>" class="nav-link"><fmt:message key="navbar.client" />
						<span class="sr-only">Atual</span>
					</a>
				</li>
				<li class="active">
					<a href="<c:url value="automoveis"/>" class="nav-link"><fmt:message key="navbar.car" />
						<span class="sr-only">Atual</span>
					</a>
				</li>
				<li class="active">
					<a href="<c:url value="locacoes"/>" class="nav-link"><fmt:message key="navbar.location" />
						<span class="sr-only">Atual</span>
					</a>
				</li>
				<li class="active">
					<a href=<c:url value="devolucoes"/>#" class="nav-link"><fmt:message key="navbar.devolution" />
						<span class="sr-only">Atual</span>
					</a>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<fmt:message key="navbar.account" />
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#"><fmt:message key="navbar.change.language" /></a></li>
						<li><a href="#"><fmt:message key="navbar.change.password" /></a></li>
						<li class="divider"></li>
						<li><form action="<c:url value="logout"/>" method="POST">
							<input type='submit' value="<fmt:message key="navbar.logout"/>" class="logout"/>
						</form>
						</li>
					</ul>
				</li>
			</ul>
			<form class="navbar-form navbar-right search-form" action="">
				<input type="text" class="form-control" placeholder="Pesquisar..." />
			</form>
		</div>
	</div>
</nav>