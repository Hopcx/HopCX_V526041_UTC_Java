package org.example.shape;

/**
 * Lop truu tuong cai dat san nhung phan dung chung cho moi hinh:
 *  - Thuoc tinh mau sac (color)
 *  - distance(): tinh qua tam cua 2 hinh
 *  - Kiem tra ti le zoom hop le
 *  - Dinh dang so khi in ra
 * Cac lop con chi can cai dat phan rieng (area, perimeter, move, ...).
 */
public abstract class AbstractShape implements Shape {

    private String color;   // private: chi truy cap qua getter/setter

    protected AbstractShape() {
        this("Black");
    }

    protected AbstractShape(String color) {
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = (color == null || color.isBlank()) ? "Black" : color;
    }

    @Override
    public double distance(Shape other) {
        if (other == null) {
            throw new IllegalArgumentException("Hinh so sanh khong duoc null");
        }
        Point c1 = this.getCenter();
        Point c2 = other.getCenter();
        return Math.hypot(c1.getX() - c2.getX(), c1.getY() - c2.getY());
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    /** Kiem tra ti le zoom - dung chung cho moi lop con. */
    protected static void checkRatio(double ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ti le zoom phai > 0, nhan duoc: " + ratio);
        }
    }

    /** Dinh dang so thuc 2 chu so thap phan. */
    protected static String fmt(double v) {
        return String.format("%.2f", v);
    }

    @Override
    public String toString() {
        return String.format("%-9s| color=%-6s| area=%9s | perimeter=%8s | %s",
                getName(), color, fmt(area()), fmt(perimeter()), describe());
    }

    /** Mo ta rieng cua tung hinh (toa do, kich thuoc...) - lop con cai dat. */
    protected abstract String describe();
}
