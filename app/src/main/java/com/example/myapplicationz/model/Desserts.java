package com.example.myapplicationz.model;

public class Desserts {

    private int id;
    private String dessertName;

    public Desserts(int id, String dessertName) {
        this.id = id;
        this.dessertName = dessertName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }
}
