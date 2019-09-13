package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.Author;
import ex_spring_data_intro.bookshop_system.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class AuthorsUtil {
    private final AuthorRepository authorRepository;

    public AuthorsUtil(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author randomAuthor() {
        List<Author> authors = this.authorRepository.findAll();
        Random random = new Random(1);
        Integer randomId = random.nextInt(authors.size());
        Optional<Author> a = this.authorRepository.findById(randomId);
        return a.get();
    }
}
