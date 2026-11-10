package org.example.shape;

/** Tam giac voi 3 dinh A, B, C. */
public class Triangle extends Polygon {

    public Triangle() {
        this(new Point(0, 0), new Point(3, 0), new Point(0, 4));
    }

    public Triangle(Point a, Point b, Point c) {
        this(a, b, c, "Black");
    }

    public Triangle(Point a, Point b, Point c, String color) {
        super(color, a, b, c);
        if (area() < 1e-9) {
            throw new IllegalArgumentException("3 diem thang hang, khong tao thanh tam giac");
        }
    }

    public Point getA() { return new Point(vertices[0]); }
    public Point getB() { return new Point(vertices[1]); }
    public Point getC() { return new Point(vertices[2]); }

    public void setA(Point a) { setVertex(0, a); }
    public void setB(Point b) { setVertex(1, b); }
    public void setC(Point c) { setVertex(2, c); }

    private void setVertex(int i, Point p) {
        Point old = vertices[i];
        vertices[i] = new Point(p);
        if (area() < 1e-9) {          // khong cho phep tam giac suy bien
            vertices[i] = old;
            throw new IllegalArgumentException("3 diem thang hang, khong tao thanh tam giac");
        }
    }

    @Override
    protected String describe() {
        return "A=" + vertices[0].toCoord() + ", B=" + vertices[1].toCoord() + ", C=" + vertices[2].toCoord();
    }
}
