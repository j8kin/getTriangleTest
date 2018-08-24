import static org.junit.Assert.*;

public class ITriangleProviderTest {

    /**
     * This test scenario verify simple Right triangle (0,0); (0,1); (1,0)
     */
    @org.junit.Test
    public void getTriangleTest1() {
        ITriangle testTriangle = new Triangle(0, 0 , 1, 0, 1, 0);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * This test scenario verify that 2 of 3 points are the same then it returns false (since this is not a triangle)
     */
    @org.junit.Test
    public void getTriangleTestZeroVector() {
        ITriangle testTriangle = new Triangle(1, 0 , 1, 0, 1, 0);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * This test scenario verify that 3 points on the same line (line parallel OX)
     */
    @org.junit.Test
    public void getTriangleTestOnOneLine1() {
        ITriangle testTriangle = new Triangle(1, 3 , -7, -2, -2, -2);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * This test scenario verify that 3 points on the same line (line parallel OY)
     */
    @org.junit.Test
    public void getTriangleTestOnOneLine2() {
        ITriangle testTriangle = new Triangle(2, 2 , 2, -5, 0, 5);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * This test scenario verify that 3 points on the same line (line 45 degree from OX)
     */
    @org.junit.Test
    public void getTriangleTestOnOneLine3() {
        ITriangle testTriangle = new Triangle(1, 2 , 3, 1, 2, 3);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * This test scenario verify that 3 points on the same line
     */
    @org.junit.Test
    public void getTriangleTestOnOneLine4() {
        ITriangle testTriangle = new Triangle(1, 2 , 3, 1, 3, 5);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }
    /**
     * Any of 3 side of Right Triangle is not parallel to OX and OY
     */
    @org.junit.Test
    public void getTriangleTestNonParallel() {
        ITriangle testTriangle = new Triangle(1, 4 , 6, 4, 1, 3);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 1st quarter
     */
    @org.junit.Test
    public void getTriangleTestQuarter1() {
        ITriangle testTriangle = new Triangle(2, 5 , 7, 5, 2, 4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 2nd quarter
     */
    @org.junit.Test
    public void getTriangleTestQuarter2() {
        ITriangle testTriangle = new Triangle(2, 5 , 7, -5, -2, -4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 3d quarter
     */
    @org.junit.Test
    public void getTriangleTestQuarter3() {
        ITriangle testTriangle = new Triangle(-2, -5 , -7, -5, -2, -4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 4th quarter
     */
    @org.junit.Test
    public void getTriangleTestQuarter4() {
        ITriangle testTriangle = new Triangle(-2, -5 , -7, 5, 2, 4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in all 4 quarters
     */
    @org.junit.Test
    public void getTriangleTestQuarter5() {
        ITriangle testTriangle = new Triangle(-3, 0 , 2, 2, -1, 1);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Right Triangle which fill half of The Cartesian plane
     */
    @org.junit.Test
    public void getTriangleTestBigNumber1() {
        ITriangle testTriangle = new Triangle(-Integer.MAX_VALUE,
                                              -Integer.MAX_VALUE,
                                               Integer.MAX_VALUE,
                                               Integer.MAX_VALUE,
                                              -Integer.MAX_VALUE,
                                              -Integer.MAX_VALUE);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Right Triangle (-MAX_INT, 0) (0, -MAX_INT) (MAX_INT, 0)
     */
    @org.junit.Test
    public void getTriangleTestBigNumber2() {
        ITriangle testTriangle = new Triangle(-Integer.MAX_VALUE,
                0,
                Integer.MAX_VALUE,
                0,
                -Integer.MAX_VALUE,
                0);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Right Triangle (100-MAX_INT, 0) (0, 100-MAX_INT) (MAX_INT-100, 0)
     */
    @org.junit.Test
    public void getTriangleTestBigNumber3() {
        ITriangle testTriangle = new Triangle(100-Integer.MAX_VALUE,
                0,
                Integer.MAX_VALUE-100,
                0,
                100-Integer.MAX_VALUE,
                0);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Test that if x coordinate from getTriangleTest11 of X1 point has changed then it will return false
     *  since it is not a Right Triangle
     * Right Triangle (99-MAX_INT, 0) (0, 100-MAX_INT) (MAX_INT-100, 0)
     */
    @org.junit.Test
    public void getTriangleTestBigNumber4() {
        ITriangle testTriangle = new Triangle(99-Integer.MAX_VALUE,
                0,
                Integer.MAX_VALUE-100,
                0,
                100-Integer.MAX_VALUE,
                0);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Test that if x coordinate from getTriangleTest11 of Y1 point has changed then it will return false
     *  since it is not a Right Triangle
     * Right Triangle (100-MAX_INT, 1) (0, 100-MAX_INT) (MAX_INT-100, 0)
     */
    @org.junit.Test
    public void getTriangleTestBigNumber5() {
        ITriangle testTriangle = new Triangle(100-Integer.MAX_VALUE,
                0,
                Integer.MAX_VALUE-100,
                1,
                100-Integer.MAX_VALUE,
                0);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Test that if x coordinate from getTriangleTest11 of Y3 point has changed then it will return false
     *  since it is not a Right Triangle
     * Right Triangle (100-MAX_INT, 0) (0, 100-MAX_INT) (MAX_INT-100, -1)
     */
    @org.junit.Test
    public void getTriangleTestBigNumber6() {
        ITriangle testTriangle = new Triangle(100-Integer.MAX_VALUE,
                0,
                Integer.MAX_VALUE-100,
                0,
                100-Integer.MAX_VALUE,
                -1);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Right Triangle (-MAX_INT, 0) (0, MAX_INT) (MAX_INT, 0)
     */
    @org.junit.Test
    public void getTriangleTestBigNumber7() {
        ITriangle testTriangle = new Triangle(-Integer.MAX_VALUE,
                0,
                Integer.MAX_VALUE,
                0,
                Integer.MAX_VALUE,
                0);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }
}