package org.example.shape;

/** Doan thang noi 2 diem start - end. */
public class Line extends AbstractShape {

    private Point start;
    private Point end;

    public Line() {
        this(new Point(0, 0), new Point(1, 0));
    }

    public Line(Point start, Point end) {
        this(start, end, "Black");
    }

    public Line(Point start, Point end, String color) {
        super(color);
        if (start == null || end == null) throw new IllegalArgumentException("Diem khong duoc null");
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public Point getStart() { return new Point(start); }
    public void setStart(Point start) { this.start = new Point(start); }
    public Point getEnd() { return new Point(end); }
    public void setEnd(Point end) { this.end = new Point(end); }

    public double length() { return start.distance(end); }

    @Override
    public double area() { return 0; }

    /** Chu vi cua doan thang duoc quy uoc bang do dai. */
    @Override
    public double perimeter() { return length(); }

    @Override
    public Point getCenter() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    @Override
    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    @Override
    public void rotate(double angleDegree) {
        Point c = getCenter();
        start.rotate(angleDegree, c);
        end.rotate(angleDegree, c);
    }

    @Override
    public void zoom(double ratio) {
        Point c = getCenter();
        start.zoom(ratio, c);
        end.zoom(ratio, c);
    }

    @Override
    protected String describe() {
        return start.toCoord() + " -> " + end.toCoord() + ", length=" + fmt(length());
    }
}
