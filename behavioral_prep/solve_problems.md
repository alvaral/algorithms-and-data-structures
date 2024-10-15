# **R.E.A.C.T.O.**

It is commonly used in technical interviews to structure problem-solving,
especially for coding interviews at companies like Amazon, Google, and others.
This framework stands for:

### R - **Repeat the Question**

- **Purpose**: Clarify the problem and ensure that you fully understand what is being asked. 
- **Action**: Restate the problem in your own words. Ask for examples if they are not given. Ask questions if something is unclear.
  - Example: "So, you're asking me to find the median of two sorted arrays, correct? Should I assume the arrays are of equal length, or can they differ?"

### E - **Examples**

- **Purpose**: Work through specific input/output examples to further clarify the requirements.
- **Action**: Go through a few sample inputs and outputs to verify your understanding. This helps catch edge cases early.
  - Example: "If I have arrays `[1, 3]` and `[2]`, the median is `2`. For arrays `[1, 2]` and `[3, 4]`, the median is `2.5`, correct?"

### A - **Approach**

- **Purpose**: Define a plan for solving the problem before jumping into coding.
- **Action**: Think through and explain different approaches you might take. Consider brute force, then optimize.
  - Example: "One way to do this is to merge the two arrays and then find the median, but this would take `O(n + m)` time. Another approach is to use binary search, which would bring the time complexity down to `O(log(min(n, m)))`."

### C - **Code**

- **Purpose**: Implement your solution.
- **Action**: Write the code based on your chosen approach. Ensure you write clean and understandable code.
  - Example: "Now that we've decided on the binary search approach, let me write the function that will find the median."

### T - **Test**

- **Purpose**: Test your solution to ensure correctness and handle edge cases.
- **Action**: Run through different test cases, including edge cases like empty arrays, arrays of different lengths, etc.
  - Example: "Let's test with an empty array, a single element array, and arrays of different lengths to see if the solution works."

### O - **Optimize**

- **Purpose**: Reflect on your solution and check if it can be improved.
- **Action**: Consider the time and space complexity and identify any potential optimizations.
  - Example: "The current solution runs in `O(log(min(n, m)))` time, which is efficient for this problem. We are not using any extra space apart from a few variables, so space complexity is `O(1)`."

---

### Sample Flow for a Coding Interview Using REACTO:

1. **Repeat the Question**: "You want me to find the median of two sorted arrays, is that right? Can the arrays have different lengths?"
2. **Examples**: "Let's try arrays `[1, 3]` and `[2]`. The median should be `2`. For `[1, 2]` and `[3, 4]`, the median is `2.5`. Does this sound correct?"
3. **Approach**: "The brute-force approach would be to merge the arrays and find the median, but that would take `O(n + m)`. A more optimal way would be to use binary search, bringing it down to `O(log(min(n, m)))`. I'll go with the binary search approach."
4. **Code**: (Write the code)
5. **Test**: "Let’s test with arrays of equal length, arrays with a single element, arrays of different lengths, and ensure it works for all cases."
6. **Optimize**: "The solution is already optimal in terms of time complexity. No unnecessary space is used apart from constant space for variables."

---

By following the **REACTO** framework, you ensure that you tackle all aspects of the problem in a structured way, reducing the chances of missing critical details. It's especially useful for tackling coding problems during technical interviews.
