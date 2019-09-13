package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.AgeRestriction;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AgeRegistrationUtil {
    public AgeRestriction randomAgeRestriction(){
        Random random = new Random();
        switch(random.nextInt(2)){
            case 0: return AgeRestriction.MINOR;
            case 1: return AgeRestriction.TEEN;
            case 2: return AgeRestriction.ADULT;
            default: return null;
        }
    }
}
