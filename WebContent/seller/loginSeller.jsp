<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page language="java" import="javax.mail.Session;"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Login</title>
<link rel="stylesheet" type="text/css"
	href="../css_files/drop_down_menu.css" />


<link rel="stylesheet" href="../css_files/colorbox.css" />
<script src="../js_files/jquery.min.js"></script>
<script src="../js_files/jquery.colorbox.js"></script>
<link rel="stylesheet" type="text/css" href="../css_files/formstyle.css" />
<script>
	$(document)
			.ready(
					function() {
						//Examples of how to assign the Colorbox event to elements

						$(".ajax").colorbox();
		});
</script>
<script type="text/javascript">

function login() {
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	if(email==''&&password=='')
		{
		
		document.getElementById("warning").innerHTML="Email id and password can not be left blank";
		return false;
		
		}
	else if(email=='')
		{
		document.getElementById("warning").innerHTML="email can not be blank";
		return false;
		}
	else if(password=='')
		{
		document.getElementById("warning").innerHTML="password can not be blank";
		return false;
		}
	else
		{
		return true;
		}
	
	
}
function register()
{
	
	var fname=document.getElementById("idfname").value;
	var lname=document.getElementById("idlname").value;
	var email=document.getElementById("idemail").value;
	var password=document.getElementById("idpassword").value;
	var repassword=document.getElementById("idrepassword").value;
	var mobile=document.getElementById("idmobile").value;
	var pass=document.getElementsByName("txtpass")[0].value;
    
    var conpass=document.getElementsByName("txtconfirm_pass")[0].value;
    
   	if(fname=='')
		{
		document.getElementById("afname").innerHTML="First Name field can't be blank";
		return false;
		}
	else
		{
		document.getElementById("afname").innerHTML="";
	
		}
	if(lname=='')
		{
		document.getElementById("alname").innerHTML="Last Name field can't be blank";
		return false;
		}
	else
		{
		document.getElementById("alname").innerHTML="";
		}
	 if(email=='')
		{
		document.getElementById("aemail").innerHTML="Email field can't be blank";
		return false;
		}
	 else
		{
		document.getElementById("aemail").innerHTML="";
		}
	 if(password=='')
		{
		document.getElementById("apass").innerHTML="Password field can't be blank";
		return false;
		}
	 else
		{
		document.getElementById("apass").innerHTML="";
		}
	 if(pass!=conpass)
		{
		 document.getElementById("arepass").innerHTML="Re-enter password should be same";
		 return false;
	   	}
	else
		{
		 document.getElementById("arepass").innerHTML="";
		 
		}
	 if(mobile=='')
		{
		document.getElementById("amobile").innerHTML="Mobile Number field cann't be blank";
		return false;
		}
	 else
		 {
		 document.getElementById("amobile").innerHTML="";
		 }
	
	
	
	
	
		
	
}
</script>
</head>
<body>
<div style="text-align: right;margin-right: 20px;">
<% 
	String uname="";
	String reg;
	uname=(String)session.getAttribute("username");
	reg=(String)session.getAttribute("reg_id");
	if(uname!=null){
		%><a href="myaddservlet?myadd=true&regid=<%=reg%>">My Adds</a><%
		out.println(" Welcome   "+uname);%><a href="addPostservlet?logout=true"> Logout</a><% 	
				
	}
	else{
		
		out.println("Welcome Guest");%>
		+
		
		<% }%>  
</div>
	<div id="maindiv">

		<div id="header">
			<a href="../homepage.jsp"><img src="../images/logo1.gif" id="logo" alt="GharBazar.com"></a>
			
		</div>
		<div id="hedderbelow"></div>
		<div id="left1" style="height: 600px;">
			
			<div id="rightcontainer" >
				<div style="margin:30px; padding-left: 100px;">
				<br>
				<br><br>
					<form action="../addPostservlet?btnlogin=1" method="post">
					
						<div id="fontstyle" style="padding: 0px 25px">Seller Login</div>
						<div class="dynamiclabel">
							<input type="email" placeholder="Email Address" name="txtemail" id="email">
							<label for="email">Email Address</label>
							
						</div>
						<div class="dynamiclabel">
							<input type="password" placeholder="Password"	name="txtpassword" id="password"> 
							<label for="password">Password</label>
						</div>
						<label id="warning" style="padding: 5px 25px;"></label>
						<div style="padding: 5px 25px">
							<input type="submit" name="btnlogin" value="Login" class="button" onclick="return login();">
							<br> <br> <span	style="color: #0092DD; font-size: 18px; width:200px; height:40px; margin-left: -30px;"><br>
								<a class='ajax'  class="ahover" href="emailSend.jsp" title="GharBazar" style="text-decoration: none;">Forgot Your Password?</a>
							</span>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="right1" style="height: 600px;background:#F4FEED;">
			<div id="rightcontainer1" style="margin:6px; ">
				<form method="post" name="frmregistration" action="../registrationservlet" style="background:#F4FEED;">
					<div id="fontstyle" style="padding: 5px 25px">New Registration</div>
					<div style="font-size: 18px; color: blue; padding:3px 25px;font-family: cursive;">Enter Information Here:
					
					</div>
					
					<div class="dynamiclabel">
						<input placeholder="First Name" type="text" name="txtfname" id="idfname">
						<label for="fname">First Name</label>
						<a id="afname" style="color: red;font-size: 15px;"></a>
						
					</div>
					
					<div class="dynamiclabel">
						<input placeholder="Last Name" type="text" name="txtlname" id="idlname">
						<label for="lname">Last Name</label>
						<a id="alname" style="color: red;font-size: 15px;"></a>
					</div>
					<div class="dynamiclabel">
							<input type="email" placeholder="Email Address" name="txtemail" id="idemail">
							<label for="email">Email Address</label>
							<a id="aemail" style="color: red;font-size: 15px;"></a>
					</div>
					<div class="dynamiclabel">
							<input type="password" placeholder="Password"	name="txtpass" id="idpassword"> 
							<label for="password">Password</label>
							<a id="apass" style="color: red;font-size: 15px;"></a>
					</div>
					<div class="dynamiclabel">
							<input type="password" placeholder="Re-Enter Password"	name="txtconfirm_pass" id="idrepassword"> 
							<label for="password">Re-Enter Password</label>
							<a id="arepass" style="color: red;font-size: 15px;"></a>
							
					</div>
					
					<div class="dynamiclabel">
							<input type="tel" placeholder="Mobile Number" name="txtmobileno" id="idmobile">
							<label for="txtmobileno">Mobile Number</label>
							<a id="amobile" style="color: red;font-size: 15px;"></a>
					</div>
					<div class="dynamiclabel">
					<a  style="color: red;font-size: 20px;" id="mandatory"></a>
					
					</div>
					
					
					
					<div style="padding: 5px 25px">
							<input type="submit" name="btnsubmit" value="Submit" class="button" onclick="return register();">&nbsp;&nbsp;&nbsp;
							<input type="reset" name="btnreset" value="Reset" class="button">
					</div>
				</form>
			</div>
		</div>
		<div id="footerup"></div>
		<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>
	</div>
</body>
</html>