<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
<meta charset="utf-8" />
<title>Create New Product</title>
</head>
<script type="text/javascript">
function backToProduct(){
	window.location.href="/loadProducts";
	//window.transfer("product.jsp","_self"); 
}
 </script>
<body>
<h1>New Domain</h1>
<br />
  <form:form method="post" action="/saveProduct" modelAttribute="product">
	  <table border="0" cellpadding="10">
	      <tr>
	          <td>Product Name:</td>
	          <td><input type="text" name="name" /></td>
	          <td>Brand:</td>
	          <td><input type="text" name="brand" /></td>
	          <td>Made In:</td>
	          <td><input type="text" name="madein" /></td>
	          <td>Price:</td>
	          <td><input type="text" name="price" /></td>
	      </tr>                            
	      <tr>
	          <td colspan="8"><input type="submit" action="/submit"/> 
	          <input type="reset" value="Reset" name="Reset" /> 
	     	 <a href="/loadProducts"> <input type="button" value="Back" /></a>
	     	  <font color="blue">${successMessage}</font></td>
	      </tr>
	  </table>
  </form:form>
</body>
</html>