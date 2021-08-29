package org.algo.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shantanu Singh on 8/21/21.
 */
public class Problem1 {


    /*
    * def common_element(A,B):
	p1 = 0
	p2 = 0
	result = [] //arraylist in java
	while p1 < A.length and p2 < B.length :
		if A[p1] == B[p2] :
			result.add(A[p1])
			p1 += 1
			p2 += 1
		else if A[p1] > B[p2] :
			p2 += 1
		else :
			p1 += 1
	return result
	* */
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = { 1, 3, 1, 3, 2, 1 };
        System.out.println("args = " + mostFreqent(array1));;

        // mostFrequent(array2) should return 3.
        int[] array2 = { 3, 3, 1, 3, 2, 1 };
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = { 0 };
        // mostFrequent(array5) should return -1.
        int[] array5 = { 0, -1, 10, 10, -1, 10, -1, -1, -1, 1 };
    }

    // Implement your solution below.
    public static Integer mostFreqent(int[] givenArray) {
        Integer maxItem = null;
        Integer maxCount = -1;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (Integer num : givenArray) {
            if (! hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                Integer count = hashMap.get(num);
                hashMap.put(num, count + 1);
            }

            if (hashMap.get(num) > maxCount) {
                maxCount = hashMap.get(num);
                maxItem = num;
            }
        }

        return maxItem;
    }
}
