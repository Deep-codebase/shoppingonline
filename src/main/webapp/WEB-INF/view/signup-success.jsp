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
<div class="container">

	<div class="row">
	
		
		<div class="col-sm-offset-4 col-sm-4">
			<div class="text-center">		
				<h1>Welcome!</h1>
				<h3>onlineshopping.com</h3>
				<h6>You can use your email address as username to login!</h6>
				<div>
					<a href="${contextRoot}/login" class="btn btn-lg btn-success">Login Here</a>
				</div>
			</div>
		</div>
	
	
	</div>
	

</div>	
</body>
</html>