# getTriangleTest
There is a public class ITriangleProvider which contains method public static ITriangle getTriangle().
```
public interface ITriangle {
    int getX1();
    int getX2();
    int getX3();
    int getY1();
    int getY2();
    int getY3();
}
```
Write JUnit tests which verifies that getTriangle return coordinates on the Cartesian plane of 3 point which creates Right Triangle.
============
Assuption:
since getTriangle dont have input parameters and no other information about ITriangleProvider I assume that it could be setTriangle mathod which allow to set output of getTriangle method to be able to provide variable input into a test.

I use algorithm with multiplication and additions to avoid floating point calculations.
Another solution could be based on Pifagor Theorem c^2 = a^2 + b^2

Additionaly verified that algorithm working when Triangle is big (TestCases 9-16)
