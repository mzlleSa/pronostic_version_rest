

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
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<title>Page de poules</title>
</head>
<body>

	<c:if test="${!empty sessionScope.utilisateur}">

		<%@include file="navbar.jsp"%>
		<%@include file="headerpoule.jsp"%>

		<div class="tm-menu-box"></div>



		</div>
		</div>
		</div>
		</div>
		</div>
		</section>
		</div>
		</div>

		<div class="tm-top-b-box tm-full-width mb-5" id="dernier-resultat">
			<div class="uk-container uk-container-center">
				<section id="tm-top-b" class="tm-top-b uk-grid"
					data-uk-grid-match="{target:'> div > .uk-panel'}"
					data-uk-grid-margin="">

				<div class="uk-width-1-1">
					<div class="uk-panel">

						<div class="va-latest-wrap">
							<div class="uk-container uk-container-center">
								<div class="va-latest-top">
									<h3>
										<span>Poule</span>
									</h3>
									</br>
								</div>

								<section id="pricePlans"> <c:forEach var="poule"
									items="${poules}">
									<ul id="plans">
										<li class="plan">
											<ul class="planContainer">
												<li class="title"><h2 class="bestPlanTitle">
														Poule
														<c:out value="${poule.key}" />
													</h2></li>
												<c:forEach var="equipe" items="${poule.value}">
													<li>
														<ul class="options">
															<li><c:out value="${equipe.identifiant}" /></li>
														</ul>
													</li>
												</c:forEach>
												<li class="button"><a
													href="matchs?idCompetition=<c:out value="${idCompetition}"/>&idPoule=<c:out value="${poule.key}" />"><font
														size="1">Voir les matchs</font></a></li>
											</ul>
										</li>
									</ul>

								</c:forEach> </br>
								</section>

							</div>
							<!--
                                   les poules 
                               -->


							</br> </br>
							<div class="uk-container uk-container-center">
								<div class="va-latest-bottom">


									<div class="uk-grid">
										<div class="uk-width-1-1">

											<a class="read-more">*****</a>

										</div>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
				</section>
			</div>
		</div>
		<br />
		<br />
		<br />
		<br />


	</c:if>

	<jsp:include page="loginRequired.jsp" />
	<jsp:include page="footer.jsp" />



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




