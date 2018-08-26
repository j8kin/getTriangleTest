/**
 * This class is created to verify that Triangle defined by corners point on The Cartesian plane
 *   are Right Triangle.
 * It is necessary to verify that one of the angle in triangle is 90 deg.
 * Since it is Cartesian plane then if Tangent between OX, OY and Triangle one side of an angel is
 * equal to Cotangent of a Triangle between OX, OY and another side of the triangle.
 *
 */
class RightTriangleVerifier {

    /**
     * Calculate greatest common divisor of two input numbers
     * @param first first number
     * @param second second number
     * @return greatest common divisor
     */
    private static int getGCD(int first, int second) {
        // find positive GCD that is why convert input to positive values
        if (first < 0)
            first *= -1;
        if (second < 0)
            second *= -1;

        // use Euler's algorithm to find GCD
        while (first !=0 && second != 0)
            if (first > second)
                first = first % second;
            else
                second = second % first;

        return first+second;
    }

    /**
     * Verify that angle between sides ((X1,Y1); (X2,Y2)) and ((X1,Y1);(X3,Y3)) is 90 deg
     * @param X1 x coordinate of the first point
     * @param Y1 y coordinate of the first point
     * @param X2 x coordinate of the second point
     * @param Y2 y coordinate of the second point
     * @param X3 x coordinate of the third point
     * @param Y3 y coordinate of the third point
     * @return true if angle is 90 deg
     */
    private static boolean verifyRightAngle(int X1, int Y1, int X2, int Y2, int X3, int Y3) {
        // the Triangle will be Right Triangle if for one of the triangle angle
        // tangent between one side of and OX is equal cotangent of another side and OX
        // Lets consider 2 Right Triangles:
        //   the first one is created by OX axis, OY axis and side between (X1,Y1) and (X2, Y2)
        //   the second is created by OX axis, OY axis and side between (X1,Y1) and (X3, Y3)
        // Now we need to find length of catheters for both Triangles:
        //   First Triangle: a1 = |X1-X2| b1 = |Y1-Y2|
        //   Second Triangle: a2 = |X1-X3| b2 = |Y1-Y3|
        // Catheters length could be pretty big to avoid working with big numbers and integer overflow
        //   lets find greatest common divisor for each pair of catheters and divide related catheter length on it:
        //   normA1 = a1/GCD(a1,b1) normB1 = b1/GCD(a1,b1)
        //   normA2 = a2/GCD(a2,b2) normB2 = b2/GCD(a2,b2)
        // Tangent of the first triangle for point (X1,Y1) is equal to normB1/normA1
        // Cotangent of the second triangle for point (X1,Y1) is equal to normA2/normB2
        // Angle of point (X1,Y1) will be 90 deg if normB1/normA1 = normA2/normB2
        // Which means that 1normB1 = normA2 and normA1 = normB2

        // first Right Triangle is formed by OX axis, OY axis and (X1,Y1) and (X2, Y2)
        // first Right Triangle is formed by OX axis, OY axis and (X1,Y1) and (X3, Y3)
        int T1C1 = java.lang.Math.abs(X1-X2); // Catheter 1 of Triangle 1
        int T1C2 = java.lang.Math.abs(Y1-Y2); // Catheter 2 of Triangle 2
        int T2C1 = java.lang.Math.abs(X1-X3); // Catheter 1 of Triangle 2
        int T2C2 = java.lang.Math.abs(Y1-Y3); // Catheter 2 of Triangle 2

        int GCD = getGCD(T1C1,T1C2); // greatest common divisor
        T1C1 = T1C1/GCD; // normalize catheter length
        T1C2 = T1C2/GCD; // normalize catheter length

        GCD = getGCD(T2C1,T2C2); // greatest common divisor
        T2C1 = T2C1/GCD; // normalize catheter length
        T2C2 = T2C2/GCD; // normalize catheter length

        return ((T1C1 == T2C2) && (T1C2 == T2C1));
    }

    /**
     * Verify that Triangle is Right Triangle
     * @param corners 3 points on The Cartesian plane which defines Triangle
     * @return true if triangle is Right Triangle and false otherwise
     */
    static boolean VerifyTriangle(ITriangle corners) {
        // first verify that all these 3 points are not on one line and this is triangle not a line
        // line equation from 2 points:
        // (x - x1)      (y - y1)
        // --------   =  --------
        // (x2 - x1)     (y2 - y1)
        // if  (x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1) then point are on a line and this is not a triangle
        if (((corners.getX3() - corners.getX1()) * (corners.getY2() - corners.getY1())) ==
                ((corners.getY3() - corners.getY1()) * (corners.getX2() - corners.getX1()))) {
            return false;
        }

        // verify that line ((X1,Y1);(X2,Y2)) is perpendicular to line ((X1,Y1);(X3,Y3))
        if (verifyRightAngle(corners.getX1(),corners.getY1(),corners.getX2(),corners.getY2(),corners.getX3(),corners.getY3()))
            return true;

        // verify that line ((X2,Y2);(X3,Y3)) is perpendicular to line ((X2,Y2);(X1,Y1))
        if (verifyRightAngle(corners.getX2(),corners.getY2(),corners.getX3(),corners.getY3(),corners.getX1(),corners.getY1()))
            return true;

        // verify that line ((X3,Y3);(X2,Y2)) is perpendicular to line ((X1,Y1);(X2,Y2))
        if (verifyRightAngle(corners.getX3(),corners.getY3(),corners.getX1(),corners.getY1(),corners.getX2(),corners.getY2()))
            return true;

        return false;
    }
}
