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
		}
	</style>
	<script type="text/javascript">
		$(function() {
			$('#login_out').click(function(){
				var actionFrom=$("<form/>",{action:'${ctx}/ct/close/logout',method:'post'});
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
			由于【${ques.name}】已经${ques.state.name},<br>
			奖品领取中心无法操作。<br>
			<div style="text-align: right;">
				<button class="btn_normal" type="button" id="login_out"  >退出</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>

	
</body>
</html>
