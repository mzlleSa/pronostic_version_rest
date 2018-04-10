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
	<jsp:include page="userData.jsp" />
	<c:if test="${!empty sessionScope.utilisateur}">
		<div align="center">
			<h1>Mon Profile</h1>
			<table border="1" cellpadding="5">

				<tr>
					<td><c:out value="Nom" /></td>
					<td><c:out value="${user.nom}" /></td>

				</tr>
				<tr>
					<td><c:out value="Prenom" /></td>
					<td><c:out value="${user.prenom}" /></td>

				</tr>
				<tr>
					<td><c:out value="Email" /></td>
					<td><c:out value="${user.email}" /></td>

				</tr>
				<tr>
					<td><c:out value="Identifiant" /></td>
					<td><c:out value="${user.identifiant}" /></td>

				</tr>
				<tr>
					<td><c:out value="Score" /></td>
					<td><c:out value="${user.score}" /></td>

				</tr>
				<tr>
					<td><c:out value="Classement" /></td>
					<td><c:out value="${user.classement}" /></td>

				</tr>
			</table>

		</div>
	</c:if>
	<jsp:include page="loginRequired.jsp" />

</body>
</html>
