package dev.anhTuan.demo.Spring.services.impl;

import dev.anhTuan.demo.Spring.services.RedPrinter;

public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String printer() {
        return "Red";
    }
}
