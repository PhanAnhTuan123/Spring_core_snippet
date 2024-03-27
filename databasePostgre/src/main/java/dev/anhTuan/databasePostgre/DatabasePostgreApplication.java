package dev.anhTuan.databasePostgre;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Log
@SpringBootApplication
public class DatabasePostgreApplication implements CommandLineRunner {

    public DatabasePostgreApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
		SpringApplication.run(DatabasePostgreApplication.class, args);
	}
	private final DataSource dataSource;

	@Override
	public void run(String... args) throws Exception {
		log.info("Datasource:" + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
