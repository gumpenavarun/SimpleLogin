<html>
<head>
<title>First Web Application</title>
</head>


<body>
    <font color="red">${errorMessage}</font>
    <form method="post" action="/login">
        Username : <input type="text" name="name" />
        Password : <input type="password" name="password" /> 
        <input type="submit" action="/submit" />
         <input type="reset" value="Reset"  />
         <a href="/loadSignUp"> <input type="button" value="SignUp" /></a>
	     	  
    </form>
</body>
</html>