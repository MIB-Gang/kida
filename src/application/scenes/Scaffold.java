package application.scenes;

import application.components.BottomBar;
import application.components.Sidemenu;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scaffold extends BorderPane {
	
	private BottomBar bottomBar = new BottomBar();
	private Sidemenu sidemenu = new Sidemenu();

	
	public Scaffold(Node body) {
		this.getStylesheets().add("application.css");
		
		this.setBottom(bottomBar);
		this.setLeft(sidemenu);
		this.setCenter(body);
		
		applyStyle();
	}
	
	private void applyStyle() {
		// TODO: Override with common JavaFX Code
		this.setStyle("-fx-base: rgb(255, 138, 0)");
		this.setStyle("-fx-background: rgb(41, 41, 41)");
		//this.setStyle("-fx-focus-color: transparent");
		this.setBackground(Background.fill(Color.rgb(41, 41, 41)));
	}

}