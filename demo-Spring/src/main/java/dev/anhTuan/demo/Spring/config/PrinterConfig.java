package dev.anhTuan.demo.Spring.config;

import dev.anhTuan.demo.Spring.services.BluePrinter;
import dev.anhTuan.demo.Spring.services.ColourPrinter;
import dev.anhTuan.demo.Spring.services.GreenPrinter;
import dev.anhTuan.demo.Spring.services.RedPrinter;
import dev.anhTuan.demo.Spring.services.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {
//    @Bean
//    public BluePrinter bluePrinter(){
//        return new SpanishBluePrinter();
//    }
//    @Bean
//    public RedPrinter redPrinter(){
//        return new SpanishRedPrinter();
//    }
//    @Bean
//    public GreenPrinter greenPrinter(){
//        return new SpanishGreenPrinter();
//    }
//    @Bean
//    public ColourPrinter colourPrinter(BluePrinter bluePrinter,RedPrinter redPrinter,GreenPrinter greenPrinter){
//        return new ColurPrinterImpl(redPrinter,bluePrinter,greenPrinter);
//    }
}
