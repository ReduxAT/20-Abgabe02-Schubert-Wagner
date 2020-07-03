package at.fhj.iit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the StringQueue
 * Methods testet:
 *  - (Constructor)
 *  - offer
 *  - remove
 *  - element
 * Methods 'peek' and 'poll' are not explicit tested because they are called by 'remove' and 'element'.
 *
 * @author Michael Schubert
 */

@DisplayName("Testing StringQueue implementation")
class StringQueueTest {

    private StringQueue queue;
    private StringQueue emptyQueue;

    /**
     * Inits a StringQueue with a max size of 3 and an empty StringQueue for the test.
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        queue = new StringQueue(3);
        emptyQueue = new StringQueue(3);

        queue.offer("first");
        queue.offer("second");
    }

    /**
     * Tests if the maximum sizes of both string queues got initiated correctly
     * by comparing it with the value 3.
     */
    @Test
    @DisplayName("Testing StringQueue constructor")
    public void testConstructor() {
        assertEquals(3, queue.getMaxSize());
        assertEquals(3, emptyQueue.getMaxSize());
    }

    /**
     * Tests if the method 'offer' adds strings to the queue correctly by adding the value "third"
     * and comparing the size of the queue.
     * In addition, it is tested if 'offer' return false if the queue is already full.
     */
    @Test
    @DisplayName("Testing method offer")
    public void testOffer() {
        assertEquals(2, queue.getElements().size());
        assertTrue(queue.offer("third"));
        assertFalse(queue.offer("fourth"));
        assertEquals(3, queue.getElements().size());
    }

    /**
     * Test if the method 'remove' works correctly by removing one element from the queue and comparing it
     * with the expected value "first". After that, it tests if the queue size got changed correctly.
     * The methods 'poll' and 'peek' are also getting tested, since 'remove' calls the method 'poll' and
     * 'poll' calls the method 'peek'.
     * This test also checks, if 'remove' returns a NoSuchElementException if the the queue is empty. The error-message
     * also gets compared.
     */
    @Test
    @DisplayName("Test method remove, poll and peek")
    public void testRemove() {
        assertEquals("first", queue.remove());
        assertEquals(1, queue.getElements().size());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emptyQueue.remove();
        });

        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Tests if the method 'element' returns the first element of the queue by comparing it with the
     * expected value "first".
     * This test also checks, if 'element' returns a NoSuchElementException if the the queue is empty. The error-message
     * also gets compared.
     * The method 'peek' gets tested too, since 'element' calls the method 'peek'.
     */
    @Test
    @DisplayName("Testing method element")
    public void testElement() {
        assertEquals("first", queue.element());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emptyQueue.element();
        });

        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}