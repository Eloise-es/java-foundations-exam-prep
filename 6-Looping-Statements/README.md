# Looping Statements

## While

```java
int i = 0;

while (i < 5) {
	Do.something();
	i++;
}
// This will loop 5 times, i will be: 0 1 2 3 4 and at the end, 4
```

```java
int i = 0;

while (i++ < 5) Do.something(); // one line, i is increased even if not < 5

// This will loop 5 times, i will be: 0 1 2 3 4 and at the end, 5
```

A common way to do forever loops:

```java
while( (clientSocket = serverSocket.accept()) != null) {
	// code which then comes back to the while loop to keep listening
}
```

## Do-while

The opposite order to a while loop.

```java
do {
	statement;
	or statements;
} while (boolean_expression);
```

Watch out, it will always enter the `do` the first time, whether or not the `while` is true.

While loops are more common and practical than do-while loops.

## For loops

```java
for (int i = 0; i < 5; i++) {
	System.out.println(i);
}
// result is 0 1 2 3 4
```

Does the same as a while loop, but the variable i is not accessible outside the loop.

Process:

1. initialization section is executed (int i = 0)
   - if empty, ignored
2. condition section is executed (i < 5)
   - if true, move to step 3
   - if false, loop is terminated immediately
   - if empty, assumed to be true
3. for block statements are executed
4. updation section executed (i++)
   - if empty, ignored
5. back to step 2

### Initialization section

If not just declaration of a local variable, they must be "expression statements" - expressions that can stand alone as statements.
This includes:

- assignment
- pre/post increment/decrement
- method call
- class instance creation (new)

You can declare multiple local variables of the same type: `for (int i = 5, k = 7; i<10; i++);`
If declared here, a variable is not visible outside the loop.

### Condition section

Simple. Anything that returns a `boolean` or `Boolean` is fine. If empty, it's seen as `true`

### Updation section

Rules are the same as for initialization section, except you can't declare a variable here.
There doesn't have to be a relationship between this and code in other sections, but it's usually `i++` or `i += 2` or something like that.

### Infinite for loop

```java
for ( ; ; ); // this will keep on looping forever!
```

## For each loops

```java
String [] values = {"a", "bb", "ccc"};
for (String value : values) {
	System.out.println(value);
}
```

This reads as "for each value in values, do ..." - much simpler than the alternative with for or while loops.

`Iterable` is a super interface of java.util.Collection and for-each can only be used on `Iterable` objects (such as ArrayList, List, HashSet, etc).

If you want to count the number of iterations, you need to make a seperate counter variable.

You can either use generics or cast the variable explicitly in the loop. Otherwise all elements in the collection will just be Objects, and you can't use type specific methods on them.

## Break and continue

`break` stops the loop, `continue` skips the remaining statements and goes to check the condition again.

They are both used in conjunction with a conditional statement. If not, there can be a compiler error as the statements after `continue` or `break` are unreachable.

## Nested loops

Although it's possible, avoid nesting more than 2 levels because it becomes easy to make mistakes (which are often hard to spot).

> Exam tip: Some questions have up to 2 levels of loops, in this case run the whole thing through on pen and paper, step by step, keeping track of the variables.

### Breaking out of and continuing with nested loops

You can label the loops so that you can choose which to break out of. See the example:

```java
MY_OUTER_LOOP: for (int i = 0; i < groups.length; i++){
	for (String name : groups[i]){
		if ("bob".equals(name))
		break MY_OUTER_LOOP; // also works with continue
	}
}
```

The labeled break/labelled continue has to be within the label scope. You can only break or continue a statement you're inside.

> Note: come back to this exercise

#### Labels

A label is a name for a block of statements, or if/for/while/do-while/for-each/switch statements.

The convention is to use capital letters, but it's not a requirement.
You can label them without later using the label.

## Comparing loop constructs

- Use a for loop when you know the number of iterations beforehand
- Use a while loop when it's more dynamically decided whether to continue looping
- Use for-each on iterables
