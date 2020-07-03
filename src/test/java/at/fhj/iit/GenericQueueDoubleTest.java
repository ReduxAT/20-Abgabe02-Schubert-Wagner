package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the GenericQueue with Doubles
 * Methods testet:
 *  - (Constructor)
 *  - offer
 *  - remove
 *  - element
 * Methods 'peek' and 'poll' are not explicit tested because they are getting implicitly called by 'remove'
 */

@DisplayName("Testing GenericQueue implementation")
public class GenericQueueDoubleTest {

    private GenericQueue<Double> queue;
    private GenericQueue<Double>  emptyQueue;

    /**
     * Inits a StringQueue with a max size of 5 for the test.
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        queue = new GenericQueue(3);
        emptyQueue = new GenericQueue(3);

        queue.offer(0.3);
        queue.offer(0.4);
    }

    @Test
    @DisplayName("Testing StringQueue constructor")
    public void testConstructor() {
        assertEquals(3, queue.getMaxSize());
        assertEquals(3, emptyQueue.getMaxSize());
    }

    @Test
    @DisplayName("Testing method offer")
    public void testOffer() {
        assertEquals(2, queue.getElements().size());
        assertTrue(queue.offer(0.5));
        assertFalse(queue.offer(0.6));
        assertEquals(3, queue.getElements().size());
    }

    @Test
    @DisplayName("Test method remove, poll and peek")
    public void testRemove() {
        assertEquals(0.3, queue.remove());
        assertEquals(1, queue.getElements().size());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emptyQueue.remove();
        });

        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing method element")
    public void testElement() {
        assertEquals(0.3, queue.element());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emptyQueue.element();
        });

        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
