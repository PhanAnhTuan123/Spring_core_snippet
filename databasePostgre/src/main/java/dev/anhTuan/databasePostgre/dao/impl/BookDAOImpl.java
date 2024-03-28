package dev.anhTuan.databasePostgre.dao.impl;

import dev.anhTuan.databasePostgre.dao.BookDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDAOImpl implements BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAOImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
