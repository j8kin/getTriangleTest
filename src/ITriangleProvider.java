public final class ITriangleProvider {
    public static ITriangle getTriangle() {
        return new ITriangle() {
            @Override
            public int getX1() {
                return 0;
            }

            @Override
            public int getX2() {
                return 0;
            }

            @Override
            public int getX3() {
                return 0;
            }

            @Override
            public int getY1() {
                return 0;
            }

            @Override
            public int getY2() {
                return 0;
            }

            @Override
            public int getY3() {
                return 0;
            }
        };
    }
}
