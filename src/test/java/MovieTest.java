import junit.framework.*;


/**
 * Created by farzanarassul on 1/9/17.
 */
public class MovieTest extends TestCase {


    public void test_Should_Get_Base_Cost_For_Childrens_Movie(){

        //Given
        Movie movie = new ChildrensMovie("Test");
        int days = 5;

        //When
        double result = movie.calculateCost(days);

        //Then
        assertEquals(4.5 , result);
    }


    public void test_Should_Get_Base_Cost_For_Regular_Movie(){

        //Given
        Movie movie = new RegularMovie("Test");
        int days = 3;

        //When
        double result = movie.calculateCost(days);

        //Then
        assertEquals(3.5, result);
    }

    public void test_Should_Get_Base_Cost_For_New_Release_Movie(){

        //Given
        Movie movie = new NewReleaseMovie("Test");
        int days = 2;

        //When
        double result = movie.calculateCost(days);

        //Then
        assertEquals(6.0, result);
    }


}