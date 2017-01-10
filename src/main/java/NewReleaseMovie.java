/**
 * Created by farzanarassul on 1/10/17.
 */
public class NewReleaseMovie extends Movie {

    private double baseCost = 0;


    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    protected double calculateCost(int days) {
        baseCost += days * 3;
        return baseCost;
    }

    @Override
    protected int calculateFrequentRentalPoints(int days) {
        if(days > 1){
            return 2;
        }
        return super.calculateFrequentRentalPoints(days);
    }
}
