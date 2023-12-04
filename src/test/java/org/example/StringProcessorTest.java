package org.example;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class StringProcessorTest extends TestCase {

    public void testRepeatString() {
        StringProcessor stringProcessor =  new StringProcessor();
        String s = "Человек";
        int count = 2;
        String actual = stringProcessor.RepeatString(s, count);
        String expected = "ЧеловекЧеловек";
        assertEquals(expected, actual);
    }

    public void testCountSubString() {
        StringProcessor stringProcessor = new StringProcessor();
        String haystack = "ЧеловекЧел";
        String needle = "Чел";
        int actual = stringProcessor.CountSubString(haystack, needle);
        int expected = 2;
        assertEquals(expected, actual);
    }

    public void testReplaceNumberToWordIntoString() {
        StringProcessor s = new StringProcessor();
        String refStr = "2He1123l2o";
        String actual = s.ReplaceNumberToWordIntoString(refStr);
        String expected = "ДваHeОдинОдинДваТриlДваo";
        assertEquals(expected, actual);
    }

    public void testRemoveEverySecondChar() {
        StringProcessor s = new StringProcessor();
        StringBuilder refStr = new StringBuilder("Мама_мыла_раму!");
        s.RemoveEverySecondChar(refStr);
        String actual = refStr.toString();
        String expected = "Мм_ыарм!";
        assertEquals(expected, actual);
    }
}