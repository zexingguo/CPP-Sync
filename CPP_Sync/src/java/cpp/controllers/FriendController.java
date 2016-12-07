/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.controllers;

import cpp.business.*;
import cpp.data.UserDB;
import cpp.util.FriendUtil;
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
public class FriendController extends HttpServlet {

    ArrayList<Friend> friendList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/pages/friends.jsp";
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        session.setAttribute("user", user);

        //Grab ArrayList for Request and FriendList (Later updatet with changes)
        ArrayList<Friend> requestArray = new ArrayList<>();
        ArrayList<Friend> friendArray = new ArrayList<>();

        requestArray = (ArrayList) session.getAttribute("requestArray");
        friendArray = (ArrayList) session.getAttribute("friendArray");

        //Initialize Variables
        String message;
        String userEmail = user.getEmail();
        String friendEmail;
        String reqEmail;

        String action = request.getParameter("action");
        if (action == null) {
            action = "friendsSend"; //deafult action

            session.setAttribute("friendArray", friendArray);
            session.setAttribute("requestArray", requestArray);
            url = "/pages/friends.jsp";
        } else if (action.equals("friendRequest")) {
            friendEmail = request.getParameter("email");
            ArrayList<Search> searchResults = (ArrayList) session.getAttribute("searchResults");

            if (UserDB.checkRequest(userEmail, friendEmail) == true) {
                message = "Friend Request Already sent, or You Are Already Friends";
                request.setAttribute("message", message);

                url = "/pages/searchresult.jsp";
            } else {
                UserDB.insertUserRequest(userEmail, friendEmail);
                message = "Your friend request has been sent ";
                request.setAttribute("searchResults", searchResults);
                request.setAttribute("message", message);
                url = "/pages/searchresult.jsp";
            }
        } else if (action.equals("addFriend")) {
            reqEmail = request.getParameter("email");

            //Update Friend Request and Arraylist that contains all the User Request 
            UserDB.updateUserRequest(user.getEmail(), reqEmail);
            requestArray = UserDB.friendRequestExists(userEmail);
            session.setAttribute("requestArray", requestArray);

            //Update Friend List ArrayList 
            friendArray = UserDB.friendList(userEmail);
            session.setAttribute("friendArray", friendArray);

            message = "Friend added";
            request.setAttribute("message", message);
            url = "/pages/friends.jsp";
        } else if (action.equals("declineFriend")) {
            reqEmail = request.getParameter("email");
            UserDB.declineFriendRequest(user.getEmail(), reqEmail);
            requestArray = UserDB.friendRequestExists(userEmail);
            session.setAttribute("requestArray", requestArray);

            message = "Friend request declined";
            request.setAttribute("message", message);
            url = "/pages/friends.jsp";

        } else if (action.equals("seeProfile")) {
//            ArrayList<Friend> profileFriendList = new ArrayList();
            ArrayList<Friend> EducationArray = new ArrayList();

            friendArray = (ArrayList) session.getAttribute("friendArray");

            //Get Every Parameters from the hidden input !! 
            String profileEmail = request.getParameter("email");

            //First use the Friend Java Class to set variable for this particular friend profile 
//            message = "the email you got " + profileEmail;
//            request.setAttribute("message", message);
            Friend friend = UserDB.selectFriend(profileEmail);

            request.setAttribute("friend", friend);

            //Get the Education Array from this friend, and pass to the profile page
            EducationArray = UserDB.selectEducation(profileEmail);
            request.setAttribute("EducationArray", EducationArray);

            url = "/pages/friend_profile.jsp";
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
