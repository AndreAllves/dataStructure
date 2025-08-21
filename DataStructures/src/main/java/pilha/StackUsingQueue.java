package pilha;

import fila.Queue;
import fila.QueueImpl;
import fila.QueueOverflowException;
import fila.QueueUnderflowException;

public class StackUsingQueue<T> implements Stack<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackUsingQueue(int size){
        this.queue1 = new QueueImpl<>(size);
        this.queue2 = new QueueImpl<>(size);
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if(isFull()){
            throw new StackOverflowException();
        }
        try {
            if(element != null){
                this.queue1.enqueue(element);
            }
        } 
        catch (QueueOverflowException e) {
            throw new StackOverflowException();
        }
    }

    @Override
    public T pop() throws StackUnderflowException {
       if(isEmpty()){
        throw new StackUnderflowException();
       }
       try {
        return this.queue1.dequeue();
       }
       catch (QueueUnderflowException e) {
        throw new StackUnderflowException();
       }
    }


    @Override
    public T top() {
        return !isEmpty() ? this.queue1.head() : null;
    }

    @Override
    public boolean isEmpty() {
      return this.queue1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.queue1.isFull();
    }

}
