package application.scenes;

import application.Playlist;
import application.controller.MediaController;
import application.uiComponents.KTextField;
import application.uiComponents.KBackButton;
import application.uiComponents.KSongTable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BodyPlaylist extends VBox {
	
	private MediaController mediaController = MediaController.getInstance();
	
	private HBox header = new HBox();
	private KBackButton backButton = new KBackButton();
	private KTextField nameField = new KTextField();
	private KSongTable table = new KSongTable();
	
	public BodyPlaylist(Playlist playlist) {
		
		nameField.setPromptText("Playlist-Namen eingeben");
		nameField.setText(playlist.getName());
		
		header.getChildren().addAll(backButton, nameField);
		this.getChildren().addAll(header, table);
		
		table.setItems(mediaController.getAllSongs().getSongs());
	
		nameField.textProperty().addListener((observableText, oldText, newText) -> {
			playlist.setName(newText);
		});
		
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
		this.setSpacing(12);
		HBox.setHgrow(nameField, Priority.ALWAYS);
	}

}
