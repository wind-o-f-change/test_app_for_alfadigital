package com.alfadigital.testapp.service;

import com.alfadigital.testapp.dao.ItemDao;
import com.alfadigital.testapp.dto.TestDTO;
import com.alfadigital.testapp.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemService {
    private final ItemDao repo;

    public ItemService(ItemDao repo) {
        this.repo = repo;
    }

    public void saveSource(Item item) {
        int contained_in = item.getContained_in();
        boolean isContained_in = contained_in > 0;
        boolean isColor = Optional.ofNullable(item.getColor()).isPresent();

        if (isContained_in && isColor) repo.saveWithAllParam(item.getId(), item.getContained_in(), item.getColor());
        else
            if (!isContained_in && isColor) repo.saveWithIdAndColor(item.getId(), item.getColor());
        else
            if (isContained_in && !isColor) repo.saveWithIdAndBoxId(item.getId(), item.getContained_in());
        else
            if (!isContained_in && !isColor) repo.saveWithId(item.getId());
    }

    public List<Integer> getIdListByColorAndBookId(TestDTO dto) {
        return repo.getByBoxIdAndColor(dto.getBox_id(), dto.getColor());
    }

}
