package application.scenes;


import application.controller.PlayerController;
import application.controller.SceneController;
import application.uiComponents.KButton;
import application.uiComponents.KHeadline;
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
	
	private KHeadline headline = new KHeadline("Bibliothek", "h1");
	
	private KButton adminButton = new KButton("Alle Songs verwalten");
			
	public BodyLibrary() {		
		adminButton.setOnAction((event) -> sceneController.changeBody(event, new BodyAdmin()));
		
		this.getChildren().addAll(headline, adminButton);

		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
		this.setSpacing(12);
		
		HBox.setHgrow(adminButton, Priority.ALWAYS);
		adminButton.setMaxWidth(Double.MAX_VALUE);

	}
	
}
