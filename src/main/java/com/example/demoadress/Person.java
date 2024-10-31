package com.example.demoadress;

public class Person {
    private String PIP;
    private String PHONE;

    public Person(String PIP, String phone) {
        this.PIP = PIP;
        PHONE = phone;
    }

    public String getPIP() {
        return PIP;
    }

    public void setPIP(String PIP) {
        this.PIP = PIP;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }
}
