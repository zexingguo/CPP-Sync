<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cpp_Sync</title>

    <!-- Bootstrap Core CSS -->
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
          <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

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
    
      <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1 class="indexHeader">CPP Sync</h1>
            <h3 class="indexHeader">We Connect YOU</h3>
            <br>
         
         <div class="container">
             
      <button type="button" class="btn btn-success btn-lg" data-toggle="modal" href="#login">
             Click Here to Login
      </button>
            
           <div class="modal fade" id="login" tabindex="-1" role="dialog">
                <div class="modal-dialog">
                <div class="modal-content">
                          <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h2 class="modal-title">Login to Cpp Sync</h2>
                                <input type="hidden" id="message" name="AlertMessage" value="${message}">
                      
                                <div class="alert alert-danger alert-dismissable" role="alert" id="messageModal">
                                    <a class="panel-close close" data-dismiss="alert">×</a>
                                    <i class="fa fa-exclamation"></i>&nbsp;${message}
                                </div>

                          </div>
                          <div class="modal-body">
                                    <form class="form-horizontal" role="form" action="UserController" method="post">
                                        <input type="hidden" name="action" value="check"> 
                                          <div class="form-group">
                                            <label class="control-label col-sm-2" for="email">Email:</label>
                                            <div class="col-sm-5">
                                              <input type="email" class="form-control" id="email" name="email" value="" placeholder="Enter email" required>
                                            </div>
                                          </div>
                                          <div class="form-group">
                                            <label class="control-label col-sm-2" for="password">Password:</label>
                                            <div class="col-sm-5">
                                              <input type="password" class="form-control" id="password" name="password" value="" placeholder="Enter password">
                                            </div>
                                          </div>
                                          <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                              <p>New To Cpp Sync? <a type="button" class="btn btn-success " href="register.jsp">Register </a>  <input type="submit" value="Sign In" class="btn btn-success"> Sign in</p>
                                            </div>
                                          </div>
                                  </form>
                          </div>
                          <div class="modal-footer">
                             <p>Welcome to Cpp Sync, Let's Connect :) </p>
                          </div>
                </div>
                </div>
            </div>    <!-- End of Login Modal -->




        </div> <!-- End of container -->
        </div>
    </header>
  
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
                      $("#login").modal();
                      $('#messageModal').slideDown();
                  }

              });
    </script>

</body>

</html>
    