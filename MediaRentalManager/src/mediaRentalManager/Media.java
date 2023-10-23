package mediaRentalManager;

/**
 * Media class that supports the functionality for Media Rental Manager.
 * 
 * @author sandrasumesh
 *
 */
public class Media implements Comparable<Media> {
	/**
	 * Instance variables. String title and int number of copies.
	 */
	private String title;
	private int numOfCopies;

	/**
	 * Standard constructor for Media. Takes in a title and number of copies.
	 * 
	 * @param title
	 * @param numOfCopies
	 */

	public Media(String title, int numOfCopies) {
		this.title = title;
		this.numOfCopies = numOfCopies;
	}

	/**
	 * Media constructor that only takes in a media.
	 * 
	 * @param media
	 */
	public Media(Media media) {
		this.title = media.title;
		this.numOfCopies = media.numOfCopies;
	}

	/**
	 * Sets the title of the media
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the title of the media.
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the number of copies of a media object. Takes in number of copies.
	 * 
	 * @param numOfCopies
	 */
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	/**
	 * Returns the number of copies.
	 * 
	 * @return
	 */
	public int getNumOfCopies() {
		return numOfCopies;
		/**
		 * Decreases the number of copies by one
		 */
	}

	public void decreaseNumOfCopies() {
		this.numOfCopies--;
	}

	/**
	 * Increases the number of copies by one.
	 */
	public void increaseNumOfCopies() {
		this.numOfCopies++;
	}

	/**
	 * Returns a number based on how the title compares the the media parameter that
	 * was taken in.
	 */
	@Override
	public int compareTo(Media media) {
		return title.compareTo(media.title);

	}

}
