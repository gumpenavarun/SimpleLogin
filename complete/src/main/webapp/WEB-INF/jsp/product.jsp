<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<title>Product</title>
</head>
<body>
	<form:form >
	<table style="width: 100%">
		<tr>
			<td colspan="5"><b>Product Details <a href="/createProduct">Create
						Product</a></td>
		</tr>
		<tr style="background-color: grey">
			<td>Id</td>
			<td>Product Name</td>
			<td>Brand</td>
			<td>Made In</td>
			<td>Price</td>
			<td>Action</td>
		</tr>
		<!-- Write for each and read the from the list and display  -->
		<c:forEach items="${productList}" var="productObj">
			<tr>
				<td><c:out value="${productObj.id}" /></td>
				<td><c:out value="${productObj.name}" /></td>
				<td><c:out value="${productObj.brand}" /></td>
				<td><c:out value="${productObj.madein}" /></td>
				<td><c:out value="${productObj.price}" /></td>
				<td><a href="/updateProduct/${productObj.id}"><input type="button" value="Edit"></a>
				 <a href="/deleteProduct/${productObj.id}"><input type="button" value="delete"></a></td>
			</tr>
		</c:forEach>
	</table>
	</form:form>
</body>
</html>