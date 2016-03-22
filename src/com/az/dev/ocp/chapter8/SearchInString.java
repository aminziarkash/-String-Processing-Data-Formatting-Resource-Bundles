package com.az.dev.ocp.chapter8;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchInString {
    
    private Scanner userInput = new Scanner(System.in);
    
    public static void main(final String[] args) {
        
        final SearchInString app = new SearchInString();
        
        app.searchStringsUsingRegex();
        
        
        app.tokenizeUsingScanner();
        
        app.tokenizeUsingStringTokenizer();
    }
    
    // SEARCHING USING QUANTIFIERS
    // Hello World 0X8D Hello 0X2B
    // 12 0x 0x12 0Xf 0xg
    // Search for HEXA DECIMAL in a piece of text : 0[Xx][0-9a-fA-F]

    // proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java
    // proj1([^,])*

    // DOT QUANTIFIER
    // ab ac abc a c db
    // a.c

    // GREEDY QUANTIFIER
    // yyxxxyxx
    // .*xx
    // with reluctant qualifier : .*?xx

    // SEARCH FOR A PHONE NUMBER
    // \d\d\d([-\s])?\d\d\d\d\d\d\d
            
    private void searchStringsUsingRegex() {

        System.out.println("SEARCH STRINGS USING DIFFERENT PATTERNS\nPress 'Enter' to conitnue or 'q' to quit\n");

        while (userInput.hasNextLine()) {
            if (userInput.nextLine().equals("q")) {
                break;
            }

            System.out.print("Text to search through\t\t:\t");
            final String enteredText = userInput.nextLine();
            System.out.print("Enter pattern\t\t\t:\t");
            final String patternString = userInput.nextLine();

            final Pattern pattern = Pattern.compile(patternString);
            final Matcher matcher = pattern.matcher(enteredText);
            System.out.println("Source\t\t\t\t:\t" + enteredText);
            System.out.println("Expression\t\t\t:\t" + matcher.pattern());
            System.out.print("Found at position + value\t:\t");

            while (matcher.find()) {
                System.out.print(matcher.start() + " " + matcher.group() + " ");
            }
            System.out.println("");
            addSepparator();
        }
    }
    
    private void tokenizeUsingScanner() {
        System.out.println("SEARCHING FOR '\\d' (DIGITS) USING SCANNERS findInLine() METHOD\n");
        System.out.print("input\t\t:\t");

        try {
            String token;
            final String pattern = "\\d";
            token = userInput.findInLine(pattern);
        while (token != null){
                System.out.println("Found\t:\t" + token);
                token = userInput.findInLine(pattern);
        }
        } catch (Exception e) {
            System.out.println("Exception caught while scanning");
        } finally {
            userInput.close();
        }
        addSepparator();
    }
    
    private void tokenizeUsingStringTokenizer() {
        System.out.println("TOKENIZING USING StringTokenizer CLASS\n");
        String s = "a bc d e";
        StringTokenizer st = new StringTokenizer(s);
        System.out.println("String text to tokenize\t:\t" + s);
        System.out.println("Number of tokens\t:\t" + st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println("Found\t:\t>" + st.nextToken() + "<");
        }
        
        String s2 = "ab bla lab ab bb cac";
        StringTokenizer st2 = new StringTokenizer(s2, "a");
        System.out.println("\nString text to tokenize using 'a' as delimiter\t:\t" + s2);
        System.out.println("Number of tokens\t:\t" + st2.countTokens());
        while (st2.hasMoreTokens()) {
            System.out.println("Found\t:\t>" + st2.nextToken() + "<");
        }
        addSepparator();
    }
    
    private void addSepparator() {
        System.out.println(
            "-----------------------------------------------------------------------------------------------------------------------");
    }
}
