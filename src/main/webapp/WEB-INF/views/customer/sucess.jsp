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
			width: 500px;
		}
		.key_info{
			margin-top: 10px;
		}
		.warn_info{
			line-height: 20px;
		}
		.spec{
			color: #8C6E48;
		}
		.bigfont{
			font-size: 40px;
		}
		.boldfont{
			font-weight: bold;
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
			<div class="key_info">
				感谢您参与方远房产客户满意度调查活动，为我们改进工作提供了有益的帮助！请您记录礼品【领取码】，到合适的领取点获取礼品：<br>
				<span class="spec bigfont">&nbsp;领取码：【${prizekey}】</span><br>
			</div>
			<div class="warn_info">
				注意事项：<br>
				1、有效的礼品领取点是：方远房产营销中心（市府大道298号），景元花园、景元西苑、汇景名苑、瑞景名苑物管处；<br>
				2、请在领取点向工作人员出示【领取码】，获得一份礼品；<br>
				3、【领取码】由系统随机生成，在领取礼品前请妥善保管，遗失无法补回；<br>
				4、每个【领取码】只领取一份礼品，重复领取无效；<br>
				5、不明事项请致电方远房产营销中心：0576-88816966。<br>

			</div>
			<div style="text-align: right;margin-top: 10px;">
				<button class="btn_normal" type="button" id="login_out"  >退出</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	
</body>
</html>
