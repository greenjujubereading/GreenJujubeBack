<%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 2019/4/13
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
    <script  src="static/js/jquery-easyui-1.5/jquery.min.js"></script>
    <script  src="static/js/common.js"></script>
</head>
<body>

<form>
    <div>
        手机号: <input name="userPhone" value="13167351123">
    </div>
    <div>
        验证码: <input name="verifyCode">
        <button type="button" class="sendVerifyCode">获取短信验证码</button>
    </div>
    <div>
        <button type="button" class="sub-btn">提交</button>
    </div>
</form>

<button type="button" class="sub-btn2">得到首页轮播图</button>
<button type="button" class="sub-btn3">得到首页booklist</button>
<button type="button" class="sub-btn4">得到首页bookrecommend</button>
<button type="button" class="sub-btn4-5">首页bookrecommend更多</button>
<button type="button" class="sub-btn5">得到首页分类图书</button>
<button type="button" class="sub-btn6">得到图书内容</button>
<button type="button" class="sub-btn9">评论内容</button>
<button type="button" class="sub-btn10">家长导读</button>
<button type="button" class="sub-btn11">讲师介绍</button>
<button type="button" class="sub-btn12">得到讲师id=1的图书列表</button>
<button type="button" class="sub-btn13">得到讲师列表</button>
<button type="button" class="sub-btn14">添加收藏</button>
<button type="button" class="sub-btn15">得到id=1的收藏</button>
<button type="button" class="sub-btn16">得到id=1的历史</button>
<button type="button" class="sub-btn17">得到id=1的相似视频</button>

<div style="border:2px red solid">
    <p>注册</p>
    <div>
        手机号: <input name="register_user_phone">
    </div>
    <div>
        密码: <input name="register_user_password">
    </div>
    <div>
        验证码: <input name="register_verifyCode">
        <button type="button" class="sendVerifyCode_reg">获取短信验证码</button>
    </div>
    <div>
        <button type="button" class="register_sub-btn">提交</button>
    </div>
</div>
<div style="border:2px black solid">
    <h1>手机号密码登陆</h1>
    <div>
        手机号: <input name="user_phone2" value="13251359103">
    </div>
    <div>
        密码: <input name="user_password2">
    </div>

    <div>
        <button type="button" class="sub-btn7">提交</button>
    </div>
</div>
<div style="border:2px black solid">
    <h1>搜索</h1>
    <div>
        搜索: <input name="video_name" value="早">
    </div>

    <div>
        <button type="button" class="sub-btn8">提交</button>
    </div>
</div>

<div class="comment">
    <label for="comment">发表评论</label><input type="text" name="comment" class="comment-input" placeholder="请发表评论">
    <button type="submit" class="btn-comment">提交</button>
</div>
<div style="border:1px black solid">
    <p>注册登陆</p>
    <div>
        手机号: <input name="register_login_user_phone">
    </div>
    <div>
        验证码: <input name="register_login_verifyCode">
        <button type="button" class="sendVerifyCode_reg_login">获取短信验证码</button>
    </div>
    <div>
        <button type="button" class="register_login_btn">提交</button>
    </div>
</div>


</body>
</html>
