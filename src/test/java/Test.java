import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuber on 2016/2/17.
 */
public class Test {
    public static void main(String[] args){
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
    }
}
