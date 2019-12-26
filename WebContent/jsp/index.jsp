<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/Resource/images/headlogo.png" />
<!-- 给网页标题前加一个小图标-->
<title>电子商务系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resource/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="container-fluid">

		<%@include file="/jsp/head.jsp"%>
		<!-- 静态包含：将所有内容包含进来 -->

		<!--
            	描述：轮播条
            -->
		<div class="container-fluid">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${pageContext.request.contextPath}/Resource/img/1.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/Resource/img/2.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/Resource/img/3.jpg">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<!--
            	描述：商品显示
            -->
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					热门商品&nbsp;&nbsp;<img
						src="${pageContext.request.contextPath}/Resource/img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2"
				style="border: 1px solid #E7E7E7; border-right: 0; padding: 0;">
				<img
					src="${pageContext.request.contextPath}/Resource/products/hao/big01.jpg"
					width="205" height="404" style="display: inline-block;" />
			</div>
			<div class="col-md-10">
				<div class="col-md-6"
					style="text-align: center; height: 200px; padding: 0px;">
					<a href="javascript:void(0)"> <img
						src="${pageContext.request.contextPath}/Resource/products/hao/middle01.jpg"
						width="516px" height="200px" style="display: inline-block;">
					</a>
				</div>

				<c:forEach items="${hotList }" var="p">
					<div class="col-md-2"
						style="text-align: center; height: 200px; padding: 10px 0px;">
						<a
							href="${pageContext.request.contextPath}/product?method=getProductById&id=${p.id}">
							<img src="${pageContext.request.contextPath}/${p.image}"
							width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a
								href="${pageContext.request.contextPath}/product?method=getProductById&id=${p.id}"
								style='color: #666'>${fn:substring(p.product_name,0,10)}..</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size: 16px">&yen;${p.mall_price }</font>
						</p>
					</div>
				</c:forEach>

			</div>
		</div>
		<!--
            	描述：广告部分
            -->
		<div class="container-fluid">
			<img
				src="${pageContext.request.contextPath}/Resource/products/hao/ad.jpg"
				width="100%" />
		</div>
		<!--
            	描述：商品显示
            -->
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					最新商品&nbsp;&nbsp;<img
						src="${pageContext.request.contextPath}/Resource/img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2"
				style="border: 1px solid #E7E7E7; border-right: 0; padding: 0;">
				<img
					src="${pageContext.request.contextPath}/Resource/products/hao/big01.jpg"
					width="205" height="404" style="display: inline-block;" />
			</div>
			<div class="col-md-10">
				<div class="col-md-6"
					style="text-align: center; height: 200px; padding: 0px;">
					<a href="javascript:void(0)"> <img
						src="${pageContext.request.contextPath}/Resource/products/hao/middle01.jpg"
						width="516px" height="200px" style="display: inline-block;">
					</a>
				</div>

				<c:forEach items="${newList }" var="p">
					<div class="col-md-2"
						style="text-align: center; height: 200px; padding: 10px 0px;">
						<a
							href="${pageContext.request.contextPath}/product?method=getProductById&id=${p.id}">
							<img src="${pageContext.request.contextPath}/${p.image}"
							width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a
								href="${pageContext.request.contextPath}/product?method=getProductById&id=${p.id}"
								style='color: #666'>${fn:substring(p.product_name,0,10)}..</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size: 16px">&yen;${p.mall_price }</font>
						</p>
					</div>
				</c:forEach>

			</div>
		</div>
		<!--
            	描述：页脚部分
            -->
		<div class="container-fluid">
			<div style="margin-top: 50px;">
				<img
					src="${pageContext.request.contextPath}/Resource/img/footer.jpg"
					width="100%" height="78" alt="我们的优势" title="我们的优势" />
			</div>

			<div style="text-align: center; margin-top: 5px;">
				<ul class="list-inline">
					<li><a href="${pageContext.request.contextPath}/jsp/info.jsp">关于我们</a></li>
					<li><a href="javascript:void(0)">联系我们</a></li>
					<li><a href="javascript:void(0)">招贤纳士</a></li>
					<li><a href="javascript:void(0)">法律声明</a></li>
					<li><a href="javascript:void(0)">友情链接</a></li>
					<li><a href="javascript:void(0)">支付方式</a></li>
					<li><a href="javascript:void(0)">配送方式</a></li>
					<li><a href="javascript:void(0)">服务声明</a></li>
					<li><a href="javascript:void(0)">广告声明</a></li>
				</ul>
			</div>
			<div
				style="text-align: center; margin-top: 5px; margin-bottom: 20px;">
				Copyright &copy; 电子商务系统 版权所有</div>
		</div>
	</div>
</body>

</html>