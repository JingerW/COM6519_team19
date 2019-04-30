<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="navbar navbar-expand-md navbar-light justify-content-between text-white" style="background-color:#4e80d4;">

	<div class="collapse navbar-collapse col-sm-2 offset-sm-1" id="navbar-left">	
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link text-white" href="index.jsp" >Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-white" href="#" >Applications</a>
			</li>
			<%
            	String username= (String) session.getAttribute("username");
            	if (username != null) {
        	%>
     		<li class="nav-item">
				<a class="nav-link text-white" href="user.jsp" >User Account</a>
			</li>
			<% }%>
		</ul>
	</div>
	<h3 class="col-sm-auto">Student Helper</h3>
	<div class="collapse navbar-collapse d-flex justify-content-end col-sm-3" id="navbar-right">	
		
	    <%
            if (username == null) {
        %>
            <ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link text-white" href="signup.jsp" >Sign up</a>
				</li>
				<li class="nav-item">
					<a class="nav-link text-white" href="login.jsp" >Login</a>
				</li>
			</ul>
		<% } else { %>
			<span>Hi, <%=username %></span> 
			<ul class="navbar-nav"> 
	           	<li class="nav-item">
	           		<a class="nav-link text-white" href="logout.jsp">Logout</a>
	           	</li>
            </ul>
       	<% }%>
		
		<div class="col-sm-4"></div>
	</div>	
</nav>
