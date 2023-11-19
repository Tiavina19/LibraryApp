package Repository;

import model.Author;
import model.Subscribers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Repository.DBConnection.getConnection;

public class SubscribersLiaison {
    private Connection connection;

    public SubscribersLiaison(Connection connection) {
        this.connection = connection;
    }

    public void insert(Subscribers subscribers) throws SQLException {
        String query = "INSERT INTO Subscribers (name, address) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subscribers.getName());
            stmt.setString(2, subscribers.getAddress());
            stmt.executeUpdate();
        }
    }

    public List<Subscribers> findAll() throws SQLException {
        List<Subscribers> subscribers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM subscribers";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int subscriberId = resultSet.getInt("subscriber_id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Subscribers subscriber = new Subscribers(subscriberId, name, address );
                subscribers.add(subscriber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  subscribers;
    }

    public void deleteById(int subscriberId) throws SQLException {
        String query = "DELETE FROM Subscribers WHERE subscriber_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subscriberId);
            stmt.executeUpdate();
        }
    }

    public void update(Subscribers subscriber) throws SQLException {
        String query = "UPDATE Subscribers SET name = ?, address = ? WHERE subscriber_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subscriber.getName());
            stmt.setString(2, subscriber.getAddress());
            stmt.setInt(3, subscriber.getSubscriberId());
            stmt.executeUpdate();
        }
    }
}

