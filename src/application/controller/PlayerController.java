package application.controller;

import java.net.MalformedURLException;

import application.Playlist;
import application.Song;
import application.uiComponents.KProgressSlider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class PlayerController {

	private static PlayerController playerController = new PlayerController();

	public static PlayerController getInstance() {
		return playerController;
	}

	private Media audio;
	private Media video;
	private MediaPlayer audioPlayer;
	private MediaPlayer videoPlayer;
	private MediaView videoView;

	private Song currentSong;
	

	private Playlist currentPlaylist;


	public Playlist getCurrentPlaylist() {
		return currentPlaylist;
	}

	public void setCurrentPlaylist(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
	}	

	public Song getCurrentSong() {
		return currentSong;
	}
	
	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}
	
	public void initCurrentSong() {
		// TODO: ist allSongs (bzw. currentPlaylist?) empty??? =>> FEHLERMELDUNG: "Du hast noch keine Songs hinzugefügt..."
		if (currentPlaylist.getSongs().isEmpty()) {
			updateCurrentSong(currentPlaylist.getSongs().get(0));
		}
		else {
		}
	}

	public void updateCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
		if (audioPlayer != null)
			if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING)
				return;

		audio = new Media(currentSong.getAudioFilePath());
		// video = new Media("file:///" + song.getVideoFilePath());
		audioPlayer = new MediaPlayer(audio);
		// videoPlayer = new MediaPlayer(video);
		// videoView = new MediaView (videoPlayer);
	}
	
	public void startPlaylist() {
		MediaController mediaController = MediaController.getInstance();
		updateCurrentSong(mediaController.getAllSongs().getSongs().get(0));
		play();
	}

	public MediaPlayer getAudioPlayer() {
		return audioPlayer;
	}

	public MediaPlayer getVideoPlayer() {
		return videoPlayer;
	}
	
//	public void playPause() {
//		if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
//			pause();
//			
//			// videoPlayer.pause();
//			}
//	}

	public void play() {
		if(currentSong != null) {
			audioPlayer.play();
		}
	}
	
	public void pause() {
//		if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
			audioPlayer.pause();
			// videoPlayer.pause();
//		}
	}

	public void nextSong() {
		if (currentPlaylist.getSongs().indexOf(currentSong) + 1 != currentPlaylist.getSongs().size()) {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media(currentPlaylist.getSongs().get(currentPlaylist.getSongs().indexOf(currentSong) + 1).getAudioFilePath());
			setCurrentSong(currentPlaylist.getSongs().get(currentPlaylist.getSongs().indexOf(currentSong) + 1));
			// video = new Media ("file:///" +
			// allSongs.get(allSongs.indexOf(song)+1).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			// videoPlayer = new MediaPlayer(video);
			// videoView = new MediaView (videoPlayer);
			play();
		} else {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media(currentPlaylist.getSongs().get(0).getAudioFilePath());
			setCurrentSong(currentPlaylist.getSongs().get(0));
			// video = new Media ("file:///" + allSongs.get(0).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			// videoPlayer = new MediaPlayer(video);
			// videoView = new MediaView (videoPlayer);
			play();
		}
	}

	public void previousSong() {

		if (audioPlayer.getCurrentTime().greaterThanOrEqualTo(Duration.seconds(5)) || currentPlaylist.getSongs().indexOf(currentSong) == 0) {
			audioPlayer.seek(Duration.seconds(0));
			// videoPlayer.seek(Duration.seconds(0));
		}
		else {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media(currentPlaylist.getSongs().get(currentPlaylist.getSongs().indexOf(currentSong) - 1).getAudioFilePath());
			setCurrentSong(currentPlaylist.getSongs().get(currentPlaylist.getSongs().indexOf(currentSong) - 1));

			// video = new Media ("file:///" +
			// allSongs.get(allSongs.indexOf(song)-1).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			// videoPlayer = new MediaPlayer(video);
			// videoView = new MediaView (videoPlayer);
			play();
		}
	}

	public void volumeChange(KProgressSlider volumeSlider) {
		if (audioPlayer != null)
			audioPlayer.setVolume(volumeSlider.getValue() * 0.01);
	}
}
