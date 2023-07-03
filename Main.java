import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/students_db";

            String username = "root";
            String password = "azerty";

            connection = DriverManager.getConnection(url, username, password);


        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM students";

        ResultSet resultSet = statement.executeQuery(query);

while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt("id"));
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("age: " + resultSet.getInt("age"));
            System.out.println("address: " + resultSet.getString("address"));
            System.out.println("gpa: " + resultSet.getDouble("gpa"));
            System.out.println("===================================");
        }

    }
}
