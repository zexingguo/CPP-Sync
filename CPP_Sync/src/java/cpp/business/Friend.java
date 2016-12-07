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

public class Friend implements Serializable {

    private String firstName;
    private String lastName;
    private String lastNameDiploma;
    private String email;
    private String yearOfGraduation;
    private String degree;
    private String major;
    private String cellPhone;
    private String description;
    private String employer;
    private String position;
    private String workPhone;
    
    private boolean publicSpeaking;
    private boolean management;
    private boolean leadership;
    private boolean organizational;
    private boolean teamwork;
    private boolean communication;
    private boolean computer;

    public Friend() {
        firstName = "";
        lastName = "";
        email = "";
        yearOfGraduation = "";
        degree = "";
        major = "";
        cellPhone = "";
        description = "";
        employer = "";
        position = "";
        workPhone = "";
        publicSpeaking = false;
        management = false;
        leadership = false;
        organizational = false;
        teamwork = false;
        communication = false;
        computer = false;
    }
    public Friend (String email, String firstName, String lastName){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Friend (String email, String firstName, String lastName, String lastNameDiploma, String cellPhone,
                   String description, String employer, String position, String workPhone, 
                   Boolean publicSpeaking, Boolean management, 
                   Boolean leadership, Boolean organizational,
                   Boolean teamwork, Boolean computer, 
                   Boolean communication) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastNameDiploma = lastNameDiploma;
        this.cellPhone = cellPhone;
        this.description = description;
        this.employer = employer;
        this.position = position; 
        this.workPhone = workPhone; 
        this.publicSpeaking = publicSpeaking;
        this.management = management; 
        this.leadership = leadership; 
        this.organizational = organizational;
        this.teamwork = teamwork;
        this.communication = communication; 
        this.computer = computer; 
    }
    
     public Friend (String email, String firstName, String lastName, String yearOfGraduation, String degree, String major){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfGraduation = yearOfGraduation;
        this.degree = degree;
        this.major = major;
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

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
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
}
