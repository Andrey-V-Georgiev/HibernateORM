package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.Book;
import ex_spring_data_intro.bookshop_system.repositories.BookRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.Random;

@Component
public class TitleUtil {
    private final BookRepository bookRepository;

    public TitleUtil(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String randomTitle() {
        int booksCount = (int) this.bookRepository.count();
        Random random = new Random(1);
        Optional<Book> book = this.bookRepository.findById(random.nextInt(booksCount));
        return book.get().getTitle();
    }
}
