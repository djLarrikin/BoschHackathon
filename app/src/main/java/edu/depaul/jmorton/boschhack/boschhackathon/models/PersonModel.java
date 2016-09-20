package edu.depaul.jmorton.boschhack.boschhackathon.models;

import java.util.Date;

/**
 * Created by Dina on 9/20/16.
 */

public class PersonModel {
    private String firstName;
    private String lastName;
    private Date birthdate;
    private char bloodType;
    private String gender;
    private String extraInfo;

    PersonModel emergencyContact;


    public void PersonModel(String firstName, String lastName, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public String getNamef() {
        return firstName;
    }

    public String getNamel() {
        return lastName;
    }

    public Date getBirthdat() {
        return birthdate;
    }

    public char getBloodType() {
        return bloodType;
    }

    public String getGender() {
        return gender;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setBloodType(char bloodType) {
        this.bloodType = bloodType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void setEmergencyContact(PersonModel emergencyContact) {
        this.emergencyContact = emergencyContact;
    }


}
