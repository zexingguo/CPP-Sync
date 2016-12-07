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
public class Admin implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private Boolean admin;

    public Admin() {
        firstName = "";
        lastName = "";
        email = "";
        admin = false;
    }

    public Admin(String firstName, String lastName, String email, Boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
