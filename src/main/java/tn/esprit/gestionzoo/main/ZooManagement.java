package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        // Instruction 1
        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + " has " + nbrCages + " cages");

        // Instruction 2 : read the values from the keyboard, with input validation
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the zoo: ");
        zooName = sc.nextLine().trim();
        while (zooName.isEmpty()) {
            System.out.print("The name cannot be empty. Enter the name of the zoo: ");
            zooName = sc.nextLine().trim();
        }

        nbrCages = -1;
        while (nbrCages <= 0) {
            System.out.print("Enter the number of cages (positive integer): ");
            if (sc.hasNextInt()) {
                nbrCages = sc.nextInt();
                if (nbrCages <= 0) {
                    System.out.println("The number of cages must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input: please enter a whole number.");
                sc.next(); // throw away the wrong input, otherwise the loop never ends
            }
        }

        // Instruction 3 : display the changes
        System.out.println(zooName + " has " + nbrCages + " cages");

        // Instruction 5 : create an animal and a zoo and assign their attributes
        Animal lion = new Animal();
        // Instruction 18 : attributes are private, they are accessed through setters
        lion.setFamily("Felidae");
        lion.setName("Simba");
        lion.setAge(5);
        lion.setMammal(true);

        Zoo myZoo = new Zoo();
        myZoo.setName(zooName);
        myZoo.setCity("Tunis");
        // Instruction 14 : nbrCages is the constant Zoo.NBR_CAGES and cannot be assigned

        // Instruction 6/7 : with only the parameterized constructors, "new Animal()" and "new Zoo()"
        // stop compiling (Java no longer generates the default constructor). Fixed by declaring them.
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal eagle = new Animal("Accipitridae", "Aquila", 3, false);
        Zoo zoo = new Zoo(zooName, "Tunis");

        // Instruction 8 / 9
        System.out.println("\n--- displayZoo() ---");
        zoo.displayZoo();
        System.out.println("--- println(zoo) and println(zoo.toString()) ---");
        System.out.println(zoo);              // before toString() was redefined: Zoo@<hashcode>
        System.out.println(zoo.toString());   // same result: println calls toString() implicitly
        System.out.println(lion);

        // Instruction 10
        System.out.println("\n--- addAnimal ---");
        System.out.println("Add lion  : " + zoo.addAnimal(lion));
        System.out.println("Add tiger : " + zoo.addAnimal(tiger));
        System.out.println("Add eagle : " + zoo.addAnimal(eagle));

        // Instruction 11
        System.out.println("\n--- displayAnimals ---");
        zoo.displayAnimals();

        System.out.println("\n--- searchAnimal ---");
        System.out.println("Search lion : " + zoo.searchAnimal(lion));
        Animal lionCopy = new Animal("Felidae", "Simba", 5, true); // identical but a different object
        System.out.println("Search identical copy of lion : " + zoo.searchAnimal(lionCopy));
        // The copy is found at the same index because the search compares names, not references.

        // Instruction 12 : uniqueness
        System.out.println("\n--- uniqueness ---");
        System.out.println("Add the lion again : " + zoo.addAnimal(lion));
        System.out.println("Add the identical copy : " + zoo.addAnimal(lionCopy));

        // Instruction 13
        System.out.println("\n--- removeAnimal ---");
        System.out.println("Remove tiger : " + zoo.removeAnimal(tiger));
        System.out.println("Remove tiger again : " + zoo.removeAnimal(tiger));
        zoo.displayAnimals();

        // Instruction 15 : fill the zoo beyond its 25 cages
        System.out.println("\n--- isZooFull (max " + Zoo.NBR_CAGES + ") ---");
        System.out.println("isZooFull before : " + zoo.isZooFull());
        int added = 0;
        for (int i = 1; i <= 30; i++) {
            if (zoo.addAnimal(new Animal("Family" + i, "Animal" + i, i, true))) {
                added++;
            }
        }
        System.out.println("Animals accepted out of 30 attempts : " + added);
        System.out.println("Animals in the zoo : " + zoo.getNbrAnimals());
        System.out.println("isZooFull after : " + zoo.isZooFull());

        // Instruction 16
        System.out.println("\n--- compareZoo ---");
        Zoo zoo2 = new Zoo("Friguia", "Enfidha");
        zoo2.addAnimal(new Animal("Giraffidae", "Gigi", 4, true));
        Zoo biggest = Zoo.compareZoo(zoo, zoo2);
        System.out.println("The zoo with the most animals is : " + biggest.getName());

        // Instruction 18 : validation through the setters
        System.out.println("\n--- encapsulation ---");
        Animal badAnimal = new Animal("Canidae", "Rex", -2, true);
        System.out.println(badAnimal);
        lion.setAge(-5);
        lion.setAge(6);
        System.out.println("Lion age : " + lion.getAge());
        Zoo badZoo = new Zoo("   ", "Sfax");
        System.out.println(badZoo);

        sc.close();
    }
}
