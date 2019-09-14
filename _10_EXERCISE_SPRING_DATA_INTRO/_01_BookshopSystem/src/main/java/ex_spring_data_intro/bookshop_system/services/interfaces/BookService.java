package ex_spring_data_intro.bookshop_system.services.interfaces;

import java.io.IOException;
import java.text.ParseException;

public interface BookService {

    void seedBooks() throws IOException, ParseException;
}
