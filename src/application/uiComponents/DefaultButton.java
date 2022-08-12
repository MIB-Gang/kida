package application.uiComponents;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class DefaultButton extends Button {

	private String defaultStyle = "-fx-background-color: #131313; -fx-background-radius: 16; -fx-text-fill: rgb(255, 255, 255);";
	private String hoverStyle = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";

	public void setbackgroundColor(String backgroundColor) {
		defaultStyle = "-fx-background-color: #" + backgroundColor + "; -fx-background-radius: 16; -fx-text-fill: rgb(255, 255, 255);";
		this.applyStyle();
	}

	public DefaultButton(String text) {
		this.setText(text);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setFont(new Font(18));

		this.setStyle(defaultStyle);
		this.setOnMouseEntered(e -> this.setStyle(hoverStyle));
		this.setOnMouseExited(e -> this.setStyle(defaultStyle));
		
		// TODO: bold font
		//this.setStyle("-fx-font-weight: bold");
	}
	
}
