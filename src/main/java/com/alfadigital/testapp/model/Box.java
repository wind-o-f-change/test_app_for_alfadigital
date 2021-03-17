package com.alfadigital.testapp.model;

public class Box {
    private int id;
    private int contained_in;


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
        return "Box{" +
                "id=" + id +
                ", contained_in=" + contained_in +
                '}';
    }
}