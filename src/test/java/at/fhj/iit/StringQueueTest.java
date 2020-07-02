package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing StringQueue implementation")
class StringQueueTest {

    private StringQueue queue;

    /**
     * Inits a StringQueue with a max size of 5 for the test.
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        queue = new StringQueue(5);
    }


    }