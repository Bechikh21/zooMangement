package tn.esprit.gestionzoo.main;


import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

import java.util.Scanner;


public class Main {

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
        System.out.println("Add lion  : " + myZoo.addAnimal(lion));
        System.out.println("Add tiger : " + myZoo.addAnimal(tiger));
        System.out.println("Add eagle : " + myZoo.addAnimal(eagle));


        System.out.println("\n--- displayAnimals ---");
        myZoo.displayAnimals();

        System.out.println("\n--- searchAnimal ---");
        System.out.println("Search lion : " + myZoo.searchAnimal(lion));
        Animal lionCopy = new Animal("Felidae", "Simba", 5, true); // identical but a different object
        System.out.println("Search identical copy of lion : " + myZoo.searchAnimal(lionCopy));
        Animal unknown = new Animal("Ursidae", "Baloo", 10, true);
        System.out.println("Search an animal not in the zoo : " + myZoo.searchAnimal(unknown));


        System.out.println("\n--- uniqueness ---");
        System.out.println("Add the lion again : " + myZoo.addAnimal(lion));
        System.out.println("Add the identical copy : " + myZoo.addAnimal(lionCopy));


        System.out.println("\n--- removeAnimal ---");
        System.out.println("Remove tiger : " + myZoo.removeAnimal(tiger));
        System.out.println("Remove tiger again : " + myZoo.removeAnimal(tiger));
        myZoo.displayAnimals();


        System.out.println("\n--- filling the zoo (max " + Zoo.NBR_CAGES + ") ---");
        System.out.println("isZooFull before : " + myZoo.isZooFull());
        int added = 0;
        for (int i = 1; i <= 30; i++) {   // try to add 30 animals, more than the 25 cages
            if (myZoo.addAnimal(new Animal("Family" + i, "Animal" + i, i, true))) {
                added++;
            }
        }
        System.out.println("Animals accepted out of 30 attempts : " + added);
        System.out.println("Animals in the zoo : " + myZoo.getNbrAnimals());
        System.out.println("isZooFull after : " + myZoo.isZooFull());


        System.out.println("\n--- compareZoo ---");
        Zoo zoo2 = new Zoo("Friguia", "Enfidha");
        zoo2.addAnimal(new Animal("Giraffidae", "Gigi", 4, true));
        Zoo biggest = Zoo.compareZoo(myZoo, zoo2);
        System.out.println("The zoo with the most animals is : " + biggest.getName());


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