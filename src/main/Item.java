package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Item extends Ball {
	
	int xVel = 0;
	int yVel = 0;

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
	
	
}
