package com.alfadigital.testapp.parser;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


@Component
public class Parser {
    private final ParserHandler handler;

    public Parser(ParserHandler handler) {
        this.handler = handler;
    }

    //    Обработку и логгирование ошибок не делал т.к этого нет в задании

    public void parse(String path) {

        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(path, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
