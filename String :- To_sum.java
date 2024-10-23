class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Check the rest of the numbers for a match
            for (int j = i + 1; j < nums.length; j++) {
                // If a pair is found that adds up to the target
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j }; // Return the indices
                }
            }
        }
        // If no pair is found, return an empty array (this should not happen as per problem statement)
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example inputs
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 1]

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 2]

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // Output: [0, 1]
    }
}  




 Two Sum
Solved
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 


