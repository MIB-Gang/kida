package application.scenes;

import application.Song;
import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
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
		
		table.setItems(mediaController.getAllSongs());
		table.getColumns().addAll(titleColumn, artistColumn, genreColumn);
		this.getChildren().addAll(importButton, table);
		
		
		table.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    // TODO: Doppelgeklickten Eintrag als aktuellen Song auswählten
                	playerController.updateCurrentSong(table.getSelectionModel().getSelectedItem());
                	playerController.play();
                    System.out.println(table.getSelectionModel().getSelectedItem().getTitle());
                }
                if(event.getButton() == MouseButton.SECONDARY) {
                    ContextMenu cm = new ContextMenu();
                    MenuItem mi = new MenuItem("Zu Playlist hinzufügen");
                    cm.getItems().add(mi);
                    cm.show(table, event.getScreenX(), event.getScreenY());
                }
            }
        }); 
		
		
		importButton.setText("Importieren");
		importButton.setOnAction((event) -> sceneController.openImportWindow(sceneController.openFileChooser(event)));
		
	}
	
}
