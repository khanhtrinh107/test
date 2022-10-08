<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
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

/*
** Style Simple Ecommerce Theme for Bootstrap 4
** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
*/
.bloc_left_price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 150%;
}

.category_block li:hover {
	background-color: #007bff;
}

.category_block li:hover a {
	color: #ffffff;
}

.category_block li a {
	color: #343a40;
}

.add_to_cart_block .price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 200%;
	margin-bottom: 0;
}

.add_to_cart_block .price_discounted {
	color: #343a40;
	text-align: center;
	text-decoration: line-through;
	font-size: 140%;
}

.product_rassurance {
	padding: 10px;
	margin-top: 15px;
	background: #ffffff;
	border: 1px solid #6c757d;
	color: #6c757d;
}

.product_rassurance .list-inline {
	margin-bottom: 0;
	text-transform: uppercase;
	text-align: center;
}

.product_rassurance .list-inline li:hover {
	color: #343a40;
}

.reviews_product .fa-star {
	color: gold;
}

.pagination {
	margin-top: 20px;
}

footer {
	background: #343a40;
	padding: 40px;
	margin-top: 20px;
}

footer a {
	color: #f8f9fa !important
}

.bgc {
	background-image: url(image/Clothes+and+shoes-74_banner.jpg);
	/*background-image: url("https://envato-shoebox-0.imgix.net/a553/ba21-ce80-45ee-82d4-120907cdb414/Clothes+and+shoes-74_banner.jpg?auto=compress%2Cformat&fit=max&mark=https%3A%2F%2Felements-assets.envato.com%2Fstatic%2Fwatermark2.png&markalign=center%2Cmiddle&markalpha=18&w=1600&s=a9cc1545e602fe3d3e6c9faed39f0a84");*/
}

.show_txt {
	display: inline-block;
	width: 100%;
	white-space: nowrap;
	overflow: hidden !important;
	text-overflow: ellipsis;
}

a .active {
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Category</a></li>
						<li class="breadcrumb-item active" aria-current="#">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<jsp:include page="Left.jsp"></jsp:include>

			<div class="col-sm-9">
				<div class="row">
					<c:forEach items="${list}" var="o">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card">
								<img class="card-img-top" src="${o.image }" alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title show_txt">
										<a href="detail?id=${o.id}" title="View Product">${o.name }</a>
									</h4>
									<p class="card-text show_txt">${o.title }</p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${o.price}$</p>
										</div>
										<div class="col">
											<a href="addToCart?cartid=${o.id}" class="btn btn-success btn-block">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:if test="${ind != 1}">
								<li class="page-item"><a class="page-link"
									href="home?index=${ind-1}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page}" var="i">
								<c:if test="${ind == i}">
									<li class="page-item active"><a class="page-link"
										href="home?index=${i}">${i}</a></li>
								</c:if>
								<c:if test="${ind != i}">
									<li class="page-item"><a class="page-link"
										href="home?index=${i}">${i}</a></li>
								</c:if>
							</c:forEach>

							<c:if test="${ind != page }">
								<li class="page-item"><a class="page-link"
									href="home?index=${ind+1}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
				</div>

			</div>

		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>

