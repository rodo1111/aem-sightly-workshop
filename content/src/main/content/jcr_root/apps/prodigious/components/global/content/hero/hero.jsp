<%@include file="/apps/prodigious/components/global/global.jsp" %>
<c:set var="isEditMode" value="<%= (WCMMode.fromRequest(request) == WCMMode.EDIT || WCMMode.fromRequest(request) == WCMMode.DESIGN) %>" />

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
	<div class="container">
		<c:set var="title" value="${currentPage.title}" />
		
		<c:if test="${not empty currentPage.pageTitle}">
			<c:set var="title" value="${currentPage.pageTitle}" />
		</c:if>
		
		<c:if test="${not empty currentPage.navigationTitle}">
			<c:set var="title" value="${currentPage.navigationTitle}" />
		</c:if>
		
		<c:if test="${not empty properties.title}">
			<c:set var="title" value="${properties.title}" />
		</c:if>
		
		<h1>${title}</h1>
		
		<c:choose>
			<c:when test="${not empty properties.message}">
				<p>${properties.message}</p>
				<p>
					<a href="${properties.linkHref}" class="btn btn-primary btn-lg" role="button">${properties.linkTitle} &raquo;</a>
				</p>
			</c:when>
			<c:otherwise>
				<c:if test="${isEditMode}">
					Double click to configure the Hero extra elements.
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</div>