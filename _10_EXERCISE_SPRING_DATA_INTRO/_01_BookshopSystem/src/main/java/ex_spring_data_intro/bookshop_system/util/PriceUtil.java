package ex_spring_data_intro.bookshop_system.util;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class PriceUtil {
    public BigDecimal setPrice(String arg_3) {

        BigDecimal price = new BigDecimal(arg_3);
        System.out.println(price + "\n");
        return price;
    }
}
