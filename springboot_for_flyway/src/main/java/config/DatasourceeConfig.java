package config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceeConfig {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.main")
    public HikariDataSource dataSource(){
        return DataSourceBuilder.
                create().
                type(HikariDataSource.class).
                build();
    }
    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
