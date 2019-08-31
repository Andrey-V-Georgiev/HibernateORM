package shampoos.interfaces;

import ingredients.abstractClasses.BasicIngredient;
import labels.classes.BasicLabel;
import utilities.Size;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo {
    long getId();
    void setId(long id);
    String getBrand();
    void setBrand(String brand);
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
    Size getSize();
    void setSize(Size size);
    BasicLabel getLabel();
    void setLabel(BasicLabel label);
    Set<BasicIngredient> getIngredients();
    void setIngredients(Set<BasicIngredient> ingredients);
}
