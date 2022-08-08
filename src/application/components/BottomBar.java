package application.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BottomBar extends HBox {
	
	private Label currentTime = new Label("00:42");				
	private Slider seekbar = new Slider();
	private Label endTime = new Label("13:37");

	public BottomBar() {
		this.getChildren().addAll(
				new Rectangle(128, 0),
				currentTime,
				seekbar,
				endTime,
				new Rectangle(128, 0)
		);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setAlignment(Pos.CENTER);
		this.setMinHeight(64);
		this.setBackground(Background.fill(Color.rgb(19, 19, 19)));
		
		HBox.setHgrow(seekbar, Priority.ALWAYS);
	}
	
}
