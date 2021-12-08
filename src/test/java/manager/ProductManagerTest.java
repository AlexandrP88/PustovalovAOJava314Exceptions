package manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {
    Book book1 = new Book(001, "Лирика", 50, "Фет");
    Book book2 = new Book(002, "Пиковая дама", 20, "Пушкин");
    Book book3 = new Book(003, "Идиот", 30, "Достоевский");
    Book book4 = new Book(004, "Россия", 40, "Гришин");
    Book book5 = new Book(005, "Весенняя гроза", 45, "Фет");
    Product product1 = new Product(006, "Шорты", 500);
    Smartphone smartphone1 = new Smartphone(007, "Ipnone", 100, "USA");
    Smartphone smartphone2 = new Smartphone(8, "Samsung", 150, "China");
    Smartphone smartphone3 = new Smartphone(9, "Honor", 90, "Korea");
    Smartphone smartphone4 = new Smartphone(010, "Yota", 70, "Россия");


    @Test
    public void showdNoProduct() {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.removeById(003);

        ProductManager manager = new ProductManager(repo);

        Product[] expected = {book1,book2};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);


    }

    @Test
    public void showdOneBoook() {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(product1);

        assertThrows(NotFoundException.class, () -> {repo.removeById(15);});
    }
}

