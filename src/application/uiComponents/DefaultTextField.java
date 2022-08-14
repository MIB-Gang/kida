package application.uiComponents;

import javafx.scene.control.TextField;

public class DefaultTextField extends TextField {

	public DefaultTextField() {
		applyStyle();
	}
	
	public DefaultTextField(String name) {
		this.setText(name);
		applyStyle();
	}
	
	
	private void applyStyle() {
		this.setStyle("-fx-background-color: transparent; -fx-border-color: #686868; -fx-border-radius: 8; -fx-border-width: 2; -fx-text-fill: white; -fx-padding: 6 12 6 12");
	}
}
