package application.uiComponents;

import java.util.Timer;
import java.util.TimerTask;

import application.controller.PlayerController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class BottomBar extends HBox {
		
	private Label currentTimeLabel = new Label("00:00");
	private KProgressSlider seekbar = new KProgressSlider();
	private Label endTimeLabel = new Label("00:00");
	private ImageView volumeIcon = new ImageView();
	private KProgressSlider volumeSlider = new KProgressSlider();
	
	private PlayerController controller = PlayerController.getInstance();
	
	Timer timer = new Timer();
	boolean dragDetected = false;


	public BottomBar() {
		
		this.getChildren().addAll(
				new Rectangle(32, 0),
				currentTimeLabel,
				seekbar,
				endTimeLabel,
				new Rectangle(48, 0),
				volumeIcon,
				new Rectangle(12, 0),
				volumeSlider,
				new Rectangle(32, 0)
		);
		
		/* VOLUMESLIDER FUNKTIONIERT NOCH NICHT SO RICHTIG BEI SCENENWECHSEL */
		if (controller.getAudioPlayer() != null) volumeSlider.setValue(controller.getAudioPlayer().getVolume() * 100);		
		
		timer.scheduleAtFixedRate(getSeekbarProgressTask(), 0, 250);

		
		
		seekbar.setOnDragDetected(event -> {controller.getAudioPlayer().pause();
        	if (timer != null) timer.cancel();
            dragDetected=true;     
	    });

		seekbar.setOnMouseReleased(event -> {
            if(dragDetected){
				double totalTime = controller.getAudioPlayer().getTotalDuration().toSeconds();
            	controller.getAudioPlayer().seek(Duration.seconds(totalTime * 0.01 * ((double) seekbar.getValue() )));
            	controller.getAudioPlayer().play();
            	timer = new Timer();
        		timer.scheduleAtFixedRate(getSeekbarProgressTask(), 0, 250);
                dragDetected=false;
            }
	    });
		
		applyStyle();
	}
	
	
	public TimerTask getSeekbarProgressTask() {
		return new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					if (controller.getAudioPlayer() != null) {
						double currentTime = controller.getAudioPlayer().getCurrentTime().toSeconds();
						double totalTime = controller.getAudioPlayer().getTotalDuration().toSeconds();
						int currentMinutes = (int) Math.abs(currentTime / 60);
						int currentSeconds = (int) Math.abs(currentTime - currentMinutes * 60);
						int endMinutes = (int) Math.abs((totalTime - currentTime) / 60);
						int endSeconds = (int) Math.abs((totalTime - currentTime) - endMinutes * 60);
						currentTimeLabel.setText(String.format("%02d:%02d", currentMinutes, currentSeconds));
						endTimeLabel.setText(String.format("%02d:%02d", endMinutes, endSeconds));
						seekbar.setValue(100 * (currentTime / totalTime));
						
						controller.volumeChange(volumeSlider);
					}
	            });
			};
		};

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
