import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // List to store the unique triplets
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array to make it easier to handle duplicates and use two pointers
        Arrays.sort(nums);
        
        // Iterate through the array, treating each number as a potential first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // If this number is the same as the previous one, skip it to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Define two pointers: one starting right after the current number (`i`) and one at the end of the array
            int left = i + 1;
            int right = nums.length - 1;

            // While the two pointers don't overlap
            while (left < right) {
                // Calculate the sum of the current triplet
                int sum = nums[i] + nums[left] + nums[right];
                
                // If the sum is zero, we've found a valid triplet
                if (sum == 0) {
                    // Add the triplet to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers inward while skipping duplicate numbers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move pointers to the next unique elements
                    left++;
                    right--;
                } 
                // If the sum is less than zero, move the left pointer to increase the sum
                else if (sum < 0) {
                    left++;
                } 
                // If the sum is greater than zero, move the right pointer to decrease the sum
                else {
                    right--;
                }
            }
        }
        
        // Return the list of unique triplets
        return result;
    }
}






15. 3Sum
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
