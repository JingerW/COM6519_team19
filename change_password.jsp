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

  <form class="border mt-5 mx-auto rounded p-3" style="width:300px" action="ChangePassword" method="post">

    <div class="form-group">
      <label for="oldpassword">Old password</label>
      <input type="text" class="form-control" name="oldpassword" placeholder="Username">
    </div>
    <div class="form-group">
      <label for="newpassword">New password</label>
      <input type="password" class="form-control" name="newpassword" placeholder="Password">
    </div>
        <div class="form-group">
      <label for="newpasswordConfirm">Confirm new password</label>
      <input type="password" class="form-control" name="newpasswordConfirm" placeholder="Password">
    </div>

    <button type="submit" class="btn btn-primary my-2">Submit</button>
  </form>
  
</div>

<div id="footer"> <%@ include file="./pages/footer.jsp" %> </div>

</body>
