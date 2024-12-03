package com.example.demoadress.data;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty PIP = new SimpleStringProperty("");
    private SimpleStringProperty PHONE = new SimpleStringProperty("");

    public Person(String PIP, String PHONE) {
        this.PIP = new SimpleStringProperty(PIP);
        this.PHONE = new SimpleStringProperty(PHONE);
    }

    public Person() {
    }

    public String getPIP() {
        return PIP.get();
    }

    public SimpleStringProperty PIPProperty() {
        return PIP;
    }

    public void setPIP(String PIP) {
        this.PIP.set(PIP);
    }

    public String getPHONE() {
        return PHONE.get();
    }

    public SimpleStringProperty PHONEProperty() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE.set(PHONE);
    }
}
