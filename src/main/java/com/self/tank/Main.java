package com.self.tank;

import java.util.Objects;

/**
 * @Author: ZST
 * @Date: 2020/6/1
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFram frame = new TankFram();
        new Thread(()->new Audio("audio/war1.wav").play()).start();

        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
