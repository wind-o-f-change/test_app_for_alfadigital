package com.alfadigital.testapp.service;

import com.alfadigital.testapp.data.ItemRepo;
import com.alfadigital.testapp.dto.TestDTO;
import com.alfadigital.testapp.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepo repo;

    public ItemService(ItemRepo repo) {
        this.repo = repo;
    }
//    private List<Item> savedItems = new ArrayList<>();

//    Обработку и логгирование ошибок не делал т.к этого нет в задании

    public void saveSours(Item item) {
//        savedItems.add(item);
//        repo.saveAndFlush(item);
        if (item.getBox() == null) repo.saveWithId(item.getId());
        else repo.saveWithId(item.getId(), item.getBox().getId());
    }


    public List<Item> getSavedItems() {
        return repo.findAll();
//        return savedItems;
    }

    public List<Integer> getIdListByColorAndBookId(TestDTO dto) {
        return null;
    }

//    public Object saveSource(SourceDTO dto) {
//        String url = dto.getUrl();
//
////        StorageDTO store = readSource(url);
//        Object store = readSource(url);
//
//        System.out.println(store);
//
//        return store;
//    }


}
