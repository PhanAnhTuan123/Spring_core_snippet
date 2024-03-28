package dev.anhTuan.databasePostgre.dao.impl;

import dev.anhTuan.databasePostgre.dao.AuthorDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDAOImpl implements AuthorDAO {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDAOImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
