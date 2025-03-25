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
	
	int hits = 0;
	
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
	Ball(int x, int y, int xVel, int yVel,Color color){
		this.x = x;
		this.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
		this.color = color;
	}
	
	public void update(int Panel_Breite,int Panel_Hoehe, Ball[] balls,Item item) {

		this.checkWall(Panel_Breite, Panel_Hoehe);
		
		for (Ball other : balls) {
			if (other != this){
				this.checkBall(other);
			}
		}
		
		this.checkItem(item);
	
		x += xVel;
		y += yVel;
	}
	
	public void checkWall(int Panel_Breite,int Panel_Hoehe) {
		if (x + r >= Panel_Breite || x < 0)
			xVel *= -1;
		if (y + r >= Panel_Hoehe || y < 0)
			yVel *= -1;
	}
	
	public void checkBall(Ball other) {
        double distance = Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
        
        if (distance <= this.r) {
            // Einfache Geschwindigkeitsvertauschung für elastische Kollision
            int tempXVel = this.xVel;
            int tempYVel = this.yVel;
            this.xVel = other.xVel;
            this.yVel = other.yVel;
            other.xVel = tempXVel;
            other.yVel = tempYVel;
        }
	}
	
	public void checkItem(Item item) {
        double distance = Math.sqrt(Math.pow(item.x - this.x, 2) + Math.pow(item.y - this.y, 2));
        
        if (distance <= this.r) {
        	xVel += 1;
        	yVel += 1;
        	hits ++;
        	System.out.println("hits" + hits + "ball" );
        }
	}
	
	public void draw(Graphics2D g2d) {	//
		g2d.setColor(color);
		g2d.fillOval(x, y, r, r);
	}
}
