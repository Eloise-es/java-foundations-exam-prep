## Java Basics
- JDK
- JRE
- components of a Java program
- compile and execute a java program
- object-oriented programming

### JDK
#### Java Development Kit 
= big one, includes tools like debugger and compiler + JRE


### JRE
#### Java Runtime Environment 
= just what is needed to run a Java program (standard classes, config, extension files)

### Components
- Source code files
  -  These contain one or more type definitions
- Java standard library classes
  - Pre-compiled, accessible by any Java program
- Third party libraries
  - Packaged in 'jar' files in the classpath

1. package statement (0 or 1)
2. import statements (0+)
3. type definitions (0+) - class/interface/enum

A class definition can contain `public`, `extends`, `implements` or none of these.

### Compile + execute
Step 1: `javac NameOfFile.java`

Step 2: `java NameOfFile.java`

Or, since Java 11, in just one step:

`java NameOfFile.java`

### Main method

There has to always be a main method, and it's always the first thing to run.
Looks like this:
```java
public static void main(String[] args) {}
```

Or like this:
```java
public static void main(String... args) {}
```

Or like this:
```java
public static void main(String args[]) throws Exception { throw new Exception(); }
```

### Command line args
Specify them like this: `java NameOfProgram a b c`

They are passed to the main method as strings. In this case, the String array 'args' would contain `["a", "b", "c"]`

If there are no args, args is not null, it is a String array of length 0

## Object-Oriented Programming (OOP)

Objects are modelled using classes. Their behaviour is modelled as methods on those classes.

OOP is the opposite of Procedural Programming

#### Abstraction
- capturing relevant details (defining the concept)

#### Encapsulation
- hiding implementation details of an entity (show what, not how)
- Data members of a class are declared private, methods are declared public.

#### Inheritance
- Creating specialised entities by extending existing entities
- e.g. SportsCar extends Car

#### Polymorphism 
- same entity has different behaviour depending on context
- direct consequence of inheritance (SportsCar is counted as Car, but behaves differently)


### Describing behaviour

We can use one behaviour on a range of objects, e.g. "Switchable" for Car, Fan, LightBulb. In every case we can switch the thing on or off, but each one does this differently.

```java
interface Switchable{
    void on();
    void off();
}
```
Use `implements` to define the behaviour per class:
```java
class Fan implements Switchable {
    boolean on;
    void on() {
        // performs actions to turn Fan on
      on = true;
    }
    void off() {
        // performs actions to turn Fan off
      on = false;
  }
}
```
We abstract out the behaviour to interfaces.

### Creating objects

```java
Car car1 = new Car();
```

### Making objects interact

See example below of how objects call each other's methods and access each other's data:
```java
class MyApp{
    public static void main(String[] args){
        Dealership dealer = new Dealership();
        car c = new Car();
        dealer.addCar(c);
        dealer.showCars();
    }
}
```
### Relation between Class, Object and Reference

class = template to make objects with

object = instance of a class

reference = the address of the object in memory (can be more than one pointing to the same object)

A reference variable not pointing to anything is `null`. A primitive variable cannot be null. 

### Using static and instance

Functions can't live alone outside a class, but sometimes we want just one function rather than individual ones for each object. To get around this, we use `static` to say that the method applies to the class rather than just an instance of the class. Then we don't have to use `new` anywhere, we can just call the function. 

"Static variables" are also called "class variables" because they stay with the class, not each object.

The opposite of static is instance, but it has no keyword as it's the default.

## Exercise (p52)

1. `java -help` = everything you can do with the command `java`
2. FileNames are written in camel case with the first letter capitalised. If the file name matches the name of the public class containing main, the compiler is happy. It has an entry point.
3. The java file name should always be the same as a public class name.
4. violated OOP principles:
   - abstraction - only one class that does everything, no concept defined to create entities with
   - encapsulation - all the how is visible in the one class
   - inheritance and polymorphism not used 
5. encapsulation controls functionality by hiding the way things are done and making parts compatible, not dependent
6. information hiding - tries to hide the behind the scenes way things work, focus is on the data you retrieve and actions you can do - hidden parts are the inside workings of functions.
7. Aggregation relies on sets of data, but with inheritance things are less dependent on each other and exist as seperate instances

--> Check answers, these questions were difficult.
