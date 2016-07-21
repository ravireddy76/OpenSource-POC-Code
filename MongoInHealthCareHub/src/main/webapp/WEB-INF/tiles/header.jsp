<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/MongoInHealthCareHub/home/landing"><img
				src="/MongoInHealthCareHub/resources/images/mhcLogo.png" class="img-landing" /></a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li id="hdDashboard"><a href="/MongoInHealthCareHub/dashboard/dbdetails">Dashboard</a></li>
				<li id="hdRewardNetwork"><a href="/MongoInHealthCareHub/memberinfo/medications">Member Information</a></li>
				<li id="hdMessages"><a href="/MongoInHealthCareHub/inboxmessage/allmessages">Messages <span
						class="badge label unread-msg"></span></a></li>
			</ul>
			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<li><img src="/MongoInHealthCareHub/resources/images/avator.png"
						class="ava-img img-responsive" /></li>
					<li class="dropdown avator"><span>Hi, <a id="headerUserName" href="/MongoInHealthCareHub/user/profile" class="captz"></a>
					</span><br /> <span class="dropdown-toggle" data-toggle="dropdown">
							<a href="#">MANAGE ACCOUNT</a> <b class="caret"></b>
					</span>
						<ul class="dropdown-menu">
							<li><a href="/MongoInHealthCareHub/user/profile">My Information</a></li>
							<li><a href="/MongoInHealthCareHub/home/logout">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
<!-- <script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		contentType: "application/json",
		dataType: 'json', 
	    cache: false,
	    type: "GET", 
	    url: "/MongoInHealthCareHub/user/profileInfo", 
	    success: function(data) {
	    	if(data !== ""){
	    		$("#headerUserName").text(data.firstName +" "+data.lastName);
	    		$(".unread-msg").text(data.numberOfUnreadMessages);
	    	}
	    }
	});
});
</script> -->