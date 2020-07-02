package com.example.Database;

public class UserData {
    private String email;
    private String googleID;
    boolean loggedIN;
    private String name;
    private String photo;
    private String iat;

    public UserData(){
        super();
    }

    public UserData(String email, String googleID,boolean loggedIN, String name, String photo,String iat) {
        this.email = email;
        this.googleID = googleID;
        this.name = name;
        this.photo = photo;
        this.loggedIN=loggedIN;
        this.iat = iat;
    }

    @Override
    public String toString() {
        return email+"\n"+googleID+"\n"+name+"\n"+photo+"\n"+iat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleID() {
        return googleID;
    }

    public void setGoogleID(String googleID) {
        this.googleID = googleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }
}
