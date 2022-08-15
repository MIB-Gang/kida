package application.uiComponents;

import application.Song;
import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class KSongTable extends TableView<Song> {
	
	private MediaController mediaController = MediaController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	private PlayerController playerController = PlayerController.getInstance();
	
    
    TableColumn<Song, String> titleColumn = new TableColumn<>("Titel");
	TableColumn<Song, String> artistColumn = new TableColumn<>("Interpret");
	TableColumn<Song, String> albumColumn = new TableColumn<>("Album");
	TableColumn<Song, String> genreColumn = new TableColumn<>("Genre");

	@SuppressWarnings("unchecked")
	public KSongTable() {
		
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
		this.getColumns().addAll(titleColumn, artistColumn, albumColumn, genreColumn);
		
		
		this.setRowFactory(new Callback<TableView<Song>, TableRow<Song>>() {
	        @Override
	        public TableRow<Song> call(TableView<Song> tableView) {
	            final TableRow<Song> row = new TableRow<>();
	            
	            ContextMenu menu = new ContextMenu();
	            MenuItem editItem = new MenuItem("Bearbeiten");
	            MenuItem favoriteItem = new MenuItem("Zu Favoriten hinzufuegen");
	            MenuItem addItem = new MenuItem("Zu Playlist hinzufuegen");
	            
	            menu.getItems().addAll(editItem, favoriteItem, addItem);
	            
	            row.setOnMouseClicked(event -> {
					if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
						playerController.updateCurrentSong(getSelectionModel().getSelectedItem());
						playerController.play();
						System.out.println(getSelectionModel().getSelectedItem().getAlbum());
					}
	            }); 
	            
	    		ImageView nextGraphic = new ImageView(new Image("/next.png"));
	    		nextGraphic.setFitWidth(24);
	    		nextGraphic.setPreserveRatio(true);
	    		row.setGraphic(nextGraphic);
	            
	            row.contextMenuProperty().bind(Bindings.when(row.emptyProperty()).then((ContextMenu) null).otherwise(menu));
	            return row;
	        }
		});
		
		
		applyStyle();
	}
	
	
	private void applyStyle() {
		VBox.setVgrow(this, Priority.ALWAYS);
		this.setMaxHeight(Double.MAX_VALUE);

		this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		this.setStyle("-fx-base: transparent; -fx-background-color: transparent; -fx-selection-bar: #686868; -fx-selection-bar-non-focused: #686868;");
		
		// TODO: Table-Header rund
//		this.lookup(".column-header-background").setStyle("-fx-background-radius: 5; -fx-border-radius: 10;");
//		System.out.println(this.lookup(".column-header-background"));
		
		titleColumn.setStyle("-fx-text-fill: white;");
		artistColumn.setStyle("-fx-text-fill: white;");
		albumColumn.setStyle("-fx-text-fill: white;");
		genreColumn.setStyle("-fx-text-fill: white;");
	
	}	
	
}
