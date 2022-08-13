package application.uiComponents;

import application.Song;
import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class SongTable extends TableView<Song> {
	
	private MediaController mediaController = MediaController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	private PlayerController playerController = PlayerController.getInstance();
	
    ContextMenu cm = new ContextMenu();
    MenuItem mi = new MenuItem("Zu Playlist hinzufuegen");
    MenuItem mi1 = new MenuItem("Umbenennen");

	public SongTable() {
		TableColumn<Song, String> titleColumn = new TableColumn<>("Titel");
		TableColumn<Song, String> artistColumn = new TableColumn<>("Interpret");
		TableColumn<Song, String> genreColumn = new TableColumn<>("Genre");
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
		
		this.getColumns().addAll(titleColumn, artistColumn, genreColumn);
		
		
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    // TODO: Doppelgeklickten Eintrag als aktuellen Song ausw�hlten
                	playerController.updateCurrentSong(getSelectionModel().getSelectedItem());
                	playerController.play();
                    System.out.println(getSelectionModel().getSelectedItem().getTitle());
                }
                if(event.getButton() == MouseButton.SECONDARY) {
                    cm.getItems().addAll(mi,mi1);
                    cm.show(getParent(), event.getScreenX(), event.getScreenY());
                }
            }
        }); 
		
		applyStyle();
	}
	
	
	private void applyStyle() {
		this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		this.setStyle("-fx-base: transparent; -fx-background-color: #292929; -fx-text-fill: white;");
	}	
	
}
