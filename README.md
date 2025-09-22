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
│       ├── SearchInsertPosition.java # LeetCode #35: Search Insert Position
│       ├── FindFirstOccurrenceInString.java # LeetCode #28: Find the Index of the First Occurrence in a String
│       ├── AddBinary.java # LeetCode #67: Add Binary
│       ├── PlusOne.java # LeetCode #66: Plus One
│       ├── SqrtX.java # LeetCode #69: Sqrt(x)
│       ├── ClimbingStairs.java # LeetCode #70: Climbing Stairs
│       ├── MergeSortedArray.java # LeetCode #88: Merge Sorted Array
│       ├── ConvertSortedArrayToBST.java # LeetCode #108: Convert Sorted Array to Binary Search Tree
│       ├── MaximumDepthOfBinaryTree.java # LeetCode #104: Maximum Depth of Binary Tree
│       ├── BalancedBinaryTree.java # LeetCode #110: Balanced Binary Tree
│       ├── SingleNumber.java # LeetCode #136: Single Number
│       ├── MinimumDepthOfBinaryTree.java # LeetCode #111: Minimum Depth of Binary Tree
│       ├── PascalsTriangleII.java # LeetCode #119: Pascal's Triangle II
│       ├── BestTimeToBuyAndSellStock.java # LeetCode #121: Best Time to Buy and Sell Stock
│       ├── PrintInOrder.java # LeetCode #1114: Print in Order
│       ├── FindMostFrequentVowelAndConsonant.java # LeetCode #3541: Find Most Frequent Vowel and Consonant
│       ├── LinkedListCycle.java # LeetCode #141: Linked List Cycle
│       ├── PrintFooBarAlternately.java # LeetCode #1115: Print FooBar Alternately
│       ├── CustomersWhoNeverOrder.java # LeetCode #183: Customers Who Never Order
│       ├── ValidPalindrome.java # LeetCode #125: Valid Palindrome
│       ├── CountCompleteTreeNodes.java # LeetCode #222: Count Complete Tree Nodes
│       ├── CountingBits.java # LeetCode #338: Counting Bits
│       ├── IntersectionOfTwoLinkedLists.java # LeetCode #160: Intersection of Two Linked Lists
│       ├── ExcelSheetColumnTitle.java # LeetCode #168: Excel Sheet Column Title
│       ├── CountAndSay.java # LeetCode #38: Count and Say
│       ├── MajorityElement.java # LeetCode #169: Majority Element
│       ├── ReverseBits.java # LeetCode #190: Reverse Bits
│       └── HappyNumber.java # LeetCode #202: Happy Number
├── hackerrank/
│   ├── MergeAndSortIntervals.java # HackerRank: Merge and Sort Intervals
│   └── PlusMinus.java # HackerRank: Plus Minus
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
        ├── SearchInsertPositionTest.java # LeetCode #35 tests (comprehensive test cases!)
        ├── FindFirstOccurrenceInStringTest.java # LeetCode #28 tests (comprehensive test cases!)
        ├── AddBinaryTest.java # LeetCode #67 tests (comprehensive test cases!)
        ├── PlusOneTest.java # LeetCode #66 tests (comprehensive test cases!)
        ├── SqrtXTest.java # LeetCode #69 tests (comprehensive test cases!)
        ├── ClimbingStairsTest.java # LeetCode #70 tests (comprehensive test cases!)
        ├── MergeSortedArrayTest.java # LeetCode #88 tests (comprehensive test cases!)
        ├── ConvertSortedArrayToBSTTest.java # LeetCode #108 tests (comprehensive test cases!)
        ├── MaximumDepthOfBinaryTreeTest.java # LeetCode #104 tests (comprehensive test cases!)
        ├── BalancedBinaryTreeTest.java # LeetCode #110 tests (comprehensive test cases!)
        ├── SingleNumberTest.java # LeetCode #136 tests (comprehensive test cases!)
        ├── MinimumDepthOfBinaryTreeTest.java # LeetCode #111 tests (comprehensive test cases!)
        ├── PascalsTriangleIITest.java # LeetCode #119 tests (comprehensive test cases!)
        ├── BestTimeToBuyAndSellStockTest.java # LeetCode #121 tests (comprehensive test cases!)
        ├── PrintInOrderTest.java # LeetCode #1114 tests (comprehensive test cases!)
        ├── FindMostFrequentVowelAndConsonantTest.java # LeetCode #3541 tests (comprehensive test cases!)
        ├── LinkedListCycleTest.java # LeetCode #141 tests (comprehensive test cases!)
        ├── PrintFooBarAlternatelyTest.java # LeetCode #1115 tests (comprehensive test cases!)
        ├── CustomersWhoNeverOrderTest.java # LeetCode #183 tests (comprehensive test cases!)
        ├── ValidPalindromeTest.java # LeetCode #125 tests (comprehensive test cases!)
        ├── CountCompleteTreeNodesTest.java # LeetCode #222 tests (comprehensive test cases!)
        ├── CountingBitsTest.java # LeetCode #338 tests (comprehensive test cases!)
        ├── IntersectionOfTwoLinkedListsTest.java # LeetCode #160 tests (comprehensive test cases!)
        ├── ExcelSheetColumnTitleTest.java # LeetCode #168 tests (comprehensive test cases!)
        ├── CountAndSayTest.java # LeetCode #38 tests (comprehensive test cases!)
        ├── MajorityElementTest.java # LeetCode #169 tests (comprehensive test cases!)
        ├── ReverseBitsTest.java # LeetCode #190 tests (comprehensive test cases!)
        └── HappyNumberTest.java # LeetCode #202 tests (comprehensive test cases!)
    └── hackerrank/
        ├── MergeAndSortIntervalsTest.java # HackerRank tests (comprehensive test cases!)
        └── PlusMinusTest.java # HackerRank tests (comprehensive test cases!)
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

This project features **36 complete algorithm solutions** with multiple algorithmic approaches and comprehensive testing:

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

### 12. Find the Index of the First Occurrence in a String (LeetCode #28)
- **Location**: `src/main/java/com/example/leetcode/FindFirstOccurrenceInString.java`
- **Description**: Find the index of the first occurrence of needle in haystack, or -1 if not found
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Built-in String.indexOf()**: O(n*m) time, O(1) space - *Most practical for production*
- 📚 **Brute Force**: O(n*m) time, O(1) space - *Educational baseline approach*
- ⚡ **KMP Algorithm**: O(n+m) time, O(m) space - *Optimal solution (recommended for interviews)*
- 🔄 **Rolling Hash (Rabin-Karp)**: O(n+m) average, O(n*m) worst case, O(1) space - *Alternative O(n+m) approach*
- 🔧 **Optimized Brute Force**: O(n*m) worst case, O(1) space - *Enhanced with early termination*

**Examples**:
```java
Input: haystack = "sadbutsad", needle = "sad" -> Output: 0
Input: haystack = "leetcode", needle = "leeto" -> Output: -1
Input: haystack = "hello", needle = "ll" -> Output: 2
Input: haystack = "mississippi", needle = "issip" -> Output: 4
```

**Special Features**:
- 🎯 **Multiple Algorithmic Approaches**: 5 different solutions for comprehensive learning
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null inputs, empty strings, single characters, large inputs
- 📈 **Constraint Handling**: Handles LeetCode constraints (10,000 characters each)
- 🔧 **Algorithm-Specific Optimizations**: KMP failure function, rolling hash collision handling
- 🌟 **Educational Value**: Demonstrates classic string matching algorithms

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 13. Add Binary (LeetCode #67)
- **Location**: `src/main/java/com/example/leetcode/AddBinary.java`
- **Description**: Given two binary strings a and b, return their sum as a binary string
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Manual Addition with StringBuilder**: O(n) time, O(n) space - *Most efficient and interview-friendly (recommended)*
- 📚 **Built-in BigInteger**: O(n) time, O(n) space - *Simple but has overhead for large inputs*
- 🔧 **Manual Addition with Array**: O(n) time, O(n) space - *Alternative to StringBuilder approach*
- 🔄 **Recursive Approach**: O(n) time, O(n) space - *Educational approach demonstrating problem structure*
- ⚡ **Bit Manipulation**: O(n) time, O(n) space - *Advanced approach using bit operations*
- 🎯 **Optimized Manual Addition**: O(n) time, O(n) space - *Enhanced with early termination*

**Examples**:
```java
Input: a = "11", b = "1" -> Output: "100"
Input: a = "1010", b = "1011" -> Output: "10101"
Input: a = "0", b = "0" -> Output: "0"
Input: a = "1111", b = "1111" -> Output: "11110"
```

**Special Features**:
- 🎯 **Multiple Algorithmic Approaches**: 6 different solutions for comprehensive learning
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null inputs, zero operands, single digits, maximum carry propagation
- 📈 **Constraint Handling**: Handles LeetCode constraints (10,000 characters each)
- 🔧 **Algorithm-Specific Optimizations**: Early termination, efficient string building
- 🌟 **Educational Value**: Demonstrates binary arithmetic, carry propagation, and string manipulation
- 💡 **Verification Tools**: Decimal conversion for result verification

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 14. Plus One (LeetCode #66)
- **Location**: `src/main/java/com/example/leetcode/PlusOne.java`
- **Description**: Increment a large integer represented as an array of digits by one
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Simple Iterative**: O(n) time, O(1) space - *Most efficient and interview-friendly (recommended)*
- 🔄 **Recursive Approach**: O(n) time, O(n) space - *Educational approach demonstrating problem structure*
- 📚 **String Conversion**: O(n) time, O(n) space - *Alternative approach using string manipulation*
- ⚡ **Mathematical Approach**: O(n) time, O(1) space - *Optimized with mathematical operations*
- 🎯 **Two-Pass Approach**: O(n) time, O(1) space - *Minimizes operations in best case*
- 🔧 **Optimized In-Place**: O(n) time, O(1) space - *Modifies input when possible*

**Examples**:
```java
Input: [1,2,3] -> Output: [1,2,4]
Input: [4,3,2,1] -> Output: [4,3,2,2]
Input: [9] -> Output: [1,0]
Input: [9,9,9] -> Output: [1,0,0,0]
```

**Special Features**:
- 🎯 **Multiple Algorithmic Approaches**: 6 different solutions for comprehensive learning
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null inputs, empty arrays, single digits, all nines, carry propagation
- 📈 **Constraint Handling**: Handles LeetCode constraints (100 digits, 0-9 values)
- 🔧 **Algorithm-Specific Optimizations**: In-place modification, two-pass optimization
- 🌟 **Educational Value**: Demonstrates array manipulation, carry handling, and space optimization
- 💡 **Verification Tools**: Array-to-value conversion for result verification

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 15. Sqrt(x) (LeetCode #69)
- **Location**: `src/main/java/com/example/leetcode/SqrtX.java`
- **Description**: Compute the integer square root of a non-negative integer x without using built-in exponent functions
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Binary Search**: O(log x) time, O(1) space - *Most efficient and interview-friendly (recommended)*
- 📚 **Newton's Method**: O(log x) time, O(1) space - *Mathematical approach with fast convergence*
- 🔧 **Linear Search**: O(√x) time, O(1) space - *Educational baseline approach*
- ⚡ **Bit Manipulation**: O(log x) time, O(1) space - *Advanced approach using bit operations*
- 🎯 **Exponential Search**: O(log x) time, O(1) space - *Alternative binary search with range finding*
- 🔄 **Optimized Binary Search**: O(log x) time, O(1) space - *Production-ready with overflow protection*

**Examples**:
```java
Input: 4 -> Output: 2
Input: 8 -> Output: 2 (since 2² = 4 ≤ 8 < 3² = 9)
Input: 9 -> Output: 3
Input: 15 -> Output: 3 (since 3² = 9 ≤ 15 < 4² = 16)
Input: 2147483647 -> Output: 46340
```

**Special Features**:
- 🎯 **Multiple Algorithmic Approaches**: 6 different solutions for comprehensive learning
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Zero, one, perfect squares, non-perfect squares, maximum integer
- 📈 **Constraint Handling**: Handles LeetCode constraints (0 ≤ x ≤ 2³¹ - 1)
- 🔧 **Overflow Protection**: Prevents integer overflow in calculations
- 🌟 **Educational Value**: Demonstrates binary search, mathematical methods, and bit manipulation
- 💡 **Key Insight**: Avoid overflow by using division instead of multiplication

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 16. Climbing Stairs (LeetCode #70)
- **Location**: `src/main/java/com/example/leetcode/ClimbingStairs.java`
- **Description**: Find the number of distinct ways to climb to the top of a staircase with n steps, taking either 1 or 2 steps at a time
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Dynamic Programming (Bottom-up)**: O(n) time, O(1) space - *Most efficient and interview-friendly (recommended)*
- 📚 **Dynamic Programming (Memoization)**: O(n) time, O(n) space - *Top-down approach with caching*
- 🔄 **Recursive Solution**: O(2^n) time, O(n) space - *Educational baseline (exponential complexity)*
- ⚡ **Matrix Exponentiation**: O(log n) time, O(1) space - *Advanced mathematical approach*
- 🎯 **Fibonacci Formula**: O(1) time, O(1) space - *Direct mathematical computation*
- 🔧 **Iterative Fibonacci**: O(n) time, O(1) space - *Simple and efficient approach*

**Examples**:
```java
Input: n = 2 -> Output: 2 (1+1, 2)
Input: n = 3 -> Output: 3 (1+1+1, 1+2, 2+1)
Input: n = 4 -> Output: 5 (1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2)
Input: n = 5 -> Output: 8 (follows Fibonacci sequence)
```

**Special Features**:
- 🎯 **Fibonacci Pattern Recognition**: Demonstrates how the problem follows the Fibonacci sequence
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Minimum constraint (n=1), maximum constraint (n=45), Fibonacci sequence verification
- 📈 **Constraint Handling**: Handles LeetCode constraints (1 ≤ n ≤ 45)
- 🔧 **Algorithm-Specific Optimizations**: Space optimization, mathematical formulas, matrix operations
- 🌟 **Educational Value**: Demonstrates dynamic programming, recursion, mathematical optimization, and Fibonacci properties
- 💡 **Key Insight**: The number of ways to reach step n = ways to reach (n-1) + ways to reach (n-2)

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 17. Merge Sorted Array (LeetCode #88)
- **Location**: `src/main/java/com/example/leetcode/MergeSortedArray.java`
- **Description**: Merge two sorted arrays in-place into nums1 without using extra space
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Two Pointers from End**: O(m + n) time, O(1) space - *Optimal solution (recommended)*
- 📚 **Copy and Sort**: O((m + n) log(m + n)) time, O(1) space - *Simple but not optimal*
- ⚡ **Auxiliary Array**: O(m + n) time, O(m + n) space - *Optimal time but uses extra space*
- 🔧 **Two Pointers from Start**: O(m + n) time, O(m) space - *Alternative with backup array*
- 🎯 **Optimized Two Pointers**: O(m + n) time, O(1) space - *Enhanced version of recommended approach*
- 🔄 **Recursive Merge**: O(m + n) time, O(m + n) space - *Educational recursive approach*

**Examples**:
```java
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
```

**Special Features**:
- 🎯 **In-place Merging**: Modifies nums1 without using extra space (optimal approach)
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty arrays, single elements, maximum constraints, negative numbers
- 📈 **Constraint Handling**: Handles LeetCode constraints (200 elements, -10^9 to 10^9 values)
- 🔧 **Algorithm-Specific Optimizations**: Space optimization, mathematical approaches, recursive solutions
- 🌟 **Educational Value**: Demonstrates in-place array manipulation, two-pointer techniques, and merge algorithms
- 💡 **Key Insight**: Work backwards from the end to avoid overwriting unprocessed elements

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 18. Convert Sorted Array to Binary Search Tree (LeetCode #108)
- **Location**: `src/main/java/com/example/leetcode/ConvertSortedArrayToBST.java`
- **Description**: Convert a sorted array into a height-balanced binary search tree
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Recursive Divide and Conquer**: O(n) time, O(log n) space - *Optimal solution (recommended)*
- ⚡ **Iterative with Stack**: O(n) time, O(log n) space - *Avoids recursion stack overflow*
- 🔧 **Recursive with Helper Class**: O(n) time, O(log n) space - *Object-oriented approach*
- 📚 **Recursive with Array Copy**: O(n log n) time, O(n) space - *Educational approach with subarrays*
- 🎯 **Optimized Recursive**: O(n) time, O(log n) space - *Enhanced with better variable naming*
- 🔍 **Recursive with Validation**: O(n) time, O(log n) space - *Includes input validation*

**Examples**:
```java
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]

Input: nums = [1,3]
Output: [3,1]

Input: nums = [1]
Output: [1]
```

**Special Features**:
- 🌳 **Height-Balanced Trees**: Ensures tree depth difference never exceeds 1
- 📊 **BST Validation**: All approaches produce valid binary search trees
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Single elements, two elements, maximum constraints, negative numbers
- 📈 **Constraint Handling**: Handles LeetCode constraints (10,000 elements, -10,000 to 10,000 values)
- 🔧 **Tree Utilities**: Height calculation, balance checking, node counting, traversal methods
- 🌟 **Educational Value**: Demonstrates divide-and-conquer, tree construction, and recursion
- 💡 **Key Insight**: Always choose middle element as root to ensure height balance

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 19. Maximum Depth of Binary Tree (LeetCode #104)
- **Location**: `src/main/java/com/example/leetcode/MaximumDepthOfBinaryTree.java`
- **Description**: Find the maximum depth of a binary tree (number of nodes along longest path from root to leaf)
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Recursive DFS**: O(n) time, O(h) space - *Most intuitive and commonly used (recommended)*
- ⚡ **Iterative BFS**: O(n) time, O(w) space - *Level-order traversal approach*
- 🔧 **Iterative DFS**: O(n) time, O(h) space - *Simulates recursion with explicit stack*
- 📚 **Optimized Recursive**: O(n) time, O(h) space - *Enhanced with better variable naming*
- 🎯 **One-liner Recursive**: O(n) time, O(h) space - *Most concise version*
- 🔍 **With Validation**: O(n) time, O(h) space - *Includes input validation and safety checks*

**Examples**:
```java
Input: [3,9,20,null,null,15,7] -> Output: 3
Input: [1,null,2]              -> Output: 2
Input: [1]                     -> Output: 1
Input: []                      -> Output: 0
```

**Special Features**:
- 🌳 **Tree Utilities**: Tree creation, conversion, height calculation, balance checking
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty trees, single nodes, skewed trees, complete trees
- 📈 **Constraint Handling**: Handles LeetCode constraints (10,000 nodes, -100 to 100 values)
- 🔧 **Algorithm-Specific Optimizations**: Space optimization, early termination, validation
- 🌟 **Educational Value**: Demonstrates tree traversal, recursion, iteration, and space complexity trade-offs
- 💡 **Key Insight**: Maximum depth = 1 + max(left_depth, right_depth)

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 20. Balanced Binary Tree (LeetCode #110)
- **Location**: `src/main/java/com/example/leetcode/BalancedBinaryTree.java`
- **Description**: Determine if a binary tree is height-balanced (depth of two subtrees never differs by more than 1)
- **Multiple Approaches**: 4 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Bottom-up Recursion**: O(n) time, O(h) space - *Optimal solution (recommended)*
- 📚 **Top-down Recursion**: O(n²) time, O(h) space - *Educational approach with repeated height calculations*
- ⚡ **Iterative with Stack**: O(n) time, O(h) space - *Alternative to recursion using explicit stack*
- 🔧 **Enhanced Bottom-up**: O(n) time, O(h) space - *Optimized version with clearer separation of concerns*

**Examples**:
```java
Input: [3,9,20,null,null,15,7] -> Output: true (balanced)
Input: [1,2,2,3,3,null,null,4,4] -> Output: false (unbalanced)
Input: [] -> Output: true (empty tree is balanced)
Input: [1] -> Output: true (single node is balanced)
```

**Special Features**:
- 🌳 **Tree Utilities**: Tree creation, conversion, height calculation, balance checking
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty trees, single nodes, skewed trees, perfectly balanced trees
- 📈 **Constraint Handling**: Handles LeetCode constraints (5,000 nodes, -10⁴ to 10⁴ values)
- 🔧 **Algorithm-Specific Optimizations**: Early termination, space optimization, mathematical properties
- 🌟 **Educational Value**: Demonstrates tree traversal, recursion, iteration, and balance concepts
- 💡 **Key Insight**: A tree is balanced if height difference ≤ 1 and both subtrees are balanced

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 21. Single Number (LeetCode #136)
- **Location**: `src/main/java/com/example/leetcode/SingleNumber.java`
- **Description**: Find the unique element in an array where every other element appears exactly twice
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **XOR Operation**: O(n) time, O(1) space - *Optimal solution (recommended)*
- 📚 **HashSet Approach**: O(n) time, O(n) space - *Educational approach using set operations*
- ⚡ **Mathematical Formula**: O(n) time, O(n) space - *Uses sum properties for unique elements*
- 🔧 **HashMap Solution**: O(n) time, O(n) space - *Frequency counting approach*
- 🎯 **Sorting Solution**: O(n log n) time, O(1) space - *Alternative approach with sorting*

**Examples**:
```java
Input: [2,2,1] -> Output: 1
Input: [4,1,2,1,2] -> Output: 4
Input: [1] -> Output: 1
Input: [-1,-1,-2] -> Output: -2
```

**Special Features**:
- 🎯 **XOR Properties**: Demonstrates bitwise XOR properties (a ^ a = 0, a ^ 0 = a)
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Single elements, negative numbers, maximum constraints
- 📈 **Constraint Handling**: Handles LeetCode constraints (30,000 elements, -30,000 to 30,000 values)
- 🔧 **Algorithm-Specific Optimizations**: Space optimization, mathematical properties, bit manipulation
- 🌟 **Educational Value**: Demonstrates XOR operations, hash tables, mathematical formulas, and sorting
- 💡 **Key Insight**: XOR cancels out pairs, leaving only the single number

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 22. Minimum Depth of Binary Tree (LeetCode #111)
- **Location**: `src/main/java/com/example/leetcode/MinimumDepthOfBinaryTree.java`
- **Description**: Find the minimum depth of a binary tree (shortest path from root to nearest leaf node)
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Recursive DFS**: O(n) time, O(h) space - *Most intuitive and commonly used (recommended)*
- ⚡ **Iterative BFS**: O(n) time, O(w) space - *Level-order traversal approach*
- 🔧 **Iterative DFS with Stack**: O(n) time, O(h) space - *Simulates recursion with explicit stack*
- 📚 **Level Order Traversal**: O(n) time, O(w) space - *Explicit depth tracking approach*
- 🎯 **Morris Traversal**: O(n) time, O(1) space - *Constant space approach*
- 🔍 **Optimized Recursive**: O(n) time, O(h) space - *Concise recursive version*

**Examples**:
```java
Input: [3,9,20,null,null,15,7] -> Output: 2
Input: [2,null,3,null,4,null,5,null,6] -> Output: 5
Input: [1,2,3,4,5] -> Output: 2
Input: [1] -> Output: 1
Input: [] -> Output: 0
```

**Special Features**:
- 🌳 **Tree Utilities**: Tree creation, conversion, height calculation, balance checking
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty trees, single nodes, skewed trees, complete trees
- 📈 **Constraint Handling**: Handles LeetCode constraints (10^5 nodes, -1000 to 1000 values)
- 🔧 **Algorithm-Specific Optimizations**: Space optimization, early termination, validation
- 🌟 **Educational Value**: Demonstrates tree traversal, recursion, iteration, and space complexity trade-offs
- 💡 **Key Insight**: Minimum depth = shortest path to a leaf node, must handle null subtrees correctly

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 23. Pascal's Triangle II (LeetCode #119)
- **Location**: `src/main/java/com/example/leetcode/PascalsTriangleII.java`
- **Description**: Return the kth (0-indexed) row of Pascal's triangle using efficient algorithms
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Iterative In-Place**: O(k²) time, O(k) space - *Most efficient and interview-friendly (recommended)*
- ⚡ **Mathematical Formula**: O(k) time, O(k) space - *Fastest using combinatorial formula*
- 🔧 **Recursive Approach**: O(2^k) time, O(k) space - *Educational but exponential complexity*
- 📚 **Two Arrays**: O(k²) time, O(k) space - *Intuitive approach using previous row*
- 🎯 **Combinatorial with Memoization**: O(k) time, O(k) space - *Optimized mathematical approach*
- 🔍 **Dynamic Programming**: O(k²) time, O(k) space - *Clean iterative solution*

**Examples**:
```java
Input: rowIndex = 3 -> Output: [1,3,3,1]
Input: rowIndex = 0 -> Output: [1]
Input: rowIndex = 1 -> Output: [1,1]
Input: rowIndex = 4 -> Output: [1,4,6,4,1]
Input: rowIndex = 5 -> Output: [1,5,10,10,5,1]
```

**Special Features**:
- 🧮 **Mathematical Properties**: Demonstrates combinatorial formulas and Pascal's triangle properties
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Row index 0, 1, maximum constraint (33), large inputs
- 📈 **Constraint Handling**: Handles LeetCode constraints (0 ≤ rowIndex ≤ 33)
- 🔧 **Algorithm-Specific Optimizations**: In-place building, combinatorial calculations, memoization
- 🌟 **Educational Value**: Demonstrates mathematical algorithms, recursion, dynamic programming, and optimization
- 💡 **Key Insight**: Each element = C(n,k) = n!/(k!(n-k)!), build in-place from right to left

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 24. Best Time to Buy and Sell Stock (LeetCode #121)
- **Location**: `src/main/java/com/example/leetcode/BestTimeToBuyAndSellStock.java`
- **Description**: Find maximum profit from buying and selling stock once using efficient algorithms
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **One Pass (Optimal)**: O(n) time, O(1) space - *Most efficient and interview-friendly (recommended)*
- ⚡ **Brute Force**: O(n²) time, O(1) space - *Check all buy-sell combinations*
- 🔧 **Dynamic Programming**: O(n) time, O(n) space - *Clear logic with state tracking*
- 📚 **Peak Valley Analysis**: O(n) time, O(1) space - *Intuitive valley-peak approach*
- 🎯 **Kadane's Algorithm**: O(n) time, O(1) space - *Convert to maximum subarray problem*
- 🔍 **Divide and Conquer**: O(n log n) time, O(log n) space - *Educational recursive approach*

**Examples**:
```java
Input: prices = [7,1,5,3,6,4] -> Output: 5 (Buy at 1, sell at 6)
Input: prices = [7,6,4,3,1] -> Output: 0 (No profit possible)
Input: prices = [1,2,3,4,5] -> Output: 4 (Buy at 1, sell at 5)
Input: prices = [2,4,1] -> Output: 2 (Buy at 2, sell at 4)
```

**Special Features**:
- 💰 **Financial Algorithm**: Demonstrates real-world stock trading optimization
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null arrays, empty arrays, single elements, no profit scenarios
- 📈 **Constraint Handling**: Handles LeetCode constraints (1 ≤ length ≤ 10⁵, 0 ≤ price ≤ 10⁴)
- 🔧 **Algorithm-Specific Optimizations**: One-pass optimization, Kadane's algorithm, peak valley analysis
- 🌟 **Educational Value**: Demonstrates greedy algorithms, dynamic programming, and optimization techniques
- 💡 **Key Insight**: Track minimum price seen so far and calculate profit at each step

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 25. Print in Order (LeetCode #1114)
- **Location**: `src/main/java/com/example/leetcode/PrintInOrder.java`
- **Description**: Ensure thread-safe execution order using multiple synchronization approaches
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Semaphore (Recommended)**: O(1) time, O(1) space - *Clean and intuitive synchronization*
- ⚡ **CountDownLatch**: O(1) time, O(1) space - *Perfect for one-time coordination*
- 🔧 **ReentrantLock with Condition**: O(1) time, O(1) space - *Fine-grained control over synchronization*
- 📚 **AtomicInteger with Busy Wait**: O(1) time, O(1) space - *Lowest latency approach*
- 🎯 **Synchronized with wait/notify**: O(1) time, O(1) space - *Classic Java synchronization*
- 🔍 **CompletableFuture**: O(1) time, O(1) space - *Functional programming style*

**Examples**:
```java
Input: [1,2,3] -> Output: "firstsecondthird"
Input: [1,3,2] -> Output: "firstsecondthird"
Input: [3,1,2] -> Output: "firstsecondthird"
Input: [3,2,1] -> Output: "firstsecondthird"
```

**Special Features**:
- 🧵 **Thread Synchronization**: Demonstrates multiple Java concurrency mechanisms
- 📊 **Cross-Validation**: All approaches produce identical results regardless of execution order
- ⚡ **Performance Analysis**: Live timing comparison between synchronization approaches
- 🧪 **Edge Case Testing**: All possible execution orders, stress testing, concurrent execution
- 📈 **Concurrency Patterns**: Semaphores, latches, locks, atomic operations, futures
- 🔧 **Algorithm-Specific Optimizations**: Different synchronization strategies for various use cases
- 🌟 **Educational Value**: Demonstrates thread safety, synchronization primitives, and concurrency patterns
- 💡 **Key Insight**: Thread synchronization ensures correct execution order regardless of thread scheduling

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 26. Find Most Frequent Vowel and Consonant (LeetCode #3541)
- **Location**: `src/main/java/com/example/leetcode/FindMostFrequentVowelAndConsonant.java`
- **Description**: Find the sum of the maximum frequency of any vowel and the maximum frequency of any consonant in a string
- **Multiple Approaches**: 4 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Frequency Array**: O(n) time, O(1) space - *Most efficient and interview-friendly (recommended)*
- 📚 **HashMap Approach**: O(n) time, O(1) space - *Alternative using HashMap for frequency counting*
- ⚡ **Single Pass**: O(n) time, O(1) space - *Count vowels and consonants separately in one pass*
- 🔧 **Streams Approach**: O(n) time, O(1) space - *Functional programming style with Java streams*

**Examples**:
```java
Input: "leetcode" -> Output: 4 (e appears 3 times max vowel, l,t,c,d each appear 1 time max consonant = 1)
Input: "aeiou"    -> Output: 1 (each vowel appears once, no consonants)
Input: "abcde"    -> Output: 2 (each character appears once: max vowel = 1, max consonant = 1)
Input: "programming" -> Output: 3 (o,a,i each appear 1 time max vowel = 1, r,g,m each appear 2 times max consonant = 2)
```

**Special Features**:
- 🎯 **Character Classification**: Automatically separates vowels (a,e,i,o,u) from consonants
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Single characters, all vowels, all consonants, maximum constraints
- 📈 **Constraint Handling**: Handles LeetCode constraints (1 ≤ length ≤ 1000, lowercase letters only)
- 🔧 **Algorithm-Specific Optimizations**: Array-based counting, HashMap alternatives, stream processing
- 🌟 **Educational Value**: Demonstrates frequency counting, character classification, and multiple algorithmic approaches
- 💡 **Key Insight**: Count frequencies separately for vowels and consonants, then find maximum of each group

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 27. Linked List Cycle (LeetCode #141)
- **Location**: `src/main/java/com/example/leetcode/LinkedListCycle.java`
- **Description**: Determine if a linked list has a cycle using multiple detection algorithms
- **Multiple Approaches**: 4 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Floyd's Cycle Detection (Tortoise and Hare)**: O(n) time, O(1) space - *Optimal solution (recommended)*
- 📚 **HashSet Approach**: O(n) time, O(n) space - *Educational approach using visited node tracking*
- ⚡ **Marking Nodes**: O(n) time, O(1) space - *Destructive approach modifying node values*
- 🔧 **Reverse List**: O(n) time, O(1) space - *Alternative destructive approach*

**Examples**:
```java
Input: head = [3,2,0,-4], pos = 1 -> Output: true (cycle exists)
Input: head = [1,2], pos = 0 -> Output: true (cycle exists)
Input: head = [1], pos = -1 -> Output: false (no cycle)
Input: head = [], pos = -1 -> Output: false (empty list)
```

**Special Features**:
- 🔄 **Cycle Detection**: Demonstrates classic Floyd's algorithm (tortoise and hare)
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty lists, single nodes, self-cycles, long lists
- 📈 **Constraint Handling**: Handles LeetCode constraints (10,000 nodes, -10⁵ to 10⁵ values)
- 🔧 **Algorithm-Specific Optimizations**: Space optimization, non-destructive vs destructive approaches
- 🌟 **Educational Value**: Demonstrates linked list manipulation, cycle detection, and pointer techniques
- 💡 **Key Insight**: Floyd's algorithm works because fast pointer will eventually catch slow pointer in a cycle

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 28. Print FooBar Alternately (LeetCode #1115)
- **Location**: `src/main/java/com/example/leetcode/PrintFooBarAlternately.java`
- **Description**: Coordinate two threads to print "foo" and "bar" alternately n times using multiple synchronization approaches
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Semaphore Approach**: O(n) time, O(1) space - *Most intuitive and interview-friendly (recommended)*
- ⚡ **Atomic Integer Approach**: O(n) time, O(1) space - *Uses atomic counter with modulo operation*
- 🔧 **ReentrantLock with Condition**: O(n) time, O(1) space - *Fine-grained control over synchronization*
- 📚 **Synchronized Blocks**: O(n) time, O(1) space - *Classic Java synchronization with wait/notify*
- 🎯 **Volatile Boolean**: O(n) time, O(1) space - *Simple but less efficient due to busy waiting*

**Examples**:
```java
Input: n = 1 -> Output: "foobar"
Input: n = 2 -> Output: "foobarfoobar"
Input: n = 3 -> Output: "foobarfoobarfoobar"
Input: n = 5 -> Output: "foobarfoobarfoobarfoobarfoobar"
```

**Special Features**:
- 🧵 **Thread Synchronization**: Demonstrates multiple Java concurrency mechanisms
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between synchronization approaches
- 🧪 **Edge Case Testing**: Minimum n=1, maximum n=1000, stress testing, concurrent execution
- 📈 **Concurrency Patterns**: Semaphores, atomic operations, locks, synchronized blocks, volatile variables
- 🔧 **Algorithm-Specific Optimizations**: Different synchronization strategies for various use cases
- 🌟 **Educational Value**: Demonstrates thread safety, synchronization primitives, and concurrency patterns
- 💡 **Key Insight**: Thread coordination ensures correct alternating output regardless of thread scheduling

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 29. Customers Who Never Order (LeetCode #183)
- **Location**: `src/main/java/com/example/leetcode/CustomersWhoNeverOrder.java`
- **Description**: Find all customers who never order anything using multiple SQL and Java approaches
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **SQL NOT IN**: O(n + m) time, O(m) space - *Most intuitive SQL approach (recommended)*
- ⚡ **SQL LEFT JOIN**: O(n + m) time, O(m) space - *Efficient JOIN-based approach*
- 🔧 **SQL NOT EXISTS**: O(n * m) time, O(1) space - *Subquery-based approach*
- 📚 **Java HashSet**: O(n + m) time, O(m) space - *Most efficient Java approach*
- 🎯 **Java Stream**: O(n + m) time, O(m) space - *Functional programming style*
- 🔍 **Java Nested Loop**: O(n * m) time, O(1) space - *Educational brute force approach*

**Examples**:
```java
Input: 
Customers: [(1, "Joe"), (2, "Henry"), (3, "Sam"), (4, "Max")]
Orders: [(1, 3), (2, 1)]

Output: ["Henry", "Max"]
```

**Special Features**:
- 🗄️ **SQL Query Generation**: Provides actual SQL queries for each approach
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: No customers, no orders, all customers ordered, duplicates
- 📈 **Database Simulation**: Java implementations simulate database operations
- 🔧 **Algorithm-Specific Optimizations**: HashSet for O(1) lookup, Streams for functional style
- 🌟 **Educational Value**: Demonstrates SQL concepts, Java collections, and algorithm optimization
- 💡 **Key Insight**: Use HashSet for O(1) lookup time in Java, or appropriate SQL JOINs for database queries

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 30. Valid Palindrome (LeetCode #125)
- **Location**: `src/main/java/com/example/leetcode/ValidPalindrome.java`
- **Description**: Determine if a string is a palindrome after removing non-alphanumeric characters and ignoring case
- **Multiple Approaches**: 7 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Two Pointers**: O(n) time, O(1) space - *Optimal solution (recommended)*
- ⚡ **String Preprocessing**: O(n) time, O(n) space - *Clean string first, then check*
- 🔧 **Recursive**: O(n) time, O(n) space - *Recursive palindrome checking*
- 📚 **Stack**: O(n) time, O(n) space - *Use stack to reverse and compare*
- 🎯 **StringBuilder**: O(n) time, O(n) space - *Build cleaned string and reverse*
- 🔍 **Character Array**: O(n) time, O(n) space - *Convert to char array and use two pointers*
- 🌟 **Optimized Two Pointers**: O(n) time, O(1) space - *Enhanced with helper methods*

**Examples**:
```java
Input: "A man, a plan, a canal: Panama" -> Output: true
Input: "race a car" -> Output: false
Input: " " -> Output: true
Input: "Madam" -> Output: true
Input: "12321" -> Output: true
```

**Special Features**:
- 🔤 **Character Filtering**: Automatically removes non-alphanumeric characters
- 📊 **Case Insensitive**: Handles mixed case correctly
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty strings, single characters, special characters, mixed alphanumeric
- 📈 **Cross-Validation**: All approaches produce identical results
- 🔧 **Algorithm-Specific Optimizations**: Two pointers for O(1) space, preprocessing for readability
- 🌟 **Educational Value**: Demonstrates string manipulation, two-pointer technique, and palindrome concepts
- 💡 **Key Insight**: Use two pointers from start and end, skip non-alphanumeric characters, compare case-insensitively

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 31. Count Complete Tree Nodes (LeetCode #222)
- **Location**: `src/main/java/com/example/leetcode/CountCompleteTreeNodes.java`
- **Description**: Count the number of nodes in a complete binary tree efficiently
- **Multiple Approaches**: 8 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Recursive Height Comparison**: O(log²n) time, O(logn) space - *Optimal solution (recommended)*
- ⚡ **Level Order Traversal**: O(n) time, O(n) space - *BFS traversal counting all nodes*
- 🔧 **Inorder Traversal**: O(n) time, O(logn) space - *DFS traversal counting all nodes*
- 📚 **Postorder Traversal**: O(n) time, O(logn) space - *DFS traversal counting all nodes*
- 🎯 **Preorder Traversal**: O(n) time, O(logn) space - *DFS traversal counting all nodes*
- 🔍 **Binary Search on Leaves**: O(log²n) time, O(logn) space - *Binary search on last level*
- 🌟 **Iterative Height Comparison**: O(log²n) time, O(1) space - *Iterative optimal approach*
- 💡 **Simple Recursive**: O(n) time, O(logn) space - *Simple recursive counting*

**Examples**:
```java
Input: root = [1,2,3,4,5,6] -> Output: 6
Input: root = [] -> Output: 0
Input: root = [1] -> Output: 1
Input: Perfect binary tree (15 nodes) -> Output: 15
Input: Complete tree (8 nodes) -> Output: 8
```

**Special Features**:
- 🌳 **Complete Binary Tree Properties**: Leverages structural properties for optimal counting
- ⚡ **Height Comparison**: Uses height comparison to identify perfect subtrees
- 📊 **Perfect Subtree Detection**: Calculates perfect subtree nodes using 2^height - 1 formula
- 🧪 **Edge Case Testing**: Empty trees, single nodes, perfect binary trees, complete trees
- 📈 **Cross-Validation**: All approaches produce identical results
- 🔧 **Algorithm-Specific Optimizations**: Height comparison for O(log²n), traversal for O(n)
- 🌟 **Educational Value**: Demonstrates tree traversal, binary tree properties, and optimization techniques
- 💡 **Key Insight**: If left and right subtrees have same height, left subtree is perfect and can be calculated directly

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 32. Counting Bits (LeetCode #338)
- **Location**: `src/main/java/com/example/leetcode/CountingBits.java`
- **Description**: Count the number of 1's in the binary representation of each number from 0 to n
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Dynamic Programming with Right Shift**: O(n) time, O(n) space - *Optimal solution (recommended)*
- ⚡ **Dynamic Programming with Power of 2**: O(n) time, O(n) space - *Alternative DP approach*
- 🔧 **Dynamic Programming with Last Set Bit**: O(n) time, O(n) space - *Bit manipulation approach*
- 📚 **Naive Approach**: O(n log n) time, O(n) space - *Educational baseline approach*
- 🎯 **Built-in Method**: O(n log n) time, O(n) space - *Using Integer.bitCount()*
- 🌟 **Optimized Bit Manipulation**: O(n) time, O(n) space - *Enhanced bit operations*

**Examples**:
```java
Input: n = 2 -> Output: [0,1,1]
Input: n = 5 -> Output: [0,1,1,2,1,2]
Input: n = 8 -> Output: [0,1,1,2,1,2,2,3,1]
Input: n = 15 -> Output: [0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4]
```

**Special Features**:
- 🎯 **Dynamic Programming Patterns**: Demonstrates multiple DP approaches for bit counting
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Zero, powers of 2, maximum constraints, consecutive numbers
- 📈 **Constraint Handling**: Handles LeetCode constraints (0 ≤ n ≤ 10⁵)
- 🔧 **Algorithm-Specific Optimizations**: Right shift, power of 2 detection, last set bit manipulation
- 🌟 **Educational Value**: Demonstrates dynamic programming, bit manipulation, and optimization techniques
- 💡 **Key Insight**: ans[i] = ans[i >> 1] + (i & 1) - count equals count of i/2 plus least significant bit

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 33. Intersection of Two Linked Lists (LeetCode #160)
- **Location**: `src/main/java/com/example/leetcode/IntersectionOfTwoLinkedLists.java`
- **Description**: Find the node where two singly linked lists intersect
- **Multiple Approaches**: 6 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Two-Pointer Technique**: O(m + n) time, O(1) space - *Optimal solution (recommended)*
- ⚡ **Length Difference Method**: O(m + n) time, O(1) space - *Alternative optimal approach*
- 🔧 **HashSet Method**: O(m + n) time, O(m) space - *Hash-based approach*
- 📚 **Brute Force Method**: O(m * n) time, O(1) space - *Educational baseline approach*
- 🎯 **Stack Method**: O(m + n) time, O(m + n) space - *Stack-based approach*
- 🌟 **Reverse and Compare Method**: O(m + n) time, O(1) space - *Advanced approach*

**Examples**:
```java
Input: listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'

Input: listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'

Input: listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
```

**Special Features**:
- 🔗 **Linked List Manipulation**: Demonstrates advanced linked list traversal techniques
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null lists, single nodes, identical lists, maximum constraints
- 📈 **Constraint Handling**: Handles LeetCode constraints (1 ≤ m, n ≤ 3×10⁴)
- 🔧 **Algorithm-Specific Optimizations**: Two-pointer technique, length difference, hash-based lookup
- 🌟 **Educational Value**: Demonstrates linked list algorithms, pointer manipulation, and optimization techniques
- 💡 **Key Insight**: Two-pointer technique works because both pointers traverse same total distance (m + n)

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 34. Excel Sheet Column Title (LeetCode #168)
- **Location**: `src/main/java/com/example/leetcode/ExcelSheetColumnTitle.java`
- **Description**: Convert a positive integer to its corresponding Excel column title (A, B, ..., Z, AA, AB, ...)
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Iterative Base-26 Conversion**: O(log₂₆(n)) time, O(log₂₆(n)) space - *Optimal solution (recommended)*
- ⚡ **Recursive Base-26 Conversion**: O(log₂₆(n)) time, O(log₂₆(n)) space - *Recursive approach with same logic*
- 🔧 **Optimized with Pre-allocation**: O(log₂₆(n)) time, O(log₂₆(n)) space - *Pre-allocates StringBuilder capacity*
- 📚 **Character Array Approach**: O(log₂₆(n)) time, O(log₂₆(n)) space - *Uses char array instead of StringBuilder*
- 🎯 **Mathematical Formula**: O(log₂₆(n)) time, O(log₂₆(n)) space - *Direct calculation without reverse*

**Examples**:
```java
Input: 1 -> Output: "A"
Input: 26 -> Output: "Z"
Input: 27 -> Output: "AA"
Input: 28 -> Output: "AB"
Input: 701 -> Output: "ZY"
Input: 702 -> Output: "ZZ"
Input: 2147483647 -> Output: "FXSHRXW"
```

**Special Features**:
- 🎯 **Base-26 Conversion**: Demonstrates 1-indexed base-26 number system (unlike standard 0-indexed)
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Single characters, boundary transitions, large numbers, maximum constraints
- 📈 **Constraint Handling**: Handles LeetCode constraints (1 ≤ columnNumber ≤ 2³¹ - 1)
- 🔧 **Algorithm-Specific Optimizations**: Pre-allocation, character arrays, mathematical formulas
- 🌟 **Educational Value**: Demonstrates base conversion, string manipulation, and mathematical properties
- 💡 **Key Insight**: Excel columns are 1-indexed, so subtract 1 before modulo operation to convert to 0-indexed

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 35. Count and Say (LeetCode #38)
- **Location**: `src/main/java/com/example/leetcode/CountAndSay.java`
- **Description**: Generate the nth term of the count-and-say sequence where each term describes the previous term
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Iterative String Building**: O(n * m) time, O(m) space - *Optimal solution (recommended)*
- ⚡ **Recursive with Memoization**: O(n * m) time, O(n * m) space - *Intuitive recursive approach*
- 🔧 **Optimized Iterative**: O(n * m) time, O(m) space - *Pre-allocated StringBuilder capacity*
- 📚 **Character Array Approach**: O(n * m) time, O(m) space - *Uses char arrays for performance*
- 🎯 **Two-Pointer Technique**: O(n * m) time, O(m) space - *Efficient consecutive digit counting*

**Examples**:
```java
Input: n = 1 -> Output: "1"
Input: n = 2 -> Output: "11" (one 1)
Input: n = 3 -> Output: "21" (two 1s)
Input: n = 4 -> Output: "1211" (one 2, then one 1)
Input: n = 5 -> Output: "111221" (one 1, one 2, then two 1s)
Input: n = 6 -> Output: "312211" (three 1s, two 2s, then one 1)
```

**Special Features**:
- 🎯 **Sequence Generation**: Demonstrates recursive sequence building and pattern recognition
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Base cases, maximum constraints, sequence progression
- 📈 **Constraint Handling**: Handles LeetCode constraints (1 ≤ n ≤ 30)
- 🔧 **Algorithm-Specific Optimizations**: Pre-allocation, character arrays, two-pointer technique
- 🌟 **Educational Value**: Demonstrates string manipulation, sequence generation, and pattern analysis
- 💡 **Key Insight**: Each term describes the previous term by counting consecutive digits
- 🛠️ **Utility Methods**: Sequence generation, term analysis, length calculation

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 36. Majority Element (LeetCode #169)
- **Location**: `src/main/java/com/example/leetcode/MajorityElement.java`
- **Description**: Find the majority element that appears more than ⌊n / 2⌋ times in an array
- **Multiple Approaches**: 7 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Boyer-Moore Voting Algorithm**: O(n) time, O(1) space - *Optimal solution (recommended)*
- ⚡ **Boyer-Moore with Verification**: O(n) time, O(1) space - *Robust approach with validation*
- 🔧 **HashMap Approach**: O(n) time, O(n) space - *Frequency counting approach*
- 📚 **Sorting Approach**: O(n log n) time, O(1) space - *Sort and return middle element*
- 🎯 **Randomization Approach**: O(n) expected time, O(1) space - *Probabilistic algorithm*
- 🔄 **Divide and Conquer**: O(n log n) time, O(log n) space - *Recursive approach*
- 💡 **Bit Manipulation**: O(32 * n) time, O(1) space - *Bit-level analysis*

**Examples**:
```java
Input: nums = [3,2,3] -> Output: 3
Input: nums = [2,2,1,1,1,2,2] -> Output: 2
Input: nums = [1] -> Output: 1
Input: nums = [1,1,2,2,2] -> Output: 2
```

**Special Features**:
- 🎯 **Voting Algorithm**: Demonstrates the elegant Boyer-Moore majority vote algorithm
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Single element, all same elements, negative numbers
- 📈 **Constraint Handling**: Handles LeetCode constraints (1 ≤ n ≤ 5×10⁴, -10⁹ ≤ nums[i] ≤ 10⁹)
- 🔧 **Algorithm-Specific Optimizations**: Space optimization, bit manipulation, randomization
- 🌟 **Educational Value**: Demonstrates voting algorithms, frequency analysis, and divide-and-conquer
- 💡 **Key Insight**: Majority element will always "survive" the voting process
- 🛠️ **Utility Methods**: Majority verification, n/3 majority elements extension
- 🎲 **Advanced Features**: Randomization approach, bit manipulation, divide-and-conquer

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 37. Reverse Bits (LeetCode #190)
- **Location**: `src/main/java/com/example/leetcode/ReverseBits.java`
- **Description**: Reverse bits of a given 32-bit unsigned integer
- **Multiple Approaches**: 7 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Bit-by-bit Reversal**: O(32) time, O(1) space - *Simple and clear approach (recommended)*
- ⚡ **Bit Manipulation with Masks**: O(1) time, O(1) space - *Optimal solution using bit swapping*
- 🔧 **Lookup Table Approach**: O(1) time, O(1) space - *Precomputed 8-bit reversals*
- 📚 **Divide and Conquer**: O(log 32) time, O(1) space - *Recursive bit swapping*
- 🎯 **String-based Approach**: O(32) time, O(32) space - *Educational string manipulation*
- 🔄 **Precomputed Masks**: O(1) time, O(1) space - *Efficient mask-based swapping*
- 💡 **Two-Pointer Bit Swapping**: O(32) time, O(1) space - *Pointer-based bit swapping*

**Examples**:
```java
Input: n = 43261596 (00000010100101000001111010011100)
Output: 964176192 (00111001011110000010100101000000)

Input: n = 4294967293 (11111111111111111111111111111101)
Output: 3221225471 (10111111111111111111111111111111)
```

**Special Features**:
- 🎯 **Bit Manipulation Mastery**: Demonstrates advanced bit manipulation techniques
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Zero, powers of 2, palindromes, negative numbers
- 📈 **Constraint Handling**: Handles 32-bit unsigned integer constraints
- 🔧 **Algorithm-Specific Optimizations**: Lookup tables, precomputed masks, divide-and-conquer
- 🌟 **Educational Value**: Demonstrates bit manipulation, string processing, and optimization techniques
- 💡 **Key Insight**: Multiple ways to reverse bits with different time/space tradeoffs
- 🛠️ **Utility Methods**: Binary string conversion, set bit counting, power of 2 detection
- 🎲 **Advanced Features**: Lookup tables, precomputed masks, two-pointer technique

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 38. Happy Number (LeetCode #202)
- **Location**: `src/main/java/com/example/leetcode/HappyNumber.java`
- **Description**: Determine if a number is happy by checking if the sum of squares of digits eventually reaches 1
- **Multiple Approaches**: 7 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **HashSet Approach**: O(log n) time, O(log n) space - *Simple cycle detection (recommended)*
- ⚡ **Floyd's Cycle Detection**: O(log n) time, O(1) space - *Optimal space-efficient solution*
- 🔧 **Mathematical Approach**: O(log n) time, O(1) space - *Using mathematical properties*
- 📚 **Recursive Approach**: O(log n) time, O(log n) space - *Recursive with memoization*
- 🎯 **Iterative with Early Termination**: O(log n) time, O(log n) space - *Early cycle detection*
- 🔄 **Bit Manipulation**: O(log n) time, O(1) space - *Optimized digit processing*
- 💡 **String-based Approach**: O(log n) time, O(log n) space - *Educational string processing*

**Examples**:
```java
Input: n = 19
Output: true
Explanation: 1² + 9² = 82, 8² + 2² = 68, 6² + 8² = 100, 1² + 0² + 0² = 1

Input: n = 2
Output: false
Explanation: 2² = 4, 4² = 16, 1² + 6² = 37, 3² + 7² = 58, 5² + 8² = 89, 8² + 9² = 145, 1² + 4² + 5² = 42, 4² + 2² = 20, 2² + 0² = 4 (cycle)
```

**Special Features**:
- 🎯 **Cycle Detection**: Multiple approaches to detect infinite loops
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Single digits, large numbers, boundary conditions
- 📈 **Constraint Handling**: Handles 1 ≤ n ≤ 2³¹ - 1
- 🔧 **Algorithm-Specific Optimizations**: Floyd's algorithm, mathematical properties, early termination
- 🌟 **Educational Value**: Demonstrates cycle detection, mathematical analysis, and optimization
- 💡 **Key Insight**: Happy numbers either reach 1 or enter a cycle
- 🛠️ **Utility Methods**: Sequence generation, step counting, range finding
- 🎲 **Advanced Features**: Floyd's cycle detection, mathematical optimization, bit manipulation

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 39. Plus Minus (HackerRank)
- **Location**: `src/main/java/com/example/hackerrank/PlusMinus.java`
- **Description**: Calculate ratios of positive, negative, and zero elements in an array
- **Multiple Approaches**: 7 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Simple Counting**: O(n) time, O(1) space - *Basic counting approach (recommended)*
- ⚡ **Stream-based Approach**: O(n) time, O(1) space - *Java streams for functional style*
- 🔧 **Enhanced Counting**: O(n) time, O(1) space - *With input validation and edge cases*
- 📚 **Functional Programming**: O(n) time, O(1) space - *IntStream-based approach*
- 🎯 **Array-based Approach**: O(n) time, O(1) space - *Array storage for counts*
- 🔄 **Math Operations**: O(n) time, O(1) space - *Using Integer.signum()*
- 💡 **Bit Manipulation**: O(n) time, O(1) space - *Sign bit checking*

**Examples**:
```java
Input: arr = [-4, 3, -9, 0, 4, 1]
Output: 
0.500000  // positive ratio (3/6)
0.333333  // negative ratio (2/6)  
0.166667  // zero ratio (1/6)

Input: arr = [1, 2, 3, -1, -2, -3, 0, 0]
Output:
0.375000  // positive ratio (3/8)
0.375000  // negative ratio (3/8)
0.250000  // zero ratio (2/8)
```

**Special Features**:
- 🎯 **Ratio Calculation**: Precise decimal formatting with 6 decimal places
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Null arrays, empty arrays, boundary values
- 📈 **Constraint Handling**: Handles 1 ≤ n ≤ 100, -100 ≤ arr[i] ≤ 100
- 🔧 **Algorithm-Specific Optimizations**: Streams, functional programming, bit manipulation
- 🌟 **Educational Value**: Demonstrates counting, streams, and mathematical operations
- 💡 **Key Insight**: Simple counting with precise decimal formatting
- 🛠️ **Utility Methods**: Ratio calculation, input validation, element counting
- 🎲 **Advanced Features**: Stream processing, functional programming, bit manipulation

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

### 39. Merge and Sort Intervals (HackerRank)
- **Location**: `src/main/java/com/example/hackerrank/MergeAndSortIntervals.java`
- **Description**: Merge all overlapping intervals and return a list of non-overlapping intervals sorted by start time
- **Multiple Approaches**: 5 different algorithms with comprehensive analysis

**Algorithms implemented**:
- 🏆 **Sort and Merge**: O(n log n) time, O(1) space - *Optimal solution (recommended)*
- ⚡ **Priority Queue**: O(n log n) time, O(n) space - *Alternative sorting approach*
- 🔧 **In-Place Merging**: O(n log n) time, O(1) space - *Space-optimized approach*
- 📚 **Two-Pointer Technique**: O(n log n) time, O(1) space - *Efficient consecutive interval merging*
- 🎯 **Recursive Merge**: O(n log n) time, O(log n) space - *Divide-and-conquer approach*

**Examples**:
```java
Input: [[1,3],[2,6],[8,10],[15,18]] -> Output: [[1,6],[8,10],[15,18]]
Input: [[1,4],[4,5]] -> Output: [[1,5]]
Input: [[1,4],[2,3]] -> Output: [[1,4]]
Input: [[1,2],[3,4],[5,6]] -> Output: [[1,2],[3,4],[5,6]]
Input: [[1,3],[2,6],[8,10],[15,18],[16,20]] -> Output: [[1,6],[8,10],[15,20]]
```

**Special Features**:
- 🎯 **Interval Merging**: Demonstrates classic interval merging algorithms and sorting techniques
- 📊 **Cross-Validation**: All approaches produce identical results
- ⚡ **Performance Analysis**: Live timing comparison between approaches
- 🧪 **Edge Case Testing**: Empty arrays, single intervals, maximum constraints, negative values
- 📈 **Constraint Handling**: Handles HackerRank constraints (1 ≤ n ≤ 10⁴, 0 ≤ start ≤ end ≤ 10⁴)
- 🔧 **Algorithm-Specific Optimizations**: In-place merging, priority queues, two-pointer technique
- 🌟 **Educational Value**: Demonstrates sorting, merging, and interval manipulation techniques
- 💡 **Key Insight**: Sort by start time, then merge overlapping intervals by comparing end times
- 🛠️ **Utility Methods**: Overlap detection, interval validation, total length calculation, max overlap analysis

**Testing**: Comprehensive test cases with performance benchmarking and cross-validation!

## Key Features

- ✅ **Java 21** with Gradle 8.14.3 Kotlin DSL
- ✅ **JUnit 5** testing framework with parameterized tests
- ✅ **2000+ comprehensive test cases** across all solutions
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
./gradlew test --tests "*FindFirstOccurrenceInString*"
./gradlew test --tests "*AddBinary*"
./gradlew test --tests "*PlusOne*"
./gradlew test --tests "*SqrtX*"
./gradlew test --tests "*ClimbingStairs*"
./gradlew test --tests "*MergeSortedArray*"
./gradlew test --tests "*ConvertSortedArrayToBST*"
./gradlew test --tests "*MaximumDepthOfBinaryTree*"
./gradlew test --tests "*BalancedBinaryTree*"
./gradlew test --tests "*SingleNumber*"
./gradlew test --tests "*MinimumDepthOfBinaryTree*"
./gradlew test --tests "*PascalsTriangleII*"
./gradlew test --tests "*BestTimeToBuyAndSellStock*"
./gradlew test --tests "*PrintInOrder*"
./gradlew test --tests "*FindMostFrequentVowelAndConsonant*"
./gradlew test --tests "*LinkedListCycle*"
./gradlew test --tests "*PrintFooBarAlternately*"
./gradlew test --tests "*CustomersWhoNeverOrder*"
./gradlew test --tests "*ValidPalindrome*"
./gradlew test --tests "*CountCompleteTreeNodes*"
./gradlew test --tests "*CountingBits*"
./gradlew test --tests "*IntersectionOfTwoLinkedLists*"
./gradlew test --tests "*ExcelSheetColumnTitle*"
./gradlew test --tests "*CountAndSay*"
./gradlew test --tests "*MajorityElement*"
./gradlew test --tests "*ReverseBits*"
./gradlew test --tests "*HappyNumber*"
./gradlew test --tests "*PlusMinus*"
./gradlew test --tests "*MergeAndSortIntervals*"
./gradlew test --tests "*BigOComplexity*"
```

### Useful Commands
```bash
./gradlew clean              # Clean build artifacts
./gradlew compileJava        # Compile source code
./gradlew test               # Run all 2000+ tests
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
| Find First Occurrence | Easy | O(n+m) time, O(m) space | 5 approaches | Comprehensive |
| Add Binary | Easy | O(n) time, O(n) space | 6 approaches | Comprehensive |
| Plus One | Easy | O(n) time, O(1) space | 6 approaches | Comprehensive |
| Sqrt(x) | Easy | O(log x) time, O(1) space | 6 approaches | Comprehensive |
| Climbing Stairs | Easy | O(n) time, O(1) space | 6 approaches | Comprehensive |
| Merge Sorted Array | Easy | O(m + n) time, O(1) space | 6 approaches | Comprehensive |
| Convert Sorted Array to BST | Easy | O(n) time, O(log n) space | 6 approaches | Comprehensive |
| Maximum Depth of Binary Tree | Easy | O(n) time, O(h) space | 6 approaches | Comprehensive |
| Balanced Binary Tree | Easy | O(n) time, O(h) space | 4 approaches | Comprehensive |
| Single Number | Easy | O(n) time, O(1) space | 5 approaches | Comprehensive |
| Minimum Depth of Binary Tree | Easy | O(n) time, O(h) space | 6 approaches | Comprehensive |
| Pascal's Triangle II | Easy | O(k) time, O(k) space | 6 approaches | Comprehensive |
| Best Time to Buy and Sell Stock | Easy | O(n) time, O(1) space | 6 approaches | Comprehensive |
| Print in Order | Easy | O(1) time, O(1) space | 6 approaches | Comprehensive |
| Find Most Frequent Vowel and Consonant | Easy | O(n) time, O(1) space | 4 approaches | Comprehensive |
| Linked List Cycle | Easy | O(n) time, O(1) space | 4 approaches | Comprehensive |
| Print FooBar Alternately | Medium | O(n) time, O(1) space | 5 approaches | Comprehensive |
| Customers Who Never Order | Easy | O(n + m) time, O(m) space | 6 approaches | Comprehensive |
| Valid Palindrome | Easy | O(n) time, O(1) space | 7 approaches | Comprehensive |
| Count Complete Tree Nodes | Medium | O(log²n) time, O(logn) space | 8 approaches | Comprehensive |
| Counting Bits | Easy | O(n) time, O(n) space | 6 approaches | Comprehensive |
| Intersection of Two Linked Lists | Easy | O(m + n) time, O(1) space | 6 approaches | Comprehensive |
| Excel Sheet Column Title | Easy | O(log₂₆(n)) time, O(log₂₆(n)) space | 5 approaches | Comprehensive |
| Count and Say | Medium | O(n * m) time, O(m) space | 5 approaches | Comprehensive |
| Majority Element | Easy | O(n) time, O(1) space | 7 approaches | Comprehensive |
| Reverse Bits | Easy | O(1) time, O(1) space | 7 approaches | Comprehensive |
| Happy Number | Easy | O(log n) time, O(1) space | 7 approaches | Comprehensive |
| Plus Minus | Easy | O(n) time, O(1) space | 7 approaches | Comprehensive |
| Merge and Sort Intervals | Medium | O(n log n) time, O(1) space | 5 approaches | Comprehensive |
| Big O Examples | Educational | All complexities | 8 complexity classes | Demonstrations |

**Total**: 40 algorithm problems + Algorithm analysis = **2000+ test cases** and **212 different algorithmic approaches**!

Happy coding! 🚀 Ready for your next technical interview! 💪
