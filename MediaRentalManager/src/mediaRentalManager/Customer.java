package mediaRentalManager;

import java.util.ArrayList;

/**
 * Customer class that supports the functionality for the Media Rental Manager.
 * 
 * @author sandrasumesh
 *
 */
public class Customer implements Comparable<Customer> {
	/**
	 * Instance variables.
	 */
	private String name;
	private String address;
	private String plan;
	private ArrayList<String> interestedList;
	private ArrayList<String> recievedList;

	/**
	 * Standard customer constructor. Takes in a name, address, and plan. Creates
	 * new String ArrayLists for receivedList and InterestedList.
	 * 
	 * @param name
	 * @param address
	 * @param plan
	 */
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		recievedList = new ArrayList<String>();
		interestedList = new ArrayList<String>();

	}

	/**
	 * Default customer constructor.
	 */
	public Customer() {
		name = null;
		address = null;
		plan = null;

	}

	/**
	 * Returns the name of the customer.
	 * 
	 * @return
	 */
	public String getName() {
		return name;

	}

	/**
	 * Adds a media to the customers recievedList.
	 * 
	 * @param title
	 * @return
	 */
	public boolean addToQueue(String title) {
		if (interestedList.contains(title)) {
			return false;
		}
		interestedList.add(title);
		return true;
	}

	/**
	 * Removes a media from the customers recievedList.
	 * 
	 * @param title
	 * @return
	 */
	public boolean removeFromQueue(String title) {
		if (interestedList.contains(title)) {
			interestedList.remove(title);
			return true;
		}
		return false;
	}

	/**
	 * Overloading method for removeFromQueue that takes in an int.
	 * 
	 * @param x
	 * @return
	 */
	public boolean removeFromQueue(int x) {
		if (interestedList.remove(x) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns queued String ArrayList.
	 * 
	 * @return
	 */
	public ArrayList<String> getInterestedList() {
		return interestedList;
	}

	/**
	 * Sets queued String ArrayList.
	 * 
	 * @param interestedList
	 */
	public void setInterestedList(ArrayList<String> interestedList) {
		this.interestedList = interestedList;
	}

	/**
	 * Returns rented String ArrayList.
	 * 
	 * @return
	 */
	public ArrayList<String> getRecievedList() {
		return recievedList;
	}

	/**
	 * Sets rented String ArrayList.
	 * 
	 * @param recievedList
	 */
	public void setRecievedList(ArrayList<String> recievedList) {
		this.recievedList = recievedList;
	}

	/**
	 * Sets customers name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns customers address.
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets customers address.
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns customers plan.
	 * 
	 * @return
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * Sets customers plan.
	 * 
	 * @param plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}

	/**
	 * Returns a number based on how the name compares the the Customer parameter
	 * that was taken in.
	 */
	public int compareTo(Customer c) {
		return name.compareTo(c.name);
	}

	/**
	 * Standard toString method for Customer.
	 */
	@Override
	public String toString() {
		return "Name: " + name + ", Address: " + address + ", Plan: " + plan + '\n' + "Rented: " + recievedList + '\n'
				+ "Queue: " + interestedList;
	}

}