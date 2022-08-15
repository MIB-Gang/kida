package application.scenes;

import application.controller.MediaController;
import application.controller.PlayerController;
import application.controller.SceneController;
import application.stages.MainStage;
import application.uiComponents.KButton;
import application.uiComponents.KHeadline;
import application.uiComponents.KSongTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Button backButton = new Button();
	
		
	private KSongTable table = new KSongTable();
	
	private String styleBase = "-fx-background-radius: 8;  -fx-padding: 4;"; // -fx-font-weight: bold;
	private String defaultStyle = "-fx-background-color: transparent;" + styleBase;
	private String pressStyle = "-fx-background-color: #181818;" + styleBase;
	
	public BodyAdmin() {

		table.setItems(mediaController.getAllSongs());
		
		importButton.setOnAction((event) -> sceneController.openImportWindow(sceneController.openFileChooser(event)));
		
		backButton.setOnAction(event -> sceneController.changeBody(event, new BodyLibrary()));
		
		header.getChildren().addAll(backButton, headline, importButton);
		this.getChildren().addAll(header, table);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
		this.setSpacing(12);
		
		header.setSpacing(12);
		header.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(headline, Priority.ALWAYS);
		headline.setMaxWidth(Double.MAX_VALUE);
		
		ImageView backGraphic = new ImageView(new Image("/back.png"));
		backGraphic.setFitWidth(10);
		backGraphic.setPreserveRatio(true);
		backButton.setGraphic(backGraphic);
		backButton.setStyle(defaultStyle);
		backButton.setOnMousePressed(e -> backButton.setStyle(pressStyle));
		backButton.setOnMouseReleased(e -> backButton.setStyle(defaultStyle));
	}
	
}
