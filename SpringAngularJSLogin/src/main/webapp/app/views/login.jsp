<html>
<head>
<body>
	<div class="col-md-6 col-md-offset-3">
		<h2>Login</h2>
		<form>
			<div class="table-responsive">
				<table class="table table-bordered" style="width: 600px">
					<tr>
						<td>UserName</td>
						<td><input type="text" id="userid" ng-model="vm.userId"
							size="30" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" id="password" ng-model="vm.password"
							size="30" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							class="btn btn-primary btn-sm" ng-click="vm.login()"
							value="Login" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</head>
</html>

