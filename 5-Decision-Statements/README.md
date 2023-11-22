# Decision statements

## if and if-else

Can be one statement or a block:

```java
if (booleanExpression) single_statement;

if (booleanExpression) {
	multiple;
	statements;
}
```

The same is true for the `else` part, and any combination can be used.
They can both be empty.
It's usually better to negate the expression rather than have an empty `if`.

### Dangling else

The `else` is associated with the nearest `if`.

### Using assignment statement in the if condition

This is perfectly possible but usually not done. There is a situations where it is used though:

```java
String data = null;
if ((data = readData()) != null) // readData returns a String
{
	// do something only if data is returned
}
```

> Exam tip: watch out for pre and post increment operations in conditons.
> E.g. if (x++ > 0) x--;

## Ternary constructs

Not needed for the exam, but important in practice.

```java
String response = isHungry ? "I'm hungry" : "I'm not hungry";
//		boolean expression ? 	true	  : 	false
```

1. It is not a statement, only part of one!! So needs to be assigned to a variable
2. It always returns a value
3. To assign, the 2nd and 3rd operands need to be compatible with the 1st operand

- If the 2nd and 3rd operands are both boolean, the expression returns a boolean.
- If the 2nd and 3rd operands are both numeric, the expression returns the wider of the two.
- If either/both of them are reference, the expression returns a reference type.

The compiler checks they are compatible by picking the most specific common superclass.

```java
Double d = 10.0;
Byte by = 1;
Number n = a == b ? d : by // Return type is Number because Double and Byte are both Number

Object o = a == b ? 10 : "hello" // Return type is either Integer or String, so Object is used
```

> Note: Exactly one of the two operands is evaluated! Watch out for this.

## Switch statements

Depending on the value of the expression, the control keeps on going until it encounters a break. If nothing matches, it enters the `default` block.

```java
int i = args.length;
switch(i) {
	case 0 : System.out.println("No arguments");
				break;
	case 1 : System.out.println("One argument");
				break;
	case 2 : System.out.println("Two arguments");
				break;
	default : System.out.println("Too many arguments");
				break;
}
```

### Parts of the switch statement

#### The switch expession

Can be:

- `byte`, `char`, `short`, `int` and their wrapper classes (NOT `long`, `float`, `double` or `boolean`)
- enum
- java.lang.String (since Java 7)

You can use an expression, although single variables are more common. Beware of all the 'baggage' like numeric promotion, casting, operator precedence...

#### Case labels

Optional.
Must be compile time constants, assignable to the type of switch expression.
So, many variables and methods such as toUpperCase() as case lables will not compile.

#### Default block

Optional, like an else statement.

#### Order of case statements and default

This is not imposed by Java, but usually default goes at the end.

#### Break statement

Optional. In the absence of a `break` statement, the control "falls through" to the next, and next, until it reaches the end.

```java
char ch = 'a';
int noOfVowels = 0;

while ((ch = readCharFromStream()) > 0) {
	switch(ch) {
		case 'a' :
		case 'e' :
		case 'i' :
		case 'o' :
		case 'u' :
			noOfVowels++;

		default : logChar(ch);
	}
}
```

In this example, `noOfVowels` is incremented when the `ch` is a lower case vowel. The default is always executed, no matter what.

> Note: duff's device is an example of the fall through behaviour of a switch statement
