package application.uiComponents;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Headline extends Label {
	
	public Headline() {
		this.setFont(new Font(48));
	}
	
	public Headline(String text) {
		this.setText(text);
		this.setFont(new Font(48));
	}
	
	public Headline(String text, String type) {
		this.setText(text);
		
		switch (type) {
		case "h1":
			this.setFont(new Font(48));
			break;
		case "h2":
			this.setFont(new Font(36));
			break;
		case "h3":
			this.setFont(new Font(24));
			break;
		default:
			this.setFont(new Font(48));
			break;
		}
	}
	
}
