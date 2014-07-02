<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function passvalid() {
		var a=document.getElementsByName("txtfname")[0].value;
		
		var pass=document.getElementsByName("txtpass")[0].value;
       
        var conpass=document.getElementsByName("txtconfirm_pass")[0].value;
        if(pass!=conpass)
        	{
        		alert("not match");
        	}
		
	}
</script>
</head>
<body>
<form method="post" name="frmregistration" action="..\registrationservlet">
      <center>
        <table border="1" cellpadding="5" width="30%">
          <thead>
            <tr>
              <th colspan="2">Enter Information Here</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>First Name</td>
              <td><input name="txtfname" value="" type="text"></td>
            </tr>
            <tr>
              <td>Last Name</td>
              <td><input name="txtlname" value="" type="text"></td>
            </tr>
            <tr>
              <td>Email</td>
              <td><input name="txtemail" value="" type="email"></td>
            </tr>
            <tr>
              <td>Mobile No.</td>
              <td><input name="txtmobileno" value="" type="tel"></td>
            </tr>
            <tr>
              <td>Password</td>
              <td><input name="txtpass"  type="password"></td>
            </tr>
            <tr>
            </tr>
            <tr>
              <td>Re-Enter Password</td>
              <td><input name="txtconfirm_pass" value="" type="password"></td>
            </tr>
            <tr>
              <td><input name="btnsubmit" value="Submit" type="submit" onClick="passvalid();"></td>
              <td><input value="Reset" type="reset"></td>
            </tr>
            <tr>
              <td colspan="2">Already registered!! <a href="index.jsp">Login
                  Here</a></td>
            </tr>
            <tr>
              <td colspan="2"><input type="submit" name="btnViewRegistration" value="View Registration"/></td>
              
              
            </tr>
          </tbody>
        </table>
      </center>
    </form>
</body>
</html>