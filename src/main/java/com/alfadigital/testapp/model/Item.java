package com.alfadigital.testapp.model;

public class Item {
    private int id;
    private int contained_in;
    private String color;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContained_in() {
        return contained_in;
    }

    public void setContained_in(Integer contained_in) {
        this.contained_in = contained_in;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", contained_in=" + contained_in +
                ", color='" + color + '\'' +
                '}';
    }
}