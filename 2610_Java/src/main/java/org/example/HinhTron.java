package org.example;

public class HinhTron {
    private double x;
    private double y;

    public HinhTron(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    // Khai baos caontroteo co tham so
    public HinhTron(){
        this.x = 6;
        this.y = 8;
        this.r = 2.5;
    }

    private double r;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }


    public double dienTich(){
        return  (Math.PI * r*r);
    }


    public void tinhTien(double d){
        this.x += d;
        this.y += d;

    }

    @Override
    public String toString() {
        return "HinhTron{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}


