package com.alfadigital.testapp.data;

import com.alfadigital.testapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {


    @Modifying
    @Query(nativeQuery = true, value = "insert into ITEM (id) values (:id)")
    void saveWithId(@Param("id") Integer id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into ITEM (id, contained_in) values (:id, :box)")
    void saveWithId(@Param("id") Integer id, @Param("box") Integer boxId);
}
