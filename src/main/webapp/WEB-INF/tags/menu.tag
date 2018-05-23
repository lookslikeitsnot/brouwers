<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">&#8962;</a></li>
		<li><a href="#">Brouwers Home</a>
			<ul>
				<li><a href="<c:url value='/brouwers'/>">Lijst</a></li>
				<li><a href="<c:url value='/brouwers/opalfabet'/>">Op
						alfabet</a></li>
				<li><a href="<c:url value='/brouwers/opnaam'/>">Op
						naam</a></li>
				<li><a href="<c:url value='/brouwers/toevoegen'/>">Toevoegen</a></li>
				<li><a href="<c:url value='/brouwers/beginnaam'/>">Per
						beginnaam</a></li>
			</ul></li>

		<c:if test='${pageContext.response.locale.language != "nl"}'>
			<c:url value='' var='nederlandsURL'>
				<c:param name='locale' value='nl_BE' />
			</c:url>
			<li><a href='${nederlandsURL}'>Nederlands</a></li>
		</c:if>
		<c:if test='${pageContext.response.locale.language != "en"}'>
			<c:url value='' var='engelsURL'>
				<c:param name='locale' value='en_US' />
			</c:url>
			<li><a href='${engelsURL}'>Engels</a></li>
		</c:if>
	</ul>
</nav>
