package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link DesignSnakeGame}.
 */
public class DesignSnakeGameTest {

    private static final int[][] SAMPLE_FOOD = {{1, 2}, {0, 1}};

    @Nested
    class DequeApproach {
        private DesignSnakeGame.SnakeGameDeque game;

        @BeforeEach
        void setUp() {
            game = new DesignSnakeGame.SnakeGameDeque(3, 2, SAMPLE_FOOD);
        }

        @Test
        void followsLeetCodeExample() {
            assertEquals(0, game.move(DesignSnakeGame.Direction.RIGHT));
            assertEquals(0, game.move(DesignSnakeGame.Direction.DOWN));
            assertEquals(1, game.move(DesignSnakeGame.Direction.RIGHT));
            assertEquals(1, game.move(DesignSnakeGame.Direction.UP));
            assertEquals(2, game.move(DesignSnakeGame.Direction.LEFT));
            assertEquals(-1, game.move(DesignSnakeGame.Direction.UP));
            assertTrue(game.isGameOver());
        }

        @Test
        void allowsReenteringTailPosition() {
            game.move(DesignSnakeGame.Direction.RIGHT);
            game.move(DesignSnakeGame.Direction.DOWN);
            game.move(DesignSnakeGame.Direction.RIGHT); // eats food, length=2
            assertEquals(1, game.score());
            assertEquals(1, game.move(DesignSnakeGame.Direction.LEFT)); // tail moved, safe
            assertFalse(game.isGameOver());
        }

        @Test
        void detectsSelfCollision() {
            DesignSnakeGame.SnakeGameDeque snake =
                    new DesignSnakeGame.SnakeGameDeque(4, 4, new int[][] {{0, 1}, {0, 2}, {1, 2}});
            snake.move(DesignSnakeGame.Direction.RIGHT); // length 2
            snake.move(DesignSnakeGame.Direction.RIGHT); // length 3
            snake.move(DesignSnakeGame.Direction.DOWN); // length 4
            assertEquals(-1, snake.move(DesignSnakeGame.Direction.UP)); // collide with body
            assertTrue(snake.isGameOver());
        }

        @Test
        void repeatedMoveAfterGameOverReturnsMinusOne() {
            assertEquals(0, game.move(DesignSnakeGame.Direction.RIGHT));
            assertEquals(-1, game.move(DesignSnakeGame.Direction.UP)); // hit wall
            assertEquals(-1, game.move(DesignSnakeGame.Direction.LEFT));
        }

        @Test
        void snapshotReturnsHeadToTailOrder() {
            game.move(DesignSnakeGame.Direction.RIGHT);
            game.move(DesignSnakeGame.Direction.DOWN);
            game.move(DesignSnakeGame.Direction.RIGHT); // eats
            List<int[]> body = game.snapshot();
            assertEquals(2, body.size());
            assertArrayEquals(new int[] {1, 2}, body.get(0));
            assertArrayEquals(new int[] {1, 1}, body.get(1));
        }
    }

    @Nested
    class LinkedListApproach {
        private DesignSnakeGame.SnakeGameLinkedList game;

        @BeforeEach
        void setUp() {
            game = new DesignSnakeGame.SnakeGameLinkedList(3, 2, SAMPLE_FOOD);
        }

        @Test
        void followsLeetCodeExample() {
            assertEquals(0, game.move(DesignSnakeGame.Direction.RIGHT));
            assertEquals(0, game.move(DesignSnakeGame.Direction.DOWN));
            assertEquals(1, game.move(DesignSnakeGame.Direction.RIGHT));
            assertEquals(1, game.move(DesignSnakeGame.Direction.UP));
            assertEquals(2, game.move(DesignSnakeGame.Direction.LEFT));
            assertEquals(-1, game.move(DesignSnakeGame.Direction.UP));
            assertTrue(game.isGameOver());
        }

        @Test
        void detectsSelfCollision() {
            DesignSnakeGame.SnakeGameLinkedList snake = new DesignSnakeGame.SnakeGameLinkedList(4,
                    4, new int[][] {{0, 1}, {0, 2}, {1, 2}, {1, 1}});
            snake.move(DesignSnakeGame.Direction.RIGHT);
            snake.move(DesignSnakeGame.Direction.RIGHT);
            snake.move(DesignSnakeGame.Direction.DOWN);
            assertEquals(-1, snake.move(DesignSnakeGame.Direction.UP));
            assertTrue(snake.isGameOver());
        }
    }

    @Nested
    class Validation {

        @Test
        void validateDimensionsRejectsInvalidSizes() {
            assertThrows(IllegalArgumentException.class,
                    () -> DesignSnakeGame.validateDimensions(0, 5));
            assertThrows(IllegalArgumentException.class,
                    () -> DesignSnakeGame.validateDimensions(5, 0));
            assertThrows(IllegalArgumentException.class,
                    () -> DesignSnakeGame.validateDimensions(20_000, 2));
        }

        @Test
        void validateFoodRejectsOutOfBounds() {
            int[][] food = {{1, 0}, {2, 2}};
            assertThrows(IllegalArgumentException.class,
                    () -> DesignSnakeGame.validateFood(2, 2, food));
        }

        @Test
        void validateFoodRejectsInvalidShape() {
            assertThrows(IllegalArgumentException.class,
                    () -> DesignSnakeGame.validateFood(3, 3, new int[][] {{1}}));
        }

        @Test
        void directionParsingIsCaseInsensitive() {
            assertEquals(DesignSnakeGame.Direction.UP, DesignSnakeGame.Direction.fromString("u"));
            assertEquals(DesignSnakeGame.Direction.LEFT, DesignSnakeGame.Direction.fromChar('l'));
        }

        @Test
        void directionParsingRejectsInvalidInput() {
            assertThrows(IllegalArgumentException.class,
                    () -> DesignSnakeGame.Direction.fromString("LEFT"));
            assertThrows(IllegalArgumentException.class,
                    () -> DesignSnakeGame.Direction.fromChar('X'));
        }

        @Test
        void constructorValidatesInputs() {
            int[][] food = {{0, 0}};
            assertThrows(IllegalArgumentException.class,
                    () -> new DesignSnakeGame.SnakeGameDeque(0, 1, food));
            assertThrows(IllegalArgumentException.class,
                    () -> new DesignSnakeGame.SnakeGameLinkedList(2, 2, new int[][] {{2, 0}}));
        }

        @Test
        void validateFoodAcceptsProperInput() {
            assertDoesNotThrow(() -> DesignSnakeGame.validateFood(3, 3, new int[][] {{1, 1}}));
        }
    }

    private static void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(expected[0], actual[0], "Row mismatch");
        assertEquals(expected[1], actual[1], "Column mismatch");
    }
}


