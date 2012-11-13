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
		.ct_context{
			color: red;
			padding-left:10px;
			padding-right:10px;
			line-height: 25px;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			$('#login_out').click(function(){
				var actionFrom=$("<form/>",{action:'${ctx}/finish/logout',method:'post'});
				actionFrom.appendTo($("body")).submit();
				return false;
			});
		});
	</script>
</head>

<body>

	<div class="ctdiv">
		<div class="ct_head"><div class="left_top"></div><div class="right_top"></div><div class="none"></div></div>
		<div class="ct_context">
			您输入的认证码[${qtkey}]已经认证通过。<br>
			${reason},你无法进行其它操作。<br>
			如果你已经参与本次调查，请到指定地点凭【纪念品领取码】领取纪念品，谢谢你的参与！<br>
			<div style="text-align: right;">
				<button class="btn_normal" type="button" id="login_out"  >退出</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	
</body>
</html>
