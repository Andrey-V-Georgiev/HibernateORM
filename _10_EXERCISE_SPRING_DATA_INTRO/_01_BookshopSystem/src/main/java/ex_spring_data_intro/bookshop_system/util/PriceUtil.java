package ex_spring_data_intro.bookshop_system.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class PriceUtil {
    public BigDecimal randomPrice() {

        double priceDouble = ThreadLocalRandom.current()
                .nextDouble(3.0, 250.0);
        return new BigDecimal(priceDouble);
    }
}
