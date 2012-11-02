<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<title>发起流程</title>
	<%@ include file="/common/setting.jsp" %>
	<%@ include file="/common/meta.jsp" %>
	<%@ include file="/common/include.jsp" %>

    <script type="text/javascript">
    $(function() {
    	$('.btn_start').click(function(){
    		var param=jQuery.parseJSON($(this).attr("param"));
    		if(param.isStartform){
        		$('<form/>',{action:'${ctx}/'+param.formKey,method:'get'})
	    			.append($('<input/>',{type:'hidden',name:'processDefinitionKey',value:param.key}))
					.appendTo($("body"))
				.submit();
    		}else{
    			$('<form/>',{action:'${ctx}/process/start/'+param.key,method:'post'})
     		 	.appendTo($("body"))
     		 	.submit();
    		}
    	});
    });
    </script>
</head>

<body class="tbody">
	<%@ include file="/common/message.jsp" %>

	<div>
		<div class="txt_title">
			发起流程<span class="f_size normal black" id="_ut"> (共<span id="_ut_c">${fn:length(processDefinitionBeans)}</span>个)</span>
		</div>
	
		<div style="" class="toolbg toolbgline toolheight nowrap">
			<div class="nowrap left">
			</div>
			<div class="right">
				<!--页码 -->&nbsp;
			</div>
		</div>

		<table class="O2" cellspacing="0" cellpadding="0" >
			<thead>
				<tr>
					<th class="noborder">流程名称</th>
					<th class="title">版本号</th>
					<th class="title">流程编码</th>
					<th class="title" style="width: 300px;">流程图</th>
					<th class="title">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bean" items="${processDefinitionBeans}">
					<tr>
						<td>${bean.processDefinition.name }</td>
						<td>${bean.processDefinition.version }</td>
						<td>${bean.processDefinition.key }</td>
						<%-- <td>${bean.formKey}</td> --%>
						<%-- <td>${bean.isStartform}</td> --%>
						<td><a target="_blank" href='${ctx }/workflow/manage/${bean.processDefinition.deploymentId}/resource?resourceName=${bean.processDefinition.diagramResourceName }'>${bean.processDefinition.diagramResourceName }</a></td>
						<td>
							<button class="btn_start" param='{"key":"${bean.processDefinition.key}","formKey":"${bean.formKey}","isStartform":${bean.isStartform}}' >启动</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:if test="${empty processDefinitionBeans}">		
		<%@ include file="/common/emp-context.jsp" %>
		</c:if>

		<div style="" class="toolbg toolbgline toolheight nowrap">
			<div class="right">
				<!--页码 -->&nbsp;
			</div>
		</div>
	</div>



</body>
</html>