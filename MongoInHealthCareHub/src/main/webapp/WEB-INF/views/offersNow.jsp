<title>HealthSavvy - Offers | Viewing Now</title>

<script type="text/javascript"
	src="/MongoInHealthCareHub/resources/scripts/provider.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#medicationUsage").addClass('active');
		$("#hdRewardNetwork").addClass('active');
		providerId = $.urlParam('id');
		GetProviderById(providerId);
	});
</script>



<div class="col-md-2 leftnav pd">
	<div class="left-nav-header">
		<span class="fa fa-dollar"></span><span class="left-nav-title">REWARD
			NETWORK</span>
	</div>
	<ul>
		<li><a href="/MongoInHealthCareHub/memberinfo/provider">Providers</a>
			<ul>
				<li class="active"><a href="#">Viewing Now</a>
			</ul></li>
		<li><a href="/MongoInHealthCareHub/memberinfo/doctor">Doctors</a></li>
		<li><a href="offers.html">Now Activated</a></li>
	</ul>
</div>

<div class="col-md-8 message-main pd">
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="row">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#about">About	Us</a></li>
					<li><a data-toggle="tab" href="#value">Our Value to You</a></li>
					<li><a data-toggle="tab" href="#conditions">Conditions</a></li>
					<li><a data-toggle="tab" href="#services">Services</a></li>
					<li><a href="/MongoInHealthCareHub/memberinfo/medications"> Close x</a></li>
				</ul>
				<div class="tab-content">

					<div class="tab-pane fade active in" id="about">
						<p></p>
					</div>
					<div class="tab-pane fade" id="value">
						<p></p>
					</div>
					<div class="tab-pane fade" id="conditions">
						<p></p>
					</div>
					<div class="tab-pane fade" id="services">
						<p></p>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="row">
				<div class="col-lg-12 pull-left">
					<label class="new pull-left active" id="cashReward"></label>
					<button class="btn btn-md btn-primary pull-right offer-act">
						<i class="fa fa-star"> </i>Activate
					</button>
				</div>
			</div>
		</div>

	</div>


	<div class="row">
		<div class="col-lg-12">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#reward">How
						to Earn Reward</a></li>
				<li><a data-toggle="tab" href="#quality">Quality</a></li>
				<li><a data-toggle="tab" href="#satisfaction">Satisfaction</a></li>
				<li><a data-toggle="tab" href="#efficiency">Efficiency</a></li>
				<li><a data-toggle="tab" href="#rates">Rates</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade active in" id="reward">
					<p></p>
				</div>
				<div class="tab-pane fade" id="quality">
					<p></p>
				</div>
				<div class="tab-pane fade" id="satisfaction">
					<p></p>
				</div>
				<div class="tab-pane fade" id="efficiency">
					<p></p>
				</div>
				<div class="tab-pane fade" id="rates">
					<p></p>
				</div>
			</div>
		</div>
	</div>

</div>
<div class="col-md-2 pd sidebar">
	<div class="container">
		<div class="row">
			<div  class="col-md-12">
				<a href="#"><img id="imageProvider" src=""	class="img-responsive" /></a>
			</div>
		</div>
	</div>

	<br>

	<div class="container">
		<!--[Map Area]-->
		<div>
			<div id="map-canvas" class="row" style="height: 150px; width: 150px;">
			</div>
		</div>
		<!--[Map Area End ]-->
		<!-- <img src="css/image/map.png" alt="" width="347" height="198" /> -->
	</div>

	<br>

	<div class="container">
		<div id="providerAddr" class="address"></div>
	</div>

</div>
