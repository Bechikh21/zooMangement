package tn.esprit.gestionzoo.main;


import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

import java.util.Scanner;


public class Main {

    // Instructions 33 & 34 : adds an animal, handles the exceptions,
    // and ALWAYS displays the number of animals (finally block)
    private static void addAnimal(Zoo zoo, Animal animal) {
        int before = zoo.getNbrAnimals();
        try {
            zoo.addAnimal(animal);
            if (zoo.getNbrAnimals() > before) {
                System.out.println(animal.getName() + " added to " + zoo.getName() + ".");
            }
        } catch (ZooFullException e) {
            System.out.println("ZooFullException: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("InvalidAgeException: " + e.getMessage());
        } finally {
            System.out.println("Number of animals in " + zoo.getName() + " : " + zoo.getNbrAnimals());
        }
    }

    public static void main(String[] args) {


        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + " has " + nbrCages + " cages");


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


        System.out.println(zooName + " has " + nbrCages + " cages");


        Zoo myZoo = new Zoo(zooName, "Tunis");
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal eagle = new Animal("Accipitridae", "Aquila", 3, false);


        System.out.println("\n--- displayZoo() ---");
        myZoo.displayZoo();
        System.out.println("--- println(myZoo) and println(myZoo.toString()) ---");
        System.out.println(myZoo);
        System.out.println(myZoo.toString());
        System.out.println(lion);


        System.out.println("\n--- addAnimal ---");
        addAnimal(myZoo, lion);
        addAnimal(myZoo, tiger);
        addAnimal(myZoo, eagle);


        System.out.println("\n--- displayAnimals ---");
        myZoo.displayAnimals();

        System.out.println("\n--- searchAnimal ---");
        System.out.println("Search lion : " + myZoo.searchAnimal(lion));
        Animal lionCopy = new Animal("Felidae", "Simba", 5, true); // identical but a different object
        System.out.println("Search identical copy of lion : " + myZoo.searchAnimal(lionCopy));
        Animal unknown = new Animal("Ursidae", "Baloo", 10, true);
        System.out.println("Search an animal not in the zoo : " + myZoo.searchAnimal(unknown));


        System.out.println("\n--- Instruction 33 : ZooFullException (" + Zoo.NBR_CAGES + " cages) ---");
        System.out.println("isZooFull : " + myZoo.isZooFull());
        addAnimal(myZoo, unknown);                 // the zoo already has 3 animals -> ZooFullException
        addAnimal(myZoo, new Animal("Canidae", "Rex", 2, true));


        System.out.println("\n--- removeAnimal ---");
        System.out.println("Remove tiger : " + myZoo.removeAnimal(tiger));
        System.out.println("Remove tiger again : " + myZoo.removeAnimal(tiger));
        myZoo.displayAnimals();


        System.out.println("\n--- Instruction 34 : InvalidAgeException ---");
        Animal badAnimal = new Animal("Canidae", "Rex", -2, true);
        addAnimal(myZoo, badAnimal);               // negative age -> InvalidAgeException
        addAnimal(myZoo, unknown);                 // a free cage again -> added


        System.out.println("\n--- compareZoo ---");
        Zoo zoo2 = new Zoo("Friguia", "Enfidha");
        addAnimal(zoo2, new Animal("Giraffidae", "Gigi", 4, true));
        Zoo biggest = Zoo.compareZoo(myZoo, zoo2);
        System.out.println("The zoo with the most animals is : " + biggest.getName());


        System.out.println("\n--- encapsulation ---");
        Zoo badZoo = new Zoo("   ", "Sfax");
        System.out.println(badZoo);


        sc.close();
    }
}