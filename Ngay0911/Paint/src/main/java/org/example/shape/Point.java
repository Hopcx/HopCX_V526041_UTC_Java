package org.example.shape;

/**
 * Diem trong mat phang. Vua la 1 hinh (Shape) vua la "vien gach" de
 * xay dung cac hinh khac (Line, Triangle, Rectangle...).
 */
public class Point extends AbstractShape {

    private double x;
    private double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, String color) {
        super(color);
        this.x = x;
        this.y = y;
    }

    /** Constructor sao chep. */
    public Point(Point other) {
        this(other.x, other.y, other.getColor());
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    // ---------- Tinh toan ----------
    @Override
    public double area() { return 0; }

    @Override
    public double perimeter() { return 0; }

    @Override
    public Point getCenter() { return new Point(x, y); }

    /** Khoang cach toi 1 diem khac (overload). */
    public double distance(Point other) {
        return Math.hypot(x - other.x, y - other.y);
    }

    // ---------- Bien doi ----------
    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /** Xoay quanh chinh no -> khong doi vi tri. */
    @Override
    public void rotate(double angleDegree) {
        // Diem xoay quanh chinh no thi khong thay doi
    }

    /** Xoay diem quanh 1 diem tam (pivot) - dung cho cac hinh khac. */
    public void rotate(double angleDegree, Point pivot) {
        double rad = Math.toRadians(angleDegree);
        double cos = Math.cos(rad), sin = Math.sin(rad);
        double dx = x - pivot.x, dy = y - pivot.y;
        x = pivot.x + dx * cos - dy * sin;
        y = pivot.y + dx * sin + dy * cos;
    }

    /** Zoom quanh chinh no -> khong doi. */
    @Override
    public void zoom(double ratio) {
        checkRatio(ratio);
    }

    /** Phong to diem so voi 1 tam (pivot) - dung cho cac hinh khac. */
    public void zoom(double ratio, Point pivot) {
        checkRatio(ratio);
        x = pivot.x + (x - pivot.x) * ratio;
        y = pivot.y + (y - pivot.y) * ratio;
    }

    @Override
    protected String describe() {
        return toCoord();
    }

    /** Chuoi toa do ngan gon "(x, y)". */
    public String toCoord() {
        return "(" + fmt(x) + ", " + fmt(y) + ")";
    }
}
