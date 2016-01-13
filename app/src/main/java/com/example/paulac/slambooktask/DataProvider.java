package com.example.paulac.slambooktask;

/**
 * Created by paulac on 11/25/15.
 */
public class DataProvider {

    private String getsetfname, getsetmi, getsetlname, getsetaddress, getsetgender, getsetmonth, getsetday, getsetyear, getsetemail;

    public String getMi() {
        return getsetmi;
    }

    public void setMi(String mi) {this.getsetmi = mi;
    }

    public String getFname() {
        return getsetfname;
    }

    public void setFname(String fname) {this.getsetfname = fname;
    }

    public String getLname() {
        return getsetlname;
    }

    public void setLname(String lname) {
        this.getsetlname = lname;
    }

    public String getAddress() {
        return getsetaddress;
    }

    public void setAddress(String address) {
        this.getsetaddress = address;
    }

    public String getMonth() {
        return getsetmonth;
    }

    public void setMonth(String month) {
        this.getsetmonth = month;
    }

    public String getGender() {
        return getsetgender;
    }

    public void setGender(String gender) {
        this.getsetgender = gender;
    }

    public String getDay() {
        return getsetday;
    }

    public void setDay(String day) {
        this.getsetday = day;
    }

    public String getYear() {
        return getsetyear;
    }

    public void setYear(String year) {
        this.getsetyear = year;
    }

    public String getEmail() {
        return getsetemail;
    }

    public void setEmail(String email) {
        this.getsetemail = email;
    }

    public DataProvider(String fname, String mi, String lname, String address, String gender,
                        String month, String day, String year, String email){


        this.getsetfname = fname;
        this.getsetmi = mi;
        this.getsetlname = lname;
        this.getsetaddress = address;
        this.getsetgender = gender;
        this.getsetmonth = month;
        this.getsetday = day;
        this.getsetyear = year;
        this.getsetemail = email;


    }


}
