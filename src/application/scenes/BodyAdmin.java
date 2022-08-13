package application.scenes;

import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
import application.uiComponents.DefaultButton;
import application.uiComponents.SongTable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class BodyAdmin extends VBox {
	
	private PlayerController playerController = PlayerController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	private MediaController mediaController = MediaController.getInstance();
	
	private SongTable table = new SongTable();
	
	private DefaultButton importButton = new DefaultButton("Importieren");
		
	
	public BodyAdmin() {

		table.setItems(mediaController.getAllSongs());
		
		importButton.setOnAction((event) -> sceneController.openImportWindow(sceneController.openFileChooser(event)));
		
		this.getChildren().addAll(importButton, table);
	}
	
}
