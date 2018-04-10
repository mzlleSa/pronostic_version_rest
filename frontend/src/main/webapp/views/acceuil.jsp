<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="/css/akslider.css" rel="stylesheet" type="text/css" />
<link href="/css/theme.css" rel="stylesheet" type="text/css" />
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/mootools/1.3.1/mootools-yui-compressed.js'></script>

<link rel="stylesheet" href="/css/style.css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

<title>Page d'acceuil</title>
</head>
<body>

	<%@include file="navbar.jsp" %>
	<%@include file="headerSlide.jsp" %>
	<%@include file="nextMatch.jsp" %>

	<center>
		
		<jsp:include page="footer.jsp" />
	</center>
	
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/uikit.js"></script>
<script type="text/javascript" src="/js/SimpleCounter.js"></script>
<script type="text/javascript" src="/js/components/grid.js"></script>
<script type="text/javascript" src="/js/components/slider.js"></script>
<script type="text/javascript" src="/js/components/slideshow.js"></script>
<script type="text/javascript" src="/js/components/slideset.js"></script>
<script type="text/javascript" src="/js/components/sticky.js"></script>
<script type="text/javascript" src="/js/components/lightbox.js"></script>
<script type="text/javascript" src="/js/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="/js/theme.js"></script>

</body>
</html>
