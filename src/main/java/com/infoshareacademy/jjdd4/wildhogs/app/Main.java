package com.infoshareacademy.jjdd4.wildhogs.app;

import com.infoshareacademy.jjdd4.wildhogs.data.Menu;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

public class Main {

    public static void main(String[] args) {
        new Configuration() {
        
        Menu menu = new Menu();
        menu.optionPicker();
    }
}
