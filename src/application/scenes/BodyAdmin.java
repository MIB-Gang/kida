package application.scenes;

import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
import application.uiComponents.DefaultButton;
import application.uiComponents.Headline;
import application.uiComponents.SongTable;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BodyAdmin extends VBox {
	
	private PlayerController playerController = PlayerController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	private MediaController mediaController = MediaController.getInstance();

	private Headline headline = new Headline("Alle Songs verwalten", "h2");
	private SongTable table = new SongTable();
	
	private DefaultButton importButton = new DefaultButton("Importieren");
		
	
	public BodyAdmin() {

		table.setItems(mediaController.getAllSongs());
		
		importButton.setOnAction((event) -> sceneController.openImportWindow(sceneController.openFileChooser(event)));
		
		this.getChildren().addAll(headline, importButton, table);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
//		HBox.setHgrow(importButton, Priority.ALWAYS);
//		importButton.setMaxWidth(Double.MAX_VALUE);

	}
	
}
