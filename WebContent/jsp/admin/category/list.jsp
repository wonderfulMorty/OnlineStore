<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/Resource/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		
	</HEAD>
	<body>
		<br>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td height="40" class="ta_01" align="center" bgColor="#afd1f3">
							<strong style="font-family: 华文行楷; font-size: xx-large;">分类列表</strong>
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
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%" height="20" style="font-size: x-large; font-family: 华文行楷">
										序号
									</td>
									<td align="center" width="17%" height="20" style="font-size: x-large; font-family: 华文行楷">
										分类名称
									</td>
									<!-- <td width="7%" align="center" height="20" style="font-size: x-large; font-family: 华文行楷">
										编辑
									</td> -->
									<td width="7%" align="center" height="20" style="font-size: x-large; font-family: 华文行楷">
										删除
									</td>
								</tr>
								<c:forEach var="c" items="${categoryLis}" varStatus="vs">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22; font-size: large;" align="center"
												width="18%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 20; font-size: large;" align="center"
												width="17%">
												${c.name }
											</td>
											<%-- <td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/adminCategory">
													<img src="${pageContext.request.contextPath}/Resource/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td> --%>
									
											<td align="center" style="HEIGHT: 20; font-size: large;">
												<a href="javascript:void(0);" onclick="removeCategory('${c.id}')">
													<img src="${pageContext.request.contextPath}/Resource/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
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
		function removeCategory(categoryId){
			if (confirm("确定删除吗？")) {
				location.href="${pageContext.request.contextPath}/adminCategory?method=delete&categoryId="+categoryId;
			}
		}
	</script>
</HTML>

