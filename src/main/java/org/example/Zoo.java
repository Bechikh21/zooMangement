package tn.esprit.gestionzoo.entities;


public class Zoo {


    public static final int NBR_CAGES = 25;

    private Animal[] animals;
    private String name;
    private String city;
    private int nbrAnimals;   // Instruction 10 : counter of animals actually in the zoo


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




    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (isZooFull()) {
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
}