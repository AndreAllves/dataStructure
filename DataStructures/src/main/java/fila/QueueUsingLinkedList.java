package fila;

import linkedList.RecursiveDoubleLinkedListImpl;

public class QueueUsingLinkedList<T> {
    private RecursiveDoubleLinkedListImpl<T> node;
    private int size;

    public QueueUsingLinkedList(int size){
        this.size = 0;
    }

    public boolean isFull(){
        return this.node.size() == this.size;
    }

    public void enqueue(T element) throws QueueOverflowException {
        if(this.isFull()){
            throw new QueueOverflowException();
        }
        
        if(element != null){
            this.node.insert(element);
        }
    }

    public T dequeue() throws QueueUnderflowException {
        T removed = null;
        if(!isEmpty()){
            throw new QueueUnderflowException();
        }

        removed = this.node.getNext().getData();
        this.node.removeFirst();
        return removed;
    }

    public T head() {
        return !isEmpty() ? this.node.getNext().getData() : null;
    }

    public boolean isEmpty() {
        return this.node.isEmpty();
    }

}
