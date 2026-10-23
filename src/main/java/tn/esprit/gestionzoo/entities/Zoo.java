package tn.esprit.gestionzoo.entities;

public class Zoo {

    // Instruction 14 : nbrCages is now a constant, a zoo can contain at most 25 animals
    public static final int NBR_CAGES = 25;

    // Instruction 18 : attributes are private (encapsulation)
    private Animal[] animals;
    private String name;
    private String city;
    private int nbrAnimals;

    // Instruction 25 : up to 10 aquatic animals
    public static final int MAX_AQUATIC_ANIMALS = 10;
    private Aquatic[] aquaticAnimals = new Aquatic[MAX_AQUATIC_ANIMALS];
    private int nbrAquaticAnimals;   // Instruction 10 : counter of animals actually in the zoo

    // Instruction 7 : explicit default constructor (see Animal)
    public Zoo() {
        animals = new Animal[NBR_CAGES];
    }

    // Instruction 14 : nbrCages is no longer a parameter, it is the constant NBR_CAGES
    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        setName(name);
        this.city = city;
    }

    // Instruction 18 : getters and setters
    public String getName() {
        return name;
    }

    // The name of a zoo must not be empty
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: the name of a zoo cannot be empty. Name not changed.");
            return;
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
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

    // Instructions 10 + 12 + 17 : an animal is added only once and the capacity is never exceeded
    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (isZooFull()) {   // Instruction 17
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
        if (animal == null || animal.getName() == null) {
            return -1;
        }
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.getName().equalsIgnoreCase(animals[i].getName())) {
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

    // Instruction 26
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null) {
            return;
        }
        if (nbrAquaticAnimals >= MAX_AQUATIC_ANIMALS) {
            System.out.println("Cannot add " + aquatic.getName() + ": the aquatic area of " + name + " is full.");
            return;
        }
        aquaticAnimals[nbrAquaticAnimals] = aquatic;
        nbrAquaticAnimals++;
    }

    public int getNbrAquaticAnimals() {
        return nbrAquaticAnimals;
    }

    // Instruction 27 : each animal runs its own version of swim() (polymorphism)
    public void makeAquaticAnimalsSwim() {
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            aquaticAnimals[i].swim();
        }
    }

    // Instruction 29 : maximum swimming depth of the penguins (0 if there is no penguin)
    public float maxPenguinSwimmingDepth() {
        float max = 0;
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                float depth = ((Penguin) aquaticAnimals[i]).getSwimmingDepth();
                if (depth > max) {
                    max = depth;
                }
            }
        }
        return max;
    }

    // Instruction 30
    public void displayNumberOfAquaticsByType() {
        int nbrDolphins = 0;
        int nbrPenguins = 0;
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                nbrDolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                nbrPenguins++;
            }
        }
        System.out.println("Number of dolphins: " + nbrDolphins);
        System.out.println("Number of penguins: " + nbrPenguins);
    }
}
