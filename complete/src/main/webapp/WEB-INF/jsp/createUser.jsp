<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Sign Up</title>
<body>
	<h1>Sign Up Here..!!!</h1>
	<h2>Enter User Details</h2>
</body>
<script>
function validateForm() {
	  var x = document.forms["userForm"]["firstname"].value;
	  var y= document.forms["userForm"]["lastname"].value;
	  if (x == "" || x.length>25) {
	    alert("First Name should be filled and lengh must be less than 25 characters ");
	    return false;
	  }else if(y==""){
		alert("Last Name Should be NOT Empty")  
		return false;
	  }
	  
	}
</script>
<form:form method="post" name="userForm" action="/saveUser" onsubmit="return validateForm()" modelAttribute="user">
	<table border="0" cellpadding="10" align="center">
		<tr>
			<td>UserName:</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstname" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastname" /></td>
		</tr>
		
		<tr>
			<td colspan="8"><input type="submit" name="Create User" /> <input
				type="reset" value="Reset" /> <font color="blue">${message}</font></td>

		</tr>
	</table>
</form:form>

</html>