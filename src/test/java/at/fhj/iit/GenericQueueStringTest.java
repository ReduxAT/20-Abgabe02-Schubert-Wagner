package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the GenericQueue with Strings
 * Methods testet:
 *  - (Constructor)
 *  - offer
 *  - remove
 *  - element
 * Methods 'peek' and 'poll' are not explicit tested because they are getting implicitly called by 'remove'
 */

@DisplayName("Testing GenericQueue implementation")
public class GenericQueueStringTest {

    private GenericQueue<String> queue;
    private GenericQueue<String>  emptyQueue;

    /**
     * Inits a StringQueue with a max size of 5 for the test.
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        queue = new GenericQueue(3);
        emptyQueue = new GenericQueue(3);

        queue.offer("first");
        queue.offer("second");
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
        assertTrue(queue.offer("third"));
        assertFalse(queue.offer("fourth"));
        assertEquals(3, queue.getElements().size());
    }

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
