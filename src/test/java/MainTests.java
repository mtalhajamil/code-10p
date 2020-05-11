import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Muhammad Talha Jamil
 * Date: 11-May-20
 */
public class MainTests {

    @Test
    public void sortByEvenOdd_oddBeforeEven_success() {
        Main main = new Main();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,4,3,7,16));
        List<Integer> sorted = main.sortByEvenOdd(list);
        boolean firstEven = false;
        for(Integer num:sorted){
            if(firstEven){
                Assert.assertTrue("No odd number should be after even number",num % 2 == 0);
            }

            if(!firstEven && num % 2 == 0){
                firstEven = true;
            }
        }
    }
}
