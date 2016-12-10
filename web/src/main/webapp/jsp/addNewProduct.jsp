<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10/26/2016
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Product</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        .btn-link {
            color: black;
        }
    </style>

</head>
<body>
<form name="addNewProductForm" method="POST" action="controller">
    <h3>Please enter param new product.</h3>
    <br/>
    <input type="hidden" name="command" value="addnewproduct" />
    Product name: <input type="text" name="productName"/>
    <br/>
    Price: <input type="number" name="price" value=""/>
    <br/>
    Status <input type="text" name="status" value=""/>
    <br/>
    <br/>
    <input class="btn btn-default" type="submit" btn-md value="Add product"/>
</form><hr/>
</body>
</html>
