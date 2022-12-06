package he.petrik.adatbaziskonzol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogDB {
    private Connection conn;
    public static String DB_DRIVER = "mysql";
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_USERNAME = "root";
    public static String DB_PASSWORD = "";

    private DogDB() throws SQLException {
        String url = String.format("jdbc:%s://%s:%s/%s", DB_DRIVER, DB_HOST, DB_PORT);
        conn = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
    }

    public List<Dog> getDogs() throws SQLException {
        List<Dog> dogs = new ArrayList<>();
        String sql = "SELECT * FROM dogs";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int age = result.getInt("age");
            String breed = result.getString("breed");
            Dog dog = new Dog(id, name, age, breed);
            dogs.add(dog);
        }

        return dogs;
    }
}
