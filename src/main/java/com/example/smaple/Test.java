package com.example.smaple;

class SuperObject {
    public void draw() {
        System.out.println("A");
        draw();
    }

    public void paint() {
        System.out.print('B');
        this.draw();
    }
}

class SubObject extends SuperObject {
    public void paint() {
        super.paint();
        System.out.print('C');
        this.draw();
    }

    public void draw() {
        System.out.print('D');
    }
}

public class Test {
    public static void main(String[] args) {
        SuperObject a = new SubObject();
        a.paint();
        a.draw();
    }
}
