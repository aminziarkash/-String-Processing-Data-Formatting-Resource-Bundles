package com.az.dev.ocp.chapter8;

import java.util.ListResourceBundle;

public class MyResourceBundle_FR extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"hello", new StringBuilder("Bonjour Java!")},
            {"welcome", new String("bienvenue à quasar démo")} 
            };
    }
}
