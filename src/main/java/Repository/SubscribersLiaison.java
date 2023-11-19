package Repository;

import model.Subscribers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String query = "SELECT * FROM Subscribers";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Subscribers subscriber = new Subscribers();
                subscriber.setSubscriberId(rs.getInt("subscriber_id"));
                subscriber.setName(rs.getString("name"));
                subscriber.setAddress(rs.getString("address"));
                subscribers.add(subscriber);
            }
        }
        return subscribers;
    }

    public Subscribers findById(int subscriberId) throws SQLException {
        String query = "SELECT * FROM Subscribers WHERE subscriber_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subscriberId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Subscribers subscriber = new Subscribers();
                subscriber.setSubscriberId(rs.getInt("subscriber_id"));
                subscriber.setName(rs.getString("name"));
                subscriber.setAddress(rs.getString("address"));
                return subscriber;
            }
        }
        return null;
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

