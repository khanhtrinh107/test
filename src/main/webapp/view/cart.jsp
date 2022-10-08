<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<style type="text/css">
body {
	background: #ddd;
	min-height: 100vh;
	vertical-align: middle;
	display: flex;
	font-family: sans-serif;
	font-size: 0.8rem;
	font-weight: bold;
}

.title {
	margin-bottom: 5vh;
}

.card {
	margin: auto;
	max-width: 950px;
	width: 90%;
	box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	border-radius: 1rem;
	border: transparent;
}

@media ( max-width :767px) {
	.card {
		margin: 3vh auto;
	}
}

.cart {
	background-color: #fff;
	padding: 4vh 5vh;
	border-bottom-left-radius: 1rem;
	border-top-left-radius: 1rem;
}

@media ( max-width :767px) {
	.cart {
		padding: 4vh;
		border-bottom-left-radius: unset;
		border-top-right-radius: 1rem;
	}
}

.summary {
	background-color: #ddd;
	border-top-right-radius: 1rem;
	border-bottom-right-radius: 1rem;
	padding: 4vh;
	color: rgb(65, 65, 65);
}

@media ( max-width :767px) {
	.summary {
		border-top-right-radius: unset;
		border-bottom-left-radius: 1rem;
	}
}

.summary .col-2 {
	padding: 0;
}

.summary .col-10 {
	padding: 0;
}

.row {
	margin: 0;
}

.title b {
	font-size: 1.5rem;
}

.main {
	margin: 0;
	padding: 2vh 0;
	width: 100%;
}

.col-2, .col {
	padding: 0 1vh;
}

a {
	padding: 0 1vh;
}

.close {
	margin-left: auto;
	font-size: 0.7rem;
}

img {
	width: 3.5rem;
}

.back-to-shop {
	margin-top: 4.5rem;
}

h5 {
	margin-top: 4vh;
}

hr {
	margin-top: 1.25rem;
}

form {
	padding: 2vh 0;
}

select {
	border: 1px solid rgba(0, 0, 0, 0.137);
	padding: 1.5vh 1vh;
	margin-bottom: 4vh;
	outline: none;
	width: 100%;
	background-color: rgb(247, 247, 247);
}

input {
	border: 1px solid rgba(0, 0, 0, 0.137);
	padding: 1vh;
	margin-bottom: 4vh;
	outline: none;
	width: 100%;
	background-color: rgb(247, 247, 247);
}

input:focus::-webkit-input-placeholder {
	color: transparent;
}

.btn {
	background-color: #000;
	border-color: #000;
	color: white;
	width: 100%;
	font-size: 0.7rem;
	margin-top: 4vh;
	padding: 1vh;
	border-radius: 0;
}

.btn:focus {
	box-shadow: none;
	outline: none;
	box-shadow: none;
	color: white;
	-webkit-box-shadow: none;
	-webkit-user-select: none;
	transition: none;
}

.btn:hover {
	color: white;
}

a {
	color: black;
}

a:hover {
	color: black;
	text-decoration: none;
}

#code {
	background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253),
		rgba(255, 255, 255, 0.185)),
		url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
	background-repeat: no-repeat;
	background-position-x: 95%;
	background-position-y: center;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="card">
		<div class="row">
			<div class="col-md-8 cart">
				<div class="title">
					<div class="row">
						<div class="col">
							<h4>
								<b>Shopping Cart</b>
							</h4>
						</div>
						<div class="col align-self-center text-right text-muted">${list.size()}
							items</div>
					</div>
				</div>
				
				<c:forEach items="${list}" var="i">
					<div class="row border-top border-bottom">
					<div class="row main align-items-center">
						<div class="col-2">
							<img class="img-fluid" src="${i.getProduct().getImage() }">
						</div>
						<div class="col">
							<div class="row">${i.getProduct().getName()}</div>
						</div>
						<div class="col">
							<a href="process?cnt=${i.quantity-1}&id=${i.getProduct().getId()}">-</a><a href="#" class="border">${i.quantity}</a><a href="process?cnt=${i.quantity+1}&id=${i.getProduct().getId()}">+</a>
						</div>
						<div class="col">
							 ${i.getPrice()*i.quantity} <a href="deleteItem?id=${i.getProduct().getId()}" class = "close" name = "close" value = "1">&#10005;</a>
						</div>
					</div>
				</div>				
				</c:forEach>
				<div class="back-to-shop">
					<a href="home">&leftarrow;</a><span class="text-muted">Back to
						shop</span>
				</div>
			</div>
			<div class="col-md-4 summary">
				<div>
					<h5>
						<b>Summary</b>
					</h5>
				</div>
				<hr>
				<div class="row">
					<div class="col" style="padding-left: 0;">ITEMS ${list.size()}</div>
					<div class="col text-right">${total} $</div>
				</div>
				<form>
					<p>SHIPPING</p>
					<select><option class="text-muted">Standard-Delivery-
							&euro;5.00</option></select>
					<p>GIVE CODE</p>
					<input id="code" placeholder="Enter your code">
				</form>
				<div class="row"
					style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
					<div class="col">TOTAL PRICE</div>
					<div class="col text-right">${total} $</div>
				</div>
				<button class="btn">CHECKOUT</button>
			</div>
		</div>

	</div>
</body>
</html>