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
			width: 800px;
		}
		.ct_context #message{
			color: red;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			$('#login_out').click(function(){
				var actionFrom=$("<form/>",{action:'${ctx}/am/logout',method:'post'});
				actionFrom.appendTo($("body")).submit();
				return false;
			});
			
			$("#produceKey").click(function(){
				var ipt=$(this);
				$('<form/>',{action:'${ctx}/am/ques/produceKey',method:'post'})
				.append($("<input type='hidden' name='qtid'/>").val(ipt.next().val()))
				.append($("<input type='hidden' name='keyNum'/>").val(ipt.next().next().val()))
	 		 	.appendTo($("body"))
	 		 	.submit();
			});
			
			$("#finishQues").click(function(){
				var ipt=$(this);
				$('<form/>',{action:'${ctx}/am/ques/finish',method:'post'})
				.append($("<input type='hidden' name='qtid'/>").val(ipt.next().val()))
	 		 	.appendTo($("body"))
	 		 	.submit();
			});
			
			$("#closeQues").click(function(){
				var ipt=$(this);
				$('<form/>',{action:'${ctx}/am/ques/close',method:'post'})
				.append($("<input type='hidden' name='qtid'/>").val(ipt.next().val()))
	 		 	.appendTo($("body"))
	 		 	.submit();
			});
		});
	</script>
</head>

<body>

	<div class="ctdiv">
		<div class="ct_head"><div class="left_top"></div><div class="right_top"></div><div class="none"></div></div>
		<div class="ct_context">
			<c:if test="${not empty message}" >
			<div id="message">${message.message}</div>
			</c:if>
			<div style="margin-top: 20px;">
				<table border="1" style="width: 100%;border: 1px dashed #000000; ">
					<thead>
						<tr>
							<th>调查表</th>
							<th>状态</th>
							<th>有效key</th>
							<th>完成key</th>
							<th colspan="2">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="quesbean" items="${quesBeanList}">
						<tr>
							<td>${quesbean.ques.name}</td>
							<td>${quesbean.ques.state.name}</td>
							<td>${quesbean.validNum}</td>
							<td>${quesbean.finishNum}</td>
							<td style="width: 150px;"><input id="produceKey" type="button" value="生成"><input type="hidden" value="${quesbean.ques.qtid}">:<input type="text" value="" size="5"/>个key</td>
							<td style="width: 150px;">
								&nbsp;&nbsp;<input id="finishQues" type="button" value="结束"><input type="hidden" value="${quesbean.ques.qtid}">
								&nbsp;&nbsp;<input id="closeQues" type="button" value="关闭"><input type="hidden" value="${quesbean.ques.qtid}">
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div style="text-align: right;margin-top: 20px;">
				<button class="btn_normal" type="button" id="login_out"  >退出</button> &nbsp;&nbsp;
			</div>
		</div>
		<div class="ct_foot"><div class="left_bottom"></div><div class="right_bottom"></div><div class="none"></div></div>
	</div>
	
</body>
</html>
