package dev.anhTuan.setUpDAOv2.dao.impl;

import dev.anhTuan.setUpDAOv2.dao.BookDao;
import dev.anhTuan.setUpDAOv2.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Service
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn,title,author_id) values (?,?,?)",book.getIsbn(),book.getTitle(),book.getAuthorId()
        );
    }

    @Override
    public Optional<Book> find(String isbn) {
        List<Book>result = jdbcTemplate.query("SELECT isbn,title,author_id from books WHERE isbn = ? LIMIT 1",new BookRowMapper(),
                isbn);
        return result.stream().findFirst();
    }

    @Override
    public List<Book> findMany() {
        return jdbcTemplate.query("Select isbn,title,author_id from books", new BookRowMapper());
    }

    @Override
    public void update(String s, Book book) {
        jdbcTemplate.update("UPDATE books set isbn = ?,author_id = ? where isbn = ?",
                book.getIsbn(),book
                        .getTitle(),book.getAuthorId(),s);
    }

    @Override
    public void delete(String isbn) {
        jdbcTemplate.update("DELETE  from books where isbn = ?",isbn);
    }

    public static class BookRowMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
           return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("authorId"))
                    .build();

        }
    }
}
