package Repository;
import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AuthorLiaison implements AuthorDao {
    private Connection connection;

    public AuthorLiaison(Connection connection) {
        this.connection = connection;
    }

    public void insert(Author author) throws SQLException {
        String query = "INSERT INTO Author (name, gender) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, String.valueOf(author.getGender()));
            stmt.executeUpdate();
        }
    }

    public List<Author> findAll() throws SQLException {
        List<Author> authors = new ArrayList<>();
        String query = "SELECT * FROM Author";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Author author = new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setName(rs.getString("name"));
                author.setGender(rs.getString("gender").charAt(0));
                authors.add(author);
            }
        }
        return authors;
    }

    public Author findById(int authorId) throws SQLException {
        String query = "SELECT * FROM Author WHERE author_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, authorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Author author = new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setName(rs.getString("name"));
                author.setGender(rs.getString("gender").charAt(0));
                return author;
            }
        }
        return null;
    }

    public void deleteById(int authorId) throws SQLException {
        String query = "DELETE FROM Author WHERE author_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, authorId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(int id, Author author) throws SQLException {

    }

    public void update(Author author) throws SQLException {
        String query = "UPDATE Author SET name = ?, gender = ? WHERE author_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, String.valueOf(author.getGender()));
            stmt.setInt(3, author.getAuthorId());
            stmt.executeUpdate();
        }
    }
}


