<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	$(document)
			.ready(
					function() {
						//Examples of how to assign the Colorbox event to elements

						$(".ajax").colorbox();
		});
</script>
<title>Untitled Document</title>
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
		
		out.println("Welcome Guest");%><a href="seller/loginSeller.jsp"> Login </a>
		
		<% }%>  
</div>
<div id="maindiv">
<form name="main" action="fileuploadservlet">
  
    <div id="header" ><a href="homepage.jsp"><img src="images/logo1.gif" id="logo" alt="GharBazar.com"></a> 
    <%
    if(uname!=null){%>
    	<a href="addPostservlet?post=<%=uname%>
    	" class="myButton">Post Your Ads Here
    		     <span class="ina-free-flag">Free</span>
    		     </a> <%    
    		     	
    }
    else{
    	%>
    	<a href="seller/loginSeller.jsp" class="myButton">Post Your Ads Here
    		     <span class="ina-free-flag">Free</span>
    		     </a> <%   
    }
    %>
    
     </div>
<div id="hedderbelow"></div>
     <div id="left"></div>
     <div id="middle">
     <br><br>
     <table cellpadding="8" vspace="2%" align="center"  width="200" border="0" cellspacing="0" >
  <tr>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Home and Life Sytle</a>
        <ul>
            <li><a href="healthservlet?health=true" >Health and Beauty Fitness</a></li>
            <li><a href="healthservlet?therapy=true">Therapy</a></li>
            <li><a href="healthservlet?doctor=true">Doctor's Details</a></li>
            <li><a href="healthservlet?babysitter=true">Babysitter</a></li>
            
        </ul>
    </li>
</ul>
  <img src="images/electronics and technology/images.jpg" height="150" width="200" /> </td>
    <td>
	<ul class="menuH decor1">

    <li><a href="#2" class="arrow">Mobiles</a>
        <ul>
        	
            <li><a href="fileuploadservlet?mobile=true">Mobiles</a></li>
            <li><a href="fileuploadservlet?mobileaccessories=true">Mobile Accessories</a></ul>
            
    </li>
    
</ul>
  <img src="images/mobile/1.jpg" height="150" width="200" /> </ul></td>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Jobs and Services</a>
        <ul>
            <li><a href="fileuploadservlet?jobseeker=true">Job Seeker</a></li>
            <li><a href="fileuploadservlet?emprectuiter=true">Employee Recruiter</a></li>
            <li><a href="fileuploadservlet?services=true">Services (Consultants)</a></li>
        </ul>
    </li>
</ul>
  <img src="images/jobs/images (3).jpg" height="150" width="200" /> </ul></td>
  </tr>
  <tr>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Vehicles</a>
        <ul>
            <li><a href="vehicleservlet?vehicles=true">Vehicles</a></li>
            <li><a href="vehicleservlet?vehicleaccessories=true">Vehicle Accessories</a></li>
        </ul>
    </li>
</ul>
  <img src="images/vehicles/images (2).jpg" height="150" width="200" /></td>
    <td>
	<ul class="menuH decor1">

    <li><a href="#2" class="arrow">Electronics</a>
        <ul>
            <li><a href="vehicleservlet?itperipherals=true">IT Peripherals</a></li>
            <li><a href="vehicleservlet?tcm=true">TV, Camera & Multimedia</a></li>
            <li><a href="vehicleservlet?homeapp=true">Home Appliances</a></li>
            <li><a href="vehicleservlet?industrial=true">Industrial Machinery Tools</a></li>
            <li><a href="vehicleservlet?ele_others=tue">Others</a></li>
        </ul>
    </li>
</ul>
  <img src="images/electronics and technology/images (5).jpg" height="150" width="200" /> </td>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Real Estate</a>
        <ul>
            <li><a href="realestateservlet?rent=true">Rent</a></li>
            <li><a href="realestateservlet?buy=true">Buy</a></li>
        </ul>
    </li>
</ul>
  <img src="images/real estate/images (3).jpg" height="150" width="200" /></td>
  </tr>
</table>
     
     </div>
	<div id="right"></div>
	
	<div id="footerup"></div>
	<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>
  
</form>
</div>
</body>
</html>