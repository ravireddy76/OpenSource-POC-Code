<div class="col-md-8 offer-main pd">
	<div id="dvViewProfile" class="panel panel-default">
		<div class="panel-body">
			<div class="rsow my-profile">
				<div class="col-sm-3">
					<img src="/MongoInHealthCareHub/resources/images/avator-big.png"
						class="img-responsive profile-photo" />
				</div>
				<div class="col-sm-7">
					<h1><span id="userName"></span></h1>
					<div class="row">
						<div class="col-xs-5">Birth Date:</div>
						<div class="col-xs-7"><span id="lblDob">Not Available</span></div>
					</div>
					<div class="row">
						<div class="col-xs-5">Gender:</div>
						<div class="col-xs-7"><span id="lblGender">Not Available</span></div>
					</div>
					<div class="row">
						<div class="col-xs-5">Company / Group:</div>
						<div class="col-xs-7">Not Available</div>
					</div>
					<div class="row">
						<div class="col-xs-5">E-Mail Address:</div>
						<div class="col-xs-7">
							<a id="lblEmail"></a>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-5">Address:</div>
						<div class="col-xs-7"><span id="lblAddress">Not Available</span></div>
					</div>
				</div>
				<div class="col-sm-2">
					<a class="btn btn-xs btn-primary toggle"><i class="fa fa-pencil"></i>EDIT</a>
				</div>
			</div>
		</div>
	</div>
	<div id="dvEditProfile" class="panel panel-default" style="display: none;">
		<div class="panel-body">
			<div class="rsow my-profile">
				<div class="col-sm-3">
					<img id="profilePhoto" class="img-responsive profile-photo"
						src="/MongoInHealthCareHub/resources/images/avator-big.png" />
					<input type='file' id="imgInp" style="display: none;" accept="image/*"/>
				</div>
				<div class="col-md-9">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-3"></label>
							<div class="col-sm-9">
								<span id="userProfileError" class="error"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstName" class="col-sm-3 control-label">First Name</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="firstName" /> 
								<span id="firstNameError" class="error"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="lastName" class="col-sm-3 control-label">Last Name</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="lastName" /> 
								<span id="lastNameError" class="error"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="dob" class="col-sm-3 control-label">Date of Birth</label>
							<div class="col-xs-10 col-md-4">
								<input type="text" class="form-control" id="dob" placeholder="MM/DD/YYYY" />
								<span id="dobError" class="error"></span>
							</div>
							<div class="col-xs-10 col-md-2">
								<label for="gender" class="col-sm-2 control-label">Gender</label>
							</div>
							<div class="col-xs-10 col-md-3">
								<select class="form-control" id="gender">
								</select>
								<span id="genderError" class="error"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-3 control-label">Email Address</label>
							<div class="col-sm-9 text-center">
								<input type="text" class="form-control" id="email" disabled/>
							</div>
						</div>
						<div class="form-group">
							<label for="addressLine1" class="col-sm-3 control-label">Address (1)</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addressLine1" />
							</div>
						</div>
						<div class="form-group">
							<label for="addressLine2" class="col-sm-3 control-label">Address (2)</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addressLine2" />
							</div>
						</div>
						<div class="form-group">
							<div class="">
								<label for="city" class="col-sm-3 control-label">&nbsp;</label>
								<div class="col-xs-10 col-md-3">
									<input type="text" class="form-control" id="city" placeholder="City" />
								</div>
								<div class="col-xs-10 col-md-3">
									<select class="form-control" id="state">
									</select>
								</div>
								<div class="col-xs-10 col-md-3">
									<input type="text" maxLength="5" class="form-control" id="zipCode" placeholder="Zip" />
									<span id="zipCodeError" class="error"></span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="healthPlan" class="col-sm-3 control-label">Health Plan</label>
							<div class="col-sm-9">
								<select class="form-control" id="healthPlan" disabled>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-9 pull-right">
								<a class="btn btn-xs btn-primary caps" onclick="javascript:updateUserProfile();"><i class="fa fa-save"></i>save</a>
								<a class="btn btn-xs btn-primary caps cancel-update"><i class="fa fa-times"></i>cancel</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/MongoInHealthCareHub/resources/scripts/settings.js"></script>