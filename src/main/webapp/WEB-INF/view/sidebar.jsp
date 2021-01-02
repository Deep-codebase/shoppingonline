<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<p class="lead">Shop Name</p>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/category?id=${category.id}" class="list-group-item" id="a_${category.name}">${category.name}</a>
	</c:forEach>
	 
</div>