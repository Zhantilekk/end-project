public class BookFactory {
    public static Book createBook(int id, String title, String author) {
        return new Book(id, title, author);
    }
}