package com.az.dev.ocp.chapter8;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MyResourceBundle {
    
    public static void main(final String[] args) {

        MyResourceBundle app = new MyResourceBundle();
        
        app.callingFromResourceBundleClassTest();
        
        app.callingFromPropertiesTest();
    }
    
    private void callingFromResourceBundleClassTest() {
        System.out.println("CALLING A RESOURCE BUNDLE FROM A CUSTOM RESOURCEBUNDLE CLASS\n");
        ResourceBundle rb2 = ResourceBundle.getBundle("com.az.dev.ocp.chapter8.MyResourceBundle_FR");
        System.out.println("Get a value from FR resource bundle class using 'hello' key\t:\t" + rb2.getObject("hello"));
        System.out.println("Get a value from FR resource bundle class using 'welcome' key\t:\t" + rb2.getObject("welcome"));
        
        addSepparator();
    }
    
    private void callingFromPropertiesTest() {
        System.out.println("PRESS ENTER TO CALL A RESOURCE BUNDLE FROM PROPERTIES FILE");
        
        final Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            if (scanner.nextLine().equals("q")) {
                break;
            }
            
            System.out.println("Type 'fr' to display 'Hello Java' message in French, 'en' to display the message in English\nor 'q' to quit");
            final String lang = scanner.nextLine();
            final Locale locale = new Locale(lang);
            final ResourceBundle rb = ResourceBundle.getBundle("com.az.dev.ocp.chapter8.Labels", locale);
            System.out.println("Message\t\t:\t" + rb.getString("hello"));
            System.out.println("Language\t:\t" + locale.getLanguage());  
        }
        scanner.close();
        addSepparator();
    }
    
    private void addSepparator() {
        System.out.println(
            "-----------------------------------------------------------------------------------------------------------------------");
    }
}
