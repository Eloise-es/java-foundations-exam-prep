# String class

## Creating and manipulating strings

### What's a string?

In Java:

- a final class (`java.lang.String`)
- String extends Object
- String implements CharSequence interface

### Creating strings

1. `String()` - creates empty string
2. `String(String str)` - copies a String or StringBuilder
3. `String(byte[] bytes)` - decodes the array of bytes
4. `String(char[] value)` - uses the sequence from a char array

You cannot apply the array indexing operator on a String (str[2]).

#### Concatenation

The + operator is overloaded, if one is a String, it converts the others `toString()` and returns a String.

If one operand is a primitive, it creates a wrapper object and then invokes `toString()` on it.

If one operand is `null`, it just uses the string "null".

It works left to right, so if the first two operands are numbers, it will add them together first.

```java
String s = 1 + 2 + "3"; // result is 33
String s2 = "1" + 2 + 3; // result is 123
```

#### the += operator

The operand on the left has to be String, Object, CHarSequence, Serializable or Comparable.

> Watch out! If neither is string, it won't compile.

#### Overriding `toString()`

It's best to override the automatic toString() for your class so you have a meaningful string produced.

### String pool and string interning

Java keeps compile time constant strings in a "string pool".

The string pool is a special area in the heap to maintain a set of unique strings.

If you use a string twice, you get a reference to the same string.

String pooling saves program memory by avoiding creation of multiple String objects with the same value.

You can get a string from the string pool for a `new` string with the `intern()` method.

### String immutability

It is impossible to change the contents of a string after you have created it.

### String methods

- `int length()` - `"0123".length()` = 4
- `char charAt(int index)` - throws IndexOutOfBoundException if negative or not less than string length
- `int indexOf(int ch)` - returns index found at or -1 if not found. Others are similar:
  - `int indexOf(String s)`
  - `int lastIndexOf(int ch)`
  - `int lastIndexOf(String s)`

For the following methods, the starting index is always inclusive, and the end index is exclusive. This is true of everything that uses element positions in Java.

- `String substring(int beginIndex, int endIndex)`
- `String substring(int beginIndex)` - to end including last char

These all return a new String object with the changes. They return the same string if the change doesn't happen.

- `String concat(String str)`
- `String toLowerCase()/toUpperCase()`
- `String replace(char oldChar, char newChar)` - replaces all matches
- `String trim()` - removes leading and trailing whitespace

To inspect the contents of a string:

- `boolean startsWith(String prefix)` - true if the string starts with this prefix
- `boolean endsWith(String suffix)` - true if the string ends with this suffix
- `boolean contains(CharSequence s)` - true if and only if it contains the specified sequence of chars
- `boolean equals(Object anObject)` - true if the contents are exactly the same. If passed a non-string object, returns false.
- `boolean equalsIgnoreCase(String anotherString)` - true if the contents are the same, ignoring case

Finally:

- `String[] split(String regex)` - splits into an array of strings around matches of the input. E.g. `"/user/ceo/MyClass".split("/")` creates the string array: `["user", "ceo", "MyClass"]`

### Comparing strings

#### Using `==`

This compares the references, checks they point to the same string. It is NOT RECOMMENDED to compare strings, because usually we want to compare character data not where they are in the heap.

#### Using `equals()`

The better way to do it.

```java
"1234".equals(str); // prefered, if str is null, returns false
str.equals("1234"); // throws NullPointerException if str is null
```

#### Using `compareTo()`

- `int compareTo(String anotherString)` - if equal, returns 0, otherwise returns difference between first non-matching chars

## Formatting strings

Use `System.out.printf()` or `System.out.format()` to print formatted strings.

- %d = number (byte, char, short, int, long)
- %s = string
- %n = new line character

`out` is a static variable in `java.lang.System` class of type `java.io.PrintStream`

To format a string, you can use format too, like this: `String message = String.format("Hello, %s!", name)`
