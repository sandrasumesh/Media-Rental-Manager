package mediaRentalManager;

import java.util.ArrayList;

/**
 * Album Class that supports the functionality of Media Rental Manager. Is an
 * extension of Media Class.
 */

public class Album extends Media {

	/**
	 * Instance variables.
	 */
	private String artist;
	private String songs;

	/**
	 * Standard constructor for Album.
	 * 
	 * @param title
	 * @param numOfCopies
	 * @param artist
	 * @param songs
	 */
	public Album(String title, int numOfCopies, String artist, String songs) {
		super(title, numOfCopies);
		this.artist = artist;
		this.songs = songs;
	}

	/**
	 * Sets artist of an Album.
	 * 
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;

	}

	/**
	 * Returns an artist of an album.
	 * 
	 * @return
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets a song of an Album.
	 * 
	 * @param songs
	 */
	public void setSong(String songs) {
		this.songs = songs;
	}

	/**
	 * Returns songs of an album.
	 * 
	 * @return
	 */
	public String getSongs() {
		return songs;
	}

	/**
	 * Standard toString method for Album Class.
	 */
	public String toString() {
		return "Title: " + getTitle() + ", Copies Available: " + getNumOfCopies() + ", Artist: " + getArtist()
				+ ", Songs: " + getSongs();
	}

}
