<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<hr>

<h1> Top Parks </h1>

<c:forEach var="park" items="${topParks}">
	<div id="park-info">
		<c:url var="img" value="${park.imageName}" /> 
		<img id="park-pic" src="${img}" /> 
		<h4><c:out value="${park.parkName}" /> <c:out value=" | Total Votes: ${park.count}" /></h4>

		<c:out value="${park.parkDescription}" /> <br>
		
	</div>
</c:forEach>