/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.business;

/**
 *
 * @author Albert Chan
 */
import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String lastNameDiploma;
    private String email;
    private String password;
    private String yearOfGraduation;
    private String degree;
    private String major;
    private String cellPhone;
    private String description;
    private String employer;
    private String position;
    private String workPhone;
    
    private boolean admin;
    private boolean publicSpeaking;
    private boolean management;
    private boolean leadership;
    private boolean organizational;
    private boolean teamwork;
    private boolean communication;
    private boolean computer;
    
    private String friendID; 
    private boolean notification;
    private boolean friend;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        password = "";
        yearOfGraduation = "";
        degree = "";
        major = "";
        cellPhone = "";
        description = "";
        employer = "";
        position = "";
        workPhone = "";
        friendID = "";
        admin = false;
        publicSpeaking = false;
        management = false;
        leadership = false;
        organizational = false;
        teamwork = false;
        communication = false;
        computer = false;
        notification = false;
        friend = false;
    }
    
    public User (String friendID, boolean notification, boolean friend){
        this.friendID = friendID; 
        this.notification = notification; 
        this.friend = friend; 
    }
    
    public User (String firstName, String lastName, String yearOfGraduation, String degree, String major){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfGraduation = yearOfGraduation;
        this.degree = degree;
        this.major = major;
    }

    public User (String email, String firstName, String lastName, String lastNameDiploma, String password, String cellPhone, String yearOfGraduation, String degree, String major, Boolean admin) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastNameDiploma = lastNameDiploma;
        this.password = password;
        this.yearOfGraduation = yearOfGraduation;
        this.degree = degree;
        this.major = major;
        this.cellPhone = cellPhone;
        this.admin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameDiploma() {
        return lastNameDiploma;
    }

    public void setLastNameDiploma(String lastNameDiploma) {
        this.lastNameDiploma = lastNameDiploma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(String yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getFriendID() {
        return position;
    }

    public void setFriendID(String friendID) {
        this.friendID = friendID;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    
    public Boolean getAdmin() {
        return admin;
    }
    
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    public boolean getPublicSpeaking() {
        return publicSpeaking;
    }
    
    public void setPublicSpeaking(Boolean publicSpeaking) {
        this.publicSpeaking = publicSpeaking;
    }
    
    public boolean getManagement() {
        return management;
    }
    
    public void setManagement(Boolean management) {
        this.management = management;
    }
    
    public boolean getLeadership() {
        return leadership;
    }
    
    public void setLeadership(Boolean leadership) {
        this.leadership = leadership;
    }
    
    public boolean getOrganizational() {
        return organizational;
    }
    
    public void setOrganizational(Boolean organizational) {
        this.organizational = organizational;
    }
    
    public boolean getTeamwork() {
        return teamwork;
    }
    
    public void setTeamwork(Boolean teamwork) {
        this.teamwork = teamwork;
    }
    
    public boolean getCommunication() {
        return communication;
    }
    
    public void setCommunication(Boolean communication) {
        this.communication = communication;
    }
    
    public boolean getComputer() {
        return computer;
    }
    
    public void setComputer(Boolean computer) {
        this.computer = computer;
    }
    
    public boolean getNotification() {
        return notification;
    }
    
    public void setNotification(Boolean notification) {
        this.notification = notification;
    }
    
    public boolean getFriend() {
        return friend;
    }
    
    public void setFriend(Boolean friend) {
        this.friend = friend;
    }
}
