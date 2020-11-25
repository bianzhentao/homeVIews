<%--
  Created by IntelliJ IDEA.
  User: 63157
  Date: 2020/11/21
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆</title>
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
    <h2>房产信息查询系统</h2>
    <form action="/users/verify.do" method="post">
        <p>请输入身份证号：<input type="text" name="cardid"><p id="cardid"></p></p>
        <p>请输入密码：<input type="text" name="password"><p id="password"></p></p>
        <input type="submit" value="登录"><a href="/users/register.do">注册</a>
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
            return true;
        })
    })

</script>
</html>
