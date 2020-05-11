import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,4,3,7,16));
        sortByEvenOdd(list);
    }

    public static List<Integer> sortByEvenOdd(List<Integer> list) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(Integer num:list){
            if(num%2==0)
                even.add(num);
            else
                odd.add(num);
        }
        odd.addAll(even);
        return odd;
    }
}
