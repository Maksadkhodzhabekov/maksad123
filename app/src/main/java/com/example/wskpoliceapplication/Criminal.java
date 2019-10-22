package com.example.wskpoliceapplication;

public class Criminal {
    public String id;
    public String category;
    public String client;
    public String number;
    public String description;
    public String create_date;
    public String detective;

    @Override
    public String toString(){
        return create_date + "-" + number;
    }
}
