<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
</head>
<body>
	<sec:authentication var="user" property="principal" />
	<sec:authorize access="isRememberMe()">
		<h2># This user is login by "Remember Me Cookies".</h2>
	</sec:authorize>

	<sec:authorize access="isFullyAuthenticated()">
		<h2># This user is login by username / password.</h2>
	</sec:authorize>
	<p>${user.id} (${user.name}) 관리자님! 안녕하세요.</p>
	<h1>
		<sec:authorize access="hasRole('ROLE_USER')">
			회원
	    </sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			관리자
	    </sec:authorize>
	    <sec:authorize access="permitAll">
			모두
	    </sec:authorize>
	    <sec:authorize access="isAuthenticated()">
	    	<a href="javascript:logout();">로그아웃</a>
	    </sec:authorize>
	</h1>
	
	<form id="logout_form" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
	<script>
		function logout() {
			document.getElementById("logout_form").submit();
		}
	</script>
</body>
</html>
