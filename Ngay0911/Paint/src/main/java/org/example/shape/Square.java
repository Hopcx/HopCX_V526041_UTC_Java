package org.example.shape;

/** Hinh vuong: truong hop dac biet cua hinh chu nhat (width = height). */
public class Square extends Rectangle {

    public Square() {
        this(new Point(0, 0), 1);
    }

    public Square(Point topLeft, double side) {
        this(topLeft, side, "Black");
    }

    public Square(Point topLeft, double side, String color) {
        super(topLeft, side, side, color);
    }

    public double getSide() { return getWidth(); }

    public void setSide(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    /** Giu tinh chat hinh vuong: doi rong thi doi luon cao. */
    @Override
    public void setWidth(double width) { setSide(width); }

    @Override
    public void setHeight(double height) { setSide(height); }

    @Override
    protected String describe() {
        return "side=" + fmt(getSide()) + ", vertices=" + verticesString();
    }
}
