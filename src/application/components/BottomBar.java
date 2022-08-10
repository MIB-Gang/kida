package application.components;

import java.util.Timer;
import java.util.TimerTask;

import application.controller.MediaController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class BottomBar extends HBox {
		
	private Label currentTime = new Label("00:42");
	private ProgressSlider seekbar = new ProgressSlider();
	private Label endTime = new Label("13:37");
	private ImageView volumeIcon = new ImageView();
	private ProgressSlider volumeSlider = new ProgressSlider();

	public BottomBar() {
		
		this.getChildren().addAll(
				new Rectangle(32, 0),
				currentTime,
				seekbar,
				endTime,
				new Rectangle(48, 0),
				volumeIcon,
				new Rectangle(12, 0),
				volumeSlider,
				new Rectangle(32, 0)
		);
		
		TimerTask seekbarProgressTask = new TimerTask() {
			@Override
			public void run() {
				seekbar.setValue(seekbar.getValue()+1);
			};
		};
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(seekbarProgressTask, 0, 250);
		
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setAlignment(Pos.CENTER);
		this.setMinHeight(64);
		this.setBackground(Background.fill(Color.rgb(19, 19, 19)));
		
		volumeIcon.setImage(new Image("/volume.png"));
		volumeIcon.setFitWidth(24);
		volumeIcon.setPreserveRatio(true);
		
		volumeSlider.setMaxWidth(64);
				
		HBox.setHgrow(seekbar, Priority.ALWAYS);
	}
	
}
