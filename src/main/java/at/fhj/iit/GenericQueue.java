package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * This class is mostly the same as StringQueue
 * but with generics so, you are able to create
 * a queue with every datatype.
 */

public class GenericQueue<T> implements IGenQueue<T> {
    private List<T> elements = new ArrayList<T>();
    private int maxSize = 5;

    /**
     * Constructor for Generic Queue, set custom maxSize of queue
     * @param maxsize
     * @author Dario Wagner
     */
    public GenericQueue(int maxsize) {
        maxSize = maxsize;
    }

    /**
     * This method allows you to add an element to the queue
     * @param obj
     * @return boolean
     * @author Dario Wagner
     */
    @Override
                    public boolean offer(T obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }

    /**
     * This method is to get the first element and remove it from the queue
     * @return T
     * @author Dario Wagner
     */
    @Override
    public T poll() {
        T element = peek();

        if (elements.size() > 0) {
            elements.remove(0);
        }

        return element;
    }

    /**
     * Get the first element and remove it, if the queue is empty, throw exception
     * @return T
     * @author Dario Wagner
     */
    @Override
    public T remove() {
        T element = poll();

        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    /**
     * Get first element
     * @return T
     * @author Dario Wagner
     */
    @Override
    public T peek() {
        T element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    /**
     * Get first element, throws exception if queue is empty
     * @return T
     * @author Dario Wagner
     */
    @Override
    public T element() {
        T element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    public List<T> getElements() {
        return elements;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
