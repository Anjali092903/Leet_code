class Solution { 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merge both arrays into one sorted array
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, k = 0;
        
        // Merge nums1 and nums2 using two pointers
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        // If any elements are left in nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        // If any elements are left in nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        // Find the median of the merged array
        int totalLength = m + n;
        if (totalLength % 2 == 1) {
            // Odd length, return the middle element
            return merged[totalLength / 2];
        } else {
            // Even length, return the average of the two middle elements
            int mid1 = totalLength / 2;
            int mid2 = mid1 - 1;
            return (merged[mid1] + merged[mid2]) / 2.0;
        }
    }
}



4. Median of Two Sorted Arrays
Solved
Hard
Topics
Companies
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
