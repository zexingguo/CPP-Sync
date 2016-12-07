/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.controllers;

/**
 *
 * @author Albert Chan
 */
import cpp.business.Education;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import cpp.business.User;
import cpp.data.UserDB;
import cpp.util.PasswordUtil;
import java.util.ArrayList;

public class AccountController extends HttpServlet {

    ArrayList<Education> EdArray = new ArrayList<>();

    String firstName;
    String lastName;
    String lastNameDiploma;
    String email;
    String oldPassword;
    String newPassword;
    String getPassword;
    String message2;
    String yearOfGraduation;
    String degree;
    String major;
    String cellPhone;
    String description;
    String employer;
    String position;
    String workPhone;
    String actionVar;
    boolean publicSpeaking;
    boolean management;
    boolean leadership;
    boolean organizational;
    boolean teamwork;
    boolean communication;
    boolean computer;
    String message;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/pages/update.jsp";
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");

        String action = request.getParameter("action");
        if (action == null) {
            action = "updateSend";
        }
        if (action.equals("updateSend")) {
            session.setAttribute("user", user);
            url = "/pages/update.jsp";
        } else if (action.equals("profileSend")) {
            session.setAttribute("user", user);
            url = "/pages/profile.jsp";
        } else if (action.equals("basicInfo")) {
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            lastNameDiploma = request.getParameter("lastNameDiploma");
            email = user.getEmail();

            UserDB.updateBasicInfo(firstName, lastName, lastNameDiploma, email);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLastNameDiploma(lastNameDiploma);
            
            message = "Your changes to General Account Settings are saved";
            request.setAttribute("message", message);
            session.setAttribute("user", user);

            url = "/pages/update.jsp";
        } else if (action.equals("changePw")) {
            email = user.getEmail();
            oldPassword = request.getParameter("password");
            newPassword = request.getParameter("newpassword");
            getPassword = (String) session.getAttribute("password");

            if (UserDB.passwordMatch(oldPassword, email) == true){
                try {
                    PasswordUtil.checkPasswordStrength(newPassword);
                    UserDB.updatePassword(newPassword, email);
                    message = "Your password has been successfully changed!";
                    request.setAttribute("message", message);
                } catch (Exception e) {
                    message = e.getMessage();

                    request.setAttribute("message", message);
                }
            } else {
                message = "Your password does not match. Please try it again!";
                request.setAttribute("message", message);
            }
            url = "/pages/update.jsp";
        } else if (action.equals("addDegree")) {
            email = user.getEmail();
            yearOfGraduation = request.getParameter("yearOfGraduation");
            degree = request.getParameter("degree");
            major = request.getParameter("major");

            UserDB.insertEducation(email, yearOfGraduation, degree, major);

            EdArray = UserDB.selectEducation(email);

            user.setYearOfGraduation(yearOfGraduation);
            user.setDegree(degree);
            user.setMajor(major);

            session.setAttribute("user", user);
            session.setAttribute("EdArray", EdArray);
            message = "Your Degree Has been Added";
            request.setAttribute("message", message);
            url = "/pages/update.jsp";
        } else if (action.equals("personalInfo")) {
            email = user.getEmail();
            cellPhone = request.getParameter("cellPhone");
            description = request.getParameter("description");

            UserDB.updatePersonal(cellPhone, description, email);

            user.setCellPhone(cellPhone);
            user.setDescription(description);
            
            message = "Your Personal Information has been updated!";
            request.setAttribute("message", message);
            session.setAttribute("user", user);
            url = "/pages/update.jsp";
        } else if (action.equals("skillInfo")) {
            actionVar = "skillInfo";
            email = user.getEmail();
            publicSpeaking = request.getParameter("publicSpeaking") != null;
            management = request.getParameter("management") != null;
            leadership = request.getParameter("leadership") != null;
            organizational = request.getParameter("organizational") != null;
            teamwork = request.getParameter("teamwork") != null;
            communication = request.getParameter("communication") != null;
            computer = request.getParameter("computer") != null;
            
            if (!UserDB.accountExists(email, actionVar)) {
                UserDB.insertSkills(email, publicSpeaking, management, leadership, organizational, teamwork, communication, computer);
            } else {
                UserDB.updateSkills(publicSpeaking, management, leadership, organizational, teamwork, communication, computer, email);
            }
            user.setPublicSpeaking(publicSpeaking);
            user.setManagement(management);
            user.setLeadership(leadership);
            user.setOrganizational(organizational);
            user.setTeamwork(teamwork);
            user.setCommunication(communication);
            user.setComputer(computer);
            
            message = "Your Personal Information has been updated !";
            request.setAttribute("message", message);
            session.setAttribute("user", user);
            url = "/pages/update.jsp";

        } else if (action.equals("currentEmp")) {
            actionVar = "currentEmp";
            email = user.getEmail();
            employer = request.getParameter("employer");
            position = request.getParameter("position");
            workPhone = request.getParameter("workPhone");

            if (!UserDB.accountExists(email, actionVar)) {
                UserDB.insertCareer(email, employer, position, workPhone);
            } else {
                UserDB.updateCareer(employer, position, workPhone, email);
            }
            user.setEmployer(employer);
            user.setPosition(position);
            user.setWorkPhone(workPhone);
            
            message = "Your Current Employment has been updated !";
            request.setAttribute("message", message);
            session.setAttribute("user", user);
            url = "/pages/update.jsp";
        }

        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
