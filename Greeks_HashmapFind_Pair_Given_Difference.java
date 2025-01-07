import java.util.HashSet;

class Solution {
    public boolean findPair(int[] arr, int x) {
        // Create a HashSet to store array elements for quick lookup
        HashSet<Integer> set = new HashSet<>();
        
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the two possible values for the pair
            int j1 = arr[i] - x; // Element that is smaller by x
            int j2 = arr[i] + x; // Element that is larger by x
            
            // Check if either of the values exist in the set
            if (set.contains(j1) || set.contains(j2)) {
                return true; // Pair with absolute difference x found
            }
            
            // Add the current element to the set for future lookups
            set.add(arr[i]);
        }
        
        // If no such pair is found, return false
        return false;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] arr1 = {5, 20, 3, 2, 5, 80};
        int x1 = 78;
        System.out.println(solution.findPair(arr1, x1)); // Output: true
        
        int[] arr2 = {90, 70, 20, 80, 50};
        int x2 = 45;
        System.out.println(solution.findPair(arr2, x2)); // Output: false
        
        int[] arr3 = {1};
        int x3 = 1;
        System.out.println(solution.findPair(arr3, x3)); // Output: false
    }
}





Find Pair Given Difference
Difficulty: EasyAccuracy: 27.25%Submissions: 260K+Points: 2
Given an array, arr[] and an integer x, return true if there exists a pair of elements in the array whose absolute difference is x, otherwise, return false.

Examples:

Input: arr[] = [5, 20, 3, 2, 5, 80], x = 78
Output: true
Explanation: Pair (2, 80) have an absolute difference of 78.
Input: arr[] = [90, 70, 20, 80, 50], x = 45
Output: false
Explanation: There is no pair with absolute difference of 45.
Input: arr[] = [1], x = 1
Output: false
Constraints:
1<= arr.size() <=106 
1<= arr[i] <=106 
0<= x <=105
