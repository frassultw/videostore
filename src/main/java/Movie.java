

public abstract class Movie
{
	public Movie(String title) {
		this.title = title;
	}

	private String title;

	protected double baseCost;

	protected double calculateCost(int days) {
		return baseCost;
	}

	protected int calculateFrequentRentalPoints(int days)
	{
		return 1;
	}

	public String getTitle () {
		return title;
	}

	
}