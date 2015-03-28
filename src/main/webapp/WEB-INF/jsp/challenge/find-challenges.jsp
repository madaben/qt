<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Map" %>
<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Find Challenges</h2>

	<spring:url value="/challenge/find-challenges" var="formUrl"/>
    <form:form modelAttribute="challengeVO" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-challenge-form">
        <fieldset>
            <div class="control-group" id="challenge.challengeDetails.description">
                <label class="control-label">Description </label>
                <form:input path="challenge.challengeDetails.description" size="30" maxlength="80"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div class="form-actions">
                <button type="submit">Find Challenge</button>
            </div>
        </fieldset>
    </form:form>

    <br/>
    <a href='<spring:url value="/challenge" htmlEscape="true"/>'>Add Challenge</a>

</div>
</body>

</html>
