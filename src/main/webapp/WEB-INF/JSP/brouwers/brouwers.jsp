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
	<h1>Alle brouwers</h1>
	<table>
		<tr>
			<th><c:url value="" var="url">
					<c:param name="sort" value="brouwerNr" />
				</c:url> <a href="${url}">Nummer</a></th>
			<th><c:url value="" var="url">
					<c:param name="sort" value="naam" />
				</c:url> <a href="${url}">Naam</a></th>
			<th><c:url value="" var="url">
					<c:param name="sort" value="adres.straat" />
				</c:url> <a href="${url}">Straat</a></th>
			<th><c:url value="" var="url">
					<c:param name="sort" value="adres.huisNr" />
				</c:url> <a href="${url}">Huisnummer</a></th>
			<th><c:url value="" var="url">
					<c:param name="sort" value="adres.postcode" />
				</c:url> <a href="${url}">Postcode</a></th>
			<th><c:url value="" var="url">
					<c:param name="sort" value="adres.gemeente" />
				</c:url> <a href="${url}">Gemeente</a></th>
			<th><c:url value="" var="url">
					<c:param name="sort" value="omzet" />
				</c:url> <a href="${url}">Omzet</a></th>
		</tr>
		<c:forEach items="${page.content}" var="brouwer">
			<tr>
				<td>${brouwer.brouwerNr}</td>
				<td>${brouwer.naam}</td>
				<td>${brouwer.adres.straat}</td>
				<td>${brouwer.adres.huisNr}</td>
				<td>${brouwer.adres.postcode}</td>
				<td>${brouwer.adres.gemeente}
				<spring:url
						value='/weer/{stad}/stadstemperatuur' var="stadstemperatuurURL">
						<spring:param name='stad' value='${brouwer.adres.gemeente}' />
					</spring:url> <a href='${stadstemperatuurURL}'> (temperatuur)</a>
				</td>
				<td>${brouwer.omzet}</td>
			</tr>
		</c:forEach>
	</table>
	<p class='pagineren'>
		<c:forEach var="pageNr" begin="1" end="${page.totalPages}">
			<c:choose>
				<c:when test="${pageNr-1 == page.number}">
${pageNr}
</c:when>
				<c:otherwise>
					<c:url value="" var="url">
						<c:param name="page" value="${pageNr-1}" />
						<c:param name="sort" value="${param.sort}" />
					</c:url>
					<a href="${url}">${pageNr}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</p>
</body>
</html>