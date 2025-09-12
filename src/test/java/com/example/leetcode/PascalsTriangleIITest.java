package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for PascalsTriangleII LeetCode problem
 * 
 * Tests all six different approaches: 1. Iterative In-Place (Optimal) 2. Mathematical Formula 3.
 * Recursive Approach 4. Two Arrays 5. Combinatorial Formula with Memoization 6. Dynamic Programming
 */
@DisplayName("Pascal's Triangle II Tests")
class PascalsTriangleIITest {

    private PascalsTriangleII solution;

    @BeforeEach
    void setUp() {
        solution = new PascalsTriangleII();
    }

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Row index 0")
        void testRowIndex0() {
            int rowIndex = 0;
            List<Integer> expected = Arrays.asList(1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("Row index 1")
        void testRowIndex1() {
            int rowIndex = 1;
            List<Integer> expected = Arrays.asList(1, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("Row index 2")
        void testRowIndex2() {
            int rowIndex = 2;
            List<Integer> expected = Arrays.asList(1, 2, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("Row index 3")
        void testRowIndex3() {
            int rowIndex = 3;
            List<Integer> expected = Arrays.asList(1, 3, 3, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("Row index 4")
        void testRowIndex4() {
            int rowIndex = 4;
            List<Integer> expected = Arrays.asList(1, 4, 6, 4, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("Row index 5")
        void testRowIndex5() {
            int rowIndex = 5;
            List<Integer> expected = Arrays.asList(1, 5, 10, 10, 5, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }
    }

    @Nested
    @DisplayName("LeetCode Example Tests")
    class LeetCodeExampleTests {

        @Test
        @DisplayName("LeetCode Example 1: rowIndex = 3")
        void testLeetCodeExample1() {
            int rowIndex = 3;
            List<Integer> expected = Arrays.asList(1, 3, 3, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("LeetCode Example 2: rowIndex = 0")
        void testLeetCodeExample2() {
            int rowIndex = 0;
            List<Integer> expected = Arrays.asList(1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("LeetCode Example 3: rowIndex = 1")
        void testLeetCodeExample3() {
            int rowIndex = 1;
            List<Integer> expected = Arrays.asList(1, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("Maximum constraint: rowIndex = 33")
        void testMaximumConstraint() {
            int rowIndex = 33;
            List<Integer> expected = Arrays.asList(1, 33, 528, 5456, 40920, 237336, 1107568,
                    4272048, 13884156, 38567100, 92561040, 193536720, 354817320, 573166440,
                    818809200, 1037158320, 1166803110, 1166803110, 1037158320, 818809200, 573166440,
                    354817320, 193536720, 92561040, 38567100, 13884156, 4272048, 1107568, 237336,
                    40920, 5456, 528, 33, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            // Skip recursive for large input as it's too slow
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("Medium size: rowIndex = 10")
        void testMediumSize() {
            int rowIndex = 10;
            List<Integer> expected = Arrays.asList(1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            assertEquals(expected, solution.getRowRecursive(rowIndex));
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }

        @Test
        @DisplayName("Large size: rowIndex = 20")
        void testLargeSize() {
            int rowIndex = 20;
            List<Integer> expected =
                    Arrays.asList(1, 20, 190, 1140, 4845, 15504, 38760, 77520, 125970, 167960,
                            184756, 167960, 125970, 77520, 38760, 15504, 4845, 1140, 190, 20, 1);

            assertEquals(expected, solution.getRowIterative(rowIndex));
            assertEquals(expected, solution.getRowMathematical(rowIndex));
            // Skip recursive for large input as it's too slow
            assertEquals(expected, solution.getRowTwoArrays(rowIndex));
            assertEquals(expected, solution.getRowCombinatorial(rowIndex));
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        @DisplayName("All approaches with small row indices")
        void testAllApproachesSmall(int rowIndex) {
            List<Integer> iterativeResult = solution.getRowIterative(rowIndex);
            List<Integer> mathematicalResult = solution.getRowMathematical(rowIndex);
            List<Integer> recursiveResult = solution.getRowRecursive(rowIndex);
            List<Integer> twoArraysResult = solution.getRowTwoArrays(rowIndex);
            List<Integer> combinatorialResult = solution.getRowCombinatorial(rowIndex);
            List<Integer> dynamicProgrammingResult = solution.getRowDynamicProgramming(rowIndex);

            assertEquals(iterativeResult, mathematicalResult,
                    "Mathematical failed for rowIndex: " + rowIndex);
            assertEquals(iterativeResult, recursiveResult,
                    "Recursive failed for rowIndex: " + rowIndex);
            assertEquals(iterativeResult, twoArraysResult,
                    "Two Arrays failed for rowIndex: " + rowIndex);
            assertEquals(iterativeResult, combinatorialResult,
                    "Combinatorial failed for rowIndex: " + rowIndex);
            assertEquals(iterativeResult, dynamicProgrammingResult,
                    "Dynamic Programming failed for rowIndex: " + rowIndex);
        }

        @ParameterizedTest
        @ValueSource(ints = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
        @DisplayName("All approaches with medium row indices (excluding recursive)")
        void testAllApproachesMedium(int rowIndex) {
            List<Integer> iterativeResult = solution.getRowIterative(rowIndex);
            List<Integer> mathematicalResult = solution.getRowMathematical(rowIndex);
            List<Integer> twoArraysResult = solution.getRowTwoArrays(rowIndex);
            List<Integer> combinatorialResult = solution.getRowCombinatorial(rowIndex);
            List<Integer> dynamicProgrammingResult = solution.getRowDynamicProgramming(rowIndex);

            assertEquals(iterativeResult, mathematicalResult,
                    "Mathematical failed for rowIndex: " + rowIndex);
            assertEquals(iterativeResult, twoArraysResult,
                    "Two Arrays failed for rowIndex: " + rowIndex);
            assertEquals(iterativeResult, combinatorialResult,
                    "Combinatorial failed for rowIndex: " + rowIndex);
            assertEquals(iterativeResult, dynamicProgrammingResult,
                    "Dynamic Programming failed for rowIndex: " + rowIndex);
        }

        @ParameterizedTest
        @MethodSource("provideTestCases")
        @DisplayName("All approaches with various test cases")
        void testAllApproaches(int rowIndex, List<Integer> expected) {
            assertEquals(expected, solution.getRowIterative(rowIndex),
                    "Iterative failed for rowIndex: " + rowIndex);
            assertEquals(expected, solution.getRowMathematical(rowIndex),
                    "Mathematical failed for rowIndex: " + rowIndex);
            if (rowIndex <= 10) { // Only test recursive for small inputs
                assertEquals(expected, solution.getRowRecursive(rowIndex),
                        "Recursive failed for rowIndex: " + rowIndex);
            }
            assertEquals(expected, solution.getRowTwoArrays(rowIndex),
                    "Two Arrays failed for rowIndex: " + rowIndex);
            assertEquals(expected, solution.getRowCombinatorial(rowIndex),
                    "Combinatorial failed for rowIndex: " + rowIndex);
            assertEquals(expected, solution.getRowDynamicProgramming(rowIndex),
                    "Dynamic Programming failed for rowIndex: " + rowIndex);
        }

        static Stream<Arguments> provideTestCases() {
            return Stream.of(Arguments.of(0, Arrays.asList(1)),
                    Arguments.of(1, Arrays.asList(1, 1)), Arguments.of(2, Arrays.asList(1, 2, 1)),
                    Arguments.of(3, Arrays.asList(1, 3, 3, 1)),
                    Arguments.of(4, Arrays.asList(1, 4, 6, 4, 1)),
                    Arguments.of(5, Arrays.asList(1, 5, 10, 10, 5, 1)),
                    Arguments.of(6, Arrays.asList(1, 6, 15, 20, 15, 6, 1)),
                    Arguments.of(7, Arrays.asList(1, 7, 21, 35, 35, 21, 7, 1)),
                    Arguments.of(8, Arrays.asList(1, 8, 28, 56, 70, 56, 28, 8, 1)),
                    Arguments.of(9, Arrays.asList(1, 9, 36, 84, 126, 126, 84, 36, 9, 1)),
                    Arguments.of(10, Arrays.asList(1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1)));
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Large row index performance test")
        void testLargeRowIndexPerformance() {
            int rowIndex = 30;
            List<Integer> expected = Arrays.asList(1, 30, 435, 4060, 27405, 142506, 593775, 2035800,
                    5852925, 14307150, 30045015, 54627300, 86493225, 119759850, 145422675,
                    155117520, 145422675, 119759850, 86493225, 54627300, 30045015, 14307150,
                    5852925, 2035800, 593775, 142506, 27405, 4060, 435, 30, 1);

            // Test all approaches
            long startTime, endTime;

            startTime = System.nanoTime();
            List<Integer> result1 = solution.getRowIterative(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Iterative time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result1);

            startTime = System.nanoTime();
            List<Integer> result2 = solution.getRowMathematical(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Mathematical time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result2);

            startTime = System.nanoTime();
            List<Integer> result4 = solution.getRowTwoArrays(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Two Arrays time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result4);

            startTime = System.nanoTime();
            List<Integer> result5 = solution.getRowCombinatorial(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Combinatorial time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result5);

            startTime = System.nanoTime();
            List<Integer> result6 = solution.getRowDynamicProgramming(rowIndex);
            endTime = System.nanoTime();
            System.out.println(
                    "Dynamic Programming time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertEquals(expected, result6);
        }

        @Test
        @DisplayName("Maximum constraint performance test")
        void testMaximumConstraintPerformance() {
            int rowIndex = 33;

            // Test all approaches
            long startTime, endTime;

            startTime = System.nanoTime();
            List<Integer> result1 = solution.getRowIterative(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Iterative time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertNotNull(result1);
            assertEquals(34, result1.size()); // Should have 34 elements

            startTime = System.nanoTime();
            List<Integer> result2 = solution.getRowMathematical(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Mathematical time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertNotNull(result2);
            assertEquals(34, result2.size());

            startTime = System.nanoTime();
            List<Integer> result4 = solution.getRowTwoArrays(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Two Arrays time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertNotNull(result4);
            assertEquals(34, result4.size());

            startTime = System.nanoTime();
            List<Integer> result5 = solution.getRowCombinatorial(rowIndex);
            endTime = System.nanoTime();
            System.out.println("Combinatorial time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertNotNull(result5);
            assertEquals(34, result5.size());

            startTime = System.nanoTime();
            List<Integer> result6 = solution.getRowDynamicProgramming(rowIndex);
            endTime = System.nanoTime();
            System.out.println(
                    "Dynamic Programming time: " + (endTime - startTime) / 1_000_000 + " ms");
            assertNotNull(result6);
            assertEquals(34, result6.size());
        }
    }

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Verify all approaches return same result")
        void testAllApproachesConsistency() {
            int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            for (int rowIndex : testCases) {
                List<Integer> iterativeResult = solution.getRowIterative(rowIndex);
                List<Integer> mathematicalResult = solution.getRowMathematical(rowIndex);
                List<Integer> recursiveResult = solution.getRowRecursive(rowIndex);
                List<Integer> twoArraysResult = solution.getRowTwoArrays(rowIndex);
                List<Integer> combinatorialResult = solution.getRowCombinatorial(rowIndex);
                List<Integer> dynamicProgrammingResult =
                        solution.getRowDynamicProgramming(rowIndex);

                assertEquals(iterativeResult, mathematicalResult,
                        "Iterative and Mathematical results should match for rowIndex: "
                                + rowIndex);
                assertEquals(iterativeResult, recursiveResult,
                        "Iterative and Recursive results should match for rowIndex: " + rowIndex);
                assertEquals(iterativeResult, twoArraysResult,
                        "Iterative and Two Arrays results should match for rowIndex: " + rowIndex);
                assertEquals(iterativeResult, combinatorialResult,
                        "Iterative and Combinatorial results should match for rowIndex: "
                                + rowIndex);
                assertEquals(iterativeResult, dynamicProgrammingResult,
                        "Iterative and Dynamic Programming results should match for rowIndex: "
                                + rowIndex);
            }
        }

        @Test
        @DisplayName("Verify row properties")
        void testRowProperties() {
            for (int rowIndex = 0; rowIndex <= 20; rowIndex++) {
                List<Integer> row = solution.getRowIterative(rowIndex);

                // Check that row has correct length
                assertEquals(rowIndex + 1, row.size(),
                        "Row " + rowIndex + " should have " + (rowIndex + 1) + " elements");

                // Check that first and last elements are 1
                assertEquals(1, row.get(0).intValue(),
                        "First element of row " + rowIndex + " should be 1");
                assertEquals(1, row.get(row.size() - 1).intValue(),
                        "Last element of row " + rowIndex + " should be 1");

                // Check that row is symmetric
                for (int i = 0; i < row.size() / 2; i++) {
                    assertEquals(row.get(i), row.get(row.size() - 1 - i),
                            "Row " + rowIndex + " should be symmetric at positions " + i + " and "
                                    + (row.size() - 1 - i));
                }
            }
        }

        @Test
        @DisplayName("Verify against complete triangle generation")
        void testAgainstCompleteTriangle() {
            for (int rowIndex = 0; rowIndex <= 15; rowIndex++) {
                List<Integer> row = solution.getRowIterative(rowIndex);
                List<List<Integer>> triangle =
                        PascalsTriangleII.generatePascalsTriangle(rowIndex + 1);
                List<Integer> expectedRow = triangle.get(rowIndex);

                assertEquals(expectedRow, row,
                        "Row " + rowIndex + " should match complete triangle generation");
            }
        }
    }

    @Nested
    @DisplayName("Cross Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("Random test cases with cross validation")
        void testRandomCasesWithCrossValidation() {
            int[] testCases =
                    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

            for (int rowIndex : testCases) {
                List<Integer> iterativeResult = solution.getRowIterative(rowIndex);
                List<Integer> mathematicalResult = solution.getRowMathematical(rowIndex);
                List<Integer> twoArraysResult = solution.getRowTwoArrays(rowIndex);
                List<Integer> combinatorialResult = solution.getRowCombinatorial(rowIndex);
                List<Integer> dynamicProgrammingResult =
                        solution.getRowDynamicProgramming(rowIndex);

                assertEquals(iterativeResult, mathematicalResult,
                        "Mathematical failed for rowIndex: " + rowIndex);
                assertEquals(iterativeResult, twoArraysResult,
                        "Two Arrays failed for rowIndex: " + rowIndex);
                assertEquals(iterativeResult, combinatorialResult,
                        "Combinatorial failed for rowIndex: " + rowIndex);
                assertEquals(iterativeResult, dynamicProgrammingResult,
                        "Dynamic Programming failed for rowIndex: " + rowIndex);

                // Test recursive only for small inputs
                if (rowIndex <= 10) {
                    List<Integer> recursiveResult = solution.getRowRecursive(rowIndex);
                    assertEquals(iterativeResult, recursiveResult,
                            "Recursive failed for rowIndex: " + rowIndex);
                }
            }
        }
    }

    @Nested
    @DisplayName("Comprehensive Integration Tests")
    class ComprehensiveIntegrationTests {

        @Test
        @DisplayName("Stress test with maximum constraints")
        void testStressTestWithMaxConstraints() {
            int rowIndex = 33;
            List<Integer> result = solution.getRowIterative(rowIndex);

            // Verify basic properties
            assertNotNull(result);
            assertEquals(34, result.size());
            assertEquals(1, result.get(0).intValue());
            assertEquals(1, result.get(result.size() - 1).intValue());

            // Verify symmetry
            for (int i = 0; i < result.size() / 2; i++) {
                assertEquals(result.get(i), result.get(result.size() - 1 - i),
                        "Row should be symmetric at positions " + i + " and "
                                + (result.size() - 1 - i));
            }

            // Verify against mathematical approach
            List<Integer> mathematicalResult = solution.getRowMathematical(rowIndex);
            assertEquals(result, mathematicalResult,
                    "Iterative and Mathematical should match for maximum constraint");
        }

        @Test
        @DisplayName("Test with very large row index")
        void testVeryLargeRowIndex() {
            int rowIndex = 30;
            List<Integer> result = solution.getRowIterative(rowIndex);

            // Verify basic properties
            assertNotNull(result);
            assertEquals(31, result.size());
            assertEquals(1, result.get(0).intValue());
            assertEquals(1, result.get(result.size() - 1).intValue());

            // Verify middle element (should be largest)
            int middleIndex = result.size() / 2;
            int middleValue = result.get(middleIndex);
            assertTrue(middleValue > 0, "Middle element should be positive");

            // Verify against mathematical approach
            List<Integer> mathematicalResult = solution.getRowMathematical(rowIndex);
            assertEquals(result, mathematicalResult,
                    "Iterative and Mathematical should match for large row index");
        }
    }
}
