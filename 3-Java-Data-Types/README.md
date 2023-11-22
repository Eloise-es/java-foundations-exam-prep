# Working with Java Data Types

- Declare and initialize variables including using final
- Cast a value from one data type to another (including automatic and manual promotion)
- Declare and initialise a String variable

## Data types in Java

### Primitive data types

- Understood by the Java compiler and the JVM
- raw data
- integers, floating point numbers, characters, booleans, bytes
- stores the actual data

### Reference data types

- Not understood by Java, you have to define them
- classes, enums, interfaces, String
- stores only the address to the location (pointer) - only value that can be directly assigned is `null`

### All primitive data types:

| Data Type | Bits | Range                                                   | Examples                                         | Supported Operations |
| --------- | ---- | ------------------------------------------------------- | ------------------------------------------------ | -------------------- |
| boolean   | 1    | true/false                                              | `true`, `false`                                  | Logical Operations   |
| byte      | 8    | -128 to 127                                             | `byte b = 10;`                                   | Arithmetic, Bitwise  |
| short     | 16   | -32,768 to 32,767                                       | `short s = 1000;`                                | Arithmetic, Bitwise  |
| int       | 32   | -2,147,483,648 to 2,147,483,647                         | `int i = 50000;`                                 | Arithmetic, Bitwise  |
| long      | 64   | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | `long l = 100000L;`                              | Arithmetic, Bitwise  |
| float     | 32   | IEEE 754 format                                         | `float f = 10.5f;`                               | Arithmetic           |
| double    | 64   | IEEE 754 format                                         | `double d = 123.456;`<br/>`double d = 123.456d;` | Arithmetic           |
| char      | 16   | Unicode characters                                      | `char c = 'A';`                                  | Arithmetic           |

Some misc facts:

- `float` and `double` store large but imprecise values.
- `void` is a keyword, meaning nothing. It's used as a return type but is not a data type.
- `null` is a value, signifying that a reference variable is not pointing to anything.

Extra study tips: IEEE 754 format, pros and cons of strongly typed languages

### Size of variables

Depends on the machine.

Reference data types are assigned sizes at compile time. The size never changes.
There is no `sizeof` operator in Java because there is no need to calculate the size of memory space taken by an instance of a class at runtime.

### Example of difference between reference and primitive values

```java
//Primitive values:
int i1 = 1;
int i2 = i1;

i2 = 2;
System.out.println(i1) // Prints 1, i1 was unnaffected by the change to i2

// Reference values:
Student s1 = new Student();
s1.id = 1;
Student s2 = s1; // Copies the value (in this case, the address!!!)
s2.id = 2;
System.out.println(s1) // Prints 2! Because it was changed via the address stored in s2
```

## Declaring and initialising variables

```java
// Valid ways to declare + initialise
int x = 10;
int y = x;
String str = "string";
SomeClass obj = new SomeClass();
Object obj2 = obj;
Object obj3 = null;
int m = 20; int p = m = 10;

// Multiple on the same line is possible
int a = 10, b = 20, c = 30;
int d, e = 50, f;

// ****ILLEGAL****
int a = 10, int b;
int a, String str;
int x = y = 10;
```

### Naming conventions

- variable names start with lower case letter
- constant variables are in upper case
- variables created with code generating tools start \_ or $

## Uninitialised variables + default values

- in C/C++, `int i` has an indeterminate value, i.e. it could be anything!
- in Java, to avoid unintended behaviour, uninitialised variables often can't be used.
- The JVM initialises uninitialised variables with default values.
- instance and `static` variables of a class are initialised to predetermined values:

```java
static int i; // = 0
static double d; // = 0.0
static boolean b; // = false
static String s; // = null

int i; // = 0
double d; // = 0.0
boolean b; // = false
String s; // = null
```

### The principle of definite assignment

= a local variable must have a definitely assigned value when any access of its value occurs

- local variables = variables declared in a method/block
- To check for this, the compiler considers only "constant expressions"
  - It can only take into account a variable value if the variable is a "compile time constant"
- Basically, just make sure local variables are assigned a value!!

## Assigning values to variables

### Literals

- represent a fixed value
- numeric literals / char literals / boolean / null
- number without decimal = int literal
- number with decimal = double literal
- underscores are allowed in numbers, e.g. 10_000_000.05
- char literals can be written as 'a' (single quotes) or '\uxxxx' where xxxx is the hex value of the char
- numeric literals can be written in hexadecimal, octal, binary

### Ways to assign variables

1. literals
2. copying another variable (careful with reference variables)
3. return value of a method
4. assigning value of one type to variable of another type

## Assigning value of one type to variable of another type

### Assigning a smaller type to a larger type

= Widening conversion AKA implicit widening conversion

- no special treatment required

```java
byte b = 10; // b is 8 bits
int i; // i is 32 bits

i = b; // This is fine! 8 bits fits inside 32 bits.
```

### If the source type is larger than the target type

= implicit narrowing

- The compiler can't tell how big each variable actually is, unless it is a compile time constant
- Only done for assignments, not method calls

#### If the source variable is not a constant

= casting AKA explicit narrowing

- Works with all primitive types except boolean
- A cast tells the compiler to assign it without worrying about any spillage.
- Be VERY careful with casting!!!! We can't predict the results if there is overflow/spillage

```java
int i = 10;
char c = (char) i; // explicitly casting i to char

int j = 128;
byte b = (byte) j; // Overflow! Not a simple thing to figure out!! In this case, it is -128
```

### Assigning short or byte to char

- This is problematic because char cannot hold negative values (it is unsigned) and byte/short can.

### Assigning float to int or double to long

- Even though they are the same sizes, their ranges are different
- float and double lose information when int and long are assigned to them, BUT Java allows this without needing to cast.
- implicit widening of int to float — OK
- implicit widening of float to int — NOT OK

### Final variables

They can't be reassigned.
If it is an object, we can still change the content within that instance.

```java
class Data {
    int x = 10;
}
public class TestClass {
    public static void main(String[] args) {
        final Data d = new Data();
        d = new Data(); // Will not compile, d is final!
        d.x = 15; // this is fine!
    }
}
```

## Objects

4 ways to instantiate an object:

1. `new` keyword
2. deserialization
3. reflection
4. cloning

The only one on the exam is the `new` keyword.

You usually save the reference to the new instance in a variable, so you can access the object after creation.

create an object = instantiate an object = instantiate a class

The type has to match, unless it's a subtype as with `List l = new ArrayList();`.

### LVTI

Since Java 10 you can shorten the declaration to just `var`.
See below:

```java
// Both work the same, with 'var' the compiler infers the data type
MultipleChoiceQuestion mcq = new MultipleChoiceQuestion();
var mcq2 = new MultipleChoiceQuestion();
```

Can't use it for...

- uninitialised variables
- method parameters
- class members
- instance members
- = null
- arrays (type must be specified in array initialiser)
- return type of method

#### When to use `var`

It is not a keyword or a reserved word, just a shortcut. Take care that it doesn't reduce the readability of the code.
It should be used when it can **improve** readability of code, by reducing clutter.

## Exercises (p.103)

1. Identify primitive and reference data types
2. What are the values of the primitive data types? What operations can be performed on them?
3. What are the methods and what objects can they be invoked on?
4. Change the declaration of various instance members of Person class to include initial values.

```java
public class Person {
    int id; // Primitive = 0
    String name; // Reference
    java.util.Date dob; // Reference
    boolean VIP = false; // Primitive = false
    public static void main(String[] args) {
        Person p1 = new Person(); // Reference
        Person p2 = p1; // Reference
        int id = p2.id; // Primitive = 0
        p1.name = args[0]; // Reference
    }
    public String getName() { return name; } // Method that can be invoked on p1 and p2
}
```

5. Write statements declaring variables of type byte, int, float, double. Assign the values 100, 1000 and 1000.0 to them.

   - which involve automatic promotion?
   - which require manual promotion?
   - which assignments require a cast?
