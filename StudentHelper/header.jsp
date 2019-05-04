<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
#navi{
	background-color:#4e80d4;
	color:white;
	position: relative;
	overflow: hidden;
}

#nav-title {
	float:none;
	position:absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	font-size: x-large;
}
</style>

<div class="w3-bar" id="navi">

	<!-- left navi item -->
	<a class="w3-bar-item w3-button w3-hover-black" href="${url}/StudentHelper/"><i class="fa fa-home"></i>Home</a>
    <a class="w3-bar-item w3-button w3-hover-black" href="#"><i class="fab fa-app-store-ios"></i>Application</a>
    
    <!-- centre title -->
    <span class="w3-bar-item" id="nav-title">Student Helper</span>
    
    <!-- right nac item -->
    <a class="w3-bar-item w3-button w3-right w3-hover-black" href="${url}/User/">Login</a>
    <a class="w3-bar-item w3-button w3-right w3-hover-black" href="${url}/User/signup.jsp">Sign up</a>
    
</div>
