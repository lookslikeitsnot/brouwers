<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers op alfabet' />
</head>
<body>
	<v:menu />
	<h1>Brouwers op naam</h1>
	<c:url value='/brouwers/opnaam' var='url' />
	<form:form action='${url}' modelAttribute='naam' method='get'>
		<form:label path='name'>Naam:</form:label>
		<form:errors path='name' />
		<form:input path='name' autofocus='autofocus' type='text'
			required='required'/>
		<input type='submit' value='Zoeken'>
		<form:errors cssClass='fout' />
	</form:form>
	<c:if test="${!empty brouwers}">
		<ul>
			<c:forEach items="${brouwers}" var="brouwer">
				<li>${brouwer.naam} (${brouwer.adres.gemeente})</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>