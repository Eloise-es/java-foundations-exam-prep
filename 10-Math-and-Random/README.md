# Math and Random classes

- Use Math class
- use Random class

## Math

- `Math.abs()` - returns positive value (returns same type)
- `Math.ceil()` - rounds up to closest whole number (returns same type)
- `Math.floor()` - rounds down to closest whole number (returns same type)
- `Math.round()` - closest whole number --> rounds double to long, and float to int
  - ties round to positive infinity (1.5 --> 2 BUT -1.5 --> -1)
- `Math.random()` - returns a random double greater than 0.0 and less than 1.0

```java
int i = (int) (Math.random()*10); // random int between 0 to 9 inclusive
long l = Math.round(Math.random()*10); // random long (no need to cast as Math.round(double) returns a long)
```

## Random

More comprehensive, more complicated solution to the problem of generating random numbers.

- generates pseudorandom numbers
  - don't qualify as truly random, but random enough for most purposes
- can either use no-args constructor or seed parameter
- if the seed is the same for two Random objects, they will produce the same random numbers
