<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10/26/2016
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Welcome</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>Welcome to internet shop dear seller or admin!</h3>
<hr/>
${user}, hello!
<hr/>
<a href="controller?command=logout">Logout</a>
<form name="AddNewProduct" method="POST" action="controller">
    <h3>If your want add new product in shop click "Add new product"</h3>
    <input type="hidden" name="command" value="addnewproductshowpage" />
    <input class="btn btn-default" type="submit" btn-md value="Add new product"/>
    <br/>
    <br/>
    ${addNewProductMessage}
</form><hr/>

<form name="ShowAllProductPaginationForm" method="POST" action="controller">
    <h3>If your want show all product in shop click "Show all product"</h3>
    <input type="hidden" name="command" value="getallproductpagination" />
    <input class="btn btn-default" type="submit" btn-md value="Show all product pagination"/>
    <br/>
    <br/>
</form><hr/>

<form name="ShowAllProductForm" method="POST" action="controller">
    <h3>If your want show all product in shop click "Show all product"</h3>
    <input type="hidden" name="command" value="showallproduct" />
    <input class="btn btn-default" type="submit" value="Show all product"/>
    <br/>
    <table  width="50%" border="1" rules="all">
        <tr>
            <th>Product ID</th><th>NAME</th><th>PRICE</th><th>STATUS</th>
        </tr>
        <c:forEach items="${listproduct}" var="product">
            <tr>
                <td align="center"><c:out value="${product.idProduct}" /></td>
                <td align="center"><c:out value="${product.nameProduct}" /></td>
                <td align="center"><c:out value="${product.price}" /></td>
                <td align="center"><c:out value="${product.status}" /></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</form><hr/>

</body></html>
