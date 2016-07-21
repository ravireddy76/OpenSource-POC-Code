<div class="modal fade" id="contact-us-modal" tabindex="-1" data-backdrop="static"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" id="test" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Contact Us</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-4"></label>
						<div class="col-sm-8">
							<span id="contactUsError" class="error"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="contactUsName" class="col-sm-2 control-label">Ravi Reddy</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="contactUsName"
								placeholder="full name..." /> <span id="contactUsNameError"
								class="error"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="contactUsPhone" class="col-sm-2 control-label">Phone</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="contactUsPhone"
								placeholder="xxx-xxx-xxxx" /> <span id="contactUsPhoneError"
								class="error"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="contactUsEmail" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="contactUsEmail"
								placeholder="enter email..." /> <span id="contactUsEmailError"
								class="error"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="contactUsMessage" class="col-sm-2 control-label">Message</label>
						<div class="col-sm-9">
							<textarea id="contactUsMessage" class="form-control" style="resize: none"
								rows="5" placeholder="4000 characters length..."></textarea>
							<span id="contactUsMessageError" class="error"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">&nbsp;</label>
						<div class="col-sm-9">
							<input type="button" class="btn btn-primary pull-right caps"
								id="contactUsSubmit" value="Submit"
								onclick="javascript: submitContactUs();" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>