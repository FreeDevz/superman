# Java Development in Cursor

This project demonstrates how to set up and develop Java applications using Cursor IDE with Gradle.

## Prerequisites

- **Java 17** or later installed
- **Gradle** for build management (wrapper included)
- **Cursor IDE** with Java extensions

## Project Structure

```
src/
├── main/java/com/example/
│   └── App.java                 # Main application class
└── test/java/com/example/
    └── AppTest.java            # Unit tests
build.gradle                    # Gradle build configuration
settings.gradle.kts            # Gradle settings
gradle/wrapper/                # Gradle wrapper files
gradlew                        # Gradle wrapper script (Unix/macOS)
gradlew.bat                    # Gradle wrapper script (Windows)
build.sh                       # Easy build script
.vscode/
├── settings.json               # Cursor/VS Code settings
└── launch.json                 # Debug configurations
```

## Getting Started

### 1. Install Java Extensions in Cursor

1. Open Cursor
2. Go to Extensions (⌘+Shift+X)
3. Search and install:
   - **Extension Pack for Java** (Microsoft)
   - **IntelliCode** (Microsoft)

### 2. Running the Application

**Option 1: Using the Build Script (Easiest)**
```bash
./build.sh
```

**Option 2: Using Gradle Wrapper**
```bash
./gradlew run
```

**Option 3: Using Cursor's Debug Panel**
1. Open the Debug panel (⌘+Shift+D)
2. Select "Launch App" or "Gradle: Run App" configuration
3. Click the green play button

**Option 4: Using System Gradle (if installed)**
```bash
gradle run
```

### 3. Running Tests

```bash
./gradlew test
```

### 4. Building the Project

```bash
./gradlew build
```

## Cursor Java Development Tips

### Shortcuts & Features

- **⌘+Shift+P**: Command palette
- **F5**: Start debugging
- **⌘+.**: Quick fix (shows available actions)
- **⌘+Space**: IntelliSense/autocomplete
- **Shift+⌘+O**: Go to symbol
- **⌘+T**: Go to file

### Code Generation

- Type `main` + Tab: Generate main method
- Type `sysout` + Tab: Generate System.out.println()
- Type `for` + Tab: Generate for loop
- Type `if` + Tab: Generate if statement

### Refactoring

- **Right-click** → Refactor: Access refactoring options
- **F2**: Rename symbol
- **⌘+Shift+R**: Refactor menu

### Debugging

1. Set breakpoints by clicking in the gutter
2. Use F5 to start debugging
3. Use F10 (step over), F11 (step into), Shift+F11 (step out)
4. View variables in the Debug panel

## Useful Extensions

- **Extension Pack for Java**: Core Java support
- **Spring Boot Extension Pack**: For Spring development  
- **Lombok Annotations Support**: For Lombok projects
- **SonarLint**: Code quality analysis
- **GitLens**: Enhanced Git capabilities

## Gradle Commands

```bash
./gradlew clean              # Clean build artifacts
./gradlew compileJava        # Compile source code
./gradlew test               # Run tests
./gradlew build              # Build the entire project
./gradlew run                # Run the main class
./gradlew jar                # Create JAR file
./gradlew dependencies       # Show dependency tree
```

Happy coding! 🚀 