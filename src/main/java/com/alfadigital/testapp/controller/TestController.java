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
public class TestController {
    private final ItemService service;
    private final Parser parser;

    public TestController(ItemService service, Parser parser) {
        this.service = service;
        this.parser = parser;
    }

    @PostMapping
    public void getSource(@RequestBody SourceDTO dto) {
        parser.parse(dto.getPath());
    }

    @PostMapping("test HTTP/1.1")
    public ResponseEntity<List<Integer>> getIdListByColorAndBookId(TestDTO dto) {
        return null;
    }
}
