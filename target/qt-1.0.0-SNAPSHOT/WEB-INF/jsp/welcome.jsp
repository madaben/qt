<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>
    <spring:url value="/resources/images/koala11.jpg" htmlEscape="true" var="petsImage"/>
    <img src="${petsImage}"/>
    <h2><fmt:message key="welcome"/></h2>

</div>
</body>

</html>
