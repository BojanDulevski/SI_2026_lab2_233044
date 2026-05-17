import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        library.addBook(new Book("1984", "George Orwell", "Dystopian"));
    }



    @Test
    public void searchBookEveryStatementTest() {


        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });


        List<Book> result = library.searchBookByTitle("Clean Code");
        assertNotNull(result);
        assertEquals(1, result.size());


        List<Book> notFound = library.searchBookByTitle("Harry Potter");
        assertNull(notFound);


        library.borrowBook("The Hobbit", "J.R.R. Tolkien");
        List<Book> borrowed = library.searchBookByTitle("The Hobbit");
        assertNull(borrowed);
    }



    @Test
    public void borrowBookEveryBranchTest() {


        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Robert C. Martin");
        });


        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Clean Code", "");
        });


        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Harry Potter", "J.K. Rowling");
        });


        assertDoesNotThrow(() -> {
            library.borrowBook("Clean Code", "Robert C. Martin");
        });


        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Clean Code", "Robert C. Martin"); // веќе изнајмена од TC4
        });
    }



    @Test
    public void searchBookMultipleConditionTest() {




        List<Book> r1 = library.searchBookByTitle("Clean Code");
        assertNotNull(r1);


        library.borrowBook("The Hobbit", "J.R.R. Tolkien");
        List<Book> r2 = library.searchBookByTitle("The Hobbit");
        assertNull(r2);


        List<Book> r3 = library.searchBookByTitle("NonExistingBook");
        assertNull(r3);



        List<Book> r4 = library.searchBookByTitle("XYZ");
        assertNull(r4);
    }



    @Test
    public void borrowBookMultipleConditionTest() {


        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });


        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Robert C. Martin");
        });


        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Clean Code", "");
        });


        assertDoesNotThrow(() -> {
            library.borrowBook("Clean Code", "Robert C. Martin");
        });
    }
}