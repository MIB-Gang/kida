package application.stages;

import application.Song;
import application.controller.MediaController;
import application.uiComponents.KButton;
import application.uiComponents.KTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class EditStage extends Stage {

	private MediaController mediaController = MediaController.getInstance();

	private BorderPane primaryPane = new BorderPane();

	
	private VBox textFieldArea = new VBox();
	private StackPane buttonArea = new StackPane();

	KTextField titleField = new KTextField();
	KTextField artistField = new KTextField();
	KTextField albumField = new KTextField();
	KTextField genreField = new KTextField();
	KButton saveEntryButton = new KButton("Speichern");
	

	public EditStage(Song song) {

		saveEntryButton.setOnAction(event -> {
			if(titleField.getText().isEmpty()) {
				Alert titleAlert = new Alert(AlertType.ERROR);
				titleAlert.initOwner(((Node) event.getSource()).getScene().getWindow());
				titleAlert.setTitle("Fehlende Daten");
				titleAlert.setHeaderText(null);
				titleAlert.setContentText("Bitte gib einen Titel ein, damit du dein Lied wiederfindest.");
				titleAlert.showAndWait();
			} else {
				song.setTitle(titleField.getText());
				song.setArtist(artistField.getText().isEmpty() ? "Unbekannter Interpret" : artistField.getText());
				song.setAlbum(albumField.getText().isEmpty() ? "Unbekanntes Album" : albumField.getText());
				song.setGenre(genreField.getText().isEmpty() ? "Unbekanntes Genre" : genreField.getText());
				mediaController.saveToFile();
				this.fireEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSE_REQUEST));
			}
		});
		
		initTextFields(song);
		textFieldArea.getChildren().addAll(titleField, new Rectangle(0, 12), artistField, new Rectangle(0, 12), albumField, new Rectangle(0, 12), genreField);
		buttonArea.getChildren().addAll(saveEntryButton);

		primaryPane.setCenter(textFieldArea);
		primaryPane.setBottom(buttonArea);


		this.setScene(new Scene(primaryPane));
		this.show();
		

		applyStyle();
	}

	private void applyStyle() {
		this.getIcons().add(new Image("/kida_icon.png"));
		this.setTitle("Songdaten bearbeiten");
		this.setMinWidth(700);
		this.setMinHeight(450);

		saveEntryButton.setBackgroundColor("#686868");

		primaryPane.setMinWidth(300);
		primaryPane.setMaxWidth(300);

		textFieldArea.setAlignment(Pos.CENTER);
		primaryPane.setBackground(Background.fill(Color.rgb(19, 19, 19)));
		buttonArea.setAlignment(Pos.CENTER);
		primaryPane.setPadding(new Insets(32));
	}
	
	private void initTextFields(Song song) {
		titleField.setPromptText("Title");
		artistField.setPromptText("Interpret");
		albumField.setPromptText("Album");
		genreField.setPromptText("Genre");
		
		titleField.setText(song.getTitle());
		artistField.setText(song.getArtist());
		albumField.setText(song.getAlbum());
		genreField.setText(song.getGenre());
	}

}
