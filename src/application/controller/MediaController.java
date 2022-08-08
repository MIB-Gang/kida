package application.controller;

import java.util.ArrayList;
import java.util.List;

import application.Song;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaController {
	
	//TODO ALLES
	
	List<Song> allSongs = new ArrayList<>();
	//TODO Filepath wird ben�tigt nur, um die Lieder abzuspielen
	
	public void playPlaylist(MouseEvent event) {
		
	}

	public void playSong(MouseEvent event, Song song) {
		Media media = new Media (song.getAudioFilePath());
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
