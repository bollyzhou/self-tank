package com.self.tank;

import java.awt.*;

public class Bullet {
	private static final int SPEED = 20;
	public static int WIDTH = ResourceMgr.bulletU.getWidth(), HEIGHT = ResourceMgr.bulletU.getHeight();
	
	private int x, y;
	private Dir dir;
	boolean live = true;
	private TankFram tankFram = null;
	
	public Bullet(int x, int y, Dir dir, TankFram tankFram) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void paint(Graphics g) {
	    if (!live) {
            tankFram.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
		
		move();
	}
	
	private void move() {
		
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
			default:break;
		}
		if (x < 0 || y < 0 || x > TankFram.GAME_WIDTH || y > TankFram.GAME_HEIGHT ) {
            live = false;
        }
	}
}