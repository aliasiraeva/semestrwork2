public class FenvikTree {
    private int size;
    private int[] tree;

    private long time;
    private long operations;

    public FenvikTree() {
        initialize(new int[0]);
    }

    public FenvikTree(int[] list) {
        initialize(list);
    }

    private void initialize(int[] list) {
        size = list.length;
        tree = new int[size];
        for (int i = 0; i < size; i++) {
            increase(i, list[i]);
        }
    }

    public int[] getTree() {
        return tree;
    }

    private void increase(int i, int diff) {
        while (i < size) {
            tree[i] += diff;
            i = i | (i + 1);
            operations++;
        }
    }

    public int sum(int i) {
        if (i == 0) {
            return tree[0];
        }
        int res = 0;
        while (i >= 0) {
            res += tree[i];
            i = (i & (i + 1)) - 1;
            operations++;
        }
        return res;
    }

    public int sum(int l, int r) {
        return (l != 0) ? sum(r) - sum(l - 1) : sum(r);
    }

    public int search(int i) {
        return sum(i, i);
    }

    public void append(int newValue) {
        int[] list;
        if (size > 0) {
            list = new int[size + 1];
            for (int j = 0; j < size; j++) {
                list[j] = search(j);
            }
            list[size] = newValue;
        } else {
            list = new int[] {newValue};
        }
        initialize(list);
    }

    public void remove(int removeIndex) {
        int[] list = new int[size];
        for (int j = 0; j < size; j++) {
            list[j] = search(j);
        }
        list = ArrayUtils.remove(list, removeIndex);
        initialize(list);
    }
    public void initMetrics() {
        time = System.nanoTime();
        operations = 0;
    }

    public String metricsInfo() {
        return (System.nanoTime() - time) / 1000.0 + ", " + operations;
    }
}
