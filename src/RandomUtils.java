import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomUtils {
    public static int[] generateList(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = RandomGenerator.getDefault().nextInt(1000);
        }
        return list;
    }
}
