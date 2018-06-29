package com.example.shauryamanocha.cosmicraymerged;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public String name;
    public String id;
    public int amount;
    public ArrayList<customLatLng> hits = new ArrayList<>();
    public HashMap<String,Object> school;
    public String schoolName ="noSchool";
    public User(){
        this.school = new HashMap<>();
        this.school.put("name","noSchool");
    }
    public User(String name, String id){
        this.name = name;
        this.id = id;
        amount = 0;
        school = new HashMap<>();
    }
    public User(String name,String school, String id){
        this.name = name;
        this.id = id;
        this.amount = 0;
        this.school = new HashMap<>();
        this.school.put("name",school);
        schoolName = school;
    }
    public User(String name,String school, String id, int amount){
        this.name = name;
        this.id = id;
        this.amount = amount;
        this.school = new HashMap<>();
        this.school.put("name",school);
        schoolName = school;
    }
    public User(String name,String school, String id, ArrayList<customLatLng> hits){
        this.name = name;
        this.id = id;
        amount = 0;
        this.hits = hits;
        this.school = new HashMap<>();
        this.school.put("name",school);
        schoolName = school;
    }
    public User(String name,String school, String id, int amount, ArrayList<customLatLng> hits){
        this.name = name;
        this.id = id;
        this.amount = amount;
        this.hits = hits;
        this.school.remove("name");
        this.school.put("name",school);
        schoolName = school;
    }
}
