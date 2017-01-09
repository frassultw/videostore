
import java.util.ArrayList;

public class Customer 
{
	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add(rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		String 				result 					= "Rental Record for " + getName () + "\n";

		for(Rental rental :  this.rentals){
			double 	thisAmount = 0;
			Movie movie = rental.getMovie();

			// determines the amount for each line
			switch (movie.getMovieType()) {
				case REGULAR:
					thisAmount = calculateRegularAmount(rental);

					break;
				case NEW_RELEASE:
					thisAmount = calculateNewReleaseAmount(rental);

					if (rental.getDaysRented () > 1)
						frequentRenterPoints++;
					break;

				case CHILDRENS:
					thisAmount = calculateChildrensAmount(rental);
					break;
			}
			
			frequentRenterPoints++;

				
			result += "\t" + movie.getTitle () + "\t"
								+ String.valueOf (thisAmount) + "\n";
			totalAmount += thisAmount;
				
		}
		
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}

	private double calculateChildrensAmount(Rental rental) {
		double thisAmount = 1.5;
		if (rental.getDaysRented () > 3)
            thisAmount += (rental.getDaysRented () - 3) * 1.5;
		return thisAmount;
	}

	private double calculateNewReleaseAmount(Rental rental) {
		double thisAmount = 0;
		thisAmount += rental.getDaysRented () * 3;
		return thisAmount;
	}

	private double calculateRegularAmount(Rental rental) {
		double thisAmount = 2;
		if (rental.getDaysRented () > 2)
            thisAmount += (rental.getDaysRented () - 2) * 1.5;
		return thisAmount;
	}


	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();
}