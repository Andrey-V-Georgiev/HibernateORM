package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class TitleUtil {
    private final BookRepository bookRepository;

    public TitleUtil(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String setTitle(String[] args) {

            StringJoiner sj = new StringJoiner(" ");
            for (int i = 5; i < args.length; i++) {
                sj.add(args[i]);
            }
            String title = sj.toString();
            System.out.println(title);

        return title;
    }
}
