package application.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


public class MediaController {
	
	Media audio;
	Media video;
	MediaPlayer audioPlayer;
	MediaPlayer videoPlayer;
	MediaView videoView;
	
	/* TODO ALLES */
	private static ObservableList<Song> allSongs = FXCollections.observableArrayList();
	public static ObservableList<Song> getAllSongs() { return allSongs; }
	public static void clearAllSongs() { allSongs.clear(); }
	
	public void scanForMedia() {
		clearAllSongs();
		List<String> pathList = new ArrayList<>();

		try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/" + System.getProperty("user.name") + "/Music"))) { /* System.getProperty("user.name") gibt Benutzernamen */
			/* Sucht nach Dateipfaden, wandelt diese in Strings um, schaut ob diese Strings jeweils mit "mp3" enden und wenn ja, speichert sie in Liste */
			pathList = paths.map(path -> path.toString().toLowerCase().replace("\\", "/")).filter(path -> path.endsWith("mp3")).collect(Collectors.toList());
		} catch (IOException error) {
			error.getMessage();
		}

				
		for (String path: pathList) allSongs.add(new Song(path,1,"a","album","g","m",false, path,"vFP"));

		/* TODO: Austauschen mit richtigen Song-Infos (Metadaten / "properties()") */
		
		for (Song song: allSongs) System.out.println(song.getAudioFilePath());
	}
	
	public Media getMedia() {
		return audioPlayer.getMedia();
	}
	
	public Media getAudioPlayer() {
		return null;
		
	}
	
	public Media getVideoPlayer(){
		return null;
		
	}
	
	public void playPlaylist(MouseEvent event) {
		
	}

	public void playSong(Song song) {
		
		/* Ich musste diese Zeile ändern, weil Status nicht überprüft werden kann, wenn noch kein audioPlayer erstellt wurde (null) */
		if (audioPlayer != null) if (audioPlayer.getStatus() == MediaPlayer.Status.PLAYING) return; /* return => Abbruch */
		
		audio = new Media("file:///" + song.getAudioFilePath());
		//video = new Media("file:///" + song.getVideoFilePath());
		audioPlayer = new MediaPlayer(audio);
		//videoPlayer = new MediaPlayer(video);
		//videoView = new MediaView (videoPlayer);
		audioPlayer.play();
 
	}
	
	public void pause() {
		if (audioPlayer.getStatus()==MediaPlayer.Status.PLAYING) {
			audioPlayer.pause();
			//videoPlayer.pause();
		}	
	}
	
	public void nextSong(Song song) {
		if (allSongs.indexOf(song)!= allSongs.size()) {
			audioPlayer.stop();
			//videoPlayer.stop();
			audio = new Media("file:///" + allSongs.get(allSongs.indexOf(song)+1).getAudioFilePath());
			//video = new Media ("file:///" + allSongs.get(allSongs.indexOf(song)+1).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			//videoPlayer = new MediaPlayer(video);
			//videoView = new MediaView (videoPlayer);
			audioPlayer.play();
		}
		else {
			audioPlayer.stop();
			//videoPlayer.stop();
			audio = new Media("file:///" + allSongs.get(0).getAudioFilePath());
			//video = new Media ("file:///" + allSongs.get(0).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			//videoPlayer = new MediaPlayer(video);
			//videoView = new MediaView (videoPlayer);
			audioPlayer.play();
		}
	}
	
	public void previousSong(Song song) {
		
		if (audioPlayer.getCurrentTime().greaterThanOrEqualTo(Duration.seconds(5)) || allSongs.indexOf(song) == 0 ){
			audioPlayer.seek(Duration.seconds(0));
			//videoPlayer.seek(Duration.seconds(0));
		}
		/* if (allSongs.indexOf(song)>=1) { */
		else {
			audioPlayer.stop();
			//videoPlayer.stop();
			audio = new Media("file:///" + allSongs.get(allSongs.indexOf(song)-1).getAudioFilePath());
			//video = new Media ("file:///" + allSongs.get(allSongs.indexOf(song)-1).getVideoFilePath());
			audioPlayer = new MediaPlayer(audio);
			//videoPlayer = new MediaPlayer(video);
			//videoView = new MediaView (videoPlayer);
			audioPlayer.play();
			}
	}
	
	public void search() {
		
	}
	
	public void sort() {
		
	}
	
	public void addLibrary() {
		
	}
	
	public void changeDate(Scanner scan, Song song) {
		
	}
	
	public void deleteLibrary() {
		
	}
	
	public void generatePlaylist() {
		
	}
	
	public void createPlaylist() {
		
	}


	/* TODO seekbar, volume */
}
