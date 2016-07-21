$(document).ready(function() {

//Signup page - FAQ - Accordion : Start
$('#accordion').on('hidden.bs.collapse', function () {
	$(this).children(".panel").removeClass("active");
});

$('#accordion').on('shown.bs.collapse', function () {
	$(this).find(".in").parent(".panel").addClass("active");
});
//Signup page - FAQ - Accordion : End

//Reward page - Tooltip : Start
$(function (){
	 $("[data-toggle='tooltip']").tooltip();
});
//Reward page - Tooltip : End

/*Offer provider page:Start*/
$('.record-each .rec-button .btn').click(function(){

	if( $(this).hasClass("btn-primary") ){ $(this).removeClass('btn-primary').addClass('btn-success').html("<span class='fa fa-check'></span>ACTIVATED"); }
	else if($(this).hasClass("btn-success") ){ $(this).removeClass('btn-success').addClass('btn-primary').html("<span class='fa fa-star'></span>ACTIVATE"); }

});

$('.two-star-cont').click(function() {
	if ($(this).hasClass("btn-primary"))
	{
		$(this).parents(".row").next(".panel").find(".record-each .rec-button .btn-primary").removeClass('btn-primary').addClass('btn-success').html("<span class='fa fa-check'></span>ACTIVATED");
		$(this).removeClass("btn-primary").addClass("btn-success");
		$(this).html('<span class="fa fa-check"></span>ALL ACTIVATED');
	}
	else if($(this).hasClass("btn-success") )
	{
		$(this).parents(".row").next(".panel").find(".record-each .rec-button .btn-success").removeClass('btn-success').addClass('btn-primary').html("<span class='fa fa-star'></span>ACTIVATE");
		$(this).removeClass("btn-success").addClass("btn-primary");
		$(this).html('<div class="two-star"> ACTIVATE ALL </div>');
	}
});
/*Offer provider page:End */

/*Reward page:Start*/

$('.reward-act').click( function() {
	if( $(this).hasClass('fa-star')){
		$(this).removeClass('fa-star').addClass('fa-check green').attr( { "data-original-title" : "Activated", "data-toggle" : "tooltip", "data-placement" : "top" } );
		console.log($(this).parents("tr").find('.reward-activated').length);
		if($(this).parents("tr").find('.reward-activated').length < 1) $(this).parents("tr").find('.username').after("<small class='reward-activated'>Activated</small>");
		else $(this).parents("tr").find('.username').next(".reward-activated").html("Activated");
		$(this).next(".tooltip").remove();
	}
	else if( $(this).hasClass('fa-check green') ) {
		$(this).removeClass('fa-check green').addClass('fa-star').attr( { "data-original-title" : "Activate", "data-toggle" : "tooltip", "data-placement" : "top" } );
			$(this).parents("tr").find('.username').next(".reward-activated").remove();
			$(this).next(".tooltip").remove();
	}

});

$('#activate-all').on("click", function() {
	if( $(this).filter(':checked').length )
	{
		$(this).parents("table").find("tbody tr").each(function(){
			$(this).find('.reward-act').removeClass('fa-star').addClass('fa-check green').attr( { "data-original-title" : "Activated", "data-toggle" : "tooltip", "data-placement" : "top" } );
			if($(this).find('.reward-activated').length < 1) $(this).find('.username').after('<small class="reward-activated">Activated</small>');
			else $(this).find('.username').next(".reward-activated").html("Activated");
		});
	}
	else
	{
		$(this).parents("table").find('.reward-act').removeClass('fa-check green').addClass('fa-star').attr( { "data-original-title" : "Activate", "data-toggle" : "tooltip", "data-placement" : "top" } );
		$(this).parents("table").find('.username').next(".reward-activated").remove();
	}

});

/*Reward page:End*/

/*Offers now Page Start*/
$('.offer-act').click( function() {
    if( $(this).hasClass("btn-primary") ){ $(this).removeClass('btn-primary').addClass('btn-success').html("<i class='fa fa-check'></i>ACTIVATED"); }
	else if($(this).hasClass("btn-success") ){ $(this).removeClass('btn-success').addClass('btn-primary').html("<i class='fa fa-star'></i>ACTIVATE"); }

    /*if( $(this).hasClass('btn-primary')) {
        $(this).removeClass('btn-primary').addClass('btn-success').next().removeClass('fa-star').addClass('fa-check');
    }
    else if( $(this).hasClass('btn-success') ) {
        $(this).removeClass('btn-success').addClass('btn-primary').next().removeClass('fa-check').addClass('fa-star');
    }*/

});
/*Offers Now Page End */

/*Contact Us Page Start*/
$("#contactUsPhone").mask("999-999-9999");

$('#contact-us-modal').on('hidden.bs.modal', function () {
	$("span[id$=Error]").text('');
	$("input[type=text]").val('');
	$("#message").val('');
});
/*Contact Us Page End*/

});

function buildDropDown(url, controlId) {
	$.ajax({
        type: "GET",
        url: url,
        data: '',
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
        	$.each(data, function (index, value) {
            	$("#" + controlId).append($("<option></option>").val(this.id).html(this.name));
            });
        },
        error: function (err) {
        }
    });
}

var contactUsUrl = "/MongoInHealthCareHub/home/contactus";

function submitContactUs()
{
	var hasErrors = false;
	$("span[id$=Error]").text('');
	var contactUsName = $("#contactUsName").val();
	var contactUsPhone = $("#contactUsPhone").val();
	var contactUsEmail = $("#contactUsEmail").val();
	var contactUsMessage = $("#contactUsMessage").val();
	
	if(contactUsName.length == 0)
	{
		$("span[id=contactUsNameError]").text('Please enter name.');
		hasErrors = true;
	}
	if (contactUsPhone.length > 0 && !IsPhone(contactUsPhone)) {
    	$("span[id=contactUsPhoneError]").text("Please provide a valid phone number xxx-xxx-xxxx.");
    	hasErrors = true;
    }
	
	if (contactUsEmail.length > 0 && !IsEmail(contactUsEmail)) {
    	$("span[id=contactUsEmailError]").text("Please provide a valid email.");
    	hasErrors = true;
    }
	
	if(contactUsPhone.length == 0 && contactUsEmail.length == 0) {
		$("span[id=contactUsPhoneError]").text("Please provide phone or email.");
    	hasErrors = true;
	}
	
	if(contactUsMessage.length == 0)
	{
		$("span[id=contactUsMessageError]").text('Please provide message.');
		hasErrors = true;
	}
	
	if(hasErrors) return false;
	
	var ContactUs = { 
			  contactName: contactUsName,
			  phone: contactUsPhone,
			  email: contactUsEmail,
			  message: contactUsMessage,
			  contactIndicator: 'N'
		};
	var jsonInput = JSON.stringify(ContactUs);  
	
	$.ajax({
		contentType: "application/json",
		dataType: 'json', 
        data: jsonInput,
        cache: false,
        type: "POST", 
        url: contactUsUrl, 
		success : function(data) {
			if(data.statusCode === "OK")
			{
				$('#contact-us-modal').modal('hide');
			}
			else
			{
				$("span[id=contactUsError]").text("Please try some time later.");
				return;
			}
		}
	});
}

function IsPhone(phone) {
	var regex = /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/;
	return regex.test(phone);
}

function IsEmail(email) {
	var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email);
}