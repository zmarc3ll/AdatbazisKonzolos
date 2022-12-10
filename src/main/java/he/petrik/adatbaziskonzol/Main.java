package he.petrik.adatbaziskonzol;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    static DogDB db;
    public static void main(String[] args) {
        try {
            db = new DogDB();
            listDogs();
        } catch (SQLException e)  {
            throw  new IllegalArgumentException();
        }
    }

    private static void listDogs() throws SQLException {
        List<Dog> dogs = db.getDogs();
        System.out.println(dogs);
    }

    private static void readDogsFromConsole() {
        System.out.println("Adja meg hány kutyát szeretne felvenni");
        Scanner sc = new Scanner(System.in);
        try {
            int count = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < count ; i++) {
                System.out.println("Adja meg a kutya nevét!");
                String name =sc.next();
                System.out.println("Adja meg a kutya nevét!");
                int age = Integer.parseInt(sc.nextLine());
                System.out.println("Adja meg a kutya fajtáját!");
                String breed = sc.nextLine();
                Dog dog = new Dog(name, age, breed);
                db.createDog(dog);
            }
        } catch (NumberFormatException e) {
            System.out.println("Nem számot adott meg");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
