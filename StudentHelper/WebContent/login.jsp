<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

<div id="content" style="height:800px">

  <form class="border mt-5 mx-auto rounded p-3" style="width:300px" action="Login" method="post">

    <div class="form-group">
      <label for="loginUsername">User name</label>
      <input type="text" class="form-control" name="loginUsername" placeholder="Username">
    </div>
    <div class="form-group">
      <label for="loginPassword">Password</label>
      <input type="password" class="form-control" name="loginPassword" placeholder="Password">
    </div>

    <button type="submit" class="btn btn-primary my-2">Login</button>
  </form>
  
</div>

<div id="footer"></div>

</body>
