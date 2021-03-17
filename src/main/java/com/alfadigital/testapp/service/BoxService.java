package com.alfadigital.testapp.service;

import com.alfadigital.testapp.data.BoxRepo;
import com.alfadigital.testapp.model.Box;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoxService {
    private final BoxRepo repo;
//    private List<Box> savedBoxes = new ArrayList<>();


    public BoxService(BoxRepo repo) {
        this.repo = repo;
    }

    public void saveSource(Box box) {
//        System.out.println(box);
//        savedBoxes.add(box);
        if (box.getBox() == null) repo.saveWithId(box.getId());
        else repo.saveWithId(box.getId(), box.getBox().getId());
    }

    public List<Box> getSavedBoxes() {
        return repo.findAll();
//        return savedBoxes;
    }
}
