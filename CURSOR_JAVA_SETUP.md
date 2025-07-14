# Complete Guide: Java Development in Cursor IDE

## 🎯 Quick Start

Your Java environment is now set up! Here's what you can do immediately:

```bash
# Compile and run your Java app (easiest)
./build.sh

# Or using Gradle wrapper:
./gradlew run

# Or manually:
javac -d build/classes src/main/java/com/example/App.java
java -cp build/classes com.example.App
```

## 📋 Prerequisites

✅ **Java 17** (installed and working)  
✅ **Gradle** (wrapper included in project)  
✅ **Cursor IDE**

## 🛠️ Essential Cursor Extensions for Java

**Must-have extensions:**

1. **Extension Pack for Java** (Microsoft)
   - Includes Language Server, Debugger, Test Runner, Maven support
   - Install: `⌘+Shift+X` → Search "Extension Pack for Java"

2. **IntelliCode** (Microsoft) 
   - AI-powered code completion
   - Install: `⌘+Shift+X` → Search "IntelliCode"

**Recommended additional extensions:**
- **Spring Boot Extension Pack** (for Spring development)
- **SonarLint** (code quality)
- **GitLens** (enhanced Git integration)
- **Bracket Pair Colorizer** (easier bracket matching)

## 🚀 Development Workflow

### Option 1: Using the Build Script (Easiest)
```bash
./build.sh    # Compiles and runs your app
```

### Option 2: Using Cursor's Built-in Tools

1. **Open Command Palette**: `⌘+Shift+P`
2. **Type**: "Java: Run Java"
3. **Select your main class**: `com.example.App`

### Option 3: Debug Mode

1. **Set breakpoints**: Click in the gutter next to line numbers
2. **Open Debug Panel**: `⌘+Shift+D`
3. **Select configuration**: "Launch App" or "Debug App"
4. **Click the green play button**

## ⚡ Cursor Java Shortcuts & Features

### Essential Shortcuts
| Shortcut | Action |
|----------|--------|
| `⌘+Shift+P` | Command palette |
| `⌘+.` | Quick fix / show available actions |
| `⌘+Space` | IntelliSense/autocomplete |
| `F5` | Start debugging |
| `F9` | Toggle breakpoint |
| `F10` | Step over (debugging) |
| `F11` | Step into (debugging) |
| `Shift+F11` | Step out (debugging) |
| `⌘+Shift+O` | Go to symbol in file |
| `⌘+T` | Go to file |
| `F2` | Rename symbol |
| `⌘+Shift+F` | Search across files |

### Code Generation Magic ✨
Type these snippets and press **Tab**:

- `main` → `public static void main(String[] args)`
- `sysout` → `System.out.println()`
- `for` → for loop template
- `fori` → for loop with index
- `foreach` → enhanced for loop
- `if` → if statement
- `try` → try-catch block
- `/**` → JavaDoc comment template

### Smart Refactoring
- **Right-click any symbol** → "Refactor" menu
- **Extract Method**: Select code → `⌘+Shift+R` → "Extract Method"
- **Rename**: `F2` on any variable/method/class
- **Organize Imports**: `⌘+Shift+O`

## 🎨 Customizing Your Java Environment

Your project includes these pre-configured settings in `.vscode/settings.json`:

- **Auto-format on save** (Google Java Style)
- **Automatic import organization**
- **Null analysis**
- **Hidden build artifacts** (target/, .classpath, etc.)

## 🛠️ Gradle Integration

### Using the Included Gradle Wrapper (Recommended)
The project includes a Gradle wrapper, so you don't need to install Gradle separately:

```bash
./gradlew build               # Build the project
./gradlew run                 # Run the application
./gradlew test                # Run tests
./gradlew jar                 # Create JAR file
```

### Installing Gradle Globally (Optional)
If you want to install Gradle system-wide:

#### macOS (using Homebrew):
```bash
# Install Gradle
brew install gradle

# Verify installation
gradle --version
```

#### Alternative: Download directly
1. Go to https://gradle.org/releases/
2. Download the binary distribution
3. Extract and add to your PATH

### Once Gradle is installed globally:
```bash
gradle build                 # Build the project
gradle run                   # Run the application
gradle test                  # Run tests
```

## 🧪 Testing Your Setup

Try these to verify everything works:

1. **Basic compilation**:
   ```bash
   ./build.sh
   ```

2. **Cursor IntelliSense**: 
   - Open `src/main/java/com/example/App.java`
   - Type `System.` and you should see autocomplete suggestions

3. **Debugging**:
   - Set a breakpoint on line 8 in `App.java`
   - Press `F5` to start debugging
   - The execution should pause at your breakpoint

4. **Quick fixes**:
   - Add a typo like `Systm.out.println("test");`
   - You should see a red squiggle
   - Press `⌘+.` to see quick fix suggestions

## 🎯 Project Structure Best Practices

```
src/
├── main/
│   ├── java/           # Your application code
│   └── resources/      # Configuration files, assets
└── test/
    ├── java/           # Unit tests
    └── resources/      # Test resources

target/                 # Compiled classes (auto-generated)
.vscode/               # Cursor/VS Code settings
pom.xml                # Maven configuration
build.sh               # Custom build script
```

## 🚨 Common Issues & Solutions

### "Cannot resolve symbol" errors
- **Solution**: Install "Extension Pack for Java"
- **Alternative**: Reload window (`⌘+Shift+P` → "Developer: Reload Window")

### Package errors
- **Ensure**: File is in correct directory structure (`src/main/java/com/example/`)
- **Check**: Package declaration matches folder structure

### Compilation fails
- **Verify**: Java is installed (`java --version`)
- **Check**: All import statements are correct
- **Try**: Clean and rebuild (`rm -rf target/`)

### IntelliSense not working
- **Install**: Extension Pack for Java
- **Wait**: Allow indexing to complete (check bottom status bar)
- **Reload**: `⌘+Shift+P` → "Java: Clean Workspace"

## 🎉 You're Ready!

Your Java development environment in Cursor is now fully set up! You can:

- ✅ Write Java code with full IntelliSense
- ✅ Debug with breakpoints
- ✅ Run and compile easily
- ✅ Use advanced refactoring tools
- ✅ Leverage AI-powered code completion

**Next steps:**
1. Try modifying the sample `App.java` file
2. Create new Java classes
3. Experiment with debugging
4. Install additional extensions as needed

Happy coding! 🚀☕ 