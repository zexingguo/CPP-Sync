<%-- 
    Document   : admin
    Created on : Mar 6, 2016, 7:07:20 PM
    Author     : achan
--%>
<%@page import="cpp.business.Admin"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/includes/header.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<Admin> UserArray = new ArrayList<>();
    UserArray = (ArrayList) session.getAttribute("UserArray");
%>
<c:if test="${user.admin == true}">
    <body>
        <input type="hidden" id="message" name="AlertMessage" value="${message2}">
        <!-- Admin Section -->
           <section>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-center">
                            <br><br>
                                <div class="alert alert-info alert-dismissable" role="alert" id="messageModal">
                                    <a class="panel-close close" data-dismiss="alert">×</a>
                                    <i class="fa fa-thumbs-o-up"></i>&nbsp;${message2}
                                </div>
                                <h2>Admin Account Control Center</h2>
                                <hr class="star-primary">
                            </div>
                        </div>
                        <br><br>
                        <table class="table table-striped">
                                              <thead>
                                                  <tr>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>User Account (Email)</th>
                                                    <th>New Password</th>
                                                    <th>Delete Account</th>
                                                  </tr>
                                             </thead>
                                            <tbody>
        <%for(Admin user : UserArray) {%>    
               <tr>
                 <td><%=user.getFirstName()%></td>
                 <td><%=user.getLastName()%></td>
                 <td><%=user.getEmail()%></td>
                 <td>
                   <form class="form-horizontal">
                     <div class="form-group">    
                           <input type="hidden" name="action" value="adminChangePw">
                           <input type="hidden" name="email" value="<%=user.getEmail()%>">
                           <label class="control-label col-sm-2" for="NewPassword">Password: </label>
                           <div class="col-sm-5">
                           <input class="form-control" type="password" name="newpassword" value="" placeholder="Enter New Password" required>
                           </div>
                           <input class="btn btn-primary" type="submit" name="adminChangePW" value="Change Password">
                     </div>
                     </form>
                 </td>
                <td>
                    <form>
                        <input type="hidden" name="action" value="deleteUserAccount">
                        <input type="hidden" name="email" value="<%=user.getEmail()%>">
                        <input type="hidden" name="admin" value="<%=user.getAdmin()%>">
                        <input class="btn btn-primary" type="submit" name="adminDeleteUser" value="Delete User Account">
                    </form>
                </td>
               </tr>
        <%}%>
  </tbody>
</table>
</div>
</section>
    </body>
</c:if>
<c:if test="${user.admin == false}">
    <body>
        <h1> Access Denied</h1>
        <p>You do not have Admin Access</p>
    </body>
</c:if>

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
    $(document).ready(function () {
        var message = document.getElementById('message').value;

        if (message == "" || message == null) {
            $('#messageModal').hide();
        } else {
            $('#messageModal').show();
        }

    });
</script>
</body>

</html> 
