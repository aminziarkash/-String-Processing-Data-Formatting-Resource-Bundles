package com.az.dev.ocp.chapter8.tests;

import java.io.File;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestingApp {
    
    public static void main(String[] args) {

        TestingApp app = new TestingApp();
        
        app.patternMatcherTest();
        
        app.patternMatcherTest1();
        
        app.stringsSplitTest();
        
        app.stringBuilderTest();
        
        app.stringAndStringBuilderTest();
        
        app.stringFormattingTest();
        
        app.tokenizeWithScanner();
    }
    
    private void tokenizeWithScanner() {
        String input = "1 2 a 3 45 6";
        Scanner scanner = new Scanner(input);
        Scanner scanner2 = new Scanner("");
        if (scanner.hasNextBoolean()){
            System.out.println(scanner.next());
        }
        int x = 0;
        do {
            x = scanner.nextInt();
            System.out.print(x + " ");
        } while (x != 0);
        scanner.close();
        
        addSeparator();
    }
    
    // wrong    : 2334
    // correcrt : 01234456
    private void patternMatcherTest() {   
        String patternString = "\\d*";
        String input = "ab34ef";
        Pattern p = Pattern.compile(patternString);
        Matcher m = p.matcher(input);
        boolean b = false;
        while (b = m.find()) {
            System.out.print(m.start() + m.group());
        }
        System.out.println("");
        addSeparator();
    }
    
    private void patternMatcherTest1() {
        String patternString = "\\B";
        String input = "^23 *$76 bc";
        Pattern p = Pattern.compile(patternString);
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.print(m.start() + " ");
        }
        System.out.println("");
        addSeparator();
    }
    
    private void stringsSplitTest() {
       String in = "1 a2 b 3 c4d 5e";
       String[] chunks = in.split("\\d"); 
       
       System.out.println("count : " + chunks.length);
       for (String s : chunks) {
           System.out.println(">" + s + "< ");
       }
       addSeparator();
    }
    
    private void stringBuilderTest() {
        StringBuilder sb = new StringBuilder(8);
        System.out.print(sb.length() + " " + sb + " ");
        sb.insert(0, "abcdef");
        sb.append("789");
        System.out.println(sb.length() + " " + sb);
        addSeparator();
    }
    
    private void stringAndStringBuilderTest() {
        String s1 = "abc";
        String s2 = s1;
        s1 += "d";
        System.out.println(s1 + " " + s2 + " " + (s1 == s2));
        
        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = sb1;
        sb1.append("d");
        System.out.println(sb1 + " " + sb2 + " " + (sb1 == sb2));
        
        addSeparator();
    }
    
    private void stringFormattingTest() {
        String s = "987.123456";
        double d = 987.123456d;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(d) + " ");
        try {
            System.out.println(nf.parse(s));
        } catch(Exception e) {
            System.out.println("Got Exception");
        }
    }

    private void addSeparator() {
        System.out.println("-------------------------------------------------------------------------------------------------");
    }
    
}
