package mediaRentalManager;

/**
 * Movie Class that supports the functionality of Media Rental Manager. Is an
 * extension of Media Class.
 */
public class Movie extends Media {

	/**
	 * Instance variable.
	 */
	private String rating;

	/**
	 * Standard Movie constructor.
	 * 
	 * @param title
	 * @param numOfCopies
	 * @param rating
	 */
	public Movie(String title, int numOfCopies, String rating) {
		super(title, numOfCopies);
		this.rating = rating;
	}

	/**
	 * Sets rating of a movie.
	 * 
	 * @param rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Returns the rating of a movie.
	 * 
	 * @return
	 */
	public String getRating() {
		return rating;

	}

	/**
	 * Standard toString method for Movie class.
	 */
	public String toString() {
		return "Title: " + getTitle() + ", Copies Available: " + getNumOfCopies() + ", Rating: " + rating;
	}

}
