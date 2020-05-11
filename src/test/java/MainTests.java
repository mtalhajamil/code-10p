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

    @Test
    public void sortByEvenOdd_maintainSequence_success() {
        Main main = new Main();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,4,3,7,16));
        List<Integer> sorted = main.sortByEvenOdd(list);

        Assert.assertTrue("Sequence of number with odd even sequence should be maintained",!isSequenceBroken(list,sorted));
    }

    @Test
    public void isSequenceBroken_invalidSequence_fail() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,4,3,7,16));
        List<Integer> sorted = new ArrayList<>(Arrays.asList(4,2,1,3,7,16));

        Assert.assertTrue("Sequence of number with odd even sequence should not be maintained",isSequenceBroken(list,sorted));
    }

    private boolean isSequenceBroken(List<Integer> list, List<Integer> sorted) {
        Integer oddIndex = 0;
        Integer evenIndex = 0;
        Integer secondLoopIndex = 0;
        for(Integer num:sorted){

            boolean isEven = false;
            if(num % 2 == 0){
                secondLoopIndex = evenIndex;
                isEven = true;
            } else {
                secondLoopIndex = oddIndex;
            }

            for(int j=secondLoopIndex;j<list.size();j++){

                if(isEven){
                    evenIndex++;
                }else{
                    oddIndex++;
                }

                if(list.get(j) % 2 == 0){
                    if(isEven){
                        if(num != list.get(j)){
                            return true;
                        }
                        break;
                    }
                } else{
                    if(!isEven){
                        if(num != list.get(j)){
                            return true;
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }


}
