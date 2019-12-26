<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript "
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript "
	src="${pageContext.request.contextPath}/js/bootstrap-paginator.js"></script>
<script type="text/javascript "
	src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
</HEAD>
<body>
	<br>

	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0" id="rootTable">

		<TBODY>
			<tr>
				<td height="40" class="ta_01" align="center" bgColor="#afd1f3">
					<strong style="font-family: 华文行楷; font-size: xx-large;">已上架商品列表</strong>
				</TD>
			</tr>
			<tr>
				<td class="ta_01" align="right">&nbsp;</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<%-- <table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="9%"
								style="font-size: x-large; font-family: 华文行楷">序号</td>
							<td align="center" width="15%"
								style="font-size: x-large; font-family: 华文行楷">商品图片</td>
							<td align="center" width="25%"
								style="font-size: x-large; font-family: 华文行楷">商品名称</td>
							<td align="center" width="15%"
								style="font-size: x-large; font-family: 华文行楷">商品价格</td>
							<td align="center" width="10%"
								style="font-size: x-large; font-family: 华文行楷">是否热门</td>
							<td align="center" width="15%"
								style="font-size: x-large; font-family: 华文行楷">商品库存</td>
							<!-- <td width="7%" align="center">
										编辑
									</td> -->
							<td width="10%" align="center"
								style="font-size: x-large; font-family: 华文行楷">删除</td>
						</tr>
					<c:forEach items="${productLis.data}" var="p" varStatus="vs">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px; font-size: large;"
									align="center" width="9%">${vs.count }</td>
								<td style="CURSOR: hand; HEIGHT: 22px; font-size: large;"
									align="center" width="15%"><img width="40" height="45"
									src="${ pageContext.request.contextPath }/${p.image}"></td>
								<td style="CURSOR: hand; HEIGHT: 22px; font-size: large;"
									align="center" width="25%">${p.product_name }</td>
								<td style="CURSOR: hand; HEIGHT: 22px; font-size: large;"
									align="center" width="15%">${p.mall_price }</td>
								<td style="CURSOR: hand; HEIGHT: 22px; font-size: large;"
									align="center" width="10%"><c:if test="${p.is_hot==1 }">是</c:if>
									<c:if test="${p.is_hot!=1 }">否</c:if></td>
								<td style="CURSOR: hand; HEIGHT: 22px; font-size: large;"
									align="center" width="15%">${p.stock }</td>
								<td align="center" style="HEIGHT: 22px; font-size: large;">
												<a href="${ pageContext.request.contextPath }/adminProduct_edit.action?pid=">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>

								<td align="center" style="HEIGHT: 22px; font-size: large;">
									<a href="javascript:void(0);"
									onclick="shelfDownProduct('${p.id}')"> <img
										src="${pageContext.request.contextPath}/Resource/images/i_del.gif"
										width="16" height="16" border="0" style="CURSOR: hand">
								</a>
								</td>
							</tr>
						</c:forEach> 
					</table> --%>

					<table class="table  table-striped table-bordered table-hover "
						id="userTable">
					</table>

				</td>
			</tr>
		</TBODY>
	</table>
	<div style="text-align: center;">
		<ul id="useroption"></ul>
	</div>




</body>



<script type="text/javascript">
	function removeProduct(productId) {
		if (confirm("确定将该商品下架吗？")) {
			location.href = "${pageContext.request.contextPath}/adminProduct?method=shelfDown&productId="
					+ productId; 

		/* 
					$.ajax({
						url : "${pageContext.request.contextPath}/adminProduct?method=shelfDown&productId="
								+ productId,
						success : function(data) {
							alert(data)
							$("#rootTable").bootstrapTable("refresh", {
								silent : true
							//静态刷新
							});
						}

					}) */
			console.log("jj:" + productId);
		}
	}

	$(function() {
		$
				.ajax({
					type : 'post',
					dataType : "json",
					url : '${pageContext.request.contextPath}/adminProduct?method=findAll',
					success : function(res) {
						//var result = JSON.parse(res);
						tbody = "<tr style='background:#fff;'><th style='text-align: center;'>序号</th><th style='text-align: center;'>id号</th><th style='text-align: center;'>商品图片</th>"
								+ "<th style='text-align: center;'>商品名称</th><th style='text-align: center;'>商品价格</th><th style='text-align: center;'>是否热门</th>"
								+ "<th style='text-align: center;'>操作</th><tr>";
						for (var i = 0; i < res.total; i++) {//拼接对应<th>需要的值
							var trs = "";
							var is_hot = (res.data[i].is_hot == 1) ? "是 "
									: "否 ";
							trs += '<tr ><td style="text-align: center;">'
									+ (i + 1)
									+ '</td><td style="text-align: center;">'
									+ res.data[i].id
									+ '</td><td style="text-align: center;">'
									+ "<img src=${pageContext.request.contextPath}/"+res.data[i].image+">"
									+ '</td><td style="text-align: center;">'
									+ res.data[i].product_name
									+ '</td><td style="text-align: center;">'
									+ res.data[i].mall_price
									+ '</td><td style="text-align: center;">'
									+ is_hot
									+ '</td><td style="text-align: center;">'
									+ '<a href="javascript:void(0);" onclick="removeProduct('
									+ res.data[i].id
									+ ')">'
									+ '<img src="${pageContext.request.contextPath}/Resource/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">'
									+ '</a>'

									/* + '<a href="javascript:void(0);" onclick="updateProduct('
									+ res.data[i].id
									+ ')">'
									+ '<img src="${pageContext.request.contextPath}/Resource/images/i_edit.gif" width="16" height="16" border="0" style="CURSOR: hand">'
									+ '</a>' */

									+ '</td></tr>';
							tbody += trs;
						}

						$("#userTable").html(tbody);
						var currentPage = res.currentPage; //当前页数
						var pageCount = res.pages; //总页数

						var options = {
							bootstrapMajorVersion : 3, //版本

							currentPage : currentPage, //当前页数

							totalPages : pageCount, //总页数

							numberOfPages : 5,
							shouldShowPage : true,//是否显示该按钮

							itemTexts : function(type, page, current) {

								switch (type) {

								case "first":

									return "首页";

								case "prev":

									return "上一页";

								case "next":

									return "下一页";

								case "last":

									return "末页";

								case "page":

									return page;

								}

							},//点击事件，用于通过Ajax来刷新整个list列表

							onPageClicked : function(event, originalEvent,
									type, page) {
								$
										.ajax({
											async : true,
											url : "${pageContext.request.contextPath}/adminProduct?method=findAll",
											type : "post",
											dataType : "json",
											data : {
												page : page
											},
											cache : false,
											success : function(d) {
												//var result = JSON.parse(data);
												console.log(d)
												tbody = "<tr style='background:#fff;'><th style='text-align: center;'>序号</th><th style='text-align: center;'>id号</th><th style='text-align: center;'>商品图片</th>"
														+ "<th style='text-align: center;'>商品名称</th><th style='text-align: center;'>商品价格</th><th style='text-align: center;'>是否热门</th>"
														+ "<th style='text-align: center;'>操作</th></tr>";
												for (var i = 0; i < d.total; i++) {//拼接对应<th>需要的值
													var trs = "";
													var is_hot = (d.data[i].is_hot == 1) ? "是 "
															: "否 ";
													trs += '<tr ><td style="text-align: center;">'
															+ (i + 1)
															+ '</td><td style="text-align: center;">'
															+ d.data[i].id
															+ '</td><td style="text-align: center;">'
															+ "<img src=${pageContext.request.contextPath}/"+d.data[i].image+">"
															+ '</td><td style="text-align: center;">'
															+ d.data[i].product_name
															+ '</td><td style="text-align: center;">'
															+ d.data[i].mall_price
															+ '</td><td style="text-align: center;">'
															+ is_hot
															+ '</td><td style="text-align: center;">'
															+ '<a href="javascript:void(0);" onclick="removeProduct('
															+ res.data[i].id
															+ ')">'
															+ '<img src="${pageContext.request.contextPath}/Resource/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">'
															+ '</a>'
															+ '</td></tr>'

															/* + '<a href="javascript:void(0);" onclick="updateProduct('
															+ res.data[i].id
															+ ')">'
															+ '<img src="${pageContext.request.contextPath}/Resource/images/i_edit.gif" width="16" height="16" border="0" style="CURSOR: hand">'
															+ '</a>' */

													;
													tbody += trs;
												}
												$("#userTable").html(tbody);
											}/*success*/
										});

							}

						};
						$('#useroption').bootstrapPaginator(options);
					}/*success*/

				});

	})
</script>
</HTML>