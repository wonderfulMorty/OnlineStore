<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/Resource/images/headlogo.png" />
<!-- 给网页标题前加一个小图标-->
<title>电子商务系统管理中心</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/Resource/css/general.css" 
 	type="text/css" />
<link rel="stylesheet" 
	href="${pageContext.request.contextPath }/Resource/css/main.css" 
	type="text/css" />

<style type="text/css">
body {
  color: white;
}
</style>
</head>
<body style="background: #278296">
<center></center>
<form method="post" action="${pageContext.request.contextPath }/admin" target="_parent" name='theForm' onsubmit="return validate()">
 <!-- 提交方法 -->
 <input type="hidden" name="method" value="login"/>
 <div align="center">
 <br>
 <h2>管理员登录</h2>
 <hr>
 
  <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
  <tr><td style="color: red" align="center">${error }</td></tr>
  <tr><td>&nbsp;</td></tr>
  <tr>
    <td style="padding-left: 50px">
      <table>
      <tr>
        <td style="font-family:华文行楷; font-size: larger;">管理员账号：</td>
        <td><input type="text" style="height: 25px; font-size: large;" name="account" /></td>
      </tr>
      <tr><td style="height: 25px"></td></tr>
      <tr>
        <td style="font-family:华文行楷; font-size: larger;">管理员密码：</td>
        <td ><input type="password" style="height: 25px; font-size: large;" name="password" /></td>
      </tr>
      <tr><td style="height: 25px"></tr>
      <tr><td>&nbsp;</td><td><input style="height: 30px; font-family: 华文行楷;font-size: larger;" type="submit" value="进入管理中心" class="button" /></td></tr>
      </table>
    </td>
  </tr>
  </table>
  </div>
</form>
<script language="JavaScript">

	/* 网页载入完毕后定位光标到name="account"的标签上 */
  document.forms['theForm'].elements['account'].focus();
  
  /**
   * 检查表单输入的内容（不能为空）
   */
  function validate()
  {
    var validator = new Validator('theForm');
    validator.required('account', account_empty);
    validator.required('password', password_empty);
    
    return validator.passed();
  }
  
</script>
</body>
</html>