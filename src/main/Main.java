package main;

import java.awt.GraphicsEnvironment;

public class Main {

	public static void main(String[] args) {
		
		//fonts();
		new MyFrame();
		//new Tunk();
		System.out.println("was zuum");

	}

	public static void fonts() {
		System.out.println("To Know the available font family names");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        System.out.println("Getting the font family names");

        // Array of all the fonts available in AWT
        String fonts[] = ge.getAvailableFontFamilyNames();

        // Getting the font family names
        for (String i : fonts) {
            System.out.println(i + " ");
        }
	}
}
