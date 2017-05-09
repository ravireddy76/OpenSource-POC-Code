<html>
<head>
<body>
	<p>You're logged in!!</p>
	<h3>Logged In Users...</h3>
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 600px">
			<tr>
				<th>User</th>
				<th>Password</th>
			</tr>

			<tr ng-repeat="user in users">
				<td>{{ user.userId}}</td>
				<td>{{ user.password }}</td>
			</tr>
		</table>
	</div>

</body>
</head>
</html>