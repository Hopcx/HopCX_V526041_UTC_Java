package org.example;

public class PhanSo {
    private int tu;
    private int mau;

    // Hàm tạo mặc định: 0/1
    public PhanSo() {
        this.tu = 0;
        this.mau = 1;
    }

    // Hàm tạo có đối
    public PhanSo(int tu, int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0");
        }
        this.tu = tu;
        this.mau = mau;
        chuanHoaDau();
    }

    public int getTu() {
        return tu;
    }

    public int getMau() {
        return mau;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public void setMau(int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0");
        }
        this.mau = mau;
        chuanHoaDau();
    }

    // Đưa dấu âm lên tử số, mẫu số luôn dương
    private void chuanHoaDau() {
        if (mau < 0) {
            tu = -tu;
            mau = -mau;
        }
    }

    // Ước chung lớn nhất (thuật toán Euclid)
    private static int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // Tổng: a/b + c/d = (ad + bc) / bd
    public PhanSo tong(PhanSo p) {
        PhanSo kq = new PhanSo(this.tu * p.mau + this.mau * p.tu, this.mau * p.mau);
        kq.rutGon();
        return kq;
    }

    // Hiệu: a/b - c/d = (ad - bc) / bd
    public PhanSo hieu(PhanSo p) {
        PhanSo kq = new PhanSo(this.tu * p.mau - this.mau * p.tu, this.mau * p.mau);
        kq.rutGon();
        return kq;
    }

    // Tích: a/b * c/d = ac / bd
    public PhanSo tich(PhanSo p) {
        PhanSo kq = new PhanSo(this.tu * p.tu, this.mau * p.mau);
        kq.rutGon();
        return kq;
    }

    // Thương: a/b : c/d = ad / bc
    public PhanSo thuong(PhanSo p) {
        if (p.tu == 0) {
            throw new ArithmeticException("Khong the chia cho phan so bang 0");
        }
        PhanSo kq = new PhanSo(this.tu * p.mau, this.mau * p.tu);
        kq.rutGon();
        return kq;
    }

    // So sánh: trả về 1 nếu this > p, -1 nếu this < p, 0 nếu bằng nhau
    // (mẫu số luôn dương nên so sánh chéo an toàn)
    public int soSanh(PhanSo p) {
        long trai = (long) this.tu * p.mau;
        long phai = (long) p.tu * this.mau;
        return Long.compare(trai, phai);
    }

    // Rút gọn phân số (thay đổi trực tiếp đối tượng hiện tại)
    public void rutGon() {
        int g = ucln(tu, mau);
        if (g != 0) {
            tu /= g;
            mau /= g;
        }
    }

    // Phân số là số nguyên khi tử chia hết cho mẫu
    public boolean laSoNguyen() {
        return tu % mau == 0;
    }

    @Override
    public String toString() {
        if (mau == 1) {
            return String.valueOf(tu);
        }
        return tu + "/" + mau;
    }
}
