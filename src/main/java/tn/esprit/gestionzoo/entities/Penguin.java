package tn.esprit.gestionzoo.entities;

// Instruction 20
public class Penguin extends Aquatic {

    protected float swimmingDepth;

    // Instruction 22
    public Penguin() {
    }

    // Instruction 22
    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        this.swimmingDepth = swimmingDepth;
    }

    // Instruction 23
    @Override
    public String toString() {
        return "Penguin{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + ", habitat='" + habitat + "', swimmingDepth=" + swimmingDepth + "}";
    }
}
