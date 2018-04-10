<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/login.css" rel="stylesheet" type="text/css" />
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/mootools/1.3.1/mootools-yui-compressed.js'></script>


<title>Page d'inscription</title>
<style>
.error {
	color: red;
	font-size: 10pt;
}
</style>
</head>
<body>


	<center style="margin-top: 50px; color: white">
		<h1>Inscrivez vous</h1>
	</center>

	<div class="login-page">
		<div class="form">

			<form:form method="post" action="inscriptionProcess"
				modelAttribute="utilisateur" class="login-form">


				<form:input path="nom" type="text" placeholder="Nom" />
				<form:errors path="nom" cssClass="error" />
				<br />
				<br />



				<form:input path="prenom" type="text" placeholder="Prenom" />
				<form:errors path="prenom" cssClass="error" />
				<br />
				<br />

				<form:input path="identifiant" type="text" placeholder="identifiant" />
				<form:errors path="identifiant" cssClass="error" />
				<br />
				<br />


				<form:input path="email" type="text" placeholder="email" />
				<form:errors path="email" cssClass="error" />
				<br />
				<br />

				<form:input path="motDePasse" type="text" placeholder="mdp" />
				<form:errors path="motDePasse" cssClass="error" />
				<br />
				<br />

				<input class="submit-button" type="submit" value="valider" />

			</form:form>
		</div>
	</div>


	<script type="text/javascript" src="/js/login.js"></script>
	<script type="text/javascript" src="/js/jquery.js"></script>
</body>
</html>
