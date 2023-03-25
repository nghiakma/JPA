<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>JSP Page</title>
<base href="/demojpa4/" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<main class="container">
	    <div class="row">
	  <div class="col">
	    <c:if test="${not empty message}">
	    <div class="alert alert-success">${message }</div>
	    </c:if>
	    <c:if test="${not empty error}">
	    <div class="alert alert-danger">${error }</div>
	    </c:if>
	  </div>
	</div>
		<div class="row">
			<div class="col">
				<form action="UserServlet" method="post">
					<div class="form-group">
						<label for="userid">User ID:</label> <input type="text"
							name="userid" id="userid" class="form-control" value="${user.userid}" /><br />
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							name="password" id="password" class="form-control" /><br />
					</div>
					<div class="form-group">
						<label for="fullname">Fullname:</label> <input type="text"
							name="fullname" id="fullname" class="form-control" value="${user.fullname}"/><br />
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text" name="email"
							id="email" class="form-control" value="${user.email}"/><br />
					</div>
					<div class="form-group">
					<div class="form-check form-check-inline">

						<input class="form-check-input" type="radio" name="admin"
							id="admin" value="true" ${user.admin? 'checked':'' }> <label class="form-check-label" for="admin">
							Admin </label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="admin"
							id="user" ${! user.admin? 'checked':'' }> <label class="form-check-label"
							for="user"> User </label>
							
					</div>
					
					</div>
					<div class="form-group">
					<br />
					 <button class="btn btn-primary" formaction="UserServlet/create">Create</button>
					 <button class="btn btn-warning" formaction="UserServlet/update">Update</button>
					 <button class="btn btn-danger" formaction="UserServlet/delete">Delete</button>
					 <button class="btn btn-info" formaction="UserServlet/reset">Reset</button>
					 
					</div>
				</form>
			</div>
		</div>
		<div class="row">
		<div class="col">
		<p>So luong </p>
		       <p>${Count}</p>
		</div>
		</div>
		
		
		<div class="row">
		<br />
		<div class="col">
		  <table class="table table-bordered">
		  <thead>
		     <tr>
		     	<th>User Id</th>
		     	<th>Fullname</th>
		     	<th>Password</th>
		     	<th>Email</th>
		     	<th>Role</th>
		     
		     </tr>
		     </thead>
		     <tbody>
		     <c:forEach var="item" items="${List_User}">
		     <tr>
		     	<td>${item.userid }</td>
		     	<td>${item.fullname }</td>
		     	<td>${item.password }</td>
		     	<td>${item.email }</td>
		     	<td>${item.admin? 'Admin':'User'}</td>
		     	<td>
		     	 <a href="UserServlet/edit?userid=${item.userid }">Edit</a>
		     	 <a href="UserServlet/delete?userid=${item.userid }">Delete</a>
		     	</td>
		     </tr>
		 </c:forEach>
		     </tbody>
		     
		  </table>
		</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>
