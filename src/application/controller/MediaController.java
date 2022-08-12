package application.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.Playlist;
import application.Song;
import application.uiComponents.ProgressSlider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaController {

	private static final MediaController controller = new MediaController();

	public static MediaController getInstance() {
		return controller;
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

	/* TODO ALLES */
	private ObservableList<Song> allSongs = FXCollections.observableArrayList();

	public ObservableList<Song> getAllSongs() {
		return allSongs;
	}
	
	public void addToAllSongs(Song song) {
		allSongs.add(song);
	}

	public void clearAllSongs() {
		allSongs.clear();
	}

	public Song getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}

//	public void scanForMedia() {
//		clearAllSongs();
//		List<Path> pathList = new ArrayList<>();
//
//		try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/" + System.getProperty("user.name") + "/Music"))) {
//			// pathList = paths.map(path -> path.toString().toLowerCase().replace("\\",
//			// "/")).filter(path -> path.endsWith("mp3")).collect(Collectors.toList());
//			pathList = paths.filter(path -> path.toString().toLowerCase().endsWith("mp3")).collect(Collectors.toList());
//		} catch (IOException error) {
//			error.getMessage();
//		}
//
//		for (Path path : pathList) {
//			String pathString = path.toString().toLowerCase().replace("\\", "/");
//			allSongs.add(new Song(pathString, "a", "album", "g", false, pathString, "vFP"));
//		}
//
//		/* TODO: Austauschen mit richtigen Song-Infos (Metadaten / "properties()") */
//
//		for (Song song : allSongs)
//			System.out.println(song.getAudioFilePath());
//	}
	
	public void proStart() {
		setCurrentSong(currentPlaylist.get(0));
		playSong(currentSong);
	}

	public MediaPlayer getAudioPlayer() {
		return audioPlayer;
	}

	public MediaPlayer getVideoPlayer() {
		return videoPlayer;
	}

	public void playPlaylist(MouseEvent event) {

	}

	public void play() {
		audioPlayer.play();
	}
	public void playSong(Song song) {
		if (audioPlayer != null)
			if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING)
				return; /* return => Abbruch */

		audio = new Media("file:///" + song.getAudioFilePath());
		// video = new Media("file:///" + song.getVideoFilePath());
		audioPlayer = new MediaPlayer(audio);
		// videoPlayer = new MediaPlayer(video);
		// videoView = new MediaView (videoPlayer);
		audioPlayer.play();
	}

	public void pause() {
//		if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
			audioPlayer.pause();
			// videoPlayer.pause();
//		}
	}

	public void nextSong() {
		if (allSongs.indexOf(currentSong) != currentPlaylist.size()) {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media("file:///" + currentPlaylist.get(currentPlaylist.indexOf(currentSong) + 1).getAudioFilePath());
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

		if (audioPlayer.getCurrentTime().greaterThanOrEqualTo(Duration.seconds(5)) || currentPlaylist.indexOf(currentSong) == 0) {
			audioPlayer.seek(Duration.seconds(0));
			// videoPlayer.seek(Duration.seconds(0));
		}
		/* if (allSongs.indexOf(song)>=1) { */
		else {
			audioPlayer.stop();
			// videoPlayer.stop();
			audio = new Media("file:///" + currentPlaylist.get(currentPlaylist.indexOf(currentSong) - 1).getAudioFilePath());
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

	/* TODO seekbar, volume */
}
