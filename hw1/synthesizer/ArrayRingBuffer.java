package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.first = 0;
        this.last = 0;
        this.capacity = capacity;
        this.fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if(isFull())
            throw new RuntimeException("Ring Buffer Overflow");
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        rb[last] = x;
        last = (last + 1) % capacity;
        fillCount ++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if(isEmpty())
            throw new RuntimeException("Ring Buffer Underflow");
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        T res = rb[first];
        first = (first+1) %capacity;
        fillCount --;
        return res;
    }



    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("Ring Buffer Underflow");
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class KeyIterator implements Iterator {
        private int ptr;

        public KeyIterator(){
            ptr = first;
        }
        @Override
        public boolean hasNext() {
            return ptr!=last;
        }

        @Override
        public Object next() {
            ptr=ptr+1;
            return rb[ptr];
        }
    }
}
