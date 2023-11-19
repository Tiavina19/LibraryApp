package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
 private DBConnection(){
         try {
             connection = DriverManager.getConnection(
                     "jdbc:postgresql://localhost:5432/library_management",
                     System.getenv("db_user"),
                     System.getenv("db_password")
             );
             System.out.println("succes Connection");
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
 }
 public static Connection getConnection(){
     if(connection == null){
         new DBConnection();
     }
     return connection;
 }
}
