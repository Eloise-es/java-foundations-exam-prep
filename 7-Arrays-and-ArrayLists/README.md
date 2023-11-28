# Arrays and ArrayLists

- use a one dimensional array
- create and manipulate an array list
- traverse the elements of an ArrayList using iterators and loops
- compare an array and an ArrayList

## Declaring array variables

An aray is an object that holds a fixed number of values of a given type. If the type is not primitive, it hold references to objects of that type.

### Declaration

```java
// Valid ways to declare:
int [] intArray;
int [][] intArrayTwoDimensional;
int i ia[]; // i is an int, ia is an int array
int [] array1, array2[]; // both arrays, array2 is 2 dimensional

// Invalid ways to declare:
int[3] = invalidArray;
int[][2] = invalidArray2;
int[1][] = invalidArray3;
```

### Creating and initialising array objects

```java
// array initialisers
int[] intArray = {0, 2, 4, 6, 8};
MyClass[] myClassArray = {new MyClass(), new MyClass(), new MyClass()}

// Use new keyword
int[] intArray1 = new int[10];
int[] intArray2 = new int[0];

// invalid (will not compile):
int [] invalidArray = new int[]; // missing size
int [] invalidArray2 = new int[5]{0, 2, 4, 6, 8}; // specifying size and also initialising with values
```

When initialised using `new`, each item in the array will have the default value.

```java
int[] intArray = new int[5]; 			// {0, 0, 0, 0, 0}
String[] strArray = new String[3]; 		// {null, null, null, null}
boolean[] boolArray = new boolean[3];	// {false, false, false}
double[] doubleArray = new double[2]; 	// {0.0, 0.0}
MyClass[] classArray = new MyClass[1]; 	// {null}
```

## Using arrays

### Array indexing

- Access array items with index e.g. `myArray[1]`
- if you try to access an array beyond its range, you get `ArrayIndexOutOfBoundsException`
- you can have an array of size 0 (e.g. args in main when you use no parameter)
- Java arrays are of fixed size - no way to increase or decrease the length
  - you can point at a different array
  - you can always change the values inside

### Array as an object of a class

The class contains:

- length (`public final`, cannot be less than 0)
- `clone()`
  - creates a new array and copies everything into there
  - primitive values are really copied
  - reference types will refer to the same object (shallow copy)
    - no new objects are made, refers to the same objects
- all the things the root class Object contains (e.g. `toString()`, `equals()`)

### Runtime behaviour of arrays

They are "reified"

- type checking is done at runtime, not compile time
- at run time, throws an `ArrayStoreException` if you try to store an incompatible type in an array.

They are "covariant"

- You can store a subclass object in an array declared as its superclass
  - e.g. `Number[]` can store `Float`, `Double`, etc...

### Summary

- Powerful as data structure, not so powerful as data type
- Used as building blocks for many other things like String
- Mostly we use the classes such as `ArrayList`, `List`, `StringBuilder` etc, instead of raw arrays
- The `java.util.Arrays` class is also useful, but not in the exam

## ArrayList

`java.util.ArrayList` adds many useful features to arrays.

For example `.add()` `.remove()` and iterating over the array list.

### Collections and Collections API

java.util.Collection --> java.util.List --> java.util.ArrayList

- Collection is an interface used to provide other interfaces and classes. Together all of these are known as the Collections API.
- List extends Collection to remember the order things were added.
- An interface just describes a behaviour, to implement it you need a class.
- Therefore we use ArrayList.

#### Generics

- The compiler doesn't know what type to put into ArrayList, it can't check compatibility
- That's why you get a warning - you have to rely on assumptions / what another human tells you, it's not coded in.
- This is called "type unsafe"
- To make it type safe, we use generics

```java
ArrayList<String> al = new ArrayList<String>();
```

### ArrayList API

Constructors:

- `ArrayList()` - empty list with initial capacity of 10
- `ArrayList(Collection c)` - list containing the elements of specified collection
- `ArrayList(int initialCapacity)` - empty list with specified initial capacity (can improve performance when you know the approx number you need)

```java
// Declarations that are ok
List list = new ArrayList();
ArrayList<String> al2 = new ArrayList<String>(list); // copying existing list
List<Student> list1 = new ArrayList<>(); // ok, list1 is of type List<Student>
// if we've already added type info, we don't have to repeat it, instead use diamond <>
```

Methods include:

#### Size management

- `ensureCapacity(int n)` - increase capacity, improves performance if used before multiple adds
- `trimToSize()` - gets rid of unused space

#### String

- `String toString()` - converts everything to string e.g. [a, b, c]

#### Add elements

- `boolean add(E e)` - here E is a placeholder for the type you specify in <>. It always returns `true`.
- `void add(int index, E e)` - add at index specified
- `boolean addAll(Collection<? extends E> c)`- add all of a list to another list
- `boolean addAll(int index, Collection<? extends E> c)`- add all of a list to another list, at index (pushes rest along)

#### Remove elements

- `E remove(int index)` - removes item at that index, returns removed item (if index too high or minus number, `IndexOutOfBoundsException`)
- `boolean remove(Object o)` - removes first occurence of specified element, if present
  - if removing integer, use `remove(new Integer(123))` because otherwise the previous method is called (overloaded)
  - returns `true` if it finds a match and removes it, otherise `false`
- `boolean removeAll(Collection<?> c)` - removes all elements that are also in specified collection (not only first occurences, all of them)
- `void clear()` - removes all elements of this list

#### Replace elements

- `E set(int index, E element)` - replaces element at specified position with the one specified. Returns the element that was replaced

#### Read but not modify

- `boolean contains(Object o)` - `true` returned as soon as match is found, otherwise `false`
  - a `null` matches `null`!!
- `E get(int index)` - returns item at that index (if index too high or minus number, `IndexOutOfBoundsException`)
- `int indexOf(Object o)` - compares each element using `equals()`, the index of the first match is returned. If no match, it returns -1.
- `boolean isEmpty()` - returns true if list contains no elements
- `int size()` - returns the number of elements (ArrayList equivalent of array.length())

### Points to remember for the exam

1. ArrayList supports `null` elements
2. ArrayList supports duplicate elements
3. Exceptions: none of the ArrayList methods except toArray() throw NullPointerException. They throw IndexOutOfBoundsException if you try to access an element beyond the range of the list.
4. It is not possible to chain method calls (unlike StringBuilder)

## ArrayList or array?

- ArrayList **advantages** - dynamic sizing, readymade features like searching + inserting methods
- ArrayList **disadvantages** - higher memory usage, no type safety (this is solved by generics), no support for primitive values (solved by autoboxing but it affects performance)

### Similarities

- maintain order with indexes
- allow duplicates
- allow null
- similar performance
- neither have thread safety
