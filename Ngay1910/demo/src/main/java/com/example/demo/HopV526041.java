package com.example.demo;

import java.util.Scanner;

public class HopV526041 {

    // Bai 1: Tinh tong cac phan tu trong mang
    static void bai01(Scanner sc) {
        System.out.print("Nhap so phan tu n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("So phan tu phai lon hon 0!");
            return;
        }

        int[] a = new int[n];
        int tong = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap a[" + i + "]: ");
            a[i] = sc.nextInt();
            tong = tong + a[i];
        }

        System.out.println("Tong cac phan tu = " + tong);
    }

    // Bai 2: Cong hai mang a va b
    static void bai02(Scanner sc) {
        System.out.print("Nhap so phan tu mang a: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("So phan tu khong hop le!");
            return;
        }

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap a[" + i + "]: ");
            a[i] = sc.nextInt();
        }

        System.out.print("Nhap so phan tu mang b: ");
        int m = sc.nextInt();

        if (m < 0) {
            System.out.println("So phan tu khong hop le!");
            return;
        }

        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Nhap b[" + i + "]: ");
            b[i] = sc.nextInt();
        }

        // Tim kich thuoc mang ket qua
        int max = Math.max(n, m);
        int[] c = new int[max];

        // Cong tung phan tu cua hai mang
        for (int i = 0; i < max; i++) {
            if (i < n) {
                c[i] = c[i] + a[i];
            }

            if (i < m) {
                c[i] = c[i] + b[i];
            }
        }

        System.out.print("Mang ket qua: ");
        for (int i = 0; i < max; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }

    // Bai 3: Nhap cac so tren mot dong va tinh tong
    static void bai03(Scanner sc) {
        sc.nextLine(); // Xoa ky tu xuong dong con lai

        System.out.println("Nhap cac so, cach nhau boi dau cach:");
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("So phan tu: 0");
            System.out.println("Tong: 0");
            return;
        }

        String[] a = s.split("\\s+");

        int dem = 0;
        long tong = 0;

        for (int i = 0; i < a.length; i++) {
            int so = Integer.parseInt(a[i]);
            tong = tong + so;
            dem++;
        }

        System.out.println("So phan tu: " + dem);
        System.out.println("Tong: " + tong);
    }

    // Ham main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Bai 1: Tinh tong mang");
            System.out.println("2. Bai 2: Cong hai mang");
            System.out.println("3. Bai 3: Dem va tinh tong");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    bai01(sc);
                    break;
                case 2:
                    bai02(sc);
                    break;
                case 3:
                    bai03(sc);
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}
