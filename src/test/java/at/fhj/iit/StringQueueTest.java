package at.fhj.iit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing StringQueue implementation")
class StringQueueTest {

    private StringQueue queue;
    private StringQueue emptyQueue;

    /**
     * Inits a StringQueue with a max size of 5 for the test.
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        queue = new StringQueue(3);
        emptyQueue = new StringQueue(3);

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
    public void testVolumeSetter() {
        assertEquals("first", queue.element());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emptyQueue.element();
        });

        String expectedMessage = "there's no element any more";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}