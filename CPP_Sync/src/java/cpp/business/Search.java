/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.business;

import java.io.Serializable;

/**
 *
 * @author achan
 */
public class Search implements Serializable {

    private String firstName;
    private String lastName;
    private String yearOfGraduation;
    private String degree;
    private String major;
    private String email;

    public Search() {
        firstName = "";
        lastName = "";
        yearOfGraduation = "";
        degree = "";
        major = "";
        email = "";
    }

    public Search(String firstName, String lastName, String yearOfGraduation, String degree, String major, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfGraduation = yearOfGraduation;
        this.degree = degree;
        this.major = major;
        this.email = email;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
