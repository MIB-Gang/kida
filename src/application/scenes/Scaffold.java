package application.scenes;

import application.components.BottomBar;
import application.components.Sidemenu;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scaffold extends BorderPane {

	private BorderPane secondaryPane = new BorderPane();
	private BottomBar bottomBar = new BottomBar();
	private Sidemenu sidemenu = new Sidemenu();

	
	public Scaffold(Node body) {
		this.getStylesheets().add("application.css");
		
		secondaryPane.setBottom(bottomBar);
		secondaryPane.setCenter(body);
		
		this.setLeft(sidemenu);
		this.setCenter(secondaryPane);
		
		applyStyle();
	}
	
	private void applyStyle() {
		// TODO: Override with common JavaFX Code
		this.setStyle("-fx-base: white; -fx-background: rgb(41, 41, 41); -fx-focus-color: transparent;");
		//this.setBackground(Background.fill(Color.rgb(41, 41, 41)));
	}

}