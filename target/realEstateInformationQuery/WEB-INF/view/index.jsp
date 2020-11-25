<%--
  Created by IntelliJ IDEA.
  User: 63157
  Date: 2020/11/21
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户界面</title>
    <style>
        div {
            margin-left: 500px;
            width: 800px;
            height: 400px;
            text-align: center;
            border: 1px solid LightGrey;
        }
        table{
            width: 800px;
            text-align: center;
        }
        tr{
            border: 1px solid LightGrey;
        }
        tr:nth-child(odd) {
            background-color:PaleGreen;
        }
        tr:nth-child(1) {
            background-color:PaleTurquoise;
        }
        td{
            border: 1px solid LightGrey;
        }
    </style>
    <script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
</head>
<body>
<h1 style=" margin-left: 750px;margin-top: 50px">房产信息查询系统</h1>
<p style=" margin-left: 400px">
    用户名：<span>${username}</span>
<a onclick="quit()" href="#" style="margin-left: 20px">退出</a></p>
<a style=" margin-left: 400px" href="#" id="cha" onclick="show()">房产信息查询</a>
<div>
    <h1>欢迎使用房产信息查询系统</h1>
    <table>
        <p id="head"></p>
        <tbody id="show">
        </tbody>
    </table>
</div>
</body>
<script>
    var pageNum=1;//当前页
    var name="";
    var cardid="";
    $("#cha").click(function () {
        $("#head").append("<p>查询类型：<select id='result'><option value='name'>用户名</option><option value='cardid'>身份证</option></select>&nbsp;<input type='text' size='20' id='canshu'>&nbsp;<input type='button' name='find' id='find' onclick='find()' value='查找'></p>");
    })
    //退出
    function quit() {
        var flag = confirm('是否退出系统？');
        if (flag == true) {
            location.href = "/users/login.do";
        }
    }
    function show() {
        $("#show").empty();//清除
        $("#show").append("<tr><td>序号</td><td>项目名称</td><td>产权人</td><td>身份证号</td><td>房屋类型</td><td>使用面积</td><td>建造时间</td></tr>");
        $.ajaxSettings.async = false;//同步
        $.getJSON("/users/show.do",{"pageNum":pageNum,"name":name,"cardid":cardid}, function (arrobj) {
            if (arrobj.rlist.length==0||arrobj.ulist.length==0) {
                $("#show").append("<tr><td colspan='7'><p>抱歉,暂无数据!</p></td></tr>");
            }
            $.each(arrobj.rlist, function (i, item) {
                $.each(arrobj.ulist, function (j, item2) {
                    if (item2.cardid == item.cardid) {
                        var date=new Date(item.buildtime);
                        var dateTime = date.getFullYear()+'-'+checkTime(date.getMonth()+1)+'-'+checkTime(date.getDate()); console.log(dateTime);
                        $("#show").append("<tr><td>" + item.id + "</td><td>" + item.projectname + "</td><td>" + item2.name + "</td><td>" + item.cardid + "</td><td>" + item.housetype + "</td><td>" + item.area + "</td><td>"+dateTime+"</td></tr>");
                    }
                })
            })
            $("#show").append("<tr><td colspan='7'><p><a onclick='shou(" + arrobj.pageInfo.firstPage + ")'>首页|</a><a onclick='shang(" + arrobj.pageInfo.prePage + ")'><<上一页|</a><a onclick='xia(" + arrobj.pageInfo.nextPage + ")'>下一页>>|</a><a onclick='wei(" + arrobj.pageInfo.lastPage + ")'>尾页</a>&nbsp;&nbsp;&nbsp;<span>第" + arrobj.pageInfo.pageNum + "页/共" + arrobj.pageInfo.pages + "页</span><span>&nbsp;&nbsp;&nbsp;(" + arrobj.pageInfo.total + "条)</p></td></tr>");
        })
    }
    //上一页
    function shang(obj) {
        pageNum=obj;
        show();
    }
    //下一页
    function xia(obj) {
        pageNum=obj;
        show();
    }
    //首页
    function shou(obj) {
        pageNum=obj;
        show();
    }
    //尾页
    function wei(obj) {
        pageNum=obj;
        show();
    }
    function find() {
        name="";
        cardid="";
        var result=$("#result").val();
        if(result=="name"){
           name=$("#canshu").val();
           show();
        }else if(result=="cardid"){
           cardid=$("#canshu").val();
           show();
        }
    }
    //时间处理
    function checkTime(i){
        if(i<10){ i='0'+i
        }
        return i ;
    }
</script>
</html>
