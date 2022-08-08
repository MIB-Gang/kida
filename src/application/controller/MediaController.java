package application.controller;

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
	
	//private List<Song> allSongs = new ArrayList<>();
	private static ObservableList<Song> allSongs = FXCollections.observableArrayList();
	//TODO Filepath wird ben�tigt nur, um die Lieder abzuspielen
	
	public void scanForMedia() {
		// "file:///" + pathList.get(0).replace("\\", "/"
		List<String> pathList = new ArrayList<>();

		try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/" + System.getProperty("user.name") + "/Music"))) {
			pathList = paths.map(path -> path.toString().toLowerCase().replace("\\", "/")).filter(path -> path.endsWith("mp3")).collect(Collectors.toList());
		} catch (IOException error) {
			error.getMessage();
		}
				
		for (String path: pathList) allSongs.add(new Song("t","a","g","m",false, path,"vFP"));
		for (Song song: allSongs) System.out.println(song.getAudioFilePath());
	}
	
	public static ObservableList<Song> getAllSongs() {
		return allSongs;
	}
	
	public void playPlaylist(MouseEvent event) {
		
	}

	public void playSong(Song song) {
		Media media = new Media("file:///" + song.getAudioFilePath());
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
