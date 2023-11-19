package Repository;

import model.Author;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Repository.DBConnection.getConnection;

public class BookLiaison implements BookDao {
    private static Connection connection;

    private  static Connection getConnection(){
        return DBConnection.getConnection();
    }

    public void insert(Book book) throws SQLException {
        String query = "INSERT INTO Book (title, author_id) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getAuthorId());
            stmt.executeUpdate();
        }
    }


    public List<Book> findAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM Book";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                int  authorId = resultSet.getInt("author_id");
                Book book = new Book(bookId, title, authorId);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  books;
    }

    public void deleteById(int bookId) throws SQLException {
        String query = "DELETE FROM Book WHERE book_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Book book) throws SQLException {
        String query = "UPDATE Book SET title = ?, author_id = ? WHERE book_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getAuthorId());
            stmt.setInt(3, book.getBookId());
            stmt.executeUpdate();
        }
    }



}
