package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.AgeRestriction;
import org.springframework.stereotype.Component;

@Component
public class AgeRegistrationUtil {
    public AgeRestriction setAgeRestriction(String arg_4){
        int type = Integer.parseInt(arg_4);
        switch(type){
            case 0: return AgeRestriction.MINOR;
            case 1: return AgeRestriction.TEEN;
            case 2: return AgeRestriction.ADULT;
            default: return null;
        }
    }
}
