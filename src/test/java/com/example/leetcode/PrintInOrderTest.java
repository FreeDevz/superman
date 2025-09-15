package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
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
 * Comprehensive test suite for PrintInOrder LeetCode problem
 * 
 * Tests all six different approaches: 1. Semaphore 2. CountDownLatch 3. ReentrantLock with
 * Condition 4. AtomicInteger with Busy Wait 5. Synchronized with wait/notify 6. CompletableFuture
 */
@DisplayName("Print in Order Tests")
class PrintInOrderTest {

    private PrintInOrder.ThreadOrderTester tester;

    @BeforeEach
    void setUp() {
        tester = new PrintInOrder.ThreadOrderTester();
    }

    @Nested
    @DisplayName("Basic Functionality Tests")
    class BasicFunctionalityTests {

        @Test
        @DisplayName("Semaphore approach - sequential order")
        void testSemaphoreSequentialOrder() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            PrintInOrder.FooSemaphore foo = new PrintInOrder.FooSemaphore();
            String result = tester.testFoo(foo, executionOrder);
            assertEquals("firstsecondthird", result);
        }

        @Test
        @DisplayName("CountDownLatch approach - sequential order")
        void testCountDownLatchSequentialOrder() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            PrintInOrder.FooCountDownLatch foo = new PrintInOrder.FooCountDownLatch();
            String result = tester.testFoo(foo, executionOrder);
            assertEquals("firstsecondthird", result);
        }

        @Test
        @DisplayName("ReentrantLock approach - sequential order")
        void testReentrantLockSequentialOrder() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            PrintInOrder.FooReentrantLock foo = new PrintInOrder.FooReentrantLock();
            String result = tester.testFoo(foo, executionOrder);
            assertEquals("firstsecondthird", result);
        }

        @Test
        @DisplayName("AtomicInteger approach - sequential order")
        void testAtomicIntegerSequentialOrder() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            PrintInOrder.FooAtomicInteger foo = new PrintInOrder.FooAtomicInteger();
            String result = tester.testFoo(foo, executionOrder);
            assertEquals("firstsecondthird", result);
        }

        @Test
        @DisplayName("Synchronized approach - sequential order")
        void testSynchronizedSequentialOrder() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            PrintInOrder.FooSynchronized foo = new PrintInOrder.FooSynchronized();
            String result = tester.testFoo(foo, executionOrder);
            assertEquals("firstsecondthird", result);
        }

        @Test
        @DisplayName("CompletableFuture approach - sequential order")
        void testCompletableFutureSequentialOrder() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            PrintInOrder.FooCompletableFuture foo = new PrintInOrder.FooCompletableFuture();
            String result = tester.testFoo(foo, executionOrder);
            assertEquals("firstsecondthird", result);
        }
    }

    @Nested
    @DisplayName("LeetCode Example Tests")
    class LeetCodeExampleTests {

        @Test
        @DisplayName("LeetCode Example 1: [1,2,3]")
        void testLeetCodeExample1() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            String expected = "firstsecondthird";

            PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
            PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
            PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
            PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
            PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
            PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

            assertEquals(expected, tester.testFoo(foo1, executionOrder));
            assertEquals(expected, tester.testFoo(foo2, executionOrder));
            assertEquals(expected, tester.testFoo(foo3, executionOrder));
            assertEquals(expected, tester.testFoo(foo4, executionOrder));
            assertEquals(expected, tester.testFoo(foo5, executionOrder));
            assertEquals(expected, tester.testFoo(foo6, executionOrder));
        }

        @Test
        @DisplayName("LeetCode Example 2: [1,3,2]")
        void testLeetCodeExample2() throws InterruptedException {
            int[] executionOrder = {1, 3, 2};
            String expected = "firstsecondthird";

            PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
            PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
            PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
            PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
            PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
            PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

            assertEquals(expected, tester.testFoo(foo1, executionOrder));
            assertEquals(expected, tester.testFoo(foo2, executionOrder));
            assertEquals(expected, tester.testFoo(foo3, executionOrder));
            assertEquals(expected, tester.testFoo(foo4, executionOrder));
            assertEquals(expected, tester.testFoo(foo5, executionOrder));
            assertEquals(expected, tester.testFoo(foo6, executionOrder));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {

        @Test
        @DisplayName("All approaches - reverse order [3,2,1]")
        void testReverseOrder() throws InterruptedException {
            int[] executionOrder = {3, 2, 1};
            String expected = "firstsecondthird";

            PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
            PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
            PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
            PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
            PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
            PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

            assertEquals(expected, tester.testFoo(foo1, executionOrder));
            assertEquals(expected, tester.testFoo(foo2, executionOrder));
            assertEquals(expected, tester.testFoo(foo3, executionOrder));
            assertEquals(expected, tester.testFoo(foo4, executionOrder));
            assertEquals(expected, tester.testFoo(foo5, executionOrder));
            assertEquals(expected, tester.testFoo(foo6, executionOrder));
        }

        @Test
        @DisplayName("All approaches - middle first [2,1,3]")
        void testMiddleFirst() throws InterruptedException {
            int[] executionOrder = {2, 1, 3};
            String expected = "firstsecondthird";

            PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
            PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
            PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
            PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
            PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
            PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

            assertEquals(expected, tester.testFoo(foo1, executionOrder));
            assertEquals(expected, tester.testFoo(foo2, executionOrder));
            assertEquals(expected, tester.testFoo(foo3, executionOrder));
            assertEquals(expected, tester.testFoo(foo4, executionOrder));
            assertEquals(expected, tester.testFoo(foo5, executionOrder));
            assertEquals(expected, tester.testFoo(foo6, executionOrder));
        }

        @Test
        @DisplayName("All approaches - last first [3,1,2]")
        void testLastFirst() throws InterruptedException {
            int[] executionOrder = {3, 1, 2};
            String expected = "firstsecondthird";

            PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
            PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
            PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
            PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
            PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
            PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

            assertEquals(expected, tester.testFoo(foo1, executionOrder));
            assertEquals(expected, tester.testFoo(foo2, executionOrder));
            assertEquals(expected, tester.testFoo(foo3, executionOrder));
            assertEquals(expected, tester.testFoo(foo4, executionOrder));
            assertEquals(expected, tester.testFoo(foo5, executionOrder));
            assertEquals(expected, tester.testFoo(foo6, executionOrder));
        }
    }

    @Nested
    @DisplayName("Parameterized Tests")
    class ParameterizedTests {

        @ParameterizedTest
        @MethodSource("provideExecutionOrders")
        @DisplayName("All approaches with various execution orders")
        void testAllApproaches(int[] executionOrder) throws InterruptedException {
            String expected = "firstsecondthird";

            PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
            PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
            PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
            PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
            PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
            PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

            assertEquals(expected, tester.testFoo(foo1, executionOrder),
                    "Semaphore failed for: " + Arrays.toString(executionOrder));
            assertEquals(expected, tester.testFoo(foo2, executionOrder),
                    "CountDownLatch failed for: " + Arrays.toString(executionOrder));
            assertEquals(expected, tester.testFoo(foo3, executionOrder),
                    "ReentrantLock failed for: " + Arrays.toString(executionOrder));
            assertEquals(expected, tester.testFoo(foo4, executionOrder),
                    "AtomicInteger failed for: " + Arrays.toString(executionOrder));
            assertEquals(expected, tester.testFoo(foo5, executionOrder),
                    "Synchronized failed for: " + Arrays.toString(executionOrder));
            assertEquals(expected, tester.testFoo(foo6, executionOrder),
                    "CompletableFuture failed for: " + Arrays.toString(executionOrder));
        }

        static Stream<Arguments> provideExecutionOrders() {
            return Stream.of(Arguments.of(new int[] {1, 2, 3}), Arguments.of(new int[] {1, 3, 2}),
                    Arguments.of(new int[] {2, 1, 3}), Arguments.of(new int[] {2, 3, 1}),
                    Arguments.of(new int[] {3, 1, 2}), Arguments.of(new int[] {3, 2, 1}));
        }

        @ParameterizedTest
        @ValueSource(ints = {10, 20, 50, 100})
        @DisplayName("Stress test with multiple iterations")
        void testStressTest(int iterations) throws InterruptedException {
            int[][] executionOrders =
                    {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
            Random random = new Random(42);

            for (int i = 0; i < iterations; i++) {
                int[] executionOrder = executionOrders[random.nextInt(executionOrders.length)];
                String expected = "firstsecondthird";

                PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
                PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
                PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
                PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
                PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
                PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

                assertEquals(expected, tester.testFoo(foo1, executionOrder),
                        "Semaphore failed in iteration " + i);
                assertEquals(expected, tester.testFoo(foo2, executionOrder),
                        "CountDownLatch failed in iteration " + i);
                assertEquals(expected, tester.testFoo(foo3, executionOrder),
                        "ReentrantLock failed in iteration " + i);
                assertEquals(expected, tester.testFoo(foo4, executionOrder),
                        "AtomicInteger failed in iteration " + i);
                assertEquals(expected, tester.testFoo(foo5, executionOrder),
                        "Synchronized failed in iteration " + i);
                assertEquals(expected, tester.testFoo(foo6, executionOrder),
                        "CompletableFuture failed in iteration " + i);
            }
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison test")
        void testPerformanceComparison() throws InterruptedException {
            int[] executionOrder = {3, 1, 2};
            int iterations = 1000;

            // Test Semaphore approach
            long startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                PrintInOrder.FooSemaphore foo = new PrintInOrder.FooSemaphore();
                tester.testFoo(foo, executionOrder);
            }
            long semaphoreTime = System.nanoTime() - startTime;

            // Test CountDownLatch approach
            startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                PrintInOrder.FooCountDownLatch foo = new PrintInOrder.FooCountDownLatch();
                tester.testFoo(foo, executionOrder);
            }
            long countDownLatchTime = System.nanoTime() - startTime;

            // Test ReentrantLock approach
            startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                PrintInOrder.FooReentrantLock foo = new PrintInOrder.FooReentrantLock();
                tester.testFoo(foo, executionOrder);
            }
            long reentrantLockTime = System.nanoTime() - startTime;

            // Test AtomicInteger approach
            startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                PrintInOrder.FooAtomicInteger foo = new PrintInOrder.FooAtomicInteger();
                tester.testFoo(foo, executionOrder);
            }
            long atomicIntegerTime = System.nanoTime() - startTime;

            // Test Synchronized approach
            startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                PrintInOrder.FooSynchronized foo = new PrintInOrder.FooSynchronized();
                tester.testFoo(foo, executionOrder);
            }
            long synchronizedTime = System.nanoTime() - startTime;

            // Test CompletableFuture approach
            startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                PrintInOrder.FooCompletableFuture foo = new PrintInOrder.FooCompletableFuture();
                tester.testFoo(foo, executionOrder);
            }
            long completableFutureTime = System.nanoTime() - startTime;

            System.out.println(
                    "\nPerformance Results (nanoseconds for " + iterations + " iterations):");
            System.out.println("Semaphore: " + semaphoreTime / 1_000_000 + " ms");
            System.out.println("CountDownLatch: " + countDownLatchTime / 1_000_000 + " ms");
            System.out.println("ReentrantLock: " + reentrantLockTime / 1_000_000 + " ms");
            System.out.println("AtomicInteger: " + atomicIntegerTime / 1_000_000 + " ms");
            System.out.println("Synchronized: " + synchronizedTime / 1_000_000 + " ms");
            System.out.println("CompletableFuture: " + completableFutureTime / 1_000_000 + " ms");

            // All approaches should complete successfully
            assertTrue(semaphoreTime > 0);
            assertTrue(countDownLatchTime > 0);
            assertTrue(reentrantLockTime > 0);
            assertTrue(atomicIntegerTime > 0);
            assertTrue(synchronizedTime > 0);
            assertTrue(completableFutureTime > 0);
        }
    }

    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Verify all approaches return same result")
        void testAllApproachesConsistency() throws InterruptedException {
            int[][] testCases = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

            for (int[] executionOrder : testCases) {
                PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
                PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
                PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
                PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
                PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
                PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

                String result1 = tester.testFoo(foo1, executionOrder);
                String result2 = tester.testFoo(foo2, executionOrder);
                String result3 = tester.testFoo(foo3, executionOrder);
                String result4 = tester.testFoo(foo4, executionOrder);
                String result5 = tester.testFoo(foo5, executionOrder);
                String result6 = tester.testFoo(foo6, executionOrder);

                assertEquals(result1, result2, "Semaphore and CountDownLatch should match for: "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result3, "Semaphore and ReentrantLock should match for: "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result4, "Semaphore and AtomicInteger should match for: "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result5, "Semaphore and Synchronized should match for: "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result6, "Semaphore and CompletableFuture should match for: "
                        + Arrays.toString(executionOrder));
            }
        }

        @Test
        @DisplayName("Verify thread order tester utility")
        void testThreadOrderTester() throws InterruptedException {
            // Test the tester utility itself
            assertNotNull(tester);

            // Test reset functionality
            tester.reset();
            assertEquals("", tester.getResult());

            // Test individual print methods
            tester.printFirst();
            assertEquals("first", tester.getResult());

            tester.reset();
            tester.printSecond();
            assertEquals("second", tester.getResult());

            tester.reset();
            tester.printThird();
            assertEquals("third", tester.getResult());

            // Test combined output
            tester.reset();
            tester.printFirst();
            tester.printSecond();
            tester.printThird();
            assertEquals("firstsecondthird", tester.getResult());
        }
    }

    @Nested
    @DisplayName("Cross Validation Tests")
    class CrossValidationTests {

        @Test
        @DisplayName("Random test cases with cross validation")
        void testRandomCasesWithCrossValidation() throws InterruptedException {
            Random random = new Random(123);
            int[][] executionOrders =
                    {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

            for (int test = 0; test < 50; test++) {
                int[] executionOrder = executionOrders[random.nextInt(executionOrders.length)];

                PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
                PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
                PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
                PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
                PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
                PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

                String result1 = tester.testFoo(foo1, executionOrder);
                String result2 = tester.testFoo(foo2, executionOrder);
                String result3 = tester.testFoo(foo3, executionOrder);
                String result4 = tester.testFoo(foo4, executionOrder);
                String result5 = tester.testFoo(foo5, executionOrder);
                String result6 = tester.testFoo(foo6, executionOrder);

                assertEquals(result1, result2, "CountDownLatch failed for test case " + test + ": "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result3, "ReentrantLock failed for test case " + test + ": "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result4, "AtomicInteger failed for test case " + test + ": "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result5, "Synchronized failed for test case " + test + ": "
                        + Arrays.toString(executionOrder));
                assertEquals(result1, result6, "CompletableFuture failed for test case " + test
                        + ": " + Arrays.toString(executionOrder));
            }
        }
    }

    @Nested
    @DisplayName("Comprehensive Integration Tests")
    class ComprehensiveIntegrationTests {

        @Test
        @DisplayName("Stress test with maximum concurrency")
        void testStressTestWithMaxConcurrency() throws InterruptedException {
            int[] executionOrder = {3, 1, 2};
            int concurrentTests = 10;
            CountDownLatch startLatch = new CountDownLatch(1);
            CountDownLatch finishLatch = new CountDownLatch(concurrentTests);

            // Run multiple concurrent tests
            for (int i = 0; i < concurrentTests; i++) {
                new Thread(() -> {
                    try {
                        startLatch.await();
                        PrintInOrder.FooSemaphore foo = new PrintInOrder.FooSemaphore();
                        String result = tester.testFoo(foo, executionOrder);
                        assertEquals("firstsecondthird", result, "Concurrent test failed");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        finishLatch.countDown();
                    }
                }).start();
            }

            startLatch.countDown(); // Start all threads
            assertTrue(finishLatch.await(5, TimeUnit.SECONDS),
                    "Concurrent tests did not complete in time");
        }

        @Test
        @DisplayName("Test with very fast execution")
        void testVeryFastExecution() throws InterruptedException {
            int[] executionOrder = {1, 2, 3};
            int iterations = 100;

            // Test with minimal delay between operations
            for (int i = 0; i < iterations; i++) {
                PrintInOrder.FooSemaphore foo = new PrintInOrder.FooSemaphore();
                String result = tester.testFoo(foo, executionOrder);
                assertEquals("firstsecondthird", result, "Fast execution failed at iteration " + i);
            }
        }

        @Test
        @DisplayName("Test with mixed execution orders")
        void testMixedExecutionOrders() throws InterruptedException {
            int[][] executionOrders =
                    {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

            for (int[] executionOrder : executionOrders) {
                PrintInOrder.FooSemaphore foo1 = new PrintInOrder.FooSemaphore();
                PrintInOrder.FooCountDownLatch foo2 = new PrintInOrder.FooCountDownLatch();
                PrintInOrder.FooReentrantLock foo3 = new PrintInOrder.FooReentrantLock();
                PrintInOrder.FooAtomicInteger foo4 = new PrintInOrder.FooAtomicInteger();
                PrintInOrder.FooSynchronized foo5 = new PrintInOrder.FooSynchronized();
                PrintInOrder.FooCompletableFuture foo6 = new PrintInOrder.FooCompletableFuture();

                String result1 = tester.testFoo(foo1, executionOrder);
                String result2 = tester.testFoo(foo2, executionOrder);
                String result3 = tester.testFoo(foo3, executionOrder);
                String result4 = tester.testFoo(foo4, executionOrder);
                String result5 = tester.testFoo(foo5, executionOrder);
                String result6 = tester.testFoo(foo6, executionOrder);

                assertEquals("firstsecondthird", result1,
                        "Semaphore failed for: " + Arrays.toString(executionOrder));
                assertEquals("firstsecondthird", result2,
                        "CountDownLatch failed for: " + Arrays.toString(executionOrder));
                assertEquals("firstsecondthird", result3,
                        "ReentrantLock failed for: " + Arrays.toString(executionOrder));
                assertEquals("firstsecondthird", result4,
                        "AtomicInteger failed for: " + Arrays.toString(executionOrder));
                assertEquals("firstsecondthird", result5,
                        "Synchronized failed for: " + Arrays.toString(executionOrder));
                assertEquals("firstsecondthird", result6,
                        "CompletableFuture failed for: " + Arrays.toString(executionOrder));
            }
        }
    }
}
