

import junit.framework.*;


public class VideoStoreTest extends TestCase
{

	public VideoStoreTest (String name) {
		super (name);
	}

	protected void setUp ()  {
		customer = new Customer ("Fred");
	}

	public void testSingleNewReleaseStatement () {
		//Given
		Movie movie = new NewReleaseMovie("The Cell");

		//When
		customer.rentMovie(movie, 3);

		//Then
		String expected = "Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n";
		assertEquals (expected, customer.printStatement());
	}

	public void testDualNewReleaseStatement () {
		customer.rentMovie(new NewReleaseMovie ("The Cell"), 3);
		customer.rentMovie(new NewReleaseMovie ("The Tigger Movie"), 3);

		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.printStatement());
	}

	public void testSingleChildrensStatement () {
		customer.rentMovie(new ChildrensMovie ("The Tigger Movie"), 3);

		assertEquals ("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.printStatement());
	}

	public void testMultipleRegularStatement () {
		customer.rentMovie(new RegularMovie ("Plan 9 from Outer Space"), 1);
		customer.rentMovie(new RegularMovie ("8 1/2"), 2);
		customer.rentMovie(new RegularMovie ("Eraserhead"), 3);

		assertEquals ("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.printStatement());
	}

	private Customer customer;

//	private Movie setupMovie(String title, Movie.MovieType type)
//	{
//		return new Movie(title, type);
//	}
}