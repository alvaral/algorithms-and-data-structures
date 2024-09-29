package data_structures.stack_queues;

import java.util.Stack;

/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.

 *   An input string is valid if:

 *   Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Every close bracket has a corresponding open
 * bracket of the same type.
 *
 * 
 *  Example 1:
 * 
 *  Input: s = "()"
 *  Output: true

 *  Example 2:

 *  Input: s = "()[]{}"
 *  Output: true

 *  Example 3:

 *  Input: s = "(]"
 *  Output: false

 *  Example 4:

 *  Input: s = "([])"
 *  Output: true
 *
 *  Constraints:
 *  1 <= s.length <= 104 s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // string of braces 
        // Iterate every char of string
        // Use Stack (LIFO) 
        // if '(' is found, add ')' to stack
        // if '[' is found, add ']'
        // if '{' is found, add '}'
        // if stack is empty or stack.pop is not c -> return false
        // When loop ends, if stack is empty the string is valid    
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();

        // Test cases
        String test1 = "()";
        System.out.println("Test 1 - Input: " + test1 + " | Expected: true | Obtained: " + validator.isValid(test1));

        String test2 = "()[]{}";
        System.out.println("Test 2 - Input: " + test2 + " | Expected: true | Obtained: " + validator.isValid(test2));

        String test3 = "(]";
        System.out.println("Test 3 - Input: " + test3 + " | Expected: false | Obtained: " + validator.isValid(test3));

        String test4 = "([])";
        System.out.println("Test 4 - Input: " + test4 + " | Expected: true | Obtained: " + validator.isValid(test4));

        String test5 = "{[()]}";
        System.out.println("Test 5 - Input: " + test5 + " | Expected: true | Obtained: " + validator.isValid(test5));

        String test6 = "((()))";
        System.out.println("Test 6 - Input: " + test6 + " | Expected: true | Obtained: " + validator.isValid(test6));

        String test7 = "((())";
        System.out.println("Test 7 - Input: " + test7 + " | Expected: false | Obtained: " + validator.isValid(test7));

        String test8 = "[]{}()";
        System.out.println("Test 8 - Input: " + test8 + " | Expected: true | Obtained: " + validator.isValid(test8));

        String test9 = "[{]}";
        System.out.println("Test 9 - Input: " + test9 + " | Expected: false | Obtained: " + validator.isValid(test9));
    }
}
