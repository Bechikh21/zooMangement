public class Animal {

    // Instruction 5
    String family;
    String name;
    int age;
    boolean isMammal;

    // Instruction 7 : adding a parameterized constructor removes the implicit default
    // constructor, so "new Animal()" in main no longer compiles. We declare it explicitly.
    public Animal() {
    }

    // Instruction 6
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    // Instruction 9
    @Override
    public String toString() {
        return "Animal{family='" + family + "', name='" + name + "', age=" + age
                + ", isMammal=" + isMammal + "}";
    }
}
