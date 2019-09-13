package ex_spring_data_intro.bookshop_system.services.impl;

import ex_spring_data_intro.bookshop_system.entities.Book;
import ex_spring_data_intro.bookshop_system.entities.EditionType;
import ex_spring_data_intro.bookshop_system.repositories.BookRepository;
import ex_spring_data_intro.bookshop_system.services.interfaces.BookService;
import ex_spring_data_intro.bookshop_system.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH =
            "C:\\JAVA_PROJECTS\\HibernateORM\\_10_EXERCISE_SPRING_DATA_INTRO\\_01_BookshopSystem\\src\\main\\resources\\files\\books.txt";
    private final BookRepository bookRepository;
    private final FileUtil fileUtil;
    private final AuthorsUtil authorsUtil;
    private final EditionTypeUtil editionTypeUtil;
    private final ReleaseDayUtil releaseDayUtil;
    private final CopiesUtil copiesUtil;
    private final PriceUtil priceUtil;
    private final AgeRegistrationUtil ageRegistrationUtil;
    private final TitleUtil titleUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorsUtil authorsUtil, EditionTypeUtil editionTypeUtil, ReleaseDayUtil releaseDayUtil, CopiesUtil copiesUtil, PriceUtil priceUtil, AgeRegistrationUtil ageRegistrationUtil, TitleUtil titleUtil) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorsUtil = authorsUtil;
        this.editionTypeUtil = editionTypeUtil;
        this.releaseDayUtil = releaseDayUtil;
        this.copiesUtil = copiesUtil;
        this.priceUtil = priceUtil;
        this.ageRegistrationUtil = ageRegistrationUtil;
        this.titleUtil = titleUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if(this.bookRepository.count() != 0) {
            return;
        }

        String[] lines = this.fileUtil.fileContent(BOOKS_FILE_PATH);

        for (String line : lines) {
            String[] params = line.split("\\s+");
            Book book = new Book();
            book.setAuthor(this.authorsUtil.randomAuthor());
            book.setEditionType(this.editionTypeUtil.randomEditionType());
            book.setReleaseDate(this.releaseDayUtil.randomReleaseDay());
            book.setCopies(this.copiesUtil.randomCopiesCount());
            book.setPrice(this.priceUtil.randomPrice());
            book.setAgeRestriction(this.ageRegistrationUtil.randomAgeRestriction());
            book.setTitle(this.titleUtil.randomTitle());


        }
    }
}
