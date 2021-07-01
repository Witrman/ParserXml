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
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            Set<String> setOfNames = new HashSet<>();
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {

                    if (qName.equalsIgnoreCase("modification")) {
                            setOfNames.add(attributes.getValue("name"));
                    }
                }
            };

            saxParser.parse(args[0], handler);
            System.out.println(setOfNames.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


