package com.alfadigital.testapp.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "BOX")
public class Box implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contained_in", referencedColumnName = "id")
    private Box box;


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
        return "Box{" +
                "id=" + id +
                ", box=" + box +
                '}';
    }
}