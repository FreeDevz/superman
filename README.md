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
│       ├── LongestPalindromicSubstring.java        # LeetCode #5: Longest Palindromic Substring
│       ├── ZigZagConversion.java          # LeetCode #6: ZigZag Conversion
│       └── IntegerToRoman.java            # LeetCode #12: Integer to Roman
└── test/java/com/example/
    ├── AppTest.java                       # Main application tests
    └── leetcode/
        ├── AddTwoNumbersTest.java         # LeetCode #2 tests
        ├── LongestSubstringWithoutRepeatingTest.java  # LeetCode #3 tests
        ├── LongestPalindromicSubstringTest.java       # LeetCode #5 tests (72 test cases!)
        ├── ZigZagConversionTest.java      # LeetCode #6 tests (114+ test cases!)
        └── IntegerToRomanTest.java        # LeetCode #12 tests (278 test cases!)
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

This project features **5 complete LeetCode solutions** with multiple algorithmic approaches and comprehensive testing:

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

## Key Features

- ✅ **Java 21** with Gradle 8.14.3 Kotlin DSL
- ✅ **JUnit 5** testing framework with parameterized tests
- ✅ **550+ comprehensive test cases** across all solutions
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
./gradlew test --tests "*BigOComplexity*"
```

### Useful Commands
```bash
./gradlew clean              # Clean build artifacts
./gradlew compileJava        # Compile source code
./gradlew test               # Run all 550+ tests
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
| Longest Palindrome | Medium | O(n) time, O(n) space | 4 approaches | 72 tests |
| ZigZag Conversion | Medium | O(n) time, O(1) space | 4 approaches | 114+ tests |
| Integer to Roman | Medium | O(1) time, O(1) space | 4 approaches | 278 tests |
| Big O Examples | Educational | All complexities | 8 complexity classes | Demonstrations |

**Total**: 5 LeetCode problems + Algorithm analysis = **550+ test cases** and **16 different algorithmic approaches**!

Happy coding! 🚀 Ready for your next technical interview! 💪
