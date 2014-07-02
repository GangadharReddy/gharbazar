<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css_files/drop_down_menu.css" />

		
		<link rel="stylesheet" href="css_files/colorbox.css" />
		<script src="js_files/jquery.min.js"></script>
		<script src="js_files/jquery.colorbox.js"></script>
		<script>
			$(document).ready(function(){
				//Examples of how to assign the Colorbox event to elements
				$(".ajax").colorbox();
			});
		</script>
</head>
<body>
<div id="maindiv">

    <div id="header" ><a href="./homepage.jsp"><img src="./images/logo1.gif" id="logo" alt="GharBazar.com"></a> 
          
     </div>
<div id="hedderbelow"></div>
<div id="middle1">
<br>
<center><h1>You are already registered..</h1><h2>You can perform<br> 
<a class='ajax' href="seller/emailSend.jsp" title="GharBazar">Forgot Password</a><br>
OR<br><a href="seller/loginSeller.jsp">Login</a></h2></center>
</div>
	<div id="footerup"></div>
	<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>
		</div>
</body>
</html>