class Solution {
    public int searchInsert(int[] nums, int target) {
        // Iterate through the array to find the position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i; // Return the index if the target is less than or equal to the current element
            }
        }
        // If target is greater than all elements, return the length of the array
        return nums.length;
    }
}



35. Search Insert Position
Easy
Topics
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
