<%@page import="org.apache.catalina.tribes.membership.StaticMember"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="daolayers.databaseconnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.statebean"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="daolayers.sellerservice"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ResultSet cityresult=null; %>
<%sellerservice service=new sellerservice(); %>
<%statebean state=new statebean();%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css_files/style.css" />
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
<script type="text/javascript">
function validation(thisform)
{
   with(thisform)
   {
      if(validateFileExtension(file, "valid_msg", "pdf/office/image files are only allowed!",
      new Array("jpg","pdf","jpeg","gif","png","doc","docx","xls","xlsx","ppt","txt")) == false)
      {
         return false;
      }
      if(validateFileSize(file,1048576, "valid_msg", "Document size should be less than 1MB !")==false)
      {
         return false;
      }
   }
}
function validateFileExtension(component,msg_id,msg,extns)
{
   var flag=0;
   with(component)
   {
      var ext=value.substring(value.lastIndexOf('.')+1);
      for(i=0;i<extns.length;i++)
      {
         if(ext==extns[i])
         {
            flag=0;
            break;
         }
         else
         {
            flag=1;
         }
      }
      if(flag!=0)
      {
         document.getElementById(msg_id).innerHTML=msg;
         component.value="";
         component.style.backgroundColor="#eab1b1";
         component.style.border="thin solid #000000";
         component.focus();
         return false;
      }
      else
      {
         return true;
      }
   }
}

function validateFileSize(component,maxSize,msg_id,msg)
{
   if(navigator.appName=="Microsoft Internet Explorer")
   {
      if(component.value)
      {
         var oas=new ActiveXObject("Scripting.FileSystemObject");
         var e=oas.getFile(component.value);
         var size=e.size;
      }
   }
   else
   {
      if(component.files[0]!=undefined)
      {
         size = component.files[0].size;
      }
   }
   if(size!=undefined && size>maxSize)
   {
      document.getElementById(msg_id).innerHTML=msg;
      component.value="";
      component.style.backgroundColor="#eab1b1";
      component.style.border="thin solid #000000";
      component.focus();
      return false;
   }
   else
   {
      return true;
   }
}

function fun1()
{
	
	var category=document.getElementById("txtcategory").value;
	var subcategory=document.getElementById("txtsubcategory").value;
	var title=document.getElementById("txttitle").value;
	var model=document.getElementById("txtmodel").value;
	var year=document.getElementById("txtyear").value;
	var price=document.getElementById("idtxtprice").value;
	var mobile=document.getElementById("txtcontactno").value;
	var state=document.getElementById("idtxtstate").value;
	var city=document.getElementById("idtxtcity").value;
	
	if(category=="")
	{
	document.getElementById("acategory").innerHTML="Please Select a Category";
	return false;
	}
else
	{
	document.getElementById("acategory").innerHTML="";
	}
	if(subcategory=="")
	{
	document.getElementById("asubcategory").innerHTML="Please Select a Category";
	return false;
	}
else
	{
	document.getElementById("asubcategory").innerHTML="";
	}
	if(title=="")
	{
	document.getElementById("atitle").innerHTML="Please Specify a title";
	return false;
	}
 else
	 {
	 document.getElementById("atitle").innerHTML="";
	 }
	if(model=="")
	{
	document.getElementById("amodel").innerHTML="please specify mobile model: eg(Bajaj discover)";
	return false;
	}
else
	{
	document.getElementById("amodel").innerHTML="";
	}
	if(year=="")
	{
	document.getElementById("ayear").innerHTML="please specify year Eg: 2014";
	return false;
	}
	else
	{
	document.getElementById("ayear").innerHTML="";
	}
	if(price=="")
	{
	document.getElementById("aprice").innerHTML="Please Specify the price";
	return false;
	}
	else
	 {
	 document.getElementById("aprice").innerHTML="";	 
	 }
	var detail=document.getElementById("idtxtdetail").value;
	if(detail=="")
	{
	document.getElementById("adetails").innerHTML="Please Explain Some Details";
	return false;
	}
else
 {
 document.getElementById("adetails").innerHTML="";
 }
	if(mobile=="")
		{
			document.getElementById("amobile").innerHTML="please give some mobile number";
			return false;
		}
	else
		{
		document.getElementById("amobile").innerHTML="";
		}
	if(state=="Select State")
		{
		document.getElementById("astate").innerHTML="please select a state";
		return false;
		}
	else
		{
		document.getElementById("astate").innerHTML="";
		}
	if(city=="")
		{
		document.getElementById("acity").innerHTML="please speicify a city";
		return false;
		}
	else
		{
		document.getElementById("acity").innerHTML="";
		}

	

	

	
	
	
	
	return true;
}



</script>
</head>
<body>
<div style="margin-right: 20px;text-align: right;">
<% 
	String uname="";
	String reg;
	uname=(String)session.getAttribute("username");
	reg=(String)session.getAttribute("reg_id");
	if(uname!=null){
		%><a href="fileuploadservlet?btnmobile=true&regid=<%=reg%>">My Adds</a><%
		out.println(" Welcome   "+uname);%><a href="addPostservlet?logout=true"> Logout</a><% 	
				
	}
	else{
		
		out.println("Welcome Guest");%><a href="seller/loginSeller.jsp"> Login </a>
		
		<% }%> 
		</div>
<div id="header" ><a href="./homepage.jsp"><img src="./images/logo1.gif" id="logo" alt="GharBazar.com"></a> 
          
     </div>
<div id="hedderbelow"></div>
<div id="middle">		
		<div class="wrapper">
		<div id="main" style="padding:10px 0 0 0;">
		
<form id="contact-form" action="./fileuploadservlet?vehicle=<%=reg%>" method="post" enctype="multipart/form-data" onsubmit="return validation(this)">
	<div style="text-align: center;"><h1>
		<label>Vehicles</label></h1>
		</div>
		
    <%List<statebean> l1=new ArrayList();
    l1=(List)request.getAttribute("state"); %>
   
   <div>
   	<label>
   		<span>Select Category</span>
   		<select name="sltmodel" id="txtcategory">
        	<option></option>
   			<option>Vehicles</option>
  			<option>VehicleAccessories</option>
  		</select>
  		<a id="acategory" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div>
   <div>
   	<label>
   		<span>Select Sub Category</span>
   		<select name="rentsell" id="txtsubcategory" >
        	<option></option>
   			<option>Rent</option>
  			<option>Sell</option>
  		</select>
  		<a id="asubcategory" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div>
   <div>
   	<label>
   		<span>Title</span>
   		<input type="text" id="txttitle" name="txttitle" />
   		<a id="atitle" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div>
   <div>
   	<label>
   		<span>Model</span>
   		<input type="text" id="txtmodel" name="txtmodelname" />
   		<a id="amodel" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div>
   <div>
   	<label>
   		<span>Year</span>
   		<input type="text" id="txtyear" name="txtyear" />
   		<a id="ayear" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div>
   <div>
   <label>
   	<span>Price</span>
   	<input type="text" id="idtxtprice" name="txtprice" />
   	<a id="aprice" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   </label>
   </div>
   <div>
  	<label>
  		<span>Details</span>
  		<textarea id="idtxtdetail" style="resize:none;"name="txtdetails"></textarea>
  		<a id="adetails" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
  	</label>
   </div>
   <div>
   	<label>
   		<span>Mobile Number</span>
   		<input type="text" id="txtcontactno" name="txtcontactno" />
   		<a id="amobile" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div>
   <div>
   	<label>
   		<span>State</span>
   		<select name="txtstate" id="idtxtstate">
	 <option selected="selected">Select State</option>
	 <%
	 int i;
    for(i=0;i<l1.size();i++)
    {
    	statebean c1=new statebean();
		c1=l1.get(i);  
	%>
		<option><%=c1.getState() %></option>
		
	<%}%>
	</select>
	<a id="astate" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div> 
   <div>
   	<label>
   		<span>City</span>
   		<input type="text" name="txtcity" id="idtxtcity">
   		<a id="acity" style="color: red;padding-left: 10px;font-weight: bold;" ></a>
   	</label>
   </div>
   <div>
   	<label>
   		<span>Image Link</span>
   		<input type="file" name="file">
   		<a id="valid_msg"></a>
   	</label>
   </div>
   <div><center>
   	<input type="submit" name="btnvehicle" value="Submit" onclick="return fun1();">
   	<input type="reset" value="Reset"></center>
   </div>
    
</form>
</div>
	</div>
	
</div>
<div id="footerup"></div>
	<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>


</body>
</html>