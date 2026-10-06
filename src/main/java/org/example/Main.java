package org.example;

public class Main {
    public static void main(String[] args) {

        Animal penguin = new Animal("Spheniscidae", "Kowalski", 4, false);
        Animal dolphin = new Animal("Delphinidae", "Flipper", 6, true);
        Animal panda = new Animal("Ursidae", "Po", 8, true);
        Animal wolf = new Animal("Canidae", "Ghost", 5, true);


        Animal penguinCopy = new Animal("Spheniscidae", "Kowalski", 4, false);


        Zoo myZoo = new Zoo("Friguia Park", "Bouficha", 3);


        System.out.println("=== Initial Zoo Details ===");
        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(penguin);
        System.out.println();


        System.out.println("=== Testing Animal Additions ===");
        /
        System.out.println("Add penguin: " + myZoo.addAnimal(penguin));


        System.out.println("Add penguin again: " + myZoo.addAnimal(penguin));


        System.out.println("Add penguinCopy: " + myZoo.addAnimal(penguinCopy));


        System.out.println("Add dolphin: " + myZoo.addAnimal(dolphin));


        System.out.println("Add panda: " + myZoo.addAnimal(panda));


        System.out.println("Add wolf (Zoo Full): " + myZoo.addAnimal(wolf));

        System.out.println("\n--- Current Animals in Zoo ---");
        myZoo.displayAnimals();
        System.out.println();


        System.out.println("=== Testing Animal Searches ===");
        System.out.println("Search penguin: " + myZoo.searchAnimal(penguin));
        System.out.println("Search penguinCopy (By attributes): " + myZoo.searchAnimal(penguinCopy));
        System.out.println("Search wolf (Not in zoo): " + myZoo.searchAnimal(wolf));
        System.out.println();


        System.out.println("=== Testing Animal Removals ===");

        System.out.println("Remove penguin: " + myZoo.removeAnimal(penguin));


        System.out.println("Remove penguin again: " + myZoo.removeAnimal(penguin));


        System.out.println("Add wolf now: " + myZoo.addAnimal(wolf));

        System.out.println("\n--- Final Animals in Zoo ---");
        myZoo.displayAnimals();
    }
}
