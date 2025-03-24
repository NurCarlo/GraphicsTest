package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener { // hier werden die grafiken gezeichent;

	final int Panel_Breite =1000;
	final int Panel_Hoehe = 1000;
	Timer timer; // timer wird fuer den actionlistener benötigt;
	int mills = 10;

	Ball ball[];
	int anzBalls = 10;
	Random random = new Random();
	
	Item item;

	MyPanel() {
		this.setPreferredSize(new Dimension(Panel_Breite, Panel_Hoehe)); // Fenster richtet sich nach dieser Größe ohne
																			// den oberen Rand
		this.setBackground(Color.lightGray); // um den hintergrund auf diesse weise zu färebn muss "super.paint(g)"
												// benutzt werden
		ball = new Ball[anzBalls];
		
		int xBalls,yBalls;
		int xPosRand, yPosRand;
		int xVelRand, yVelRand;
		Color colorRand;
		
		for(int i =0;i<ball.length;i+=1) {
			xBalls = (int) (i*Panel_Breite/ball.length);
			xPosRand = random.nextInt(Panel_Breite) + 1;
			yPosRand = random.nextInt(Panel_Hoehe) + 1;
			xVelRand = random.nextInt(21) -10;
			yVelRand = random.nextInt(21) -10;
			colorRand = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
			ball[i] = new Ball(xPosRand,yPosRand,xVelRand,yVelRand,colorRand);
		}
		

		xPosRand = random.nextInt(Panel_Breite) + 1;
		yPosRand = random.nextInt(Panel_Hoehe) + 1;
		item = new Item(xPosRand, xPosRand, 0, 0, Color.black);
//		for(int i =0;i<5;i+=1) {
//			
//			int x = i * (Panel_Hoehe - 10);
//            int y = i * (Panel_Hoehe - 10);
//            int xVel = 7;
//            int yVel = 11;
//			
//			
//            
//			ball[i] = new Ball(x,y,xVel,yVel);
//		}
			
//        for (int i = 0; i < ball.length; i++) {
//            int x = (int) (Math.random() * (Panel_Breite - 50));  // Zufällige X-Position
//            int y = (int) (Math.random() * (Panel_Hoehe - 50));   // Zufällige Y-Position
//            int xVel = (int) (Math.random() * 10 + 2);  // Zufällige Geschwindigkeit
//            int yVel = (int) (Math.random() * 10 + 2);
//            ball[i] = new Ball(x, y, xVel, yVel);
//        }
		

		timer = new Timer(mills, this); // timer wird auf 1s gestellt; entspricht der wiederholrate von ectionPerformed
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (x + 50 >= Panel_Breite || x < 0)	//wurde auch zu Ball ausgelagert
//			xVel *= -1;
//		if (y + 50 >= Panel_Hoehe || y < 0)
//			yVel *= -1;
//		x += xVel;
//		y += yVel;
		
		for(int i =0;i<ball.length;i+=1)
			ball[i].update(Panel_Breite, Panel_Hoehe, ball);
		repaint();
	}

	public void paint(Graphics g) { // das eigentliche zeichnen

		super.paint(g); // paints bg?

		Graphics2D g2d = (Graphics2D) g; // typecast von graphic zu graphics2D; g2d hat mehr funktionen

		// g2d.setBackground(Color.CYAN); //geht nicht; im frame ändern?
		// g2d.setColor(Color.gray);
		// g2d.fillRect(0, 0, 500, 500); //eine Fläche in der Größe des Fensters zu
		// öffen geht aber lol

		//g2d.setColor(Color.black);		//augelagert zr Ball Klasse
		//g2d.fillOval(x, y, 50, 50);
		
		for(int i =0;i<ball.length;i+=1)
			ball[i].draw(g2d);
		
		item.draw(g2d);

		// text(g2d);
		// dreieck(g2d);
		// zeug(g2d);
		// pokeball(g2d);
		System.out.println("paint");

	}

	public void pokeball(Graphics2D g2d) {
		g2d.setColor(Color.red);
		g2d.fillArc(0, 0, 100, 100, 0, 180);
		g2d.setColor(Color.white);
		g2d.fillArc(0, 0, 100, 100, 180, 180);
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(5)); // die kreise fuer den knopf sind nicht mittig
		g2d.drawLine(0, 50, 100, 50);
		g2d.setStroke(new BasicStroke(1));
		g2d.fillOval(50 - 5, 50 - 5, 10, 10);
		g2d.drawOval(50 - 10, 50 - 10, 20, 20);
		System.out.println("pika");

	}

	public void zeug(Graphics2D g2d) {
		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(5)); // stroke it
		g2d.drawLine(0, 0, 500, 500);
		g2d.drawRect(0, 0, 100, 200);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval(70, 50, 50, 100);
		g2d.setColor(Color.orange);
		g2d.drawOval(0, 0, 100, 100);
		System.out.println("zeuch");
	}

	public void dreieck(Graphics2D g2d) {
		g2d.setColor(Color.yellow);
		int[] xPoints = { 100, 200, 300 };
		int[] yPoints = { 150, 0, 150 };
		System.out.println("xPoints[0] xPoints[0] xPoints[0]");
		g2d.fillPolygon(xPoints, yPoints, 3);

		g2d.setColor(Color.yellow);
		int[] xPoints2 = { 0, 100, 200 };
		int[] yPoints2 = { 300, 150, 300 };
		g2d.fillPolygon(xPoints2, yPoints2, 3);

		g2d.setColor(Color.yellow);
		int[] xPoints3 = { 200, 300, 400 };
		int[] yPoints3 = { 300, 150, 300 };
		g2d.fillPolygon(xPoints3, yPoints3, 3);
	}

	public void text(Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.setFont(new Font("Magneto", Font.BOLD, 50));
		g2d.drawString("bist ein kek", 0, 50);

	}

}
