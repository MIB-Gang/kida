package application.scenes;


import application.controller.PlayerController;
import application.controller.SceneController;
import application.uiComponents.DefaultButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BodyLibrary extends VBox {
	
	private PlayerController controller = PlayerController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	
	private Label title = new Label();
	DefaultButton adminButton = new DefaultButton("Alle Songs verwalten");
			
	public BodyLibrary() {
		title.setText("Bibliothek");
		
		adminButton.setOnAction((event) -> sceneController.changeBody(event, new BodyAdmin()));
		
		this.getChildren().addAll(title, adminButton);

		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
		title.setFont(new Font(48));
		
		HBox.setHgrow(adminButton, Priority.ALWAYS);
	}
	
}
