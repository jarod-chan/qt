<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>方远房产满意度调查</title>
	<%@ include file="/common/setting.jsp" %>
	<%@ include file="/common/meta.jsp" %>
	<%@ include file="/common/base.jsp" %>
	<style type="text/css">
		.ctdiv{
			width: 400px;
		}
		
		.prizekey_div input{
			border: 1px solid #e5e5e5;
			font-size: 15px;
			margin-bottom: 20px;
		}
		.center_name{
			text-align: center;
		}
		.prizekey_div{
			padding-left:80px;
			vertical-align: middle;
		}
		.ct_context  #message {
			text-align:left;
			padding-bottom:10px;
			padding-left:80px;
			padding-right:50px;
			color: #FF0000;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			$('#login_out').click(function(){
				var actionFrom=$("<form/>",{action:'${ctx}/ct/close/logout',method:'post'});
				actionFrom.appendTo($("body")).submit();
				return false;
			});
			$('#check_prizekey').click(function(){
				var actionFrom=$("form");
				actionFrom.submit();
				return false;
			});
		});
	</script>
</head>

<body>

	<form action="${ctx}/ct/receive" method="post">
	<div class="ctdiv">
		<div class="ct_head"><div class="left_top"></div><div class="right_top"></div><div class="none"></div></div>
		<div class="ct_context">
			<div class="center_name">
				<h2>${center.realname}</h2>
			</div>
			<div class="prizekey_div">
				纪念品领取码&nbsp;&nbsp;<input type="text"   name="prizeKey"  value="${prizeKey}" /> 
			</div>
			<c:if test="${not empty message}" >
				<div id="message">${message.message}</div>
			</c:if>
			<div style="text-align: right;">
				<em style="font-weight: 600;color: red;">1</em>-&gt;<em>2</em>-&gt;<em>3</em>
				<button class="btn_normal" type="button" id="check_prizekey"  >验证奖品码&nbsp;-&gt;</button> &nbsp;&nbsp;<button class="btn_normal" type="button" id="login_out"  >退出</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	</form>
	
</body>
</html>
