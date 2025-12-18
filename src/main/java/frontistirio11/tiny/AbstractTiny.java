package frontistirio11.tiny;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Based on slide "AbstractTiny".
 *
 * Holds common state (size + modCount) and implements Serializable.
 */
public abstract class AbstractTiny implements Serializable {

    protected int size;
    protected transient int modCount;

    public AbstractTiny() {
        size = 0;
        modCount = 0;
    }

    public int size() {
        return size;
    }

    public abstract Iterator iterator();
}
