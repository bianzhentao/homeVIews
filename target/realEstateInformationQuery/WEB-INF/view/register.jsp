<%--
  Created by IntelliJ IDEA.
  User: 63157
  Date: 2020/11/21
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<style>
    div {
        margin-left: 700px;
        margin-top: 100px;
        width: 400px;
        height: 220px;
        text-align: center;
        border: 1px solid LightGrey;
    }
</style>
<script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
<body>
<div>
    <h1>帐号注册</h1>
    <form action="/users/addUsers.do" method="post">
        <p>身份证号：<input type="text" name="cardid"><p id="cardid"></p></p>
        <p>用户名：<input type="text" name="name"><p id="name"></p></p>
        <p>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><p id="password"></p></p>
        <p>确认密码：<input type="password" name="password1"><p id="password1"></p></p>
        <input type="submit" value="注册"><input type="button" value="返回" onclick="javascript:window.history.back(-1);">
    </form>
</div>
</body>
<script>
    $(function () {
        //文本框失去焦点时恢复原样
        $("[name='cardid']").blur(function () {
            $("#cardid").html("");
            $("[name='cardid']").css("border-color", "black");
        })
        $("[name='name']").blur(function () {
            $("#name").html("");
            $("[name='name']").css("border-color", "black");
        })
        $("[name='password1']").blur(function () {
            $("#password1").html("");
            $("[name='password1']").css("border-color", "black");
        })
        $("[name='password']").blur(function () {
            $("#password").html("");
            $("[name='password']").css("border-color", "black");
        })
        //form表单验证
        $("form").submit(function () {
            var cardid = $("[name='cardid']").val().trim();
            if (cardid == "") {
                $("[name='cardid']").css("border-color", "red");
                $("#cardid").html("身份证号不能为空").css("color","red");
                return false;
            }
            var name = $("[name='name']").val().trim();
            if (name == "") {
                $("[name='name']").css("border-color", "red");
                $("#name").html("用户名不能为空").css("color","red");
                return false;
            }
            var password = $("[name='password']").val().trim();
            if (password == "") {
                $("[name='password']").css("border-color", "red");
                $("#password").html("密码不能为空").css("color","red");
                return false;
            }else if(password.length<6){
                $("[name='password']").css("border-color", "red");
                $("#password").html("密码名不能低于6位").css("color","red");
                return false;
            }
            var password1 = $("[name='password1']").val().trim();
            if (password1 == "") {
                $("[name='password1']").css("border-color", "red");
                $("#password1").html("确认密码不能为空").css("color","red");
                return false;
            }else if(password1!=password){
                $("[name='password1']").css("border-color", "red");
                $("#password1").html("确认密码输入与密码不一致").css("color","red");
                return false;
            }else if(password1.length<6){
                $("[name='password1']").css("border-color", "red");
                $("#password1").html("确认密码名不能低于6位").css("color","red");
                return false;
            }
            return true;
        })
    })
</script>
</html>
