<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:url var="base" value="/"></c:url>--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="static/js/jquery-easyui-1.5/jquery.min.js"></script>
<script src="static/js/common.js"></script>
<title>加入清早读书大家庭</title>
</head>
<body>
        <div>
           手机号: <input name="user_phone_invite"  >
       </div>
        <div>用户名为：${user_name}的用户你好</div>

        <button type="button" class="sub-btn_invite">确定</button>
</body>
</html>