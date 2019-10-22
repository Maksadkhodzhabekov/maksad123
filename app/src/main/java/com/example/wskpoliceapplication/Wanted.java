package com.example.wskpoliceapplication;

public class Wanted {
    public String id;
    public String status;
    public String first_name;
    public String last_name;
    public String last_location;
    public String nicknames;
    public String description;
    public String photo;
    public String middlename;

    @Override
    public String toString(){ return first_name + " " + last_name; }
}
