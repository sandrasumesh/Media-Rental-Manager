package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mediaRentalManager.Customer;
import mediaRentalManager.MediaRentalManager;

public class StudentTests {

	@Test
	public void test() {
		ArrayList <String> result = new ArrayList<>();
		MediaRentalManager test = new MediaRentalManager();
		test.addCustomer("Albert, Mike", "11 Apple Mount VA", "LIMITED");
		test.addCustomer("Park, Laura", "227 Park Lane DC", "UNLIMITED");
		
	//	System.out.print(lol.getAllCustomersInfo());
		test.addAlbum("My Everything", 3, "Ariana Grande", "Problem");
		test.addMovie("Jaws", 2, "PG");
		
		//System.out.print(test.getAllCustomersInfo());
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();		
	
		
		resultsBuffer.append(manager.getAllCustomersInfo());
		//assertTrue(TestingSupport.correctResults("pubTestAddingCustomers.txt", resultsBuffer.toString()));
	}

}
