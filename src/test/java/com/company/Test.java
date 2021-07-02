package com.company;

import org.junit.Assert;

public class Test extends Main {


    @org.junit.Test
    public void testParsingXml1() {
        String actual = parsingXml("");
        Assert.assertEquals("The file was not found or the file is corrupted", actual);
    }

    @org.junit.Test
    public void testParsingXml2() {
        String actual = parsingXml("cars.xml");
        Assert.assertEquals("16350", actual);
    }

    @org.junit.Test
    public void testParsingXml3() {
        String actual = parsingXml("people.xml");
        Assert.assertEquals("The file was not found or the file is corrupted", actual);
    }
}


