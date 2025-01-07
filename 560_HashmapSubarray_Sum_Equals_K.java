import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Initialize a HashMap to store the cumulative sum frequencies
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // There is one way to achieve a sum of 0 (empty subarray)
        
        int count = 0; // To keep track of the total number of subarrays with sum = k
        int currentSum = 0; // To keep track of the cumulative sum

        // Iterate through the array
        for (int num : nums) {
            currentSum += num; // Update the cumulative sum
            
            // Check if (currentSum - k) exists in the map
            // This means there exists a subarray ending at this index with sum = k
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Update the map with the current cumulative sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count; // Return the total count of subarrays with sum = k
    }
}



560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
