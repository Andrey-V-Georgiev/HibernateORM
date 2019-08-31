package ingredients.abstractClasses;

import ingredients.interfaces.ChemicalIngredient;

import javax.persistence.Column;
import java.math.BigDecimal;

public abstract class BasicChemicalIngredeient
        extends BasicIngredient implements ChemicalIngredient {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    BasicChemicalIngredeient() {}

    public BasicChemicalIngredeient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.setChemicalFormula(chemicalFormula);
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }

    @Override
    public String getChemicalFormula() {
        return chemicalFormula;
    }
}
