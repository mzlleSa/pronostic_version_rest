<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de pronostic</title>
</head>
<body>
	<jsp:include page="userData.jsp" />
	<c:if test="${!empty sessionScope.utilisateur}">
		<form action="pronosticProcess" method="post">

			<c:if test="${empty pronostics}">
				<input type="hidden" name="action" value="insert" />
			</c:if>

			<c:if test="${!empty pronostics}">
				<input type="hidden" name="action" value="update" />
			</c:if>

			<c:if test="${estJouer}">
				<c:out value="Le pronostic est termin pour ce match" />
			</c:if>
			<table>

				<tr>
					<td><label for="equipe1">${equipe1.identifiant}</label></td>
					<td><input type="text" name="equipe1" id="equipe1"
						value="${pronosticEquipe1.prediction}"
						<c:if test="${estJouer}"><c:out value="disabled='disabled'"/></c:if> /></td>
					<input type="hidden" name="label1" value="${equipe1.id}" />
				</tr>

				<tr>
					<td><label for="equipe2">${equipe2.identifiant}</label></td>
					<td><input type="text" name="equipe2" id="equipe2"
						value="${pronosticEquipe2.prediction}"
						<c:if test="${estJouer}"><c:out value="disabled='disabled'"/></c:if> /></td>
					<input type="hidden" name="label2" value="${equipe2.id}" />
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="enregistrer"
						<c:if test="${estJouer}"><c:out value="disabled='disabled'"/></c:if> /></td>
					<input type="hidden" name="idMatch" value="${idMatch}" />
				</tr>
			</table>
		</form>

	</c:if>

	<jsp:include page="loginRequired.jsp" />
</body>
</html>
