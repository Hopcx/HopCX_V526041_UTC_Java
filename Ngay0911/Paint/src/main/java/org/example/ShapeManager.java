package org.example;

import org.example.shape.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Quan ly danh sach hinh. Chi lam viec qua interface Shape
 * (da hinh) nen khong can biet hinh cu the la gi.
 */
public class ShapeManager {

    private final List<Shape> shapes = new ArrayList<>();

    public void add(Shape s) {
        if (s != null) shapes.add(s);
    }

    public void addAll(List<Shape> list) {
        for (Shape s : list) add(s);
    }

    public void clear() { shapes.clear(); }

    public int size() { return shapes.size(); }

    /** Danh sach chi doc, tranh bi sua tu ben ngoai. */
    public List<Shape> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    public void display() {
        if (shapes.isEmpty()) {
            System.out.println("  (Danh sach rong)");
            return;
        }
        for (int i = 0; i < shapes.size(); i++) {
            System.out.printf("  %2d. %s%n", i + 1, shapes.get(i));
        }
    }

    // ---------- Thong ke ----------
    public double totalArea() {
        double sum = 0;
        for (Shape s : shapes) sum += s.area();
        return sum;
    }

    public double totalPerimeter() {
        double sum = 0;
        for (Shape s : shapes) sum += s.perimeter();
        return sum;
    }

    public Shape maxArea() {
        return shapes.isEmpty() ? null : Collections.max(shapes, Comparator.comparingDouble(Shape::area));
    }

    public Shape minArea() {
        return shapes.isEmpty() ? null : Collections.min(shapes, Comparator.comparingDouble(Shape::area));
    }

    /** Cap 2 hinh co tam xa nhau nhat. */
    public Shape[] farthestPair() {
        Shape[] best = null;
        double max = -1;
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                double d = shapes.get(i).distance(shapes.get(j));
                if (d > max) {
                    max = d;
                    best = new Shape[]{shapes.get(i), shapes.get(j)};
                }
            }
        }
        return best;
    }

    public void sortByArea() {
        shapes.sort(Comparator.comparingDouble(Shape::area));
    }

    // ---------- Bien doi ----------
    public void zoomAll(double ratio) {
        for (Shape s : shapes) s.zoom(ratio);
    }

    public void moveAll(double dx, double dy) {
        for (Shape s : shapes) s.move(dx, dy);
    }

    public void rotateAll(double angle) {
        for (Shape s : shapes) s.rotate(angle);
    }
}
