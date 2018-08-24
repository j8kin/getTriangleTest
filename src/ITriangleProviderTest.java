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
    public void getTriangleTest2() {
        ITriangle testTriangle = new Triangle(1, 0 , 1, 0, 1, 0);
        ITriangleProvider.setTriangle(testTriangle);

        assertFalse(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * This test verifies that if triangle is Right Triangle but rotated
     *  (OX or OY are not parallel into any triangle side)
     */
    @org.junit.Test
    public void getTriangleTest3() {
        ITriangle testTriangle = new Triangle(1, 4 , 6, 4, 1, 3);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 1st quarter
     */
    @org.junit.Test
    public void getTriangleTest4() {
        ITriangle testTriangle = new Triangle(2, 5 , 7, 5, 2, 4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 2nd quarter
     */
    @org.junit.Test
    public void getTriangleTest5() {
        ITriangle testTriangle = new Triangle(2, 5 , 7, -5, -2, -4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 3d quarter
     */
    @org.junit.Test
    public void getTriangleTest6() {
        ITriangle testTriangle = new Triangle(-2, -5 , -7, -5, -2, -4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in 4th quarter
     */
    @org.junit.Test
    public void getTriangleTest7() {
        ITriangle testTriangle = new Triangle(-2, -5 , -7, 5, 2, 4);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * The triangle is located in all 4 quarters
     */
    @org.junit.Test
    public void getTriangleTest8() {
        ITriangle testTriangle = new Triangle(-3, 0 , 2, 2, -1, 1);
        ITriangleProvider.setTriangle(testTriangle);

        assertTrue(RightTriangleVerifier.VerifyTriangle(ITriangleProvider.getTriangle()));
    }

    /**
     * Right Triangle which fill half of The Cartesian plane
     */
    @org.junit.Test
    public void getTriangleTest9() {
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
    public void getTriangleTest10() {
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
    public void getTriangleTest11() {
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
    public void getTriangleTest12() {
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
    public void getTriangleTest13() {
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
    public void getTriangleTest14() {
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
    public void getTriangleTest15() {
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