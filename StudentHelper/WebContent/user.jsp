<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>Student Helper</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script> 
	$(function(){
	  $("#header").load("./pages/header.jsp"); 
	  $("#footer").load("./pages/footer.jsp"); 
	});
</script> 

<body>

<div id="header"></div>

<div id="content" style="background-color:#d7dbe2;padding-bottom: 10px;padding-top: 10px;">

<div class="row text-center border rounded col-md-8 offset-md-2 py-4 my-4" style ="background-color:white">
	<div class="col-sm-2">
		<img src="https://via.placeholder.com/200x200">
		<% String username= (String) session.getAttribute("username"); %>
		<h3><%=username %></h3>
	</div>
	<div class="col-sm-4">
		<p>Email address: </p>
	</div>
</div>

</div>

<div id="footer"></div>

</body>
</html>