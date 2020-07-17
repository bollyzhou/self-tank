package com.self.tank;

import java.awt.*;

public class Bullet {
	private static final int SPEED = 50;
	private static int WIDTH = 30, HEIGHT = 30;
	
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
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		
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