package com.self.tank.Chain;

import com.self.tank.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZST
 * @Date: 2020/8/10
 */
public class ColliderChain {

    List<Collider> colliders = new ArrayList<>();
    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider collider){
        colliders.add(collider);
    }

    public boolean collide(GameObject gameObject1, GameObject gameObject2) {
        for (Collider collider : colliders) {
            collider.collide(gameObject1, gameObject2);
            return true;
        }
        return false;
    }
}
