<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 12/9/2016
  Time: 00:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Form Login
<form:form method="post" commandName="user" action="checkUser" class="box Login"> <!--action="getUserById""-->
    <fieldset class="boxBody">
        <form:label path="login">Login</form:label>
        <form:input path="login"/>
        <form:errors path="login" cssClass="error" />

        <form:label path="password">Password</form:label>
        <form:input path="password"/>
        <form:errors path="password" cssClass="error" />

        <input type="submit" class="btn btn-default" value="Login"/>

    </fieldset>

</form:form>


<%--<s:form id="personForm" name="getUserById" action="getUserById" modelAttribute="getUserById" method="post">--%>
    <%--<fieldset class="boxBody">--%>


        <%--<input type="submit" class="btn btn-default" value="Get User By Id"/>--%>

    <%--</fieldset>--%>
<%--</s:form>--%>

</body>
</html>
