package org.example.shape;

/**
 * Lop truu tuong cho da giac (Triangle, Rectangle, ...).
 * Cai dat chung area/perimeter/move/rotate/zoom dua tren danh sach dinh.
 */
public abstract class Polygon extends AbstractShape {

    protected Point[] vertices;   // protected: lop con duoc truy cap truc tiep

    protected Polygon(String color, Point... vertices) {
        super(color);
        if (vertices == null || vertices.length < 3) {
            throw new IllegalArgumentException("Da giac can it nhat 3 dinh");
        }
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    /** Tra ve ban sao danh sach dinh. */
    public Point[] getVertices() {
        Point[] copy = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) copy[i] = new Point(vertices[i]);
        return copy;
    }

    /** Do dai canh thu i (noi dinh i va dinh i+1). */
    protected double edge(int i) {
        return vertices[i].distance(vertices[(i + 1) % vertices.length]);
    }

    /** Dien tich theo cong thuc Shoelace (Gauss). */
    @Override
    public double area() {
        double sum = 0;
        for (int i = 0; i < vertices.length; i++) {
            Point p = vertices[i], q = vertices[(i + 1) % vertices.length];
            sum += p.getX() * q.getY() - q.getX() * p.getY();
        }
        return Math.abs(sum) / 2;
    }

    @Override
    public double perimeter() {
        double sum = 0;
        for (int i = 0; i < vertices.length; i++) sum += edge(i);
        return sum;
    }

    /** Tam = trung binh cong toa do cac dinh. */
    @Override
    public Point getCenter() {
        double sx = 0, sy = 0;
        for (Point p : vertices) {
            sx += p.getX();
            sy += p.getY();
        }
        return new Point(sx / vertices.length, sy / vertices.length);
    }

    @Override
    public void move(double dx, double dy) {
        for (Point p : vertices) p.move(dx, dy);
    }

    @Override
    public void rotate(double angleDegree) {
        Point c = getCenter();
        for (Point p : vertices) p.rotate(angleDegree, c);
    }

    @Override
    public void zoom(double ratio) {
        Point c = getCenter();
        for (Point p : vertices) p.zoom(ratio, c);
    }

    /** Chuoi liet ke cac dinh. */
    protected String verticesString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < vertices.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(vertices[i].toCoord());
        }
        return sb.append("]").toString();
    }
}
