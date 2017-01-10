
import java.util.ArrayList;

public class Customer
{

    double totalAmount 			= 0;
    int	frequentRenterPoints 	= 0;

	public Customer (String name) {
		this.name = name;
	}

	public String getName () {
		return name;
	}
	
	public String printStatement() {

		String	result = "Rental Record for " + getName () + "\n";

		for(Rental rental :  this.rentals){

			result += "\t" + rental.title + "\t"
								+ rental.cost + "\n";

		}
		
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}



	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();

    public void rentMovie(Movie movie, int daysRented) {

        double cost = movie.calculateCost(daysRented);
        Rental rental = new Rental(movie.getTitle(), cost);

        this.rentals.add(rental);

        frequentRenterPoints += movie.calculateFrequentRentalPoints(daysRented);
        totalAmount += cost;

    }
}