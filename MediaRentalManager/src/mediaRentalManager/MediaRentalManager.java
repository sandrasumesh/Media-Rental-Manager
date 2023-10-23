package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaRentalManager implements MediaRentalManagerInt {

	private ArrayList<Customer> customerData = new ArrayList<Customer>();
	private ArrayList<Media> mediaData = new ArrayList<Media>();
	private int limitedPlanLimit;

	public MediaRentalManager() {
		limitedPlanLimit = 2;

	}

	@Override
	public void addCustomer(String name, String address, String plan) {
		customerData.add(new Customer(name, address, plan));

	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {
		if (rating != "PG" && rating != "R" && rating != "NR") {
			throw new IllegalArgumentException("Invalid Rating");
		}
		mediaData.add(new Movie(title, copiesAvailable, rating));

	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		mediaData.add(new Album(title, copiesAvailable, artist, songs));

	}

	@Override
	public void setLimitedPlanLimit(int value) {
		limitedPlanLimit = value;

	}

	@Override
	public String getAllCustomersInfo() {
		String returnString = "***** Customers' Information *****" + '\n';
		Collections.sort(customerData);
		for (int i = 0; i < customerData.size(); i++) {
			String tostring = customerData.get(i).toString();
			returnString += tostring + '\n';
		}
		return returnString;

	}

	@Override
	public String getAllMediaInfo() {
		String returnString = "***** Media Information *****" + '\n';
		Collections.sort(mediaData);
		for (int i = 0; i < mediaData.size(); i++) {
			String tostring = mediaData.get(i).toString();
			returnString += tostring + '\n';
		}
		return returnString;
	}

	@Override
	public boolean addToQueue(String customerName, String mediaTitle) {

		for (int i = 0; i < customerData.size(); i++) {
			if (customerData.get(i).getName().equals(customerName)) {

				return customerData.get(i).addToQueue(mediaTitle);
			}

		}
		return false;
	}

	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		for (int i = 0; i < customerData.size(); i++) {
			if (customerData.get(i).getName().equals(customerName)) {

				return customerData.get(i).removeFromQueue(mediaTitle);
			}

		}
		return false;

	}

	@Override
	public String processRequests() {
		Collections.sort(customerData);

		String returnMessage = "";

		boolean isValid = false;

		for (int i = 0; i < customerData.size(); i++) {
			Customer test = customerData.get(i);

			if (test.getPlan().equals("LIMITED")) {
				for (int j = 0; j < test.getInterestedList().size(); j++) {
					for (int k = 0; k < mediaData.size(); k++) {
						Media media = mediaData.get(k);
						String mediaTitle = media.getTitle();
						if (test.getInterestedList().get(j).equals(mediaData.get(k).getTitle())
								&& mediaData.get(k).getNumOfCopies() > 0) {
							isValid = true;
							mediaData.get(k).decreaseNumOfCopies();
							returnMessage += "Sending " + mediaTitle + " to " + test.getName() + '\n';

							break;
						}

					}
					if (test.getRecievedList().size() < limitedPlanLimit && isValid == true) {
						test.getRecievedList().add(test.getInterestedList().get(j));
						test.removeFromQueue(j);

						j--;

						if (test.getRecievedList().size() == limitedPlanLimit) {
							break;
						}
					}

				}

			}
			if (test.getPlan().equals("UNLIMITED")) {
				for (int j = 0; j < test.getInterestedList().size(); j++) {
					for (int k = 0; k < mediaData.size(); k++) {
						if (test.getInterestedList().get(j).equals(mediaData.get(k).getTitle())
								&& mediaData.get(k).getNumOfCopies() > 0) {
							isValid = true;

							Media media = mediaData.get(k);
							String mediaTitle = media.getTitle();

							returnMessage += "Sending " + mediaTitle + " to " + test.getName() + '\n';
							mediaData.get(k).decreaseNumOfCopies();
							test.getRecievedList().add(test.getInterestedList().get(j));
							test.removeFromQueue(j);
							j--;

							break;
						}

					}

				}
			}
		}

		return returnMessage;
	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		for (int i = 0; i < customerData.size(); i++) {
			if (customerData.get(i).getName().equals(customerName)) {
				for (int j = 0; j < customerData.get(i).getRecievedList().size(); j++) {
					for (int k = 0; k < mediaData.size(); k++) {
						if (customerData.get(i).getRecievedList().get(j).equals(mediaData.get(k).getTitle())) {
							customerData.get(i).getRecievedList().remove(j);
							mediaData.get(k).increaseNumOfCopies();
							return true;
						}
					}
				}

			}
		}
		return false;
	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		Collections.sort(mediaData);
		ArrayList<Media> results = new ArrayList<>();
		for (int i = 0; i < mediaData.size(); i++) {
			if (mediaData.get(i) instanceof Movie) {
				Movie m = (Movie) mediaData.get(i);
				results.add(m);
			}
			if (mediaData.get(i) instanceof Album) {
				Album a = (Album) mediaData.get(i);
				results.add(a);

			}
		}

		for (int i = 0; i < results.size(); i++) {
			if (title != null) {
				if (results.get(i).getTitle().equals(title) == false) {
					results.remove(i);
					i--;
				}

			}

		}

		for (int i = 0; i < results.size(); i++) {

			if (rating != null) {

				if (results.get(i) instanceof Movie) {

					if (((Movie) results.get(i)).getRating().equals(rating) == false) {
						results.remove(i);
						i--;

					}
				} else {
					// System.out.print(results.get(i).getTitle());
					results.remove(i);
					i--;

				}
			}

		}
		for (int i = 0; i < results.size(); i++) {
			if (artist != null) {
				if (results.get(i) instanceof Album) {

					if (((Album) results.get(i)).getArtist().equals(artist) == false) {
						results.remove(i);
						i--;
					}
				} else {
					results.remove(i);
					i--;
				}
			}

		}
		for (int i = 0; i < results.size(); i++) {
			if (songs != null) {
				// System.out.println(results.get(i).getTitle());
				if (results.get(i) instanceof Album) {

					if (!(((Album) results.get(i)).getSongs().contains(songs))) {
						results.remove(i);
						i--;
					}

				} else {
					results.remove(i);
					i--;
				}
			}

		}
		ArrayList<String> returnArr = new ArrayList<>();
		for (Media mediaElement : results) {
			returnArr.add(mediaElement.getTitle());
		}
		return returnArr;
	}

}
