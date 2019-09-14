package ex_spring_data_intro.bookshop_system.services.impl;

import ex_spring_data_intro.bookshop_system.entities.Book;
import ex_spring_data_intro.bookshop_system.repositories.AuthorRepository;
import ex_spring_data_intro.bookshop_system.repositories.BookRepository;
import ex_spring_data_intro.bookshop_system.services.interfaces.BookService;
import ex_spring_data_intro.bookshop_system.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH =
            "C:\\JAVA_PROJECTS\\HibernateORM\\_10_EXERCISE_SPRING_DATA_INTRO\\_01_BookshopSystem\\src\\main\\resources\\files\\books.txt";
    private final BookRepository bookRepository;
    private final FileUtil fileUtil;
    private final AuthorsUtil authorsUtil;
    private final EditionTypeUtil editionTypeUtil;
    private final ReleaseDateUtil releaseDateUtil;
    private final CopiesUtil copiesUtil;
    private final PriceUtil priceUtil;
    private final AgeRegistrationUtil ageRegistrationUtil;
    private final TitleUtil titleUtil;
    private final CategoryUtil categoryUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorsUtil authorsUtil, EditionTypeUtil editionTypeUtil, ReleaseDateUtil releaseDateUtil, CopiesUtil copiesUtil, PriceUtil priceUtil, AgeRegistrationUtil ageRegistrationUtil, TitleUtil titleUtil, CategoryUtil categoryUtil) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorsUtil = authorsUtil;
        this.editionTypeUtil = editionTypeUtil;
        this.releaseDateUtil = releaseDateUtil;
        this.copiesUtil = copiesUtil;
        this.priceUtil = priceUtil;
        this.ageRegistrationUtil = ageRegistrationUtil;
        this.titleUtil = titleUtil;
        this.categoryUtil = categoryUtil;
    }

    @Override
    public void seedBooks() throws IOException, ParseException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] lines = this.fileUtil.fileContent(BOOKS_FILE_PATH);

        for (String line : lines) {
            String[] args = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.authorsUtil.randomAuthor());
            book.setEditionType(this.editionTypeUtil.setEditionType(args[0]));
            book.setReleaseDate(this.releaseDateUtil.setReleaseDay(args[1]));
            book.setCopies(this.copiesUtil.setCopiesCount(args[2]));
            book.setPrice(this.priceUtil.setPrice(args[3]));
            book.setAgeRestriction(this.ageRegistrationUtil.setAgeRestriction(args[4]));
            book.setTitle(this.titleUtil.setTitle(args));
            book.setCategories(this.categoryUtil.randomSetOfCategories());

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> findAllTitles() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        Date date = formatter.parse("31/12/2000");

        return this.bookRepository
                .findAllByReleaseDateAfter(date)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }
}
