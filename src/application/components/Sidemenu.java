package application.components;

import application.controller.MediaController;
import application.scenes.BodyHome;
import application.scenes.BodyLibrary;
import application.scenes.BodySearch;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sidemenu extends BorderPane {

	private VBox menuContent = new VBox();
	private HBox controlElements = new HBox();
	private ImageView logoContainer = new ImageView();
	
	private Button prevButton = new Button();
	private Button playButton = new Button();
	private Button skipButton = new Button();
	private MediaController controller = new MediaController();

		
	public Sidemenu() {
		menuContent.getChildren().addAll(logoContainer, new Rectangle(0, 32));

		menuContent.getChildren().add(new MenuButton("Home", new Image("/home.png"), new BodyHome()));
		menuContent.getChildren().add(new MenuButton("Suche", new Image("/search.png"), new BodySearch()));
		menuContent.getChildren().add(new MenuButton("Bibliothek", new Image("/library.png"), new BodyLibrary()));
		
		controlElements.getChildren().addAll(prevButton, playButton, skipButton);
		
		playButton.setOnAction((event) -> {
			controller.scanForMedia();
			controller.playSong(MediaController.getAllSongs().get(0));
		});
		
		this.setCenter(menuContent);
		this.setBottom(controlElements);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setMinWidth(128);
		this.setBackground(Background.fill(Color.rgb(19, 19, 19)));
		this.setPadding(new Insets(32));
		
		logoContainer.setImage(new Image("/kida.png"));
		logoContainer.setFitWidth(128);
		logoContainer.setPreserveRatio(true);
		prevButton.setGraphic(new ImageView(new Image("/prev.png")));
		playButton.setGraphic(new ImageView(new Image("/play.png")));
		skipButton.setGraphic(new ImageView(new Image("/skip.png")));
	}
	
}
