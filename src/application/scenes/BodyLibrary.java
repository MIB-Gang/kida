package application.scenes;

import application.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class BodyLibrary extends VBox {
	
	private TableView<Song> table = new TableView<>();

	@SuppressWarnings("unchecked")
	public BodyLibrary() {
		TableColumn<Song, String> titleColumn = new TableColumn<>("Titel");
		TableColumn<Song, String> artistColumn = new TableColumn<>("Interpret");
		TableColumn<Song, String> genreColumn = new TableColumn<>("Genre");
		titleColumn.setMinWidth(100);
		artistColumn.setMinWidth(100);
		genreColumn.setMinWidth(100);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
		
		table.setItems(getSongs());
		table.getColumns().addAll(titleColumn, artistColumn, genreColumn);
		this.getChildren().add(table);
	}
	
	public ObservableList<Song> getSongs() {
		ObservableList<Song> songs = FXCollections.observableArrayList();
		songs.add(new Song());
		songs.add(new Song());
		return songs;
	}
	
}
