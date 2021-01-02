<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home">Online
				Shopping</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="about"><a href="${contextRoot}/about">About</a></li>

				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>

				<li id="listProducts"><a href="${contextRoot}/showallProducts">View
						Products</a>
				</li>
				<sec:authorize access="hasRole('ADMIN')">
					<li id="manageProduct"><a href="${contextRoot}/manageproduct">Manage
							Product</a>
					</li>
						
				</sec:authorize>
				<li style="padding: 16px;">
						<form class="form-inline">
							<input class="form-control mr-sm-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="/searchproduct">Search</button>
								
						</form>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAnonymous()">
					<li id="signup"><a href="${contextRoot}/membership">Sign
							Up</a></li>
					<li id="login"><a href="${contextRoot}/login">Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="dropdown" id="userModel"><a
						class="btn btn-default dropdown-toggle" href="javascript:void(0)"
						id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="true"> ${userModel.fullName} <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<sec:authorize access="hasRole('USER')">
								<li id="cart"><a href="${contextRoot}/showCart"> <span
										class="glyphicon glyphicon-shopping-cart"></span>&#160;<span
										class="badge">${userModel.cart.cartLines}</span> - &#8377;
										${userModel.cart.grandTotal}
								</a></li>
								<li role="separator" class="divider"></li>
							</sec:authorize>
							<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
						</ul></li>
				</sec:authorize>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
<script>
	window.userRole = '${userModel.role}'
</script>
