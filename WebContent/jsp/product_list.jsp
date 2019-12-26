<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/Resource/images/headlogo.png" /><!-- 给网页标题前加一个小图标-->
		<title>电子商务系统</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resource/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Resource/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
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


		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}">首页&nbsp;&nbsp;&gt;</a>&nbsp;&nbsp;分类商品</li>
				</ol>
			</div>
 
			<c:forEach items="${productPageBean.data }" var="p">
			<div class="col-md-2">
				<a href="${pageContext.request.contextPath}/product?method=getProductById&id=${p.id}">
					<img src="${pageContext.request.contextPath}/${p.image}" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="${pageContext.request.contextPath}/product?method=getProductById&id=${p.id}" style='color:green'>${fn:substring(p.product_name,0,10)}..</a></p>
				<p><font color="#FF0000">商城价：&yen;${p.mall_price }</font></p>
			</div>
			</c:forEach>

		</div>

		<!--分页 -->
		<c:if test="${empty productPageBean.data }">
			<h3 style="font-family: 华文行楷">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好，该分类下暂无商品~_~</h3>
			<br><br>
		</c:if>
		<c:if test="${not empty productPageBean.data }">
			<div style="width:380px;margin:0 auto;margin-top:50px;">
				<ul class="pagination" style="text-align:center; margin-top:10px;">
					
					<!-- 判断是否是第一页 -->
					<c:if test="${productPageBean.pageNumber == 1 }">
						<li class="disabled">
							<a href="javascript:void(0)" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					
					<!-- 不是第一页 --><!-- ${param.categoryId} 从地址栏中获取 categoryId-->
					<c:if test="${productPageBean.pageNumber != 1 }">
						<li>
							<a href="${pageContext.request.contextPath}/product?method=findProductByPageAndCategoryId&pageNumber=${productPageBean.pageNumber-1}&categoryId=${param.categoryId}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					
					<!-- 展示所有页码 -->
					<c:forEach begin="1" end="${productPageBean.totalPage }" var="n">
						<!-- 判断是否是当前页 -->
						<c:if test="${productPageBean.pageNumber == n }">
							<li class="active"><a href="javascript:void(0)">${n }</a></li>
						</c:if>
						<!-- 不是当前页 -->
						<c:if test="${productPageBean.pageNumber != n }">
							<li><a href="${pageContext.request.contextPath}/product?method=findProductByPageAndCategoryId&pageNumber=${n}&categoryId=${param.categoryId}">${n }</a></li>
						</c:if>
					</c:forEach>
					
					<!-- 判断是否是最后一页 -->
					<c:if test="${productPageBean.pageNumber == productPageBean.totalPage }">
						<li class="disabled">
							<a href="javascript:void(0)" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
					
					<!-- 不是最后一页 -->
					<c:if test="${productPageBean.pageNumber != productPageBean.totalPage }">
						<li>
							<a href="${pageContext.request.contextPath}/product?method=findProductByPageAndCategoryId&pageNumber=${productPageBean.pageNumber+1}&categoryId=${param.categoryId}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</c:if>
		<!-- 分页结束=======================        -->

		<!--
       		商品浏览记录:
        -->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px; font-family: 微软雅黑;">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="javascript:void(0)">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">

			<ul style="list-style: none;">
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="${pageContext.request.contextPath}/Resource/products/1/cs10001.jpg"
					width="130px" height="130px" /></li>
			</ul>

		</div>
	</div>

	<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/Resource/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
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
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 电子商务系统 版权所有
		</div>

	</body>

</html>