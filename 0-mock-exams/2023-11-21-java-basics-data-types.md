# Mock exam 21 nov - Java Basics & Data Types (Udemy)

## Classpath, file structure, executing files

```
package com.udayan.test;

public class Exam {
    public static void main(String [] args) {
        System.out.println("All the best!");
    }
}
Location of files:

D:.
└───WORK
    └───QUIZ
        └───SEC07
            ├───classes
            │   └───com
            │       └───udayan
            │           └───test
            │                   Exam.class
            │
            └───src
                └───com
                    └───udayan
                        └───test
                                Exam.java
You are currently at WORK folder.

D:\WORK>
```

Which of the following java command will show All the best! on to the console?

To execute Exam class from WORK folder, you should specify the classpath (Quiz\Sec07\classes\) which contains whole path of the class(com\udayan\test\Exam.class).

And you should also use fully qualified name of the class, which is com.udayan.test.Exam.

Hence correct option is: `java -cp Quiz\Sec07\classes\ com.udayan.test.Exam`

## Main method

It's possible to have another main method, as long as it isn't public (called by the JVM). So this is fine:

```java
//Guest.java
class Message {
    static void main(String [] args) {
        System.out.println("Welcome " + args[2] + "!");
    }
}

public class Guest {
    public static void main(String [] args) {
        Message.main(args);
    }
}
```

Special main method (called by JVM on execution) should be `static` and should have `public` access modifier. It also takes argument of `String []` type (Varargs syntax `String...` can also be used).

`String []` or `String...` argument can use any identifier name, even though in most of the cases you will see "args" is used.

`final` modifier can be used with this special main method.

The syntax can vary as follows:

`public static void main(String [] args)`
`public static void main(String... args)`
`static public void main(String [] args)`
`static public void main(String... args)`
`static public final void main(String [] args)`

Like any other method, main method can also be overloaded. But main method called by JVM is always with String [] parameter.

### From Hyperskill

If the main method has an invalid declaration, two cases are possible:

- your program cannot be compiled
- your program is successfully compiled but can't be started

#### Your program cannot be compiled.

This is the case when the main method declaration breaks the syntax of Java.

**Examples:**
invalid method declaration: no return value (even `void`).
`public static main(String[] args)`
invalid method declaration: a mistake in the keyword (pulic instead of `public`).
`pulic static void main(String[] args)`

#### A program can be compiled but cannot be run.

This is the case when the main method has a correct declaration as a regular method but doesn't satisfy the specific requirement of the main method.

**Examples:**

- invalid arguments (should be String[] args)

```java
public static void main(String args) {
    System.out.println("Hello, Java");
}
```

- the method declaration has no keyword `static`

```java
public void main(String[] args) {
    System.out.println("Hello, Java");
}
```

In both cases, an error happens at **runtime.**

## Packages and imports

`import orders.*;` will only import all the classes in orders package but not in `orders.items` package.

`protected`, `default` and `private` members are not accessible outside of a package using object reference. TestA is in different package so it can only access public members of class A using object reference.

NOTE: protected members can be accessed outside but only through inheritance and not object reference.

## Class access modifiers

Consider incomplete code of M.java file:

```java
class M {
}

________ class N {
}
```

Which options can fill the above blank:

```
1. public  			X public class must match file name
2. private			X top level class cannot be private
3. protected		X top level class cannot be protected
4. final
5. abstract
```

Top-level class can use only two access modifiers [`public` and default (don't specify anything)]. `private` and `protected` cannot be used.

As **file name** is M.java, class N **cannot be public**.

- Top-level class can be final, hence it is a correct option.
- Top-level class can be abstract and hence it is also a correct option.

## Compiling file with multiple classes with mains

This is the code in Test.java

```java
class A {
    public static void main(String [] args) {
        System.out.println("A");
    }
}

class B {
    public static void main(String [] args) {
        System.out.println("B");
    }
}

class C {
    public static void main(String [] args) {
        System.out.println("C");
    }
}

class D {
    public static void main(String [] args) {
        System.out.println("D");
    }
}
```

How do you make it print C?

- No compilation error!!! Test.java is a valid java file. As none of the classes in Test.java file are `public`, file name can use any valid Java identifier.

1. As file name is Test.java, hence to compile the code below command is used:

   - `javac Test.java`

2. This creates 4 class files: A.class, B.class, C.class & D.class.
3. To print C on to the console, class C must be executed. To execute C class, command is:
   - `java C`

## Types

### Casting + overflow

Byte limit is -128 to 127 --> on overflow becomes negative

- f = c _ l _ i \* f; => Left side variable 'f' is of float type and right side expression evaluates to float value, which can easily be assigned to float type. Hence, it compiles successfully.

- f = l + i + c; => Left side variable 'f' is of float type and right side expression evaluates to long value, which can easily be assigned to float type. Hence, no issues here.

### Initialized values

Primitive type instance variables are initialized to respective zeros (byte: 0, short: 0, int: 0, long: 0L, float: 0.0f, double: 0.0, boolean: false, char: \u0000).

When printed on the console; byte, short, int & long prints 0, float & double print 0.0, boolean prints false and char prints nothing or non-printable character (whitespace).

Reference type instance variables are initialized to null.

## To learn:

- wrapper objects (Number, Byte, Double, etc...)
- garbage collection
