package com.self.tank;

/**
 * @Author: ZST
 * @Date: 2020/8/3
 */
public interface Collider {
    boolean collide(GameObject gameObject1, GameObject gameObject2);
}