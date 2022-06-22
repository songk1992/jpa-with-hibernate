import java.util.Arrays;

public class MyMath {
    int sum(int[] nums){
        return Arrays.stream(nums).sum();
    }
}
