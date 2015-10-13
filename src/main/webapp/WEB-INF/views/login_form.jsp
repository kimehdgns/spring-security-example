<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title></title>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#loginbtn").click(function(){
				if($("#loginid").val() == ""){
					alert("로그인 아이디를 입력해주세요");
					$("#loginid").focus();
				}else if($("#loginpwd").val() == ""){
					alert("로그인 비밀번호를 입력해주세요");
					$("#loginpwd").focus();
				}else{
					$("#loginfrm").attr("action", "<c:url value='/j_spring_security_check'/>");
					$("#loginfrm").submit();
				}
			});
		});

		function login() {
			$.ajax({
				url : './j_spring_security_check',
				data: $('form input').serialize(),
				type: 'POST',
				dataType : 'json',
				beforeSend: function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
				}
			}).done(function(body) {
				var message = body.response.message;
				var error = body.response.error;
				if (error == true) {
					alert(message);
				}
				if (error == false) {
					var url = '${referer}';
					if (url == '') url = '<c:url value="/main" />';
					location.href = url;
				}
			});
		}
	</script>
	<c:if test="${not empty param.fail}">
		<script>
			alert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}');
		</script>
	</c:if>
</head>
<body>
<div style="display:inline-block;">
	로그인 화면
	<form id="loginfrm" name="loginfrm" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="loginid" name="loginid" value=""/>
				</td>
				<td rowspan="2">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input type="button" id="loginbtn" value="submit login"/><br/>
					<button type="button" onclick="login();">ajax login</button>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="text" id="loginpwd" name="loginpwd" value=""/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label><input type="checkbox" name="remember" /> remember-me</label>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
