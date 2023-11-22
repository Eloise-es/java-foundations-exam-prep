# Working with Java Operators

- basic arithmetic operators
- increment and decrement operators
- relational operators
- arithmetic assignment operators
- conditional operators
- operator precedence + use of parenthesis

## Arithmetic operators

| Operator | Explanation                                                                                                | Example                                                         | Type                                    | Operands                 |
| -------- | ---------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------- | ------------------------ |
| `+`      | Addition operator, used to add two numbers or concatenate two strings.                                     | `int result = 5 + 3;` or `String combined = "Hello" + "World";` | Binary                                  | Numeric types or strings |
| `-`      | Subtraction operator, used to subtract one number from another or indicate a negative value (unary minus). | `int result = 8 - 3;` or `int negative = -a;`                   | Binary (Subtraction) / Unary (Negative) | Numeric types            |
| `*`      | Multiplication operator, used to multiply two numbers.                                                     | `int result = 4 * 6;`                                           | Binary                                  | Numeric types            |
| `/`      | Division operator, used to divide one number by another.                                                   | `double result = 10.0 / 2;`                                     | Binary                                  | Numeric types            |
| `%`      | Modulus operator, returns the remainder of a division.                                                     | `int result = 10 % 3;`                                          | Binary                                  | Integral numeric types   |
| `++`     | Increment operator, increases the value of a variable by 1.                                                | `int num = 5; num++;`                                           | Unary                                   | Numeric types            |
| `--`     | Decrement operator, decreases the value of a variable by 1.                                                | `int num = 5; num--;`                                           | Unary                                   | Numeric types            |

**Note:** Both the division and the modulo operation throw an `ArithmeticException` when we try to use zero as the right side operand.
With `float` and `double` this doesn't occur, instead they result in positive infinity or negative infinity.
I tried `double % 0` and got `NaN`. With `double / 0` I got `Infinity`.

## Relational operators

| Operator | Explanation                                                                                                  | Example                                | Operands                           |
| -------- | ------------------------------------------------------------------------------------------------------------ | -------------------------------------- | ---------------------------------- |
| `==`     | Equality operator, checks if two operands are equal.                                                         | `boolean isEqual = (5 == 5);`          | Numeric types, characters, objects |
| `!=`     | Inequality operator, checks if two operands are not equal.                                                   | `boolean isNotEqual = (5 != 3);`       | Numeric types, characters, objects |
| `>`      | Greater than operator, checks if the left operand is greater than the right operand.                         | `boolean isGreaterThan = (8 > 3);`     | Numeric types, characters          |
| `<`      | Less than operator, checks if the left operand is less than the right operand.                               | `boolean isLessThan = (3 < 8);`        | Numeric types, characters          |
| `>=`     | Greater than or equal to operator, checks if the left operand is greater than or equal to the right operand. | `boolean isGreaterOrEqual = (5 >= 5);` | Numeric types, characters          |
| `<=`     | Less than or equal to operator, checks if the left operand is less than or equal to the right operand.       | `boolean isLessOrEqual = (3 <= 8);`    | Numeric types, characters          |

**Notes:**

If you try `10  == false`, you get a compiler error (`error: incomparable types`).
If you use `>`, `<`, `>=` or `<=` with incomparable types, you get: `error: bad operand types for binary operator`.

With `==` and `!=`, you cannot compare a numeric and non-numeric value. You also can't compare two reference types.
For reference types:

- If you create two objects with the `new` keyword, even if their content is the same, using `==` will result in `false` because it compares the references, not the content.
- To compare the content of objects, it's recommended to use the `.equals()` method, which is specifically designed for content comparison in objects.

There are some important things to learn about using these, particularly with Strings, more info later.

## Logical /Conditional operators

| Operator | Explanation                                                                                                     | Example                                         |
| -------- | --------------------------------------------------------------------------------------------------------------- | ----------------------------------------------- |
| `&&`     | Logical AND operator, returns `true` if both operands are `true`.                                               | `if (isHungry && checkFridge()) {...};`         |
| `\|\|`   | Logical OR operator, returns `true` if at least one operand is `true`.                                          | `if (isHungry \|\| isTired) {...};`             |
| `!`      | Logical NOT operator, reverses the logical state of the operand.                                                | `if (!isHappy) {...};`                          |
| `&`      | Bitwise AND operator, performs bitwise AND operation on individual bits of operands.                            | `int result = 5 & 3;`                           |
| `\|`     | Bitwise OR operator, performs bitwise OR operation on individual bits of operands.                              | `int result = 5 \| 3;`                          |
| `^`      | Bitwise XOR operator, returns true if exactly one of the operands is true.                                      | `boolean isHungryOrTired = isHungry ^ isTired;` |
| `?:`     | Ternary conditional operator, evaluates a boolean expression and returns one of two values based on the result. | `String str = a == 5 ? "five" : "not five"`     |

Note: Can use the bitwise operators `&` and `|` if you want non-short circuiting "and"/"or", e.g. if you want a function to be carried out no matter whether the other thing is true or false.
The thing on the right will always be checked even if the thing on the left is true.

Note: Ternary operator is just the short form of an if else statement.

## Assignment operators

The simple assignment operator is `=`. The rest are called compound assignment operators.
These work on numeric types (primitive and wrappers) but not on boolean or reference types.

| Operator | Explanation                                                                                                                                 | Example                                                 |
| -------- | ------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------- |
| `+=`     | Adds right operand to left and assigns result to left. Unlike the others, this works on String too.                                         | `int a = 10; a += 5;` <br/> a is now 15                 |
| `-=`     | Subtracts right operand from left and assigns result to left.                                                                               | `int a = 10; a -= 3;` <br/> a is now 7                  |
| `*=`     | Multiplies left operand by right and assigns result to left.                                                                                | `int a = 5; a *= 2;` <br/> a is now 10                  |
| `/=`     | Divides left operand by right and assigns result to left.                                                                                   | `double a = 10.0; a /= 3;` <br/> a is now approx 3.3333 |
| `%=`     | Assigns modulus of left operand with right to the left operand.                                                                             | `int a = 10; a %= 3;` <br/> a is now 1                  |
| `&=`     | Performs bitwise AND operation on left and right and assigns result to left.                                                                | `int a = 5; a &= 3;` <br/> a is now 1                   |
| `\|=`    | Performs bitwise OR operation on left and right and assigns result to left.                                                                 | `int a = 5; a \|= 3;` <br/> a is now 7                  |
| `^=`     | Performs bitwise XOR operation on left and right and assigns result to left.                                                                | `int a = 5; a ^= 3;` <br/> a is now 6                   |
| `<<=`    | Shifts bits of left operand to the left by number of positions specified by right and assigns result to left.                               | `int a = 5; a <<= 2;` <br/> a is now 20                 |
| `>>=`    | Shifts bits of left operand to the right by number of positions specified by right and assigns result to left.                              | `int a = 10; a >>= 2;` <br/> a is now 2                 |
| `>>>=`   | Unsigned right shift, shifts bits of left operand to right by specified number of positions, filling with zeros and assigns result to left. | `int a = -10; a >>>= 2;` <br/> a is now 1073741821      |

The left and the right have to be compatible. See 3-Java-Data-Types for the rules about this.

## Bitwise operators

These are used to apply logical operations to individual bits of given numeric values. It's not requiered for the exam, but here they are:

| Operator | Explanation                                                                                                        | Example                                             |
| -------- | ------------------------------------------------------------------------------------------------------------------ | --------------------------------------------------- |
| `&`      | Bitwise AND, performs AND operation on individual bits.                                                            | `int a = 5 & 3;` <br/> `// a is now 1`              |
| `\|`     | Bitwise OR, performs OR operation on individual bits.                                                              | `int a = 5 \| 3;` <br/> `// a is now 7`             |
| `^`      | Bitwise XOR, performs XOR operation on individual bits.                                                            | `int a = 5 ^ 3;` <br/> `// a is now 6`              |
| `~`      | Bitwise Complement, inverts the bits.                                                                              | `int a = ~5;` <br/> `// a is now -6`                |
| `<<`     | Left Shift, shifts bits to the left by a certain number of positions.                                              | `int a = 5 << 2;` <br/> `// a is now 20`            |
| `>>`     | Right Shift, shifts bits to the right by a certain number of positions.                                            | `int a = 10 >> 2;` <br/> `// a is now 2`            |
| `>>>`    | Unsigned Right Shift, shifts bits to the right by a certain number of positions, filling leftmost bits with zeros. | `int a = -10 >>> 2;` <br/> `// a is now 1073741821` |

## Miscellaneous operators

| Operator     | Explanation                                                                                                                                                                              |
| ------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `+`          | Addition operator for numbers or concatenation for strings.                                                                                                                              |
| `.`          | Member access operator, used to access fields and methods of a class.                                                                                                                    |
| `()`         | Cast operator, used to assign variables of a larger type to variables of a smaller type. Also used to cast references of one type to another, but that's not on the exam or in the book. |
| `[]`         | Array access operator, used to access elements within an array.                                                                                                                          |
| `instanceof` | Binary operator used to test if an object is an instance of a particular class or interface.                                                                                             |
| `->`         | Lambda operator, used to define lambda expressions in Java 8 and later.                                                                                                                  |

The dot operator throws a NullPointerException if you apply it to a null reference.

## Expressions and Statements

### Expessions have a value

- They are a combination of one or more explicit values, constants, variables, operators and functions that are interpreted and computed by the programming language.
- They always have a value.
- e.g. `a = a + b` or `a + b` or even `a`

### Statements are complete lines of code

- They can be expressions or contain expressions, but don't have to.
- e.g. `a = a + b;` or `int a = 20;` but not `a + b;` (gives a "Not a statement" error)

## Postfix and prefix (`++i` and `i++`)

`post = i++` = assign `i` to `post`, then increase `i` by 1
`pre = ++i` = increase `i` by 1, then assign it to `pre`

- The prefix form (`--i`/`++i`) increases/decreases it BEFORE it is used.
- The postfix form (`i--`/`i++`) increases/decreases it AFTER it is used.

## String concatenation with `+`

The + operator is overloaded, it works differently with strings.

First, it converts anything that's not a string to a string with `.toString()`. Then it concatenates the strings into a new string. If there is a `null` it doesn't try to run `toString()`, it just uses the String "null".

## Numeric promotion and casting

1. Unary numeric promotion
   - if the type is smaller than int, it will be promoted to int before applying the operator
2. Binary numeric promotion
   - both operands promoted to an int
   - IF one or more is larger than an int, both become like the largest one
   - e.g. int + float // int becomes float

This can cause problems if you want to save the result to a smaller type.

To avoid numeric promotion, you have to explicitly cast the result back to the target type.

With `final` compile time constant variables this doesn't happen if the value fits inside the target type. This is not true of final primitive wrapper objects as the compiler doesn't know they can't be changed.

Numeric promotion does not apply to unary increment operators or compound assignment operators (`--`, `++`, `+=`, `-=`, etc).

## Operator precedence and evaluation of expressions

Similar to BODMAS, Java has its own conventions.

There is no one correct table of precedence, they often disagree on minor things that never happen in real life.

| Precedence | Operator                                         | Type                                           | Associativity |
| ---------- | ------------------------------------------------ | ---------------------------------------------- | ------------- |
| 16         | `()`, `[]`, `.`                                  | Parentheses, Array subscript, Member selection | Left to Right |
| 15         | `var++`, `var--`                                 | Postfix                                        | Left to Right |
| 14         | `++var`, `--var`, `+`, `-`, `!`, `~`, `( type )` | Unary, Unary type cast                         | Right to left |
| 13         | `(cast)`, `new`                                  | Cast, new keyword                              | Right to left |
| 12         | `*`, `/`, `%`                                    | Multiplication, Division, Modulus              | Left to right |
| 11         | `+`, `-`                                         | Addition, Subtraction                          | Left to right |
| 10         | `<<`, `>>`, `>>>`                                | Bitwise shift                                  | Left to right |
| 9          | `<`, `<=`, `>`, `>=`, `instanceof`               | Relational                                     | Left to right |
| 8          | `==`, `!=`                                       | Equality                                       | Left to right |
| 7          | `&`                                              | Bitwise AND                                    | Left to right |
| 6          | `^`                                              | Bitwise exclusive OR                           | Left to right |
| 5          | `\|`                                             | Bitwise inclusive OR                           | Left to right |
| 4          | `&&`                                             | Logical AND                                    | Left to right |
| 3          | `\|\|`                                           | Logical OR                                     | Left to right |
| 2          | `? :`                                            | Ternary conditional                            | Right to left |
| 1          | `=`, `+=`, `-=`, `*=`, `/=`, `%=`                | Assignment                                     | Right to left |

This is why this won't compile:

```java
int i = 0;
byte b = (byte) i + 1; // i is cast to byte and then operation is performed (creating an int)
```

Instead we have to do this:

```java
int i = 0;
byte b = (byte) (i + 1);
```

### Evaluation order

Java goes from left to right, and evaluates each part before evaluating as a whole.

```java
int result = getA() - getB() + getC(); // getA invoked first
int result = getA() - (getB() + getC()); // getA STILL invoked first (left to right)
```
