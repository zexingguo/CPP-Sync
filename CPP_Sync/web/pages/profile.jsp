<%-- 
    Document   : profile
    Created on : Feb 29, 2016, 10:58:24 AM
    Author     : achan
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="cpp.business.Education"%>
<%@page import="cpp.business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp" />
<% ArrayList<Education> EdArray = new ArrayList<>(); 
   EdArray = (ArrayList)session.getAttribute("EdArray");
%>

    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <input type="hidden" id="message" name="AlertMessage" value="${message}">
                <div class="alert alert-info alert-dismissable" role="alert" id="messageModal">
                        <a class="panel-close close" data-dismiss="alert">×</a>
                        <i class="fa fa-thumbs-o-up"></i>&nbsp;${message}
                </div>   
                        <div class="profile-userpic">
                        <img class="img-responsive" src="img/default.jpg" alt="">
                        </div>
                    <div class="intro-text">
                        <span class="name">${user.firstName} ${user.lastName}</span>
                        <p><span class="skills">${user.email}</span></p>
                         <p><span class="skills">${user.cellPhone}</span></p>
                        <hr class="star-light">
                        <p><span class="skills">${user.description}</span></p>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Education Section -->
    <section id="userProfile">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Education and Skills</h2>
                    <small>If you want to Add More, Click on Edit My Profile</small>
                    <hr class="star-primary">
                </div>
            </div>
                    <table class="table table-striped">
                          <thead>
                              <tr>
                                <th>Last Name in Diploma</th>
                                <th>Degree</th>
                                <th>Year of Graduation</th>
                                <th>Major</th>
                              </tr>
                         </thead>
                        <tbody>
                             <%for(Education ed: EdArray) {%> 
                                <tr>
                                    <td>${user.lastNameDiploma}</td>
                                    <td><%=ed.getYearOfGraduation()%></td>
                                    <td><%=ed.getDegree()%></td>		
                                    <td><%=ed.getMajor()%></td>
                               </tr> 
                             <% } %>     
                        </tbody>
                    </table>
            <br><br>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="education-text">
                         <h2>Skills</h2>
                          <small>If you want to Add More, Click on My Account</small>
                         <hr class="star-primary">
                         <p><span class="skills">
                            <c:if test="${user.publicSpeaking == true}">Public Speaking</c:if> 
                            <c:if test="${user.management == true}">&nbsp; &nbsp;Management</c:if>
                            <c:if test="${user.leadership == true}">&nbsp; &nbsp;Leadership</c:if>
                            <c:if test="${user.organizational == true}">&nbsp; &nbsp;Organizational</c:if>
                            <c:if test="${user.teamwork == true}">&nbsp; &nbsp;Teamwork</c:if>
                            <c:if test="${user.communication == true}">&nbsp; &nbsp;Communication</c:if>
                            <c:if test="${user.computer == true}">&nbsp; &nbsp;Computer</c:if>
                            </span></p>
                    </div>
                </div>
            </div>



    </section>

    <!-- Career Section -->
    <section class="success" id="career">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Career</h2>
                     <small>If you want to Edit, Click on My Account</small>
                    <hr class="star-light">
                </div>
            </div>
            <div class="row">
             <div class="col-lg-12 text-center">
                <div class="col-lg-4 col-lg-offset-2">
                    <h3>Employer:</h3>
                </div>
                <div class="col-lg-4">
                    <h3>${user.employer}</h3>
                </div>
             </div>
            </div>
            <div class="row">
             <div class="col-lg-12 text-center">
                <div class="col-lg-4 col-lg-offset-2">
                    <h3>Position:</h3>
                </div>
                <div class="col-lg-4">
                    <h3>${user.position}</h3>
                </div>
             </div>
            </div>
            <div class="row">
             <div class="col-lg-12 text-center">
                <div class="col-lg-4 col-lg-offset-2">
                    <h3>Work Phone:</h3>
                </div>
                <div class="col-lg-4">
                    <h3>${user.workPhone}</h3>
                </div>
             </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="text-center navbar-static-bottom">
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