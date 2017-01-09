

public class Movie
{
	public enum MovieType{
		REGULAR(0),
		NEW_RELEASE(1),
		CHILDRENS(2);

		public final int value;

		MovieType(int value){
			this.value = value;
		}
	}

	private String title;
	private MovieType type;
	private int priceCode;
	
	public Movie (String title, MovieType type) {
		this.title = title;
		this.type = type;
		this.priceCode 	= GetPriceCode(type);
	}
	
	public int getPriceCode () {
		return priceCode;
	}

	public MovieType getMovieType(){
		return type;
	}

	public String getTitle () {
		return title;
	}

	private int GetPriceCode(MovieType type) {
		return type.value;
	}
	
}