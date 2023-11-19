package Repository;
import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Repository.DBConnection.getConnection;


public class AuthorLiaison implements AuthorDao {
    private static Connection connection;

    private static  Connection getConnection() { return DBConnection.getConnection();}

    public void insert(Author author) throws SQLException {
        String query = "INSERT INTO Author (name, gender) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, String.valueOf(author.getGender()));
            stmt.executeUpdate();
        }
    }

    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM Author";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int authorId = resultSet.getInt("author_id");
                String name = resultSet.getString("name");
                char gender = resultSet.getString("sex").charAt(0);
                Author author = new Author(authorId, name, gender);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  authors;
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
        String query = "UPDATE Author SET name = ?, gender = ? WHERE author_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, String.valueOf(author.getGender()));
            stmt.setInt(3, author.getAuthorId());
            stmt.executeUpdate();
        }
    }

}


