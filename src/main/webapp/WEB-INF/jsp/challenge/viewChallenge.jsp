<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Map" %>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>
<body>


<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>
  <%--      <c:if test="${pet['new']}">New </c:if>  --%>
        View Challenge
    </h2>

 <spring:url value="/challenge/${challengeVO.challenge.id}/edit" var="formUrl"/>
    <form:form modelAttribute="challengeVO" method="get" action="${fn:escapeXml(formUrl)}" 
               class="form-horizontal">
        <div class="control-group" id="owner">
            <h3>${challengeVO.challenge.name} </h3>
        </div>
        <table  style="width:50%">	        
		    <tr><td>Description</td><td>${challengeVO.challenge.challengeDetails.description}</td></tr>
		    <tr><td>More Info</td><td>${challengeVO.challenge.challengeDetails.moreInfo}</td></tr>
		    <tr><td>Group Ages</td><td>${challengeVO.challenge.challengeMetadata.groupAge}</td></tr>
		    <tr><td>Categories</td><td>
		     <c:forEach items = "${challengeVO.challenge.challengeMetadata.categories}" var="category">
		     ${category.name}<br/>
		     </c:forEach>
		     
		    </td></tr>
       </table>
        <div class="form-actions">
         <button type="submit">Edit Challenge</button>             
        </div>
    </form:form>
</div>
</body>

</html>
