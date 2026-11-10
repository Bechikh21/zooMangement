# Zoo Management - Prosit 6

ESPRIT TECH zoo management project. Contains prosits 1-5 plus polymorphism and abstract classes.

## Instructions covered
- **5**: `Animal` (family, name, age, isMammal) and `Zoo` (animals, name, city, nbrCages); a lion and a zoo are created in main.
- **6**: parameterized constructors. *Observation*: `new Animal()` / `new Zoo()` in main no longer compile, because Java stops generating the default constructor once another constructor is declared.
- **7**: fixed by declaring the default constructors explicitly; animals are now created with the parameterized constructor.
- **8**: `displayZoo()`. *Observation*: `println(myZoo)` and `println(myZoo.toString())` both print `Zoo@<hashcode>`, since `println` calls `toString()` inherited from `Object`.
- **9**: `toString()` redefined in `Zoo` and `Animal`.
- **10**: `addAnimal()` with an animal counter. *Observation*: adding more animals than cages throws `ArrayIndexOutOfBoundsException` unless the capacity is checked.
- **11**: `displayAnimals()` and `searchAnimal()` (search by name, returns the index or -1). *Observation*: an identical copy of an animal is found at the same index because names are compared.
- **12**: an animal is added only once, and the capacity (max 25) is never exceeded.
- **13**: `removeAnimal()`.

- **14**: `nbrCages` becomes the constant `NBR_CAGES = 25`; the constructor is now `Zoo(String name, String city)`.
- **15**: `isZooFull()`.
- **16**: `static Zoo compareZoo(Zoo z1, Zoo z2)` returns the zoo with the most animals.

- **17**: `addAnimal()` uses `isZooFull()`.
- **18**: all attributes are `private` with getters/setters; an animal's age cannot be negative and a zoo's name cannot be empty. *Errors to fix*: main could no longer access `lion.name`, `myZoo.city`, ... directly, so it now uses the setters/getters.
- **19**: code organized in `tn.esprit.gestionzoo.main` (`ZooManagement`) and `tn.esprit.gestionzoo.entities` (`Animal`, `Zoo`).

- **20**: `Aquatic` (habitat) and `Terrestrial` (nbrLegs) extend `Animal`; `Dolphin` (swimmingSpeed) and `Penguin` (swimmingDepth) extend `Aquatic`.
- **21**: one instance of each class created with the default constructor.
- **22**: parameterized constructors calling `super(...)`; the `Animal` attributes become `protected`. *Observation*: the default-constructor calls in main stop compiling because Java no longer generates them; fixed by declaring the default constructors explicitly.
- **23**: `toString()` redefined in every subclass.
- **24**: `swim()` in `Aquatic` and `Dolphin`. *Observation*: `Penguin` does not redefine it, so it prints the inherited "This aquatic animal is swimming" while the dolphin prints "This dolphin is swimming" (overriding).

- **25**: `aquaticAnimals` array in `Zoo` (max 10).
- **26**: `addAquaticAnimal(Aquatic aquatic)`; aquatic animals are added to a zoo in main.
- **27**: `swim()` is called on every aquatic animal of the zoo. *Observation*: although the array is typed `Aquatic`, each object runs the `swim()` of its real class (polymorphism / dynamic binding).
- **28**: `swim()` is `abstract` in `Aquatic` (so `Aquatic` becomes abstract and can no longer be instantiated); `Penguin` now redefines it.
- **29**: `maxPenguinSwimmingDepth()`.
- **30**: `displayNumberOfAquaticsByType()`.
- **31**: `equals()` (and `hashCode()`) redefined in `Aquatic`: same name, same age and same habitat.

## Run
```
javac -d out $(find src/main/java -name "*.java")
java -cp out tn.esprit.gestionzoo.main.ZooManagement
```
