<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers' />
</head>
<body>
	<v:menu />
	<h1>Brouwers site</h1>
	<h3>
		<spring:message code="goed"/> 
		<spring:message code="${moment}"/> 
	</h3>
</body>
</html>