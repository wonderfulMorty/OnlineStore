<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>订单详情</strong>
				<hr>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
							<!-- colspan： 单元格横跨的列数 -->
							<th colspan="2">订 单 号 :${order.id}</th>
							<th colspan="1"><c:if test="${order.state == 0 }">去付款</c:if>
								<c:if test="${order.state == 1 }">已付款</c:if> <c:if
									test="${order.state == 2 }">确认收货</c:if> <c:if
									test="${order.state == 3 }">已完成</c:if>
							</th>
							<th colspan="2">下单时间: <fmt:formatDate
									value="${order.order_time }" pattern="yyyy-MM-dd HH:mm:ss" />
							</th>
						</tr>
						<tr class="warning">
							<th style="font-family: 华文行楷; font-size: larger;">图 片</th>
							<th style="font-family: 华文行楷; font-size: larger;">商 品</th>
							<th style="font-family: 华文行楷; font-size: larger;">价 格</th>
							<th style="font-family: 华文行楷; font-size: larger;">数 量</th>
							<th style="font-family: 华文行楷; font-size: larger;">小 计</th>
						</tr>
						<c:forEach items="${order.items }" var="oi">
							<tr class="active">
								<td width="60" width="40%"><input type="hidden" name="id"
									value="22"> <img
									src="${pageContext.request.contextPath}/${oi.product.image}"
									width="70" height="60"></td>
								<td width="30%"><a target="_blank">${oi.product.product_name}</a>
								</td>
								<td width="20%">￥${oi.product.mall_price}</td>
								<td width="10%">${oi.count}</td>
								<td width="15%"><span class="subtotal">￥${oi.subtotal}</span>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div style="text-align: right; margin-right: 120px;">
				商品金额: <strong style="color: #ff6600;">￥${order.total}元</strong>
			</div>

		</div>

		<div>
			<hr />
			<form id="orderForm" action="${pageContext.request.contextPath }/order"
				method="post" class="form-horizontal"
				style="margin-top: 5px; margin-left: 150px;">
				<!-- 提交的方法 -->
				<input type="hidden" name="method" value="pay">
				<!-- 订单号 -->
				<input type="hidden" name="orderId" value="${order.id}">
				<div class="form-group">
					<label for="address" class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="address" name="address"
							placeholder="请输入收货地址">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-1 control-label">收货人</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="请输收货人">
					</div>
				</div>
				<div class="form-group">
					<label for="telephone" class="col-sm-1 control-label">电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="telephone" name="telephone"
							placeholder="请输入联系方式">
					</div>
				</div>
				<hr />

				<div style="margin-top: 5px; margin-left: 150px;">
					<strong>选择银行：</strong>
					<p>
						<br /> <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"
							checked="checked" />工商银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/icbc.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="BOC-NET-B2C" />中国银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/bc.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="ABC-NET-B2C" />农业银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/abc.bmp"
							align="middle" /> <br /> <br /> <input type="radio"
							name="pd_FrpId" value="BOCO-NET-B2C" />交通银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/bcc.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="PINGANBANK-NET" />平安银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/pingan.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="CCB-NET-B2C" />建设银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/ccb.bmp"
							align="middle" /> <br /> <br /> <input type="radio"
							name="pd_FrpId" value="CEB-NET-B2C" />光大银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/guangda.bmp"
							align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行 <img
							src="${pageContext.request.contextPath}/Resource/bank_img/cmb.bmp"
							align="middle" />

					</p>
					<hr />
					<p style="text-align: right; margin-right: 100px;">
						<a
							onclick="submitForm()">
							<img
							src="${pageContext.request.contextPath}/Resource/images/finalbutton.gif"
							width="204" height="51" border="0" />
						</a>
					</p>
					<hr />

				</div>
			</form>
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
function submitForm() {
	if ($('#address').val()=="" || $('#name').val()=="" || $('#telephone').val()==""){
		alert("收货地址/联系人/联系电话 不能为空！");
	}else{
		document.getElementById('orderForm').submit();
	}
}
</script>
</html>