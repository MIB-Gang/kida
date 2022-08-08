package application.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class MediaController {
	
	//TODO ALLES
	private static ObservableList<Song> allSongs = FXCollections.observableArrayList();
	
	public void scanForMedia() {
		List<String> pathList = new ArrayList<>();

		try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/" + System.getProperty("user.name") + "/Music"))) { // System.getProperty("user.name") gibt Benutzernamen
			// Sucht nach Dateipfaden, wandelt diese in Strings um, schaut ob diese Strings jeweils mit "mp3" enden und wenn ja, speichert sie in Liste
			pathList = paths.map(path -> path.toString().toLowerCase().replace("\\", "/")).filter(path -> path.endsWith("mp3")).collect(Collectors.toList());
		} catch (IOException error) {
			error.getMessage();
		}

				
		for (String path: pathList) allSongs.add(new Song("t",1,"a","album","g","m",false, path,"vFP"));

		// TODO: Austauschen mit richtigen Song-Infos (Metadaten / "properties()")
		
		for (Song song: allSongs) System.out.println(song.getAudioFilePath());
	}
	
	public static ObservableList<Song> getAllSongs() {
		return allSongs;
	}
	
	public void playPlaylist(MouseEvent event) {
		
	}

	public void playSong(Song song) {
		Media media = new Media("file:///" + song.getAudioFilePath()); // "file:///" => außerhalb dieses Java-Projekts
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
	
	public void pause() {
		
	}
	
	public void search() {
		
	}
	
	public void sort() {
		
	}
	
	public void addLibrary() {
		
	}
	
	public void changeDate() {
		
	}
	
	public void deleteLibrary() {
		
	}
	
	public void generatePlaylist() {
		
	}
	
	public void createPlaylist() {
		
	}


	//TODO seekbar, volume
}
