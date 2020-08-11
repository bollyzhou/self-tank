package com.self.tank.strategy;

import com.self.tank.*;
import com.self.tank.strategy.FireStrategy;

/**
 * @Author: ZST
 * @Date: 2020/8/2
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        for (Dir dir : Dir.values()) {
            new Bullet(bX, bY, dir, tank.getGroup());
        }
        if (tank.getGroup().equals(Group.GOOD)) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
