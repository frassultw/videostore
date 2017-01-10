/**
 * Created by farzanarassul on 1/10/17.
 */
public class ChildrensMovie extends Movie {

    private double baseCost = 1.5;
    public int frequentRenterPoints = 1;

    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public double calculateCost(int days){
        if (days > 3)
            baseCost += (days - 3) * 1.5;
        return baseCost;
    }

}
