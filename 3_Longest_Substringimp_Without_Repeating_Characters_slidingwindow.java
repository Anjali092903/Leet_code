import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int max = 0;

        while (j < s.length()) {
            char Chj = s.charAt(j); 
            freq.put(Chj, freq.getOrDefault(Chj, 0) + 1);

            // Shrink window if duplicate character found
            while (freq.get(Chj) > 1) {
                char Chi = s.charAt(i); 
                freq.put(Chi, freq.get(Chi) - 1);
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }
}








3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
