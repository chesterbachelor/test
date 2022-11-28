package org.example.brewery.beer;

import java.util.Objects;

public abstract class Beer {
    protected String name;
    protected Strength strength;
    protected Beer(String name, int alcoholContent){
        this.name = name;
        calculateBeerStrength(alcoholContent);
    }
    public String getName(){
        return name;
    }
    public Strength getStrength(){
        return strength;
    }
    private void calculateBeerStrength(int alcoholContent){
        if(alcoholContent < 3){
            strength = Strength.LIGHT;
        }else if(alcoholContent < 6){
            strength = Strength.MEDIUM;
        }else{
            strength = Strength.STRONG;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return name.equals(beer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
