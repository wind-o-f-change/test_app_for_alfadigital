package com.alfadigital.testapp.service;

import com.alfadigital.testapp.data.BoxRepo;
import com.alfadigital.testapp.model.Box;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService {
    private final BoxRepo repo;


    public BoxService(BoxRepo repo) {
        this.repo = repo;
    }

    public void saveSource(Box box) {
        if (box.getBox() == null) repo.saveWithId(box.getId());
        else repo.saveWithId(box.getId(), box.getBox().getId());
    }

    public List<Box> getSavedBoxes() {
        return repo.findAll();
    }
}
