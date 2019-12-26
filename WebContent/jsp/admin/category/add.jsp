<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/Resource/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminCategory" method="post">
			<!-- 提交的方法 -->
			<input type="hidden" name="method" value="save">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="40">
						<strong style="font-family: 华文行楷; font-size: xx-large;">添加分类
						</strong>
					</td>
				</tr>

				<tr>
					<td width="30%" align="center" bgColor="#f5fafe" class="ta_01"  height="30" style="font-size: x-large; font-family: 华文行楷">
						分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3"  height="30">
						<input type="text" name="name" value="" id="userAction_save_do_logonName" class="bg" style="height: 27px;width:400px;font-size: large;"/>
					</td>
				</tr>
			
				<tr>
					<td colspan="2" align="center" bgColor="#f5fafe" class="ta_01"  height="30" style="font-size: x-large; font-family: 华文行楷">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" bgColor="#f5fafe" class="ta_01"  height="30" style="font-size: x-large; font-family: 华文行楷">
						&nbsp;
					</td>
				</tr>
			
				<tr>
					<td class="ta_01" style="WIDTH: 100%;" align="center"
						bgColor="#f5fafe" colSpan="4"  height="25">
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