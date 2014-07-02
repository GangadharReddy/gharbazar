<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css_files/drop_down_menu.css" />
<title>Untitled Document</title>
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
</head>
<body>
<div style="text-align: right;margin-right: 20px;">
<% 
	String uname="";
	String reg;
	uname=(String)session.getAttribute("username");
	reg=(String)session.getAttribute("reg_id");
	if(uname!=null){
		%><a href="./myadds/homemyadd.jsp">My Adds</a><%
		out.println(" Welcome   "+uname);%><a href="addPostservlet?logout=true"> Logout</a><% 	
				
	}
	else{
		
		out.println("Welcome Guest");%><a href="seller/loginSeller.jsp"> Login </a>
		
		<% }%>
</div>
<div id="maindiv">
<form name="main" action="../addPostservlet" method="post">
    <div id="header" >
    <a href="./homepage.jsp"><img src="./images/logo1.gif" id="logo" alt="GharBazar.com"></a> 
	     
     </div>
     <div id="hedderbelow"></div>
     <div id="left"></div>
     <div id="middle">
     <h1 style="color:blue; text-align: center;"><b>Select Category to Post</b></h1>
     <table cellpadding="8" vspace="2%" align="center"  width="200" border="0" cellspacing="0" >
  <tr>
    <td><ul class="menuH decor1">

    <li><a class="arrow" href="addPostservlet?health=<%=reg%>">Home and Life Sytle</a>
      
    </li>
</ul>
  <img src="images/electronics and technology/images.jpg" height="150" width="200" /> </ul></td>
    <td>
	<ul class="menuH decor1">

    <li><a href="addPostservlet?mobile=<%=reg%>" class="arrow">Mobiles</a>
            
    </li>
    
</ul>
  <img src="images/mobile/1.jpg" height="150" width="200" /> </ul></td>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Jobs and Services</a>
       
    </li>
</ul>
  <img src="images/jobs/images (3).jpg" height="150" width="200" /> </ul></td>
  </tr>
  <tr>
    <td><ul class="menuH decor1">

    <li><a href="addPostservlet?vehicle=<%=reg%>" class="arrow">Vehicles</a>
     
    </li>
</ul>
  <img src="images/vehicles/images (2).jpg" height="150" width="200" /> </ul></td>
    <td>
	<ul class="menuH decor1">

    <li><a href="addPostservlet?electronics=<%=reg%>" class="arrow">Electronics</a>
       
    </li>
</ul>
  <img src="images/electronics and technology/images (5).jpg" height="150" width="200" /> </ul></td>
    <td><ul class="menuH decor1">

    <li><a href="addPostservlet?realestate=<%=reg %>" class="arrow">Real Estate</a>
       
    </li>
</ul>
  <img src="images/real estate/images (3).jpg" height="150" width="200" /> </ul></td>
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