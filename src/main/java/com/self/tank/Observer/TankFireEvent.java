package com.self.tank.Observer;

import com.self.tank.Tank;

/**
 * @Author: ZST
 * @Date: 2020/8/11
 */
public class TankFireEvent {
    Tank tank;
    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
    public Tank getSource() {
        return tank;
    }
}
