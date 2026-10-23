package tn.esprit.gestionzoo.entities;

public class Animal {

    // Instruction 5 / 18 / 22 : attributes are protected so subclasses can use them
    protected String family;
    protected String name;
    protected int age;
    protected boolean isMammal;

    // Instruction 7 : adding a parameterized constructor removes the implicit default
    // constructor, so "new Animal()" in main no longer compiles. We declare it explicitly.
    public Animal() {
    }

    // Instruction 6
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age);
        this.isMammal = isMammal;
    }

    // Instruction 18 : getters and setters
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    // An animal cannot have a negative age
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Error: the age of an animal cannot be negative (" + age + "). Age not changed.");
            return;
        }
        this.age = age;
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    // Instruction 9
    @Override
    public String toString() {
        return "Animal{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + "}";
    }
}
