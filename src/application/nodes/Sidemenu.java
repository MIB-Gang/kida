package application.nodes;

import application.canvas.HomeCanva;
import application.controller.SceneController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Sidemenu extends VBox {
	
	public Sidemenu(Stage stage) {		
		Image logo = new Image("kida.png");
		
		ImageView logoContainer = new ImageView();
		logoContainer.setImage(logo);
		logoContainer.setFitWidth(128);
		logoContainer.setPreserveRatio(true);
				
		Button home = new Button("Home");
		Button search = new Button("Suchen");
		Button library = new Button("Bibliothek");
		//home.setOnAction((e) -> { NavigationController.changeCanva(stage, new HomeCanva()); });
		
		this.setId("sidemenu");
		this.getChildren().add(logoContainer);
		this.getChildren().addAll(new Rectangle(0, 32), home, search, library);
	}
	
}
