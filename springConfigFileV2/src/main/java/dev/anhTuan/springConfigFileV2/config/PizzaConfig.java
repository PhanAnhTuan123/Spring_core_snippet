package dev.anhTuan.springConfigFileV2.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pizza")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PizzaConfig {
    private String sauce;
    private String topping;
    private String crust;
}
