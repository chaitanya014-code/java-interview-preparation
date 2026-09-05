import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15, 3, 6};
        int target = 9;

        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {

            int complement = target - number;

            if (set.contains(complement)) {
                System.out.println(
                    complement + " + " + number + " = " + target
                );
            }

            set.add(number);
        }
    }
}
