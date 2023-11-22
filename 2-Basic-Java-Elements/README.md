# Basic Java Elements

- Conventions to be followed
- Java Identifiers and reserved words
- Comments
- Importing packages
- Describe java.lang package

## Conventions to be followed

#### Cases
1. **ClassNames** should be in CamelCase with a CapitalLetter
2. **packagenames** are usually fully in lowercase but can also be likeThis
3. **variableNames** also start in lowerCase and sometimes like_this but likeThis is better

#### Naming
- meaningful
- don't include type information as Java is strongly typed
- BAD: strAccountId, double_balance, foo, thingy

#### Package names
- Always start with reverse domain name, combined with group/app name
- E.g. com.boa.fit.fxblotter = bank of america (company), fixed income technologies (dep), FX Blotter (app)
- Then on the end you could add .dataStructures.ReadOnlyArrayList for example
- This is to make sure they are all unique

## Java Identifiers and reserved words

### Reserved words

```java
+------------+--------------+-------------+-------------+
| abstract   | assert       | boolean     | break       |
| byte       | case         | catch       | char        |
| class      | const        | continue    | default     |
| do         | double       | else        | enum        |
| extends    | final        | finally     | float       |
| for        | goto         | if          | implements  |
| import     | instanceof   | int         | interface   |
| long       | native       | new         | package     |
| private    | protected    | public      | return      |
| short      | static       | strictfp    | super       |
| switch     | synchronized | this        | throw       |
| throws     | transient    | try         | void        |
| volatile   | while        |             |             |
+------------+--------------+-------------+-------------+
```

#### Literals
`true` `false` `null` `1` `99.9` are interpreted literally for the value they represent. Includes numeric values too.
#### Keywords
`class` `public` `main` etc have predefined actions for the compiler.
#### Prohibited words
`goto` is a prohibited word, even though it doesn't mean anything to the compiler.

### Identifiers
As long as they are not reserved words, you can use any other words to represent whatever you like in a Java program. Then they are called identifiers.
They can't start with a digit.

_Note: `var` is not a keyword, because `var var = "hello"` is converted to `String var = "hello"` by the compiler._

### Important Java Keywords

`class` - defines a new reference type

`new` - creates a new instance of a class

`if` and `else` - create decision statements

`switch`, `case`, `default` and `break` - create more complex decision structures

`for, while, do, break, continue` - create looping statements

`package` - organise classes into packages

`import` - refer to classes defined in other packages

`public`, `private` and `protected` - hide implementation and other unnecessary details of a class (encapsulation)

`extends` and `implements` - create inheritance relationships ('is-a' relationships)

`boolean`, `byte`, `char`, `short`, `int`, `long`, `float`, `double` - declare primitive data types

`super` and `this` - instance members of the parent or current class

`return` - return a value from a method

`static` - specify that it belongs to the class itself, not the members of the class

`throws`, `catch` and `throw` - perform exception handling

These are the only keywords included in the exam

## Importing packages

### Package statement

```java
package com.amazon.sales.itemsMaster;
public class Item {
    
}
```

You cannot have more than one package statement in a Java source file.

The package statement MUST be the first statement in a file if present.

##### Default package
Every Java class belongs to a package. 
If there is no package statement, the classes defined in that file belong to an unnamed, or 'default' package.
It's not possible to import from this package to other classes.

### Import statement

```java
import com.enthuware.ocp.ClassName;
import com.amazon.sales.*;
```

To refer to a class from another package, you need to use its 'fully qualified class name' or FQCN = package name + dot + class name

Instead of doing this every time, you can use an import statement. 
You can use as many as you like, and all they do is create a shortcut way to access those classes.

Some facts about importing packages:
- `java.lang.package` is automatically imported every time.
- There are no subpackages, you can't access com.amazon.books.ClassName by doing com.amazon.*
- If there is no package with the name you specify in the classpath, the compiler will raise an error.
- You can't import default packages / unpackaged classes.
- If you want to import two classes with the same class name, you will have to use FQCN to refer to them.
  - You can import one of them and use FQCN for the other.
- `import static` exists but is not recommended (not on the exam, not used in professional contexts)



## Structure of a Java class

### Class means...
1. in OOP, an abstraction of an entity
2. the code in a java source file (.java file)
3. the output of the java compiler (.class file)

### Structure of a java source file 
1. package statement (0-1)
2. import statements (0+)
3. type declarations (0+)

The order is important, and all 3 parts are optional.

### Members of a class 

Within a class definition, you can have the following **members**...
- field declarations
- methods
- constructors
- initializers
- and also... (not important for this exam)
  - annotations
  - classes
  - interfaces
  - enums

Members can be...
- static
- non-static aka instance

## Comments

```java
// comment 

/* 
multi
line
comment 
*/
```
### JavaDoc comments
If you write comments in this format, you can easily convert them into HTML documentation for your code.

Here's an example of a Javadoc comment for a simple Java method:

```java
/**
* This method calculates the square of a given number.
*
* @param number The input number for which the square will be calculated.
* @return The square of the input number.
  */
  public int calculateSquare(int number) {
  return number * number;
  }
```

  In this example:

- The /** at the beginning indicates the start of a Javadoc comment block.
- The description provides a brief explanation of what the method does.
- @param is used to document the parameters of the method, specifying their names and descriptions.
- @return documents the value that the method returns. 

When the JavaDoc tool processes this, it generates documentation that includes this information, making it easy for other developers to understand how to use the calculateSquare method.

See javadocs folder for chatGPT's example of a class using javadoc.

## File names

If the file contains a public class, the file MUST have the same name as the class.
E.g. A public class called `Student` needs to be in a file called `Student.java` or `Student.jav`

- Only one class per file can be public.
- It's ok to have no public classes in a file.
- It's good practice to keep even a non-public class in a file by the same name.
- By `class`, we're really talking about `type`, so only one public type (enum, interface, class) per file.
- You can have other public types nested inside a public type.
  - These are called 'nested types', as opposed to 'top level types'.
- It's common practice to define each type in its own file.
- It is common practice (not required) to keep the source file in the directory that matches the package name in the file.
- Any class can have a method named main. If you want to execute a class, it needs to have main.

EXAM TIP: Unless stated, assume each class is in its own file of the same name.

## Advanced compilation and execution
Packaging is only for ease of maintenance, the compiler doesn't care about it. 

To compile code with named package:

`javac -d . Account.java`

This produces the correct directory structure for the package.

### More than one source file at once

`javac -d . A.java B.java`

`javac -d . *.java`

It will work out which needs compiling first and do it the best way.

### Packaging classes into Jar

Java Archive zips all the relevant files up together. You can compile it like this...

`jar -cvfm accounting.jar mymanifest.txt accounting`

And then run the program simply like this...

` java -jar accounting.jar`

mymanifest.txt contains the entry point:

`Main-Class: accounting.Account`

When you zip it, this goes into the MANIFEST.MF file.

## Compilation error or exception at runtime?

Three tips to differentiate these:
1. Compiler notices any syntactic mistakes.
   - package statement comes first
   - keywords spelt wrong
2. Compiler doesn't execute any code, so can't find all logical errors. 
    - byte b = 200 // error: 200 is too big to fit in a byte
    - int i = 10/0 // no error, even though it seems wrong when you look at it
3. JVM is the ultimate guard, catches errors in runtime, and actually executes the code.
   - int i - 10/0 // no meaningful integral value, so exception is thrown

## Standard Java packages

The java.lang package is always imported without you having to explicitly do it. 
For the others, you have to import them, and you should avoid using the wildcard * for this.

| Package       | Description                                      | Most Used Classes                                                                          |
|---------------|--------------------------------------------------|--------------------------------------------------------------------------------------------|
| `java.lang`   | Basic functionalities, such as Object and System | `Object`, `String`, `System`, `Math`, `StringBuilder`, `RuntimeException`, wrapper classes |
| `java.util`   | General utilities for data structures            | `Set`, `Map`, `Date`, `ArrayList`, `HashMap`, `List`, `Collection`                         |
| `java.io`     | Input/output functionalities                     | `FileInputStream`, `FileOutputStream`, `PrintWriter`, `BufferedReader`                     |
| `java.net`    | Networking functionalities                       | `URL`, `Socket`, `HttpURLConnection`, `InetAddress`                                        |
| `java.awt`    | Abstract windowing toolkit for creating GUIs     | `Frame`, `Button`, `TextField`, `Label`, `Checkbox`                                        |
| `javax.swing` | Extension of AWT for more advanced GUI elements  | `JFrame`, `JButton`, `JTable`, `JTextField`, `JScrollPane`                                 |
| `java.sql`    | Access to databases via JDBC                     | `Connection`, `Statement`, `ResultSet`, `DriverManager`                                    |

### java.lang.Object
The root class of all classes in Java.

**Wrapper classes and autoboxing - look into this some more to understand better.**

### java.lang.System

The System class has a variable called `out`, of type `PrintStream`. It has various print methods (e.g. `println()`)

### java.lang.Math

Contains methods for things like exponentials, trigometric values, logarithms, and rounding decimals.

### java.util.Random

Used to generate random numbers. Important for the exam, not so much for real life.

## Exercise (p.78)

1. create classes in two different named packages
2. invoke a method from another package
3. create a class with a main method. Execute it multiple times with different arguments. Print the number of arguments.
4. Write down...
   - 3 java literals: `true`, `false`, `null`
   - 3 java keywords: `public`, `class`, `while`
   - 1 reserved word that is neither literal nor keyword: `goto`
5. classes from java.lang: 
   - Object, System, Math
6. Modify the names of the classes to make them fit Java conventions