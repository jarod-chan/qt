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
			width: 830px;
		}
		.ques_name{
			text-align: center;
		}
		.ques_btn{
			text-align: right;
		}
		.question_div{
		  margin-bottom: 20px;
		  padding:10px;
		  width: 800px;
		  border: 1px dashed #000000; 
		}
		.text_context{
			border: 1px solid #000000;
			width: 500px;
			height: 200px;
			font-size: 15px;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			$('#login_out').click(function(){
				var actionFrom=$("form");
				actionFrom.submit();
				return false;
			});
			
			$("input[type=checkbox]").click(function(){
				var checkbox=$(this);
				checkbox.attr("checked",true);
				checkbox.parent().find(".partItemValue").val(checkbox.val());
				checkbox.parent().find("input[type=checkbox]").not(checkbox).removeAttr("checked");
				$(this).parent().find(".not_choice").hide();
			});
			
			$(".question_div").mouseover(function() {
			     $(this).css("background-color","#99FFFF");
			}).mouseout(function(){
				 $(this).css("background-color","#FFFFFF");
			});
			
			$("#btn_submit").click(function(){
				var partItems=$(".partItemValue");
				var flag=false;
				partItems.each(function(){
					if($(this).val()==""){
					   $(this).parent().find(".not_choice").show();
					   flag=true;
					}
				});
				if(flag){
					alert("红色标注行没被选择，无法【提交问卷】！");
					return;
				}
				
				var actionFrom=$("form");
				var oldAction=actionFrom.attr("action");
				actionFrom.attr("action",oldAction+"/next_choice").submit();
			});
		});
	</script>
</head>

<body>

	<form action="${ctx}/finish/logout" method="post">
	<div class="ctdiv">
		<div class="ct_head"><div class="left_top"></div><div class="right_top"></div><div class="none"></div></div>
		<div class="ct_context">
			<div class="ques_name">
				<h2>${ques.name}</h2>
			</div>
			<div class="ques_choice">
			
				<c:set value="0" var="index" /> 
				<c:forEach var="question" items="${questionList}" varStatus="status">
					<div class="question_div" >
						<div>${question.choice.no}.${question.choice.subject}</div>
						<c:forEach var="item" items="${question.items}" >
							<div style="margin-left: 15px; margin-top: 2px;">
								<input type="hidden" name="receiveBeans[${index}].id"    class="partItemId" value="${item.id}">
								<input type="hidden" name="receiveBeans[${index}].value" class="partItemValue" value="${item.value}">
								<c:forEach var="option" items="${item.options}">
									<input type="checkbox" name="chk_${status.count}_${item.type}" value="${option.id}" <c:if test="${option.id==item.value}">checked="true"</c:if> />(${option.no})&nbsp;${option.name}&nbsp;&nbsp;
								</c:forEach>
								<span class="not_choice" style="color: red;display: none;">【X】</span>
							</div>
							<c:set value="${index+1}" var="index" />
						</c:forEach>
					</div>	
				</c:forEach>
					<div class="question_div" >
						<div style="margin-left: 3px;">你有什么意见建议？（500字以内，可以不填）</div>
						<div style="margin-left: 3px;">
							<textarea name="shortBeans[${status.index}].value" class="text_context"></textarea>
						</div>
					</div>	
			</div>
			<div class="ques_btn">
				<button class="btn_normal" type="button" id="btn_submit"  >提交问卷</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	</form>
	
</body>
</html>