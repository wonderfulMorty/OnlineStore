<%--
    Author     : SakuraSora 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
    描述：菜单栏
-->
<div class="container-fluid">
	<div class="col-md-4">
		<%-- <img src="${pageContext.request.contextPath}/Resource/img/logo2.png" /> --%>
	</div>
	<div class="col-md-5">
		<img src="${pageContext.request.contextPath}/Resource/img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top: 20px">
		<ol class="list-inline">
			<c:if test="${empty user }">
				<li><a
					href="${pageContext.request.contextPath}/user?method=loginUI">登录</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user?method=registUI">注册</a></li>
			</c:if>
			<c:if test="${not empty user }">
							${user.account }：你好!
							<li><a
					href="${pageContext.request.contextPath}/order?method=findMyOrdersByPage&pageNumber=1">我的订单</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user?method=logout">退出</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath }/jsp/cart.jsp">购物车</a></li>
		</ol>
	</div>
</div>
<!--
    描述：导航条
-->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}">首页</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="c_ul">
					<!-- 分类信息 -->
				</ul>
			</div>
		</div>
	</nav>
</div>

<script type="text/javascript">
	$(function() {
		//发送ajax 查询所有分类
		$.post(
				"${pageContext.request.contextPath}/category",
				{
					"method" : "findAll"
				},
				function(obj) {
				//遍历json列表,获取每一个分类,包装成li标签,插入到ul内部
					$(obj).each(
							function() {
									$("#c_ul").append(
										"<li><a href='${pageContext.request.contextPath}/product?method=findProductByPageAndCategoryId&pageNumber=1&categoryId="
											+ this.id
											+ "'>"
											+ this.name
											+ "</a></li>");
							});
				}, 
				"json"
		);
	})
</script>