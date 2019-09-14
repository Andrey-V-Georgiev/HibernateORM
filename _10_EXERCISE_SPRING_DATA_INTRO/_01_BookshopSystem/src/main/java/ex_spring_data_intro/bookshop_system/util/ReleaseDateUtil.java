package ex_spring_data_intro.bookshop_system.util;

import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ReleaseDateUtil {
    public Date setReleaseDay(String arg_1) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        Date date = formatter.parse(arg_1);

        return date;
    }
}
