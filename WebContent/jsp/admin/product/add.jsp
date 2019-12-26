<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/Resource/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<!--表单entype属性必须为 multipart/form-data  -->
		<!-- 表单entype属性必须为 multipart/form-data -->
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="40">
						<strong style="font-family: 华文行楷; font-size: xx-large;">添加商品</strong>
					</td>
				</tr>

				<tr>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						所属分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="category_id" style="font-size: large;">
							<c:forEach items="${categoryLis }" var="c">
								<option value="${c.id }">${c.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="product_name" value="" id="userAction_save_do_logonName" class="bg" style="height: 27px;font-size: large; width:400px ;"/>
					</td>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<select name="is_hot" style="font-size: large;">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="market_price" value="" id="userAction_save_do_logonName" class="bg" style="height: 27px;font-size: large;"/>
					</td>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mall_price" value="" id="userAction_save_do_logonName" class="bg" style="height: 27px;font-size: large;"/>
					</td>
				</tr>
				<tr>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="file" name="image" style="height: 27px;font-size: large;"/>
					</td>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						商品库存：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="stock" value="" id="userAction_save_do_logonName" class="bg" style="height: 27px;font-size: large;"/>
					</td>
				</tr>
				<tr>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01" height="30" style="font-size: x-large; font-family: 华文行楷">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="description" rows="5" cols="30" style="height: 27px;font-size: large;"></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="4" align="center" bgColor="#f5fafe" class="ta_01"  height="30" style="font-size: x-large; font-family: 华文行楷">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" bgColor="#f5fafe" class="ta_01"  height="30" style="font-size: x-large; font-family: 华文行楷">
						&nbsp;
					</td>
				</tr>
				
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4" height="25">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok" style="height: 25px;font-size: x-large; font-family: 华文行楷">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel" style="height: 25px;font-size: x-large; font-family: 华文行楷">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" style="height: 25px;font-size: x-large; font-family: 华文行楷"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>