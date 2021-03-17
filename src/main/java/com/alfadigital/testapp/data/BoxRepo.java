package com.alfadigital.testapp.data;

import com.alfadigital.testapp.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepo extends JpaRepository<Box, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into BOX (id) values (:id)")
    void saveWithId(@Param("id") Integer id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into BOX (id, contained_in) values (:id, :box)")
    void saveWithId(@Param("id") Integer id, @Param("box") Integer boxId);
}
