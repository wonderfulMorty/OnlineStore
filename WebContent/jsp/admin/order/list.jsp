<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/Resource/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/Resource/layer/layer.js"></script>
		
	</HEAD>
	<body>
		<br>
		
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td height="40" class="ta_01" align="center" bgColor="#afd1f3">
							<strong style="font-family: 华文行楷; font-size: xx-large;">
								订单列表
							</strong>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="right">&nbsp;

						</td>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 15px; BACKGROUND-COLOR: #afd1f3">

									<th align="center" style="font-size: x-large; font-family: 华文行楷;">
										序号
									</th>
									<th align="center"  style="font-size: x-large; font-family: 华文行楷;">
										订单号
									</th>
									<th align="center"  style="font-size: x-large; font-family: 华文行楷;">
										订单金额
									</th>
									<th align="center"  style="font-size: x-large; font-family: 华文行楷;">
										收货人
									</th>
									<td align="center"  style="font-size: x-large; font-family: 华文行楷;">
										联系电话
									</th>
									<th align="center"  style="font-size: x-large; font-family: 华文行楷;">
										收货地址
									</th>
									<th align="center"  style="font-size: x-large; font-family: 华文行楷;">
										订单状态
									</th>
									<th align="center"  style="font-size: x-large; font-family: 华文行楷;HEIGHT: 15px;">
										订单详情
									</th>
								</tr>
								
									<c:forEach items="${orderLis }" var="o" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 30px; font-size: large;" align="center"
												width="9%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 30px; font-size: large;" align="center"
												width="25%">
												${o.id }
											</td>
											<td style="CURSOR: hand; HEIGHT: 30px; font-size: large;" align="center"
												width="10%">
												${o.total }
											</td>
											<td style="CURSOR: hand; HEIGHT: 30px; font-size: large;" align="center"
												width="10%">
												${o.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 30px; font-size: large;" align="center"
												width="15%">
												${o.telephone }
											</td>
											<td style="CURSOR: hand; HEIGHT: 30px; font-size: large;" align="center"
												width="20%">
												${o.address }
											</td>
											<td style="CURSOR: hand; HEIGHT: 30px; font-size: large;" align="center"
												width="15%">
												<c:if test="${o.state == 0 }">未付款</c:if>
												<c:if test="${o.state == 1 }">
													<a href="${pageContext.request.contextPath }/adminOrder?method=updateState&orderId=${o.id}" style="color:blue; font-size: large;">去发货</a>
												</c:if>
												<c:if test="${o.state == 2 }">待收货</c:if>
												<c:if test="${o.state == 3 }">已完成</c:if>
											</td>
											<td align="center" style="HEIGHT: 30px" width="10%">
												<input type="button" value="订单详情" style="font-size: x-large; font-family: 华文行楷; height: 27px;"  onclick="showDetail('${o.id}')"/>
											</td>
							
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
					
				</TBODY>
			</table>
		
	</body>
	<script type="text/javascript">
			function showDetail(oid){
				//alert(oid);
				//发送ajax
				$.post("${pageContext.request.contextPath}/adminOrder",
						{"method":"showDetail","orderId":oid},
						function(d){
							//alert(d);
							var s="<table border='1' width='99%'>";
							s+="<tr><th style=\"font-family: 华文行楷\">商品图片</th><th style=\"font-family: 华文行楷\">商品名称</th><th style=\"font-family: 华文行楷\">购买数量</th></tr>"
							
							$(d).each(function(){
								s+="<tr><td align=\"center\" valign=\"middle\"><image src=\""+this.product.image+"\"/></td><td align=\"center\" valign=\"middle\"><strong>"+this.product.product_name+"</strong></td><td align=\"center\" valign=\"middle\"><strong>"+this.count+"</strong></td></tr>";
							});
							
							s+="</table>";
							
							layer.open({
						        type: 1,//0:信息框; 1:页面; 2:iframe层;	3:加载层;	4:tip层
						        title:"订单号:"+oid,//标题
						        area: ['520px', '300px'],//大小（默认居中）
						        shadeClose: true, //点击弹层外区域 遮罩关闭
						        content: s//内容
						    });
						},
				"json");
			}
		</script>
</HTML>

