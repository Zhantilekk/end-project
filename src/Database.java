import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static Database instance;
    private Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/library_db";
    private final String username = "postgres";
    private final String password = "password";

    private Database() throws SQLException {
        try {
            // Загружаем класс драйвера PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Устанавливаем соединение с базой данных
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        return connection;
    }


    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }
        return instance;
    }
}