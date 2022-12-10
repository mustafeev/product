import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void searchTestWhenFewProductsFound() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(id:1, name:"Harry Potter 1", price:100, author:"Rowling");
        Book book2 = new Book(id:2, name:"Harry Potter 2", price:200, author:"Rowling");
        Book book3 = new Book(id:3, name:"The Lord of the rings", price:300, author:"Tolkien");
        SmartPhone phone = new SmartPhone(id:4, name:"Samsung", price:800, author:"Samsung");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone);
        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy(text:"Potter");
        Assertions.assertArrayEquals(expected, actual);
    }
}
