<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>方远房产满意度调查</title>
	<%@ include file="/common/setting.jsp" %>
	<%@ include file="/common/meta.jsp" %>
	<%@ include file="/common/base.jsp" %>
	
	<style>
	.container {
		margin: 200px auto 0;
		width: 320px;
		color: #444;
		border: 3px solid rgba(0, 0, 0, 0);
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
		border-radius: 5px;
		-webkit-box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
		-moz-box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
		font-size: 15px;
	}
	
	.container div {
		text-align: center;
	}
	
	.container .logodiv {
		-webkit-border-radius: 4px;
		-moz-border-radius: 4px;
		border-radius: 4px;
		background: #D3D3D3;
		border: 1px solid #e5e5e5;
	}
	
	.logodiv .logo_title {
		height: 30px;
		line-height: 30px;
		overflow: hidden;
		color: #666;
		padding: 0 10px;
		font-size: 20px;
		border-bottom: 1px solid #e5e5e5;
		background: #E3E3E3;
		border-radius: 4px 4px 0 0;
		font-weight: bold;
	}
	
	.logodiv .logo_context  {
		padding-top:10px;
		padding-bottom:10px;
	}
	
	.logodiv .logo_context  div {
		margin-bottom: 5px;
	}
	
	.logodiv  #message {
		text-align:left;
		padding-bottom:10px;
		padding-left:50px;
		padding-right:40px;
		color: #FF0000;
	}
	
	.logodiv .logo_context input{
		border: 1px solid #e5e5e5;
		font-size: 15px;
	}
	
	.logodiv .logo_footer{
		padding-bottom:10px;
	}
	
	body{
		 background: #8C6E48;
	}
	</style>
	
	<script type="text/javascript">
		$(function() {
			$('#login').click(function(){
				var actionFrom=$("form");
				actionFrom.submit();
				return false;
			});
		});
	</script>
</head>

<body>

	<form action="${ctx}/am" method="post">
	<%@ include file="/common/log.jsp" %>
	
	<div class="container">
		<div class="logodiv">
			<div class="logo_title">
				<span>系统管理员</span>
			</div>
			<div class="logo_context">
					<div >用户&nbsp;&nbsp;<input type="text"  id="name"  name="name"  value="${name}" /> </div>
					<div >密码&nbsp;&nbsp;<input type="password"  id="password"  name="password"  value="" /> </div>
			</div>
			<c:if test="${not empty message}" >
				<div id="message">${message.message}</div>
			</c:if>
			<div class="logo_footer">
					<button class="btn_normal" type="button" id="login"  >登录</button> 
			</div>		
		</div>
	</div>
	</form>

</body>
</html>
