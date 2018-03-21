<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
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
			<th>Nummer</th>
			<th>Naam</th>
			<th>Straat</th>
			<th>HuisNr</th>
			<th>Postcode</th>
			<th>Gemeente</th>
			<th>Omzet</th>
		</tr>
		<c:forEach items="${brouwers}" var="brouwer">
			<tr>
				<td>${brouwer.brouwerNr}</td>
				<td>${brouwer.naam}</td>
				<td>${brouwer.adres.straat}</td>
				<td>${brouwer.adres.huisNr}</td>
				<td>${brouwer.adres.postcode}</td>
				<td>${brouwer.adres.gemeente}</td>
				<td>${brouwer.omzet}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>