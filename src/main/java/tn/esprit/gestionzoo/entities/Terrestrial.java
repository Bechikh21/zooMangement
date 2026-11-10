package tn.esprit.gestionzoo.entities;

// Instruction 20
public class Terrestrial extends Animal {

    protected int nbrLegs;

    // Instruction 22
    public Terrestrial() {
    }

    // Instruction 22
    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        this.nbrLegs = nbrLegs;
    }

    // Instruction 23
    @Override
    public String toString() {
        return "Terrestrial{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + ", nbrLegs=" + nbrLegs + "}";
    }
}
