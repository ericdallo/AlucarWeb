<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="jquery" required="false" type="java.lang.Boolean"%>
<%@ attribute name="bootstrap" required="false" type="java.lang.Boolean"%>
<%@ attribute name="util" required="false" type="java.lang.Boolean"%>

<c:if test="${jquery eq true }">
	<script src='<c:url value="/js/jquery.js"/>'></script>
	<script src='<c:url value="/js/jquery-ui.js"/>'></script>
	<script src='<c:url value="/js/jquery-mask.js"/>'></script>
</c:if>
<c:if test="${bootstrap eq true }">
	<script src='<c:url value="/bootstrap/js/bootstrap.min.js"/>'></script>
	<link href='<c:url value="/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet"/>
</c:if>
<c:if test="${empty util || util eq true}">
	<link href='<c:url value="/css/util.css"/>' rel="stylesheet"/>
</c:if>

