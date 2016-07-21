<div class="col-md-8 offer-main pd">
		<div class="row">
			<div class="offer-providers">
				<div class="container">
				
					 <div id="med-map-canvas" style="height:700px; width:770px;"></div>
					 <br/>
					 <div>
						<small class="container-fluid"><b>Medication Name:</b></small> 
						<input type="text" name="medicationNameId" id="medicationNameId"></input>
						<button type="button" id="searchMedBtnId" onclick="javascript:searchMemberMedicationUsageAction();">Search</button>
				 	 </div>
				</div>
			</div>
		</div>
		
		<div id='medicationChartId' class="img-responsive"
			style="width: 500px; height: 400px; position: relative;">
		</div>
</div>

<!-- Include Java Script file to execute JQuery events. -->
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script type="text/javascript" src="/MongoInHealthCareHub/resources/scripts/medication.js"></script> 
 


