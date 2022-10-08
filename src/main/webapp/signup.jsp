<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style type="text/css">
.modal-content {
	position: relative;
	background-color: #ffffff;
	border: 1px solid #999999;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 0;
	outline: none;
	-webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	background-clip: padding-box;
}

.modal-header {
	border-bottom: 1px solid #48a4ac;
	background: #61bdc5;
	min-height: 16.4286px;
	padding: 10px 15px;
}

.close {
	float: right;
	font-size: 21px;
	font-weight: 700;
	line-height: 1;
	color: #000;
	text-shadow: 0 1px 0 #fff;
	opacity: .2;
	filter: alpha(opacity = 20);
}

.modal-body {
	position: relative;
	padding: 20px;
}

.modal-footer {
	padding: 19px 20px 20px;
	margin-top: 0;
	text-align: right;
	border-top: 1px solid #e5e5e5;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<i class="fa fa-times"></i>
					</button>
					<h4 class="modal-title">Ready to Join? Create a New Account</h4>
				</div>

				<form action="signup" method="post">
					<div class="modal-body">
						<p>${mess}</p>
						<div class="form-group">
							<label for="userEmail">Username</label> <input type="text"
								class="form-control" required="" name="user" value="">
							
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" required="" name="pass" value="">
									<span class="help-block">Choose a password for your new
										account.</span>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="passwordr">Repeat Password</label> <input
										type="password" class="form-control" required=""
										name="passr" value=""> <span class="help-block">Type
										the password again. Passwords must match.</span>
								</div>
							</div>
						</div>
					</div>

					<div class="modal-footer">
						<input type="hidden" name="isEmpty" value="">
						<button type="input" name="submit" value="newAccount"
							class="btn btn-success btn-icon">
							<i class="fa fa-check"></i> Create My Account
						</button>
						<button type="button" class="btn btn-default btn-icon"
							data-dismiss="modal">
							<i class="fa fa-times-circle"></i> Cancel
						</button>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>