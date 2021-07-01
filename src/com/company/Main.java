package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            HashMap<String, Integer> mapOfNames = new HashMap<>();
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {

                    if (qName.equalsIgnoreCase("modification")) {
                        String name = attributes.getValue("name");
                        if(!mapOfNames.containsKey(name)){
                            mapOfNames.put(name,1);
                        }else{
                            mapOfNames.put(name,mapOfNames.get(name)+1);
                        }
                    }
                }
            };
/*
            if(args[0].equals("")) {
                System.out.println("Введите название XML файла после команды.");
                return;
            }*/
            String path = "cars.xml";
            saxParser.parse(path, handler);
            for (Map.Entry<String, Integer> pair : mapOfNames.entrySet())
            {
                String key = pair.getKey();
                int value = pair.getValue();
                System.out.println(key + " : " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


