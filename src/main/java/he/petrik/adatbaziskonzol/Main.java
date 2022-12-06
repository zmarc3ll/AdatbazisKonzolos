package he.petrik.adatbaziskonzol;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DogDB db = new DogDB();
            List<Dog> dogs = db.getDogs();
            System.out.println(dogs);
        } catch (SQLException e)  {
            throw  new IllegalArgumentException();
        }
    }
}
