<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Offer Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add an Offer
</h1>

<c:url var="addAction" value="/offers/add" ></c:url>

<form:form action="${addAction}" commandName="offer">
    <table>
        <c:if test="${!empty offer.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="category">
                    <spring:message text="Category"/>
                </form:label>
            </td>
            <td>
                <form:input path="category" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="locationName">
                    <spring:message text="Location Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="locationName" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="locationX">
                    <spring:message text="Location X"/>
                </form:label>
            </td>
            <td>
                <form:input path="locationX" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="locationY">
                    <spring:message text="Location Y"/>
                </form:label>
            </td>
            <td>
                <form:input path="locationY" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty offer.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Offer"/>" />
                </c:if>
                <c:if test="${empty offer.name}">
                    <input type="submit"
                           value="<spring:message text="Add Offer"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Offer List</h3>
<c:if test="${!empty listOffers}">
    <table class="tg">
        <tr>
            <th width="80">Offer ID</th>
            <th width="120">Offer Category</th>
            <th width="120">Offer Name</th>
            <th width="120">Offer Price</th>
            <th width="120">Offer Location</th>
            <th width="120">Offer Location X</th>
            <th width="120">Offer Location Y</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOffers}" var="offer">
            <tr>
                <td>${offer.id}</td>
                <td>${offer.category}</td>
                <td>${offer.name}</td>
                <td>${offer.price}</td>
                <td>${offer.locationName}</td>
                <td>${offer.locationX}</td>
                <td>${offer.locationY}</td>
                <td><a href="<c:url value='/offers/edit/${offer.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/offers/remove/${offer.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>