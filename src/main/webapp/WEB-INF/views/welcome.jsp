<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome page</title>
    </head>
    <body>
        Test test <br />
        Greeting : ${greeting}
        <br />This is a welcome page.<br />

        Login: <a href="<c:url value="/login" />">Login</a><br />
        Offers: <a href="<c:url value="/offers" />">Offers</a><br />
        User registration: <a href="<c:url value="/newUser" />">User reg</a><br />
    </body>
</html>