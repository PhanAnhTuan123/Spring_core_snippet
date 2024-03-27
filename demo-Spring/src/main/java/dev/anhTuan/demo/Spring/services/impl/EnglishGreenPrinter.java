package dev.anhTuan.demo.Spring.services.impl;

import dev.anhTuan.demo.Spring.services.GreenPrinter;

public class EnglishGreenPrinter implements GreenPrinter {

    @Override
    public String printer() {
        return "Green";
    }
}
