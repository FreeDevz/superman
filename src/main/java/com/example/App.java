package com.example;

/**
 * Hello World application
 * This is a basic Java program to demonstrate Cursor setup
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Java in Cursor!");
        
        // Example of basic Java features
        String name = "Developer";
        int version = 21;
        
        System.out.printf("Welcome %s! You're using Java %d%n", name, version);
        
        // Example method call
        greetUser(name);
    }
    
    /**
     * Demonstrates method creation and documentation
     * @param name The name to greet
     */
    private static void greetUser(String name) {
        System.out.println("Nice to meet you, " + name + "!");
    }
} 