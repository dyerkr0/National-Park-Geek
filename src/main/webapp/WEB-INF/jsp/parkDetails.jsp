<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<br>
<c:url var="img" value="${park.imageName}" /> 
<img src="${img}" /> <br>
<c:out value="${park.parkName}" /> <br>
<c:out value="${park.state}" /> <br>
<c:out value="${park.parkDescription}" /> <br> <br>
<c:out value="Annual Visitor Count: ${park.annualVisitorCount}" /> <br>
<c:out value="Entry Fee: $${park.entryFee}" /> <br>
<c:out value="Acreage: ${park.acreage}" /> <br>
<c:out value="Elevation: ${park.elevationInFeet} ft" /> <br>
<c:out value="Miles of Trail: ${park.milesOfTrail}" /> <br>
<c:out value="Number of Campsites: ${park.numberOfCampsites}" /> <br>
<c:out value="Climate: ${park.climate}" /> <br>
<c:out value="Year Founded: ${park.yearFounded}" /> <br>
<c:out value="Number of Animal Species: ${park.numberOfAnimalSpecies}" /> <br>
<c:out value="${park.inspirationalQuote}" />
<c:out value="- ${park.inspirationalQuoteSource}" /> <br>


<div id="weather">

<c:forEach var="weather" items="${forecast}">
	<c:url var="weatherimg" value="/img/weather/${weather.forecast}.png" /> 
	<c:choose>
		<c:when test="${weather.fiveDayForecastValue}==1">
			<div id="today-weather">	
				<img id="weather-img" src="${weatherimg}" />
				<c:out value="Low: ${weather.low}" />
				<c:out value="High: ${weather.high}" />
				<c:if test="${not empty weather.advisories}">
				<c:forEach var="advisory" items="${weather.advisories}">
					<c:out value="${advisory}"/>
				</c:forEach>
				</c:if>
			</div>
		</c:when>
	<c:otherwise>
		<div id="other-weather">
			<img id="weather-img" src="${weatherimg}" />
			<c:out value="Low: ${weather.low}" />
			<c:out value="High: ${weather.high}" />
		</div>
	</c:otherwise>
	</c:choose>

</c:forEach>
</div>




