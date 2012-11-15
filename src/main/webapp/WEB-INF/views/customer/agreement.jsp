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
			width: 600px;
		}
		.ct_context{
			padding-left:10px;
			padding-right:10px;
			line-height: 25px;
		}
		
		.ques_name{
			text-align: center;
		}
		
		
	</style>
	<script type="text/javascript">
		$(function() {
			$("#check").bind("click",function(){
				if($(this).attr("checked")){
					$("#btn_start").addClass("btn_normal");
					$("#btn_start").removeClass("btn_disable");
				}else{
					$("#btn_start").addClass("btn_disable");
					$("#btn_start").removeClass("btn_normal");
				}
			});
			
			$('#btn_start').click(function(){ 
				if($(this).hasClass("btn_normal")){
					window.open("${ctx}/fill","_self");
					return false;
				}
				
			});
		});
	</script>
</head>

<body>

	<div class="ctdiv">
		<div class="ct_head"><div class="left_top"></div><div class="right_top"></div><div class="none"></div></div>
		<div class="ct_context">
			<div class="ques_name">
				<h2>${ques.name}</h2>
			</div>
			<div class="agreement">
				1、 感谢您参与方远房产客户满意度调查活动；<br>
				2、 本次满意度调查活动范围为方远房产新老业主；<br>
				3、调查活动遵循自愿原则，采用随机码认证，匿名答题的方式，保证被调查者回答问题的客观性；<br>
				4、调查问卷共计30 个选择性问题，2个建议性问题，回答全部选择性问题后，调查问卷有效；<br>
				5、 每个调查问题内容需要回答2个结果：满意度和重要性程度；<br>
				6、调查结果不对外公开，作为方远房产公司内部改进产品质量和服务的依据；<br>
				7、调查问卷由方远房产营销中心负责解释。<br><br>
			</div>
			<div style="text-align: right;">
				<input id="check" type="checkbox"> 我已认真阅读相关条款，同意参与本次调查。<button class="btn_disable" type="button" id="btn_start"  >开始调查</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	
</body>
</html>
