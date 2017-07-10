<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<c:import url="/WEB-INF/jsp/header.jsp" />
<hr>
<c:url var="img" value="${park.imageName}" /> 
<img src="${img}" /> <br>
<h3><c:out value="${park.parkName} - ${park.state}" /> </h3><br>
<c:out value="${park.inspirationalQuote}" /> 
<c:out value="- ${park.inspirationalQuoteSource}" /> <br> <br>
<c:out value="${park.parkDescription}" /> <br> <br>
<c:out value="Annual Visitor Count: ${park.annualVisitorCount}" /> <br>
<c:out value="Entry Fee: $${park.entryFee}" /> <br>
<c:out value="Acreage: ${park.acreage}" /> <br>
<c:out value="Elevation: ${park.elevationInFeet} ft" /> <br>
<c:out value="Miles of Trail: ${park.milesOfTrail}" /> <br>
<c:out value="Number of Campsites: ${park.numberOfCampsites}" /> <br>
<c:out value="Climate: ${park.climate}" /> <br>
<c:out value="Year Founded: ${park.yearFounded}" /> <br>
<c:out value="Number of Animal Species: ${park.numberOfAnimalSpecies}" />

 <hr>


	<div id="daily-weather-block">
	<c:forEach var="weather" items="${forecast}">
		<c:if test="${weather.fiveDayForecastValue==1}">
			<div id="today-weather">	
			<c:url var="weatherimg" value="/img/weather/${weather.forecast}.png" /> 
				<img id="today-weather-img" src="${weatherimg}" /> <br>
				<c:choose>
					<c:when test="${isFahrenheit}">
						<c:out value="High: ${weather.high}F" />
					</c:when>
					<c:otherwise>
						<c:out value="High: "/> <fmt:formatNumber pattern="###.#C" value="${(weather.high - 32) * (5/9) }" />
					</c:otherwise>
				  </c:choose> 
				  <c:choose>
					<c:when test="${isFahrenheit}">
						<c:out value="Low: ${weather.low}F" />
					</c:when>
					<c:otherwise>
						<c:out value="Low: "/> <fmt:formatNumber pattern="###.#C" value="${(weather.low - 32) * (5/9) }" />
					</c:otherwise>
				</c:choose>
				<br>
				<c:forEach var="advisory" items="${weather.advisories}">
					<c:out value="${advisory}"/> <br>
				</c:forEach>
			</div>
		</c:if>
	</c:forEach>
	<div id="other-weather">
	<table>
		<tr>
			<c:forEach var="weather" items="${forecast}">
				<c:if test="${weather.fiveDayForecastValue!=1}">
					<c:url var="weatherimg" value="/img/weather/${weather.forecast}.png" /> 
					<td> <img id="weather-img" src="${weatherimg}" /> </td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="weather" items="${forecast}">
				<c:if test="${weather.fiveDayForecastValue!=1}">
				<td> 
				  <c:choose>
					<c:when test="${isFahrenheit}">
						<c:out value="High: ${weather.high}F" />
					</c:when>
					<c:otherwise>
						<c:out value="High: "/> <fmt:formatNumber pattern="###.#C" value="${(weather.high - 32) * (5/9) }" />
					</c:otherwise>
				  </c:choose> 
			    </td>
			    </c:if>
			</c:forEach>
			
		</tr>
		<tr>
			<c:forEach var="weather" items="${forecast}">
			<c:if test="${weather.fiveDayForecastValue!=1}">
			<td>
				<c:choose>
					<c:when test="${isFahrenheit}">
						<c:out value="Low: ${weather.low}F" />
					</c:when>
					<c:otherwise>
						<c:out value="Low: "/> <fmt:formatNumber pattern="###.#C" value="${(weather.low - 32) * (5/9) }" />
					</c:otherwise>
				</c:choose>
			</td>
			</c:if>
			</c:forEach>
		</tr>
			

		</table>

	<c:choose>
		<c:when test="${isFahrenheit}">
			<c:url var="formAction" value="/parkDetails">
				<c:param name="isFahrenheit" value="false" />
				<c:param name="parkCode" value="${park.parkCode}" />
			</c:url>
			<form action="${formAction}" method="POST">
				<input type="submit" value="Change to Celsius">
			</form>
		</c:when>
		<c:otherwise>
			<c:url var="formAction" value="/parkDetails">
				<c:param name="isFahrenheit" value="true" />
				<c:param name="parkCode" value="${park.parkCode}" />
			</c:url>
			<form action="${formAction}" method="POST">
				<input type="submit" value="Change to Fahrenheit">
			</form>
		</c:otherwise>
	</c:choose>
	</div>
</div>
