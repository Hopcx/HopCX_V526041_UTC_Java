package org.example.shape;

/** Hinh tron: tam + ban kinh. */
public class Circle extends AbstractShape {

    private Point center;
    private double radius;

    public Circle() {
        this(new Point(), 1);
    }

    public Circle(Point center, double radius) {
        this(center, radius, "Black");
    }

    public Circle(Point center, double radius, String color) {
        super(color);
        setCenter(center);
        setRadius(radius);
    }

    @Override
    public Point getCenter() { return new Point(center); }   // tra ve ban sao de bao ve du lieu

    public void setCenter(Point center) {
        if (center == null) throw new IllegalArgumentException("Tam khong duoc null");
        this.center = new Point(center);
    }

    public double getRadius() { return radius; }

    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Ban kinh phai > 0");
        this.radius = radius;
    }

    @Override
    public double area() { return Math.PI * radius * radius; }

    @Override
    public double perimeter() { return 2 * Math.PI * radius; }

    @Override
    public void move(double dx, double dy) { center.move(dx, dy); }

    /** Xoay hinh tron quanh tam: hinh khong thay doi. */
    @Override
    public void rotate(double angleDegree) { }

    @Override
    public void zoom(double ratio) {
        checkRatio(ratio);
        radius *= ratio;
    }

    @Override
    protected String describe() {
        return "center=" + center.toCoord() + ", r=" + fmt(radius);
    }
}
