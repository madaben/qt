<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@page import="java.util.Map" %>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>
<body>


<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>
  <%--      <c:if test="${pet['new']}">New </c:if>  --%>
        Challenge
    </h2>

    <form:form modelAttribute="challengeVO" method="post"
               class="form-horizontal">
        <div class="control-group" id="owner">
            <label class="control-label">Edit Challenge </label>
        </div>
        <petclinic:inputField label="Name" name="challenge.name"/>
        <petclinic:textareaField label="Description" name="challenge.challengeDetails.description" rows="8" cols="100"/>
        <petclinic:textareaField label="More Info" name="challenge.challengeDetails.moreInfo" rows="8" cols="100"/>
        <div><label class="control-label">Group Age</label>
	        <form:select path="challenge.challengeMetadata.groupAge">
	    		<form:options items="${challengeVO.groupAges}" itemValue="name" itemLabel="name"/>
			</form:select>
		</div>
		<div>
			<label class="control-label">Category</label>
			<form:select multiple="true" path="categoriesIDs" selected="selected">
		    	<c:forEach items="${categories}" var="category">
					<form:option value="${category.id}" label="${category.name}" />
				</c:forEach>
			</form:select>
		</div>
        <div class="form-actions">
         <button type="submit">Save Challenge</button>
             <%-- <c:choose>
                <c:when test="${pet['new']}">
                    <button type="submit">Add Pet</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update Pet</button>
                </c:otherwise>
            </c:choose> --%>
        </div>
    </form:form>
</div>
</body>

</html>
