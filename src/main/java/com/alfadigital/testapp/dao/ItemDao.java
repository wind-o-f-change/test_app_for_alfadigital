package com.alfadigital.testapp.dao;


import java.util.List;

public interface ItemDao {
    void saveWithId(int id);
    void saveWithIdAndBoxId(int id, int box_id);
    void saveWithIdAndColor(int id, String color);
    void saveWithAllParam(int id, int box_id, String color);
    List<Integer> getByBoxIdAndColor(int box_id, String color);
}
