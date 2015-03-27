<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2>Challenges</h2>
    
    <datatables:table id="challengeDetails" data="${selections}" row="challenge" theme="bootstrap2" 
                      cssClass="table table-striped" pageable="false" info="false">
       <datatables:column title="Name" property="challenge.name" />
       <datatables:column title="Address" property="description" />
       <datatables:column title="More Info" property="moreInfo"/>
    </datatables:table>

</div>
</body>

</html>
