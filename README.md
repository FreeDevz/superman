# Superman Java Project

This project demonstrates Java development in Cursor IDE with Gradle, including LeetCode algorithm solutions.

## Project Structure

```
src/
├── main/java/com/example/
│   ├── App.java                           # Main application class
│   └── leetcode/
│       └── AddTwoNumbers.java             # LeetCode: Add Two Numbers solution
└── test/java/com/example/
    ├── AppTest.java                       # Unit tests
    └── leetcode/
        └── AddTwoNumbersTest.java         # LeetCode solution tests
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

## Key Features

- ✅ **Java 17** with Gradle Kotlin DSL
- ✅ **JUnit 5** testing framework
- ✅ **Comprehensive test coverage**
- ✅ **LeetCode algorithm solutions**
- ✅ **VS Code/Cursor IDE integration**
- ✅ **Gradle wrapper** for consistent builds

## Development

### Prerequisites
- Java 17 or later
- Gradle (wrapper included)
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
