$(document).ready(function() {
		$("#dvTerms").jqxWindow({
			height : 150,
			width : 300,
			theme : 'summer',
			isModal : true,
			resizable: false,
			draggable: false,
			okButton: $('#dvTermsOk'),
			autoOpen : false
		});
		$("#dvPrivacy").jqxWindow({
			height : 150,
			width : 300,
			theme : 'summer',
			isModal : true,
			resizable: false,
			draggable: false,
			okButton: $('#dvPrivacy'),
			autoOpen : false
		});
		$("#termsLink").click(function() {
			$("#dvTerms").jqxWindow('open');
		});
		$("#privacyLink").click(function() {
			$("#dvPrivacy").jqxWindow('open');
		});
	});
	function DoRegister() {
		var redirectUtl = "/MongoInHealthCareHub/dashboard/dbdetails";
		$("#spanPasswordMatchError").hide();
		var email = $("#txtUsername").val();
		var password = $("#txtPassword").val();
		var checkPassword = $("#txtCheckPassword").val();

		if (password.length > 0 && (password == checkPassword)) {
			location.replace(redirectUtl);
		} else {
			$("#spanPasswordMatchError").show();
			return false;
		}
	}