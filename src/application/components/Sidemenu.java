package application.components;

import application.scenes.BodyHome;
import application.scenes.BodyLibrary;
import application.scenes.BodySearch;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sidemenu extends VBox {

	private ImageView logoContainer = new ImageView();
		
	public Sidemenu() {	
		this.getChildren().addAll(logoContainer, new Rectangle(0, 32));

		this.getChildren().add(new MenuButton("Home", new Image("/home.png"), new BodyHome()));
		this.getChildren().add(new MenuButton("Suche", new Image("/search.png"), new BodySearch()));
		this.getChildren().add(new MenuButton("Bibliothek", new Image("/library.png"), new BodyLibrary()));
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setMinWidth(128);
		this.setBackground(Background.fill(Color.rgb(19, 19, 19)));
		this.setPadding(new Insets(32));
		
		logoContainer.setImage(new Image("/kida.png"));
		logoContainer.setFitWidth(128);
		logoContainer.setPreserveRatio(true);
	}
	
}
