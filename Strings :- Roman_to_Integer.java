Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV.
  Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction
  is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].




import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    // Method to convert Roman numeral to integer
    public static int romanToInt(String s) {
        // Mapping of Roman numerals to their integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int total = 0;      // Variable to hold the total integer value
        int prevValue = 0;  // Variable to track the previous numeral's value

        // Iterate through the Roman numeral string in reverse
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i); // Get the current character
            int currentValue = romanMap.get(currentChar); // Get its integer value
            
            // If the current value is less than the previous value, subtract it
            if (currentValue < prevValue) {
                total -= currentValue; // Subtraction case (e.g., IV, IX)
            } else {
                total += currentValue; // Addition case
            }
            
            // Update the previous value for the next iteration
            prevValue = currentValue;
        }
        
        return total; // Return the computed integer value
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt user for input
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine(); // Read the input from the user
        
        // Convert the Roman numeral to integer and display the result
        int result = romanToInt(romanNumeral);
        System.out.println("The integer value is: " + result);
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}




using without maping 
import java.util.Scanner;
public class RomanToInteger {
     // Method to convert Roman numeral to integer
    public static int romanToInt(String s) {
        int total = 0;      // Variable to hold the total integer value
        int prevValue = 0;  // Variable to track the previous numeral's value
     // Iterate through the Roman numeral string in reverse
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i); // Get the current character
            int currentValue = 0; // Variable to hold the integer value of the current numeral
            
            // Determine the integer value of the current numeral
            if (currentChar == 'I') {
                currentValue = 1;
            } else if (currentChar == 'V') {
                currentValue = 5;
            } else if (currentChar == 'X') {
                currentValue = 10;
            } else if (currentChar == 'L') {
                currentValue = 50;
            } else if (currentChar == 'C') {
                currentValue = 100;
            } else if (currentChar == 'D') {
                currentValue = 500;
            } else if (currentChar == 'M') {
                currentValue = 1000;
            }
            
            // If the current value is less than the previous value, subtract it
            if (currentValue < prevValue) {
                total -= currentValue; // Subtraction case (e.g., IV, IX)
            } else {
                total += currentValue; // Addition case
            }
           // Update the previous value for the next iteration
            prevValue = currentValue;
        }
        
        return total; // Return the computed integer value
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        
        // Prompt user for input
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine(); // Read the input from the user
        
        // Convert the Roman numeral to integer and display the result
        int result = romanToInt(romanNumeral);
        System.out.println("The integer value is: " + result);
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
