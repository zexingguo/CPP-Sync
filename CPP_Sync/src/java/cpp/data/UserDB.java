/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.data;

/**
 *
 * @author Albert Chan
 */
import cpp.business.*;
import java.sql.*;
import java.util.ArrayList;

public class UserDB {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/CppSyncDB";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "sesame";

    public static void insert(User user) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "INSERT INTO User (Email, FirstName, LastName, LastNameDiploma, Password, Admin) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            String userQuery2
                    = "INSERT INTO Education (Email, YearOfGraduation, Degree, Major)"
                    + "VALUES (?, ?, ?, ?)";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getFirstName());
                ps.setString(3, user.getLastName());
                ps.setString(4, user.getLastNameDiploma());
                ps.setString(5, user.getPassword());
                ps.setBoolean(6, user.getAdmin());
                ps.executeUpdate();

                ps = connection.prepareStatement(userQuery2);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getYearOfGraduation());
                ps.setString(3, user.getDegree());
                ps.setString(4, user.getMajor());
                ps.executeUpdate();

            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void insertEducation(String email, String yearOfGraduation, String degree, String major) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "INSERT INTO Education (Email, YearOfGraduation, Degree, Major)"
                    + "VALUES (?, ?, ?, ?)";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, email);
                ps.setString(2, yearOfGraduation);
                ps.setString(3, degree);
                ps.setString(4, major);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void insertCareer(String email, String employer, String position, String workPhone) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "INSERT INTO Career (Email, Employer, JobPosition, WorkPhone)"
                    + "VALUES (?, ?, ?, ?)";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, email);
                ps.setString(2, employer);
                ps.setString(3, position);
                ps.setString(4, workPhone);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void insertSkills(String email, Boolean publicSpeaking, Boolean management, Boolean leadership, Boolean organizational, Boolean teamwork, Boolean communication, Boolean computer) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "INSERT INTO Skills (Email, PublicSpeaking, Management, Leadership, Organizational, Teamwork, Communication, Computer)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, email);
                ps.setBoolean(2, publicSpeaking);
                ps.setBoolean(3, management);
                ps.setBoolean(4, leadership);
                ps.setBoolean(5, organizational);
                ps.setBoolean(6, teamwork);
                ps.setBoolean(7, communication);
                ps.setBoolean(8, computer);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void updateUserRequest(String userEmail, String friendEmail) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "UPDATE Friends SET Notification = false, Friend = true "
                    + "WHERE Email = ? AND FriendID = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, userEmail);
                ps.setString(2, friendEmail);

                ps.executeUpdate();

                ps = connection.prepareStatement(userQuery);
                ps.setString(1, friendEmail);
                ps.setString(2, userEmail);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void insertUserRequest(String userEmail, String friendEmail) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "INSERT INTO Friends (Email, FriendID, Notification, Friend)"
                    + "VALUES (?, ?, ?, ?)";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, userEmail);
                ps.setString(2, friendEmail);
                ps.setBoolean(3, false);
                ps.setBoolean(4, false);

                ps.executeUpdate();

//                ps = connection.prepareStatement(userQuery);
                ps.setString(1, friendEmail);
                ps.setString(2, userEmail);
                ps.setBoolean(3, true);
                ps.setBoolean(4, false);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void updateBasicInfo(String firstName, String lastName, String lastNameDiploma, String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "UPDATE User"
                    + " SET FirstName = ?, LastName = ?, LastNameDiploma = ?"
                    + " WHERE Email = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, lastNameDiploma);
                ps.setString(4, email);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void updatePersonal(String cellPhone, String description, String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "UPDATE User"
                    + " SET CellPhone = ?, Description = ?"
                    + " WHERE Email = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, cellPhone);
                ps.setString(2, description);
                ps.setString(3, email);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static ArrayList searchResults(String search, String yearOfGraduationFrom, String yearOfGraduationTo, String email) {

        Search searchUser = new Search();
        ArrayList<Search> searchResults = new ArrayList();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT u.FirstName, u.LastName, e.YearofGraduation, e.Degree, e.Major, u.email FROM user u LEFT JOIN education e ON e.Email = u.Email LEFT JOIN career c ON u.Email = c.Email WHERE (u.FirstName = ? OR u.LastName = ? OR u.LastNameDiploma = ? OR e.Major = ? OR e.Degree = ? OR e.YearofGraduation = ?) AND (e.YearofGraduation between ? AND ?) AND u.Email <> ?";
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, search);
                ps.setString(2, search);
                ps.setString(3, search);
                ps.setString(4, search);
                ps.setString(5, search);
                ps.setString(6, search);
                ps.setString(7, search);
                ps.setString(7, yearOfGraduationFrom);
                ps.setString(8, yearOfGraduationTo);
                ps.setString(9, email);
                rs = ps.executeQuery();

                while (rs.next()) {
                    searchUser = new Search(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("YearofGraduation"), rs.getString("Degree"), rs.getString("Major"), rs.getString("Email"));
                    searchResults.add(searchUser);
                }
//                for (Search result : searchResults) {
//                    System.out.println(result.getFirstName() + " " + result.getLastName() + " " + result.getYearOfGraduation() + " " + result.getDegree() + " " + result.getMajor());
//                }
//                return user;
            } catch (SQLException e) {
                System.err.println(e);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return searchResults; //TODO MUST CHANGE NOT NULL
    }

    public static void updateCareer(String employer, String position, String workPhone, String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "UPDATE Career"
                    + " SET Employer = ?, JobPosition = ?, WorkPhone = ?"
                    + " WHERE Email = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, employer);
                ps.setString(2, position);
                ps.setString(3, workPhone);
                ps.setString(4, email);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void updateSkills(Boolean publicSpeaking, Boolean management, Boolean leadership, Boolean organizational, Boolean teamwork, Boolean communication, Boolean computer, String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "UPDATE Skills"
                    + " SET PublicSpeaking = ?, Management = ?, Leadership = ?, Organizational = ?, Teamwork = ?, Communication = ?, Computer = ?"
                    + " WHERE Email = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setBoolean(1, publicSpeaking);
                ps.setBoolean(2, management);
                ps.setBoolean(3, leadership);
                ps.setBoolean(4, organizational);
                ps.setBoolean(5, teamwork);
                ps.setBoolean(6, communication);
                ps.setBoolean(7, computer);
                ps.setString(8, email);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void updatePassword(String newPassword, String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "UPDATE User"
                    + " SET Password = ?"
                    + " WHERE Email = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, newPassword);
                ps.setString(2, email);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static User selectUser(String email) {
        User user = null;
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT *"
                    + " FROM User "
                    + "WHERE Email = ?";
            String query2 = "SELECT *"
                    + " FROM Education "
                    + "WHERE Email = ?";
            String query3 = "SELECT *"
                    + " FROM Career "
                    + "WHERE Email = ?";
            String query4 = "SELECT *"
                    + " FROM Skills "
                    + "WHERE Email = ?";

            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, email);
                rs = ps.executeQuery();

                if (rs.next()) {
                    user = new User();
                    user.setFirstName(rs.getString("FirstName"));
                    user.setLastName(rs.getString("LastName"));
                    user.setLastNameDiploma(rs.getString("LastNameDiploma"));
                    user.setEmail(rs.getString("Email"));
                    user.setCellPhone(rs.getString("CellPhone"));
                    user.setDescription(rs.getString("Description"));
                    user.setAdmin(rs.getBoolean("Admin"));

                    ps = connection.prepareStatement(query2);
                    ps.setString(1, email);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        user.setYearOfGraduation(rs.getString("YearOfGraduation"));
                        user.setDegree(rs.getString("Degree"));
                        user.setMajor(rs.getString("Major"));
                    }

                    ps = connection.prepareStatement(query3);
                    ps.setString(1, email);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        user.setEmployer(rs.getString("Employer"));
                        user.setPosition(rs.getString("JobPosition"));
                        user.setWorkPhone(rs.getString("WorkPhone"));
                    }

                    ps = connection.prepareStatement(query4);
                    ps.setString(1, email);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        user.setPublicSpeaking(rs.getBoolean("PublicSpeaking"));
                        user.setManagement(rs.getBoolean("Management"));
                        user.setLeadership(rs.getBoolean("Leadership"));
                        user.setOrganizational(rs.getBoolean("Organizational"));
                        user.setTeamwork(rs.getBoolean("Teamwork"));
                        user.setCommunication(rs.getBoolean("Communication"));
                        user.setComputer(rs.getBoolean("Computer"));
                    }
                }
            } catch (SQLException e) {
                System.err.println(e);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return user;
    }

    public static Friend selectFriend(String friendEmail) {
        Friend friend = null;
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            String query = "SELECT *"
                    + " FROM User "
                    + "WHERE Email = ?";
            String query3 = "SELECT *"
                    + " FROM Career "
                    + "WHERE Email = ?";
            String query4 = "SELECT *"
                    + " FROM Skills "
                    + "WHERE Email = ?";

            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, friendEmail);
                rs = ps.executeQuery();

                if (rs.next()) {
                    friend = new Friend();
                    friend.setFirstName(rs.getString("FirstName"));
                    friend.setLastName(rs.getString("LastName"));
                    friend.setLastNameDiploma(rs.getString("LastNameDiploma"));
                    friend.setEmail(rs.getString("Email"));
                    friend.setCellPhone(rs.getString("CellPhone"));
                    friend.setDescription(rs.getString("Description"));

//                    ps = connection.prepareStatement(query2);
//                    ps.setString(1, friendEmail);
//                    rs = ps.executeQuery();
//                    if (rs.next()) {
//                        friend.setYearOfGraduation(rs.getString("YearOfGraduation"));
//                        friend.setDegree(rs.getString("Degree"));
//                        friend.setMajor(rs.getString("Major"));
//                    }
                    ps = connection.prepareStatement(query3);
                    ps.setString(1, friendEmail);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        friend.setEmployer(rs.getString("Employer"));
                        friend.setPosition(rs.getString("JobPosition"));
                        friend.setWorkPhone(rs.getString("WorkPhone"));
                    }

                    ps = connection.prepareStatement(query4);
                    ps.setString(1, friendEmail);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        friend.setPublicSpeaking(rs.getBoolean("PublicSpeaking"));
                        friend.setManagement(rs.getBoolean("Management"));
                        friend.setLeadership(rs.getBoolean("Leadership"));
                        friend.setOrganizational(rs.getBoolean("Organizational"));
                        friend.setTeamwork(rs.getBoolean("Teamwork"));
                        friend.setCommunication(rs.getBoolean("Communication"));
                        friend.setComputer(rs.getBoolean("Computer"));
                    }
                }
            } catch (SQLException e) {
                System.err.println(e);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return friend;
    }

    public static ArrayList selectEducation(String email) {

        ArrayList<Education> array = new ArrayList<>();

        Education edu = new Education();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT *"
                    + " FROM Education "
                    + "WHERE Email = ?";

            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, email);
                rs = ps.executeQuery();

                while (rs.next()) {
                    edu = new Education(rs.getString("YearofGraduation"), rs.getString("Degree"), rs.getString("Major"));
                    array.add(edu);
                }
            } catch (SQLException e) {
                System.err.println(e);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return array;
    }

    public static ArrayList selectAllUsers() {

        ArrayList<Admin> array = new ArrayList<>();

        Admin adm = new Admin();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT *"
                    + " FROM User";

            try {
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    adm = new Admin(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getBoolean("Admin"));
                    array.add(adm);
                }
            } catch (SQLException e) {
                System.err.println(e);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return array;
    }

    public static void deleteUserAccount(String email) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "DELETE FROM User"
                    + " WHERE Email = ?";
            String userQuery2
                    = "DELETE FROM Friends"
                    + " WHERE FriendID = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, email);

                ps.executeUpdate();
                
                ps = connection.prepareStatement(userQuery2);
                ps.setString(1, email);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }
    
    public static void declineFriendRequest(String userEmail, String friendEmail) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = null;

            String userQuery
                    = "DELETE FROM Friends "
                    + "WHERE Email = ? AND FriendID = ?";

            try {
                ps = connection.prepareStatement(userQuery);
                ps.setString(1, userEmail);
                ps.setString(2, friendEmail);

                ps.executeUpdate();

                ps = connection.prepareStatement(userQuery);
                ps.setString(1, friendEmail);
                ps.setString(2, userEmail);

                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static ArrayList friendRequestExists(String email) {
        ArrayList<Friend> requestArray = new ArrayList();
        Friend friend = new Friend();
        String query;

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement ps = null;
            ResultSet rs = null;

//                query = "SELECT FriendID FROM Friends "
//                        + "WHERE Email = ? AND Notification = true";
            query = "SELECT f.FriendID ,u.FirstName, u.LastName FROM Friends f Inner JOIN User u ON f.FriendID = u.Email WHERE f.Email = ? AND f.Notification = true";
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, email);
                rs = ps.executeQuery();

                while (rs.next()) {
                    friend = new Friend(rs.getString("FriendID"), rs.getString("FirstName"), rs.getString("LastName"));
                    requestArray.add(friend);
                }

            } catch (SQLException e) {
                System.err.println(e);

            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return requestArray;
    } // end of friendRequestExists

    public static ArrayList friendList(String userEmail) {
        ArrayList<Friend> friendListArray = new ArrayList();
        Friend friendList = new Friend();
        String query;

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement ps = null;
            ResultSet rs = null;

            query = "SELECT f.FriendID, u.FirstName, u.LastName, u.LastNameDiploma, u.CellPhone, u.Description, c.Employer, c.JobPosition, c.WorkPhone, s.PublicSpeaking, s.Management, s.Leadership, s.Organizational, s.Teamwork, s.Computer, s.Communication "
                    + "FROM Friends f "
                    + "Left JOIN User u ON f.FriendID = u.Email "
                    + "Left JOIN Career c ON f.FriendID = c.Email "
                    + "Left JOIN Skills s ON f.FriendID = s.Email "
                    + "WHERE f.Email = ?  AND f.Friend = true ";

            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, userEmail);
                rs = ps.executeQuery();

                while (rs.next()) {
                    friendList = new Friend(rs.getString("FriendID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("LastNameDiploma"), rs.getString("CellPhone"),
                            rs.getString("Description"), rs.getString("Employer"), rs.getString("JobPosition"), rs.getString("WorkPhone"),
                            rs.getBoolean("PublicSpeaking"), rs.getBoolean("Management"),
                            rs.getBoolean("Leadership"), rs.getBoolean("Organizational"),
                            rs.getBoolean("Teamwork"), rs.getBoolean("Computer"),
                            rs.getBoolean("Communication"));
                    friendListArray.add(friendList);
                }

            } catch (SQLException e) {
                System.err.println(e);

            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return friendListArray;
    } // end of FriendExists

    public static boolean accountExists(String email, String actionVar) {
        boolean result = false;
        String query;

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement ps = null;
            ResultSet rs = null;

            if (actionVar.equalsIgnoreCase("currentEmp")) {
                query = "SELECT Email FROM Career "
                        + "WHERE Email = ?";
            } else if (actionVar.equalsIgnoreCase("skillInfo")) {
                query = "SELECT Email FROM Skills "
                        + "WHERE Email = ?";
            } else if (actionVar.equalsIgnoreCase("friendExist")) {
                query = "SELECT Email FROM Friends "
                        + "WHERE Email = ?";
            } else {
                query = "SELECT Email FROM User "
                        + "WHERE Email = ?";
            }
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, email);
                rs = ps.executeQuery();
                result = rs.next();

            } catch (SQLException e) {
                System.err.println(e);
                return false;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return result;
    } // end of accountExist
    
    public static boolean checkRequest(String userEmail, String friendEmail) {
        boolean result = false;
        String query;

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement ps = null;
            ResultSet rs = null;

           
                query = "SELECT * FROM Friends WHERE Email = ? AND FriendID = ?";
            
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, userEmail);
                ps.setString(2, friendEmail);
                rs = ps.executeQuery();
                while(rs.next()){
                    result = true;
                }

            } catch (SQLException e) {
                System.err.println(e);
                return false;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return result;
    } // end of friendRequest

    public static boolean passwordMatch(String password, String email) {
        boolean result = false;

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT Password FROM User "
                    + "WHERE Password = ? AND "
                    + "Email = ?";
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, password);
                ps.setString(2, email);
                rs = ps.executeQuery();
                System.out.println(rs);
                result = rs.next();

            } catch (SQLException e) {
                System.err.println(e);
                return false;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        return result;
    }

}
