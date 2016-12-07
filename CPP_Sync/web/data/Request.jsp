<%-- 
    Document   : Request
    Created on : Mar 9, 2016, 9:12:10 AM
    Author     : JKguo
--%>

<%@page import="cpp.business.Friend"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Friend> requestArray = new ArrayList();
    requestArray = (ArrayList)session.getAttribute("requestArray");
    String message;
    if(requestArray.size() >= 1){
        message = "You have " + requestArray.size() + " pending friend requests, please go to your Friend List!";
    }else{
        message = "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <input type="hidden" id="message" name="AlertMessage" value="<%=message%>">
        <div class="alert alert-info alert-dismissable" role="alert" id="messageModal">
            <a class="panel-close close" data-dismiss="alert">×</a>
            <i class="fa fa-bell"></i>&nbsp;<%=message%>
        </div>  
    </body>
        <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/freelancer.js"></script>
    <script type="text/javascript">
        $( document ).ready(function() {
                  var message = document.getElementById('message').value;
                 
                  if(message == "" || message == null){
                      $('#messageModal').hide();
                  }else{
                      $('#messageModal').show();
                  }

              });
    </script>
</html>
