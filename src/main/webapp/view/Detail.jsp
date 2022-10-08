<%-- 
    Document   : Detail
    Created on : Dec 29, 2020, 5:43:04 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .preview {
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    -webkit-flex-direction: column;
    -ms-flex-direction: column;
    flex-direction: column; }
@media screen and (max-width: 996px) {
    .preview {
        margin-bottom: 20px; } }

.preview-pic {
    -webkit-box-flex: 1;
    -webkit-flex-grow: 1;
    -ms-flex-positive: 1;
    flex-grow: 1; }

.preview-thumbnail.nav-tabs {
    border: none;
    margin-top: 15px; }
.preview-thumbnail.nav-tabs li {
    width: 18%;
    margin-right: 2.5%; }
.preview-thumbnail.nav-tabs li img {
    max-width: 100%;
    display: block; }
.preview-thumbnail.nav-tabs li a {
    padding: 0;
    margin: 0; }
.preview-thumbnail.nav-tabs li:last-of-type {
    margin-right: 0; }

.tab-content {
    overflow: hidden; }
.tab-content img {
    width: 100%;
    -webkit-animation-name: opacity;
    animation-name: opacity;
    -webkit-animation-duration: .3s;
    animation-duration: .3s; }

.card1 {
    /*background: #eee;*/
    padding: 3em;
    line-height: 1.5em; }

@media screen and (min-width: 997px) {
    .wrapper {
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex; } }

.details {
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    -webkit-flex-direction: column;
    -ms-flex-direction: column;
    flex-direction: column; }

.colors {
    -webkit-box-flex: 1;
    -webkit-flex-grow: 1;
    -ms-flex-positive: 1;
    flex-grow: 1; }

.product-title, .price, .sizes, .colors {
    text-transform: UPPERCASE;
    font-weight: bold; }

.checked, .price span {
    color: #ff9f1a; }

.product-title, .rating, .product-description, .price, .vote, .sizes {
    margin-bottom: 15px; }

.product-title {
    margin-top: 0; }

.size {
    margin-right: 10px; }
.size:first-of-type {
    margin-left: 40px; }

.color {
    display: inline-block;
    vertical-align: middle;
    margin-right: 10px;
    height: 2em;
    width: 2em;
    border-radius: 2px; }
.color:first-of-type {
    margin-left: 20px; }

.add-to-cart, .like {
    padding: 1.2em 1.5em;
    border: none;
    text-transform: UPPERCASE;
    font-weight: bold;
    color: #fff;
    -webkit-transition: background .3s ease;
    transition: background .3s ease; }
.add-to-cart:hover, .like:hover {
    background: #b36800;
    color: #fff; }

.not-available {
    text-align: center;
    line-height: 2em; }
.not-available:before {
    font-family: fontawesome;
    content: "\f00d";
    color: #fff; }

.orange {
    background: #ff9f1a; }

.green {
    background: #85ad00; }

.blue {
    background: #0076ad; }

.tooltip-inner {
    padding: 1.3em; }

@-webkit-keyframes opacity {
    0% {
        opacity: 0;
        -webkit-transform: scale(3);
        transform: scale(3); }
    100% {
        opacity: 1;
        -webkit-transform: scale(1);
        transform: scale(1); } }

@keyframes opacity {
    0% {
        opacity: 0;
        -webkit-transform: scale(3);
        transform: scale(3); }
    100% {
        opacity: 1;
        -webkit-transform: scale(1);
        transform: scale(1); } }
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
                <jsp:include page="Left.jsp"></jsp:include>
                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${detail.image}"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${detail.name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency">US $</span><span class="num">${detail.price}</span>
                                            </span> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Description</dt>
                                            <dd><p>
                                                    ${detail.description}
                                                </p></dd>
                                        </dl>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-5">
                                                <dl class="param param-inline">
                                                    <dt>Quantity: </dt>
                                                    <dd>
                                                        <select class="form-control form-control-sm" style="width:70px;">
                                                            <option> 1 </option>
                                                            <option> 2 </option>
                                                            <option> 3 </option>
                                                        </select>
                                                    </dd>
                                                </dl>  <!-- item-property .// -->
                                            </div> <!-- col.// -->

                                        </div> <!-- row.// -->
                                        <hr>
                                        <a href="#" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
                                        <a href="#" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->


                    </div>
                </div>
            </div>
        </div>
       <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
