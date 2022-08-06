package application.scenes;

import application.nodes.BottomBar;
import application.nodes.Sidemenu;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Scaffold extends Scene {

	private static BorderPane secondaryPane = new BorderPane();
	static SplitPane primaryPane = new SplitPane();
	
	public Scaffold(Stage stage, Node child) {
		super(secondaryPane); /* primaryPane */
		this.getStylesheets().add("application.css");
				
		BottomBar bottomBar = new BottomBar();
		Sidemenu sidemenu = new Sidemenu(stage);
		
		secondaryPane.setBottom(bottomBar);
		secondaryPane.setLeft(sidemenu);
		secondaryPane.setCenter(child);
				
		//primaryPane.getItems().addAll(sidemenu, secondaryPane);

	}

}