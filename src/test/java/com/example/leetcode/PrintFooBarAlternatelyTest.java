package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Comprehensive test suite for PrintFooBarAlternately
 * 
 * Tests all synchronization approaches with various scenarios: - Basic functionality tests - Edge
 * cases (n=1, n=1000) - Concurrency stress tests - Performance tests - Correctness validation
 */
@DisplayName("Print FooBar Alternately Tests")
public class PrintFooBarAlternatelyTest {

    @Nested
    @DisplayName("Semaphore Approach Tests")
    class SemaphoreApproachTests {

        @Test
        @DisplayName("Basic functionality test with n=1")
        void testBasicFunctionalityN1() throws InterruptedException {
            PrintFooBarAlternately.SemaphoreApproach foobar =
                    new PrintFooBarAlternately.SemaphoreApproach(1);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(5, TimeUnit.SECONDS),
                    "Threads should complete within 5 seconds");
            assertEquals("foobar", output.toString(), "Output should be 'foobar' for n=1");
        }

        @Test
        @DisplayName("Basic functionality test with n=2")
        void testBasicFunctionalityN2() throws InterruptedException {
            PrintFooBarAlternately.SemaphoreApproach foobar =
                    new PrintFooBarAlternately.SemaphoreApproach(2);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(5, TimeUnit.SECONDS),
                    "Threads should complete within 5 seconds");
            assertEquals("foobarfoobar", output.toString(),
                    "Output should be 'foobarfoobar' for n=2");
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 5, 10, 50, 100})
        @DisplayName("Parameterized test for various n values")
        void testVariousNValues(int n) throws InterruptedException {
            PrintFooBarAlternately.SemaphoreApproach foobar =
                    new PrintFooBarAlternately.SemaphoreApproach(n);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(10, TimeUnit.SECONDS),
                    "Threads should complete within 10 seconds");

            String expected = "foobar".repeat(n);
            assertEquals(expected, output.toString(),
                    "Output should be '" + expected + "' for n=" + n);
        }

        @Test
        @DisplayName("Stress test with n=1000")
        @Timeout(value = 30, unit = TimeUnit.SECONDS)
        void testStressTestN1000() throws InterruptedException {
            PrintFooBarAlternately.SemaphoreApproach foobar =
                    new PrintFooBarAlternately.SemaphoreApproach(1000);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(30, TimeUnit.SECONDS),
                    "Threads should complete within 30 seconds");

            String expected = "foobar".repeat(1000);
            assertEquals(expected, output.toString(), "Output should be correct for n=1000");
        }

        @Test
        @DisplayName("Concurrency test - multiple runs")
        void testConcurrencyMultipleRuns() throws InterruptedException {
            for (int run = 0; run < 10; run++) {
                PrintFooBarAlternately.SemaphoreApproach foobar =
                        new PrintFooBarAlternately.SemaphoreApproach(5);

                StringBuilder output = new StringBuilder();
                CountDownLatch latch = new CountDownLatch(2);

                Thread fooThread = new Thread(() -> {
                    try {
                        foobar.foo(() -> output.append("foo"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        latch.countDown();
                    }
                });

                Thread barThread = new Thread(() -> {
                    try {
                        foobar.bar(() -> output.append("bar"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        latch.countDown();
                    }
                });

                fooThread.start();
                barThread.start();

                assertTrue(latch.await(5, TimeUnit.SECONDS),
                        "Run " + run + " should complete within 5 seconds");

                String expected = "foobar".repeat(5);
                assertEquals(expected, output.toString(),
                        "Run " + run + " should produce correct output");
            }
        }
    }

    @Nested
    @DisplayName("Atomic Integer Approach Tests")
    class AtomicIntegerApproachTests {

        @Test
        @DisplayName("Basic functionality test with n=1")
        void testBasicFunctionalityN1() throws InterruptedException {
            PrintFooBarAlternately.AtomicIntegerApproach foobar =
                    new PrintFooBarAlternately.AtomicIntegerApproach(1);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(5, TimeUnit.SECONDS),
                    "Threads should complete within 5 seconds");
            assertEquals("foobar", output.toString(), "Output should be 'foobar' for n=1");
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 5, 10, 50})
        @DisplayName("Parameterized test for various n values")
        void testVariousNValues(int n) throws InterruptedException {
            PrintFooBarAlternately.AtomicIntegerApproach foobar =
                    new PrintFooBarAlternately.AtomicIntegerApproach(n);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(10, TimeUnit.SECONDS),
                    "Threads should complete within 10 seconds");

            String expected = "foobar".repeat(n);
            assertEquals(expected, output.toString(),
                    "Output should be '" + expected + "' for n=" + n);
        }
    }

    @Nested
    @DisplayName("ReentrantLock Approach Tests")
    class ReentrantLockApproachTests {

        @Test
        @DisplayName("Basic functionality test with n=1")
        void testBasicFunctionalityN1() throws InterruptedException {
            PrintFooBarAlternately.ReentrantLockApproach foobar =
                    new PrintFooBarAlternately.ReentrantLockApproach(1);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(5, TimeUnit.SECONDS),
                    "Threads should complete within 5 seconds");
            assertEquals("foobar", output.toString(), "Output should be 'foobar' for n=1");
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 5, 10, 50})
        @DisplayName("Parameterized test for various n values")
        void testVariousNValues(int n) throws InterruptedException {
            PrintFooBarAlternately.ReentrantLockApproach foobar =
                    new PrintFooBarAlternately.ReentrantLockApproach(n);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(10, TimeUnit.SECONDS),
                    "Threads should complete within 10 seconds");

            String expected = "foobar".repeat(n);
            assertEquals(expected, output.toString(),
                    "Output should be '" + expected + "' for n=" + n);
        }
    }

    @Nested
    @DisplayName("Synchronized Approach Tests")
    class SynchronizedApproachTests {

        @Test
        @DisplayName("Basic functionality test with n=1")
        void testBasicFunctionalityN1() throws InterruptedException {
            PrintFooBarAlternately.SynchronizedApproach foobar =
                    new PrintFooBarAlternately.SynchronizedApproach(1);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(5, TimeUnit.SECONDS),
                    "Threads should complete within 5 seconds");
            assertEquals("foobar", output.toString(), "Output should be 'foobar' for n=1");
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 5, 10, 50})
        @DisplayName("Parameterized test for various n values")
        void testVariousNValues(int n) throws InterruptedException {
            PrintFooBarAlternately.SynchronizedApproach foobar =
                    new PrintFooBarAlternately.SynchronizedApproach(n);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(10, TimeUnit.SECONDS),
                    "Threads should complete within 10 seconds");

            String expected = "foobar".repeat(n);
            assertEquals(expected, output.toString(),
                    "Output should be '" + expected + "' for n=" + n);
        }
    }

    @Nested
    @DisplayName("Volatile Boolean Approach Tests")
    class VolatileBooleanApproachTests {

        @Test
        @DisplayName("Basic functionality test with n=1")
        void testBasicFunctionalityN1() throws InterruptedException {
            PrintFooBarAlternately.VolatileBooleanApproach foobar =
                    new PrintFooBarAlternately.VolatileBooleanApproach(1);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(5, TimeUnit.SECONDS),
                    "Threads should complete within 5 seconds");
            assertEquals("foobar", output.toString(), "Output should be 'foobar' for n=1");
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 5, 10, 50})
        @DisplayName("Parameterized test for various n values")
        void testVariousNValues(int n) throws InterruptedException {
            PrintFooBarAlternately.VolatileBooleanApproach foobar =
                    new PrintFooBarAlternately.VolatileBooleanApproach(n);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(10, TimeUnit.SECONDS),
                    "Threads should complete within 10 seconds");

            String expected = "foobar".repeat(n);
            assertEquals(expected, output.toString(),
                    "Output should be '" + expected + "' for n=" + n);
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same output for n=5")
        void testAllApproachesSameOutput() throws InterruptedException {
            int n = 5;
            String expected = "foobar".repeat(n);

            // Test Semaphore approach
            String semaphoreOutput = testApproach(new PrintFooBarAlternately.SemaphoreApproach(n));
            assertEquals(expected, semaphoreOutput,
                    "Semaphore approach should produce correct output");

            // Test AtomicInteger approach
            String atomicOutput = testApproach(new PrintFooBarAlternately.AtomicIntegerApproach(n));
            assertEquals(expected, atomicOutput,
                    "AtomicInteger approach should produce correct output");

            // Test ReentrantLock approach
            String lockOutput = testApproach(new PrintFooBarAlternately.ReentrantLockApproach(n));
            assertEquals(expected, lockOutput,
                    "ReentrantLock approach should produce correct output");

            // Test Synchronized approach
            String syncOutput = testApproach(new PrintFooBarAlternately.SynchronizedApproach(n));
            assertEquals(expected, syncOutput,
                    "Synchronized approach should produce correct output");

            // Test VolatileBoolean approach
            String volatileOutput =
                    testApproach(new PrintFooBarAlternately.VolatileBooleanApproach(n));
            assertEquals(expected, volatileOutput,
                    "VolatileBoolean approach should produce correct output");
        }

        private String testApproach(Object foobar) throws InterruptedException {
            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    if (foobar instanceof PrintFooBarAlternately.SemaphoreApproach) {
                        ((PrintFooBarAlternately.SemaphoreApproach) foobar)
                                .foo(() -> output.append("foo"));
                    } else if (foobar instanceof PrintFooBarAlternately.AtomicIntegerApproach) {
                        ((PrintFooBarAlternately.AtomicIntegerApproach) foobar)
                                .foo(() -> output.append("foo"));
                    } else if (foobar instanceof PrintFooBarAlternately.ReentrantLockApproach) {
                        ((PrintFooBarAlternately.ReentrantLockApproach) foobar)
                                .foo(() -> output.append("foo"));
                    } else if (foobar instanceof PrintFooBarAlternately.SynchronizedApproach) {
                        ((PrintFooBarAlternately.SynchronizedApproach) foobar)
                                .foo(() -> output.append("foo"));
                    } else if (foobar instanceof PrintFooBarAlternately.VolatileBooleanApproach) {
                        ((PrintFooBarAlternately.VolatileBooleanApproach) foobar)
                                .foo(() -> output.append("foo"));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    if (foobar instanceof PrintFooBarAlternately.SemaphoreApproach) {
                        ((PrintFooBarAlternately.SemaphoreApproach) foobar)
                                .bar(() -> output.append("bar"));
                    } else if (foobar instanceof PrintFooBarAlternately.AtomicIntegerApproach) {
                        ((PrintFooBarAlternately.AtomicIntegerApproach) foobar)
                                .bar(() -> output.append("bar"));
                    } else if (foobar instanceof PrintFooBarAlternately.ReentrantLockApproach) {
                        ((PrintFooBarAlternately.ReentrantLockApproach) foobar)
                                .bar(() -> output.append("bar"));
                    } else if (foobar instanceof PrintFooBarAlternately.SynchronizedApproach) {
                        ((PrintFooBarAlternately.SynchronizedApproach) foobar)
                                .bar(() -> output.append("bar"));
                    } else if (foobar instanceof PrintFooBarAlternately.VolatileBooleanApproach) {
                        ((PrintFooBarAlternately.VolatileBooleanApproach) foobar)
                                .bar(() -> output.append("bar"));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(10, TimeUnit.SECONDS),
                    "Threads should complete within 10 seconds");
            return output.toString();
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with minimum n value (n=1)")
        void testMinimumNValue() throws InterruptedException {
            PrintFooBarAlternately.SemaphoreApproach foobar =
                    new PrintFooBarAlternately.SemaphoreApproach(1);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(5, TimeUnit.SECONDS),
                    "Threads should complete within 5 seconds");
            assertEquals("foobar", output.toString(), "Output should be 'foobar' for n=1");
        }

        @Test
        @DisplayName("Test with maximum n value (n=1000)")
        @Timeout(value = 30, unit = TimeUnit.SECONDS)
        void testMaximumNValue() throws InterruptedException {
            PrintFooBarAlternately.SemaphoreApproach foobar =
                    new PrintFooBarAlternately.SemaphoreApproach(1000);

            StringBuilder output = new StringBuilder();
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    foobar.foo(() -> output.append("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    foobar.bar(() -> output.append("bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(30, TimeUnit.SECONDS),
                    "Threads should complete within 30 seconds");

            String expected = "foobar".repeat(1000);
            assertEquals(expected, output.toString(), "Output should be correct for n=1000");
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() throws InterruptedException {
            int n = 100;
            long[] times = new long[5];
            String[] approachNames = {"Semaphore", "AtomicInteger", "ReentrantLock", "Synchronized",
                    "VolatileBoolean"};

            // Test Semaphore approach
            long startTime = System.currentTimeMillis();
            testApproachPerformance(new PrintFooBarAlternately.SemaphoreApproach(n));
            times[0] = System.currentTimeMillis() - startTime;

            // Test AtomicInteger approach
            startTime = System.currentTimeMillis();
            testApproachPerformance(new PrintFooBarAlternately.AtomicIntegerApproach(n));
            times[1] = System.currentTimeMillis() - startTime;

            // Test ReentrantLock approach
            startTime = System.currentTimeMillis();
            testApproachPerformance(new PrintFooBarAlternately.ReentrantLockApproach(n));
            times[2] = System.currentTimeMillis() - startTime;

            // Test Synchronized approach
            startTime = System.currentTimeMillis();
            testApproachPerformance(new PrintFooBarAlternately.SynchronizedApproach(n));
            times[3] = System.currentTimeMillis() - startTime;

            // Test VolatileBoolean approach
            startTime = System.currentTimeMillis();
            testApproachPerformance(new PrintFooBarAlternately.VolatileBooleanApproach(n));
            times[4] = System.currentTimeMillis() - startTime;

            // Print performance results
            System.out.println("\nPerformance Results (n=" + n + "):");
            for (int i = 0; i < approachNames.length; i++) {
                System.out.println(approachNames[i] + ": " + times[i] + "ms");
            }

            // All approaches should complete within reasonable time
            for (int i = 0; i < times.length; i++) {
                assertTrue(times[i] < 5000, approachNames[i] + " should complete within 5 seconds");
            }
        }

        private void testApproachPerformance(Object foobar) throws InterruptedException {
            CountDownLatch latch = new CountDownLatch(2);

            Thread fooThread = new Thread(() -> {
                try {
                    if (foobar instanceof PrintFooBarAlternately.SemaphoreApproach) {
                        ((PrintFooBarAlternately.SemaphoreApproach) foobar).foo(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.AtomicIntegerApproach) {
                        ((PrintFooBarAlternately.AtomicIntegerApproach) foobar).foo(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.ReentrantLockApproach) {
                        ((PrintFooBarAlternately.ReentrantLockApproach) foobar).foo(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.SynchronizedApproach) {
                        ((PrintFooBarAlternately.SynchronizedApproach) foobar).foo(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.VolatileBooleanApproach) {
                        ((PrintFooBarAlternately.VolatileBooleanApproach) foobar).foo(() -> {
                        });
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            Thread barThread = new Thread(() -> {
                try {
                    if (foobar instanceof PrintFooBarAlternately.SemaphoreApproach) {
                        ((PrintFooBarAlternately.SemaphoreApproach) foobar).bar(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.AtomicIntegerApproach) {
                        ((PrintFooBarAlternately.AtomicIntegerApproach) foobar).bar(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.ReentrantLockApproach) {
                        ((PrintFooBarAlternately.ReentrantLockApproach) foobar).bar(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.SynchronizedApproach) {
                        ((PrintFooBarAlternately.SynchronizedApproach) foobar).bar(() -> {
                        });
                    } else if (foobar instanceof PrintFooBarAlternately.VolatileBooleanApproach) {
                        ((PrintFooBarAlternately.VolatileBooleanApproach) foobar).bar(() -> {
                        });
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });

            fooThread.start();
            barThread.start();

            assertTrue(latch.await(10, TimeUnit.SECONDS),
                    "Performance test should complete within 10 seconds");
        }
    }
}
