import java.util.List;

public class LibraryService {
    private IBookRepository bookRepository;


    public LibraryService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void listBooks() {
        List<Book> books = bookRepository.getAllBooks();
        for (Book book : books) {
            book.displayInfo();
        }
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }
}