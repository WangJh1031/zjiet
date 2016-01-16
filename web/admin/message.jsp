<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>企业内容管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Admin panel developed with the Bootstrap from Twitter.">
    <meta name="author" content="travis">

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/site.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="messagebean" class="Bean.UsersMessageBean"/>

${message}
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">企业内容管理系统</a>
            <div class="btn-group pull-right">
                <a class="btn" href="index.jsp"><i class="icon-user"></i><%=session.getAttribute("uid")%></a>
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="login.jsp">退出</a></li>
                </ul>
            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li><a href="index.jsp">公司介绍设置</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">用户管理 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="users.jsp">用户编辑</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">留言管理 <b class="caret"></b></a>
                        <ul class="dropdown-menu">

                            <li><a href="message.jsp">留言编辑</a></li>
                        </ul>
                    </li>
                    <li><a href="stats.html">产品管理</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header"><i class="icon-wrench"></i> 管理菜单</li>
                    <li><a href="users.jsp">用户管理</a></li>
                    <li><a href="message.jsp">留言管理</a></li>
                    <li><a href="items.jsp">产品管理</a></li>
                    <li><a href="news.jsp">新闻管理</a></li>
                    <li><a href="#">退出登录</a></li>
                </ul>
            </div>
        </div>
        <div class="span9">
            <div class="row-fluid">
                <div class="page-header">
                    <h1>Message <small>All messages</small></h1>
                </div>
                <table class="table table-striped table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>反馈邮箱</th>
                        <th>留言标题</th>
                        <th>留言时间</th>

                    </tr>
                    </thead>
                    <c:forEach items="${messagebean.all}" var="messageedit">
                        <form action="message_info" method="post" id="useredit">
                            <tbody>

                            <tr class="list-users">
                                <td>${messageedit.user_id}</td>
                                <td>${messageedit.user_name}</td>
                                <td><input type="hidden" value="${messageedit.message_title}" name="title">${messageedit.message_title}</td>
                                <td>${messageedit.message_date}</td>


                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#" >Actions <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><i class="icon-pencil"></i><input type="submit" name="actions" value="info" class="btn"></li>
                                            <li><i class="icon-trash"></i><input type="submit" name="actions" value="delete" class="btn"></li>

                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </form>
                    </c:forEach>
                </table>


            </div>
        </div>

        <hr>



    </div>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
