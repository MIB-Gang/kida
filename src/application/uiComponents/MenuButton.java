package application.uiComponents;

import application.controller.SceneController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MenuButton extends Button {

	private SceneController controller = new SceneController();
	private ImageView icon;
	private VBox graphic = new VBox();

	public MenuButton(String text, Image icon, Node body) {
		this.icon = new ImageView(icon);
		graphic.getChildren().addAll(this.icon, new Rectangle(32,0));
		this.setText(text);
		this.setGraphic(graphic);
		this.setOnAction((event) -> controller.changeBody(event, body));

		applyStyle();
	}
	
	private void applyStyle() {
		icon.setFitWidth(24);
		icon.setPreserveRatio(true);
		this.setFont(new Font(18));
		// TODO: bold font
		//this.setStyle("-fx-font-weight: bold");
	}
	
}
