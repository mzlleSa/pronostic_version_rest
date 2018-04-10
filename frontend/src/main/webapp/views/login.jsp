<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/login.css" rel="stylesheet" type="text/css" />
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/mootools/1.3.1/mootools-yui-compressed.js'></script>

<title>Page de login</title>
</head>
<body>



	<c:if test="${empty sessionScope.utilisateur}">

		<center style="margin-top: 50px; color: white">
			<h1>Connectez vous</h1>
			<div>
				<c:if test="${not empty errorMessage}">
					<c:out value="${errorMessage}" />
				</c:if>
			</div>
		</center>

		<div class="login-page">
			<div class="form">
				<form:form method="post" action="loginProcess"
					modelAttribute="utilisateur" class="login-form">
					<form:input type="text" path="identifiant"
						placeholder="identifiant" />
					<form:input type="password" path="motDePasse"
						placeholder="mot de passe" />
					<input class="submit-button" type="submit" value="connexion" />

				</form:form>
			</div>
		</div>
	</c:if>
	<c:if test="${!empty sessionScope.utilisateur}">
		<c:redirect url="competitions" />
	</c:if>


	<script type="text/javascript" src="/js/login.js"></script>
	<script type="text/javascript" src="/js/jquery.js"></script>
</body>
</html>
