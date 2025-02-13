import java.util.List;


public interface IBookRepository {
    void addBook(Book book);
    List<Book> getAllBooks();
    void deleteBook(int id);
}