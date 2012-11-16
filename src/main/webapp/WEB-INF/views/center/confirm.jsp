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
		.prizekey_div,.prize_div{
			margin-left: 65px;
			margin-bottom: 10px;
		}
		
		.prize_div{
			margin-left: 80px;
		}
		.spec_em{
			font-weight:bold;
			color: #8C6E48;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			$('#login_out').click(function(){
				var actionFrom=$("<form/>",{action:'${ctx}/ct/close/logout',method:'post'});
				actionFrom.appendTo($("body")).submit();
				return false;
			});
			$('#btn_comfirm').click(function(){
				var actionFrom=$("form");
				actionFrom.submit();
				return false;
			});
		});
	</script>
</head>

<body>

	<form action="${ctx}/ct/confirm" method="post">
	<div class="ctdiv">
		<div class="ct_head"><div class="left_top"></div><div class="right_top"></div><div class="none"></div></div>
		<div class="ct_context">
			<div class="center_name">
				<h2>${center.realname}</h2>
			</div>
			<div class="prizekey_div">
				<input type="hidden" name="prizeKey" value="${longPrizeKey}">
				纪念品领取码：[${longPrizeKey}]已经通过认证。
			</div>
			<div class="prize_div">
				选择纪念品：<select name="prizeId">
					<c:forEach items="${prizeList}" var="prize">
						<option value="${prize.id}">${prize.name}</option>
					</c:forEach>
				</select>
			</div>
			<div style="text-align: right;">
				<em >1</em>-&gt;<em class="spec_em">2</em>-&gt;<em>3</em>
				<button class="btn_normal" type="button" id="btn_comfirm"  >确认</button> &nbsp;&nbsp;<button class="btn_normal" type="button" id="login_out"  >退出</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	</form>
	
</body>
</html>
