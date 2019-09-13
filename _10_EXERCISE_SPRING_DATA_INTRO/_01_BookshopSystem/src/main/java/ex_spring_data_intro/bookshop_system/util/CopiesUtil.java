package ex_spring_data_intro.bookshop_system.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CopiesUtil {

    public Integer randomCopiesCount() {
        Random random = new Random(10000);
        return random.nextInt(1000000);
    }
}
