package org.example.shape;

/**
 * Interface Shape - "hop dong" chung cho moi hinh trong ung dung Paint.
 * Gom 2 nhom phuong thuc:
 *  - Nhom tinh toan: area, perimeter, distance, getCenter
 *  - Nhom bien doi : move, rotate, zoom
 */
public interface Shape {

    // ================= NHOM TINH TOAN =================

    /** Dien tich cua hinh. */
    double area();

    /** Chu vi cua hinh. */
    double perimeter();

    /** Tam (trong tam) cua hinh - dung lam goc cho distance/rotate/zoom. */
    Point getCenter();

    /** Khoang cach giua tam hinh nay va tam hinh khac. */
    double distance(Shape other);

    // ================= NHOM BIEN DOI =================

    /** Tinh tien hinh theo vector (dx, dy). */
    void move(double dx, double dy);

    /** Xoay hinh quanh tam cua no mot goc (don vi: do, nguoc chieu kim dong ho). */
    void rotate(double angleDegree);

    /** Phong to / thu nho hinh quanh tam voi ti le ratio (ratio > 0). */
    void zoom(double ratio);

    // ================= THONG TIN =================

    /** Ten loai hinh (Point, Circle, Line, ...). */
    String getName();
}
