package com.self.tank;

/**
 * @Author: ZST
 * @Date: 2020/6/1
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFram frame = new TankFram();

        while (true) {
            Thread.sleep(1000L);
            frame.repaint();
        }

    }
}
