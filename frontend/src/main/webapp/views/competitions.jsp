
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

<title>Page de competitions</title>
</head>
<body>

	<c:if test="${!empty sessionScope.utilisateur}">
		<%@include file="navbar.jsp"%>




		<div class="tm-top-a-box tm-full-width tm-box-bg-1 ">
			<div class="uk-container uk-container-center">
				<section id="tm-top-a" class="tm-top-a uk-grid uk-grid-collapse"
					data-uk-grid-match="{target:'> div > .uk-panel'}"
					data-uk-grid-margin="">
				<div class="uk-width-1-1 uk-row-first">
					<div class="uk-panel">
						<div
							class="uk-cover-background uk-position-relative head-match-wrap"
							style="height: 662px; background-image: url('/images/head-bg-match.jpg');">
							<img class="uk-invisible" src="//images/head-bg-match.jpg" alt="">
							<div class="uk-position-cover uk-flex-center head-news-title">
								<h1>Les competitions disponibles</h1>
								<div class="clear"></div>
								<div class="va-latest-wrap">
									<div class="va-latest-middle uk-flex uk-flex-middle">
										<div class="uk-container uk-container-center">
											<div class="uk-container uk-container-center">
												<div id="tm-middle" class="tm-middle uk-grid"
													data-uk-grid-match="" data-uk-grid-margin="">


													<div class="tm-main uk-width-medium-2-4 uk-push-1-4">
														<c:forEach var="competition" items="${listeCompetitions}">
															<main id="tm-content" class="tm-content">
															<div class="match-list-wrap">
																<div class="match-list-item">
																	<div class="logo">
																		<a href="match-single.html"> <img
																			src="/images/champions-league-logo.png"
																			class="img-polaroid"></a>
																	</div>
																	<div class="team-name">
																		<c:out value="${competition.identifiant}" />

																		<a
																			href="competition?id=<c:out value="${competition.id}" />">voir
																			les matches</a>
																	</div>
																	<a
																		href="competition?id=<c:out value="${competition.id}" />">voir
																		les matches</a>
																</div>

															</div>
															</main>
														</c:forEach>
													</div>


												</div>
											</div>
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
	</c:if>
	<jsp:include page="loginRequired.jsp" />



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

