package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser(); // для чтения xlm документа используем SAXParser
            Set<String> setOfNames = new HashSet<>(); // используем для подсчета уникальных значений
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {

                    if (qName.equalsIgnoreCase("modification")) {    // при первом попадании на тэг modification
                            setOfNames.add(attributes.getValue("name")); // значение атрибута name добавляется в HashSet
                    }                                                           // здесь могут находится только уникальные значения
                }
            };

            saxParser.parse(args[0], handler);
            System.out.println(setOfNames.size());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input file name: \"java -jar ParserXml.jar cars.xml\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


