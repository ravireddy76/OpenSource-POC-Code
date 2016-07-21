<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/MongoInHealthCareHub/resources/images/mongoicon.png" type="image/x-icon" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- Including CSS resources. -->
<%@ include file="/WEB-INF/views/cssresource.jsp" %>
<%@ include file="/WEB-INF/views/jsresource.jsp" %>
</head>
<body>
	<div class="page">
		<div><tiles:insertAttribute name="header" /></div>
		<div id="content" class="container">
			<div class="row">
				<div ><tiles:insertAttribute name="leftsidebar" /></div>
				<div ><tiles:insertAttribute name="content" /></div>
				<div ><tiles:insertAttribute name="rightsidebar" /></div>
			</div>
		</div>
		<div><tiles:insertAttribute name="footer" /></div>
	</div>
</body>

</html>