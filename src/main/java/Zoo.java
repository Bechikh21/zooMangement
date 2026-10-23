public class Zoo {

    // Instruction 14 : nbrCages is now a constant, a zoo can contain at most 25 animals
    static final int NBR_CAGES = 25;

    Animal[] animals;
    String name;
    String city;
    int nbrAnimals;   // Instruction 10 : counter of animals actually in the zoo

    // Instruction 7 : explicit default constructor (see Animal)
    public Zoo() {
        animals = new Animal[NBR_CAGES];
    }

    // Instruction 14 : nbrCages is no longer a parameter, it is the constant NBR_CAGES
    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        this.name = name;
        this.city = city;
    }

    // Instruction 8
    public void displayZoo() {
        System.out.println("Name: " + name + " | City: " + city + " | Number of cages: " + NBR_CAGES);
    }

    // Instruction 9 : without toString(), println(myZoo) prints "Zoo@1b6d3586" (class name + hash code)
    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES
                + ", nbrAnimals=" + nbrAnimals + "}";
    }

    // Instruction 11
    public void displayAnimals() {
        if (nbrAnimals == 0) {
            System.out.println("The zoo " + name + " has no animals.");
            return;
        }
        System.out.println("Animals of " + name + " (" + nbrAnimals + "):");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println("  [" + i + "] " + animals[i]);
        }
    }

    // Instructions 10 + 12 : an animal is added only once and the capacity is never exceeded
    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (nbrAnimals >= NBR_CAGES) {
            return false;
        }
        if (searchAnimal(animal) != -1) {
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    // Instruction 11 : search by name, return the index or -1
    public int searchAnimal(Animal animal) {
        if (animal == null || animal.name == null) {
            return -1;
        }
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.name.equalsIgnoreCase(animals[i].name)) {
                return i;
            }
        }
        return -1;
    }

    // Instruction 13
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    // Instruction 15
    public boolean isZooFull() {
        return nbrAnimals >= NBR_CAGES;
    }

    // Instruction 16 : returns the zoo with the most animals
    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;
        return (z2.nbrAnimals > z1.nbrAnimals) ? z2 : z1;
    }
}
