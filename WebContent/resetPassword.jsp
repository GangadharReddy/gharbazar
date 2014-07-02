<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">


</script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css_files/productview.css" />
<link rel="stylesheet" type="text/css" href="css_files/formstyle.css" />
</head>
<body>
<div id="maindiv">
<div id="header" ><a href="homepage.jsp"><img src="images/logo1.gif" id="logo" alt="GharBazar.com"></a> 
</div>
<div id="hedderbelow"></div>
     <div id="left"></div>
     <div id="middle" >
     <div style="margin-left: 300px;">
<form action="/upadatePassword" method="post">
<div style="padding: 8px 25px; font-family: cursive;font-size: 20px;">Reset Password</div>
<div class="dynamiclabel">
	<input type="password" name="txtnewpassword" placeholder="Enter New Password">
	<label for="password">Enter New Password</label>
</div>
<div class="dynamiclabel">
	<input type="password" name="txtreset"placeholder="Re-Enter Password">
	<label for="txtreset">Re-Enter Password</label>
</div>
<divstyle="padding:5px 25px"><input type="submit" name="btnsubmit" value="Submit" class="button"></div>		
	<br>
</form>
</div>
 </div>
	<div id="right"></div>
	
	<div id="footerup"></div>
	<div id="footer" style="text-align: center;">All Rights Reserved &copy;&nbsp;2014</div>
	</div>
</body>
</html>