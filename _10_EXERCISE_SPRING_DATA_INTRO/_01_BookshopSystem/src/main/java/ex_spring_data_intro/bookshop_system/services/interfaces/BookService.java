package ex_spring_data_intro.bookshop_system.services.interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException, ParseException;

    List<String> findAllTitles() throws ParseException;
}
