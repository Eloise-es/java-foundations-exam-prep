# Classes and COnstructors

- create a new class including main
- use private modifier
- describe relationship between object and its members
- difference between class variable, instance variable, local variable
- create object's default constructor which modifies the object's fields
- use constructors with and without parameters
- develop code that overloads constructors

## Relationship between object and its members

To access an object and its instance variables, we have to save a reference to the object.

### `this` keyword

We use it to mean the object/instance that we are currently inside. Sometimes it's not necessary, but we should still use it for better readability.

> Note: watch out for redundant assignment in the exam!

This:

- is a keyword
- has the type of the class in which it is used
- works just like any other local variable
- can't be modified
- can only be used in the context of a class

## Access modifiers

private > default > protected > public

- `private` - only accessible within that class
- `"default"` - absence of modifier, accessible to all members of the package
- `protected` - accessible from same package OR any subclass
- `public` - accessible from anywhere

## Encapsulation principles

Encapsulation = restricting direct access to an object's fields

You should be able to make use of a class through methods and not by accessing variables. Why?

1. you have freedom to modify the implementation of the functionality without affecting the users of your class
2. you can ensure that the value of a variable is always consistent with the business logic (e.g. age cannot be negative)

- Always make your code as private as possible (don't hand out access rights easily)
  - the more you relax access, the less encapsulated a class gets
- Almost never make data-fields non-private (use getters and setters)
- Make methods non-private only when sure another class needs to access them
- ideally, only constants deserve to be public

## Constructors

When you ask JVM to create new instance of a class:

1. load and initialize the class (if not already done)
2. allocate memory in the heap
3. initialize variables to default values
4. **instance initializers** and **constructors**

### Instance initializers

```java
class TestClass {
	int variable;
	{
		System.out.println("This is an instance initializer");
		System.out.println("with access to" + this.variable);
	}
}
```

### Constructors

- name is always the class name
- no return type

```java
class TestClass {
	int variable;

	TestClass(int x) {
		this.variable = x;
		// permissable to have return; but not required
	}
}
```

It is possible to have a method with the same name as the class, if you give it a return type (even `void`) it counts as a method, not a constructor.

IF YOU ADD A CONSTRUCTOR, THE DEFAULT EMPTY ONE DOESN'T EXIST.

The default constructor has the same accessibility as the class.

#### Overloading constructors

It's common to use constructor chaining, see example below:

```java
public class ClassesTest {
	String name;
	int age;

	ClassesTest() { // if no args
		this("No name", 18);
	}

	ClassesTest(int age) { // if only age provided
		this("No name", age);
	}

	ClassesTest(String name) { // if only name provided
		this(name, 18);
	}

	ClassesTest(String name, int age) { // both name and age
		this.name = name;
		this.age = age;
	}
}
```

This way, all the initialization logic is in one place. The call to the other constructor must be on the first line though, and must use `this`.

The constructor is only invoked:

- with `new` keyword
- with `this`, through another constructor
- with `super`

## Scopes of class, instance and local variables

- Three **visibility** scopes: class, method, block
- Five **lifespan** scopes: class, instance, method, for loop, block

#### Visibility

| Visibility Scopes | Description                                                   | Example                                  |
| ----------------- | ------------------------------------------------------------- | ---------------------------------------- |
| Class             | Visible throughout the entire class                           | Class variables and methods              |
| Method            | Visible within the method where it's declared                 | Local variables declared within a method |
| Block             | Visible within a block of code (e.g., if statement, for loop) | Variables declared within a block        |

#### Lifespan

| Lifespan Scopes | Description                                         | Example                                   |
| --------------- | --------------------------------------------------- | ----------------------------------------- |
| Class           | Exists as long as the class exists                  | Static variables in a class               |
| Instance        | Exists as long as the object instance exists        | Instance variables within an object       |
| Method          | Exists during the execution of the method           | Local variables within a method           |
| For Loop        | Exists within the execution of a for loop           | Variables declared within a for loop      |
| Block           | Exists within the block of code where it's declared | Variables declared within a block of code |

> Exam tip: simple rule is that you can't define 2 variables with same name and same visibility scope. BUT exception exists:
> It is possible to overlap instance field with method local variable, but not possible to overlap method local variable with loop/block scoped variable.
