<div class="container">

	<!-- <div class="row" ng-init="pCtrl.fetchProducts()"> -->

	<div class="col-md-3">
		<%@include file="sidebar.jsp"%>
	</div>

	<div class="col-md-9">

		<div class="row carousel-holder">

			<div class="col-md-12">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					</ol>
					<div class="carousel-inner">

						<div class="item active">
							<img class="slide-image" src="images/banner1.jpg" alt="">
						</div>
						<div class="item">
							<img class="slide-image" src="images/banner2.jpg" alt="">
						</div>
						<div class="item">
							<img class="slide-image" src="images/banner3.jpg" alt="">
						</div>
						<div class="item">
							<img class="slide-image" src="images/banner4.jpg" alt="">
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-xs-12">
				<h3>Our Most Viewed Products</h3>
				<hr />
			</div>
		</div>

		<div class="row is-table-row">
			<c:forEach items="${mostviewedProducts}" var="mostviewedProducts">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="images/${mostviewedProducts.code}.jpg" alt=""
							class="landingImg">
						<h5>${mostviewedProducts.name}</h5>
						<hr />
						<div class="caption">
							<h4 class="pull-right">&#8377;
								${mostviewedProducts.unitPrice}</h4>
							<p>${mostviewedProducts.description}</p>
							<a href="" class="btn btn-primary pull-right">View</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<div class="col-sm-4 col-lg-4 col-md-4">
			<h4>Checkout more products!</h4>
			<hr />
			<a class="btn btn-primary" href="${contextRoot}/showallProducts">More
				Products</a>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h3>Our Most Purchased Products</h3>
				<hr />
			</div>
		</div>
		
		<div class="row is-table-row">
			<c:forEach items="${mostviewedProducts}" var="mostviewedProducts">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="images/${mostviewedProducts.code}.jpg" alt=""
							class="landingImg">
						<h5>${mostviewedProducts.name}</h5>
						<hr />
						<div class="caption">
							<h4 class="pull-right">&#8377;
								${mostviewedProducts.unitPrice}</h4>
							<p>${mostviewedProducts.description}</p>
							<a href="" class="btn btn-primary pull-right">View</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
			

			<div class="col-sm-4 col-lg-4 col-md-4">
				<h4>Checkout more products!</h4>
				<hr />
				<a class="btn btn-primary" href="/showallProducts">More Products</a>
			</div>

		

	</div>
	<!-- col-md-9 -->




</div>

</div>

</div>
<!-- /.container -->
