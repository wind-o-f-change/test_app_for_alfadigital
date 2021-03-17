package com.alfadigital.testapp.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ITEM")
public class Item implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contained_in", referencedColumnName = "id")
    private Box box;
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

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", box=" + box +
                ", color='" + color + '\'' +
                '}';
    }
}