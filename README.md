# Superman Java Project

This project demonstrates comprehensive Java development in Cursor IDE with Gradle, featuring multiple LeetCode algorithm solutions and Big O complexity analysis.

## Project Structure

```
src/
├── main/java/com/example/
│   ├── App.java                           # Main application with all demonstrations
│   ├── algorithms/
│   │   └── BigOComplexityExamples.java    # Comprehensive Big O complexity examples
│   └── leetcode/
│       ├── AddTwoNumbers.java             # LeetCode #2: Add Two Numbers
│       ├── LongestSubstringWithoutRepeating.java  # LeetCode #3: Longest Substring
│       ├── LongestCommonPrefix.java       # LeetCode #14: Longest Common Prefix
│       ├── LongestPalindromicSubstring.java        # LeetCode #5: Longest Palindromic Substring
│       ├── ZigZagConversion.java          # LeetCode #6: ZigZag Conversion
│       ├── IntegerToRoman.java            # LeetCode #12: Integer to Roman
│       ├── RomanToInteger.java            # LeetCode #13: Roman to Integer
│       ├── ThreeSum.java                  # LeetCode #15: 3Sum
│       ├── BinaryTreeInorderTraversal.java # LeetCode #94: Binary Tree Inorder Traversal
│       ├── RemoveDuplicatesFromSortedArray.java # LeetCode #26: Remove Duplicates from Sorted Array
│       └── SearchInsertPosition.java # LeetCode #35: Search Insert Position
└── test/java/com/example/
    ├── AppTest.java                       # Main application tests
    └── leetcode/
        ├── AddTwoNumbersTest.java         # LeetCode #2 tests
        ├── LongestSubstringWithoutRepeatingTest.java  # LeetCode #3 tests
        ├── LongestCommonPrefixTest.java   # LeetCode #14 tests (comprehensive test cases!)
        ├── LongestPalindromicSubstringTest.java       # LeetCode #5 tests (72 test cases!)
        ├── ZigZagConversionTest.java      # LeetCode #6 tests (114+ test cases!)
        ├── IntegerToRomanTest.java        # LeetCode #12 tests (278 test cases!)
        ├── RomanToIntegerTest.java        # LeetCode #13 tests (164 test cases!)
        ├── ThreeSumTest.java              # LeetCode #15 tests (84 test cases!)
        ├── BinaryTreeInorderTraversalTest.java # LeetCode #94 tests (comprehensive test cases!)
        ├── RemoveDuplicatesFromSortedArrayTest.java # LeetCode #26 tests (comprehensive test cases!)
        └── SearchInsertPositionTest.java # LeetCode #35 tests (comprehensive test cases!)
build.gradle.kts                         # Gradle build configuration
settings.gradle.kts                      # Gradle settings
gradle/wrapper/                          # Gradle wrapper files
gradlew                                  # Gradle wrapper script (Unix/macOS)
gradlew.bat                              # Gradle wrapper script (Windows)
build.sh                                 # Easy build script
.vscode/
├── settings.json                         # Cursor/VS Code settings
└── launch.json                           # Debug configurations
```

## Quick Start

### Run the Application
```bash
./gradlew run
```
This will demonstrate ALL LeetCode solutions with live examples, performance comparisons, and algorithm visualizations!

### Run Tests
```bash
./gradlew test                          # Run all tests (200+ test cases!)
./gradlew test --tests "*LeetCode*"     # Run only LeetCode tests
./gradlew test --tests "*BigO*"         # Run Big O complexity tests
```

### Build Project
```bash
./gradlew build
```

## Algorithm Solutions

### 🧮 Big O Complexity Examples
- **Location**: `src/main/java/com/example/algorithms/BigOComplexityExamples.java`
- **Description**: Comprehensive examples of all major time complexities with practical implementations
- **Complexities Covered**: O(1), O(log n), O(n), O(n log n), O(n²), O(n³), O(2ⁿ), O(n!)

**Includes real implementations of**:
- ⚡ **O(1)**: Array access, HashMap operations, Stack operations
- 📊 **O(log n)**: Binary search, BST operations, Tree height calculation
- 📈 **O(n)**: Linear search, Array traversal, String operations
- 🔄 **O(n log n)**: Merge sort, Quick sort, Heap sort
- 🔲 **O(n²)**: Bubble sort, Selection sort, Matrix operations
- 🔺 **O(n³)**: Three Sum, Floyd-Warshall algorithm
- 💥 **O(2ⁿ)**: Fibonacci (naive), Power sets, Tower of Hanoi
- 🌟 **O(n!)**: Permutations, Traveling Salesman Problem

## LeetCode Solutions

This project features **11 complete LeetCode solutions** with multiple algorithmic approaches and comprehensive testing:

### 1. Add Two Numbers (LeetCode #2)
- **Location**: `src/main/java/com/example/leetcode/AddTwoNumbers.java`
- **Description**: Add two numbers represented as linked lists in reverse order
- **Time Complexity**: O(max(m, n))
- **Space Complexity**: O(max(m, n))

**Example**:
```java
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807
```

### 2. Longest Substring Without Repeating Characters (LeetCode #3)
- **Location**: `src/main/java/com/example/leetcode/LongestSubstringWithoutRepeating.java`
- **Description**: Find the length of the longest substring without repeating characters
- **Time Complexity**: O(n) (sliding window approach)
- **Space Complexity**: O(min(m,n)) where m is charset size

**Examples**:
```java
Input: "abcabcbb" -> Output: 3 (substring "abc")
Input: "bbbbb"    -> Output: 1 (substring "b")
Input: "pwwkew"   -> Output: 3 (substring "wke")
```

**Multiple implementations**:
- ✅ **HashMap approach** (most efficient)
- ✅ **HashSet approach** (alternative sliding window)
- ✅ **Brute force approach** (for comparison)

### 3. Longest Palindromic Substring (LeetCode #5)
- **Location**: `src/main/java/com/example/leetcode/LongestPalindromicSubstring.java`
- **Description**: Find the longest palindromic substring in a given string
- **Multiple Approaches**: 4 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🎯 **Expand Around Centers**: O(n²) time, O(1) space - *Recommended for interviews*
- ⚡ **Manacher's Algorithm**: O(n) time, O(n) space - *Optimal performance*
- 📚 **Dynamic Programming**: O(n²) time, O(n²) space - *Educational approach*
- 🔍 **Brute Force**: O(n³) time, O(1) space - *Learning tool*

**Examples**:
```java
Input: "babad"   -> Output: "bab" or "aba"
Input: "cbbd"    -> Output: "bb"
Input: "racecar" -> Output: "racecar"
```

**Testing**: 72 comprehensive test cases with cross-validation between all approaches!

### 4. ZigZag Conversion (LeetCode #6)
- **Location**: `src/main/java/com/example/leetcode/ZigZagConversion.java`
- **Description**: Convert string to zigzag pattern and read line by line
- **Multiple Approaches**: 4 different algorithms + visualization utilities

**Algorithms implemented**:
- 🎯 **Simulation**: O(n) time, O(n) space - *Most intuitive*
- ⚡ **Mathematical Pattern**: O(n) time, O(1) space - *Most space efficient*
- 📚 **String Array**: O(n) time, O(n) space - *Educational approach*
- 🔧 **Optimized Simulation**: O(n) time, O(n) space - *Production-ready*

**Examples**:
```java
Input: "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Pattern visualization:
P   A   H   N
A P L S I I G
Y   I   R
```

**Special Features**:
- 🎨 **Pattern Visualization**: See the actual zigzag layout
- 📊 **Utility Functions**: Cycle length calculation, row mapping
- 🧪 **Comprehensive Testing**: 114+ test cases with performance comparison

**Testing**: 114+ comprehensive test cases testing all approaches and edge cases!

### 5. Integer to Roman (LeetCode #12)
- **Location**: `src/main/java/com/example/leetcode/IntegerToRoman.java`
- **Description**: Convert integer (1-3999) to Roman numeral with proper subtractive notation
- **Multiple Approaches**: 4 different algorithms + comprehensive utilities

**Algorithms implemented**:
- 🏆 **Greedy Arrays**: O(1) time, O(1) space - *Recommended for interviews (fastest)*
- 📚 **Greedy Map**: O(1) time, O(1) space - *Most readable and maintainable*
- ⚡ **Lookup Table**: O(1) time, O(1) space - *Maximum performance with pre-computation*
- 🎓 **Recursive**: O(1) time, O(1) space - *Educational demonstration*

**Examples**:
```java
Input: 3    -> Output: "III"
Input: 4    -> Output: "IV"
Input: 9    -> Output: "IX"
Input: 58   -> Output: "LVIII"
Input: 1994 -> Output: "MCMXCIV"
```

**Special Features**:
- 🏛️ **Roman Numeral Validation**: Proper rule checking for valid Roman numerals
- 📊 **Construction Analysis**: Step-by-step breakdown showing numeral building
- 🔍 **Subtractive Detection**: Identifies IV, IX, XL, XC, CD, CM cases
- 📏 **Length Analysis**: Roman numeral string length calculation
- ⚙️ **Utility Methods**: Character values, validation, pattern analysis

**Testing**: 278 comprehensive test cases with cross-validation between all approaches!

### 6. Roman to Integer (LeetCode #13)
- **Location**: `src/main/java/com/example/leetcode/RomanToInteger.java`
- **Description**: Convert Roman numeral string to integer with proper subtractive notation handling
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Left-to-Right with Lookahead**: O(n) time, O(1) space - *Recommended for interviews (most intuitive)*
- 📚 **HashMap with Lookahead**: O(n) time, O(1) space - *Most readable and maintainable*
- ⚡ **Right-to-Left Processing**: O(n) time, O(1) space - *Alternative approach avoiding lookahead*
- 🔧 **Subtractive Pairs Lookup**: O(n) time, O(1) space - *Explicit subtractive case handling*
- 🎯 **Array-Based Lookup**: O(n) time, O(1) space - *Maximum performance with O(1) character lookup*

**Examples**:
```java
Input: "III"     -> Output: 3
Input: "IV"      -> Output: 4
Input: "IX"      -> Output: 9
Input: "LVIII"   -> Output: 58
Input: "MCMXCIV" -> Output: 1994
```

**Special Features**:
- 🏛️ **Roman Numeral Validation**: Proper rule checking for valid Roman numerals
- 📊 **Conversion Analysis**: Step-by-step breakdown showing numeral conversion process
- 🔍 **Subtractive Detection**: Identifies IV, IX, XL, XC, CD, CM cases
- 📏 **Character Analysis**: Character counting and frequency analysis
- ⚙️ **Utility Methods**: Validation, analysis, and performance comparison tools
- 🧪 **Cross-Validation**: All approaches produce identical results

**Testing**: 164 comprehensive test cases with cross-validation between all approaches!

### 7. 3Sum (LeetCode #15)
- **Location**: `src/main/java/com/example/leetcode/ThreeSum.java`
- **Description**: Find all unique triplets in array that sum to zero
- **Multiple Approaches**: 4 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Sorting + Two Pointers**: O(n²) time, O(1) space - *Optimal solution (recommended)*
- 📚 **Brute Force**: O(n³) time, O(k) space - *Educational baseline*
- ⚡ **Hash Set**: O(n²) time, O(n) space - *Alternative O(n²) approach*
- 🔧 **Optimized Two Pointers**: O(n²) time, O(1) space - *Enhanced with early termination*

**Examples**:
```java
Input: [-1,0,1,2,-1,-4] -> Output: [[-1,-1,2],[-1,0,1]]
Input: [0,1,1]          -> Output: []
Input: [0,0,0]          -> Output: [[0,0,0]]
```

**Special Features**:
- 🎯 **Duplicate Handling**: Automatically skips duplicate triplets
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: All positive, all negative, multiple zeros
- 📈 **Optimization**: Early termination and aggressive duplicate skipping

**Testing**: 84 comprehensive test cases with performance benchmarking and cross-validation!

### 8. Longest Common Prefix (LeetCode #14)
- **Location**: `src/main/java/com/example/leetcode/LongestCommonPrefix.java`
- **Description**: Find the longest common prefix string amongst an array of strings
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Horizontal Scanning**: O(S) time, O(1) space - *Most intuitive and efficient*
- ⚡ **Vertical Scanning**: O(S) time, O(1) space - *Alternative efficient approach*
- 🔄 **Divide and Conquer**: O(S) time, O(m log n) space - *Recursive approach*
- 🔍 **Binary Search**: O(S log m) time, O(1) space - *Binary search on length*
- 🌳 **Trie Data Structure**: O(S) time, O(S) space - *Advanced data structure approach*

**Examples**:
```java
Input: ["flower","flow","flight"] -> Output: "fl"
Input: ["dog","racecar","car"]    -> Output: ""
Input: ["interspecies","interstellar","interstate"] -> Output: "inters"
```

**Special Features**:
- 🎯 **Multiple Algorithmic Approaches**: 5 different solutions for learning
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null strings, empty strings, single strings
- 📈 **Constraint Handling**: Handles LeetCode constraints (200 strings, 200 chars each)
- 🔧 **Utility Methods**: String statistics, result comparison, performance measurement

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 9. Binary Tree Inorder Traversal (LeetCode #94)
- **Location**: `src/main/java/com/example/leetcode/BinaryTreeInorderTraversal.java`
- **Description**: Given the root of a binary tree, return the inorder traversal of its nodes' values
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Recursive**: O(n) time, O(h) space - *Most intuitive and commonly used*
- ⚡ **Iterative with Stack**: O(n) time, O(h) space - *Simulates recursion with stack*
- 🌟 **Morris Traversal**: O(n) time, O(1) space - *Most space-efficient (constant space)*
- 🔄 **Two Stacks**: O(n) time, O(n) space - *Explicit state tracking approach*
- 🔍 **Hash Set**: O(n) time, O(n) space - *Tracks visited nodes for correct order*

**Examples**:
```java
Input: [1,null,2,3] -> Output: [1,3,2]
Input: [1,2,3,4,5,6,7] -> Output: [4,2,5,1,6,3,7]
Input: [10,5,15,3,7,12,18] -> Output: [3,5,7,10,12,15,18]
```

**Special Features**:
- 🎯 **Multiple Algorithmic Approaches**: 5 different solutions for comprehensive learning
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null trees, empty trees, single nodes, skewed trees
- 📈 **Constraint Handling**: Handles LeetCode constraints (100 nodes, values -100 to 100)
- 🌳 **Tree Utilities**: Tree creation, statistics, validation, and conversion methods
- 🔧 **Structure Preservation**: Ensures tree structure remains intact after traversal

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 10. Remove Duplicates from Sorted Array (LeetCode #26)
- **Location**: `src/main/java/com/example/leetcode/RemoveDuplicatesFromSortedArray.java`
- **Description**: Remove duplicates from sorted array in-place and return count of unique elements
- **Multiple Approaches**: 4 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Two Pointers**: O(n) time, O(1) space - *Optimal solution (recommended)*
- 📚 **HashSet Approach**: O(n) time, O(n) space - *Educational approach (not in-place)*
- 🔧 **Brute Force with Array Copy**: O(n) time, O(n) space - *Learning tool*
- ⚡ **Optimized Two Pointers**: O(n) time, O(1) space - *Enhanced with early termination*

**Examples**:
```java
Input: [1,1,2]                    -> Output: 2, nums = [1,2,_]
Input: [0,0,1,1,1,2,2,3,3,4]     -> Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Input: [1]                        -> Output: 1, nums = [1]
Input: [1,1,1,1]                  -> Output: 1, nums = [1,_,_,_]
```

**Special Features**:
- 🎯 **In-place Modification**: Modifies array without extra space (optimal approach)
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty arrays, single elements, all duplicates, no duplicates
- 📈 **Constraint Handling**: Handles LeetCode constraints (30,000 elements, -100 to 100 values)
- 🔧 **Utility Methods**: Array printing, debugging, and performance measurement tools

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 11. Search Insert Position (LeetCode #35)
- **Location**: `src/main/java/com/example/leetcode/SearchInsertPosition.java`
- **Description**: Find the index where a target value should be inserted in a sorted array to maintain order
- **Multiple Approaches**: 4 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Binary Search**: O(log n) time, O(1) space - *Optimal solution (recommended)*
- ⚡ **Alternative Binary Search**: O(log n) time, O(1) space - *Explicit insert position logic*
- 🔄 **Recursive Binary Search**: O(log n) time, O(log n) space - *Recursive approach*
- 📚 **Linear Search**: O(n) time, O(1) space - *Educational baseline (not optimal)*

**Examples**:
```java
Input: [1,3,5,6], target = 5 -> Output: 2 (target found)
Input: [1,3,5,6], target = 2 -> Output: 1 (insert at index 1)
Input: [1,3,5,6], target = 7 -> Output: 4 (insert at end)
Input: [1,3,5,6], target = 0 -> Output: 0 (insert at beginning)
```

**Special Features**:
- 🎯 **Binary Search Mastery**: Classic binary search implementation with insert position logic
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Single elements, two elements, negative numbers, large arrays
- 📈 **Constraint Handling**: Handles LeetCode constraints (10,000 elements, -10,000 to 10,000 values)
- 🔧 **Utility Methods**: Multiple solution approaches for comprehensive learning

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

## Key Features

- ✅ **Java 21** with Gradle 8.14.3 Kotlin DSL
- ✅ **JUnit 5** testing framework with parameterized tests
- ✅ **1000+ comprehensive test cases** across all solutions
- ✅ **Multiple algorithmic approaches** for each problem
- ✅ **Performance analysis** and complexity comparisons
- ✅ **Algorithm visualization** and pattern demonstration
- ✅ **Cross-validation testing** ensuring algorithm consistency
- ✅ **Production-ready code** with robust error handling
- ✅ **Educational documentation** with detailed explanations
- ✅ **VS Code/Cursor IDE integration** with optimized settings

## Performance Highlights

- 🚀 **All algorithms**: Optimized for both time and space complexity
- 📊 **Live benchmarking**: Performance comparison between different approaches
- ⚡ **Fast execution**: All solutions handle maximum LeetCode constraints efficiently
- 🧪 **Stress testing**: Verified with large inputs and edge cases
- 📈 **Complexity analysis**: Detailed Big O analysis for each approach

## Development

### Prerequisites
- Java 21 or later (currently using Java 21.0.6)
- Gradle 8.14.3 (wrapper included)
- Cursor IDE with Java extensions

### Running Specific Solutions
```bash
# Run all LeetCode demonstrations
./gradlew run

# Run specific tests
./gradlew test --tests "*AddTwoNumbers*"
./gradlew test --tests "*LongestSubstring*"
./gradlew test --tests "*LongestPalindromic*"
./gradlew test --tests "*ZigZagConversion*"
./gradlew test --tests "*IntegerToRoman*"
./gradlew test --tests "*RomanToInteger*"
./gradlew test --tests "*ThreeSum*"
./gradlew test --tests "*LongestCommonPrefix*"
./gradlew test --tests "*BinaryTreeInorderTraversal*"
./gradlew test --tests "*RemoveDuplicatesFromSortedArray*"
./gradlew test --tests "*SearchInsertPosition*"
./gradlew test --tests "*BigOComplexity*"
```

### Useful Commands
```bash
./gradlew clean              # Clean build artifacts
./gradlew compileJava        # Compile source code
./gradlew test               # Run all 1000+ tests
./gradlew build              # Build the entire project
./gradlew run                # Run with all algorithm demonstrations
```

## Educational Value

This project serves as:
- 🎓 **Interview preparation** with multiple solution approaches
- 📚 **Algorithm study guide** with practical implementations
- 🔬 **Performance analysis** comparing different approaches
- 🧪 **Testing best practices** with comprehensive test suites
- 💻 **Java development** showcase with modern practices
- 🎯 **LeetCode mastery** with detailed explanations

## Algorithm Summary

| Problem | Difficulty | Optimal Complexity | Approaches | Test Cases |
|---------|------------|-------------------|------------|------------|
| Add Two Numbers | Medium | O(n) time, O(n) space | 1 approach | Standard |
| Longest Substring | Medium | O(n) time, O(k) space | 3 approaches | Comprehensive |
| Longest Common Prefix | Easy | O(S) time, O(1) space | 5 approaches | Comprehensive |
| Longest Palindrome | Medium | O(n) time, O(n) space | 4 approaches | 72 tests |
| ZigZag Conversion | Medium | O(n) time, O(1) space | 4 approaches | 114+ tests |
| Integer to Roman | Medium | O(1) time, O(1) space | 4 approaches | 278 tests |
| Roman to Integer | Easy | O(n) time, O(1) space | 5 approaches | 164 tests |
| 3Sum | Medium | O(n²) time, O(1) space | 4 approaches | 84 tests |
| Binary Tree Inorder | Easy | O(n) time, O(h) space | 5 approaches | Comprehensive |
| Remove Duplicates | Easy | O(n) time, O(1) space | 4 approaches | Comprehensive |
| Search Insert Position | Easy | O(log n) time, O(1) space | 4 approaches | Comprehensive |
| Big O Examples | Educational | All complexities | 8 complexity classes | Demonstrations |

**Total**: 11 LeetCode problems + Algorithm analysis = **1100+ test cases** and **43 different algorithmic approaches**!

Happy coding! 🚀 Ready for your next technical interview! 💪
