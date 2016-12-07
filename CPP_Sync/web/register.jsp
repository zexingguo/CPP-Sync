<%-- 
    Document   : register
    Created on : Feb 26, 2016, 8:54:50 PM
    Author     : JKguo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.GregorianCalendar, java.util.Calendar"%>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Cpp Sync</title>

        <!-- Bootstrap Core CSS -->
          <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
              <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
              <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

        <!-- Custom CSS -->
        <link href="css/profile.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <input type="hidden" id="message" name="AlertMessage" value="${message}">
        <nav class="navbar navbar-default navbar-static-top">
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.jsp">Cpp Sync</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">Login</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <h1 class="registerH1">Register</h1>
                    <div class="alert alert-danger alert-dismissable" role="alert" id="messageModal">
                        <a class="panel-close close" data-dismiss="alert">×</a>
                        <i class="fa fa-exclamation"></i> &nbsp;${message}
                    </div>
            <br>
            <form class="form-horizontal" role="form" action="UserController" method="post">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="firstName">First Name:</label>
                    <div class="col-sm-5">
                        <input class="form-control" id="firstName" type="text" name="firstName" value=""  required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lastName">Last Name: </label>
                    <div class="col-sm-5">
                        <input class="form-control" id="lastName" type="text" name="lastName" value="" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="lastNameDiploma">Last Name In Diploma: </label>
                    <div class="col-sm-5">
                        <input class="form-control" id="lastNameDiploma" type="text" name="lastNameDiploma" value="" required>
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" id="email" name="email" value="" placeholder="Enter email" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="password1">Password:</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" id="password" name="password" value="" placeholder="Enter password" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="password2">Re-Enter Password: </label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" id="password" name="password2" value="" placeholder="Re-Enter password" required>
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label for="yearofGraduation" class="control-label col-sm-2" >Year of Graducation:</label>
                    <div class="col-sm-5">
                        <select class="form-control" id="yearofGraduation" name="yearOfGraduation" >
                            <% for (int i = 1968; i <= currentYear; i++) { %>
                                <option value="<%=i%>"><%=i%></option>
                            <% } %> 
                        </select>
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label for="degree" class="control-label col-sm-2" >Degree</label>
                    <div class="col-sm-5">
                        <select class="form-control" id="degree"  name="degree">
                            <option value="BS">BS</option>
                            <option value="MSBA">MSBA</option>
                            <option value="MBA">MBA</option>
                        </select>
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label for="major" class="control-label col-sm-2" >Major</label>
                    <div class="col-sm-5">
                        <select class="form-control" id="degree"  name="major">
                            <option value="Accounting">Accounting</option>
                            <option value="CIS">CIS</option>
                            <option value="Finance">Finance</option>
                            <option value="Management">Management</option>
                            <option value="Marketing">Marketing</option>
                            <option value="MSBA">MSBA</option>
                            <option value="MBA">MBA</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">
                        <p> <input type="submit" class="btn btn-success" value="Register"></p>
                    </div>
                </div>
                <br><br>
         </form>
        </div>
<!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $( document ).ready(function() {
                  var message = document.getElementById('message').value;;
                 
                  if(message == "" || message == null){
                      $('#messageModal').hide();
                  }else{
                      $('#messageModal').show();
                  }

              });
    </script>

</body>

</html>