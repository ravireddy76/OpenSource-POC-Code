$(document).ready(function (){
    $("#medicationUsage").addClass('active');
 	$("#hdRewardNetwork").addClass('active');

	GetAllProviders(); 
});	



/**
 * Function to get user information.
 * @param userInfoUrl
 * 
 * @returns userInfo
 */
function getMemberMedicationUsage(memberMedicationUrl){
	var userInfo = $.ajax({
		  type: "GET",
		  url: memberMedicationUrl,
		  dataType: "json",									 
		  global: false,
		  async:false,
		  success: function(data) {				  
			 return data;		      
		  }
	  }).responseText;

	return userInfo;
}


