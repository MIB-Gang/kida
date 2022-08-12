package application.scenes;


import application.controller.PlayerController;
import application.controller.SceneController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BodyLibrary extends VBox {
	
	private PlayerController controller = PlayerController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	
	private Label title = new Label();
			
	public BodyLibrary() {
		title.setText("Bibliothek");
		
		Button ENTFERNEMICHSPAETER = new Button("Alle Songs verwalten");
		ENTFERNEMICHSPAETER.setOnAction((event) -> sceneController.changeBody(event, new BodyAdmin()));
		
		this.getChildren().addAll(title, ENTFERNEMICHSPAETER);

		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
		title.setFont(new Font(48));
	}
	
}
