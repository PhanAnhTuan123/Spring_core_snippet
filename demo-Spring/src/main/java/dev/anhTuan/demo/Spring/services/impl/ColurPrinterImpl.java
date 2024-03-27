package dev.anhTuan.demo.Spring.services.impl;

import dev.anhTuan.demo.Spring.services.BluePrinter;
import dev.anhTuan.demo.Spring.services.ColourPrinter;
import dev.anhTuan.demo.Spring.services.GreenPrinter;
import dev.anhTuan.demo.Spring.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class ColurPrinterImpl implements ColourPrinter {
    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;

    public ColurPrinterImpl() {
    }

    public ColurPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }

    @Override
    public String print() {
        return String.join(",",redPrinter.printer(), bluePrinter.printer(), greenPrinter.printer());
    }
}
