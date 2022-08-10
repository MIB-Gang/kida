package application.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;

public class ProgressSlider extends Slider {
	
	public ProgressSlider() {
		this.setId("progressSlider");
        applyStyle();
	}
	
	private void applyStyle() {
        //this.setStyle("-fx-inner-background: rgb(0, 217, 217);");		
        this.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                StackPane trackPane = (StackPane) lookup(".track");
                String style = String.format("-fx-background-color: linear-gradient(to right, rgb(255, 138, 0) %d%%, rgb(217, 217, 217) %d%%); -fx-background-insets: 0 0 -1 0, 0, 1;",
                        new_val.intValue(), new_val.intValue());
                trackPane.setStyle(style);
            }
        });
	}
	
}
