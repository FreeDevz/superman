package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive test suite for CustomersWhoNeverOrder
 * 
 * Tests all SQL and Java approaches with various scenarios: - Basic functionality tests with sample
 * data - Edge cases (no customers, no orders, all customers ordered) - Performance tests with large
 * datasets - Cross-validation between approaches - SQL query validation
 */
@DisplayName("Customers Who Never Order Tests")
public class CustomersWhoNeverOrderTest {

    @Nested
    @DisplayName("SQL NOT IN Approach Tests")
    class NotInApproachTests {

        @Test
        @DisplayName("Basic functionality test with sample data")
        void testBasicFunctionality() {
            CustomersWhoNeverOrder.NotInApproach approach =
                    new CustomersWhoNeverOrder.NotInApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();
            List<String> expected = CustomersWhoNeverOrder.TestData.getExpectedResult();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(expected.size(), result.size(), "Result size should match expected");
            assertTrue(CustomersWhoNeverOrder.validateResult(result, expected),
                    "Result should match expected");
        }

        @Test
        @DisplayName("Test with no customers")
        void testNoCustomers() {
            CustomersWhoNeverOrder.NotInApproach approach =
                    new CustomersWhoNeverOrder.NotInApproach();

            List<CustomersWhoNeverOrder.Customer> customers = Arrays.asList();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when no customers");
        }

        @Test
        @DisplayName("Test with no orders")
        void testNoOrders() {
            CustomersWhoNeverOrder.NotInApproach approach =
                    new CustomersWhoNeverOrder.NotInApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(customers.size(), result.size(),
                    "All customers should be returned when no orders exist");
            for (CustomersWhoNeverOrder.Customer customer : customers) {
                assertTrue(result.contains(customer.getName()),
                        "Customer " + customer.getName() + " should be in result");
            }
        }

        @Test
        @DisplayName("Test with all customers having orders")
        void testAllCustomersOrdered() {
            CustomersWhoNeverOrder.NotInApproach approach =
                    new CustomersWhoNeverOrder.NotInApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList(
                    new CustomersWhoNeverOrder.Order(1, 1), new CustomersWhoNeverOrder.Order(2, 2),
                    new CustomersWhoNeverOrder.Order(3, 3), new CustomersWhoNeverOrder.Order(4, 4));

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when all customers have orders");
        }

        @Test
        @DisplayName("Test SQL query generation")
        void testSqlQuery() {
            CustomersWhoNeverOrder.NotInApproach approach =
                    new CustomersWhoNeverOrder.NotInApproach();

            String sqlQuery = approach.getSqlQuery();

            assertTrue(sqlQuery.contains("SELECT"), "SQL query should contain SELECT");
            assertTrue(sqlQuery.contains("FROM Customers"),
                    "SQL query should contain FROM Customers");
            assertTrue(sqlQuery.contains("NOT IN"), "SQL query should contain NOT IN");
            assertTrue(sqlQuery.contains("CustomerId"), "SQL query should contain CustomerId");
        }
    }

    @Nested
    @DisplayName("SQL LEFT JOIN Approach Tests")
    class LeftJoinApproachTests {

        @Test
        @DisplayName("Basic functionality test with sample data")
        void testBasicFunctionality() {
            CustomersWhoNeverOrder.LeftJoinApproach approach =
                    new CustomersWhoNeverOrder.LeftJoinApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();
            List<String> expected = CustomersWhoNeverOrder.TestData.getExpectedResult();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(expected.size(), result.size(), "Result size should match expected");
            assertTrue(CustomersWhoNeverOrder.validateResult(result, expected),
                    "Result should match expected");
        }

        @Test
        @DisplayName("Test with no customers")
        void testNoCustomers() {
            CustomersWhoNeverOrder.LeftJoinApproach approach =
                    new CustomersWhoNeverOrder.LeftJoinApproach();

            List<CustomersWhoNeverOrder.Customer> customers = Arrays.asList();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when no customers");
        }

        @Test
        @DisplayName("Test with no orders")
        void testNoOrders() {
            CustomersWhoNeverOrder.LeftJoinApproach approach =
                    new CustomersWhoNeverOrder.LeftJoinApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(customers.size(), result.size(),
                    "All customers should be returned when no orders exist");
        }

        @Test
        @DisplayName("Test SQL query generation")
        void testSqlQuery() {
            CustomersWhoNeverOrder.LeftJoinApproach approach =
                    new CustomersWhoNeverOrder.LeftJoinApproach();

            String sqlQuery = approach.getSqlQuery();

            assertTrue(sqlQuery.contains("SELECT"), "SQL query should contain SELECT");
            assertTrue(sqlQuery.contains("LEFT JOIN"), "SQL query should contain LEFT JOIN");
            assertTrue(sqlQuery.contains("IS NULL"), "SQL query should contain IS NULL");
        }
    }

    @Nested
    @DisplayName("SQL NOT EXISTS Approach Tests")
    class NotExistsApproachTests {

        @Test
        @DisplayName("Basic functionality test with sample data")
        void testBasicFunctionality() {
            CustomersWhoNeverOrder.NotExistsApproach approach =
                    new CustomersWhoNeverOrder.NotExistsApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();
            List<String> expected = CustomersWhoNeverOrder.TestData.getExpectedResult();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(expected.size(), result.size(), "Result size should match expected");
            assertTrue(CustomersWhoNeverOrder.validateResult(result, expected),
                    "Result should match expected");
        }

        @Test
        @DisplayName("Test with no customers")
        void testNoCustomers() {
            CustomersWhoNeverOrder.NotExistsApproach approach =
                    new CustomersWhoNeverOrder.NotExistsApproach();

            List<CustomersWhoNeverOrder.Customer> customers = Arrays.asList();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when no customers");
        }

        @Test
        @DisplayName("Test with no orders")
        void testNoOrders() {
            CustomersWhoNeverOrder.NotExistsApproach approach =
                    new CustomersWhoNeverOrder.NotExistsApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(customers.size(), result.size(),
                    "All customers should be returned when no orders exist");
        }

        @Test
        @DisplayName("Test SQL query generation")
        void testSqlQuery() {
            CustomersWhoNeverOrder.NotExistsApproach approach =
                    new CustomersWhoNeverOrder.NotExistsApproach();

            String sqlQuery = approach.getSqlQuery();

            assertTrue(sqlQuery.contains("SELECT"), "SQL query should contain SELECT");
            assertTrue(sqlQuery.contains("NOT EXISTS"), "SQL query should contain NOT EXISTS");
            assertTrue(sqlQuery.contains("WHERE"), "SQL query should contain WHERE");
        }
    }

    @Nested
    @DisplayName("Java HashSet Approach Tests")
    class HashSetApproachTests {

        @Test
        @DisplayName("Basic functionality test with sample data")
        void testBasicFunctionality() {
            CustomersWhoNeverOrder.HashSetApproach approach =
                    new CustomersWhoNeverOrder.HashSetApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();
            List<String> expected = CustomersWhoNeverOrder.TestData.getExpectedResult();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(expected.size(), result.size(), "Result size should match expected");
            assertTrue(CustomersWhoNeverOrder.validateResult(result, expected),
                    "Result should match expected");
        }

        @Test
        @DisplayName("Test with no customers")
        void testNoCustomers() {
            CustomersWhoNeverOrder.HashSetApproach approach =
                    new CustomersWhoNeverOrder.HashSetApproach();

            List<CustomersWhoNeverOrder.Customer> customers = Arrays.asList();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when no customers");
        }

        @Test
        @DisplayName("Test with no orders")
        void testNoOrders() {
            CustomersWhoNeverOrder.HashSetApproach approach =
                    new CustomersWhoNeverOrder.HashSetApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(customers.size(), result.size(),
                    "All customers should be returned when no orders exist");
        }

        @Test
        @DisplayName("Test with duplicate orders")
        void testDuplicateOrders() {
            CustomersWhoNeverOrder.HashSetApproach approach =
                    new CustomersWhoNeverOrder.HashSetApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    Arrays.asList(new CustomersWhoNeverOrder.Customer(1, "Alice"),
                            new CustomersWhoNeverOrder.Customer(2, "Bob"));
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList(
                    new CustomersWhoNeverOrder.Order(1, 1), new CustomersWhoNeverOrder.Order(2, 1), // Duplicate
                                                                                                    // customer
                                                                                                    // ID
                    new CustomersWhoNeverOrder.Order(3, 1) // Another duplicate
            );

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(1, result.size(), "Only Bob should be returned");
            assertTrue(result.contains("Bob"), "Bob should be in result");
            assertTrue(!result.contains("Alice"), "Alice should not be in result");
        }
    }

    @Nested
    @DisplayName("Java Stream Approach Tests")
    class StreamApproachTests {

        @Test
        @DisplayName("Basic functionality test with sample data")
        void testBasicFunctionality() {
            CustomersWhoNeverOrder.StreamApproach approach =
                    new CustomersWhoNeverOrder.StreamApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();
            List<String> expected = CustomersWhoNeverOrder.TestData.getExpectedResult();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(expected.size(), result.size(), "Result size should match expected");
            assertTrue(CustomersWhoNeverOrder.validateResult(result, expected),
                    "Result should match expected");
        }

        @Test
        @DisplayName("Test with no customers")
        void testNoCustomers() {
            CustomersWhoNeverOrder.StreamApproach approach =
                    new CustomersWhoNeverOrder.StreamApproach();

            List<CustomersWhoNeverOrder.Customer> customers = Arrays.asList();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when no customers");
        }

        @Test
        @DisplayName("Test with no orders")
        void testNoOrders() {
            CustomersWhoNeverOrder.StreamApproach approach =
                    new CustomersWhoNeverOrder.StreamApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(customers.size(), result.size(),
                    "All customers should be returned when no orders exist");
        }
    }

    @Nested
    @DisplayName("Java Nested Loop Approach Tests")
    class NestedLoopApproachTests {

        @Test
        @DisplayName("Basic functionality test with sample data")
        void testBasicFunctionality() {
            CustomersWhoNeverOrder.NestedLoopApproach approach =
                    new CustomersWhoNeverOrder.NestedLoopApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();
            List<String> expected = CustomersWhoNeverOrder.TestData.getExpectedResult();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(expected.size(), result.size(), "Result size should match expected");
            assertTrue(CustomersWhoNeverOrder.validateResult(result, expected),
                    "Result should match expected");
        }

        @Test
        @DisplayName("Test with no customers")
        void testNoCustomers() {
            CustomersWhoNeverOrder.NestedLoopApproach approach =
                    new CustomersWhoNeverOrder.NestedLoopApproach();

            List<CustomersWhoNeverOrder.Customer> customers = Arrays.asList();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when no customers");
        }

        @Test
        @DisplayName("Test with no orders")
        void testNoOrders() {
            CustomersWhoNeverOrder.NestedLoopApproach approach =
                    new CustomersWhoNeverOrder.NestedLoopApproach();

            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList();

            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(customers.size(), result.size(),
                    "All customers should be returned when no orders exist");
        }
    }

    @Nested
    @DisplayName("Cross-Approach Comparison Tests")
    class CrossApproachComparisonTests {

        @Test
        @DisplayName("All approaches should produce same result with sample data")
        void testAllApproachesSameResult() {
            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getSampleCustomers();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getSampleOrders();

            // Test all approaches
            List<String> notInResult = new CustomersWhoNeverOrder.NotInApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> leftJoinResult = new CustomersWhoNeverOrder.LeftJoinApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> notExistsResult = new CustomersWhoNeverOrder.NotExistsApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> hashSetResult = new CustomersWhoNeverOrder.HashSetApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> streamResult = new CustomersWhoNeverOrder.StreamApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> nestedLoopResult = new CustomersWhoNeverOrder.NestedLoopApproach()
                    .findCustomersWhoNeverOrder(customers, orders);

            // All results should be the same
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, leftJoinResult),
                    "NOT IN and LEFT JOIN should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, notExistsResult),
                    "NOT IN and NOT EXISTS should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, hashSetResult),
                    "NOT IN and HashSet should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, streamResult),
                    "NOT IN and Stream should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, nestedLoopResult),
                    "NOT IN and Nested Loop should produce same result");
        }

        @Test
        @DisplayName("All approaches should produce same result with large data")
        void testAllApproachesSameResultLargeData() {
            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getLargeCustomerSet();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getLargeOrderSet();

            // Test all approaches
            List<String> notInResult = new CustomersWhoNeverOrder.NotInApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> leftJoinResult = new CustomersWhoNeverOrder.LeftJoinApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> notExistsResult = new CustomersWhoNeverOrder.NotExistsApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> hashSetResult = new CustomersWhoNeverOrder.HashSetApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> streamResult = new CustomersWhoNeverOrder.StreamApproach()
                    .findCustomersWhoNeverOrder(customers, orders);
            List<String> nestedLoopResult = new CustomersWhoNeverOrder.NestedLoopApproach()
                    .findCustomersWhoNeverOrder(customers, orders);

            // All results should be the same
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, leftJoinResult),
                    "NOT IN and LEFT JOIN should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, notExistsResult),
                    "NOT IN and NOT EXISTS should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, hashSetResult),
                    "NOT IN and HashSet should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, streamResult),
                    "NOT IN and Stream should produce same result");
            assertTrue(CustomersWhoNeverOrder.validateResult(notInResult, nestedLoopResult),
                    "NOT IN and Nested Loop should produce same result");
        }
    }

    @Nested
    @DisplayName("Edge Case Tests")
    class EdgeCaseTests {

        @Test
        @DisplayName("Test with single customer and single order")
        void testSingleCustomerSingleOrder() {
            List<CustomersWhoNeverOrder.Customer> customers =
                    Arrays.asList(new CustomersWhoNeverOrder.Customer(1, "Alice"));
            List<CustomersWhoNeverOrder.Order> orders =
                    Arrays.asList(new CustomersWhoNeverOrder.Order(1, 1));

            CustomersWhoNeverOrder.HashSetApproach approach =
                    new CustomersWhoNeverOrder.HashSetApproach();
            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertTrue(result.isEmpty(), "Result should be empty when customer has order");
        }

        @Test
        @DisplayName("Test with single customer and no orders")
        void testSingleCustomerNoOrders() {
            List<CustomersWhoNeverOrder.Customer> customers =
                    Arrays.asList(new CustomersWhoNeverOrder.Customer(1, "Alice"));
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList();

            CustomersWhoNeverOrder.HashSetApproach approach =
                    new CustomersWhoNeverOrder.HashSetApproach();
            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(1, result.size(), "Result should contain one customer");
            assertTrue(result.contains("Alice"), "Alice should be in result");
        }

        @Test
        @DisplayName("Test with customers having multiple orders")
        void testCustomersWithMultipleOrders() {
            List<CustomersWhoNeverOrder.Customer> customers =
                    Arrays.asList(new CustomersWhoNeverOrder.Customer(1, "Alice"),
                            new CustomersWhoNeverOrder.Customer(2, "Bob"),
                            new CustomersWhoNeverOrder.Customer(3, "Charlie"));
            List<CustomersWhoNeverOrder.Order> orders = Arrays.asList(
                    new CustomersWhoNeverOrder.Order(1, 1), new CustomersWhoNeverOrder.Order(2, 1), // Alice
                                                                                                    // has
                                                                                                    // multiple
                                                                                                    // orders
                    new CustomersWhoNeverOrder.Order(3, 2) // Bob has one order
            );

            CustomersWhoNeverOrder.HashSetApproach approach =
                    new CustomersWhoNeverOrder.HashSetApproach();
            List<String> result = approach.findCustomersWhoNeverOrder(customers, orders);

            assertEquals(1, result.size(), "Only Charlie should be returned");
            assertTrue(result.contains("Charlie"), "Charlie should be in result");
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Performance comparison between approaches")
        void testPerformanceComparison() {
            List<CustomersWhoNeverOrder.Customer> customers =
                    CustomersWhoNeverOrder.TestData.getLargeCustomerSet();
            List<CustomersWhoNeverOrder.Order> orders =
                    CustomersWhoNeverOrder.TestData.getLargeOrderSet();

            // Test HashSet approach (should be fastest)
            long startTime = System.nanoTime();
            new CustomersWhoNeverOrder.HashSetApproach().findCustomersWhoNeverOrder(customers,
                    orders);
            long hashSetTime = System.nanoTime() - startTime;

            // Test Stream approach
            startTime = System.nanoTime();
            new CustomersWhoNeverOrder.StreamApproach().findCustomersWhoNeverOrder(customers,
                    orders);
            long streamTime = System.nanoTime() - startTime;

            // Test Nested Loop approach (should be slowest)
            startTime = System.nanoTime();
            new CustomersWhoNeverOrder.NestedLoopApproach().findCustomersWhoNeverOrder(customers,
                    orders);
            long nestedLoopTime = System.nanoTime() - startTime;

            System.out.println("Performance Results:");
            System.out.println("HashSet: " + (hashSetTime / 1_000_000) + "ms");
            System.out.println("Stream: " + (streamTime / 1_000_000) + "ms");
            System.out.println("Nested Loop: " + (nestedLoopTime / 1_000_000) + "ms");

            // HashSet should be faster than nested loop
            assertTrue(hashSetTime < nestedLoopTime,
                    "HashSet approach should be faster than nested loop");
        }
    }

    @Nested
    @DisplayName("Data Structure Tests")
    class DataStructureTests {

        @Test
        @DisplayName("Test Customer class")
        void testCustomerClass() {
            CustomersWhoNeverOrder.Customer customer1 =
                    new CustomersWhoNeverOrder.Customer(1, "Alice");
            CustomersWhoNeverOrder.Customer customer2 =
                    new CustomersWhoNeverOrder.Customer(1, "Alice");
            CustomersWhoNeverOrder.Customer customer3 =
                    new CustomersWhoNeverOrder.Customer(2, "Bob");

            assertEquals(1, customer1.getId());
            assertEquals("Alice", customer1.getName());
            assertEquals(customer1, customer2);
            assertTrue(!customer1.equals(customer3));
            assertEquals(customer1.hashCode(), customer2.hashCode());
        }

        @Test
        @DisplayName("Test Order class")
        void testOrderClass() {
            CustomersWhoNeverOrder.Order order1 = new CustomersWhoNeverOrder.Order(1, 1);
            CustomersWhoNeverOrder.Order order2 = new CustomersWhoNeverOrder.Order(1, 1);
            CustomersWhoNeverOrder.Order order3 = new CustomersWhoNeverOrder.Order(2, 1);

            assertEquals(1, order1.getId());
            assertEquals(1, order1.getCustomerId());
            assertEquals(order1, order2);
            assertTrue(!order1.equals(order3));
            assertEquals(order1.hashCode(), order2.hashCode());
        }
    }
}
