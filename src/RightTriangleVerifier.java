/**
 * This class is created to verify that Triangle defined by corners point on The Cartesian plane
 *   are Right Triangle.
 * The verification is based on the following principles:
 *   1. The Triangle is Right only if one of the corner is 90 deg.
 *   2. cos 90 deg is equal to 0
 *   3. scalar vectors multiplication is equal: <a,b>  = |a| * |b| * cos(Angle between a and b)
 *   4. scalar multiplication of 2 non-zero vectors equal to ZERO only if corner between them is 90 degree (or 270)
 *
 * Algorithm:
 *  1. calculate 3 vectors based on points (AB = {X1 - X2, Y1 - Y2}, AC = {X1-X3, Y1-Y3}, BC={X2-X3,Y2-Y3})
 *  2. if any vector is zero-vector return false
 *  3. for each pair of vector calculate scalar multiplication of these vectors:
 *       V1*V2 = V1x * V2x + V1y*V2y
 *  3.1 if any of scalar multiplication equal 0 then return true
 *  3.2. otherwise return false
 *
 * IMPORTANT NOTICE:
 *   Use this algorithm instead of using c2 = a2+b2 to avoid using floating point
 *     and avoid problem with compare floating point variables
 */
class RightTriangleVerifier {
    /**
     * Verify that Triangle is Right Triangle
     * @param corners 3 points on The Cartesian plane which defines Triangle
     * @return true if triangle is Right Triangle and false otherwise
     */
    static boolean VerifyTriangle(ITriangle corners) {
        // calculate 3 vectors
        int[] V1 = {corners.getX1() - corners.getX2(), corners.getY1() - corners.getY2()};
        int[] V2 = {corners.getX1() - corners.getX3(), corners.getY1() - corners.getY3()};
        int[] V3 = {corners.getX2() - corners.getX3(), corners.getY2() - corners.getY3()};

        int scalarMultRes;

        // verify that there are no zero-vectors
        if ((V1[0] == 0 && V1[1] == 0) ||
            (V2[0] == 0 && V2[1] == 0) ||
            (V3[0] == 0 && V3[1] == 0)) {
            return false;
        }

        scalarMultRes = V1[0]*V2[0] + V1[1]*V2[1];
        if (scalarMultRes == 0)
            return true;

        scalarMultRes = V1[0]*V3[0] + V1[1]*V3[1];
        if (scalarMultRes == 0)
            return true;

        scalarMultRes = V2[0]*V3[0] + V2[1]*V3[1];
        if (scalarMultRes == 0)
            return true;

        return false;
    }
}
