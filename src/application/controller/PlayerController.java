package application.controller;

import application.Playlist;
import application.Song;
import application.uiComponents.ProgressSlider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class PlayerController {

	private static final PlayerController playerController = new PlayerController();

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
		updateCurrentSong(currentPlaylist.get(0));
	}

	public void updateCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
		if (audioPlayer != null)
			if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING)
				return;

		audio = new Media("file:///" + currentSong.getAudioFilePath());
		// video = new Media("file:///" + song.getVideoFilePath());
		audioPlayer = new MediaPlayer(audio);
		// videoPlayer = new MediaPlayer(video);
		// videoView = new MediaView (videoPlayer);
	}
	
	public void startPlaylist() {
		updateCurrentSong(currentPlaylist.get(0));
		play();
	}

	public MediaPlayer getAudioPlayer() {
		return audioPlayer;
	}

	public MediaPlayer getVideoPlayer() {
		return videoPlayer;
	}

	public void play() {
		// TODO: currentSong != null? bzw. audioPlayer != null?
		audioPlayer.play();
	}
	

	public void pause() {
//		if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
			audioPlayer.pause();
			// videoPlayer.pause();
//		}
	}

	public void nextSong() {
		if (currentPlaylist.indexOf(currentSong) + 1 != currentPlaylist.size()) {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media("file:///" + currentPlaylist.get(currentPlaylist.indexOf(currentSong) + 1).getAudioFilePath());
			setCurrentSong(currentPlaylist.get(currentPlaylist.indexOf(currentSong) + 1));
			// video = new Media ("file:///" +
			// allSongs.get(allSongs.indexOf(song)+1).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			// videoPlayer = new MediaPlayer(video);
			// videoView = new MediaView (videoPlayer);
			audioPlayer.play();
		} else {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media("file:///" + currentPlaylist.get(0).getAudioFilePath());
			// video = new Media ("file:///" + allSongs.get(0).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			// videoPlayer = new MediaPlayer(video);
			// videoView = new MediaView (videoPlayer);
			audioPlayer.play();
		}
	}

	public void previousSong() {

		if (audioPlayer.getCurrentTime().greaterThanOrEqualTo(Duration.seconds(2)) || currentPlaylist.indexOf(currentSong) == 0) {
			audioPlayer.seek(Duration.seconds(0));
			// videoPlayer.seek(Duration.seconds(0));
		}
		else {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media("file:///" + currentPlaylist.get(currentPlaylist.indexOf(currentSong) - 1).getAudioFilePath());
			setCurrentSong(currentPlaylist.get(currentPlaylist.indexOf(currentSong) - 1));

			// video = new Media ("file:///" +
			// allSongs.get(allSongs.indexOf(song)-1).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			// videoPlayer = new MediaPlayer(video);
			// videoView = new MediaView (videoPlayer);
			audioPlayer.play();
		}
	}

	public void search() {

	}

	public void volumeChange(ProgressSlider volumeSlider) {
		if (audioPlayer != null)
			audioPlayer.setVolume(volumeSlider.getValue() * 0.01);
	}
}
