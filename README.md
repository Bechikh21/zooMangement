# Zoo Management - Prosit 3

ESPRIT TECH zoo management project. Contains prosits 1-2 plus the Zoo capacity rules.

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

## Run
```
javac -d out src/main/java/*.java
java -cp out ZooManagement
```
