package rockcountdown;

public class Song {

	private int rank;

	private String title;

	private String artist;


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
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


	// specific constructor
	public Song(int rank, String title, String artist) {
		super();
		this.rank = rank;
		this.title = title;
		this.artist = artist;
	}


	// generic constructor
	public Song(String songProperties) {
		super();
		String[] parts = songProperties.split("\t");
		this.rank = Integer.parseInt(parts[0]);
		this.title = parts[1];
		this.artist = parts[2];
	}


}
