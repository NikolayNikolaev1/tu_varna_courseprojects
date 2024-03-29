package rectangle;

public class ColorRectangle extends Color implements Comparable{
    private int iX1;
    private int iY1;
    private int iX2;
    private int iY2;

    public ColorRectangle() {
        super();
    }

    public ColorRectangle (int x1, int y1, int x2, int y2, long color) {
        super(color);
        this.setIX1(x1);
        this.setIY1(y1);
        this.setIX2(x2);
        this.setIY2(y2);
    }

    private int getIX1() {
        return this.iX1;
    }

    private int getIY1() {
        return this.iY1;
    }

    private int getIX2() {
        return this.iX2;
    }

    private int getIY2() {
        return this.iY2;
    }

    private void setIX1(int x1) {
        this.iX1 = x1;
    }

    private void setIY1(int y1) {
        this.iY1 = y1;
    }

    private void setIX2(int x2) {
        this.iX2 = x2;
    }

    private void setIY2(int y2) {
        this.iY2 = y2;
    }

    public int calcArea() {
        return Math.abs((this.iX2 - this.iX1) * (this.iY2 - this.iY1));
    }

    public int calcParamSum() {
        return this.iX1 + this.iY1 + this.iX2 + this.iY2;
    }

    /*public int compareTo(Object o) {
        return this.calcArea() < ((ColorRectangle)o).calcArea() ? -1 :
                this.calcArea() > ((ColorRectangle)o).calcArea() ? 1 : 0;
    }*/

    public int compareTo(Object o ) {
        if (this.equals((ColorRectangle) o)) {
            return 0;
        }

        if (this.isInside((ColorRectangle)o)) {
            return -1;
        }

        return 1;
    }

    public boolean equals(ColorRectangle rectangle) {
        return this.iX1 == rectangle.iX1
                && this.iY1 == rectangle.iY1
                && this.iX2 == rectangle.iX2
                && this.iY2 == rectangle.iY2;
    }

    public void translateX(int iPoints) {
        this.iX1 += iPoints;
        this.iX2 += iPoints;
    }

    public void translateY(int iPoints) {
        this.iY1 += iPoints;
        this.iY2 += iPoints;
    }

    public void translateXY(int iPoints) {
        this.translateX(iPoints);
        this.translateY(iPoints);
    }

    public boolean isInside(int ptX, int ptY) {
        return this.iX1 <= ptX && this.iX2 >= ptX &&
                this.iY1 <= ptY && this.iY2 >= ptY;
    }

    public boolean isInside(ColorRectangle secondRectangle) {
        return this.iX1 >= secondRectangle.iX1 &&
                this.iY1 >= secondRectangle.iY1 &&
                this.iX2 <= secondRectangle.iX2 &&
                this.iY2 <= secondRectangle.iY2;
    }

    public ColorRectangle unionRect(ColorRectangle r) {
        return new ColorRectangle(
                Math.min(this.iX1, r.iX1),
                Math.min(this.iY1, r.iY1),
                Math.max(this.iX2, r.iX2),
                Math.max(this.iY2, r.iY2),
                this.getColor() + r.getColor());
    }

    public ColorRectangle intersectionRect(ColorRectangle r) {
        /*return new Rectangle((this.iX1 < r.iX1) ? this.iX1 : r.iX1,
                (this.iY1 < r.iY1) ? this.iY1 : r.iY1,
                (this.iX2 > r.iX2) ? this.iX2 : r.iX2,
                (this.iY2 > r.iY2) ? this.iY2 : r.iY2);*/


        ColorRectangle secondRectangle = new ColorRectangle(
                /*(this.iX1 > r.iX1) ? this.iX1 : r.iX1,
                (this.iY1 > r.iY1) ? this.iY1 : r.iY1,
                (this.iX2 < r.iX2) ? this.iX2 : r.iX2,
                (this.iY2 > r.iY2) ? this.iY2 : r.iY2,*/
                Math.max(this.iX1, r.iX1),
                Math.max(this.iY1, r.iY1),
                Math.min(this.iX2, r.iX2),
                Math.min(this.iY2, r.iY2),
                this.getColor() + r.getColor());

        if (secondRectangle.iX1 >= secondRectangle.iX2) {
            secondRectangle.iX1 = 0;
            secondRectangle.iX2 = 0;
        }

        if (secondRectangle.iY1 >= secondRectangle.iY2) {
            secondRectangle.iY1 = 0;
            secondRectangle.iY2 = 0;
        }

        return secondRectangle;
    }

    public String toString() {
        return "X1: " + this.iX1 +
                " Y1: " + this.iY1 +
                " X2: " + this.iX2 +
                " Y2: " + this.iY2 +
                " Area: " + this.calcArea() +
                super.toString();
    }
}
