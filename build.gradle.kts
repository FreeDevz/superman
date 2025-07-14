plugins {
    id("java")
    id("application")
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5 for testing
    add("testImplementation", "org.junit.jupiter:junit-jupiter:5.10.0")
    add("testRuntimeOnly", "org.junit.platform:junit-platform-launcher")
}

configure<JavaApplication> {
    mainClass.set("com.example.App")
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.named<JavaCompile>("compileJava") {
    options.encoding = "UTF-8"
}

tasks.named<JavaCompile>("compileTestJava") {
    options.encoding = "UTF-8"
}

// Custom task to run the application easily
tasks.register("runApp") {
    group = "application"
    description = "Runs the main application"
    dependsOn("run")
} 