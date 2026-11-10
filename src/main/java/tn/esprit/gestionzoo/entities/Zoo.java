package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class Zoo {

    public static final int NBR_CAGES = 3;

    private Animal[] animals;
    private String name;
    private String city;
    private int nbrAnimals;

    public static final int MAX_AQUATIC_ANIMALS = 10;
    private Aquatic[] aquaticAnimals = new Aquatic[MAX_AQUATIC_ANIMALS];
    private int nbrAquaticAnimals;

    public Zoo() {
        animals = new Animal[NBR_CAGES];
    }

    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        setName(name);
        this.city = city;
    }

    public String getName() {
        return name;
    }

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

    public void displayZoo() {
        System.out.println("Name: " + name + " | City: " + city + " | Number of cages: " + NBR_CAGES);
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES
                + ", nbrAnimals=" + nbrAnimals + "}";
    }

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

    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal == null) {
            return;
        }
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("Cannot add " + animal.getName()
                    + ": the age of an animal cannot be negative (" + animal.getAge() + ").");
        }
        if (searchAnimal(animal) != -1) {
            System.out.println(animal.getName() + " is already in the zoo.");
            return;
        }
        if (nbrAnimals >= NBR_CAGES) {
            throw new ZooFullException("Cannot add " + animal.getName()
                    + ": the zoo " + name + " is full (" + NBR_CAGES + " cages).");
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
    }

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

    public boolean isZooFull() {
        return nbrAnimals >= NBR_CAGES;
    }

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;
        return (z2.nbrAnimals > z1.nbrAnimals) ? z2 : z1;
    }

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

    public void makeAquaticAnimalsSwim() {
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            aquaticAnimals[i].swim();
        }
    }

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
