package com.example.wskpoliceapplication;

public class Departament {
        public String id;
        public String address;
        public String name;
        public String boss;
        public String phone;
        public String email;
        public String description;

        @Override
    public String toString(){
            return name;
        }
}
