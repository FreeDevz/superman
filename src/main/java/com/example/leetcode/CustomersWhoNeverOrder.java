package com.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode 183. Customers Who Never Order
 * 
 * Problem Description: Suppose that a website contains two tables, the Customers table and the
 * Orders table. Write a SQL query to find all customers who never order anything.
 * 
 * Table: Customers +----+-------+ | Id | Name | +----+-------+ | 1 | Joe | | 2 | Henry | | 3 | Sam
 * | | 4 | Max | +----+-------+
 * 
 * Table: Orders +----+------------+ | Id | CustomerId | +----+------------+ | 1 | 3 | | 2 | 1 |
 * +----+------------+
 * 
 * Using the above tables as example, return the following: +-----------+ | Customers |
 * +-----------+ | Henry | | Max | +-----------+
 * 
 * Constraints: None specified
 * 
 * Approach Analysis: 1. SQL NOT IN Approach: Use NOT IN subquery to find customers not in orders 2.
 * SQL LEFT JOIN Approach: Use LEFT JOIN with IS NULL to find unmatched customers 3. SQL NOT EXISTS
 * Approach: Use NOT EXISTS subquery for better performance 4. Java HashSet Approach: Simulate
 * database operations using HashSet 5. Java Stream Approach: Use Java 8 streams for functional
 * programming style 6. Java Nested Loop Approach: Traditional nested loop comparison
 * 
 * Time Complexity: O(n + m) where n = customers, m = orders Space Complexity: O(m) for storing
 * order customer IDs
 */
public class CustomersWhoNeverOrder {

    // Data structures to represent the database tables
    public static class Customer {
        private final int id;
        private final String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Customer{id=" + id + ", name='" + name + "'}";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Customer customer = (Customer) obj;
            return id == customer.id && Objects.equals(name, customer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Order {
        private final int id;
        private final int customerId;

        public Order(int id, int customerId) {
            this.id = id;
            this.customerId = customerId;
        }

        public int getId() {
            return id;
        }

        public int getCustomerId() {
            return customerId;
        }

        @Override
        public String toString() {
            return "Order{id=" + id + ", customerId=" + customerId + "}";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Order order = (Order) obj;
            return id == order.id && customerId == order.customerId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, customerId);
        }
    }

    /**
     * Approach 1: SQL NOT IN Approach
     * 
     * SQL Query: SELECT Name AS Customers FROM Customers WHERE Id NOT IN (SELECT CustomerId FROM
     * Orders);
     * 
     * Java Implementation: Simulate the NOT IN logic using HashSet
     * 
     * Time Complexity: O(n + m) Space Complexity: O(m)
     */
    public static class NotInApproach {
        public List<String> findCustomersWhoNeverOrder(List<Customer> customers,
                List<Order> orders) {
            // Create a set of customer IDs who have placed orders
            Set<Integer> customerIdsWithOrders =
                    orders.stream().map(Order::getCustomerId).collect(Collectors.toSet());

            // Find customers whose ID is NOT IN the set of customers with orders
            return customers.stream()
                    .filter(customer -> !customerIdsWithOrders.contains(customer.getId()))
                    .map(Customer::getName).collect(Collectors.toList());
        }

        public String getSqlQuery() {
            return "SELECT Name AS Customers\n" + "FROM Customers\n"
                    + "WHERE Id NOT IN (SELECT CustomerId FROM Orders);";
        }
    }

    /**
     * Approach 2: SQL LEFT JOIN Approach
     * 
     * SQL Query: SELECT C.Name AS Customers FROM Customers C LEFT JOIN Orders O ON C.Id =
     * O.CustomerId WHERE O.CustomerId IS NULL;
     * 
     * Java Implementation: Simulate LEFT JOIN using HashMap
     * 
     * Time Complexity: O(n + m) Space Complexity: O(m)
     */
    public static class LeftJoinApproach {
        public List<String> findCustomersWhoNeverOrder(List<Customer> customers,
                List<Order> orders) {
            // Create a map of customer ID to order count
            Map<Integer, Integer> customerOrderCount = new HashMap<>();

            // Count orders for each customer
            for (Order order : orders) {
                customerOrderCount.merge(order.getCustomerId(), 1, Integer::sum);
            }

            // Find customers with no orders (LEFT JOIN with IS NULL)
            return customers.stream()
                    .filter(customer -> !customerOrderCount.containsKey(customer.getId()))
                    .map(Customer::getName).collect(Collectors.toList());
        }

        public String getSqlQuery() {
            return "SELECT C.Name AS Customers\n" + "FROM Customers C\n"
                    + "LEFT JOIN Orders O ON C.Id = O.CustomerId\n" + "WHERE O.CustomerId IS NULL;";
        }
    }

    /**
     * Approach 3: SQL NOT EXISTS Approach
     * 
     * SQL Query: SELECT Name AS Customers FROM Customers C WHERE NOT EXISTS ( SELECT 1 FROM Orders
     * O WHERE O.CustomerId = C.Id );
     * 
     * Java Implementation: Simulate NOT EXISTS using nested loops
     * 
     * Time Complexity: O(n * m) Space Complexity: O(1)
     */
    public static class NotExistsApproach {
        public List<String> findCustomersWhoNeverOrder(List<Customer> customers,
                List<Order> orders) {
            List<String> result = new ArrayList<>();

            for (Customer customer : customers) {
                boolean hasOrder = false;
                // Check if customer has any order (NOT EXISTS logic)
                for (Order order : orders) {
                    if (order.getCustomerId() == customer.getId()) {
                        hasOrder = true;
                        break;
                    }
                }
                if (!hasOrder) {
                    result.add(customer.getName());
                }
            }

            return result;
        }

        public String getSqlQuery() {
            return "SELECT Name AS Customers\n" + "FROM Customers C\n" + "WHERE NOT EXISTS (\n"
                    + "    SELECT 1\n" + "    FROM Orders O\n" + "    WHERE O.CustomerId = C.Id\n"
                    + ");";
        }
    }

    /**
     * Approach 4: Java HashSet Approach (Optimized)
     * 
     * Uses HashSet for O(1) lookup time, making it the most efficient Java approach
     * 
     * Time Complexity: O(n + m) Space Complexity: O(m)
     */
    public static class HashSetApproach {
        public List<String> findCustomersWhoNeverOrder(List<Customer> customers,
                List<Order> orders) {
            // Create HashSet for O(1) lookup
            Set<Integer> customerIdsWithOrders = new HashSet<>();
            for (Order order : orders) {
                customerIdsWithOrders.add(order.getCustomerId());
            }

            // Find customers who never ordered
            List<String> result = new ArrayList<>();
            for (Customer customer : customers) {
                if (!customerIdsWithOrders.contains(customer.getId())) {
                    result.add(customer.getName());
                }
            }

            return result;
        }
    }

    /**
     * Approach 5: Java Stream Approach (Functional Programming)
     * 
     * Uses Java 8 streams for a functional programming approach
     * 
     * Time Complexity: O(n + m) Space Complexity: O(m)
     */
    public static class StreamApproach {
        public List<String> findCustomersWhoNeverOrder(List<Customer> customers,
                List<Order> orders) {
            Set<Integer> customerIdsWithOrders =
                    orders.stream().map(Order::getCustomerId).collect(Collectors.toSet());

            return customers.stream()
                    .filter(customer -> !customerIdsWithOrders.contains(customer.getId()))
                    .map(Customer::getName).collect(Collectors.toList());
        }
    }

    /**
     * Approach 6: Java Nested Loop Approach (Brute Force)
     * 
     * Traditional nested loop approach for educational purposes
     * 
     * Time Complexity: O(n * m) Space Complexity: O(1)
     */
    public static class NestedLoopApproach {
        public List<String> findCustomersWhoNeverOrder(List<Customer> customers,
                List<Order> orders) {
            List<String> result = new ArrayList<>();

            for (Customer customer : customers) {
                boolean foundOrder = false;
                for (Order order : orders) {
                    if (order.getCustomerId() == customer.getId()) {
                        foundOrder = true;
                        break;
                    }
                }
                if (!foundOrder) {
                    result.add(customer.getName());
                }
            }

            return result;
        }
    }

    /**
     * Helper method to create sample data for testing
     */
    public static class TestData {
        public static List<Customer> getSampleCustomers() {
            return Arrays.asList(new Customer(1, "Joe"), new Customer(2, "Henry"),
                    new Customer(3, "Sam"), new Customer(4, "Max"));
        }

        public static List<Order> getSampleOrders() {
            return Arrays.asList(new Order(1, 3), // Sam ordered
                    new Order(2, 1) // Joe ordered
            );
        }

        public static List<String> getExpectedResult() {
            return Arrays.asList("Henry", "Max");
        }

        public static List<Customer> getLargeCustomerSet() {
            List<Customer> customers = new ArrayList<>();
            for (int i = 1; i <= 1000; i++) {
                customers.add(new Customer(i, "Customer" + i));
            }
            return customers;
        }

        public static List<Order> getLargeOrderSet() {
            List<Order> orders = new ArrayList<>();
            // Only customers with even IDs have orders
            for (int i = 1; i <= 500; i++) {
                orders.add(new Order(i, i * 2));
            }
            return orders;
        }

        public static List<String> getLargeExpectedResult() {
            List<String> result = new ArrayList<>();
            // Customers with odd IDs never ordered
            for (int i = 1; i <= 1000; i += 2) {
                result.add("Customer" + i);
            }
            return result;
        }
    }

    /**
     * Helper method to run a test with given approach
     */
    public static void runTest(String approachName, Object approach, List<Customer> customers,
            List<Order> orders) {
        System.out.println("\n=== Testing " + approachName + " ===");

        try {
            List<String> result;
            long startTime = System.nanoTime();

            if (approach instanceof NotInApproach) {
                result = ((NotInApproach) approach).findCustomersWhoNeverOrder(customers, orders);
                System.out.println("SQL Query:");
                System.out.println(((NotInApproach) approach).getSqlQuery());
            } else if (approach instanceof LeftJoinApproach) {
                result = ((LeftJoinApproach) approach).findCustomersWhoNeverOrder(customers,
                        orders);
                System.out.println("SQL Query:");
                System.out.println(((LeftJoinApproach) approach).getSqlQuery());
            } else if (approach instanceof NotExistsApproach) {
                result = ((NotExistsApproach) approach).findCustomersWhoNeverOrder(customers,
                        orders);
                System.out.println("SQL Query:");
                System.out.println(((NotExistsApproach) approach).getSqlQuery());
            } else if (approach instanceof HashSetApproach) {
                result = ((HashSetApproach) approach).findCustomersWhoNeverOrder(customers, orders);
            } else if (approach instanceof StreamApproach) {
                result = ((StreamApproach) approach).findCustomersWhoNeverOrder(customers, orders);
            } else if (approach instanceof NestedLoopApproach) {
                result = ((NestedLoopApproach) approach).findCustomersWhoNeverOrder(customers,
                        orders);
            } else {
                throw new IllegalArgumentException("Unknown approach: " + approachName);
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            System.out.println("Result: " + result);
            System.out.println("Execution time: " + duration + "ms");

        } catch (Exception e) {
            System.err.println("Error in " + approachName + ": " + e.getMessage());
        }
    }

    /**
     * Helper method to validate results
     */
    public static boolean validateResult(List<String> actual, List<String> expected) {
        if (actual.size() != expected.size()) {
            return false;
        }

        Set<String> actualSet = new HashSet<>(actual);
        Set<String> expectedSet = new HashSet<>(expected);

        return actualSet.equals(expectedSet);
    }

    /**
     * Main method for testing all approaches
     */
    public static void main(String[] args) {
        System.out.println("Customers Who Never Order - Multiple Approaches Demo");
        System.out.println("====================================================");

        // Test with sample data
        List<Customer> customers = TestData.getSampleCustomers();
        List<Order> orders = TestData.getSampleOrders();
        List<String> expected = TestData.getExpectedResult();

        System.out.println("\nSample Data:");
        System.out.println("Customers: " + customers);
        System.out.println("Orders: " + orders);
        System.out.println("Expected Result: " + expected);

        // Test all approaches
        String[] approachNames = {"SQL NOT IN", "SQL LEFT JOIN", "SQL NOT EXISTS", "Java HashSet",
                "Java Stream", "Java Nested Loop"};

        Object[] approaches = {new NotInApproach(), new LeftJoinApproach(), new NotExistsApproach(),
                new HashSetApproach(), new StreamApproach(), new NestedLoopApproach()};

        for (int i = 0; i < approachNames.length; i++) {
            runTest(approachNames[i], approaches[i], customers, orders);
        }

        // Performance test with larger data
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Performance Test with Large Data");
        System.out.println("=".repeat(60));

        List<Customer> largeCustomers = TestData.getLargeCustomerSet();
        List<Order> largeOrders = TestData.getLargeOrderSet();
        List<String> largeExpected = TestData.getLargeExpectedResult();

        System.out.println("Large Data Set:");
        System.out.println("Customers: " + largeCustomers.size());
        System.out.println("Orders: " + largeOrders.size());
        System.out.println("Expected customers who never ordered: " + largeExpected.size());

        for (int i = 0; i < approachNames.length; i++) {
            runTest(approachNames[i], approaches[i], largeCustomers, largeOrders);
        }

        // Cross-validation test
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Cross-Validation Test");
        System.out.println("=".repeat(60));

        List<List<String>> allResults = new ArrayList<>();
        for (Object approach : approaches) {
            List<String> result;
            if (approach instanceof NotInApproach) {
                result = ((NotInApproach) approach).findCustomersWhoNeverOrder(customers, orders);
            } else if (approach instanceof LeftJoinApproach) {
                result = ((LeftJoinApproach) approach).findCustomersWhoNeverOrder(customers,
                        orders);
            } else if (approach instanceof NotExistsApproach) {
                result = ((NotExistsApproach) approach).findCustomersWhoNeverOrder(customers,
                        orders);
            } else if (approach instanceof HashSetApproach) {
                result = ((HashSetApproach) approach).findCustomersWhoNeverOrder(customers, orders);
            } else if (approach instanceof StreamApproach) {
                result = ((StreamApproach) approach).findCustomersWhoNeverOrder(customers, orders);
            } else if (approach instanceof NestedLoopApproach) {
                result = ((NestedLoopApproach) approach).findCustomersWhoNeverOrder(customers,
                        orders);
            } else {
                continue;
            }
            allResults.add(result);
        }

        // Check if all results are the same
        boolean allSame = true;
        for (int i = 1; i < allResults.size(); i++) {
            if (!validateResult(allResults.get(0), allResults.get(i))) {
                allSame = false;
                break;
            }
        }

        System.out.println("All approaches produce same result: " + allSame);
        System.out
                .println("Result matches expected: " + validateResult(allResults.get(0), expected));
    }
}
