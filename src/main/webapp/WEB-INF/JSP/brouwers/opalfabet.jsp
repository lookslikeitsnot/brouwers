<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers op alfabet' />
</head>
<body>
	<v:menu />
	<h1>Brouwers op alfabet</h1>
	<h2>
		<c:forEach var="letter" begin="65" end="90">
			<%
				Character chr = Character.toChars((Integer) pageContext.getAttribute("letter"))[0];
					pageContext.setAttribute("chr", chr);
			%>
			<c:set var="firstLetter" value='${chr}' />
			<spring:url var='url' value='/brouwers/{letter}'>
				<spring:param name='letter' value='${firstLetter}' />
			</spring:url>

			<a href='${url}'><c:out value="${firstLetter}" /></a>

		</c:forEach>
	</h2>
	<c:if test="${!empty brouwers}">
		<ul>
			<c:forEach items="${brouwers}" var="brouwer">
				<li>${brouwer.naam} (${brouwer.adres.gemeente})</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>