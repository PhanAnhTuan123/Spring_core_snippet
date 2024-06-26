package dev.anhTuan.setUpDAOv2.dao.impl;

import dev.anhTuan.setUpDAOv2.dao.AuthorDao;
import dev.anhTuan.setUpDAOv2.domain.Author;
import dev.anhTuan.setUpDAOv2.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Component
public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO  authors(id,name,age) values (?,?,?)",
                author.getId(),author.getName(),author.getAge());
    }

    @Override
    public Optional<Author> findOne(long l) {
        List<Author>results  =
        jdbcTemplate.query("SELECT id,name,age FROM authors WHERE id=? LIMIT 1",new AuthorRowMapper(),l);
        return results.stream().findFirst();
    }

    @Override
    public List<Author> find() {
        return jdbcTemplate.query("SELECT id,name,age FROM authors "
                ,new AuthorRowMapper());
    }

    @Override
    public List<Author> findMany() {
        return jdbcTemplate.query("Select id,name,age From authors"
                ,new AuthorRowMapper());
    }

    @Override
    public void update(long id,Author author) {
    jdbcTemplate.update("Update authors SET id = ?,name=?,age = ? where id = ?",
            author.getId(),author.getName(),author.getAge(),id);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM authors where id = ?",id);
    }

    public static class AuthorRowMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
