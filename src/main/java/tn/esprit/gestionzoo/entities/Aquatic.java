package tn.esprit.gestionzoo.entities;

// Instruction 20
// Instruction 28 : the class becomes abstract so swim() must be redefined in every child class
public abstract class Aquatic extends Animal {

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

    // Instruction 24 / 28 : abstract, each child class must give its own implementation
    public abstract void swim();

    // Instruction 23
    @Override
    public String toString() {
        return "Aquatic{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + ", habitat='" + habitat + "'}";
    }

    // Instruction 31 : two aquatic animals are identical if they have the same name, age and habitat
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Aquatic)) return false;
        Aquatic other = (Aquatic) obj;
        return age == other.age
                && java.util.Objects.equals(name, other.name)
                && java.util.Objects.equals(habitat, other.habitat);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, habitat);
    }
}
