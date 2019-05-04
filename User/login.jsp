                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Student Helper - Login</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>

<c:import url="${student}/header.jsp"/>

  <%
     String msg= (String) session.getAttribute("msg");
     if (msg != null) {
  %>
    <div class="text-center" style="background-color:#ef4a4a;text-align: center;"><%=msg %></div>
  <% 
    session.removeAttribute("msg");} 
  %>

<form class="w3-container w3-border w3-round" style="width: 300px;margin: auto;margin-top: 20px;" action="Login" method="post">
  <h2 class="w3-text-blue">Sign up</h2>
  <p>
  <label class="w3-text-blue"><b>User name</b></label>
  <input class="w3-input w3-border" name="username" type="text"></p>
  <p>      
  <label class="w3-text-blue"><b>Password</b></label>
  <input class="w3-input w3-border" name="password" type="password"></p>
  <p>      
  <button class="w3-button w3-blue">Login</button></p>
</form>

<c:import url="${student}/footer.jsp"/>

</body>
</html>