package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation

    private SortedIntList list;
    private int totalAdded;

    public DelegationSortedIntList() {
        list = new SortedIntList(); 
        totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        totalAdded++;
        return list.add(num);
    }

    @Override
    public boolean addAll(IntegerList other) {
        boolean changed = false;

        for (int i = 0; i < other.size(); i++) {
            totalAdded++; 
            changed |= list.add(other.get(i));
        }

        return changed;
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public boolean remove(int num) {
        return list.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList other) {
        return list.removeAll(other);
    }

    @Override
    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}