package application.nodes;

import java.util.HashMap;
import java.util.Map;

import application.canvas.HomeCanva;
import application.canvas.LibraryCanva;
import application.canvas.SearchCanva;
import application.controller.SceneController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Sidemenu extends VBox {
	
	private Map<String, Node> buttons = new HashMap<>();
	
	public Sidemenu() {	
		this.setId("sidemenu");

		Image logo = new Image("kida.png");
		
		ImageView logoContainer = new ImageView();
		logoContainer.setImage(logo);
		logoContainer.setFitWidth(128);
		logoContainer.setPreserveRatio(true);
		
		this.getChildren().addAll(logoContainer, new Rectangle(0, 32));
		
		buttons = Map.of(
				"Home", new HomeCanva(),
				"Suchen", new SearchCanva(),
				"Bibliothek", new LibraryCanva()
		);
		
		for (String name: buttons.keySet()) {
			Button menuButton = new Button(name);
			menuButton.setOnAction((e) -> System.out.println(name));
			SceneController controller = new SceneController();
			//menuButton.setOnAction((e) -> controller.changeCanva(e, new LibraryCanva()));
			//home.setOnAction((e) -> { NavigationController.changeCanva(stage, new HomeCanva()); });
			this.getChildren().add(menuButton);
		}
		
	}
	
}
