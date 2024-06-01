package util.Arrays;
public class RemoveDuplicates {
    public static int removeDuplicates(int[] array) {
        if (array.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[j]) {
                j++;
                array[j] = array[i];
            }
        }
        return j + 1;
    }
}
