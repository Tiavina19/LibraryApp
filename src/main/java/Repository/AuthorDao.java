package Repository;

import model.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
    void insert(Author author) throws SQLException;
    List<Author> findAll() throws SQLException;
    Author findById(int id) throws SQLException;
    void deleteById(int id) throws SQLException;
    void update(int id, Author author) throws SQLException;
}
