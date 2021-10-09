package com.example.vtb_finances.model;

import java.util.List;

public class UserInfo {

    private String id;
    private String name;
    private long valuation;
    private int level;
    private String email;
    private int age;
    private List<String> stocks;

    public UserInfo() {
    }

    public UserInfo(String id, String name, long valuation, int level, String email, int age, List<String> stocks) {
        this.id = id;
        this.name = name;
        this.valuation = valuation;
        this.level = level;
        this.email = email;
        this.age = age;
        this.stocks = stocks;
    }

    public List<String> getStocks() {
        return stocks;
    }

    public void setStocks(List<String> stocks) {
        this.stocks = stocks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValuation() {
        return valuation;
    }

    public void setValuation(long valuation) {
        this.valuation = valuation;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", valuation=" + valuation +
                ", level=" + level +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}