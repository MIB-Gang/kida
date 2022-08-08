package application.controller;

import application.screens.Scaffold;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;

public class SceneController {
	
	private Scene scene;

	public void changeCanva(ActionEvent e, Node canva) {
		scene = (Scene) ((Node) e.getSource()).getScene();
		scene.setRoot(new Scaffold(canva));
	}
	
}
