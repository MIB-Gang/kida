package application.scenes;

import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
import application.uiComponents.KButton;
import application.uiComponents.KHeadline;
import application.uiComponents.KSongTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BodyAdmin extends VBox {
	
	private PlayerController playerController = PlayerController.getInstance();
	private SceneController sceneController = SceneController.getInstance();
	private MediaController mediaController = MediaController.getInstance();

	private HBox header = new HBox();
	private KHeadline headline = new KHeadline("Alle Songs verwalten", "h2");
	private KButton importButton = new KButton("Importieren");
		
	private KSongTable table = new KSongTable();

	
	public BodyAdmin() {

		table.setItems(mediaController.getAllSongs());
		
		importButton.setOnAction((event) -> sceneController.openImportWindow(sceneController.openFileChooser(event)));
		
		header.getChildren().addAll(headline, importButton);
		this.getChildren().addAll(header, table);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
		this.setSpacing(12);
		
		header.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(headline, Priority.ALWAYS);
		headline.setMaxWidth(Double.MAX_VALUE);

	}
	
}
