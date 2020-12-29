<html>
<head>
<title>First Web Application</title>
</head>
<script>
function validateForm() {
	  var x = document.forms["loginForm"]["name"].value;
	  var y= document.forms["loginForm"]["password"].value;
	  if (x == "" || x.length>25) {
	    alert("UserName Should Not Be Empty ");
	    return false;
	  }else if(y==""){
		alert("Password Should NOT be Empty")  
		return false;
	  }
	  
	}
</script>

<body>
    <font color="red">${errorMessage}</font>
    <form method="post" name="loginForm" onsubmit="return validateForm()" action="/login">
        Username : <input type="text" name="name" />
        Password : <input type="password" name="password" /> 
        <input type="submit" action="/submit" />
         <input type="reset" value="Reset"  />
         <a href="/loadSignUp"> <input type="button" value="SignUp" /></a>
	     	  
    </form>
</body>
</html>