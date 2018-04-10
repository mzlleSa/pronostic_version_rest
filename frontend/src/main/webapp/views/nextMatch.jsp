
<div class="tm-top-b-box tm-full-width  " id="next-match">
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
									Next <span>Match</span>
								</h3>
								<div class="date">${nextMatch.dateMatch}</div>
							</div>
						</div>
						<div class="va-latest-middle uk-flex uk-flex-middle">
							<div class="uk-container uk-container-center">
								<div class="uk-grid uk-flex uk-flex-middle">
									<div class="uk-width-2-12 center">
										<a href="results.html"> <img src="images/logo-img.png"
											class="img-polaroid" alt="" title="">
										</a>
									</div>
									<div class="uk-width-3-12 name uk-vertical-align">
										<div class="wrap uk-vertical-align-middle">
											<c:set var="first" value="${nextMatch.equipes[0]}" />
											<c:out value="${ first.identifiant}" />
										</div>
									</div>

									<div class="uk-width-2-12 score">
										<div class="table">
											<div class="left">*</div>
											<div class="right">*</div>
											<div class="uk-clearfix"></div>
										</div>
									</div>

									<div class="uk-width-3-12 name alt uk-vertical-align">
										<div class="wrap uk-vertical-align-middle">

											<c:set var="second" value="${nextMatch.equipes[1]}" />
											<c:out value="${second.identifiant}" />
										</div>
									</div>
									<div class="uk-width-2-12 center">
										<a href="results.html"> <img src="images/logo-img.png"
											class="img-polaroid" alt="" title="">
										</a>
									</div>
								</div>
							</div>
						</div>
						<div class="uk-container uk-container-center">
							<div class="va-latest-bottom">
								<br /> <br />


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