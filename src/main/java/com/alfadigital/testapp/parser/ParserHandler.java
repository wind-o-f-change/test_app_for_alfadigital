package com.alfadigital.testapp.parser;

import com.alfadigital.testapp.model.Box;
import com.alfadigital.testapp.model.Item;
import com.alfadigital.testapp.service.BoxService;
import com.alfadigital.testapp.service.ItemService;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


@Component
public class ParserHandler extends DefaultHandler {
    private final ItemService itemService;
    private final BoxService boxService;

    private final String boxName = "Box";
    private final String itemName = "Item";

    private List<Box> boxes = new ArrayList<>();


    public ParserHandler(ItemService itemService, BoxService boxService) {
        this.itemService = itemService;
        this.boxService = boxService;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        int boxSize = boxes.size();


        if (boxSize > 0) {
            Box parentBox = boxes.get(boxSize - 1);

            if (qName.equals(boxName)) {
                Box box = boxCreate(attributes);
                box.setContained_in(parentBox.getId());
                saveBox(box);

            } else if (qName.equals(itemName)) {
                Item item = itemCreate(attributes);
                item.setContained_in(parentBox.getId());
                itemService.saveSource(item);
            }

        } else {
            if (qName.equals(boxName)) {
                Box box = boxCreate(attributes);
                saveBox(box);

            } else if (qName.equals(itemName)) {
                Item item = itemCreate(attributes);
                itemService.saveSource(item);
            }
        }
    }

    private void saveBox(Box box) {
        boxes.add(box);
        boxService.saveSource(box);
    }

    private Item itemCreate(Attributes attributes) {
        String id = attributes.getValue("id");
        String color = attributes.getValue("color");

        Item item = new Item();
        if (id != null) item.setId(Integer.parseInt(id));
        if (color != null) item.setColor(color);

        return item;
    }

    private Box boxCreate(Attributes attributes) {
        String id = attributes.getValue("id");

        Box box = new Box();
        if (id != null) box.setId(Integer.parseInt(id));

        return box;
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(boxName)){
            int boxSize = boxes.size();
                boxes.remove(boxSize - 1);
        }
    }
}
