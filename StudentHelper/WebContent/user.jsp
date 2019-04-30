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

<body>

<div id="header"> <%@ include file="./pages/header.jsp" %> </div>

<div id="content" style="background-color:#d7dbe2;padding-bottom: 10px;padding-top: 10px;">

<div class="row text-center border rounded col-md-8 offset-md-2 py-4 my-4" style ="background-color:white">
	<div class="col-sm-2">
		<img src="https://via.placeholder.com/200x200">
		<% String user = (String) session.getAttribute("username"); %>
		<h3><%=user %></h3>
	</div>
	<div class="col-sm-4">
		<% String email = (String) session.getAttribute("useremail"); %>
		<p>Email address: <%=email %></p>
		<a class="btn btn-primary" href="change_password.jsp" role="button">Change password</a>
	</div>
	<div class="col-sm-4">
		<% int balance = (int) session.getAttribute("balance"); %>
		<p>Balance remain in peanut bank: <%=balance %> peanut</p>
		<a class="btn btn-primary" href="topup.jsp" role="button">Top up</a>
	</div>

</div>

</div>

<div id="footer"> <%@ include file="./pages/footer.jsp" %> </div>

</body>
</html>