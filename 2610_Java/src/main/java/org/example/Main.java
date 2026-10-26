package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== BÀI 1: Demo các phép toán trên 2 phân số =====
        System.out.println("===== BAI 1 =====");
        PhanSo a = new PhanSo(6, 8);
        PhanSo b = new PhanSo(1, 3);
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + a.tong(b));
        System.out.println("a - b = " + a.hieu(b));
        System.out.println("a * b = " + a.tich(b));
        System.out.println("a / b = " + a.thuong(b));

        int kq = a.soSanh(b);
        if (kq > 0) {
            System.out.println("a > b");
        } else if (kq < 0) {
            System.out.println("a < b");
        } else {
            System.out.println("a = b");
        }

        a.rutGon();
        System.out.println("a sau khi rut gon = " + a);

        // ===== BÀI 2: Tập hợp các phân số =====
        System.out.println("\n===== BAI 2 =====");
        System.out.print("Nhap so luong phan so n: ");
        int n = sc.nextInt();

        List<PhanSo> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Phan so thu " + (i + 1) + ":");
            System.out.print("  Tu so: ");
            int tu = sc.nextInt();
            int mau;
            do {
                System.out.print("  Mau so (khac 0): ");
                mau = sc.nextInt();
            } while (mau == 0);
            ds.add(new PhanSo(tu, mau));
        }

        if (ds.isEmpty()) {
            System.out.println("Tap phan so rong.");
            return;
        }

        System.out.println("Tap phan so: " + ds);

        // 1. Phân số lớn nhất
        PhanSo max = ds.get(0);
        for (PhanSo p : ds) {
            if (p.soSanh(max) > 0) {
                max = p;
            }
        }
        System.out.println("Phan so lon nhat: " + max);

        // 2. Tổng các phân số
        PhanSo tong = new PhanSo(0, 1);
        for (PhanSo p : ds) {
            tong = tong.tong(p);
        }
        System.out.println("Tong cac phan so: " + tong);

        // 3. Số phân số không phải là số nguyên
        int dem = 0;
        for (PhanSo p : ds) {
            if (!p.laSoNguyen()) {
                dem++;
            }
        }
        System.out.println("So phan so khong phai so nguyen: " + dem);
    }
}
