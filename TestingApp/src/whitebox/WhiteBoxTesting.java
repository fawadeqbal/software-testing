/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whitebox;

/**
 *
 * @author fawad
 */
public class WhiteBoxTesting {

    public static int isCentered(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length % 2 == 0) {
            return 0;
        }
        int middleIndex = arr.length / 2;

        for (int i = 0; i < arr.length; i++) {
            if (i != middleIndex && arr[i] <= arr[middleIndex]) {
                return 0;
            }
        }
        return 1;
    }
}
