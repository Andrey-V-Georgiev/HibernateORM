package ex_spring_data_intro.bookshop_system.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Random;

@Component
public class ReleaseDayUtil {

    public LocalDate randomReleaseDay() {
        ZonedDateTime now = ZonedDateTime.now();

        Random randomYear = new Random(1982);
        Random randomMonth = new Random(1);
        Random randomDay = new Random(1);

        int  intRandomYear = randomYear.nextInt(now.getYear());
        int  intRandomMonth = randomMonth.nextInt(12);
        int  intRandomDay = randomDay.nextInt(30);

        return LocalDate.of(intRandomYear, intRandomMonth, intRandomDay);
    }
}
