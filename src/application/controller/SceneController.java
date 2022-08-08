package application.controller;

import application.scenes.Scaffold;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;

public class SceneController {
	
	private Scene scene;

	public void changeBody(ActionEvent e, Node body) {
		scene = (Scene) ((Node) e.getSource()).getScene();
		scene.setRoot(new Scaffold(body));
	}
	
}
