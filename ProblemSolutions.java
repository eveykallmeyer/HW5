/******************************************************************
 *
 *   Evey Kallmeyer / COMP 272-002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // Check if Subset A is null
        if (list1 == null || list1.length == 0) {
            return false;
        }

        // Check if Subset B is null
        if (list2 == null || list2.length == 0) {
            return true;
        }

        // Build a hash set of Subset A
        HashSet<Integer> set = new HashSet<>(Math.max(16, list1.length * 2));
        for (int x : list1) {
            set.add(x);
        }

        // Check for Subset B's elements
        for (int y : list2) {
            if (!set.contains(y)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // Check that length of the array is not null and is at least k long
        if (array == null || array.length == 0 || k < 1 || k > array.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Create a minHeap with a size of k
        // Use a minheap so you know the smallest integers are towards the root/start of the array
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Check each element in the array
        for (int num : array) {
            minHeap.offer(num);
            // Check if the heap has more than k elements, and if so, remove the root
            // Make once the heap is down to k elements, the root is now the k-th largest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Return the k-th largest element
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // Create a minHeap to store elements from the arrays being sorted
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add array 1 elements into the minHeap
        for (int n : array1) {
            minHeap.offer(n);
        }

        // Add array 2 elements into the minHeap
        for (int n : array2) {
            minHeap.offer(n);
        }

        // Make the sortedArray's length equal to the sum of the lengths of each original array
        int[] sortedArray = new int[array1.length + array2.length];

        // Add elements from the minHeap into the sortedArray
        // Use .poll so they are entered in the sorted order
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = minHeap.poll();
        }

        return sortedArray;
    }

}