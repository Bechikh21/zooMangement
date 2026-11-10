package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

import java.util.Scanner;

public class ZooManagement {

    private static void addAnimal(Zoo zoo, Animal animal) {
        try {
            zoo.addAnimal(animal);
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
                sc.next();
            }
        }

        System.out.println(zooName + " has " + nbrCages + " cages");

        Animal lion = new Animal();
        lion.setFamily("Felidae");
        lion.setName("Simba");
        lion.setAge(5);
        lion.setMammal(true);

        Zoo myZoo = new Zoo();
        myZoo.setName(zooName);
        myZoo.setCity("Tunis");

        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal eagle = new Animal("Accipitridae", "Aquila", 3, false);
        Zoo zoo = new Zoo(zooName, "Tunis");

        System.out.println("\n--- displayZoo() ---");
        zoo.displayZoo();
        System.out.println("--- println(zoo) and println(zoo.toString()) ---");
        System.out.println(zoo);
        System.out.println(zoo.toString());
        System.out.println(lion);

        System.out.println("\n--- addAnimal ---");
        addAnimal(zoo, lion);
        addAnimal(zoo, tiger);
        addAnimal(zoo, eagle);

        System.out.println("\n--- displayAnimals ---");
        zoo.displayAnimals();

        System.out.println("\n--- searchAnimal ---");
        System.out.println("Search lion : " + zoo.searchAnimal(lion));
        Animal lionCopy = new Animal("Felidae", "Simba", 5, true);
        System.out.println("Search identical copy of lion : " + zoo.searchAnimal(lionCopy));

        System.out.println("\n--- uniqueness ---");
        addAnimal(zoo, lion);
        addAnimal(zoo, lionCopy);

        System.out.println("\n--- removeAnimal ---");
        System.out.println("Remove tiger : " + zoo.removeAnimal(tiger));
        System.out.println("Remove tiger again : " + zoo.removeAnimal(tiger));
        zoo.displayAnimals();

        System.out.println("\n--- ZooFullException (max " + Zoo.NBR_CAGES + ") ---");
        System.out.println("isZooFull before : " + zoo.isZooFull());
        for (int i = 1; i <= 3; i++) {
            addAnimal(zoo, new Animal("Family" + i, "Animal" + i, i, true));
        }
        System.out.println("isZooFull after : " + zoo.isZooFull());

        System.out.println("\n--- compareZoo ---");
        Zoo zoo2 = new Zoo("Friguia", "Enfidha");
        addAnimal(zoo2, new Animal("Giraffidae", "Gigi", 4, true));
        Zoo biggest = Zoo.compareZoo(zoo, zoo2);
        System.out.println("The zoo with the most animals is : " + biggest.getName());

        System.out.println("\n--- encapsulation ---");
        Animal badAnimal = new Animal("Canidae", "Rex", -2, true);
        System.out.println(badAnimal);
        zoo.removeAnimal(eagle);
        addAnimal(zoo, badAnimal);
        lion.setAge(-5);
        lion.setAge(6);
        System.out.println("Lion age : " + lion.getAge());
        Zoo badZoo = new Zoo("   ", "Sfax");
        System.out.println(badZoo);

        System.out.println("\n--- inheritance ---");
        Terrestrial terrestrial = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        Terrestrial elephant = new Terrestrial("Elephantidae", "Dumbo", 8, true, 4);
        Dolphin flipper = new Dolphin("Delphinidae", "Flipper", 6, true, "Sea", 35.5f);
        Penguin pingu = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);
        System.out.println(elephant);
        System.out.println(flipper);
        System.out.println(pingu);

        System.out.println("\n--- swim() ---");
        flipper.swim();
        pingu.swim();

        System.out.println("\n--- aquatic animals of the zoo ---");
        zoo2.addAquaticAnimal(flipper);
        zoo2.addAquaticAnimal(pingu);
        zoo2.addAquaticAnimal(new Dolphin("Delphinidae", "Echo", 4, true, "Sea", 40.0f));
        zoo2.addAquaticAnimal(new Penguin("Spheniscidae", "Skipper", 5, false, "Antarctica", 250.5f));
        zoo2.addAquaticAnimal(new Penguin("Spheniscidae", "Kowalski", 4, false, "Antarctica", 180.0f));

        zoo2.makeAquaticAnimalsSwim();

        System.out.println("Max penguin swimming depth : " + zoo2.maxPenguinSwimmingDepth());

        zoo2.displayNumberOfAquaticsByType();

        System.out.println("\n--- equals() ---");
        Penguin pinguCopy = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 50.0f);
        Penguin pinguElsewhere = new Penguin("Spheniscidae", "Pingu", 3, false, "Zoo pool", 120.0f);
        System.out.println("pingu.equals(pinguCopy) : " + pingu.equals(pinguCopy));
        System.out.println("pingu.equals(pinguElsewhere) : " + pingu.equals(pinguElsewhere));
        System.out.println("pingu.equals(flipper) : " + pingu.equals(flipper));

        sc.close();
    }
}
