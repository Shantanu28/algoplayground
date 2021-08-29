package org.algo.practice.arrays;

import java.util.Arrays;

/**
 * @author Shantanu Singh on 8/21/21.
 *
 * def is_rotate(A, B):
 * 	if A.length != B.length: return false
 *
 * 	key = A[0], key_i = -1
 * 	for i from 0 to B.length - 1 :
 * 		if B[i] == key :
 * 			key_i = i
 * 			break
 *
 * 	if key_i == -1 : return false
 *
 * 	for i from 0 to A.length - 1 :
 * 		j = (key_i + i) % A.length
 * 		if A[i] != B[j] :
 * 			return false
 *
 * 	return true
 */
public class Problem3 {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] array2a = { 4, 5, 6, 7, 8, 1, 2, 3 };
        // isRotation(array1, array2a) should return false.
        System.out.println("args = " + isRotation(array1, array2a));

        int[] array2b = { 4, 5, 6, 7, 1, 2, 3 };
        // isRotation(array1, array2b) should return true.
        System.out.println("args = " + isRotation(array1, array2b));

        int[] array2c = { 4, 5, 6, 9, 1, 2, 3 };
        // isRotation(array1, array2c) should return false.
        System.out.println("args = " + isRotation(array1, array2c));

        int[] array2d = { 4, 6, 5, 7, 1, 2, 3 };
        // isRotation(array1, array2d) should return false.
        System.out.println("args = " + isRotation(array1, array2d));

        int[] array2e = { 4, 5, 6, 7, 0, 2, 3 };
        // isRotation(array1, array2e) should return false.
        System.out.println("args = " + isRotation(array1, array2e));

        int[] array2f = { 1, 2, 3, 4, 5, 6, 7 };
        // isRotation(array1, array2f) should return true.
        System.out.println("args = " + isRotation(array1, array2f));
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;

        int key = array1[0];
        int keyIndex = -1;

        for (int i = 0; i < array2.length; i++) {
            if (array2[i] == key) {
                keyIndex = i;
                break;
            }
        }

        if (keyIndex == -1) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            int j = (keyIndex + i) % array1.length;

            if (array1[i] != array2[j]) {
                return false;
            }
        }

        return true;
    }
}
