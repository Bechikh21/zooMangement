package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {

    protected String habitat;

    public Aquatic() {
    }

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

    public abstract void swim();

    @Override
    public String toString() {
        return "Aquatic{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + ", habitat='" + habitat + "'}";
    }

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
