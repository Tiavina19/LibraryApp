package Repository;

import model.Author;
import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    void insert(Book book) throws SQLException;
    List<Book> findAll() throws SQLException;
    void deleteById(int id) throws SQLException;
    void update( Book book) throws SQLException;
}
