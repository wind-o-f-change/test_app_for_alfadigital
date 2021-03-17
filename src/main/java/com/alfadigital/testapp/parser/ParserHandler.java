package com.alfadigital.testapp.parser;

import com.alfadigital.testapp.model.Box;
import com.alfadigital.testapp.model.Item;
import com.alfadigital.testapp.service.BoxService;
import com.alfadigital.testapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class ParserHandler extends DefaultHandler {
    private ItemService itemService;
    private BoxService boxService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setBoxService(BoxService boxService) {
        this.boxService = boxService;
    }

    private final String boxName = "Box";
    private final String itemName = "Item";

    private List<Box> boxes = new ArrayList<>();


    public ParserHandler() {
    }

    @Override
    public void endDocument()  {
        System.out.println("\n");
        if (boxes.size()>0) boxes.forEach(System.out::println);
        else System.out.println("Чтение успешно");
        System.out.println("\n");
        boxService.getSavedBoxes().forEach(System.out::println);
        System.out.println("\n");
        itemService.getSavedItems().forEach(System.out::println);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        int boxSize = boxes.size();


        if (boxSize > 0) {
            Box parentBox = boxes.get(boxSize - 1);

            if (qName.equals(boxName)) {
                Box box = boxCreate(attributes);
                box.setBox(parentBox);
                saveBox(box);

            } else if (qName.equals(itemName)) {
                Item item = itemCreate(attributes);
                item.setBox(parentBox);
                itemService.saveSours(item);
            }

        } else {
            if (qName.equals(boxName)) {
                Box box = boxCreate(attributes);
                saveBox(box);

            } else if (qName.equals(itemName)) {
                Item item = itemCreate(attributes);
                itemService.saveSours(item);
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
//            if (boxSize > 0)
                boxes.remove(boxSize - 1);
        }
        System.out.println("end " + qName);
    }
}
