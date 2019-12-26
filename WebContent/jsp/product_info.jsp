<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
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
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resource/css/style.css"
	type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>

	<%@include file="/jsp/head.jsp"%>
	<!-- 静态包含：将所有内容包含进来 -->


	<div class="container">
		<div class="row">
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="${pageContext.request.contextPath}">首页&nbsp;&nbsp;&gt;</a>&nbsp;&nbsp;商品详情
			</div>

			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6">
					<img style="opacity: 1; width: 400px; height: 350px;" title=""
						class="medium"
						src="${pageContext.request.contextPath}/${product.image}">
				</div>

				<div class="col-md-6">
					<div>
						<strong>${product.product_name }</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>编号：${product.id }</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						商城价: <strong style="color: #ef0101;">￥：${product.mall_price }元</strong>
						市场价：
						<del>￥${product.market_price }元</del>
					</div>

					<div style="margin: 10px 0 10px 0;">
						促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"
							style="background-color: #f07373;">限时抢购</a>
					</div>

					<div
						style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<div style="margin: 5px 0 10px 0;">
							&nbsp;&nbsp;&nbsp;库存：${product.stock }件 <input type="hidden" id="stock"
								name="stock" value="${product.stock }">
						</div>


						<form id="form1" action="${pageContext.request.contextPath}/cart" method="post">
							<!-- 提交的方法 -->
							<input type="hidden" name="method" value="addToCart">
							<!-- 商品的编号 -->
							<input type="hidden" name="productId" value="${product.id }">
							<div
								style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
								购买数量: <input id="quantity" name="count" value="1"
									maxlength="4" size="10" type="text">
							</div>
						</form>
	
							<div style="margin: 20px 0 10px 0;; text-align: center;">
								<!-- <a href="javascript:void(0)" onclick="subForm()">  -->
								<input
									style="color:blue; background: url('${pageContext.request.contextPath}/Resource/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;"
									value="加入购物车" type="button" onclick="subForm()">
								<!-- </a> -->
								 &nbsp;收藏商品
							</div>
						
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍</strong>
				</div>

				<div>
					<img src="${pageContext.request.contextPath}/${product.image}">
				</div>

				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>${product.description }</strong>
				</div>

			</div>
		</div>
	</div>
	<div style="margin-top: 50px;">
		<img
			src="${pageContext.request.contextPath}/Resource/image/footer.jpg"
			width="100%" height="78" alt="我们的优势" title="我们的优势" />
	</div>

	<div style="text-align: center; margin-top: 5px;">
		<ul class="list-inline">
			<li><a href="${pageContext.request.contextPath}/jsp/info.jsp">关于我们</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/contact.jsp">联系我们</a></li>
			<li><a href="javascript:void(0)">招贤纳士</a></li>
			<li><a href="javascript:void(0)">法律声明</a></li>
			<li><a href="javascript:void(0)">友情链接</a></li>
			<li><a href="javascript:void(0)">支付方式</a></li>
			<li><a href="javascript:void(0)">配送方式</a></li>
			<li><a href="javascript:void(0)">服务声明</a></li>
			<li><a href="javascript:void(0)">广告声明</a></li>
		</ul>
	</div>
	<div style="text-align: center; margin-top: 5px; margin-bottom: 20px;">
		Copyright &copy; 电子商务系统 版权所有</div>
</body>
<script type="text/javascript">
	$(function() {
		$('#quantity').blur(function() {
			var stock = $('#stock').val();
			var quantity = $('#quantity').val();
			if (quantity > stock) {
				$('#quantity').val(stock);
			}
		});
	});
	
	function subForm(){
		//让指定的表单提交
		document.getElementById("form1").submit();
	}
</script>

</html>