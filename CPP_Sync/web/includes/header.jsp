<%-- 
    Document   : header
    Created on : Feb 29, 2016, 7:53:21 AM
    Author     : achan
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.GregorianCalendar, java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    int total = 0;
%>
<!doctype html>

<html>
   <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Cpp Sync</title>

        <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/profile.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">CPP Sync</a>
            </div>

            <form class="navbar-form navbar-left" method="post" action="UserController">
                    <div class="form-group">
                          <input type="hidden" name="action" value="search">
                          <input  class="form-control" type="Search" name="search" value=""  placeholder="Search People">
                          <select class="form-control" name="yearOfGraduationFrom" >
                          <% for (int i = 1968; i <= currentYear; i++) {%>
                          <option value="<%=i%>"><%=i%></option>
                          <% }%> 
                        </select>
                        <select class="form-control" name="yearOfGraduationTo" >
                            <% for (int i = 1968; i <= currentYear; i++) { %>
                            <option value="<%=total%>" selected><%=i%></option>
                            <%total += i; } %> 
                        </select>
                    </div>
                        <input type="submit" class="btn btn-default" value="Submit">
            </form>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <c:if test="${user.admin == true}">
                    <li>
                    <form id="admin" method="post" action="AdminController">
                        <input type="hidden" name="action" value="adminSend" /> 
                    </form>
                    <a href="javascript:{}" onclick="document.getElementById('admin').submit();">Admin Center</a>
                    </li>
                    </c:if>
                    <li class="page-scroll">
                        <form id="profile" method="post" action="AccountController">
                        <input type="hidden" name="action" value="profileSend" />         
                        </form>
                        <a href="javascript:{}" onclick="document.getElementById('profile').submit();">My Profile</a>
                    </li>
                    <li class="page-scroll">
                        <form id="myform" method="post" action="AccountController">
                            <input type="hidden" name="action" value="updateSend" />
                        </form>
                        <a href="javascript:{}" onclick="document.getElementById('myform').submit();">My Account</a>
                    </li>
                    <li class="page-scroll">
                        <form id="friends" method="post" action="FriendController">
                        <input type="hidden" name="action" value="friendsSend" />
                        </form>
                        <a href="javascript:{}" onclick="document.getElementById('friends').submit();">Friends</a>
                    </li>
                    <li class="page-scroll">
                        <form id="signOut" method="post" action="UserController">
                        <input type="hidden" name="action" value="signout" />
                        </form>
                        <a href="javascript:{}" onclick="document.getElementById('signOut').submit();">Sign Out</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
