<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">

<head>


<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="css/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="css/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="css/myapp.css" rel="stylesheet">

</head>

<body>
	<script>
		window.menu = '${title}';

		window.contextRoot = '${contextRoot}'
	</script>

	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>

		<!-- Page Content -->

		<div class="content">

			<div style="background-color:#337ab7;height:50px;"></div>
	<div class="container-fluid">
		<div class="row col-lg-4 col-lg-offset-4" style="margin-top: 80px;background-color:#fff;padding:20px;border:solid 1px #ddd;">
			<!-- <img th:src="@{/images/login.jpg}" class="img-responsive center-block" width="300" height="300" alt="Logo" /> -->
			<form action="/login" method="POST" class="form-signin">
				<h3 class="form-signin-heading">Login</h3>
				<br /> <input type="text" id="email" name="email"  class="form-control" /> <br /> <input type="password"  id="password" name="password" class="form-control" /> <br />
				<c:if test="${param.error!=null}">
				<div align="center">
					<p style="font-size: 20; color: #FF1C19;">Email or Password is invalid.</p>
				</div>
				</c:if>
				<button class="btn btn-lg btn-primary" name="Submit" value="Login" type="Submit" style="margin-right:10px;">Login</button>
				<a href="/recover-password">Forgot password?</a>
			</form>
		</div>
	</div>


		</div>
		<!-- jQuery -->
		<script src="js/jquery.js"></script>

		<script src="js/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>

		<!-- Self coded javascript -->
		<script src="js/myapp.js"></script>

	</div>

</body>

</html>