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

These are the only keywords included in the exam.

## Comments

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

`java.lang.package` is automatically imported every time.

## Describe java.lang package

