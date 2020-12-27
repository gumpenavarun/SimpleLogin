<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html >
<head>
<meta charset="utf-8" />
<title>Update Existing Product</title>
</head>
<body>
    <div align="center">
        <h1>Update Existing Product</h1>
        <br />
        
            <form:form method="post" action="/updateProduct" modelAttribute="updateProduct">
 
            <table border="0" cellpadding="10">
            	
                <tr>
                    <td>Product Name:</td>
                    <td><input type="text" name="name" value="${updateProduct.name}" /></td>
                </tr>
                <tr>
                    <td>Brand:</td>
                    <td><input type="text" name="brand" value="${updateProduct.brand}"/></td>
                </tr>
                <tr>
                    <td>Made In:</td>
                    <td><input type="text" name="madein" value="${updateProduct.madein} "/></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" value="${updateProduct.price}" /></td>
                </tr>                            
                <tr>
                 <input type="hidden" name="id" value="${updateProduct.id}" />
                    <td colspan="2"><input type="submit" name="submit"/> 
                	<a href="/loadProducts"> <input type="button" value="Back" /></a><font color="blue">${updateSuccess}</font></td>
                </tr>
             
            </table>
        </form:form>
    </div>
</body>
</html>