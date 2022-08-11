package application.scenes;

import application.Song;
import application.controller.MediaController;
import application.controller.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class BodyAdmin extends VBox {
	
	private MediaController controller = MediaController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	
	private TableView<Song> table = new TableView<>();
	
	private Button importButton = new Button();
	
	@SuppressWarnings("unchecked")
	public BodyAdmin() {
		TableColumn<Song, String> titleColumn = new TableColumn<>("Titel");
		TableColumn<Song, String> artistColumn = new TableColumn<>("Interpret");
		TableColumn<Song, String> genreColumn = new TableColumn<>("Genre");
		titleColumn.setMinWidth(100);
		artistColumn.setMinWidth(100);
		genreColumn.setMinWidth(100);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
		
		table.setItems(controller.getAllSongs());
		table.getColumns().addAll(titleColumn, artistColumn, genreColumn);
		this.getChildren().addAll(importButton, table);
		
		importButton.setText("Importieren");
		importButton.setOnAction((event) -> sceneController.openImportWindow(sceneController.openFileChooser(event)));
		
	}
	
}
