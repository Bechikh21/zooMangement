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
        lion.family = "Felidae";
        lion.name = "Simba";
        lion.age = 5;
        lion.isMammal = true;

        Zoo myZoo = new Zoo();
        myZoo.name = zooName;
        myZoo.city = "Tunis";
        myZoo.nbrCages = nbrCages;

        // Instruction 6/7 : with only the parameterized constructors, "new Animal()" and "new Zoo()"
        // stop compiling (Java no longer generates the default constructor). Fixed by declaring them.
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal eagle = new Animal("Accipitridae", "Aquila", 3, false);
        Zoo zoo = new Zoo(zooName, "Tunis", 3);

        // Instruction 8 / 9
        System.out.println("\n--- displayZoo() ---");
        zoo.displayZoo();
        System.out.println("--- println(zoo) and println(zoo.toString()) ---");
        System.out.println(zoo);              // before toString() was redefined: Zoo@<hashcode>
        System.out.println(zoo.toString());   // same result: println calls toString() implicitly
        System.out.println(lion);

        // Instruction 10 : add more animals than there are cages (3)
        System.out.println("\n--- addAnimal ---");
        System.out.println("Add lion  : " + zoo.addAnimal(lion));
        System.out.println("Add tiger : " + zoo.addAnimal(tiger));
        System.out.println("Add eagle : " + zoo.addAnimal(eagle));
        System.out.println("Add bear  : " + zoo.addAnimal(new Animal("Ursidae", "Baloo", 10, true)));
        // Without the capacity check, the 4th add throws ArrayIndexOutOfBoundsException.

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

        sc.close();
    }
}
