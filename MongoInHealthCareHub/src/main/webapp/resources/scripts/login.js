var loginUrl = "/MongoInHealthCareHub/home/login";
var signUpUrl = "/MongoInHealthCareHub/home/signup";
var redirectUrl = "/MongoInHealthCareHub/dashboard/dbdetails";

$(document).ready(function(){
	//doLogin();
});

function doLogin() {
	var hasErrors = false;
	$("span[id$=Error]").text('');
	var email = $("#email").val();
	var password = $("#signin-password").val();
	var errorSpan = $("span[id=loginError]");
	if(email.length == 0)
	{
		hasErrors = true;
		errorSpan.text("enter email");
	}
	else {
		if(!IsEmail(email)){
			hasErrors = true;
			errorSpan.text("enter valid email");
		}
		else if(password.length == 0)
		{
			hasErrors = true;
			errorSpan.text("*enter password!");
		}
	}

	if(hasErrors) return false;

	var Login = {
			email: email,
			password: password
	};

	var jsonInput = JSON.stringify(Login);

	$.ajax({
		contentType: "application/json",
		dataType: 'json', 
		data: jsonInput,
		cache: false,
		type: "POST", 
		url: loginUrl, 
		success : function(data) {
			if(data.statusCode =="OK") {
				$("#email").val('');
				$("#password").val('');
				location.href = redirectUrl;
			}else {
				errorSpan.text("Invalid Email or Password");
				return;
			}
		}
	});
}

function doRegister()
{
	var hasErrors = false;
	$("span[id$=Error]").text('');
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var signUpEmail = $("#signUpEmail").val();
	var retypeEmail = $("#retypeEmail").val();
	var signUpPassword = $("#signUpPassword").val();
	var retypePassword = $("#retypePassword").val();
	var addressLine1 = $("#addressLine1").val();
	var addressLine2 = $("#addressLine2").val();
	var city = $("#city").val();
	var state = $("#state").val();
	var zipCode = $("#zipCode").val();
	
	if(firstName.length == 0)
	{
		$("span[id=firstNameError]").text('Please enter first name.');
		hasErrors = true;
	}
	if(lastName.length == 0)
	{
		$("span[id=lastNameError]").text('Please enter last name.');
		hasErrors = true;
	}
	if(signUpEmail.length == 0)
	{
		$("span[id=signUpEmailError]").text('Please enter an email.');
		hasErrors = true;
	}
	
	if (signUpEmail.length > 0 && !IsEmail(signUpEmail)) {
    	$("span[id=signUpEmailError]").text("Please provide a valid email address.");
    	hasErrors = true;
    }
	
	if(signUpEmail != retypeEmail)
	{
		$("span[id=retypeEmailError]").text('Emails do not match.');
		hasErrors = true;
	}
	
	if(signUpPassword.length == 0)
	{
		$("span[id=signUpPasswordError]").text('Please enter a password.');
		hasErrors = true;
	}
	
	if(signUpPassword.length > 0 && signUpPassword.length < 6)
	{
		$("span[id=signUpPasswordError]").text('Password should be at least 6 characters.');
		hasErrors = true;
	}
	
	if(signUpPassword.length > 0 && signUpPassword != retypePassword)
	{
		$("span[id=retypePasswordError").text('Passwords do not match.');
		hasErrors = true;
	}

	if(hasErrors) return false;
	
	var UserProfile = { 
			  firstName: firstName,
			  lastName: lastName,
			  emailAddress: signUpEmail,
			  userPassword: signUpPassword,
			  members: [{
				  		addressLine1: addressLine1,
			  			addressLine2: addressLine2,
			  			city: city,
			  			state: state,
			  			zipCode: zipCode,
			  			memberRegistrationIndicator: false
			            }]
		};
	var jsonInput = JSON.stringify(UserProfile);  
	
	$.ajax({
		contentType: "application/json",
		dataType: 'json', 
        data: jsonInput,
        cache: false,
        type: "POST", 
        url: signUpUrl, 
		success : function(data) {
			if(data.statusCode === "OK")
			{
				$("input[type=text]").val('');
				$("input[type=password]").val('');
				location.href = redirectUrl;
			}
			else if(data.statusCode === "NOT_ACCEPTABLE")
			{
				$("span[id=signUpError]").text("Email already exists.");
				return;
			}
			else
			{
				return;
			}
		}
	});
}

function loginInputKeyUp(e) { 
	e.which = e.which || e.keyCode;
	if(e.which == 13) {
		doLogin();
	}
}

$("input").keydown(function(event) {
	if (event.which == 13) {
		event.preventDefault();
		doLogin();
	}
});