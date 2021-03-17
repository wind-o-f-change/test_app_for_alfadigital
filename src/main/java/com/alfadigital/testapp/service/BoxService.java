package com.alfadigital.testapp.service;

import com.alfadigital.testapp.dao.BoxDao;
import com.alfadigital.testapp.model.Box;
import org.springframework.stereotype.Service;


@Service
public class BoxService {
    private final BoxDao repo;


    public BoxService(BoxDao repo) {
        this.repo = repo;
    }

    public void saveSource(Box box) {
        boolean isContained_in = box.getContained_in() > 0;
        if (!isContained_in) repo.saveWithId(box.getId());
        else repo.saveWithAllParam(box.getId(), box.getContained_in());
    }
}
