package leetcode.medium.application;
import java.util.*;
/**
 * Created by lenovo on 2017/9/5.
 */
public class PeekingIterator implements Iterator<Integer> {

    Iterator iterator;
    Integer before = null;
    Integer after = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        after = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return after;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        before = after;
        if(iterator.hasNext()) after = (Integer)iterator.next();
        else after = null;
        return before;
    }

    @Override
    public boolean hasNext() {
        if(after == null) return false;
        return true;
    }
}