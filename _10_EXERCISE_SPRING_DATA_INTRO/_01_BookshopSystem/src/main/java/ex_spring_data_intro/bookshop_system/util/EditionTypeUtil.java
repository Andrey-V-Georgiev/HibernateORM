package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.EditionType;
import org.springframework.stereotype.Component;

@Component
public class EditionTypeUtil {
    public EditionType setEditionType(String arg_0) {

        int type = Integer.parseInt(arg_0);
        switch(type){
            case 0: return EditionType.NORMAL;
            case 1: return EditionType.PROMO;
            case 2: return EditionType.GOLD;
            default: return null;
        }
    }
}
