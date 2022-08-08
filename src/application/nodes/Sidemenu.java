package application.nodes;

import java.util.LinkedHashMap;
import java.util.Map;

import application.controller.SceneController;
import application.screens.ScreenHome;
import application.screens.ScreenLibrary;
import application.screens.ScreenSearch;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Sidemenu extends VBox {
	
	private Map<String, Node> buttons = new LinkedHashMap<>();
	
	public Sidemenu() {	
		this.setId("sidemenu");

		Image logo = new Image("/kida.png");
		
		ImageView logoContainer = new ImageView();
		logoContainer.setImage(logo);
		logoContainer.setFitWidth(128);
		logoContainer.setPreserveRatio(true);
		
		this.getChildren().addAll(logoContainer, new Rectangle(0, 32));
		
		buttons.put("Home", new ScreenHome());
		buttons.put("Suchen", new ScreenSearch());
		buttons.put("Bibliothek", new ScreenLibrary());
		
		for (String name: buttons.keySet()) {
			Button menuButton = new Button(name);
			menuButton.setFont(new Font(20));
			SceneController controller = new SceneController();
			menuButton.setOnAction((event) -> controller.changeCanva(event, buttons.get(name)));
			this.getChildren().add(menuButton);
		}
		
	}
	
}
