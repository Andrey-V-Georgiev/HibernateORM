package shampoos.classes;

import labels.classes.BasicLabel;
import shampoos.abstractClasses.BasicShampoo;
import utilities.Size;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo {

    private static final String BRAND = "Pink Panther";
    private static final BigDecimal PRICE = new BigDecimal("8.50");
    private static final Size SIZE = Size.MEDIUM;

    public PinkPanther( ) {
    }

    public PinkPanther(BasicLabel label) {
        super(BRAND, PRICE, SIZE, label);
    }
}
