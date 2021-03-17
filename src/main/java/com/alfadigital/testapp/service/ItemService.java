package com.alfadigital.testapp.service;

import com.alfadigital.testapp.data.ItemRepo;
import com.alfadigital.testapp.dto.TestDTO;
import com.alfadigital.testapp.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepo repo;

    public ItemService(ItemRepo repo) {
        this.repo = repo;
    }


    public void saveSours(Item item) {
        if (item.getBox() == null) repo.saveWithId(item.getId());
        else repo.saveWithId(item.getId(), item.getBox().getId());
    }


    public List<Item> getSavedItems() {
        return repo.findAll();
    }

    public List<Integer> getIdListByColorAndBookId(TestDTO dto) {
        return null;
    }

}
