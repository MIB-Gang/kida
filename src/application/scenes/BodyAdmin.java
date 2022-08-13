package application.scenes;

import application.Song;
import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
import application.uiComponents.DefaultButton;
import application.uiComponents.SongTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class BodyAdmin extends VBox {
	
	private PlayerController playerController = PlayerController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	private MediaController mediaController = MediaController.getInstance();
	
	private SongTable table = new SongTable();
	
	private DefaultButton importButton = new DefaultButton("Importieren");
	
    ContextMenu cm = new ContextMenu();
    MenuItem mi = new MenuItem("Zu Playlist hinzufuegen");
    MenuItem mi1 = new MenuItem("Umbenennen");
	
	public BodyAdmin() {

		table.setItems(mediaController.getAllSongs());
		
		importButton.setOnAction((event) -> sceneController.openImportWindow(sceneController.openFileChooser(event)));
		
		this.getChildren().addAll(importButton, table);
	}
	
}
