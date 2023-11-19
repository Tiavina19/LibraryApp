package Repository;
import model.Subscribers;

import java.sql.SQLException;
import java.util.List;
public interface SubscribersDao {
    void insert(Subscribers subscriber) throws SQLException;
    List<Subscribers> findAll() throws SQLException;
    Subscribers findById(int id) throws SQLException;
    void deleteById(int id) throws SQLException;
    void update(int id, Subscribers subscribers) throws SQLException;
}
