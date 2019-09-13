package ex_spring_data_intro.bookshop_system.services.impl;

import ex_spring_data_intro.bookshop_system.entities.Author;
import ex_spring_data_intro.bookshop_system.repositories.AuthorRepository;
import ex_spring_data_intro.bookshop_system.services.interfaces.AuthorService;

import ex_spring_data_intro.bookshop_system.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final static String AUTHOR_FILE_PATH =
            "C:\\JAVA_PROJECTS\\HibernateORM\\_10_EXERCISE_SPRING_DATA_INTRO\\_01_BookshopSystem\\src\\main\\resources\\files\\authors.txt";
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if(this.authorRepository.count() != 0) {
            return;
        }

        String[] lines = this.fileUtil.fileContent(AUTHOR_FILE_PATH);

        for(String line : lines){
            String[] args = line.split("\\s+");
            Author author = new Author();
            author.setFirstName(args[0]);
            author.setLastName(args[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }
}
