package application.uiComponents;

import application.Playlist;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class KPlaylistButton extends VBox {

	private KButton button = new KButton();
	private Label nameLabel = new Label();
	
	public KButton getButton() {
		return button;
	}

	public KPlaylistButton() {
		button.setGraphic(new ImageView(new Image("/disc.png")));
		this.getChildren().addAll(button, nameLabel);
		applyStyle();
	}
	
	public KPlaylistButton(Playlist playlist) {
		button.setText(playlist.getName().substring(0, 1));
		nameLabel.setText(playlist.getName());
		this.getChildren().addAll(button, nameLabel);
		applyStyle();
	}
	
	public KPlaylistButton(Image graphicImage) {
		button.setGraphic(new ImageView(graphicImage));
		this.getChildren().addAll(button, nameLabel);

		applyStyle();
	}
	
	public KPlaylistButton(String text) {
		button.setGraphic(new ImageView(new Image("/disc.png")));
		nameLabel.setText(text);
		this.getChildren().addAll(button, nameLabel);

		applyStyle();
	}
	
	private void applyStyle() {
		//nameLabel.setFont(new Font(18));

		button.setMinHeight(96);
		button.setMinWidth(96);
		button.setMaxHeight(Double.MAX_VALUE);
		button.setMaxWidth(Double.MAX_VALUE);
		
		// TODO: bold font
		//this.setStyle("-fx-font-weight: bold");
	}
	
}
