import java.util.*;

class Solution {
    // Array to map digits to their respective letters
    String[] arr = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>(); // Corrected ListString to List<String>

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>(); // Return an empty list if input is empty
        }
        generateCombination(digits, ""); // Start recursive function
        return ans;
    }

    public void generateCombination(String digits, String asf) {
        if (digits.length() == 0) { // Base case: when all digits are processed
            ans.add(asf); // Add the combination to the answer list
            return;
        }

        int digit = digits.charAt(0) - '0'; // Convert character to integer
        String digitComb = arr[digit];     // Get the corresponding letters for the digit
        String ros = digits.substring(1); // Rest of the string

        for (int i = 0; i < digitComb.length(); i++) { // Loop through all letters for the current digit
            char ch = digitComb.charAt(i);  // Get each character
            generateCombination(ros, asf + ch); // Recursive call for the rest of the digits
        }
    }
}


















17. Letter Combinations of a Phone Number
Solved
Medium
Topics
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
