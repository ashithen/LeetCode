package org.example.playing;

import java.util.HashMap;
import java.util.Map;

public class TestInteger {

    public static void main(String[] args) {
        Integer test = 10;
        test++;
        Map<Integer,Integer> yy = new HashMap<>();
        yy.put(1,test);
        TestIntBehav testIntBehav = new TestIntBehav();
        testIntBehav.testInt++;
        System.out.println(testIntBehav.testInt);
    }
}
