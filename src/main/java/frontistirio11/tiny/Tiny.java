package frontistirio11.tiny;

/**
 * Based on slide "The Tiny Interface".
 *
 * A tiny, linear collection where we add to the end and remove from the end.
 */
public interface Tiny {

    // Precondition: the collection is not full
    // Postcondition: obj is added to the end of the collection
    // Throws an IllegalStateException if the collection is full
    void add(Object obj);

    // Precondition: the collection is not empty
    // Postcondition: the last object is removed from the end of the collection and returned
    // Throws an IllegalStateException if the collection is empty
    Object removeLast();

    // Returns the number of objects currently in the collection
    int size();

    // Returns true if the collection is full or false otherwise
    boolean isFull();
}
