package cz.mkalina.sortedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is a specialized LinkedList, which keeps values sorted.
 *
 * @param <T>
 */
public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    public SortedLinkedList() {
        super();
    }
    public SortedLinkedList(Collection<T> collection) {
        super(collection);
    }

    @Override
    public boolean add(T t) {
        Iterator<T> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (next.compareTo(t) > 0) {
                super.add(i, t);
                return true;
            }
            i++;
        }
        super.addLast(t);
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        c.forEach(this::add);
        return true;
    }

    // following methods does not make sense for list with fixed items order

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addFirst(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addLast(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }
}
