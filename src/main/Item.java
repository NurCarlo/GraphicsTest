package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item extends Ball {
	
	int xVel = 0;
	int yVel = 0;
	int r = 50;
	int hits = 0;

	Item(int x, int y, int xVel, int yVel, Color color) {
		super(x, y, xVel, yVel, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(color);
		g2d.fillRect(x, y, r, r);
	}
	
	@Override
	public void checkBall(Ball ball) {
        double distance = Math.sqrt(Math.pow(ball.x - this.x, 2) + Math.pow(ball.y - this.y, 2));
        
        if (distance <= this.r) {
        	ball.xVel += 1;
        	ball.yVel += 1;
        	hits ++;
        	System.out.println("hits" + hits + "item");
        }
	}

	public void update(Ball ball) {
		// TODO Auto-generated method stub
		checkBall(ball);
	}
}
