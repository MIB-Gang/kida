package application.uiComponents;

import application.scenes.BodyExplore;
import application.scenes.BodyGenre;
import application.scenes.BodyHome;
import application.scenes.BodyAdmin;
import application.scenes.BodyAlbums;
import application.scenes.BodyArtists;
import application.scenes.BodySearch;
import javafx.geometry.Insets;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sidemenu extends BorderPane {

	private VBox menuContent = new VBox();
	private ControlElements controlElements = new ControlElements();
	private ImageView logoContainer = new ImageView();
		
	public Sidemenu() {
		menuContent.getChildren().addAll(logoContainer, new Rectangle(0, 32));

		menuContent.getChildren().add(new KMenuButton("Suche", new Image("/search.png"), new BodySearch()));
		menuContent.getChildren().add(new KMenuButton("Home", new Image("/library.png"), new BodyHome()));
		menuContent.getChildren().add(new KMenuButton("Interpreten", new Image("/toggle_on.png"), new BodyArtists()));
		menuContent.getChildren().add(new KMenuButton("Alben", new Image("/kida_icon.png"), new BodyAlbums()));
		menuContent.getChildren().add(new KMenuButton("Genre", new Image("/next.png"), new BodyGenre()));

		this.setCenter(menuContent);
		this.setBottom(controlElements);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPrefWidth(128);
		this.setBackground(Background.fill(Color.rgb(19, 19, 19)));
		this.setPadding(new Insets(32, 32, 12, 32));
		
		menuContent.setSpacing(4);
		
		logoContainer.setImage(new Image("/kida.png"));
		logoContainer.setFitWidth(128);
		logoContainer.setPreserveRatio(true);
	}
	
}
