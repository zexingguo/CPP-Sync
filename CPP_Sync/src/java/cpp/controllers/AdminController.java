/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.controllers;

import cpp.business.Admin;
import cpp.business.User;
import cpp.data.UserDB;
import cpp.util.PasswordUtil;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author achan
 */
public class AdminController extends HttpServlet {

    ArrayList<Admin> UserArray = new ArrayList<>();

    String email;
    String newPassword;
    String message2;
    String admin;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/pages/admin.jsp";
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        UserArray = UserDB.selectAllUsers();
        session.setAttribute("user", user);
        session.setAttribute("UserArray", UserArray);

        String action = request.getParameter("action");
        if (action == null) {
            action = "adminSend";
        }
        if (action.equals("adminSend")) {
            session.setAttribute("user", user);
            url = "/pages/admin.jsp";
        } else if (action.equals("adminChangePw")) {
            email = request.getParameter("email");
            newPassword = request.getParameter("newpassword");
            message2 = "";

            try {
                PasswordUtil.checkPasswordStrength(newPassword);
                UserDB.updatePassword(newPassword, email);
                message2 = "Password for account: ( " + email + " ) has been successfully changed!";
                request.setAttribute("message2", message2);
            } catch (Exception e) {
                message2 = e.getMessage();
                request.setAttribute("message2", message2);
            }
        } else if (action.equals("deleteUserAccount")) {
            email = request.getParameter("email");
            admin = request.getParameter("admin");
            if (email.equalsIgnoreCase(user.getEmail())) {
                message2 = "You cannot delete your own account!";
                request.setAttribute("message2", message2);
            } else if (admin.equalsIgnoreCase("true")) {
                message2 = "You cannot delete an admin account!";
                request.setAttribute("message2", message2);
            } else {
                UserDB.deleteUserAccount(email);
                message2 = "User account: ( " + email + " ) has been successfully deleted!";
                request.setAttribute("message2", message2);

                UserArray = UserDB.selectAllUsers();
                session.setAttribute("user", user);
                session.setAttribute("UserArray", UserArray);
                url = "/pages/admin.jsp";
            }
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
