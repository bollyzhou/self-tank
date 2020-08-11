package com.self.tank.Observer;

import com.self.tank.Tank;

/**
 * @Author: ZST
 * @Date: 2020/8/11
 */
public class TankFireHandler implements TankFireObserver {

    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank source = e.getSource();
        source.fire();
    }
}
