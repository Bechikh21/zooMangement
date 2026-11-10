package tn.esprit.gestionzoo.entities;

// Instruction 20
public class Dolphin extends Aquatic {

    protected float swimmingSpeed;

    // Instruction 22
    public Dolphin() {
    }

    // Instruction 22
    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    public float getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(float swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    // Instruction 24
    @Override
    public void swim() {
        System.out.println("This dolphin is swimming");
    }

    // Instruction 23
    @Override
    public String toString() {
        return "Dolphin{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + ", habitat='" + habitat + "', swimmingSpeed=" + swimmingSpeed + "}";
    }
}
