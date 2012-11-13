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
		
		.warn_info{
			line-height: 20px;
		}
		.spec{
			color: red;
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
			<div>
				您已经成功参与【${ques.name}】。<br>
				<span class="spec bigfont">&nbsp;纪念品领取码：</span><br>
				<span class="spec bigfont">【${prizekey}】</span><br>
			</div>
			<div class="warn_info">
				&nbsp;&nbsp;&nbsp;&nbsp;请记录当前【纪念品领取码】（手机拍照，截图保存，手动抄写等），并携带该【纪念品领取码】到指定地点领取奖品！<br> 
				注意事项：<br>
				1.【纪念品领取码】是领取奖品的<span class="boldfont">唯一证明</span>，请妥善保管。<br>
				
				2.【纪念品领取码】是随机生成，退出将<span class=" boldfont">无法找回</span>，请在退出前确保你准确记录。<br>
				
				3.【纪念品领取码】只能<span class="boldfont">领取纪念品一次</span>，随后销毁，请做好保密工作。 <br>
			</div>
			<div style="text-align: right;margin-top: 10px;">
				<button class="btn_normal" type="button" id="login_out"  >退出</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	
</body>
</html>
