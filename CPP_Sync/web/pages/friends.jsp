<%@page import="cpp.business.Friend"%>
<%@page import="cpp.business.Search"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/includes/header.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
    ArrayList<Friend> requestList = new ArrayList();
    requestList = (ArrayList)session.getAttribute("requestArray");
    ArrayList<Friend> friendList = new ArrayList();
    friendList = (ArrayList)session.getAttribute("friendArray");
%>
    <!-- Friend List Section -->
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
                        <h2>Friend Page</h2>
                        <hr class="star-primary">
                    </div>
                </div>
                <br><br>
                <h4>Friend Requests</h4>
                <table class="table table-striped">
                                      <thead>
                                          <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                          </tr>
                                     </thead>
                                    <tbody>
                                        <% for(Friend result : requestList) { %>
                                        <tr>
                                            <td><%=result.getFirstName()%></td>
                                            <td><%=result.getLastName()%></td>
                                            <td>
                                                <form id="addFriend" method="post" action="FriendController">
                                                    <input type="hidden" name="action" value="addFriend"/>
                                                    <input type="hidden" name="email" value="<%=result.getEmail()%>"/>
                                                    <input id="add" type="submit" onclick="hideAddButton()" class="btn btn-success" value="Add">
                                                </form>
                                                
                                            </td>
                                            <td>
                                                <form id="declineFriend" method="post" action="FriendController">
                                                    <input type="hidden" name="action" value="declineFriend"/>
                                                    <input type="hidden" name="email" value="<%=result.getEmail()%>"/>
                                                </form>
                                                <input id="decline" type="submit" onclick="hideDeclineButton()" class="btn btn-default" value="Decline">
                                            </td>
                                        </tr>
                                        <% } %>  
                                    </tbody>
                </table>
                <br>
                <h4>Friend Lists</h4>
                <table class="table table-striped">
                                      <thead>
                                          <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                          </tr>
                                     </thead>
                                    <tbody>
                                        <% for(Friend result : friendList) { %>
                                        <tr>
                                            <td><%=result.getFirstName()%></td>
                                            <td><%=result.getLastName()%></td>
                                            <td>
                                                <form id="seeProfile" method="post" action="FriendController">
                                                    <input type="hidden" name="action" value="seeProfile"/>
                                                    <input type="hidden" name="email" value="<%=result.getEmail()%>"/>
                                                    <input type="submit" onclick="document.getElementById('seeProfile').submit();" class="btn btn-success" value="View Profile">
                                                </form>
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
              
              function hideAddButton(){
                  $('#add').hide();
                  document.getElementById('addFriend').submit();
              }
              function hideDeclineButton(){
                  $('#decline').hide();
                  document.getElementById('declineFriend').submit();
              }
    </script>
    </body>

</html> 
