package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.Author;
import ex_spring_data_intro.bookshop_system.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class AuthorsUtil {
    private final AuthorRepository authorRepository;
    private static Random r;

    @Autowired
    public AuthorsUtil(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author randomAuthor() {
        List<Author> authors = this.authorRepository.findAll();
        Integer randomId = getRandomNumberInRange(1, authors.size());
        Optional<Author> a = this.authorRepository.findById(randomId);
        return a.get();
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
