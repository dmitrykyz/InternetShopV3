<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10/19/2016
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Welcome</title>
    <link href="css/bootstrap.css" rel="stylesheet">

    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
//        function addProduct(element) {
//
//        }
        $(document).ready(function(){
            $('.add').click(function(){
                var productId = $('#productId').val();
                $.ajax({
                    type:'POST',
                    data: {
                        productId : productId,
                        command: 'addproducttoorder'},
                    url: 'controller',
                    success: function(result){
                        //$(document).val(result);
                        alert("All Work");
//                        $('#someTextRezult').val(result);
                        //$('#someTextRezult').val(someText + "vvrr");
                    }
                })
            })
        })
    </script>
</head>
<body>

<!-- Это для тестов -->
<input class = "btn btn-default" type="button" id="ButtonAddProductToOrder1" value="+" />

<h3>Welcome to internet shop dear byer!</h3>
<hr/>
${user}, hello!
<hr/>
<a href="controller?command=logout">Logout</a>
<br/>
<form name="ShowProductForm" method="POST" action="controller">
    <h3>If your want show all product in shop click "Show all product"</h3>
    <input type="hidden" name="command" value="showallproduct" />
    <input class="btn btn-default" type="submit" btn-md value="Show all product"/>
    <br/>
    <table width="50%" border="1" rules="all">
        <tr>
            <th>Product ID</th><th>NAME</th><th>PRICE</th><th>STATUS</th><th>ADD</th><th>DELETE</th>
        </tr>
        <c:forEach items="${listproduct}" var="product">
            <tr>
                <td>
                    <c:set var="idProduct" value="${product.idProduct}"/>
                    <c:out value="${product.idProduct}" />
                </td>
                <td align="center"><c:out value="${product.nameProduct}" /></td>
                <td align="center"><c:out value="${product.price}" /></td>
                <td align="center"><c:out value="${product.status}" /></td>
                <td align="center">
                    <form name="AddProductToOrder" method="POST" action="controller">
                        <input type="hidden" name="command" value="addproducttoorder" />
                        <input type="hidden" name="productId" id="productId" value="${product.idProduct}" />
                        <!--тут поменял submit на button-->
                        <input class = "btn btn-default add" type="button" id="ButtonAddProductToOrder"
                               value="+"<%--onclick="addProduct(this)--%>"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</form>
    ${addProductToOrderCommandMessage}
<hr/>
<form name="ShowAllProductPaginationForm" method="POST" action="controller">
    <h3>If your want show all product in shop click "Show all product"</h3>
    <input type="hidden" name="command" value="getallproductpagination" />
    <input class="btn btn-default" type="submit" btn-md value="Show all product pagination"/>
    <br/>
    <br/>
</form><hr/>


<form name="ShowBasketForm" method="POST" action="controller">
    <h3>If your want show your basket click "Show basket"</h3>
    <input type="hidden" name="command" value="showbasket" />
    <input class="btn btn-default" type="submit" btn-md value="Show basket"/>
    <br/>
    <table width="50%" border="1" rules="all">
        <tr>
           <th>Order ID</th><th>TOTAL PRICE</th><th>REGISTRY</th><th>PAID</th><th></th>
         </tr>
        <c:forEach items="${listorderinbasket}" var="order">
            <tr>
                <td align="center">
                    <c:out value="${order.idOrder}" />
                </td>
                <td align="center"><c:out value="${order.totalPrice}" /></td>
                <td align="center"><c:out value="${order.isRegistryOrder}" /></td>
                <td align="center"><c:out value="${order.isPaidOrder}" /></td>
                <td></td>
                    <tr>
                    <th>#</th><th>Product ID</th><th>NAME</th><th>PRICE</th><th>STATUS</th>
                    </tr>
                    <c:forEach items="${order.productList}" var="productinorder">
                        <tr>
                            <td></td>
                        <td align="center"><c:out value="${productinorder.idProduct}" /></td>
                        <td align="center"><c:out value="${productinorder.nameProduct}" /></td>
                        <td align="center"><c:out value="${productinorder.price}" /></td>
                        <td align="center"><c:out value="${productinorder.status}" /></td>
                        </tr>
                    </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <br/>
</form>

</body></html>
