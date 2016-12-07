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
import cpp.business.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import cpp.business.User;
import cpp.data.UserDB;
import cpp.util.PasswordUtil;
import java.util.ArrayList;

public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Education> EdArray = new ArrayList<>();
        ArrayList<Friend> requestArray = new ArrayList<>();
        ArrayList<Friend> friendArray = new ArrayList<>();
        User user = new User();
        String url = "/index.jsp";
        HttpSession session = request.getSession();
        String message = "";
        
        request.setAttribute("message", message);
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/register.jsp";    // the "join" page
        } else if (action.equals("check")) {
            //login
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            message = "";
            
            
            try {
                PasswordUtil.checkPasswordStrength(password);
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message != "") {
                request.setAttribute("message", message);
                url = "/index.jsp";
            } else {
                if (UserDB.accountExists(email, "") == false) {
                    message = "You do not have an account, please signup!";
                    request.setAttribute("message", message);
                    url = "/register.jsp";
                } else if (UserDB.passwordMatch(password, email) == true) {
                   
                    session.setAttribute("password", password);
                    user = UserDB.selectUser(email);
                    EdArray = UserDB.selectEducation(email);
                    String userEmail = user.getEmail();
                    //Check Friend Request and FriendList
                    String friendExist = "friendExist";
                    if(UserDB.accountExists(email, friendExist) == true){
                        requestArray = UserDB.friendRequestExists(email);
                        friendArray = UserDB.friendList(email);
                    }
                    session.setAttribute("requestArray", requestArray);
                    session.setAttribute("friendArray", friendArray);
                    session.setAttribute("user", user);
                    session.setAttribute("userEmail", userEmail);
                    if(requestArray.size() >= 1){
                        message = "You have " + requestArray.size() + " pending friend requests, please go to your Friend List!";
                        request.setAttribute("message", message);
                    }
                    
                    session.setAttribute("EdArray", EdArray);
                    url = "/pages/profile.jsp";
                } else {
                    message = "Password incorrect, please re-enter!";
                    request.setAttribute("message", message);
                    url = "/index.jsp";
                }
            }
        } else if (action.equals("add")) {
            // get parameters from the request
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String lastNameDiploma = request.getParameter("lastNameDiploma");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            String yearOfGraduation = request.getParameter("yearOfGraduation");
            String degree = request.getParameter("degree");
            String major = request.getParameter("major");
            String cellPhone = request.getParameter("cellPhone");
            Boolean admin = false;

            if (UserDB.accountExists(email, "") == true) {
                message = "This account already exists, please use another email!";
                request.setAttribute("message", message);
                url = "/register.jsp";

            } else {
                try {
                    PasswordUtil.checkPasswordStrength(password);
                            if (!password.equals(password2)) {
                            message = "Password does not match, please re-enter";
                            request.setAttribute("message", message);
                            url = "/register.jsp";
                            } else {
                                user = new User(email, firstName, lastName, lastNameDiploma, password, cellPhone, yearOfGraduation, degree, major, admin);
                                UserDB.insert(user);   
                                EdArray = UserDB.selectEducation(email);
                                session.setAttribute("EdArray", EdArray);
                                session.setAttribute("user", user);

                                session.setAttribute("requestArray", requestArray);
                                session.setAttribute("friendArray", friendArray);

                                String userEmail = user.getEmail();
                                session.setAttribute("userEmail", userEmail);
                                
                                message= null;
                                request.setAttribute("message", message);
                                url = "/pages/profile.jsp";
                            }
                } catch (Exception e) {
                    message = e.getMessage();
                }
                
            }
        }
        else if(action.equals("search")){
            requestArray = (ArrayList)session.getAttribute("requestArray");
            friendArray = (ArrayList)session.getAttribute("friendArray");
            
            String search = request.getParameter("search");
            
            
            String email = (String)session.getAttribute("userEmail");
            request.setAttribute("message", message);
            String yearOfGraduationFrom = request.getParameter("yearOfGraduationFrom");
            String yearOfGraduationTo = request.getParameter("yearOfGraduationTo");
            ArrayList<Search> searchResults = UserDB.searchResults(search, yearOfGraduationFrom, yearOfGraduationTo, email);
            session.setAttribute("searchResults", searchResults);
            
            message = "Search results";
            request.setAttribute("message", message);
                url = "/pages/searchresult.jsp";
            }
        else if(action.equals("signout")){
            session.invalidate();
            url = "/index.jsp";
        }
        else if(action.equals("photo")){
            message = "Got photo sumbit";
            request.setAttribute("message", message);
            
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
