var UserProfileId=0;

$(document).ready(function(){
	$("#myInformation").addClass('active');
	GetUserProfile();
});

function GetUserProfile()
{
	var hasErrors = false;
	var getProfileUrl = "/MongoInHealthCareHub/user/profileInfo";
	$("span[id$=Error]").text('');
	if(hasErrors) return;
	$.ajax({
		contentType: "application/json",
		dataType: 'json', 
        cache: false,
        type: "GET", 
        url: getProfileUrl, 
        success: function(data) {
        	if(data !== ""){
        		UserProfileId = data.userProfileIdentifier;
        		var member = data.members[0];
        		$("#headerUserName").text(data.firstName +" "+data.lastName);
        		$("#userName").text(data.firstName +" "+data.lastName);
	       		$("#email").text(data.emailAddress).attr("href", "mailto:"+data.emailAddress);
	       		if(member !== ""){
	       			if(member.dateOfBirth != null){
	       				$("#dob").text(member.dateOfBirth);
	       			}
	       			var address = member.addressLine1;
       				if(member.addressLine2 != null){
       					address = address + ", " + member.addressLine2;
       				}
       				address = address + ", " + member.city;
       				address = address + ", " + member.state;
       				address = address + ", " + member.zipCode;
       				
	       			$("#address").text(address);
	       		}
        	}
        }
	});
}