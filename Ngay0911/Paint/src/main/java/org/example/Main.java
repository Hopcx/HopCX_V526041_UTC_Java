package org.example;

import org.example.shape.Shape;

import java.util.Scanner;

/** Chuong trinh chinh - menu quan ly cac hinh trong ung dung Paint. */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ShapeManager manager = new ShapeManager();
    private static final ShapeFactory factory = new ShapeFactory();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Chon chuc nang: ");
            System.out.println();
            switch (choice) {
                case 1: createRandom(); break;
                case 2: display(); break;
                case 3: statistics(); break;
                case 4: zoom(); break;
                case 5: move(); break;
                case 6: rotate(); break;
                case 7: sortByArea(); break;
                case 8: farthest(); break;
                case 0: System.out.println("Tam biet!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("============== PAINT - QUAN LY HINH ==============");
        System.out.println(" 1. Tao ngau nhien danh sach hinh");
        System.out.println(" 2. Hien thi danh sach hinh");
        System.out.println(" 3. Tong chu vi / dien tich, hinh lon nhat / nho nhat");
        System.out.println(" 4. Phong to (zoom) cac hinh theo ti le ratio");
        System.out.println(" 5. Tinh tien (move) cac hinh");
        System.out.println(" 6. Xoay (rotate) cac hinh");
        System.out.println(" 7. Sap xep theo dien tich tang dan");
        System.out.println(" 8. Tim 2 hinh co tam xa nhau nhat");
        System.out.println(" 0. Thoat");
        System.out.println("==================================================");
    }

    private static void createRandom() {
        int n = readInt("Nhap so luong hinh can tao: ");
        if (n <= 0) {
            System.out.println("So luong phai > 0");
            return;
        }
        manager.clear();
        manager.addAll(factory.randomShapes(n));
        System.out.println("Da tao " + n + " hinh ngau nhien:");
        manager.display();
    }

    private static void display() {
        System.out.println("DANH SACH HINH (" + manager.size() + "):");
        manager.display();
    }

    private static void statistics() {
        if (isEmpty()) return;
        System.out.printf("Tong chu vi   : %.2f%n", manager.totalPerimeter());
        System.out.printf("Tong dien tich: %.2f%n", manager.totalArea());
        System.out.println("Hinh co dien tich LON nhat:\n  " + manager.maxArea());
        System.out.println("Hinh co dien tich NHO nhat:\n  " + manager.minArea());
    }

    private static void zoom() {
        if (isEmpty()) return;
        double ratio = readDouble("Nhap ti le ratio (> 0): ");
        try {
            double before = manager.totalArea();
            manager.zoomAll(ratio);
            System.out.printf("Da zoom x%.2f. Tong dien tich: %.2f -> %.2f%n", ratio, before, manager.totalArea());
            manager.display();
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private static void move() {
        if (isEmpty()) return;
        double dx = readDouble("Nhap dx: ");
        double dy = readDouble("Nhap dy: ");
        manager.moveAll(dx, dy);
        System.out.println("Da tinh tien theo vector (" + dx + ", " + dy + "):");
        manager.display();
    }

    private static void rotate() {
        if (isEmpty()) return;
        double angle = readDouble("Nhap goc xoay (do): ");
        manager.rotateAll(angle);
        System.out.println("Da xoay " + angle + " do quanh tam moi hinh:");
        manager.display();
    }

    private static void sortByArea() {
        if (isEmpty()) return;
        manager.sortByArea();
        System.out.println("Da sap xep theo dien tich tang dan:");
        manager.display();
    }

    private static void farthest() {
        if (manager.size() < 2) {
            System.out.println("Can it nhat 2 hinh!");
            return;
        }
        Shape[] pair = manager.farthestPair();
        System.out.printf("Khoang cach lon nhat: %.2f%n", pair[0].distance(pair[1]));
        System.out.println("  " + pair[0]);
        System.out.println("  " + pair[1]);
    }

    // ---------- Ham tien ich nhap lieu ----------
    private static boolean isEmpty() {
        if (manager.size() == 0) {
            System.out.println("Danh sach rong! Hay tao hinh truoc (chuc nang 1).");
            return true;
        }
        return false;
    }

    private static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            if (!sc.hasNextLine()) return 0;   // het du lieu vao -> thoat
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    private static double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            if (!sc.hasNextLine()) return 1;
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so thuc!");
            }
        }
    }
}
