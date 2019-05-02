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

<body>

<div id="header"> <%@ include file="./pages/header.jsp" %> </div>

<div id="content" style="height:800px">

  <%
     String msg= (String) session.getAttribute("msg");
     if (msg != null) {
  %>
  <div class="text-center" style="background-color:#ef4a4a"><%=msg %></div>
  <% 
    session.removeAttribute("msg");} 
  %>

  <form class="border mt-5 mx-auto rounded p-3" style="width:300px" action="Signup" method="post">

	<div class="form-group">
      <label for="signupUsername">Username</label>
      <input type="text" class="form-control" name="signupUsername" placeholder="Create username">
    </div>
    <div class="form-group">
      <label for="signupEmailaddress">Email address</label>
      <input type="email" class="form-control" name="signupEmailAddress" aria-describedby="emailHelp" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="signupPassword">Password</label>
      <input type="password" class="form-control" name="signupPassword" placeholder="Password">
    </div>
    <div class="form-group">
      <label for="signupPasswordConfirm">Password confirm</label>
      <input type="password" class="form-control" name="signupPasswordConfirm" placeholder="Password confirm">
    </div>

    <button type="submit" class="btn btn-primary my-2">Signup</button>
  </form>
  
</div>

<div id="footer"> <%@ include file="./pages/footer.jsp" %> </div>

</body>
