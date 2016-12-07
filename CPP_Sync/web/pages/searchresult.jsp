<%-- 
    Document   : searchresult
    Created on : Feb 29, 2016, 10:52:44 AM
    Author     : achan
--%>
<%@page import="cpp.business.Search"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/includes/header.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<Search> list = new ArrayList();
    list = (ArrayList)session.getAttribute("searchResults");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body>
    <!-- Search Result Section -->
    <section>

            <input type="hidden" id="message" name="AlertMessage" value="${message}">
             <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                    <br><br>
                     <div class="alert alert-info alert-dismissable" role="alert" id="messageModal">
                        <a class="panel-close close" data-dismiss="alert">×</a>
                        <i class="fa fa-thumbs-o-up"></i>&nbsp;${message}
                    </div>  
                        <h2>Search Results</h2>
                        
                        <hr class="star-primary">
                    </div>
                </div>
                <br><br>
                <table class="table table-striped">
                                      <thead>
                                          <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Year of Graduation</th>
                                            <th>Degree</th>
                                            <th>Major</th>
                                            <th></th>
                                          </tr>
                                     </thead>
                                    <tbody>
                                        <% for(Search result : list) { %>
                                        <tr>
                                            <td><%=result.getFirstName()%></td>
                                            <td><%=result.getLastName()%></td>
                                            <td><%=result.getYearOfGraduation()%></td>
                                            <td><%=result.getDegree()%></td>
                                            <td><%=result.getMajor()%></td>
                                            <td>
                                                <form id="friend" method="post" action="FriendController">
                                                    <input type="hidden" name="action" value="friendRequest"/>
                                                    <input type="hidden" name="email" value="<%=result.getEmail()%>"/>
                                                </form>
                                                    <!--<input type="submit" id ="request" onclick="requestClick()" class="btn btn-success" value="Send Friend Request">-->
                                            
                                                <input type="submit" onclick="document.getElementById('friend').submit();" class="btn btn-success" value="Send Friend Request">
                                               
                                            </td>
                                        </tr>
                                      <% } %>  
                                    </tbody>
                </table>
             </div>
     </section>
        
<!-- Footer -->
    <footer class="text-center navbar-fixed-bottom">
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy;  CPP Sync 2016 - Developers: Zexing Jack Guo, Albert Chan, Anderson Lam
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll visible-xs visible-sm">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>



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
    </body>

</html> 
