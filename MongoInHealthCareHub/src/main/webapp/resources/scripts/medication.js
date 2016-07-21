/* Global variables.*/
var geocoder;
var map;

$(document).ready(function (){
    $("#medicationUsage").addClass('active');
 	$("#hdRewardNetwork").addClass('active');
 	
 	/* Medication search button */
	$("#searchMedBtnId").jqxButton(
		{ width: 90,theme: "black"}
	);

	/* Initialize the map.*/
	initializeMap();
});	


/** Method to search all members based on by medication.**/
function searchMemberMedicationUsageAction(){
	alert("Inside the searchMemberMedicationUsageAction()....");
	
	var medicationName = $("#medicationNameId").val();
	var memberHealthDataUrl = "/MongoInHealthCareHub/memberinfo/medicationUsage/"+medicationName;
	var medicationUsageJson = getMemberMedicationUsage(memberHealthDataUrl);
	var medicationUsageMembers = new Array();
	
	/* Paint the map using member address.*/
	$.each(JSON.parse(medicationUsageJson), function(idx, memberObj) {
		medicationUsageMembers.push(memberObj.memberAddress);
	});
	
	//alert("1 -> Number of Members =="+medicationUsageMembers.length);

	paintMap(medicationUsageMembers);
}


/**
 * Function to get user information.
 * @param userInfoUrl
 * 
 * @returns userInfo
 */
function getMemberMedicationUsage(memberMedicationUrl){
	var medicationUsageJson = $.ajax({
		  type: "GET",
		  url: memberMedicationUrl,
		  dataType: "json",									 
		  global: false,
		  async:false,
		  success: function(data) {				  
			 return data;		      
		  }
	  }).responseText;

	return medicationUsageJson;
}


function initializeMap() {
	  geocoder = new google.maps.Geocoder();
	  var latlng = new google.maps.LatLng(44.882026,  -93.268447);
	  var mapOptions = {
	    zoom: 5,
	    center: latlng
	  };
	 
	  map = new google.maps.Map(document.getElementById('med-map-canvas'), mapOptions);
}



/* Method to paint map for the given address address lat/long and mark google maps */
function paintMap(medicationUsageMembers) {	
	for(var iter = 0;iter < medicationUsageMembers.length;iter++){
		var memberAddress = medicationUsageMembers[iter];
		geocoder.geocode({'address': memberAddress}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
		      map.setCenter(results[0].geometry.location);
		      var marker = new google.maps.Marker({
		          map: map,
		          position: new google.maps.LatLng(results[0].geometry.location.lat(),results[0].geometry.location.lng())
		      });
		    } else {
		      alert('Geocode was not successful for the following reason: ' + status);
		    }
		  });
	}	
}


