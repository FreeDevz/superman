package com.example.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Comprehensive test suite for Plus Minus problem Tests all seven different approaches with various
 * test cases
 */
@DisplayName("Plus Minus Tests")
class PlusMinusTest {

    private PlusMinus solution;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        solution = new PlusMinus();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Nested
    @DisplayName("Simple Counting Approach Tests")
    class SimpleCountingApproachTests {

        @Test
        @DisplayName("Basic test case from HackerRank")
        void testBasicCase() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.166667", lines[2]);
        }

        @Test
        @DisplayName("All positive numbers")
        void testAllPositive() {
            int[] arr = {1, 2, 3, 4, 5};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("1.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }

        @Test
        @DisplayName("All negative numbers")
        void testAllNegative() {
            int[] arr = {-1, -2, -3, -4, -5};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.000000", lines[0]);
            assertEquals("1.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }

        @Test
        @DisplayName("All zeros")
        void testAllZeros() {
            int[] arr = {0, 0, 0, 0, 0};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("1.000000", lines[2]);
        }

        @Test
        @DisplayName("Single element")
        void testSingleElement() {
            int[] arr = {5};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("1.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }

        @Test
        @DisplayName("Mixed positive and negative")
        void testMixedPositiveNegative() {
            int[] arr = {1, -1, 2, -2, 3, -3};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.500000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }
    }

    @Nested
    @DisplayName("Stream-based Approach Tests")
    class StreamBasedApproachTests {

        @Test
        @DisplayName("Stream approach basic test")
        void testStreamBasic() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            solution.plusMinusStream(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.166667", lines[2]);
        }

        @Test
        @DisplayName("Stream approach with all positive")
        void testStreamAllPositive() {
            int[] arr = {1, 2, 3};
            solution.plusMinusStream(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("1.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }
    }

    @Nested
    @DisplayName("Enhanced Counting Tests")
    class EnhancedCountingTests {

        @Test
        @DisplayName("Enhanced counting basic test")
        void testEnhancedBasic() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            solution.plusMinusEnhanced(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.166667", lines[2]);
        }

        @Test
        @DisplayName("Enhanced counting with null input")
        void testEnhancedNullInput() {
            solution.plusMinusEnhanced(null);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }

        @Test
        @DisplayName("Enhanced counting with empty array")
        void testEnhancedEmptyArray() {
            solution.plusMinusEnhanced(new int[0]);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }
    }

    @Nested
    @DisplayName("Functional Programming Tests")
    class FunctionalProgrammingTests {

        @Test
        @DisplayName("Functional programming basic test")
        void testFunctionalBasic() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            solution.plusMinusFunctional(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.166667", lines[2]);
        }

        @Test
        @DisplayName("Functional programming with mixed values")
        void testFunctionalMixed() {
            int[] arr = {1, 2, 3, -1, -2, -3, 0, 0};
            solution.plusMinusFunctional(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.375000", lines[0]);
            assertEquals("0.375000", lines[1]);
            assertEquals("0.250000", lines[2]);
        }
    }

    @Nested
    @DisplayName("Array-based Approach Tests")
    class ArrayBasedApproachTests {

        @Test
        @DisplayName("Array-based basic test")
        void testArrayBasedBasic() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            solution.plusMinusArray(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.166667", lines[2]);
        }

        @Test
        @DisplayName("Array-based with all zeros")
        void testArrayBasedAllZeros() {
            int[] arr = {0, 0, 0};
            solution.plusMinusArray(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("1.000000", lines[2]);
        }
    }

    @Nested
    @DisplayName("Math Operations Tests")
    class MathOperationsTests {

        @Test
        @DisplayName("Math operations basic test")
        void testMathBasic() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            solution.plusMinusMath(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.166667", lines[2]);
        }

        @Test
        @DisplayName("Math operations with edge values")
        void testMathEdgeValues() {
            int[] arr = {100, -100, 0};
            solution.plusMinusMath(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.333333", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.333333", lines[2]);
        }
    }

    @Nested
    @DisplayName("Bit Manipulation Tests")
    class BitManipulationTests {

        @Test
        @DisplayName("Bit manipulation basic test")
        void testBitManipulationBasic() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            solution.plusMinusBitManipulation(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.166667", lines[2]);
        }

        @Test
        @DisplayName("Bit manipulation with negative numbers")
        void testBitManipulationNegative() {
            int[] arr = {-1, -2, -3};
            solution.plusMinusBitManipulation(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.000000", lines[0]);
            assertEquals("1.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same results")
        void testAllApproachesProduceSameResults() {
            int[] testCases = {-4, 3, -9, 0, 4, 1};
            int[] arr = testCases;

            // Capture output from each approach
            String[] outputs = new String[7];
            String[] approachNames = {"Simple", "Stream", "Enhanced", "Functional", "Array", "Math",
                    "BitManipulation"};

            // Test each approach
            solution.plusMinus(arr);
            outputs[0] = outputStream.toString();
            outputStream.reset();

            solution.plusMinusStream(arr);
            outputs[1] = outputStream.toString();
            outputStream.reset();

            solution.plusMinusEnhanced(arr);
            outputs[2] = outputStream.toString();
            outputStream.reset();

            solution.plusMinusFunctional(arr);
            outputs[3] = outputStream.toString();
            outputStream.reset();

            solution.plusMinusArray(arr);
            outputs[4] = outputStream.toString();
            outputStream.reset();

            solution.plusMinusMath(arr);
            outputs[5] = outputStream.toString();
            outputStream.reset();

            solution.plusMinusBitManipulation(arr);
            outputs[6] = outputStream.toString();
            outputStream.reset();

            // All outputs should be identical
            for (int i = 1; i < outputs.length; i++) {
                assertEquals(outputs[0], outputs[i],
                        "Approach " + approachNames[i] + " differs from " + approachNames[0]);
            }
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Minimum array size")
        void testMinimumArraySize() {
            int[] arr = {1};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("1.000000", lines[0]);
            assertEquals("0.000000", lines[1]);
            assertEquals("0.000000", lines[2]);
        }

        @Test
        @DisplayName("Maximum array size")
        void testMaximumArraySize() {
            int[] arr = new int[100];
            for (int i = 0; i < 50; i++) {
                arr[i] = 1; // positive
            }
            for (int i = 50; i < 75; i++) {
                arr[i] = -1; // negative
            }
            for (int i = 75; i < 100; i++) {
                arr[i] = 0; // zero
            }

            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.500000", lines[0]);
            assertEquals("0.250000", lines[1]);
            assertEquals("0.250000", lines[2]);
        }

        @Test
        @DisplayName("Boundary values")
        void testBoundaryValues() {
            int[] arr = {100, -100, 0};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.333333", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.333333", lines[2]);
        }

        @Test
        @DisplayName("Equal distribution")
        void testEqualDistribution() {
            int[] arr = {1, -1, 0, 2, -2, 0};
            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals("0.333333", lines[0]);
            assertEquals("0.333333", lines[1]);
            assertEquals("0.333333", lines[2]);
        }
    }

    @Nested
    @DisplayName("Utility Method Tests")
    class UtilityMethodTests {

        @Test
        @DisplayName("Test getRatios method")
        void testGetRatios() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            double[] ratios = solution.getRatios(arr);

            assertEquals(3, ratios.length);
            assertEquals(0.5, ratios[0], 1e-6); // positive ratio
            assertEquals(1.0 / 3.0, ratios[1], 1e-6); // negative ratio
            assertEquals(1.0 / 6.0, ratios[2], 1e-6); // zero ratio
        }

        @Test
        @DisplayName("Test getRatios with null input")
        void testGetRatiosNullInput() {
            double[] ratios = solution.getRatios(null);

            assertEquals(3, ratios.length);
            assertEquals(0.0, ratios[0], 1e-6);
            assertEquals(0.0, ratios[1], 1e-6);
            assertEquals(0.0, ratios[2], 1e-6);
        }

        @Test
        @DisplayName("Test getRatios with empty array")
        void testGetRatiosEmptyArray() {
            double[] ratios = solution.getRatios(new int[0]);

            assertEquals(3, ratios.length);
            assertEquals(0.0, ratios[0], 1e-6);
            assertEquals(0.0, ratios[1], 1e-6);
            assertEquals(0.0, ratios[2], 1e-6);
        }

        @Test
        @DisplayName("Test isValidInput method")
        void testIsValidInput() {
            // Valid inputs
            assertTrue(solution.isValidInput(new int[] {1, 2, 3}));
            assertTrue(solution.isValidInput(new int[] {-100, 100, 0}));
            assertTrue(solution.isValidInput(new int[] {1}));

            // Invalid inputs
            assertFalse(solution.isValidInput(null));
            assertFalse(solution.isValidInput(new int[0]));
            assertFalse(solution.isValidInput(new int[101])); // too large
            assertFalse(solution.isValidInput(new int[] {101})); // value too large
            assertFalse(solution.isValidInput(new int[] {-101})); // value too small
        }

        @Test
        @DisplayName("Test countElements method")
        void testCountElements() {
            int[] arr = {-4, 3, -9, 0, 4, 1};
            int[] counts = solution.countElements(arr);

            assertEquals(3, counts.length);
            assertEquals(3, counts[0]); // positive count
            assertEquals(2, counts[1]); // negative count
            assertEquals(1, counts[2]); // zero count
        }

        @Test
        @DisplayName("Test formatRatio method")
        void testFormatRatio() {
            assertEquals("0.500000", solution.formatRatio(0.5));
            assertEquals("0.333333", solution.formatRatio(1.0 / 3.0));
            assertEquals("0.166667", solution.formatRatio(1.0 / 6.0));
            assertEquals("1.000000", solution.formatRatio(1.0));
            assertEquals("0.000000", solution.formatRatio(0.0));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison for various inputs")
        void testPerformanceComparison() {
            int[][] testCases = {{-4, 3, -9, 0, 4, 1}, {1, 2, 3, -1, -2, -3, 0, 0},
                    {1, 1, 0, -1, -1}, {0, 0, 0}, {1, 2, 3}, {-1, -2, -3}, {0}};

            for (int[] arr : testCases) {
                long startTime, endTime;

                // Test simple counting approach
                startTime = System.nanoTime();
                solution.plusMinus(arr);
                endTime = System.nanoTime();
                long simpleTime = endTime - startTime;
                outputStream.reset();

                // Test stream approach
                startTime = System.nanoTime();
                solution.plusMinusStream(arr);
                endTime = System.nanoTime();
                long streamTime = endTime - startTime;
                outputStream.reset();

                // Test enhanced approach
                startTime = System.nanoTime();
                solution.plusMinusEnhanced(arr);
                endTime = System.nanoTime();
                long enhancedTime = endTime - startTime;
                outputStream.reset();

                // Test functional approach
                startTime = System.nanoTime();
                solution.plusMinusFunctional(arr);
                endTime = System.nanoTime();
                long functionalTime = endTime - startTime;
                outputStream.reset();

                // Test array approach
                startTime = System.nanoTime();
                solution.plusMinusArray(arr);
                endTime = System.nanoTime();
                long arrayTime = endTime - startTime;
                outputStream.reset();

                // Test math approach
                startTime = System.nanoTime();
                solution.plusMinusMath(arr);
                endTime = System.nanoTime();
                long mathTime = endTime - startTime;
                outputStream.reset();

                // Test bit manipulation approach
                startTime = System.nanoTime();
                solution.plusMinusBitManipulation(arr);
                endTime = System.nanoTime();
                long bitManipulationTime = endTime - startTime;
                outputStream.reset();

                System.out.printf(
                        "Input size: %d, Simple: %dns, Stream: %dns, Enhanced: %dns, Functional: %dns, Array: %dns, Math: %dns, BitManip: %dns%n",
                        arr.length, simpleTime, streamTime, enhancedTime, functionalTime, arrayTime,
                        mathTime, bitManipulationTime);
            }
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @CsvSource({"'1,2,3', '1.000000,0.000000,0.000000'",
                "'-1,-2,-3', '0.000000,1.000000,0.000000'", "'0,0,0', '0.000000,0.000000,1.000000'",
                "'1,-1,0', '0.333333,0.333333,0.333333'"})
        @DisplayName("Parameterized test for various inputs")
        void testParameterized(String input, String expected) {
            int[] arr = java.util.Arrays.stream(input.split(",")).map(String::trim)
                    .mapToInt(Integer::parseInt).toArray();
            String[] expectedRatios = expected.split(",");

            solution.plusMinus(arr);

            String output = outputStream.toString().trim();
            String[] lines = output.split("\n");
            assertEquals(3, lines.length);
            assertEquals(expectedRatios[0], lines[0]);
            assertEquals(expectedRatios[1], lines[1]);
            assertEquals(expectedRatios[2], lines[2]);
        }
    }
}
