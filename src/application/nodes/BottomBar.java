package application.nodes;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;

public class BottomBar extends HBox {

	public BottomBar() {
		Label currentTime = new Label("00:42");				
		Slider seekbar = new Slider();
		Label endTime = new Label("13:37");
		
		HBox.setHgrow(seekbar, Priority.ALWAYS);

		this.setId("bottomBar");
		this.getChildren().addAll(
				new Rectangle(128, 0),
				currentTime,
				seekbar,
				endTime,
				new Rectangle(128, 0)
		);

	}
	
}
