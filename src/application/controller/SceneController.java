package application.controller;

import application.scenes.Scaffold;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;

public class SceneController {
	
	private Scene scene;
	
//	private Scaffold scaffold = Scaffold.getInstance();

	public void changeBody(ActionEvent e, Node body) {
		scene = (Scene) ((Node) e.getSource()).getScene();
		scene.setRoot(new Scaffold(body));
	}
	
//	public void changeBody(ActionEvent e, Node body) {
//		//scene = (Scene) ((Node) e.getSource()).getScene();
//		//scene.setRoot(new Scaffold(body));
//		scaffold.setBody(body);
//	}
	
}
