<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />


<div id="park-page">
	<c:forEach var="park" items="${parks}">
		<c:url var="img" value="${park.imageName}" />
		<c:url value="/parkDetails" var="parkDetails">
	 	 	<c:param name="parkCode" value="${park.parkCode}" />
	 	 </c:url>
		<div id="park-info">
			<a href="${parkDetails}"><img id="park-pic" src="${img}" /></a>
			<c:out value="${park.parkName}" /> <br>
			<c:out value="${park.parkDescription}" /> <br>
		</div>
	</c:forEach>
</div>