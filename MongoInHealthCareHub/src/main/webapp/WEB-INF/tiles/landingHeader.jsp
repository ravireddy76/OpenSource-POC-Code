<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/MongoInHealthCareHub/home/landing"><img
				src="/MongoInHealthCareHub/resources/images/mongodbHadoop.png" class="img-responsive" /></a>
		</div>
		<div class="collapse navbar-collapse">
			<div class="navbar-right">
				<div class="row">
					<div class="col-lg-12 signin">
						<div class="row">
							<small class="col-md-4">Login 2 POC App?</small>
							<span id="loginError" class="error"></span>
						</div>
						<div class="row">
							<form class="form-horizontal">
								<div class="col-md-5">
									<input type="email" class="form-control" id="email"
										placeholder="E-Mail" onkeyup="loginInputKeyUp(event)" />
								</div>
								<div class="col-md-5">
									<input type="password" class="form-control" id="signin-password" 
									placeholder="Password" onkeyup="loginInputKeyUp(event)" />
								</div>
								<div class="col-md-2">
									<input type="button" class="btn btn-warning caps" id="submit"
										value="Login" onclick="javascript:doLogin();" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>