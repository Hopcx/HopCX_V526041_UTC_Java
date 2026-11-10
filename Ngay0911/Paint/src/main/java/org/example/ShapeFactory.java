package org.example;

import org.example.shape.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Sinh ngau nhien cac hinh. */
public class ShapeFactory {

    private static final String[] COLORS = {"Red", "Green", "Blue", "Yellow", "Black", "Pink"};
    private final Random random;

    public ShapeFactory() {
        this(new Random());
    }

    /** Truyen seed de ket qua lap lai duoc khi kiem thu. */
    public ShapeFactory(long seed) {
        this(new Random(seed));
    }

    private ShapeFactory(Random random) {
        this.random = random;
    }

    /** Lam tron 1 chu so thap phan cho de doc. */
    private double rand(double min, double max) {
        return Math.round((min + random.nextDouble() * (max - min)) * 10) / 10.0;
    }

    private Point randomPoint() {
        return new Point(rand(-10, 10), rand(-10, 10));
    }

    private String randomColor() {
        return COLORS[random.nextInt(COLORS.length)];
    }

    /** Tao 1 hinh ngau nhien thuoc 1 trong 6 loai. */
    public Shape randomShape() {
        String color = randomColor();
        switch (random.nextInt(6)) {
            case 0:
                return new Point(rand(-10, 10), rand(-10, 10), color);
            case 1:
                return new Circle(randomPoint(), rand(1, 6), color);
            case 2:
                return new Line(randomPoint(), randomPoint(), color);
            case 3:
                while (true) {   // lap lai den khi 3 diem khong thang hang
                    try {
                        return new Triangle(randomPoint(), randomPoint(), randomPoint(), color);
                    } catch (IllegalArgumentException ignored) {
                    }
                }
            case 4:
                return new Rectangle(randomPoint(), rand(1, 8), rand(1, 8), color);
            default:
                return new Square(randomPoint(), rand(1, 6), color);
        }
    }

    public List<Shape> randomShapes(int n) {
        List<Shape> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(randomShape());
        return list;
    }
}
