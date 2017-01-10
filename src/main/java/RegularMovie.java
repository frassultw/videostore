/**
 * Created by farzanarassul on 1/10/17.
 */
public class RegularMovie extends Movie {

    private double baseCost = 2;

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    protected double calculateCost(int days) {

        if (days > 2)
            baseCost += (days - 2) * 1.5;
        return baseCost;
    }
}
