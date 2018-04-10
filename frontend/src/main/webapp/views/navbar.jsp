<div class="tm-menu-box">
	<div style="height: 70px;" class="uk-sticky-placeholder">
		<nav style="margin: 0px;" class="tm-navbar uk-navbar"
			data-uk-sticky="">
			<div class="uk-container uk-container-center">
				<a class="tm-logo uk-float-left" href="/"> <img
					src="images/logo-loader.png" alt="logo" title="logo"> <span>SEZSPORT<em>.Com</em></span>
				</a>

				<ul class="uk-navbar-nav uk-hidden-small">
					<li><a href="/">Accueil</a></li>
					<c:if test="${empty sessionScope.utilisateur}">
						<li><a href="#next-match">Prochain match</a></li>
						<li><a href="inscription">Inscription</a></li>
						<li><a href="login">Connexion</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.utilisateur}">
						<li><a href="competitions">Competitions</a></li>
						<li><a href="profile">Profile</a></li>
						<li><a href="logout">Deconnexion</a>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
</div>