<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 11/22/2016
  Time: 00:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>All Product</title>
</head>
<body>

<td>Total product count: ${totalproductcount}</td>
</br>
<td>Current page: ${page}</td>
</br>
</br>
<div class="row">
    <div class="col-md-2"> </div>
    <div class="col-md-8">
        <div class="table-responsive">
            <table class="table table-hover"  width="50%" border="1" rules="all">
                <tr>
                    <th>Product ID</th><th>NAME</th><th>PRICE</th><th>STATUS</th>
                </tr>

                <c:forEach items="${listproductpagination}" var="product">
                    <tr>
                        <td align="center"><c:out value="${product.idProduct}" /></td>
                        <td align="center"><c:out value="${product.nameProduct}" /></td>
                        <td align="center"><c:out value="${product.price}" /></td>
                        <td align="center"><c:out value="${product.status}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="col-md-2"> </div>
</div>
</br>
</br>

<table style="font: 14pt arial;     width: 50%;  margin: auto;">
    <tr>
        <th>
            <c:if test="${page ne 1}">
                <a href="controller?command=getallproductpagination&page=${page - 1}">&#60;&#60;Previous</a>
            </c:if>
        </th>
        <%--For displaying Page numbers.
The when condition does not display a link for the current page--%>

        <c:forEach begin="1" end="${countofpages}" var="i">
            <c:choose>
                <c:when test="${page eq i}">
                    <th>${i}</th>
                </c:when>
                <c:otherwise>
                    <th>
                        <a href="controller?command=getallproductpagination&page=${i}">${i}</a>
                    </th>
                </c:otherwise>
            </c:choose>
        </c:forEach>


        <th>
            <%--For displaying Next link --%>
            <c:if test="${page lt countofpages}">
                <a href="controller?command=getallproductpagination&page=${page + 1}">Next&#62;&#62;</a>
                </br>
                </form>
            </c:if>
        </th>
    </tr>
</table>


</body>
</html>
