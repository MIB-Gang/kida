package application;

public class Song {
	private int id;
	private String title;
	private String artist;
	private String genre;
	private String mood;
	private boolean like;
	private String audioFilePath;
	private String videoFilePath;
	
	
	public Song() {
		this.title = "Titel";
		this.artist = "Interpret";
		this.genre = "Genre";
		this.mood = "Stimmung";
		this.like = false;
		this.audioFilePath = "";
		this.videoFilePath = "";
	}
	
	public Song(String title, String artist, String genre, String mood, boolean like, String audioFilePath, String videoFilePath) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.mood = mood;
		this.like = like;
		this.audioFilePath = audioFilePath;
		this.videoFilePath = videoFilePath;
	}

	
	public String getAudioFilePath() {
		return audioFilePath;
	}

	public void setAudioFilePath(String audioFilePath) {
		this.audioFilePath = audioFilePath;
	}

	public String getVideoFilePath() {
		return videoFilePath;
	}

	public void setVideoFilePath(String videoFilePath) {
		this.videoFilePath = videoFilePath;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

}
