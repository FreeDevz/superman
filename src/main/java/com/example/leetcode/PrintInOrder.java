package com.example.leetcode;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LeetCode 1114: Print in Order
 * 
 * Problem Description: Suppose we have a class:
 * 
 * public class Foo { public void first() { print("first"); } public void second() {
 * print("second"); } public void third() { print("third"); } }
 * 
 * The same instance of Foo will be passed to three different threads. Thread A will call first(),
 * thread B will call second(), and thread C will call third(). Design a mechanism and modify the
 * program to ensure that second() is executed after first(), and third() is executed after
 * second().
 * 
 * Example 1: Input: [1,2,3] Output: "firstsecondthird" Explanation: There are three threads being
 * fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(),
 * and thread C calls third(). "firstsecondthird" is the correct output.
 * 
 * Example 2: Input: [1,3,2] Output: "firstsecondthird" Explanation: The input [1,3,2] means thread
 * A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the
 * correct output.
 * 
 * Note: We do not know how the threads will be scheduled in the operating system, even though the
 * numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our
 * tests' comprehensiveness.
 * 
 * Approach 1: Semaphore (Recommended) Time Complexity: O(1) per method Space Complexity: O(1)
 * 
 * Approach 2: CountDownLatch Time Complexity: O(1) per method Space Complexity: O(1)
 * 
 * Approach 3: ReentrantLock with Condition Time Complexity: O(1) per method Space Complexity: O(1)
 * 
 * Approach 4: AtomicInteger with Busy Wait Time Complexity: O(1) per method Space Complexity: O(1)
 * 
 * Approach 5: Synchronized with wait/notify Time Complexity: O(1) per method Space Complexity: O(1)
 * 
 * Approach 6: CompletableFuture Time Complexity: O(1) per method Space Complexity: O(1)
 */
public class PrintInOrder {

    /**
     * Approach 1: Semaphore (Recommended Solution)
     * 
     * Use semaphores to control the execution order. Semaphores are perfect for this use case as
     * they provide a clean way to synchronize threads.
     * 
     * @param printFirst Runnable to print "first"
     * @param printSecond Runnable to print "second"
     * @param printThird Runnable to print "third"
     */
    public static class FooSemaphore {
        private final Semaphore secondSemaphore = new Semaphore(0);
        private final Semaphore thirdSemaphore = new Semaphore(0);

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst() outputs "first". Do not change or remove this line.
            printFirst.run();
            secondSemaphore.release(); // Signal that first() is done
        }

        public void second(Runnable printSecond) throws InterruptedException {
            secondSemaphore.acquire(); // Wait for first() to complete
            // printSecond() outputs "second". Do not change or remove this line.
            printSecond.run();
            thirdSemaphore.release(); // Signal that second() is done
        }

        public void third(Runnable printThird) throws InterruptedException {
            thirdSemaphore.acquire(); // Wait for second() to complete
            // printThird() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    /**
     * Approach 2: CountDownLatch
     * 
     * Use CountDownLatch to coordinate the execution order. CountDownLatch is ideal for
     * synchronization where one thread needs to wait for other threads to complete.
     * 
     * @param printFirst Runnable to print "first"
     * @param printSecond Runnable to print "second"
     * @param printThird Runnable to print "third"
     */
    public static class FooCountDownLatch {
        private final CountDownLatch firstLatch = new CountDownLatch(1);
        private final CountDownLatch secondLatch = new CountDownLatch(1);

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstLatch.countDown(); // Signal that first() is done
        }

        public void second(Runnable printSecond) throws InterruptedException {
            firstLatch.await(); // Wait for first() to complete
            // printSecond() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondLatch.countDown(); // Signal that second() is done
        }

        public void third(Runnable printThird) throws InterruptedException {
            secondLatch.await(); // Wait for second() to complete
            // printThird() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    /**
     * Approach 3: ReentrantLock with Condition
     * 
     * Use ReentrantLock with Condition variables to control the execution order. This approach
     * provides fine-grained control over thread synchronization.
     * 
     * @param printFirst Runnable to print "first"
     * @param printSecond Runnable to print "second"
     * @param printThird Runnable to print "third"
     */
    public static class FooReentrantLock {
        private final Lock lock = new ReentrantLock();
        private final Condition firstCondition = lock.newCondition();
        private final Condition secondCondition = lock.newCondition();
        private boolean firstFinished = false;
        private boolean secondFinished = false;

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                // printFirst() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstFinished = true;
                firstCondition.signal(); // Signal that first() is done
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (!firstFinished) {
                    firstCondition.await(); // Wait for first() to complete
                }
                // printSecond() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinished = true;
                secondCondition.signal(); // Signal that second() is done
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (!secondFinished) {
                    secondCondition.await(); // Wait for second() to complete
                }
                // printThird() outputs "third". Do not change or remove this line.
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Approach 4: AtomicInteger with Busy Wait
     * 
     * Use AtomicInteger to track the execution state. This approach uses busy waiting, which may
     * consume more CPU but provides very low latency.
     * 
     * @param printFirst Runnable to print "first"
     * @param printSecond Runnable to print "second"
     * @param printThird Runnable to print "third"
     */
    public static class FooAtomicInteger {
        private final AtomicInteger state = new AtomicInteger(0);

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst() outputs "first". Do not change or remove this line.
            printFirst.run();
            state.set(1); // Signal that first() is done
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (state.get() != 1) {
                Thread.yield(); // Busy wait for first() to complete
            }
            // printSecond() outputs "second". Do not change or remove this line.
            printSecond.run();
            state.set(2); // Signal that second() is done
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (state.get() != 2) {
                Thread.yield(); // Busy wait for second() to complete
            }
            // printThird() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    /**
     * Approach 5: Synchronized with wait/notify
     * 
     * Use synchronized blocks with wait/notify to control the execution order. This is a classic
     * Java synchronization approach.
     * 
     * @param printFirst Runnable to print "first"
     * @param printSecond Runnable to print "second"
     * @param printThird Runnable to print "third"
     */
    public static class FooSynchronized {
        private final Object lock = new Object();
        private boolean firstFinished = false;
        private boolean secondFinished = false;

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                // printFirst() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstFinished = true;
                lock.notifyAll(); // Signal that first() is done
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!firstFinished) {
                    lock.wait(); // Wait for first() to complete
                }
                // printSecond() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinished = true;
                lock.notifyAll(); // Signal that second() is done
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (!secondFinished) {
                    lock.wait(); // Wait for second() to complete
                }
                // printThird() outputs "third". Do not change or remove this line.
                printThird.run();
            }
        }
    }

    /**
     * Approach 6: CompletableFuture
     * 
     * Use CompletableFuture to chain the execution order. This approach provides a functional
     * programming style for handling asynchronous operations.
     * 
     * @param printFirst Runnable to print "first"
     * @param printSecond Runnable to print "second"
     * @param printThird Runnable to print "third"
     */
    public static class FooCompletableFuture {
        private CompletableFuture<Void> firstFuture = new CompletableFuture<>();
        private CompletableFuture<Void> secondFuture = new CompletableFuture<>();

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFuture.complete(null); // Signal that first() is done
        }

        public void second(Runnable printSecond) throws InterruptedException {
            try {
                firstFuture.get(); // Wait for first() to complete
                // printSecond() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFuture.complete(null); // Signal that second() is done
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            try {
                secondFuture.get(); // Wait for second() to complete
                // printThird() outputs "third". Do not change or remove this line.
                printThird.run();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Utility class to test all approaches
     */
    public static class ThreadOrderTester {
        private final StringBuilder result = new StringBuilder();
        private final Object resultLock = new Object();

        public void printFirst() {
            synchronized (resultLock) {
                result.append("first");
            }
        }

        public void printSecond() {
            synchronized (resultLock) {
                result.append("second");
            }
        }

        public void printThird() {
            synchronized (resultLock) {
                result.append("third");
            }
        }

        public String getResult() {
            synchronized (resultLock) {
                return result.toString();
            }
        }

        public void reset() {
            synchronized (resultLock) {
                result.setLength(0);
            }
        }

        /**
         * Test a specific Foo implementation with given execution order
         * 
         * @param foo the Foo implementation to test
         * @param executionOrder array representing the order of method calls
         * @return the result string
         */
        public String testFoo(Object foo, int[] executionOrder) throws InterruptedException {
            reset();
            CountDownLatch startLatch = new CountDownLatch(1);
            CountDownLatch finishLatch = new CountDownLatch(3);

            // Create threads based on execution order
            Thread[] threads = new Thread[3];
            for (int i = 0; i < 3; i++) {
                final int methodIndex = executionOrder[i];
                threads[i] = new Thread(() -> {
                    try {
                        startLatch.await(); // Wait for all threads to be ready
                        switch (methodIndex) {
                            case 1:
                                if (foo instanceof FooSemaphore) {
                                    ((FooSemaphore) foo).first(this::printFirst);
                                } else if (foo instanceof FooCountDownLatch) {
                                    ((FooCountDownLatch) foo).first(this::printFirst);
                                } else if (foo instanceof FooReentrantLock) {
                                    ((FooReentrantLock) foo).first(this::printFirst);
                                } else if (foo instanceof FooAtomicInteger) {
                                    ((FooAtomicInteger) foo).first(this::printFirst);
                                } else if (foo instanceof FooSynchronized) {
                                    ((FooSynchronized) foo).first(this::printFirst);
                                } else if (foo instanceof FooCompletableFuture) {
                                    ((FooCompletableFuture) foo).first(this::printFirst);
                                }
                                break;
                            case 2:
                                if (foo instanceof FooSemaphore) {
                                    ((FooSemaphore) foo).second(this::printSecond);
                                } else if (foo instanceof FooCountDownLatch) {
                                    ((FooCountDownLatch) foo).second(this::printSecond);
                                } else if (foo instanceof FooReentrantLock) {
                                    ((FooReentrantLock) foo).second(this::printSecond);
                                } else if (foo instanceof FooAtomicInteger) {
                                    ((FooAtomicInteger) foo).second(this::printSecond);
                                } else if (foo instanceof FooSynchronized) {
                                    ((FooSynchronized) foo).second(this::printSecond);
                                } else if (foo instanceof FooCompletableFuture) {
                                    ((FooCompletableFuture) foo).second(this::printSecond);
                                }
                                break;
                            case 3:
                                if (foo instanceof FooSemaphore) {
                                    ((FooSemaphore) foo).third(this::printThird);
                                } else if (foo instanceof FooCountDownLatch) {
                                    ((FooCountDownLatch) foo).third(this::printThird);
                                } else if (foo instanceof FooReentrantLock) {
                                    ((FooReentrantLock) foo).third(this::printThird);
                                } else if (foo instanceof FooAtomicInteger) {
                                    ((FooAtomicInteger) foo).third(this::printThird);
                                } else if (foo instanceof FooSynchronized) {
                                    ((FooSynchronized) foo).third(this::printThird);
                                } else if (foo instanceof FooCompletableFuture) {
                                    ((FooCompletableFuture) foo).third(this::printThird);
                                }
                                break;
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        finishLatch.countDown();
                    }
                });
                threads[i].start();
            }

            startLatch.countDown(); // Start all threads
            finishLatch.await(); // Wait for all threads to complete

            return getResult();
        }
    }

    /**
     * Main method to demonstrate all approaches
     */
    public static void main(String[] args) {
        ThreadOrderTester tester = new ThreadOrderTester();

        // Test cases with different execution orders
        int[][] testCases = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

        System.out.println("Testing Print in Order Solutions:");
        System.out.println("=================================");

        for (int[] executionOrder : testCases) {
            System.out.println("\nExecution Order: " + java.util.Arrays.toString(executionOrder));
            System.out.println("Expected: firstsecondthird");

            try {
                // Test all approaches
                FooSemaphore foo1 = new FooSemaphore();
                FooCountDownLatch foo2 = new FooCountDownLatch();
                FooReentrantLock foo3 = new FooReentrantLock();
                FooAtomicInteger foo4 = new FooAtomicInteger();
                FooSynchronized foo5 = new FooSynchronized();
                FooCompletableFuture foo6 = new FooCompletableFuture();

                String result1 = tester.testFoo(foo1, executionOrder);
                String result2 = tester.testFoo(foo2, executionOrder);
                String result3 = tester.testFoo(foo3, executionOrder);
                String result4 = tester.testFoo(foo4, executionOrder);
                String result5 = tester.testFoo(foo5, executionOrder);
                String result6 = tester.testFoo(foo6, executionOrder);

                System.out.println("Semaphore: " + result1 + " "
                        + (result1.equals("firstsecondthird") ? "✓" : "✗"));
                System.out.println("CountDownLatch: " + result2 + " "
                        + (result2.equals("firstsecondthird") ? "✓" : "✗"));
                System.out.println("ReentrantLock: " + result3 + " "
                        + (result3.equals("firstsecondthird") ? "✓" : "✗"));
                System.out.println("AtomicInteger: " + result4 + " "
                        + (result4.equals("firstsecondthird") ? "✓" : "✗"));
                System.out.println("Synchronized: " + result5 + " "
                        + (result5.equals("firstsecondthird") ? "✓" : "✗"));
                System.out.println("CompletableFuture: " + result6 + " "
                        + (result6.equals("firstsecondthird") ? "✓" : "✗"));

            } catch (InterruptedException e) {
                System.err.println("Test interrupted: " + e.getMessage());
            }
        }

        // Performance analysis
        System.out.println("\n\nPerformance Analysis:");
        System.out.println("=====================");
        System.out.println("Approach 1 (Semaphore): O(1) time, O(1) space - RECOMMENDED");
        System.out.println("Approach 2 (CountDownLatch): O(1) time, O(1) space - CLEAN");
        System.out.println("Approach 3 (ReentrantLock): O(1) time, O(1) space - FINE-GRAINED");
        System.out.println("Approach 4 (AtomicInteger): O(1) time, O(1) space - LOW LATENCY");
        System.out.println("Approach 5 (Synchronized): O(1) time, O(1) space - CLASSIC");
        System.out.println("Approach 6 (CompletableFuture): O(1) time, O(1) space - FUNCTIONAL");

        System.out.println("\nKey Insights:");
        System.out.println("=============");
        System.out.println("• Thread synchronization is crucial for correct execution order");
        System.out.println("• Semaphores provide clean and intuitive synchronization");
        System.out.println("• CountDownLatch is perfect for one-time coordination");
        System.out.println("• ReentrantLock offers fine-grained control over synchronization");
        System.out.println("• AtomicInteger with busy wait provides lowest latency");
        System.out.println("• Synchronized blocks are the classic Java approach");
        System.out.println("• CompletableFuture enables functional programming style");
    }
}
