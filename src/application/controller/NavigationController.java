package application.controller;

import application.scenes.Scaffold;
import javafx.scene.Node;
import javafx.stage.Stage;

public class NavigationController {

	public static void changeCanva(Stage stage, Node canva) {
		stage.setScene(new Scaffold(stage, canva));
	}
	
}
