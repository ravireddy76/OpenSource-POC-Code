<div class="col-md-8 offer-main pd">
	<form class="form-inline container">
		<div class="form-group row" style="display: block;">
			<div class="col-md-6 search">
				<label for="search">Search:</label> <input type="text" name="search"
					class="form-control" id="search"
					placeholder="doctor name, type, etc">
			</div>
			<div class="col-md-5 zip">
				<label for="zip">Your Zip Code: </label> <input type="text"
					name="zip" class="form-control" id="zip" placeholder="optional">
			</div>
			<div class="col-md-1 go">
				<button type="button" id="submit" class="btn btn-primary pull-right">
					<span class="fa fa-search"></span> GO
				</button>
			</div>
		</div>
	</form>
	<br/>
	<!-- Doctors Data Grid. -->
	<div id="jqxWidget">
		<div id="doctorsGrid"></div>
	</div>
	<br/>	
	<div>
		<button type="button" id="activateBtnId">Activate</button>
	</div>
	<!-- Popup window -->
	<div id="alertWindowId">
        <div id="alertMessageId"></div>
     </div>           
</div>

<!-- Include Java Script file to execute JQuery events. -->
<script type="text/javascript" src="/MongoInHealthCareHub/resources/scripts/doctor.js"></script>
