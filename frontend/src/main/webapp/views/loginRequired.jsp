<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de competitions</title>
</head>
<body>
	<c:if test="${empty sessionScope.utilisateur}">
		<h4>Vous devez vous connectez avant d'acceder � cette page !</h4>
		<a href="login">se connecter</a>
	</c:if>
</body>
</html>
