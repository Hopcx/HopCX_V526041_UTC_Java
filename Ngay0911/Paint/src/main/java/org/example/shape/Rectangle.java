package org.example.shape;

/**
 * Hinh chu nhat. Luu bang 4 dinh (ke thua tu Polygon) de co the xoay
 * duoc mot goc bat ky, khong chi nam ngang.
 * Thu tu dinh: topLeft -> topRight -> bottomRight -> bottomLeft.
 */
public class Rectangle extends Polygon {

    public Rectangle() {
        this(new Point(0, 0), 1, 1);
    }

    public Rectangle(Point topLeft, double width, double height) {
        this(topLeft, width, height, "Black");
    }

    public Rectangle(Point topLeft, double width, double height, String color) {
        super(color, buildVertices(topLeft, width, height));
    }

    private static Point[] buildVertices(Point tl, double w, double h) {
        if (tl == null) throw new IllegalArgumentException("Diem goc khong duoc null");
        if (w <= 0 || h <= 0) throw new IllegalArgumentException("Chieu dai/rong phai > 0");
        double x = tl.getX(), y = tl.getY();
        return new Point[]{
                new Point(x, y),
                new Point(x + w, y),
                new Point(x + w, y + h),
                new Point(x, y + h)
        };
    }

    public double getWidth() { return edge(0); }
    public double getHeight() { return edge(1); }

    /** Dat lai chieu rong, giu nguyen dinh topLeft va huong cua hinh. */
    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("Chieu rong phai > 0");
        resize(width, getHeight());
    }

    /** Dat lai chieu cao, giu nguyen dinh topLeft va huong cua hinh. */
    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Chieu cao phai > 0");
        resize(getWidth(), height);
    }

    private void resize(double w, double h) {
        Point p0 = vertices[0];
        // vector don vi theo huong canh rong (u) va canh cao (v)
        double ux = (vertices[1].getX() - p0.getX()) / getWidth();
        double uy = (vertices[1].getY() - p0.getY()) / getWidth();
        double vx = (vertices[3].getX() - p0.getX()) / getHeight();
        double vy = (vertices[3].getY() - p0.getY()) / getHeight();
        vertices[1] = new Point(p0.getX() + ux * w, p0.getY() + uy * w);
        vertices[3] = new Point(p0.getX() + vx * h, p0.getY() + vy * h);
        vertices[2] = new Point(vertices[1].getX() + vx * h, vertices[1].getY() + vy * h);
    }

    @Override
    public double area() { return getWidth() * getHeight(); }

    @Override
    public double perimeter() { return 2 * (getWidth() + getHeight()); }

    @Override
    protected String describe() {
        return "w=" + fmt(getWidth()) + ", h=" + fmt(getHeight()) + ", vertices=" + verticesString();
    }
}
