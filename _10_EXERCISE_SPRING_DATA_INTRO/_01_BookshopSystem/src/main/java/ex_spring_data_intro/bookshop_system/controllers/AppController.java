package ex_spring_data_intro.bookshop_system.controllers;

import ex_spring_data_intro.bookshop_system.services.interfaces.AuthorService;
import ex_spring_data_intro.bookshop_system.services.interfaces.BookService;
import ex_spring_data_intro.bookshop_system.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public AppController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();
        List<String> titles = this.bookService.findAllTitles();
        titles.forEach(System.out::println);
    }
}
