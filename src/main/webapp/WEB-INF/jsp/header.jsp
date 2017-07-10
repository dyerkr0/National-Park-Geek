<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/nationalpark.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePage" />
    		<c:url value="/img/logo.png" var="logo" />
    		<c:url value="/surveyInput" var="surveyInput" />
    		
    		 <a href="${homePage}">
        		<img id="header-logo" src="${logo}" alt="National Park Geek logo" />
       	    </a>
       	    
       	    <nav id="nav">
       	    	<ul>
       	    		<li><a href="${homePage}">Home</a></li>
       	    		<li><a href="${surveyInput}">Survey</a></li>
       	    	</ul>
       	    </nav>
       	    <br>
 	</header>
    
