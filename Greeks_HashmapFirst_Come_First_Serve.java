// User function Template for Java

import java.util.HashMap;
import java.util.Map;

class Solution {

    static int firstElement(int arr[], int k) {
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        
        // Populate the HashMap with frequencies
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        // Iterate through the array to find the first element with frequency k
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == k) {
                return arr[i]; // Return the first element with frequency k
            }
        }
        
        // If no such element exists, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 7, 4, 3, 4, 8, 7};
        int k1 = 2;
        System.out.println(firstElement(arr1, k1)); // Output: 7
        
        int[] arr2 = {4, 1, 6, 1, 6, 4};
        int k2 = 1;
        System.out.println(firstElement(arr2, k2)); // Output: -1
    }
}



First Come First Serve
Difficulty: EasyAccuracy: 49.87%Submissions: 11K+Points: 2
You are given an array arr[], containing the IDs of users in chronological order of their occurrences. Find the first user who has exactly k occurrences.
If no such user exists, return -1.

Examples:

Input: arr[] = [1, 7, 4, 3, 4, 8, 7] , k = 2
Output: 7
Explanation: Both 7 and 4 occur 2 times. But 7 is the first that occurs 2 times.  
Input: arr[] = [4, 1, 6, 1, 6, 4] , k = 1 
Output: -1 
Explanation: No one occurs exactly 1 time.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
