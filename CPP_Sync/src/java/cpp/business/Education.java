/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.business;

/**
 *
 * @author achan
 */
import java.io.Serializable;

public class Education implements Serializable {

    private String yearOfGraduation;
    private String degree;
    private String major;
    
    public Education() {
        yearOfGraduation = "";
        degree = "";
        major = "";
    }
    
    public Education(String yearOfGraduation, String degree, String major) {
        this.yearOfGraduation = yearOfGraduation;
        this.degree = degree;
        this.major = major;
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

}
