package com.self.tank;

/**
 * @Author: ZST
 * @Date: 2020/6/1
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFram frame = new TankFram();
        for (int i = 0; i < 5; i++) {
            frame.enemyTanks.add(new Tank(200 + i * 100, 200, Dir.DOWN, Group.BAD, frame));
        }
            while (true) {
                Thread.sleep(50);
                frame.repaint();
            }

    }
}
