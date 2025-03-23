package main;

import javax.swing.JFrame;

public class MyFrame extends JFrame{	//nur die koniguration vom fenster; gereichnet wir im Panel

	MyPanel panel;
	
	MyFrame(){
		
		panel = new MyPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(1000, 1000);	//größe eig egal, wird vom panel überschrieben
		

		this.add(panel);	//panel erzeugen zum zeichen, da die obere leiste zum zeichenbereich hdazu gehört
		this.pack();		//fügt dem fenster das panel hinzu; das Fenster übernimmt auch die Eigenschaften des Panels (größe zB)
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("GeilesTeil");
						System.out.println("mecko");
						
		
		System.out.println("chercker");
	}
	
}
