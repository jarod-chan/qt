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
	
	<%@ include file="button_custom.jsp" %>
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
		  border: 1px dashed #8C6E48 ;  
		}
		.text_context{
			border: 1px solid #8C6E48;
			width: 500px;
			height: 200px;
			font-size: 15px;
		}
		.part_div{
			font-size: 20px;
			font-weight: bold;
			margin-bottom: 10px;
		}
		.answer_div{
			margin-left: 15px; 
			margin-top: 2px;
			padding:0;
			height: 20px;
		}
		
		.answer_ul {
			list-style-type:none;
			padding:0;
			margin:0;
			width:100%;
		}
		.answer_ul .option_li{ 
			float:left;
			padding:0;
			margin:0;
			display: inline;
			cursor: pointer;
			_cursor: hand;
			margin-right: 30px;
			height: 20px;
		}
		
		.span_cont{
			margin-top:3px;
			margin-left:3px;
			float:left;
			width:12px;
			height:12px;
			border: 1px solid black;
			cursor：pointer;
			_cursor:hand;
			background-color: #D3D3D3;
		}
		
		
		.option_sel{
			background-color: #8C6E48;
			color: #FFFFFF;
		}
		
		.question_noml{
			background-color :#D3D3D3;
			color: #000000;
		}
		
		.question_curr{
			background-color : #8C6E48;
			color : #FFFFFF;
		}
		
		.question_curr .option_sel{
			background-color: #D3D3D3;
			color: #000000;
		}
		
		.option_sel .span_cont{
			border: 1px solid white;
			background-color: #8C6E48;
		}
		
		.question_curr .option_sel .span_cont{
			border: 1px solid black;
			background-color: #D3D3D3;
 		}
		
		.question_curr .span_cont{
			border: 1px solid white;
		}
		

	</style>
	<script type="text/javascript">


		$(function() {
			$('#login_out').click(function() {
				var actionFrom = $("form");
				actionFrom.submit();
				return false;
			});

			$(".answer_ul .option_li").click(
				function() {
					var option_li = $(this);
					var answer_ul = option_li.parent();
					var quesdiv = option_li.parents(".question_div");
					answer_ul.find(".not_choice").hide();
					quesdiv.find(".partItemValue").val(option_li.find(".option_id").val());
					quesdiv.css({
						"padding-left" : "0px",
						"border-left" : "11px solid #8C6E48"
					});

					answer_ul.find(".option_sel").removeClass("option_sel");
					option_li.addClass("option_sel");
			});

			$(".question_div").mouseover(function() {
				$(this).addClass("question_curr").removeClass("question_noml");
			}).mouseout(function() {
				$(this).addClass("question_noml").removeClass("question_curr");
			});

			$("#btn_submit").click(function() {
				var partItems = $(".partItemValue");
				var flag = false;
				partItems.each(function() {
					if ($(this).val() == "") {
						$(this).parent().find(".not_choice").show();
						flag = true;
					}
				});
				if (flag) {
					alert("红色标注【X】行没被选择，无法【提交问卷】！");
					return;
				}

				var actionFrom = $("form");
				var oldAction = actionFrom.attr("action");
				actionFrom.submit();
			});

			$(".text_context").attr({
				"maxlength" : "500"
			}).iemaxlength();

			//选项着色
			var optColorArr = [ "#8C6E48", "#FFDC90", "#D3D3D3", "#6298B0",
					"#314B57" ];

			$("select").each(
					function() {
						$(this).find("option").each(function(idx) {
							$(this).css("background-color", optColorArr[idx]);
						});
						$(this).bind(
								"change",
								function() {
									$(this).css("background-color",
											optColorArr[this.selectedIndex])
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
				
					<c:if test="${index==0}">
					  <div class="part_div">一、基本信息</div>
					</c:if>
					<c:if test="${index==4}">
					  <div class="part_div">二、满意度调查</div>
					</c:if>
					
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
							<div style="float: left; width: 600px;">${question.choice.no}.${question.choice.subject}</div>				
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
							<div style="clear: both;width: 0;height: 0;"></div>
						</div>
						
						<div class="answer_div" >
							<input type="hidden" name="receiveBeans[${index}].id"    class="partItemId" value="${itemChk.id}">
							<input type="hidden" name="receiveBeans[${index}].value" class="partItemValue" value="${itemChk.value}">
							<ul class="answer_ul">
								<c:forEach var="option" items="${itemChk.options}">
								<li class="option_li <c:if test="${option.id==itemChk.value}">option_sel</c:if>">
									<span class="span_cont"></span>&nbsp;${option.name}
									<input type="hidden" class="option_id" value="${option.id}" />
								</li>
								</c:forEach>
								<li><span class="not_choice" style="color: red;display: none;">【X】</span></li>
							</ul>
							
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
			<div class="ques_btn" style="text-align: center;">
				<button class="btn_normal" type="button" id="btn_submit"  >提交问卷</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	</form>
	
</body>
</html>
