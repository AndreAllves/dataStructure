package linkedList;

public interface DoubleLinkedList<T> extends LinkedList<T> {
    public void insert(T element);
    public void remove(T element);
    public void insertFirst(T element);
    public void removeFirst();
    public void removeLast();
}