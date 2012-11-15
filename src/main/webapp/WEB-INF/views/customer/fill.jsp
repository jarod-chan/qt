<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
				actionFrom.submit();
			});
			
			$(".text_context").attr({"maxlength":"500"}).iemaxlength();
			
			//选项着色
			var optColorArr=["#FF6000","#FFCC00","#FFFFFF","#99FFFF","#0099FF"];
			
			$("select").each(function(){
				$(this).find("option").each(function(idx){
					$(this).css("background-color",optColorArr[idx]);
				});
				$(this).bind("change",function(){
					$(this).css("background-color",optColorArr[this.selectedIndex])
				}).triggerHandler("change");
			});
			
		});
	</script>
</head>

<body>

	<form action="${ctx}/fill" method="post">
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
						<!-- 根据答案组个数来确定是不是存在重要性 -->
						<c:choose>
							<c:when test="${fn:length(question.items)==2}">
								<c:set value="${question.items[0]}" var="itemSel" />
								<c:set value="${question.items[1]}" var="itemChk" />
							</c:when>
							<c:otherwise>
								<c:set value="${null}" var="itemSel" />
								<c:set value="${question.items[0]}" var="itemChk" />
							</c:otherwise>
						</c:choose>
				
						<div >
							<div style="float: left; width: 620px;">${question.choice.no}.${question.choice.subject}</div>				
							<div style="float: left; ">
								<c:if test="${not empty itemSel}">
										<input type="hidden" name="receiveBeans[${index}].id"   value="${itemSel.id}">
										问题重要性：<select name="receiveBeans[${index}].value" >
											<c:forEach var="option" items="${itemSel.options}">
												<option value="${option.id}" <c:if test="${option.id==itemSel.value||(itemSel.value==null&&option.no=='C')}">selected="true"</c:if> >${option.name}</option>
											</c:forEach>
										</select>
									<c:set value="${index+1}" var="index" />
								</c:if>
							</div>
							<div style="clear: both;"></div>
						</div>
						
						<div style="margin-left: 15px; margin-top: 2px;">
							<input type="hidden" name="receiveBeans[${index}].id"    class="partItemId" value="${itemChk.id}">
							<input type="hidden" name="receiveBeans[${index}].value" class="partItemValue" value="${itemChk.value}">
							<c:forEach var="option" items="${itemChk.options}">
								<input type="checkbox" name="chk_${status.count}_${itemChk.type}" value="${option.id}" <c:if test="${option.id==itemChk.value}">checked="true"</c:if> />(${option.no})&nbsp;${option.name}&nbsp;&nbsp;
							</c:forEach>
							<span class="not_choice" style="color: red;display: none;">【X】</span>
						</div>
						<c:set value="${index+1}" var="index" />

						
						
						
						
					</div>
					
					
					
						
				</c:forEach>
				
						
				<c:forEach var="simasw" items="${simpleAnswerList}" varStatus="status">
					<div class="question_div" >
							<div>${simasw.simple.no}.${simasw.simple.subject}(500字以内，可以不填)</div>
							<div style="margin-left: 15px;">
								<input type="hidden" name="replayBeans[${status.index}].id" value="${simasw.id}" />
								<input type="hidden" name="replayBeans[${status.index}].simpleId" value="${simasw.simple.id}" />
								<textarea name="replayBeans[${status.index}].value" class="text_context">${simasw.value}</textarea>
							</div>
					</div>
				</c:forEach>
						
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
