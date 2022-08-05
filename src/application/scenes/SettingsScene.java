package application.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SettingsScene extends Scene {

private static VBox parent = new VBox();
	
	
	public SettingsScene(Stage stage) {
		super(parent);
		this.getStylesheets().add("application.css");
		
		Label hallo = new Label("Einstellungen");
		hallo.setTextFill(Color.web("FF8A00"));
		
		parent.getChildren().add(hallo);
	}
}
