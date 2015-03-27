<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <spring:url value="/resources/images/banner-graphic.png" var="banner"/>
<img src="${banner}"/>
--%>
<div class="navbar" style="width: 601px;">
    <div class="navbar-inner">
        <ul class="nav">
            <li style="width: 120px;"><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home"></i>
                Home</a></li>
            <li style="width: 150px;"><a href="<spring:url value="/challenge" htmlEscape="true" />"> Add Challenge</a></li>
            <li style="width: 160px;"><a href="<spring:url value="/challenge/get-find-challenges" htmlEscape="true" />">Find Challenges</a></li>
           
        </ul>
    </div>
</div>
	
