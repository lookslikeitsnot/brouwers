<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<head><v:head title='Stadstemperatuur'/></head>
<body><v:menu/>
<c:choose>
<c:when test='${empty fout}'>
<h1>Het is <fmt:formatNumber value='${temperatuur}'/> °C in 
${stad}</h1>
</c:when>
<c:otherwise>
<div class='fout'>${fout}</div>
</c:otherwise>
</c:choose>
</body>
</html>