package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the App class
 */
public class AppTest {
    
    @Test
    @DisplayName("Test basic functionality")
    public void testAppExists() {
        // This is a simple test to verify the class exists
        App app = new App();
        assertNotNull(app);
    }
    
    @Test
    @DisplayName("Test main method runs without errors")
    public void testMainMethod() {
        // Test that main method can be called without throwing exceptions
        assertDoesNotThrow(() -> {
            App.main(new String[]{});
        });
    }
} 