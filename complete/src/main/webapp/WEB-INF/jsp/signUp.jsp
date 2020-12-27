<html>
<title>Sign Up</title>
<body>
<h1>Sign Up Here..!!!</h1>
<h2>Enter User Details</h2>
</body>
	<form:form method="post" action="/saveLogin" modelAttribute="login">
	  <table border="0" cellpadding="10">
	      <tr>
	          <td>UserName:</td>
	          <td><input type="text" name="username" /></td>
	          <tr>
	          <td>Password:</td>
	          <td><input type="password" name="password" /></td>
	          </tr>
	      </tr>                            
	      <tr>
	          <td colspan="8"><input type="submit" action="/submit"/> 
	          <input type="reset" value="Reset"  /> 
	          <font color="blue">${successMessage}</font></td>
	     	
	      </tr>
	  </table>
  </form:form>

</html>