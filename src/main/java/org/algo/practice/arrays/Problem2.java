package org.algo.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Shantanu Singh on 8/21/21.
 */
public class Problem2 {

    /*

def frequent_number(given_array):
	max_item = null, max_count = -1
	count = {} //hashmap

	for item in given_array :
		if item is not in count:
			count[item] = 1
		else:
			count[item] += 1

		if count[item] > max_count:
			max_count = count[item]
			max_item = item
	return max_item
    */

    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        int[] array1A = { 1, 3, 4, 6, 7, 9 };
        int[] array2A = { 1, 2, 4, 5, 9, 10 };
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).
        System.out.println("args = " + Arrays.toString(commonElements(array1A, array2A)));

        int[] array1B = { 1, 2, 9, 10, 11, 12 };
        int[] array2B = { 0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15 };
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).
        System.out.println("args = " + Arrays.toString(commonElements(array1B, array2B)));

        int[] array1C = { 0, 1, 2, 3, 4, 5 };
        int[] array2C = { 6, 7, 8, 9, 10, 11 };
        // commonElements(array1C, array2C) should return [] (an empty array).
        System.out.println("args = " + Arrays.toString(commonElements(array1C, array2C)));
    }

    // Implement your solution below.
    // NOTE: Remember to return an Integer array, not an int array.
    public static Integer[] commonElements(int[] array1, int[] array2) {
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> resultInArray = new ArrayList<>();

        while (p1 < array1.length && p2 < array2.length) {
            if (array1[p1] == array2[p2]) {
                resultInArray.add(array1[p1]);
                p1 += 1;
                p2 += 1;
            } else if (array1[p1] > array2[p2]) {
                p2 += 1;
            } else {
                p1 += 1;
            }
        }
        return resultInArray.stream()
            .toArray(Integer[]::new);
    }
}
