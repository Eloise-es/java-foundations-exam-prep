# Java Methods

## Creating a method

### Return type

- Can only return one thing at the most
- must match what the method returns
- Options: `void`, `int`, `byte`, `short`, `char`, `float`, `double`, `String` / any other reference type

### Method name

- usually camel case with lowercase first letter
- cannot be reserved word, must begin with java letter

### Parameters

- each parameter declaration = type and identifier
- parameters may be defined as final if the method doesn't change their value
  - will fail to compile if the method body tries to change a final parameter

### Method body

- code to be executed upon method invocation
- must be in curly braces

## Returning a value from a method

- not possible to return a value conditionally
  - error: missing return statement
- if the return type is a reference type, it may return `null`
- the only way to not return a value is if it throws an exception
- `void` methods must not return anything
  - `return;` is allowed in void methods though

### Exceptions to the rule of always returning the same type

#### 1. Numeric promotion

- If the return type is numeric, a smaller type will be promoted to the return type
  - e.g. returning a `byte` from an `int` method

#### 2. Autoboxing / Unboxing

- the return value can be a reference to a wrapper class if the return type is of a primitive of the same or larger type
  - e.g. a `Short` can be returned from an int method, and an `int` from an `Integer` method
  - they will be boxed or unboxed to match the return type

#### 3. Covariant return types

- related to inheritance
  - e.g. a `String` can be returned from a `Object` method as a `String` is also an `Object`

#### Returning multiple values

- Not possible!!! Use a class and return an object.

### `varargs`

If you know the type of arguments but not the number that will be passed in.

```java
// WITHOUT VARARGS
public double average(int[] values) {
	double sum = 0;
	for(int i=0; i<values.length; i++) sum += values;
	return values.length==0?0 : sum/values.length;
}
// calling the method:
int[] values = {1,2,3,4};
double average = average(values);
```

This is a bit annoying to use, so varargs was created:

```java
// WITH VARARGS
public double average(int... values) {
	double sum = 0;
	for(int i=0; i<values.length; i++) sum += values;
	return values.length==0?0 : sum/values.length;
}

// calling the method:
double average = average(1, 2, 3, 4);
```

#### Restrictions on varargs

If we use multiple varargs of the same type at once, the compiler doesn't know how to group them.

So the rules are:

- no more than one varargs parameter
- the varargs param must be the last one

## Overloading methods

### Method signature

Like the id of a method. e.g.

```java
void process(int a, String str)
public void process(int weight, String animal)
private int process(int size, String name)
```

ALL have the signature **process(int, String)** so the compiler will complain.

### Overloading

The compiler sees them as different methods completely, but it can make life easier for the developer to overload.

- e.g. `System.out.println()` is heavily overloaded, which is why we can pass it basically anything we like.

It can cause problems if the compiler can't figure out what to do with a method call as two methods could apply.

#### Method selection

This is how the compiler selects which method to use:

1. As long as they have different method signatures, there is no problem with them being similar, they will compile fine
   - Java specifies the following rules to disambiguate method calls
2. Exact match
   - A String is both a String and an Object, but the compiler will choose the method which takes a String as it's an exact match
3. Most specific method
   - A String is both an Object and a CharSequence, but the compiler chooses the more specific one (CharSequence)
   - This means the one closer to the type being passed
4. Consider widening before autoboxing
   - A `byte` will pick `method(short value)` over `method(Byte value)`
5. Consider autoboxing before varargs
   - An `int` will pick `method(Integer value)` over `method(int... value)`

> Exam tip: Likely to get one question on this. If it's too hard just skip it.

## Passing into methods

### Pass-by-value

The variable isn't passed, the value is. So the method cannot change the variables that are passed as parameters.

#### Primitive values

The value is a primitive. It is copied, so the original variable is not changed when passed in as a parameter.

#### Reference values

The value is a memory location. This is copied, but still points to the same object. Therefore, the object is changed.

You can avoid this happening by creating a new object:

```java
public static void modifyData(Data z) {
	z = new Data(); // make new object, z now points at this object
	z.value = 2 * z.value; // doesn't change original
}
```

#### Returning a value from a method

This is also pass-by-value, so if it's a reference variable the memory location is returned.

## The static keyword
