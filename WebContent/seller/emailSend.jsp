<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" type="text/css" href="css_files/formstyle.css" />
</head>
<body>
<div style="margin:30px; overflow: visible;">
	<form action="../EmailSendingServlet" method="post">
		<div style="padding: 8px 25px; font-family: cursive;font-size: 20px;">Forgot Password</div>
       	<div class="dynamiclabel">
			<input type="email" placeholder="Email Address" name="txtemailid">
			<label for="email">Email Address</label>
		</div>
		<div style="padding:5px 25px">
			<input type="submit" name="btnsubmit" value="Submit" class="button">
		</div>
	</form>
</div>
</body>
</html>