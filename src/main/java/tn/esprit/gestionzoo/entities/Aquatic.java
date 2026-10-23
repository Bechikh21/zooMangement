package tn.esprit.gestionzoo.entities;

// Instruction 20
public class Aquatic extends Animal {

    protected String habitat;

    // Instruction 22 : once a parameterized constructor exists, the default one must be declared explicitly
    public Aquatic() {
    }

    // Instruction 22
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Instruction 24
    public void swim() {
        System.out.println("This aquatic animal is swimming");
    }

    // Instruction 23
    @Override
    public String toString() {
        return "Aquatic{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + ", habitat='" + habitat + "'}";
    }
}
