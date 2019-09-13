package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.EditionType;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EditionTypeUtil {
    public EditionType randomEditionType() {
        Random random = new Random();
        int randomInt = random.nextInt(2);
        switch(randomInt){
            case 0: return EditionType.NORMAL;
            case 1: return EditionType.PROMO;
            case 2: return EditionType.GOLD;
            default: return null;
        }
    }
}
