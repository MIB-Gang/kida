package application.components;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import application.controller.SceneController;
import application.scenes.BodyHome;
import application.scenes.BodyLibrary;
import application.scenes.BodySearch;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sidemenu extends VBox {

	private List<Button> buttons = new ArrayList<>();
	private ImageView logoContainer = new ImageView();
		
	public Sidemenu() {	
		buttons.add(new MenuButton("Home", new Image("/home.png"), new BodyHome()));
		buttons.add(new MenuButton("Suche2", new Image("/search.png"), new BodySearch()));
		buttons.add(new MenuButton("Bibliothek!", new Image("/library.png"), new BodyLibrary()));
		
		this.getChildren().addAll(logoContainer, new Rectangle(0, 32));
		for (Button button: buttons) this.getChildren().add(button);
		
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
