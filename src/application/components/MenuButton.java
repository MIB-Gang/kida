package application.components;

import application.controller.SceneController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class MenuButton extends Button {

	private SceneController controller = new SceneController();
	private ImageView icon;

	public MenuButton(String text, Image icon, Node body) {
		this.icon = new ImageView(icon);
		this.setText(text);
		this.setGraphic(this.icon);
		this.setOnAction((event) -> controller.changeBody(event, body));

		applyStyle();
	}
	
	private void applyStyle() {
		icon.setFitWidth(12);
		icon.setPreserveRatio(true);
		this.setFont(new Font(18));
		// TODO: bold font
		//this.setStyle("-fx-font-weight: bold");
	}
	
}
