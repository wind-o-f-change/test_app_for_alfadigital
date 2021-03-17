package com.alfadigital.testapp.controller;

import com.alfadigital.testapp.dto.SourceDTO;
import com.alfadigital.testapp.dto.TestDTO;
import com.alfadigital.testapp.parser.Parser;
import com.alfadigital.testapp.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public void getSource(@RequestBody SourceDTO dto) {
        new Parser().parse(dto.getUrl());
    }

    @PostMapping("test HTTP/1.1")
    public ResponseEntity<List<Integer>> getIdListByColorAndBookId(TestDTO dto) {
        return null;
    }
}
