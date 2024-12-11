class Solution {
    public int maxArea(int[] height) {
        int left = 0; // Pointer at the start of the array
        int right = height.length - 1; // Pointer at the end of the array
        int maxArea = 0; // To store the maximum area found
        
        // Iterate until the two pointers meet
        while (left < right) {
            // Calculate the area between the lines at 'left' and 'right'
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update the maximum area if the current one is larger
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++; // Move the left pointer
            } else {
                right--; // Move the right pointer
            }
        }
        
        return maxArea; // Return the maximum area found
    }
}





11. Container With Most Water
Solved
Medium
Topics
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

