<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<style type="text/css">

</style>
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
<div id="maindiv">

  <form action="../maruadmintaru" class="login" method="post">
  
    <h1 style="border:200px;text-shadow: 0 -1px rgba(0, 0, 1, 0.3);background: rgba(200, 231, 255, 0.50); color:black;">Admin</h1>
    <input type="email" name="txtemail" class="login-input" placeholder="Email Address" autofocus>
    <input type="password" name="txtpassword" class="login-input" placeholder="Password">
    <center>
	<input type="submit" value="Login" name="btnlogin" class="login-submit">
    </center><p class="login-help"><a href="index.html">Forgot password?</a></p>
   
  </form>
  
  </div>
</body>
</html>