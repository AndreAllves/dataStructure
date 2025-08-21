package heap;

public interface Heap<T extends Comparable<T>> {
    public abstract boolean isEmpty();
	public abstract void insert(T element);
	public abstract T extractRootElement();
	public T rootElement();
	public abstract T[] heapsort(T[] array);
	public abstract void buildHeap(T[] array);
	public abstract T[] toArray();
	public abstract int size();
}
