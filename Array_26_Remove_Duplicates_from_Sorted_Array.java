class Solution {
    public int removeDuplicates(int[] nums) {
       if (nums.length == 0) {
            return 0; // If array khali h toh return 0
        }
         // Pointer to track the position of unique elements
        int k = 1; // Start from the second position kyoki jo element se start kiya h vo khud ma bhi unique h 
  
         // Iterate over the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous unique element
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Move the unique element to position k
                k++; // Increment the position for the next unique element
            }
        }
        // Return the count of unique elements
        return k;
    }
}  


26. Remove Duplicates from Sorted Array
Solved
Easy
Topics
Companies
Hint
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
5.4M
Submissions
9.2M
Acceptance Rate
58.5%
Topics
Companies
Hint 3
Essentially, once an element is encountered, you simply need to bypass its duplicates and move on to the next unique element.
