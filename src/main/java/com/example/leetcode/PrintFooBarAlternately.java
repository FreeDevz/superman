package com.example.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LeetCode 1115. Print FooBar Alternately
 * 
 * Problem Description: Suppose you are given the following code:
 * 
 * class FooBar { public void foo() { for (int i = 0; i < n; i++) { print("foo"); } }
 * 
 * public void bar() { for (int i = 0; i < n; i++) { print("bar"); } } }
 * 
 * The same instance of FooBar will be passed to two different threads: - thread A will call foo(),
 * while - thread B will call bar().
 * 
 * Modify the given program to output "foobarfoobar..." n times.
 * 
 * Example 1: Input: n = 1 Output: "foobar" Explanation: There are two threads being fired
 * asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1
 * time.
 * 
 * Example 2: Input: n = 2 Output: "foobarfoobar" Explanation: "foobar" is being output 2 times.
 * 
 * Constraints: - 1 <= n <= 1000
 * 
 * Approach Analysis: 1. Semaphore Approach: Use two semaphores to control execution order 2. Atomic
 * Integer Approach: Use atomic counter with modulo operation 3. ReentrantLock Approach: Use locks
 * with conditions for synchronization 4. Synchronized Block Approach: Use synchronized blocks with
 * wait/notify
 * 
 * Time Complexity: O(n) - Each method runs n times Space Complexity: O(1) - Constant space for
 * synchronization primitives
 */
public class PrintFooBarAlternately {

    /**
     * Approach 1: Semaphore-based synchronization
     * 
     * Uses two semaphores to control the execution order: - fooSemaphore: Allows foo() to execute
     * (initially 1) - barSemaphore: Allows bar() to execute (initially 0)
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public static class SemaphoreApproach {
        private final int n;
        private final Semaphore fooSemaphore;
        private final Semaphore barSemaphore;

        public SemaphoreApproach(int n) {
            this.n = n;
            this.fooSemaphore = new Semaphore(1); // foo can start immediately
            this.barSemaphore = new Semaphore(0); // bar must wait
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire(); // Wait for permission to print foo
                printFoo.run();
                barSemaphore.release(); // Allow bar to print
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barSemaphore.acquire(); // Wait for permission to print bar
                printBar.run();
                fooSemaphore.release(); // Allow foo to print next
            }
        }
    }

    /**
     * Approach 2: Atomic Integer with modulo operation
     * 
     * Uses an atomic counter to track the current turn: - Even numbers (0, 2, 4, ...) allow foo to
     * print - Odd numbers (1, 3, 5, ...) allow bar to print
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public static class AtomicIntegerApproach {
        private final int n;
        private final AtomicInteger turn;

        public AtomicIntegerApproach(int n) {
            this.n = n;
            this.turn = new AtomicInteger(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (turn.get() % 2 != 0) {
                    Thread.yield(); // Wait for our turn
                }
                printFoo.run();
                turn.incrementAndGet();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (turn.get() % 2 != 1) {
                    Thread.yield(); // Wait for our turn
                }
                printBar.run();
                turn.incrementAndGet();
            }
        }
    }

    /**
     * Approach 3: ReentrantLock with Condition
     * 
     * Uses a lock with two conditions to coordinate between threads: - fooCondition: Signaled when
     * foo should print - barCondition: Signaled when bar should print
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public static class ReentrantLockApproach {
        private final int n;
        private final ReentrantLock lock;
        private final Condition fooCondition;
        private final Condition barCondition;
        private boolean isFooTurn;

        public ReentrantLockApproach(int n) {
            this.n = n;
            this.lock = new ReentrantLock();
            this.fooCondition = lock.newCondition();
            this.barCondition = lock.newCondition();
            this.isFooTurn = true; // foo starts first
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (!isFooTurn) {
                        fooCondition.await();
                    }
                    printFoo.run();
                    isFooTurn = false;
                    barCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (isFooTurn) {
                        barCondition.await();
                    }
                    printBar.run();
                    isFooTurn = true;
                    fooCondition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * Approach 4: Synchronized blocks with wait/notify
     * 
     * Uses synchronized blocks with wait/notify mechanism: - Shared lock object for synchronization
     * - Boolean flag to track whose turn it is
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public static class SynchronizedApproach {
        private final int n;
        private final Object lock;
        private boolean isFooTurn;

        public SynchronizedApproach(int n) {
            this.n = n;
            this.lock = new Object();
            this.isFooTurn = true; // foo starts first
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (!isFooTurn) {
                        lock.wait();
                    }
                    printFoo.run();
                    isFooTurn = false;
                    lock.notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (isFooTurn) {
                        lock.wait();
                    }
                    printBar.run();
                    isFooTurn = true;
                    lock.notify();
                }
            }
        }
    }

    /**
     * Approach 5: Volatile boolean with busy waiting
     * 
     * Uses volatile boolean flag for coordination: - Simple but less efficient due to busy waiting
     * - Good for understanding basic thread coordination
     * 
     * Time Complexity: O(n) Space Complexity: O(1)
     */
    public static class VolatileBooleanApproach {
        private final int n;
        private volatile boolean isFooTurn;

        public VolatileBooleanApproach(int n) {
            this.n = n;
            this.isFooTurn = true; // foo starts first
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!isFooTurn) {
                    Thread.yield(); // Busy wait
                }
                printFoo.run();
                isFooTurn = false;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (isFooTurn) {
                    Thread.yield(); // Busy wait
                }
                printBar.run();
                isFooTurn = true;
            }
        }
    }

    /**
     * Helper method to create a simple print function
     */
    public static Runnable createPrintFunction(String text) {
        return () -> System.out.print(text);
    }

    /**
     * Helper method to run a test with given approach
     */
    public static void runTest(String approachName, int n) {
        System.out.println("\n=== Testing " + approachName + " with n=" + n + " ===");

        try {
            switch (approachName) {
                case "Semaphore":
                    testSemaphoreApproach(n);
                    break;
                case "AtomicInteger":
                    testAtomicIntegerApproach(n);
                    break;
                case "ReentrantLock":
                    testReentrantLockApproach(n);
                    break;
                case "Synchronized":
                    testSynchronizedApproach(n);
                    break;
                case "VolatileBoolean":
                    testVolatileBooleanApproach(n);
                    break;
                default:
                    System.out.println("Unknown approach: " + approachName);
            }
        } catch (Exception e) {
            System.err.println("Error in " + approachName + ": " + e.getMessage());
        }
    }

    private static void testSemaphoreApproach(int n) throws InterruptedException {
        SemaphoreApproach foobar = new SemaphoreApproach(n);
        StringBuilder output = new StringBuilder();

        Thread fooThread = new Thread(() -> {
            try {
                foobar.foo(() -> output.append("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                foobar.bar(() -> output.append("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        fooThread.start();
        barThread.start();
        fooThread.join();
        barThread.join();

        System.out.println("Output: " + output.toString());
        System.out.println("Expected: " + "foobar".repeat(n));
        System.out.println("Correct: " + output.toString().equals("foobar".repeat(n)));
    }

    private static void testAtomicIntegerApproach(int n) throws InterruptedException {
        AtomicIntegerApproach foobar = new AtomicIntegerApproach(n);
        StringBuilder output = new StringBuilder();

        Thread fooThread = new Thread(() -> {
            try {
                foobar.foo(() -> output.append("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                foobar.bar(() -> output.append("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        fooThread.start();
        barThread.start();
        fooThread.join();
        barThread.join();

        System.out.println("Output: " + output.toString());
        System.out.println("Expected: " + "foobar".repeat(n));
        System.out.println("Correct: " + output.toString().equals("foobar".repeat(n)));
    }

    private static void testReentrantLockApproach(int n) throws InterruptedException {
        ReentrantLockApproach foobar = new ReentrantLockApproach(n);
        StringBuilder output = new StringBuilder();

        Thread fooThread = new Thread(() -> {
            try {
                foobar.foo(() -> output.append("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                foobar.bar(() -> output.append("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        fooThread.start();
        barThread.start();
        fooThread.join();
        barThread.join();

        System.out.println("Output: " + output.toString());
        System.out.println("Expected: " + "foobar".repeat(n));
        System.out.println("Correct: " + output.toString().equals("foobar".repeat(n)));
    }

    private static void testSynchronizedApproach(int n) throws InterruptedException {
        SynchronizedApproach foobar = new SynchronizedApproach(n);
        StringBuilder output = new StringBuilder();

        Thread fooThread = new Thread(() -> {
            try {
                foobar.foo(() -> output.append("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                foobar.bar(() -> output.append("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        fooThread.start();
        barThread.start();
        fooThread.join();
        barThread.join();

        System.out.println("Output: " + output.toString());
        System.out.println("Expected: " + "foobar".repeat(n));
        System.out.println("Correct: " + output.toString().equals("foobar".repeat(n)));
    }

    private static void testVolatileBooleanApproach(int n) throws InterruptedException {
        VolatileBooleanApproach foobar = new VolatileBooleanApproach(n);
        StringBuilder output = new StringBuilder();

        Thread fooThread = new Thread(() -> {
            try {
                foobar.foo(() -> output.append("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                foobar.bar(() -> output.append("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        fooThread.start();
        barThread.start();
        fooThread.join();
        barThread.join();

        System.out.println("Output: " + output.toString());
        System.out.println("Expected: " + "foobar".repeat(n));
        System.out.println("Correct: " + output.toString().equals("foobar".repeat(n)));
    }

    /**
     * Main method for testing all approaches
     */
    public static void main(String[] args) {
        System.out.println("Print FooBar Alternately - Multiple Approaches Demo");
        System.out.println("==================================================");

        int[] testCases = {1, 2, 3, 5};
        String[] approaches =
                {"Semaphore", "AtomicInteger", "ReentrantLock", "Synchronized", "VolatileBoolean"};

        for (int n : testCases) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("Testing with n = " + n);
            System.out.println("=".repeat(50));

            for (String approach : approaches) {
                runTest(approach, n);
            }
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Performance Comparison");
        System.out.println("=".repeat(50));

        // Performance test with larger n
        int performanceN = 100;
        long startTime, endTime;

        for (String approach : approaches) {
            startTime = System.currentTimeMillis();
            try {
                runTest(approach, performanceN);
            } catch (Exception e) {
                System.err
                        .println("Performance test failed for " + approach + ": " + e.getMessage());
            }
            endTime = System.currentTimeMillis();
            System.out.println(approach + " approach took: " + (endTime - startTime) + "ms");
        }
    }
}
