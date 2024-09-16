public class ArrayUtils {

    public static int[] insert(int[] list, int newIndex, int newValue) {
        int[] newList = new int[list.length + 1];
        for (int j = 0; j <= newIndex - 1; j++) {
            newList[j] = list[j];
        }
        newList[newIndex] = newValue;
        for (int j = newIndex + 1; j < list.length + 1; j++) {
            newList[j] = list[j - 1];
        }
        return newList;
    }

    public static int[] remove(int[] list, int removeIndex) {
        int[] newList = new int[list.length - 1];
        for (int j = 0; j < removeIndex; j++) {
            newList[j] = list[j];
        }
        for (int j = removeIndex + 1; j < list.length; j++) {
            newList[j - 1] = list[j];
        }
        return newList;
    }
}
