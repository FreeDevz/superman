# Superman Java Project

This project demonstrates Java development in Cursor IDE with Gradle, including LeetCode algorithm solutions.

## Project Structure

```
src/
├── main/java/com/example/
│   ├── App.java                           # Main application class
│   └── leetcode/
│       ├── AddTwoNumbers.java             # LeetCode: Add Two Numbers solution
│       └── LongestSubstringWithoutRepeating.java  # LeetCode: Longest Substring solution
└── test/java/com/example/
    ├── AppTest.java                       # Unit tests
    └── leetcode/
        ├── AddTwoNumbersTest.java         # LeetCode: Add Two Numbers tests
        └── LongestSubstringWithoutRepeatingTest.java  # LeetCode: Longest Substring tests
build.gradle                              # Gradle build configuration
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

### Run Tests
```bash
./gradlew test
```

### Build Project
```bash
./gradlew build
```

## LeetCode Solutions

The project includes solutions to popular LeetCode problems:

### 1. Add Two Numbers (Problem #2)
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

**Run specific solution**:
```bash
java -cp build/classes/java/main com.example.leetcode.AddTwoNumbers
```

### 2. Longest Substring Without Repeating Characters (Problem #3)
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

**Multiple implementations included**:
- ✅ **HashMap approach** (most efficient)
- ✅ **HashSet approach** (alternative sliding window)
- ✅ **Brute force approach** (for comparison)

**Run specific solution**:
```bash
java -cp build/classes/java/main com.example.leetcode.LongestSubstringWithoutRepeating
```

## Key Features

- ✅ **Java 21** with Gradle 8.14.3 Kotlin DSL
- ✅ **JUnit 5** testing framework
- ✅ **Comprehensive test coverage**
- ✅ **LeetCode algorithm solutions**
- ✅ **VS Code/Cursor IDE integration**
- ✅ **Gradle wrapper** for consistent builds

## Development

### Prerequisites
- Java 21 or later (currently using Java 21.0.6)
- Gradle 8.14.3 (wrapper included)
- Cursor IDE with Java extensions

### Useful Commands
```bash
./gradlew clean              # Clean build artifacts
./gradlew compileJava        # Compile source code
./gradlew test               # Run tests
./gradlew build              # Build the entire project
./gradlew run                # Run the main class
```

Happy coding! 🚀
