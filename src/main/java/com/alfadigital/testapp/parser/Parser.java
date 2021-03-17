package com.alfadigital.testapp.parser;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


@Component
public class Parser {
//    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
//        parse("input.xml");
//    }

    //    Обработку и логгирование ошибок не делал т.к этого нет в задании

    public void parse(String path) {
//        XMLInputFactory factory = XMLInputFactory.newInstance();
//        XMLStreamReader xmlReader = null;
//        try {
//           xmlReader = factory.createXMLStreamReader(new FileInputStream(path));
//
//           while (xmlReader.hasNext()) {
////               System.out.println(xmlReader.getAttributeCount());
//               int event = xmlReader.next();
//               if (event == XMLStreamConstants.START_ELEMENT) {
//                   System.out.println(xmlReader.getName() + " " + xmlReader.getPIData());
//               }
//           }
//        }finally {
//            xmlReader.close();
//        }

        SAXParser parser = null;
        try {
            parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(path, new ParserHandler());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
//        return S;
//        Storage
    }


}
