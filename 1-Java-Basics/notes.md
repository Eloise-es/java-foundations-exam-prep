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





