public final class ITriangleProvider {
    // corners is created for testing purposes set it test
    private static ITriangle corners;

    /**
     * set Triangle method. Created for test purpose
     * @param inCorners corner to be returned by getTriangle
     */
    public static void setTriangle(ITriangle inCorners) {
        corners = inCorners;
    }

    /**
     * This method returns points on The Cartesian plane which
     * @return Cartesian plane which represents Right Triangle
     */
    public static ITriangle getTriangle() {
        return corners;
    }
}
