/**
 * Implement simple Triangle interface for testing purposes
 */
public class Triangle implements ITriangle {
    private int X1;
    private int X2;
    private int X3;
    private int Y1;
    private int Y2;
    private int Y3;


    /**
     * Default constructor which initialize Triangle corners points
     * @param X1 - x of point 1
     * @param X2 - x of point 2
     * @param X3 - x of point 3
     * @param Y1 - y of point 1
     * @param Y2 - y of point 2
     * @param Y3 - y of point 3
     */
    Triangle(int X1, int X2, int X3, int Y1, int Y2, int Y3)
    {
        this.X1 = X1;
        this.X2 = X2;
        this.X3 = X3;
        this.Y1 = Y1;
        this.Y2 = Y2;
        this.Y3 = Y3;
    }

    @Override
    public int getX1() {
        return X1;
    }

    @Override
    public int getX2() {
        return X2;
    }

    @Override
    public int getX3() {
        return X3;
    }

    @Override
    public int getY1() {
        return Y1;
    }

    @Override
    public int getY2() {
        return Y2;
    }

    @Override
    public int getY3() {
        return Y3;
    }
}
