
import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use the two-pointer technique effectively
        Arrays.sort(nums);
        
        // Initialize a variable to store the closest sum
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Iterate through the array, treating each number as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Define two pointers: one starting just after the current element, and one at the end of the array
            int left = i + 1;
            int right = nums.length - 1;

            // While the two pointers do not overlap
            while (left < right) {
                // Calculate the sum of the current triplet
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update the closest sum if the current sum is closer to the target
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                // Move pointers based on how the current sum compares to the target
                if (currentSum < target) {
                    // Increase the sum by moving the left pointer to the right
                    left++;
                } else if (currentSum > target) {
                    // Decrease the sum by moving the right pointer to the left
                    right--;
                } else {
                    // If the current sum equals the target, it's the closest possible
                    return currentSum;
                }
            }
        }
        
        // Return the closest sum found
        return closestSum;
    }
}






16. 3Sum Closest
Solved
Medium
Topics
Companies
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
