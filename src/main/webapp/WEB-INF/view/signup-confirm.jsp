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
<%@include file="navbar.jsp" %>
<div class="container">
	
	<div class="row">
	
		<div class="col-sm-6">
	
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
						<h3>Name : <strong>${usermodel.firstName} ${registerModel.user.lastName}</strong></h3>
						<h4>Email : <strong>${usermodel.email}</strong></h4>
						<h4>Contact : <strong>${usermodel.contactNumber}</strong></h4>
						<h4>Role : <strong>${usermodel.role}</strong></h4>
						<p>
							<%-- <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a> --%>
						</p>
					</div>
				</div>
			
			</div>
					
		
		</div>
		
		<div class="col-sm-6">
		
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
						<p>${usermodel.adresslist[0].addressLineOne}, </p>
						<p>${usermodel.adresslist[0].addressLineTwo}, </p>
						<p>${usermodel.adresslist[0].city} -  ${usermodel.adresslist[0].postalCode}, </p>
						<p>${usermodel.adresslist[0].state}</p>
						<p>${usermodel.adresslist[0].country}</p>
						
					</div>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
			
			<div class="text-center">
				
				<a href="/saveUser" class="btn btn-lg btn-primary">Confirm</a>
				
			</div>
			
		</div>
		
	</div>

</div>
</body>
</html>