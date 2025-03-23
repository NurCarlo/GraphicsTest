package main;

import java.awt.Color;
import java.awt.Graphics2D;

//um aus dem Grafikobjeckt eine eigene klasse zu machen muessen alleeigenschaften übernommen werden, 
//zdem muss eine eigene draw und update funktion hinzugefügt werden 

public class Ball {
	int x, y;
	int sizex = 30, sizey = 30;
	int r = 50;
	int xVel =7, yVel = 11;
	Color color = Color.green;

	Ball(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	Ball(int x, int y, int xVel, int yVel){
		this.x = x;
		this.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
	}
	
	public void update(int Panel_Breite,int Panel_Hoehe) {
		if (x + 50 >= Panel_Breite || x < 0)
			xVel *= -1;
		if (y + 50 >= Panel_Hoehe || y < 0)
			yVel *= -1;
		x += xVel;
		y += yVel;
	}
	
	public void draw(Graphics2D g2d) {	//
		g2d.setColor(color);
		g2d.fillOval(x, y, r, r);
	}
}
