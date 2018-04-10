<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page des matchs</title>
</head>
<body>
	<jsp:include page="userData.jsp" />
	<c:if test="${!empty sessionScope.utilisateur}">

		<div align="center">
			<h1>Les matchs disponibles</h1>
			<table border="1" cellpadding="5">
				<tr>
					<th>ID</th>
					<th>Identifiant</th>
					<th>Date de debut</th>
					<th>Equipes</th>
					<th>Action</th>
				</tr>
				<c:forEach var="match" items="${listeMatchs}">
					<tr>
						<td><c:out value="${match.id}" /></td>
						<td><c:out value="${match.identifiant}" /></td>
						<td><c:out value="${match.dateMatch}" /></td>
						<td><c:forEach var="equipe" items="${match.equipes}">
							- <c:out value="${equipe.identifiant}" />
								<br />
							</c:forEach></td>
						<td><a href="pronostic?idMatch=<c:out value="${match.id}" />">pronostiquer</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</c:if>


	<jsp:include page="loginRequired.jsp" />
</body>
</html>
