package com.self.tank;

import java.util.Objects;

/**
 * @Author: ZST
 * @Date: 2020/6/1
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFram frame = new TankFram();
        int count = Integer.valueOf((String) Objects.requireNonNull(PropertyMgr.getValue("enemy.tank.count")));
        for (int i = 0; i < count; i++) {
            frame.enemyTanks.add(new Tank(200 + i * 100, 200, Dir.DOWN, Group.BAD, frame));
        }
            while (true) {
                Thread.sleep(50);
                frame.repaint();
            }

    }
}
