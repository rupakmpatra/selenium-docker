package com.rupak.tests.util;

public class Demo {
    public static void main(String[] args) {

        System.setProperty("selenium.grid.hubHost", "192.168.1.34");
        Config.initialize();
        String host = Config.get("selenium.grid.hubHost");
        System.out.println("host is "+host);
    }
}
