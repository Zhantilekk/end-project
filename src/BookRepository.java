import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookRepository implements IBookRepository {

    @Override
    public void addBook(Book book) {
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new book was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = "SELECT id, title, author FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void deleteBook(int id) {
        try {
            Connection conn = Database.getInstance().getConnection();
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The book was deleted successfully!");
            } else {
                System.out.println("No book found with the provided ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}