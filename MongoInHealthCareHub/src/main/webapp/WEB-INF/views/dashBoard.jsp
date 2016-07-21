<div class="col-md-12 dashboard-main">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						
						<div>
							<small class="container-fluid">Condition Code: </small> 
							<input type="text" name="condCodeId" id="condCodeId"></input>
							<button type="button" id="searchCondBtnId" onclick="javascript:searchMemberConditionCodeAction();">Search</button>
						</div>
						<br/>
						<!-- <div>
							<input type="text" name="condCode" id="condCodeId"></input>
							<button type="button" id="searchCondBtnId">Search</button>
						</div> -->
					
						<!-- <div class="table">
						    <div class="td">
						         <label>Search By Condition Code :<label>
						         <input type="text" name="searchbox" id="searchId"/>
						         <button type="button" id="searchCondBtnId">Search</button>
						    </div>
						</div> -->
						
						
						<div class="container">
							<div class="row offers">
								<div class="col-md-6 part">
									<div class="overlay">
										<div id='chartHealthDataAnalyticsId' style="width:850px; height:500px"></div>
									</div>
								</div>
								<!-- <div class="col-md-6 part">
									<div class="btn-cont">
										<a href="#" class="btn btn-xs btn-warning" data-toggle="modal"
											data-target="#network-modal">What's this?</a> <a
											href="/PACNHub/reward/provider"
											class="btn btn-xs btn-primary">View Rewards</a>
									</div>
								</div> -->
							</div>
						</div>
					</div>
					<!-- <div class="col-md-6">
						<h3>Your Annual Cash Bonus: </h3> 
						<h4 class="status">Current progress</h4>
						<div class="container">
							<div class="row offers">
								<div class="col-md-6 part">
									<div class="progress-radial progress-3">
										<div class="overlay">
											<div id='rewardsChartId' class="img-responsive"
												style="width: 300px; height: 300px; position: relative;">
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-6 part">
									<div class="btn-cont">
										<a href="#" class="btn btn-xs btn-warning" data-toggle="modal"
											data-target="#annual-modal">What's this?</a> <a
											href="/PACNHub/home/underconstruction"
											class="btn btn-xs btn-primary">View Details</a>
									</div>
								</div>
							</div>
						</div>
					</div> -->
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="container">
						<div class="row insight-box">
							<!-- <b>Location</b> -->
							<div class="pull-left" style="margin-right: 30px;">
								<div id="member-map-canvas" style="height:130px; width:340px;"></div>
							</div>
							<!-- <div class="pull-left" style="padding-top: 5px;">
								<div class="message-count ">
									<span class="unread-msg" ></span>
									<p>
										<a href="/PACNHub/home/underconstruction">New Messages</a>
									</p>
								</div>
							</div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-8">
			<div id="carousel-example-captions" class="carousel slide"
				data-ride="carousel">
				<h3 class="offer-txt">MongoDB and Hadoop Success</h3>

				<ol class="carousel-indicators">
					<li data-target="#carousel-example-captions" data-slide-to="0"
						class="active"></li>
					<li class="" data-target="#carousel-example-captions"
						data-slide-to="1"></li>
					<li class="" data-target="#carousel-example-captions"
						data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img src="/MongoInHealthCareHub/resources/images/bigDataSuccess.jpg"
							class="img-responsive" />
						<div class="carousel-caption">
							<h3>Industry Still thinking ?</h3>
							<div>
								<span class="healthCarePercentage">21st century needs for scale, cost efficiency and flexibility</span>
							</div>
							<small>Applications</small>
						</div>
						<!-- <a href="/MongoInHealthCareHub/home/underconstruction"
							class="btn btn-xs btn-primary view-btn" style="">VIEW DETAILS</a> -->
					</div>
					<div class="item">
						<img src="/MongoInHealthCareHub/resources/images/mongodbHadoop.png"
							class="img-responsive" />
						<div class="carousel-caption">
							<h3>MongoDB & Hadoop in health care industry</h3>
							<div>
								<span class="percentage">Modern Healthcare Architecture</span>
							</div>
							<small>Healthcare Solutions</small>
						</div>
						<!-- <a href="/PACNHub/home/underconstruction"
							class="btn btn-xs btn-primary view-btn" style="">VIEW DETAILS</a> -->
					</div>
					<div class="item">
						<img src="/MongoInHealthCareHub/resources/images/healthCare.jpg"
							class="img-responsive" />
						<div class="carousel-caption">
							<h3>Health Care Industry</h3>
							<div>
								<span class="healthCarePercentage">
									<li>360-Degree Patient Management</li>
									<li>Lab Data Management and Analytics.</li>
								</span>
							</div>
							<small>and more ....</small>
						</div>
						<!-- <a href="/PACNHub/home/underconstruction"
							class="btn btn-xs btn-primary view-btn" style="">VIEW DETAILS</a> -->
					</div>
					<div class="item">
						<img src="/MongoInHealthCareHub/resources/images/rxIcon.png"
							class="img-responsive" />
						<div class="carousel-caption">
							<h3>Rx Industry</h3>
							<div>
								<span class="percentage">Rx</span> Drug usage and analytics
							</div>
							<small></small>
						</div>
						<!-- <a href="/PACNHub/home/underconstruction"
							class="btn btn-xs btn-primary view-btn" style="">VIEW DETAILS</a> -->
					</div>
				</div>
				<a class="left carousel-control" href="#carousel-example-captions"
					data-slide="prev"> <span class="fa fa-backward"></span>
				</a> <a class="right carousel-control" href="#carousel-example-captions"
					data-slide="next"> <span class="fa fa-forward"></span>
				</a>
			</div>

		</div>
	</div>
</div>

<!-- Network Modal -->
<div class="modal fade" id="network-modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h2 class="modal-title" id="myModalLabel">Lorem ipsum dolor sit
					amet</h2>
			</div>
			<div class="modal-body">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Curabitur convallis libero sit amet molestie egestas. Mauris eu leo
					in tellus ullamcorper tempus. Donec sem nibh, mattis ac arcu sed,
					venenatis rutrum nibh. Sed ac suscipit eros, a accumsan libero.
					Vestibulum ligula nibh, dignissim a dapibus quis, ullamcorper ac
					est. Etiam lacus sapien, iaculis in eros quis, cursus pharetra
					elit. In molestie pulvinar tristique. Vivamus ac est porta,
					faucibus diam a, rhoncus ligula.</p>
			</div>
		</div>
	</div>
</div>

<!-- Network Modal -->
<div class="modal fade" id="annual-modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h2 class="modal-title" id="myModalLabel">Lorem ipsum dolor sit
					amet</h2>
			</div>
			<div class="modal-body">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Curabitur convallis libero sit amet molestie egestas. Mauris eu leo
					in tellus ullamcorper tempus. Donec sem nibh, mattis ac arcu sed,
					venenatis rutrum nibh. Sed ac suscipit eros, a accumsan libero.
					Vestibulum ligula nibh, dignissim a dapibus quis, ullamcorper ac
					est. Etiam lacus sapien, iaculis in eros quis, cursus pharetra
					elit. In molestie pulvinar tristique. Vivamus ac est porta,
					faucibus diam a, rhoncus ligula.</p>
			</div>
		</div>
	</div>
</div>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script type="text/javascript" src="/MongoInHealthCareHub/resources/scripts/acn-dashboard.js"></script>
