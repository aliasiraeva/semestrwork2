import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.random.RandomGenerator;

public class Main {
    public static final String DATA_FILE = "semestr-work-2.txt";

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(DATA_FILE)) {
            DataOutputStream outputStream = new DataOutputStream(fileOutputStream);

            int size = 10000;
            int[] list = RandomUtils.generateList(size);
            FenvikTree tree = new FenvikTree();

            outputStream.writeChars("Add elements\n");
            for (int i = 0; i < size; i++) {
                tree.initMetrics();
                tree.append(list[i]);
                outputStream.writeChars(i + ", " + tree.metricsInfo() + "\n");
            }

            outputStream.writeChars("Search elements\n");
            for (int i = 0; i < 1000; i++) {
                tree.initMetrics();
                tree.search(RandomGenerator.getDefault().nextInt(size));
                outputStream.writeChars(i + ", " + tree.metricsInfo() + "\n");
            }

            outputStream.writeChars("Remove elements\n");
            for (int i = 0; i < 100; i++) {
                tree.initMetrics();
                tree.remove(RandomGenerator.getDefault().nextInt(size - 100));
                outputStream.writeChars(i + ", " + tree.metricsInfo() + "\n");
            }

            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
