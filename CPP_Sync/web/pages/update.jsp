<%-- 
    Document   : update
    Created on : Feb 28, 2016, 1:43:59 PM
    Author     : Anderson
--%>

<%@page import="cpp.business.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cpp.business.Education"%>
<jsp:include page="/includes/header.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.GregorianCalendar, java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<% ArrayList<Education> EdArray = new ArrayList<>(); 
   EdArray = (ArrayList)session.getAttribute("EdArray"); 
%>
<jsp:include page="/includes/header.jsp" />
      
        <section>
            <input type="hidden" id="message" name="AlertMessage" value="${message}">
            <div class="container">
            <h1>Edit Profile</h1>
            <hr>
            <div class="row">
              <!-- left column -->
              <div class="col-md-3">
                <div class="text-center">
                    <div class="profile-userpic">
                    <img src="img/default.jpg" class="avatar img-circle" alt="avatar" style="width: 70%; height:70%;">
                    </div>
                  <h6>Upload a Photo</h6>
                   <form id="profile" method="post" action="UserController">
                       <input type="hidden" name="action" value="photo" >
                       <input type="file" class="form-control">
                       <p><input type="submit" class="btn btn-primary" value="Submit"></p>
                   </form>
                  
                </div>
              </div>

              <!-- edit form column -->
              <div class="col-md-9 personal-info">
                      <div class="alert alert-info alert-dismissable" role="alert" id="messageModal">
                        <a class="panel-close close" data-dismiss="alert">×</a>
                        <i class="fa fa-thumbs-o-up"></i>&nbsp;${message}
                      </div>
                      <h3>Personal info</h3>
                     <!--  Different Update Forms -->

                     <!-- General Account Settings -->
                     <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                          <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                              <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                  General Account Settings
                                </a>
                              </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                              <div class="panel-body">
                                    <form class="form-horizontal" role="form" action="AccountController" method="post">
                                            <input type="hidden" name="action" value="basicInfo">
                                            <div class="form-group">
                                                <label class="control-label col-sm-2" for="firstName">First Name:</label>
                                                <div class="col-sm-5">
                                                  <input class="form-control" id="firstName" type="text" name="firstName" value="${user.firstName}"  required>
                                                </div>
                                            </div>
                                          <div class="form-group">
                                                <label class="control-label col-sm-2" for="lastName">Last Name: </label>
                                                <div class="col-sm-5">
                                                <input class="form-control" id="lastName" type="text" name="lastName" value="${user.lastName}" required>
                                                </div>
                                          </div>
                                          <div class="form-group">
                                                <label class="control-label col-sm-2" for="lastNameDiploma">Last Name In Diploma: </label>
                                                <div class="col-sm-5">
                                                  <input class="form-control" id="lastNameDiploma" type="text" name="lastNameDiploma" value="${user.lastNameDiploma}" required>
                                                </div>
                                          </div>
                                          <div class="col-sm-offset-4 col-sm-4">
                                             <p> <input type="submit" class="btn btn-primary" value="Submit"></p>
                                          </div>
                                    </form>
                              </div>
                            </div>
                          </div>

                          <!-- Change Password -->
                          <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingTwo">
                              <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                  Change Password
                                </a>
                              </h4>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                              <div class="panel-body">
                                        <form class="form-horizontal" role="form">
                                            <input type="hidden" name="action" value="changePw">
                                            <div class="form-group">
                                               <label class="control-label col-sm-2" for="OldPassword">Old Password:</label>
                                                <div class="col-sm-5">
                                                  <input class="form-control" type="password" name="password" value="" placeholder="Enter your Old Password" required>
                                                </div>
                                            </div>
                                          <div class="form-group">
                                                <label class="control-label col-sm-2" for="NewPassword">New Password</label>
                                                <div class="col-sm-5">
                                                <input class="form-control" type="password" name="newpassword" value="" placeholder="Enter your New Password" required>
                                                </div>
                                          </div>
                                          <div class="col-sm-offset-4 col-sm-4">
                                             <p> <input type="submit" class="btn btn-primary" value="Submit"></p>
                                          </div>
                                    </form>
                              </div>
                            </div>
                          </div>

                          <!-- Add Degrees -->
                          <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingThree">
                              <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                  Add Degrees
                                </a>
                              </h4>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                              <div class="panel-body">
                                       <form class="form-horizontal" role="form">
                                            <input type="hidden" name="action" value="addDegree">
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
                                          <div class="col-sm-offset-4 col-sm-4">
                                              <p> <input type="submit" class="btn btn-primary" value="Submit"></p>
                                          </div>
                                      </form>
                                      <br>
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
                              </div>
                            </div>
                          </div>

                         <!-- Personal Information -->
                          <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingFour">
                              <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                  Personal Information
                                </a>
                              </h4>
                            </div>
                            <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                              <div class="panel-body">
                                      <form class="form-horizontal" role="form">
                                            <input type="hidden" name="action" value="personalInfo">
                                            <div class="form-group">
                                               <label class="control-label col-sm-2" for="description">Tell us about yourself</label>
                                                <div class="col-sm-5">
                                                  <textarea class="form-control" rows="5" name="description" cols="50">${user.description}</textarea>
                                                </div>
                                          </div>
                                          <div class="form-group">
                                                <label class="control-label col-sm-2" for="cellPhone">CellPhone</label>
                                                <div class="col-sm-5">
                                                <input class="form-control" type="text" name="cellPhone" value="${user.cellPhone}" required>
                                                </div>
                                          </div>
                                          <div class="col-sm-offset-4 col-sm-4">
                                             <p> <input type="submit" class="btn btn-primary" value="Submit"></p>
                                          </div>
                                    </form>
                               </div>
                              </div>
                          </div>

                          <!-- Add Skills -->
                          <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingFive">
                              <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                  Add Skills
                                </a>
                              </h4>
                            </div>
                            <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
                              <div class="panel-body">
                              <form role="form">
                              <input type="hidden" name="action" value="skillInfo">
                                          <div class="checkbox">
                                            <label><input type="checkbox" name="publicSpeaking" value="publicSpeaking" <c:if test="${user.publicSpeaking == true}">checked="checked"</c:if>  />Public Speaking</label>
                                          </div>
                                          <div class="checkbox">
                                            <label><input type="checkbox" name="management" value="management" <c:if test="${user.management == true}">checked="checked"</c:if>  />Management</label>
                                          </div>
                                          <div class="checkbox">
                                            <label><input type="checkbox" name="leadership" value="leadership" <c:if test="${user.leadership == true}">checked="checked"</c:if> />Leadership</label>
                                          </div>
                                          <div class="checkbox">
                                            <label><input type="checkbox" name="organizational" value="organizational" <c:if test="${user.organizational == true}">checked="checked"</c:if> />Organizational</label>
                                          </div>
                                          <div class="checkbox">
                                            <label><input type="checkbox" name="teamwork" value="teamwork" <c:if test="${user.teamwork == true}">checked="checked"</c:if> />Teamwork</label>
                                          </div>
                                          <div class="checkbox">
                                            <label><input type="checkbox" name="communication" value="communication" <c:if test="${user.communication == true}">checked="checked"</c:if> />Communication</label>
                                          </div>
                                          <div class="checkbox">
                                            <label><input type="checkbox" name="computer" value="computer" <c:if test="${user.computer == true}">checked="checked"</c:if> />Computer</label>
                                          </div>
                                          <div class="col-sm-4">
                                             <p> <input type="submit" class="btn btn-primary" name="SkillInfo" value="Update Skills"></p>
                                          </div>
                                    </form>
                               </div>
                              </div>
                          </div>


                          <!-- Current Employment -->
                          <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingSix">
                              <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                                   Current Employment
                                </a>
                              </h4>
                            </div>
                            <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
                              <div class="panel-body">
                                      <form class="form-horizontal" role="form">
                                            <input type="hidden" name="action" value="currentEmp">
                                            <div class="form-group">
                                               <label class="control-label col-sm-2" for="employer">Employer</label>
                                                <div class="col-sm-5">
                                                    <input class="form-control" name="employer" value="${user.employer}" required>
                                                </div>
                                          </div>
                                          <div class="form-group">
                                                <label class="control-label col-sm-2" for="position">Position</label>
                                                <div class="col-sm-5">
                                                   <input class="form-control" name="position" value="${user.position}" required>
                                                </div>
                                          </div>
                                          <div class="form-group">
                                                <label class="control-label col-sm-2" for="workPhone">Work Phone</label>
                                                <div class="col-sm-5">
                                                   <input class="form-control" type="text" name="workPhone" value="${user.workPhone}" required>
                                                </div>
                                          </div>
                                          <div class="col-sm-offset-4 col-sm-4">
                                             <p> <input type="submit" class="btn btn-primary" value="Submit"></p>
                                          </div>
                                    </form>
                               </div>
                              </div>
                          </div>

                    </div>  <!-- End of Left Column -->

              </div>
              </div>
            </div>
            <hr>
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